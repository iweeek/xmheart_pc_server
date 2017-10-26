// 轮播
var mySwiper = new Swiper ('#bannerSwiper', {
  loop: true,
  paginationClickable :true,
  pagination: '.swiper-pagination'
})

var mySwiper2 = new Swiper ('#noticeSwiper', {
  direction: 'vertical',
  loop: true,
  paginationClickable :true,
  pagination: '.swiper-pagination'
})

// 导航
$(function(){
	$(".xm-navbar-nav .xm-navbar-item").hover(function(){
  	$t=$(this);
  	$obj=$t.find(".navboxBase");
  	$obj.css({"left":-$t.offset().left+"px","width":$("body").width()});
  	$obj.show();
  },function(){
    $(this).find('.navboxBase').hide();
  });

  // 导航悬浮
  var $xmNav = $('.xm-nav');

  var fixTop = $xmNav.offset().top;
  var fixHeight = $xmNav.height();

  $(window).scroll(function(event) {
  	 var docTop = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
  	 if (fixTop < docTop) {
      $xmNav.addClass('xm-nav-fixed');
    } else {
      $xmNav.removeClass('xm-nav-fixed');
    }
  });

  // 专家轮播
  $('.officesBase').each(function(idx, e){
    var swiper = new Swiper($(this).find('.contentsDoctor'), {
      slidesPerView: 4,
      paginationClickable: true,
      spaceBetween: 0,
      freeMode: true,
      prevButton:$(this).find('.Aprev'),
      nextButton:$(this).find('.Anext'),
    });
  })


  $('.contentsDoctor li').hover(function(){
	var $this = $(this);
	$this.find('.doctorDialog').show();
    var nextIndex = $this.siblings('.swiper-slide-next').index();
    var currentIndex = $this.index();
    if (nextIndex !== -1 && currentIndex === (nextIndex + 2)) {
    		setTimeout(function(){
    			$this.parents('.contents').siblings('.toolsBase').find('.Anext').trigger('click');
    		}, 800)
    }
  },function(){
    $(this).find('.doctorDialog').hide();
  });
  // 科室轮播
  // var swiper = new Swiper('#officeSwiper', {
  //   slidesPerView: 4,
  //   paginationClickable: true,
  //   spaceBetween: 0,
  //   freeMode: true,
  //   prevButton:'.officesBase .Aprev',
  //   nextButton:'.officesBase .Anext',
  // });

  // 胸痛中心
  $(".quickMenus li.first").hover(function(){
		$t=$(this);
		$obj=$t.find(".QMSub");
		if($obj.length>0){
			$obj.css("top",-(12+$t.index()*61)+"px");
			$obj.show();
		}
	},function(){
		$t=$(this);
		$obj=$t.find(".QMSub");
		if($obj.length>0){
			$obj.hide();
		}
	});
  
  $(".QMSubMenus li.second").hover(function(){
		$t=$(this);
		$obj=$t.find(".third-menus");
		if($obj.length>0){
			$obj.show();
		}
	},function(){
		$t=$(this);
		$obj=$t.find(".third-menus");
		if($obj.length>0){
			$obj.hide();
		}
	});
  
  var mySwiper = new Swiper ('#xtSwiper', {
    loop: true,
    paginationClickable :true,
    pagination: '.swiper-pagination'
  })

  //  详情页字体控制
  $("#EMChange a").click(function(){
  	$t=$(this);
  	if($t.data("type")=="0"){
  		$("#EMChange img").stop().animate({"left":"-5px"},288);
  		$("#FontState").text("14px");
  		$("#DIVContent").find('*').css({"font-size":"14px","line-height":"24px"});
  	}else if($t.data("type")=="1"){
  		$("#EMChange img").stop().animate({"left":"40px"},288);
  		$("#FontState").text("16px");
  		$("#DIVContent").find('*').css({"font-size":"16px","line-height":"24px"});
  	}else{
  		$("#EMChange img").stop().animate({"left":"86px"},288);
  		$("#FontState").text("18px");
  		$("#DIVContent").find('*').css({"font-size":"18px","line-height":"24px"});
  	}
  });

  // 电子院报
  var year = "";
  var time = "";
  $("#ddlYears2").change(function(){
	  year = $(this).val();
  });
  $("#ddlTimes2").change(function(){
	  times = $(this).val();
  });
  $("#GoToNewspaper2").on("click",function(){
	  var str = "?page=1&year=" + year + "&times=" + times;
	  location.href = str;
  });

  $('#ddlYears2').change(function(){
    var selectVal = $(this).val();
    if (selectVal !== 0) {
      ajaxTimes(selectVal);
    }else {
      $('#ddlTimes2').html('');
      var html = '<option value="0">选择期数</option>';
      $('#ddlTimes2').html(html);
    }
  })

  function ajaxTimes(val) {
    $.ajax({
      url: 'getTimes',
      type: 'GET',
      dataType: 'json',
      data: {year: val},
    })
    .done(function(data) {
      $('#ddlTimes2').html('');
      var html = '<option value="0">选择期数</option>';
      for (var i = 0; i< data.length; i++) {
        html += '<option value = "' + data[i] + '">' + data[i] + '期</option>'
      }
      $('#ddlTimes2').html(html);
    })
  }
//  前台视频播放
  var videoUrl = $('#H2Title').data('src');
  if (videoUrl) {
	  $("#jquery_jplayer_1").jPlayer({
			ready: function () {
				$(this).jPlayer("setMedia", {
					title: "Big Buck Bunny",
					m4v: videoUrl,
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
  }
})
