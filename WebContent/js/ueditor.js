$(function () {
    var ue = UE.getEditor('container');
    var title = $('.article-title');
    var digest = $("#wordCount").find("textArea");
    var word = $("#wordCount").find(".word");
    var tags = $('.tag-input');
    var category1 = $('.select-title-first');
    var category2 = $('.select-title-second');
    
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
            var url = '/xmheart_pc_server/articles/' + articleId;
            $.get(url, function (res) {
                console.log('article:', res);
                title.val(res.title);
                tags.val(res.tags);
                digest.val(res.brief);
                ctrl.statInputNum(digest, word);
                //对编辑器的操作最好在编辑器ready之后再做
                ue.ready(function () {
                    //设置编辑器的内容
                    ue.setContent(res.content);
                });

            });
        },
        publish: function () {
            // 编辑器内容 ue.getContent()获取html内容，返回: <p>hello</p>  ue.getContentTxt()获取纯文本内容，返回: hello
            var params = {
                columnId: category2.find('option:selected').val(),
                title: title.val(),
                content: ue.getContent(),
                tags: tags.val(),
                brief: digest.val()
            };
            console.log('publish:', params)
            $.post('/xmheart_pc_server/articles', params, function (result) {
                console.log(result);
            });
        },
        reset: function () {
            ue.setContent('');
            $('.select-title-second').hide();
            $("#wordCount").find(".word").html('200');
        },
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
        init: function () {

            ctrl.statInputNum(digest, word);
            var articleId = ctrl.getUrlParam('articleId')
            if (articleId) {
                ctrl.getArticle(articleId);
            }
            ctrl.getColumn(0, '#J_select_first');
        }
    }
    ctrl.init();

    // 二级分类的出现
    $('.select-title-first').change(function () {
        var firstId = $(this).val();
        if (firstId !== 0) {
            $('.select-title-second').show();
            ctrl.getColumn(firstId, '#J_select_second');
        }
    });

    // 需要发布的内容
    $('#publish').on('click', ctrl.publish);

    // 舍弃
    $('#reset').on('click', ctrl.reset);

})