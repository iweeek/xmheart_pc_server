var ue = UE.getEditor('container');
//对编辑器的操作最好在编辑器ready之后再做
ue.ready(function () {
    //设置编辑器的内容
    ue.setContent('');
    //获取html内容，返回: <p>hello</p>
    var html = ue.getContent();
    //获取纯文本内容，返回: hello
    var txt = ue.getContentTxt();
});

$(function () {
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
        //获取url中的参数
        getUrlParam: function (name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
            var r = window.location.search.substr(1).match(reg);  //匹配目标参数
            if (r != null) return unescape(r[2]); return null; //返回参数值
        },
        init: function () {
            console.log(111, ctrl.getUrlParam('articleId'));
            $.get('/xmheart_pc_server/columns', function (result) {
                console.log('columns:', result);
            });
        }
    }
    ctrl.init();

    // 标题二级选项的出现
    $('.select-title-first').change(function () {
        if ($(this).val() !== 0) {
            $('.select-title-second').show()
        }
    })
    // 摘要的字数
    var wordCount = $("#wordCount"), 
        digest = wordCount.find("textArea"), 
        word = wordCount.find(".word");
    ctrl.statInputNum(digest, word);

    var category1 = $('.select-title-first'), 
        category2 = $('.select-title-second'), 
        title = $('.article-title'), 
        tags = $('.tag-input'), 
        contentHtml, 
        contentText;
    // 需要发布的内容
    $('#publish').on('click', function () {
        // 编辑器内容
        contentHtml = ue.getContent();
        var params = {
            columnId: category2.find('option:selected').val(),
            title: title.val(),
            content: contentHtml,
            tags: tags.val(),
            brief: digest.val()
        }
        $.post('/xmheart_pc_server/articles', params, function (result) {
            console.log(result);
        });
    });

    // 舍弃
    $('#reset').on('click', function () {
        ue.setContent('');
        $('.select-title-second').hide()
    });

    // 摘要的字数
    var wordCount = $("#wordCount"), textArea = wordCount
        .find("textArea"), word = wordCount.find(".word");
    ctrl.statInputNum(textArea, word);
})