exports = this;
var videoUrl;
var videoId;
var title = $('#videoTitle');
var brief = $('#brief');
var isAdded = false;
exports.XPW = exports.EDIT || {};
exports.XPW.videoEdit = (function() {
	videoEdit.getUrlParam = function(name) {
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
			var r = window.location.search.substr(1).match(reg); // 匹配目标参数
			if (r != null)
				return unescape(r[2]);
			return null; // 返回参数值
			
	    }
	
    function videoEdit() {
//	  videoEdit.initVideo();
    	  var id = videoEdit.getUrlParam("videoId");
    	  console.log(id);
    	  if (!id) {
    		  $("#publish").show();
    		  $("#update").hide();
    	  } else {
    		  $("#publish").hide();
    		  $("#update").show();
    	  }
	  // 初始化页面处理。
	  videoEdit.addVideo();
	  videoEdit.publish();
	  videoEdit.update();
	  videoEdit.init();
//	  xtIndexEdit.getData();
//	  xtIndexEdit.pageId = 0;
//	  xtIndexEdit.postData();
    }
  videoEdit.initVideo = function (video) {
//	  $("#jquery_jplayer_1").jPlayer({
//		   ready: function () {
//		    $(this).jPlayer("setMedia", {
//		     m4a: "http://localhost:8080/js/third_party/01.mp4",
//		     oga: "/media/mysound.ogg"
//		    });
//		   },
//		   swfPath: "/js",
//		   supplied: "m4a, oga"
//		  });
	  var videoSrc = video || '';
	  videoUrl = videoSrc;
	  console.log(videoUrl);// TODO
	  $("#jquery_jplayer_1").jPlayer({
			ready: function () {
				$(this).jPlayer("setMedia", {
					title: "Big Buck Bunny",
					m4v: videoSrc,
					poster: "http://www.jplayer.org/video/poster/Big_Buck_Bunny_Trailer_480x270.png"
				});
			},
			swfPath: "./third_party/jquery.jplayer.swf",
			supplied: "m4v",
			size: {
				width: "640px",
				height: "360px",
				cssClass: "jp-video-360p"
			},
			useStateClassSkin: true,
			autoBlur: false,
			smoothPlayBar: true,
			keyEnabled: true,
			remainingDuration: true,
			toggleDuration: true
		});
	  isAdded = true;
  }
  
  videoEdit.addVideo = function () {
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
				  var video = responseText;
				  videoEdit.initVideo(video);
//				  $this.siblings('.add-image-url').find('.upload-img').attr('src', img);
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
  
  videoEdit.valid = function (params, type) {

	if (!params.title) {
		sweetAlert("信息不完整", "请填写标题", "error");
		return false;
	}

	if (!params.brief) {
		sweetAlert("信息不完整", "请填写简介", "error");
		return false;
	}
	
	if (!isAdded) {
		sweetAlert("信息不完整", "请选择需要上传的视频", "error");
		return false;
	}
	return true;
  }
  
    videoEdit.publish = function () {
	    $('#publish').on('click', function(){
		    var $this = $(this);
	
		    console.log(title.val());
		    console.log(brief.val());
		    console.log(videoUrl);
			var params = {
				title : title.val(),
				brief : brief.val(),
				isPublished : true,
				imgUrl : '',
				videoUrl : videoUrl
			};
	
			if (!videoEdit.valid(params, 'publish')) {
				return;
			}
			$this.attr('disabled', 'disabled');
			var url = '/videos';
			$.post(url, params, function(res) {
				$this.removeAttr('disabled');
//				swal({
//					title : "上传成功",
//					type : "success",
//					showCancelButton : true,
//					confirmButtonColor : "#8cd4f5",
//					confirmButtonText : "确定",
//					cancelButtonText : "继续上传",
//					closeOnConfirm : true
//				}).then(function() {
//					//成功
//				}, function (dismiss) {
//					  // dismiss can be 'cancel', 'overlay',
//					  // 'close', and 'timer'
//					  if (dismiss === 'cancel') {
//					    swal(
//					      'Cancelled',
//					      'Your imaginary file is safe :)',
//					      'error'
//					    )
//					  }
//				});
				
				swal({
					title : "上传成功",
					type : "success",
					confirmButtonColor : "#8cd4f5",
					confirmButtonText : "确定",
					closeOnConfirm : true
					}).then(function () {
					 
					});
			}).error(function() {
				$this.removeAttr('disabled');
				sweetAlert("哎呀", "服务器开小差了~请稍后再试", "error");
			});

			return;
  	    });
    }
    
    videoEdit.update = function () {
	    $('#update').on('click', function(){
		    var $this = $(this);
	
			var params = {
				title : title.val(),
				brief : brief.val(),
				isPublished : true,
				imgUrl : '',
				videoUrl : videoUrl
			};
	
			if (!videoEdit.valid(params, 'update')) {
				return;
			}
			$this.attr('disabled', 'disabled');
			var url = '/videos/' + videoId;
			$.post(url, params, function(res) {
				$this.removeAttr('disabled');
				swal({
					title : "更新成功",
					type : "success",
					confirmButtonColor : "#8cd4f5",
					confirmButtonText : "确定",
					closeOnConfirm : true
				}, function() {
//					window.history.go(-1);
				});
			});

			return;
  	    });
    }
  
    videoEdit.getVideos = function(videoId) {
    		var url = '/videos/' + videoId;
        $.get(url, function (res) {
            $('#videoTitle').val(res.title);
            $('#brief').val(res.brief);
//            $('#upload-img').attr('src', res.imageUrl);
            console.log(res.videoUrl);
            videoEdit.initVideo(res.videoUrl);
            $('#add-image-url').show();
            $('#addImgBtn').hide();
        });
    }
		
    videoEdit.init = function() {
    		videoId = videoEdit.getUrlParam('videoId');
        if (videoId) {
            videoEdit.getVideos(videoId);
        }
    }
  
//  xtIndexEdit.getData = function () {
//	  $.get('/xtIndexPage',function(data){
//		  IndexEdit.pageId = data.id;
//		  if(data.bannerImage1Url) {
//			  $('.add-img-list').eq(0).find('.add-image-url img').attr('src', data.bannerImage1Url);
//			  $('.add-img-list').eq(0).find('.add-image-button').hide();
//			  $('.add-img-list').eq(0).find('.add-image-url').show();
//		  }
//		  if (data.bannerImage1ActionUrl) {
//			  $('.add-img-list').eq(0).find('.add-img-link input').val(data.bannerImage1ActionUrl);
//		  }
//		  if(data.bannerImage2Url) {
//			  $('.add-img-list').eq(1).find('.add-image-url img').attr('src', data.bannerImage1Url);
//			  $('.add-img-list').eq(1).find('.add-image-button').hide();
//			  $('.add-img-list').eq(1).find('.add-image-url').show();
//		  }
//		  if (data.bannerImage2ActionUrl) {
//			  $('.add-img-list').eq(1).find('.add-img-link input').val(data.bannerImage1ActionUrl);
//		  }
//		  if(data.bannerImage3Url) {
//			  $('.add-img-list').eq(2).find('.add-image-url img').attr('src', data.bannerImage1Url);
//			  $('.add-img-list').eq(2).find('.add-image-button').hide();
//			  $('.add-img-list').eq(2).find('.add-image-url').show();
//		  }
//		  if (data.bannerImage3ActionUrl) {
//			  $('.add-img-list').eq(2).find('.add-img-link input').val(data.bannerImage1ActionUrl);
//		  }
//	  });
//  }
//  xtIndexEdit.postData = function () {
//	  $('.search-button').on('click', function(){
//		  var parms = {
//		    bannerImage1Url: $('.add-img-list').eq(0).find('.add-image-url img').attr('src'),
//			bannerImage1ActionUrl: $('.add-img-list').eq(0).find('.add-img-link input').val(),
//			bannerImage2Url: $('.add-img-list').eq(1).find('.add-image-url img').attr('src'),
//			bannerImage2ActionUrl: $('.add-img-list').eq(1).find('.add-img-link input').val(),
//			bannerImage3Url: $('.add-img-list').eq(2).find('.add-image-url img').attr('src'),
//			bannerImage3ActionUrl: $('.add-img-list').eq(2).find('.add-img-link input').val()
//		  };
//		  var url = 'xtIndexPage/'+ xtIndexEdit.pageId;
//		  $.ajax({
//			  url: url,
//		      type: 'put',
//		      dataType: 'json',
//		      data: parms
//		    })
//		   .done(function(data) {
//			   swal('更新成功');
//		   })
//	  });
//  }

  return videoEdit;
})();
