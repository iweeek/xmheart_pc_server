exports = this;
exports.XPW = exports.EDIT || {};
exports.XPW.IndexEdit = (function() {
  function IndexEdit() {
	  // 初始化页面处理。
	  IndexEdit.addSlideImg();
	  IndexEdit.getData();
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
	  console.log(123)
	  $.get('/indexPage',function(data){
		  console.log(data);
	  });
  }
  
  


  return IndexEdit;
})();
