exports = this;
exports.XPW = exports.EDIT || {};
exports.XPW.IndexEdit = (function() {
  function IndexEdit() {
	  // 初始化页面处理。
	  IndexEdit.addSlideImg();
	  IndexEdit.getData();
	  IndexEdit.pageId = 0;
	  IndexEdit.postData();
  }
  
  IndexEdit.addSlideImg = function () {
	  $('.add-list-main').on('click', '#addImgBtn', function (){
		  $(this).siblings('.upload-form').find('.add-img-file').trigger('click');
	  })
	  $('.add-list-main').on('change', '.add-img-file', function (){
		  $(this).siblings('.add-img-submit').trigger('click');
	  })
	  $('.js-upload-form').submit(function(){
		  $this = $(this);
		  $this.ajaxSubmit({
			  success: function (responseText) {
				  var img = responseText;
				  $this.siblings('.add-image-url').find('.upload-img').attr('src', img);
				  $this.siblings('.add-image-button').hide();
				  $this.siblings('.add-image-url').show();
			  }
		  });
		  return false;
	  })
	  $('.add-list-main').on('mouseover', '.add-image-url, .add-image-edit', function (){
		  $(this).siblings('.add-image-edit').show();
	  })
	  $('.add-list-main').on('mouseleave', '.add-image-url, .add-image-edit', function (){
		  $(this).siblings('.add-image-edit').hide();
	  })
	  $('.add-list-main').on('mouseover', '.add-image-edit', function (){
		  $(this).show();
	  })
	  $('.add-list-main').on('mouseleave', '.add-image-edit', function (){
		  $(this).hide();
	  })
	  $('.add-list-main').on('click', '.add-image-edit', function (){
		  $(this).siblings('.upload-form').find('.add-img-file').trigger('click');
	  })
  }
  
  IndexEdit.getData = function () {
	  $.get('/indexPage',function(data){
		  console.log(data);
		  IndexEdit.pageId = data.id;
		  if(data.bannerImage1Url) {
			  $('.add-img-list').eq(0).find('.add-image-url img').attr('src', data.bannerImage1Url);
			  $('.add-img-list').eq(0).find('.add-image-button').hide();
			  $('.add-img-list').eq(0).find('.add-image-url').show();
		  }
		  if (data.bannerImage1ActionUrl) {
			  $('.add-img-list').eq(0).find('.add-img-link input').val(data.bannerImage1ActionUrl);
		  }
		  if(data.bannerImage2Url) {
			  $('.add-img-list').eq(1).find('.add-image-url img').attr('src', data.bannerImage1Url);
			  $('.add-img-list').eq(1).find('.add-image-button').hide();
			  $('.add-img-list').eq(1).find('.add-image-url').show();
		  }
		  if (data.bannerImage2ActionUrl) {
			  $('.add-img-list').eq(1).find('.add-img-link input').val(data.bannerImage1ActionUrl);
		  }
		  if(data.bannerImage3Url) {
			  $('.add-img-list').eq(2).find('.add-image-url img').attr('src', data.bannerImage1Url);
			  $('.add-img-list').eq(2).find('.add-image-button').hide();
			  $('.add-img-list').eq(2).find('.add-image-url').show();
		  }
		  if (data.bannerImage3ActionUrl) {
			  $('.add-img-list').eq(2).find('.add-img-link input').val(data.bannerImage1ActionUrl);
		  }
	  });
  }
  IndexEdit.postData = function () {
	  $('.search-button').on('click', function(){
		  var parms = {
		    bannerImage1Url: $('.add-img-list').eq(0).find('.add-image-url img').attr('src'),
			bannerImage1ActionUrl: $('.add-img-list').eq(0).find('.add-img-link input').val(),
			bannerImage2Url: $('.add-img-list').eq(1).find('.add-image-url img').attr('src'),
			bannerImage2ActionUrl: $('.add-img-list').eq(1).find('.add-img-link input').val(),
			bannerImage3Url: $('.add-img-list').eq(2).find('.add-image-url img').attr('src'),
			bannerImage3ActionUrl: $('.add-img-list').eq(2).find('.add-img-link input').val()
		  };
		  var url = 'indexPage/'+ IndexEdit.pageId;
		  $.ajax({
			  url: url,
		      type: 'put',
		      dataType: 'json',
		      data: parms
		    })
		   .done(function(data) {
			   swal('更新成功')
		   })
	  });
  }
  
  


  return IndexEdit;
})();
