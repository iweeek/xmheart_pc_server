$(function () {
    var ctrl = {
        columnId: 0,
        getColumns: function (parentColumnId, htmlId) {
            $.get('/xmheart_pc_server/columns', {
                parentColumnId: parentColumnId
            }, function (data) {
                if (parentColumnId === 0) {
                    var optionString = '';
                    for (var i in data) {
                        var jsonObj = data[i];
                        optionString += "<option value=\"" + jsonObj.id + "\" >" + jsonObj.columnName + "</option>";
                        $(htmlId).html("<option value='请选择'>请选择</option> " + optionString);
                    }
                    
                    $('.ui-nodata').show();
                    $('.ui-loading').hide();
                    return;
                }
                var template = $('#J_classify_tmpl').html();
                var views = '';
                var classify = { result: data };
                if (data.length === 0) {
                    $('.ui-nodata').show();
                    $('#J_classify').html('');
                } else {
                    views = Mustache.render(template, classify)
                    $('#J_classify').html(views);
                }
                $('.ui-loading').hide();
            });
        },
        edit: function (id, name) {
            swal({
                title: '修改二级栏目',
                text: name,
                type: 'input',
                showCancelButton: true,
                closeOnConfirm: false,
                animation: "slide-from-top",
                inputPlaceholder: "输入新栏目名称"
            }, function (inputValue) {
                if (inputValue === '') {
                    swal.showInputError('你需要输入新的栏目名称！');
                    return false
                }
                // TODO: 提交修改请求
                swal('修改成功！', '你已将二级栏目：' + name + '的名称修改为' + inputValue, 'success');
            });
        },
        init: function () {
            $('.ui-loading').show();
            $('.ui-nodata').hide();
            
            this.getColumns(0, '#J_select_first');
        }
    }
    ctrl.init();

    // 二级分类的出现
    $('#J_select_first').change(function () {
        var firstId = $(this).val();

        if (firstId !== 0 && firstId !== '请选择') {
            $('.ui-loading').show();
            $('.ui-nodata').hide();
            
            ctrl.getColumns(firstId);
        }
    });

    // 编辑
    $('#J_classify').on('click', '.edit-btn', function () {
        var id = this.getAttribute('data-id');
        var name = this.getAttribute('data-name');
        ctrl.edit(id, name);
    });
})