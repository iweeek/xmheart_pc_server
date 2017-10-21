exports = this;
exports.XPW = exports.EDIT || {};
exports.XPW.IndexEdit = (function() {
  function IndexEdit() {
	  // 初始化页面处理。
	  IndexEdit.addSlideImg();
	  IndexEdit.getData();
	  IndexEdit.pageId = 0;
	  IndexEdit.postData();
	  IndexEdit.limitFont();
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
		  $('.add-font-list').eq(0).find('.link-title').val(data.bannerArticle1Title),
		  $('.add-font-list').eq(0).find('textarea').val(data.bannerArticle1Brief),
		  $('.add-font-list').eq(0).find('.input-link').val(data.bannerArticle1Url),
		  $('.add-font-list').eq(1).find('.link-title').val(data.bannerArticle2Title),
		  $('.add-font-list').eq(1).find('textarea').val(data.bannerArticle2Brief),
		  $('.add-font-list').eq(1).find('.input-link').val(data.bannerArticle2Url),
		  $('.add-font-list').eq(2).find('.link-title').val(data.bannerArticle3Title),
		  $('.add-font-list').eq(2).find('textarea').val(data.bannerArticle3Brief),
		  $('.add-font-list').eq(2).find('.input-link').val(data.bannerArticle3Url)
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
			bannerImage3ActionUrl: $('.add-img-list').eq(2).find('.add-img-link input').val(),
			bannerArticle1Title: $('.add-font-list').eq(0).find('.link-title').val(),
			bannerArticle1Brief: $('.add-font-list').eq(0).find('textarea').val(),
			bannerArticle1Url: $('.add-font-list').eq(0).find('.input-link').val(),
			bannerArticle2Title: $('.add-font-list').eq(1).find('.link-title').val(),
			bannerArticle2Brief: $('.add-font-list').eq(1).find('textarea').val(),
			bannerArticle2Url: $('.add-font-list').eq(1).find('.input-link').val(),
			bannerArticle3Title: $('.add-font-list').eq(2).find('.link-title').val(),
			bannerArticle3Brief:$('.add-font-list').eq(2).find('textarea').val(),
			bannerArticle3Url: $('.add-font-list').eq(2).find('.input-link').val()
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
  IndexEdit.limitFont = function () {
	  var numItem = $('.word');
	  var digest = $('.digest-wrapper textarea');
	  var max = $('.word').eq(0).text(), curLength;
      digest[0].setAttribute("maxlength", max);
      digest[1].setAttribute("maxlength", max);
      digest[2].setAttribute("maxlength", max);
      curLength = digest.val().length;
      numItem.text(curLength);
      digest.on('input propertychange', function () {
    	  	 $(this).siblings('.wordwrap').find('.word').text($(this).val().length);
      });
  }

  return IndexEdit;
})();
