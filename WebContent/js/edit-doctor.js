exports = this;
exports.XPW = exports.EDIT || {};
exports.XPW.DoctorEdit = (function() {
  function DoctorEdit() {
    // 初始化页面处理。
	DoctorEdit.firstOfficeLoad();
	DoctorEdit.firstSelectHandle();
	DoctorEdit.jumpDoctorDep()
	DoctorEdit.NewDoctor()
	DoctorEdit.online()
  }
  DoctorEdit.firstOfficeLoad = function () {
	$('.ui-loading').hide();
	$.ajax({
	  url: '/depts',
      type: 'GET'
    })
   .done(function(data) {
      var firstColumnTemplate = $('#firstColumnTemplate').html();
      Mustache.parse(firstColumnTemplate);   
      var rendered = Mustache.render(firstColumnTemplate, {data});
      $('#typeSelectInput').html(rendered);
      $('#columnSearch').trigger('click');
   })
  }

  DoctorEdit.firstSelectHandle = function () {
    $('#columnSearch').click(function() {
    		var val = $('#typeSelectInput').val();
    		$('.ui-loading').show();
    		DoctorEdit.doctorData(val);
    })
  }

  DoctorEdit.doctorData = function (val) {
    $.ajax({
      url: '/doctors',
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
    	    	    $('.ui-loading').hide();
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
      location.href = '/static/doctor_ueditor.html?doctorId=' + doctorId;
    }) 
  }
  
  DoctorEdit.online = function () {
	  $('#doctorTable').on ('click', '.post-btn-online', function() {
		  var $this = $(this);
		  var id = $this.data('id');
		  var isDisplayed = !$this.data('is-displayed');
		  $.ajax({
		  	  	url: '/doctors/' + id,
		        type: 'POST',
		        dataType: 'json',
		        data: {id:id, isDisplayed: isDisplayed}
		      })
		  .done(function(data) {
			  var doctorTemplate = $('#doctorTd').html();
		    	  Mustache.parse(doctorTemplate);   // optional, speeds up future uses
		    	  var rendered = Mustache.render(doctorTemplate, {data});
		    	  $('#'+id).replaceWith(rendered);
		  });
	  })
  }
  
  DoctorEdit.NewDoctor = function () {
	  $('#tools').on ('click', '#columnNew', function() {
	      location.href = '/static/doctor_ueditor.html';
	  })
  }
  
  return DoctorEdit;
})();
