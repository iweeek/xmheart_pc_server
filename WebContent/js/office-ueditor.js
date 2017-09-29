exports = this;
exports.XPW = exports.EDIT || {};
exports.XPW.OfficeUeditor = (function() {
  function OfficeUeditor() {
    // 初始化页面处理。
	OfficeUeditor.getOfficeInfo()
  	OfficeUeditor.postOfficeInfo()
  	OfficeUeditor.ue = UE.getEditor('container');
	OfficeUeditor.isDisplayed = false;
  }

  OfficeUeditor.getUrlParam = function (name) {
      var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
      var r = window.location.search.substr(1).match(reg);  //匹配目标参数
      if (r != null) return unescape(r[2]); return null; //返回参数值
  }
  
  OfficeUeditor.fillData = function (data) {
	  $('#officeName').val(data.name);
      $('#officeNum').val(data.doctors);
      $('#officeOutService').val(data.outService);
      $('#typeSelectInput').val(data.deptId);
      OfficeUeditor.isDisplayed = data.isDisplayed;
      OfficeUeditor.ue.ready(function () {
        //设置编辑器的内容
    	  	OfficeUeditor.ue.setContent(data.intro);
      });
  }
  
  OfficeUeditor.getOfficeInfo = function () {
    var id = OfficeUeditor.getUrlParam('deptId')
    if (id) {
	    $.ajax({
	  	  url: '/xmheart_pc_server/dept/' + id,
	        type: 'GET',
	        dataType: 'json',
	        data: {id: id}
	      })
	     .done(function(data) {
	    	   OfficeUeditor.fillData(data);
	     })
     }
  }
 
  OfficeUeditor.postOfficeInfo = function () {
	  var id = OfficeUeditor.getUrlParam('deptId');
	  var url = id ? '/xmheart_pc_server/dept/' + id : '/xmheart_pc_server/dept'
	  $('.btn-group').on('click', '#save', function() {
		  var name = $('#officeName').val();
	      var outService = $('#officeOutService').val();
		  var isDisplayed = OfficeUeditor.isDisplayed;
		  var intro = OfficeUeditor.ue.getContent();
		  var upateParms = {id: id, name: name, outService: outService, intro: intro, isDisplayed: isDisplayed};
		  var newParms = {name: name, outService: outService,  intro: intro, isDisplayed: isDisplayed};
		  var parms = id ? upateParms : newParms;
		  $.ajax({
		  	  	url: url,
		        type: 'POST',
		        dataType: 'json',
		        data: parms
		      })
		  .done(function(data) {
			  OfficeUeditor.fillData(data);
			  swal("保存成功!");
		  });
	  })
  }
  
  return OfficeUeditor;
})();
