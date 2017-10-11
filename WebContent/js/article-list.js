$(function () {
    var ctrl = {
        columnId: 0,
        pageNo: 1,
        pageTotal: 0,
        noNextPage: false,
        getColumns: function (parentColumnId, htmlId) {
            $.get('/xmheart_pc_server/columns', {
                parentColumnId: parentColumnId
            }, function (data) {
                var optionString = '';
                for (var i in data) {
                    var jsonObj = data[i];
                    optionString += "<option value=\"" + jsonObj.id + "\" >" + jsonObj.columnName + "</option>";
                    $(htmlId).html("<option value='请选择'>请选择</option> " + optionString);
                }
            });
        },
        dateFilter: function (date, formatString) {
        		if (!date) return '';
          	var date = new Date(date);

          	formatString = formatString || 'yyyy-MM-dd';

          	var dateMap = {
          		year: date.getFullYear(),
          		month: date.getMonth() + 1,
          		day: date.getDate(),
          		hour: date.getHours(),
          		minutes: date.getMinutes(),
          		seconds: date.getSeconds()
          	};

          	for (var key in dateMap) {
          		var value = dateMap[key];
          		value = value < 10 ? '0' + value : value;
          		dateMap[key] = value.toString();
          	}

          	var year = dateMap.year,
          	    month = dateMap.month,
          	    day = dateMap.day,
          	    hour = dateMap.hour,
          	    minutes = dateMap.minutes,
          	    seconds = dateMap.seconds;

          	var formatDate = formatString.replace(/y+/, function ($0) {
          		return year.substring(year.length, -$0.length);
          	}).replace(/M+/, function () {
          		return month;
          	}).replace(/d+/, function () {
          		return day;
          	}).replace(/H+/, function () {
          		return hour;
          	}).replace(/h+/, function () {
          		return hour % 12 === 0 ? 12 : hour % 12;
          	}).replace(/m+/, function () {
          		return minutes;
          	}).replace(/s+/, function () {
          		return seconds;
          	});
          	return formatDate;
        },
        getArticles: function (pageNo, pageSize, columnId) {
            $('.ui-loading').show();
            var loading = true;
            $.get('/xmheart_pc_server/articles', {
                pageNo: pageNo,
                pageSize: pageSize,
                columnId: columnId
            }, function (data) {
                if (data.length < ctrl.pageSize) {
                    ctrl.noNextPage = true;
                }
                $.each(data, function(name, val){
	  	    	   	  val.publishTime = ctrl.dateFilter(val.publishTime)
	  	    	    })
                var template = $('#J_articles_tmpl').html();
                Mustache.parse(template);  
                var rendered = Mustache.render(template, {result: data});
                $("#J_articles").html(rendered);
                $('.ui-loading').hide();
            });
        },
        publish: function (articleId) {
            var params = {
                isPublished: true
            };
            // 编辑模式
            var url = '/xmheart_pc_server/articles/' + articleId;
            $.post(url, params, function (res) {
                swal("发布成功！");
                ctrl.getArticles(ctrl.pageNo, 10, ctrl.columnId);
            });
        },
        offline: function (articleId) {
            var params = {
                isPublished: false
            };
            // 编辑模式
            var url = '/xmheart_pc_server/articles/' + articleId;
            $.post(url, params, function (res) {
                swal("下线成功！");
                ctrl.getArticles(ctrl.pageNo, 10, ctrl.columnId);
            });
        },
        previous: function () {
            if (ctrl.pageNo > 1) {
                ctrl.pageNo--;
                ctrl.getArticles(ctrl.pageNo, 10, ctrl.columnId);
            }
        },
        next: function () {
            if (!ctrl.noNextPage) {
                ctrl.pageNo++;
                ctrl.getArticles(ctrl.pageNo, 10, ctrl.columnId);
            }
        },
        init: function () {
            this.getColumns(0, '#J_select_first');
            ctrl.getArticles(ctrl.pageNo, 10, ctrl.columnId);
        }
    }
    ctrl.init();

    // 二级分类的出现
    $('#J_select_first').change(function () {
        var firstId = $(this).val();
        if (firstId === '请选择') {
            $('.select-title-second').hide();
        }

        if (firstId !== 0 && firstId !== '请选择') {
            $('.select-title-second').show();
            ctrl.getColumns(firstId, '#J_select_second');
        }
    });

    // 获取二级分类的id
    $('#J_select_second').change(function () {
        ctrl.columnId = $(this).val();
    });

    // 筛选
    $('#J_filter_btn').on('click', function () {
        ctrl.getArticles(1, 10, ctrl.columnId);
    });

    // 上一页
    $('.previous').on('click', ctrl.previous);

    // 下一页
    $('.next').on('click', ctrl.next);

    // 编辑
    $('#J_articles').on('click', '.edit-btn', function () {
        var articleId = this.getAttribute('data');
        location.href = '/xmheart_pc_server/static/ueditor.html?articleId=' + articleId;
    });

    // 发布
    $('#J_articles').on('click', '.publish-btn', function () {
        var articleId = this.getAttribute('data');
        ctrl.publish(articleId);
    });

    // 下线
    $('#J_articles').on('click', '.offline-btn', function () {
        var articleId = this.getAttribute('data');
        ctrl.offline(articleId);
    })

    // 新建
    $('#J_create_btn').on('click', function () {
        location.href = '/xmheart_pc_server/static/ueditor.html';
    })
})