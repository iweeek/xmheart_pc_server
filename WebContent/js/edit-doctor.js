exports = this;
exports.XPW = exports.EDIT || {};
exports.XPW.DoctorEdit = (function() {
  function DoctorEdit() {
    // 初始化页面处理。
	DoctorEdit.firstOfficeLoad();
	DoctorEdit.firstSelectHandle();
	DoctorEdit.jumpDoctorDep()
	DoctorEdit.NewDoctor()
  }
  DoctorEdit.firstOfficeLoad = function () {
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

  DoctorEdit.firstSelectHandle = function () {
    $('#columnSearch').click(function() {
    		var val = $('#typeSelectInput').val();
    		DoctorEdit.doctorData(val);
    })
  }

  DoctorEdit.doctorData = function (val) {
    $.ajax({
      url: '/xmheart_pc_server/doctors',
      type: 'GET',
      dataType: 'json',
      data: {deptId: val}
    })
    .done(function(data) {
    		if (data.length > 0) {
    	    		var doctorTemplate = $('#doctorTd').html();
    	    	    Mustache.parse(doctorTemplate);   // optional, speeds up future uses
    	    	    var rendered = Mustache.render(doctorTemplate, {data});
    	    	    $('#doctorTable').html(rendered);
    		} else {
    			swal({
    				  title: "当前一级栏目下没有二级栏目",
    				  timer: 1500,
    				  showConfirmButton: false
    			});
    		}
    })
  }

  DoctorEdit.jumpDoctorDep = function () {
    $('#doctorTable').on ('click', '.post-btn-edit', function() {
      var doctorId = $(this).data('doctor-id');
      location.href = '/xmheart_pc_server/static/doctor-ueditor.html?doctorId=' + doctorId;
    })
    
  }
  
  DoctorEdit.NewDoctor = function () {
	  $('#tools').on ('click', '#columnNew', function() {
	      location.href = '/xmheart_pc_server/static/doctor-ueditor.html';
	  })
  }
  
  return DoctorEdit;
})();
