$(function () {
    var ctrl = {
        columnId: 0,
        articles: [],
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
                var template = $('#J_articles_tmpl').html();
                var templateOffline = $('#J_articles_tmpl_offline').html();
                var views = '';
                data.forEach(function (tr) {
                    var article = { result: tr };
                    if (tr.isPublished) {
                        views += Mustache.render(templateOffline, article)
                    } else {
                        views += Mustache.render(template, article)
                    }
                });
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
    $('.select-title-first').change(function () {
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