exports = this;
exports.XPW = exports.EDIT || {};
exports.XPW.DoctorUeditor = (function() {
  function DoctorUeditor() {
    // 初始化页面处理。
	DoctorUeditor.firstOfficeLoad()
  	DoctorUeditor.getDoctorInfo()
  	DoctorUeditor.postDoctorInfo()
  	DoctorUeditor.ue = UE.getEditor('container');
	DoctorUeditor.isDisplayed = false;
  }

  DoctorUeditor.getUrlParam = function (name) {
      var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
      var r = window.location.search.substr(1).match(reg);  //匹配目标参数
      if (r != null) return unescape(r[2]); return null; //返回参数值
  }
  
  DoctorUeditor.fillData = function (data) {
	  $('#doctorName').val(data.name);
      $('#doctorProfessiona').val(data.professionalTitle);
      $('#doctorDuty').val(data.duty);
      $('#typeSelectInput').val(data.deptId);
      DoctorUeditor.isDisplayed = data.isDisplayed;
      DoctorUeditor.ue.ready(function () {
          //设置编辑器的内容
   	   	   DoctorUeditor.ue.setContent(data.intro);
      });
  }
  DoctorUeditor.firstOfficeLoad = function () {
	  $.ajax({
		  url: '/xmheart_pc_server/depts',
	      type: 'GET'
	    })
	   .done(function(data) {
	      var firstColumnTemplate = $('#firstColumnTemplate').html();
	      Mustache.parse(firstColumnTemplate);   
	      var rendered = Mustache.render(firstColumnTemplate, {data});
	      $('#typeSelectInput').html(rendered);
	   })
  }
  
  DoctorUeditor.getDoctorInfo = function () {
    var id = DoctorUeditor.getUrlParam('doctorId')
    if (id) {
	    $.ajax({
	  	  url: '/xmheart_pc_server/doctors/' + id,
	        type: 'GET',
	        dataType: 'json',
	        data: {id: id}
	      })
	     .done(function(data) {
	    	 	DoctorUeditor.fillData(data);
	     })
     }
  }
 
  DoctorUeditor.postDoctorInfo = function () {
	  var id = DoctorUeditor.getUrlParam('doctorId');
	  var url = id ? '/xmheart_pc_server/doctors/' + id : '/xmheart_pc_server/doctors'
	  $('.btn-group').on('click', '#save', function() {
		  var name = $('#doctorName').val();
		  var deptId = parseInt($('#typeSelectInput').val());
		  var duty = $('#doctorDuty').val();
		  var professionalTitle = $('#doctorProfessiona').val();
		  var intro = DoctorUeditor.ue.getContent();
		  var isDisplayed = DoctorUeditor.isDisplayed;
		  var upateParms = {id: id, name: name, deptId: deptId, duty: duty, professionalTitle: professionalTitle, intro: intro, isDisplayed: isDisplayed};
		  var newParms = {name: name, deptId: deptId, duty: duty, professionalTitle: professionalTitle, intro: intro, isDisplayed: isDisplayed};
		  var parms = id ? upateParms : newParms;
		  $.ajax({
		  	  	url: url,
		        type: 'POST',
		        dataType: 'json',
		        data: parms
		      })
		  .done(function(data) {
			  DoctorUeditor.fillData(data);
			  swal("保存成功!");
		  });
	  })
  }
  
  return DoctorUeditor;
})();
