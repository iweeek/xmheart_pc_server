$(function () {
    var ctrl = {
        columnId: '',
        articles: [],
        pageNo: 1,
        pageTotal: 0,
        noNextPage: false,
        getColumn: function (parentColumnId, htmlId) {
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
        getArticles: function (pageNo, pageSize, columnId) {
            $('.ui-loading').show();
            var loading = true;
            $.get('/xmheart_pc_server/articles', {
                pageNo: pageNo,
                pageSize: pageSize,
                columnId: columnId
            }, function (data) {
                ctrl.articles = data;
                if (data.length < ctrl.pageSize) {
                    ctrl.noNextPage = true;
                }
                var users = { result: data };
                var template = $('#J_articles_tmpl').html();
                Mustache.parse(template);   // optional, speeds up future uses
                var views = Mustache.render(template, users);
                $("#J_articles").html(views);
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
                swal("发布成功！")
            });
        },
        previous: function () {
            if (ctrl.pageNo > 1) {
                ctrl.pageNo--;
                ctrl.getArticles(ctrl.pageNo, 10, 0);
            }
        },
        next: function () {
            if (!ctrl.noNextPage) {
                ctrl.pageNo++;
                ctrl.getArticles(ctrl.pageNo, 10, 0);
            }
        },
        init: function () {
            this.getColumn(0, '#J_select_first');
            ctrl.getArticles(ctrl.pageNo, 10, 0);
        }
    }
    ctrl.init();

    // 二级分类的出现
    $('.select-title-first').change(function () {
        var firstId = $(this).val();
        if (firstId === '请选择') {
            $('.select-title-second').hide();
        }

        if (firstId !== 0 && firstId !== '请选择') {
            $('.select-title-second').show();
            ctrl.getColumn(firstId, '#J_select_second');
        }
    });

    // 获取二级分类的id
    $('.select-title-second').change(function () {
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

    // 新建
    $('#J_create_btn').on('click', function () {
        location.href = '/xmheart_pc_server/static/ueditor.html';
    })
})