exports = this;
exports.XPW = exports.EDIT || {};
exports.XPW.RoleUeditor = (function() {
  function RoleUeditor () {
    // 初始化页面处理。
  	RoleUeditor.getRoleInfo()
  	RoleUeditor.postRoleInfo()
	RoleUeditor.cancel();
  }

  RoleUeditor._getUrlParam = function (name) {
      var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
      var r = window.location.search.substr(1).match(reg);  //匹配目标参数
      if (r != null) return unescape(r[2]); return null; //返回参数值
  }
  
  RoleUeditor.fillData = function (data) {
	  $('#roleName').val(data.name);
  }
  
  RoleUeditor.getRoleInfo = function () {
    var id = RoleUeditor._getUrlParam('roleId');
    
    if (id) {
	    $.ajax({
	  	  url: '/roles/' + id,
	        type: 'GET',
	        dataType: 'json',
	        data: {id: id}
	      })
	     .done(function(data) {
	    	 	RoleUeditor.fillData(data);
	     })
     }
  }
 
  RoleUeditor.postRoleInfo = function () {
	  var id = RoleUeditor._getUrlParam('roleId');
	  var url = id ? '/roles/' + id : '/roles'
	  $('.btn-group').on('click', '#save', function() {
		  var $this = $(this);
		  $this.attr('disabled','disabled');
		  var name = $('#roleName').val();
//		  Fixed  暂时写死 测试
		  var privIds = [2, 3];
//		  $('.user-limit input:checked').each(function(){
//			  privIds.push($(this).val());//向数组中添加元素
//		  });
		  if (!name) {
			  swal("名称不能为空");
			  $this.removeAttr('disabled');
			  return false;
		  }
		  if (privIds.length < 1) {
			  swal("权限不能为空");
			  $this.removeAttr('disabled');
			  return false;
		  }
		  var upateParms = {id: id, name: name, privIds: privIds};
		  var newParms = {name: name, privIds: privIds };
		  var parms = id ? upateParms : newParms;
		  $.ajax({
		  	  	url: url,
		        type: 'POST',
		        dataType: 'json',
		        data: parms
		      })
		   .done(function(data) {
			  $this.removeAttr('disabled');
			  RoleUeditor.fillData(data);
			  if (id) {
				  swal({
                      title: "编辑成功",
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
			  } else {
				  swal({
                      title: "创建成功",
                      text: "返回上一页？",
                      type: "success",
                      showCancelButton: true,
                      confirmButtonColor: "#8cd4f5",
                      confirmButtonText: "返回上一页",
                      cancelButtonText: "留在本页",
                      closeOnConfirm: false
                  }, function () {
                	  	var url = '/role_list.html';
                     location.href = url;
                  });
			  }
		  });
	  })
  }
  
  RoleUeditor.cancel = function() {
      $('#cancel').on('click', function(){
			// 取消(直接返回上一级，不做接口交互)
			window.history.go(-1);
      });
  }
  
  
  return RoleUeditor;
})();
