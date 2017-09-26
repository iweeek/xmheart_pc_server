$(function () {
    var ctrl = {
        columnId: 0,
        groups: [],
        noNextPage: false,
        getColumns: function (parentColumnId) {
            $('.ui-loading').show();
            var loading = true;
            $.get('/xmheart_pc_server/columns', {
                parentColumnId: parentColumnId
            }, function (data) {
                ctrl.groups = data;
                if (data.length < ctrl.pageSize) {
                    ctrl.noNextPage = true;
                }
                var template = $('#J_groups_tmpl').html();
                var views = '';
                var groups = { result: data };
                views = Mustache.render(template, groups)
                $('#J_groups').html(views);
                $('.ui-loading').hide();
            });
        },
        edit: function (id, name) {
            swal({
                title: '修改一级栏目',
                text: name,
                type: 'input',
                showCancelButton: true, 
                closeOnConfirm: false, 
                animation: "slide-from-top", 
                inputPlaceholder: "输入新栏目名称" 
            }, function (inputValue) {
                console.log(inputValue);
                if (inputValue === '') {
                    swal.showInputError('你需要输入新的栏目名称！');
                    return false
                }
                // TODO: 提交修改请求
                swal('修改成功！', '你已将一级栏目：' + name + '的名称修改为' + inputValue, 'success');
            });
        },
        init: function () {
            ctrl.getColumns(ctrl.columnId);
        }
    }
    ctrl.init();

    // 编辑
    $('#J_groups').on('click', '.edit-btn', function () {
        var id = this.getAttribute('data-id');
        var name = this.getAttribute('data-name');
        ctrl.edit(id, name);
    });
})