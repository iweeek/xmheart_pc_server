$(function () {
    var ue = UE.getEditor('container');
    var title = $('.article-title');
    var digest = $("#wordCount").find("textArea");
    var word = $("#wordCount").find(".word");
    var tags = $('.tag-input');
    var category1 = $('.select-title-first');
    var category2 = $('.select-title-second');
    var article = {};
    var ctrl = {
        //获取url中的参数
        getUrlParam: function (name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
            var r = window.location.search.substr(1).match(reg);  //匹配目标参数
            if (r != null) return unescape(r[2]); return null; //返回参数值
        },
        statInputNum: function (digest, numItem) {
            var max = numItem.text(), curLength;

            digest[0].setAttribute("maxlength", max);
            curLength = digest.val().length;
            numItem.text(max - curLength);
            digest.on('input propertychange', function () {
                numItem.text(max - $(this).val().length);
            });
        },
        getArticle: function (articleId) {
            var url = '/articles/' + articleId;
            $.get(url, function (res) {
                article = res;
                title.val(res.title);
                tags.val(res.tags);
                digest.val(res.brief.slice(0,200));
                ctrl.statInputNum(digest, word);
                $('.category').show();
                $('.category-edit').text(res.columnName);
                // $('.category-create').hide();
                //对编辑器的操作最好在编辑器ready之后再做
                ue.ready(function () {
                    //设置编辑器的内容
                    ue.setContent(res.content);
                });

            });
        },
        publish: function () {
            // 编辑器内容 ue.getContent()获取html内容，返回: <p>hello</p>  ue.getContentTxt()获取纯文本内容，返回: hello
            var brief = digest.val() ? digest.val() : ue.getContentTxt().slice(0,200) 
            var publishTime = $('[data-toggle="datepicker"]').datepicker('getDate')
            var params = {
                columnId: category2.find('option:selected').val(),
                title: title.val(),
                content: ue.getContent(),
                tags: tags.val(),
                brief: brief,
                isPublished: true,
                publishTime: publishTime
            };
            
            if (!ctrl.valid(params, 'publish')) {
                return;
            }

            // 编辑模式
            var articleId = ctrl.getUrlParam('articleId');
            if (articleId) {
                if (category2.find('option:selected').val()) {
                    params.columnId = category2.find('option:selected').val();
                }

                var url = '/articles/' + articleId;
                $.post(url, params, function (res) {
                    swal({
                        title: "发表成功",
                        text: "返回上一页？",
                        type: "success",
                        showCancelButton: true,
                        confirmButtonColor: "#8cd4f5",
                        confirmButtonText: "返回上一页",
                        cancelButtonText: "留在本页",
                        closeOnConfirm: false
                    }, function () {
                        window.history.go(-1);
                    });
                }).error(function() { sweetAlert("哎呀", "服务器开小差了~请稍后再试", "error"); });;

                return;
            }

            $.post('/articles', params, function (res) {
                swal({
                    title: "新建文章成功",
                    type: "success",
                    showCancelButton: true,
                    confirmButtonColor: "#8cd4f5",
                    confirmButtonText: "返回上一页",
                    cancelButtonText: "取消",
                    closeOnConfirm: false
                }, function () {
                    ctrl.cancel();
                });
                // window.history.go(-1);
            }).error(function() { sweetAlert("哎呀", "服务器开小差了~请稍后再试", "error"); });
        },
        save: function () {
            // 保存(提交请求但isPublished为false)
        		var brief = digest.val() ? digest.val() : ue.getContentTxt().slice(0,200) 
        		var publishTime = $('[data-toggle="datepicker"]').datepicker('getDate')
            var params = {
                columnId: category2.find('option:selected').val(),
                title: title.val(),
                content: ue.getContent(),
                tags: tags.val(),
                brief: brief,
                isPublished: false,
                publishTime: publishTime
            };

            if (!ctrl.valid(params)) {
                return;
            }
            
            // 编辑模式
            var articleId = ctrl.getUrlParam('articleId');
            if (articleId) {
                if (category2.find('option:selected').val()) {
                    params.columnId = category2.find('option:selected').val();
                }
                var url = '/articles/' + articleId;
                $.post(url, params, function (res) {
                    swal({
                        title: "保存成功",
                        type: "success",
                        showCancelButton: true,
                        confirmButtonColor: "#8cd4f5",
                        confirmButtonText: "发表文章",
                        cancelButtonText: "取消",
                        closeOnConfirm: false
                    }, function () {
                        ctrl.publish();
                    });
                }).error(function() { sweetAlert("哎呀", "服务器开小差了~请稍后再试", "error"); });

                return;
            }

            $.post('/articles', params, function (res) {
                swal({
                    title: "新建文章成功",
                    type: "success",
                    showCancelButton: true,
                    confirmButtonColor: "#8cd4f5",
                    confirmButtonText: "返回上一页",
                    cancelButtonText: "取消",
                    closeOnConfirm: false
                }, function () {
                    ctrl.cancel();
                });
            }).error(function() { sweetAlert("哎呀", "服务器开小差了~请稍后再试", "error"); });
        },
        valid: function (params, type) {
            var articleId = ctrl.getUrlParam('articleId');
            
            if (!params.columnId && !articleId) {
                sweetAlert("信息不完整", "请填写分类", "error");
                return false;
            }
            if(!params.title) {
                sweetAlert("信息不完整", "请填写标题", "error");
                return false;
            }

            if (type === 'publish') {
                if (!params.content) {
                    sweetAlert("信息不完整", "请填写内容", "error");
                    return false;
                }
                if (!params.tags) {
                    sweetAlert("信息不完整", "请填写标签", "error");
                    return false;
                }
            }
            
            return true;
        },
        preview: function () {
            $('#preview-panel').html(ue.getContent());
        },
        cancel: function () {
            // 取消(直接返回上一级，不做接口交互)
            window.history.go(-1);
        },
        reset: function () {
            ue.setContent('');
            $('.select-title-second').hide();
            $("#wordCount").find(".word").html('200');
        },
        getColumn: function (parentColumnId, htmlId) {
            $.get('/columns', {
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
        init: function () {
            var articleId = ctrl.getUrlParam('articleId');
            ctrl.statInputNum(digest, word);
            // 编辑模式
            if (articleId) {
                ctrl.getArticle(articleId);
            }
            ctrl.getColumn(0, '#J_select_first');
        },
        initDate: function() {
        		$('[data-toggle="datepicker"]').datepicker({
        		    language: 'zh-CN',
        		    format: 'yyyy-mm-dd'
        		 });
        }
    }
    ctrl.init();
    ctrl.initDate();
    // 二级分类的出现
    $('.select-title-first').change(function () {
        var firstId = $(this).val();
        if (firstId !== 0) {
            $('.select-title-second').show();
            ctrl.getColumn(firstId, '#J_select_second');
        }
    });
   
    $('#publish').on('click', ctrl.publish);
    $('#reset').on('click', ctrl.reset);
    $('#save').on('click', ctrl.save)
    $('#preview').on('click', ctrl.preview);
    $('#cancel').on('click', ctrl.cancel);

})