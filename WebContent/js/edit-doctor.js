exports = this;
exports.XPW = exports.EDIT || {};
exports.XPW.DoctorEdit = (function() {
  function DoctorEdit() {
    // 初始化页面处理。
	DoctorEdit.firstOfficeLoad();
	DoctorEdit.firstSelectHandle();
	DoctorEdit.jumpDoctorDep();
	DoctorEdit.NewDoctor();
	DoctorEdit.online();
	DoctorEdit.next();
	DoctorEdit.prev();
	DoctorEdit.deptId = 0;
	DoctorEdit.hasNextPage = true;
	DoctorEdit.hasPreviousPage = false;
	DoctorEdit.totalPage = 0;
	DoctorEdit.currentPage = 1;
  }
  DoctorEdit._getUrlParam = function (name) {
      var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
      var r = window.location.search.substr(1).match(reg);  //匹配目标参数
      if (r != null) return unescape(r[2]); return null; //返回参数值
  },
  DoctorEdit.firstOfficeLoad = function () {
	$('.ui-loading').hide();
	$('.previous').hide();
	$('.next').hide();
	$.ajax({
	  url: '/depts',
      type: 'GET'
    })
   .done(function(data) {
      var firstColumnTemplate = $('#firstColumnTemplate').html();
      Mustache.parse(firstColumnTemplate);   
      var rendered = Mustache.render(firstColumnTemplate, {data:data});
      $('#typeSelectInput').html(rendered);
      $('#columnSearch').trigger('click');
   })
  }

  DoctorEdit.firstSelectHandle = function () {
    $('#columnSearch').click(function() {
    		DoctorEdit.deptId = $('#typeSelectInput').val();
    		$('.ui-loading').show();
    		if (DoctorEdit._getUrlParam('pageNo')) {
    			DoctorEdit.currentPage = DoctorEdit._getUrlParam('pageNo');
    		}
    		DoctorEdit.doctorData();
    })
  }

  DoctorEdit.doctorData = function () {
    $.ajax({
      url: '/doctors',
      type: 'GET',
      dataType: 'json',
      data: {deptId: DoctorEdit.deptId, pageNo: DoctorEdit.currentPage}
    })
    .done(function(data) {
    		var list = data.list;
    		if (data.hasPreviousPage) {
    			$('.previous').show();
    		} else {
    			$('.previous').hide();
    		}
    		if (data.hasNextPage) {
    			$('.next').show();
    		} else {
    			$('.next').hide();
    		}
    		DoctorEdit.hasNextPage = data.hasNextPage;
    		DoctorEdit.hasPreviousPage = data.hasPreviousPage;
    		DoctorEdit.totalPage = data.pages;
    		DoctorEdit.currentPage = data.pageNum;
    		if (list.length > 0) {
    	    		var doctorTemplate = $('#doctorTd').html();
    	    	    Mustache.parse(doctorTemplate);   // optional, speeds up future uses
    	    	    var rendered = Mustache.render(doctorTemplate, {data: list});
    	    	    $('#doctorTable').html(rendered);
    	    	    $('.ui-loading').hide();
    		} else {
    			swal({
    				  title: "当前栏目下没有医生",
    				  timer: 1500,
    				  showConfirmButton: false
    			});
    		}
    })
    .fail(function(e) {
    	 	$('.ui-loading').hide();
    	 	$('#doctorTable').html('');
    	 	swal('当前栏目下没有医生！')
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
		  $this.attr('disabled','disabled');
		  var id = $this.data('id');
		  var isDisplayed = !$this.data('is-displayed');
		  $.ajax({
		  	  	url: '/doctors/' + id,
		        type: 'POST',
		        dataType: 'json',
		        data: {id:id, isDisplayed: isDisplayed}
		      })
		  .done(function(data) {
			  $this.removeAttr('disabled');
			  var doctorTemplate = $('#doctorTd').html();
		    	  Mustache.parse(doctorTemplate);   // optional, speeds up future uses
		    	  var rendered = Mustache.render(doctorTemplate, {data:data});
		    	  $('#'+id).replaceWith(rendered);
		  });
	  })
  }
  
  DoctorEdit.NewDoctor = function () {
	  $('#tools').on ('click', '#columnNew', function() {
	      location.href = '/static/doctor_ueditor.html';
	  })
  }
  
  DoctorEdit.next = function () {
	  $('.pager').on ('click', '.next a', function() {
	      if(DoctorEdit.hasNextPage) {    	  	
	    	  	DoctorEdit.currentPage += 1;
	    	  	DoctorEdit.doctorData();
	      }
	  })
  }
  
  DoctorEdit.prev = function () {
	  $('.pager').on ('click', '.previous a', function() {
	      if(DoctorEdit.hasPreviousPage) {
	    	  	DoctorEdit.currentPage -= 1;
	    	  	DoctorEdit.doctorData();
	      }
	  })
  }
  
  return DoctorEdit;
})();
