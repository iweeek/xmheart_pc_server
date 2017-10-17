		<div class="xm-footer">
			<div class="xm-footer-main">
				<div class="xm-footer-link">
					<a href="#">网站地图</a>
					<span>|</span>
					<a href="#">法律声明</a>
					<span>|</span>
					<a href="#">版权声明</a>
					<span>|</span>
					<a href="#">隐私安全</a>
					<span>|</span>
					<a href="#">帮助信息</a>
				</div>
				<p class="xm-footer-info">版权所有：厦门大学心血管病医院（本网站所有内容未经许可，不得以任何形式进行转载）</p>
				<p class="xm-footer-info">闽ICP备09051364号-1</p>
				<script src="http://dcs.conac.cn/js/14/215/0000/41619365/CA142150000416193650001.js"></script>
			</div>
		</div>
		<script src="/js/third_party/jquery.min.js"></script>
		<script src="/js/respond.min.js"></script>
		<script src="/js/swiper-3.4.2.jquery.min.js"></script>
		<script src="/js/common.js"></script>
		
		<div class="xm-float-right">
            <a>
                <img src="/image/img21.png">
                <p>收起</p>
            </a>
            <!--<a style="display: block;">
                <img src="/image/img11.png"><i></i>
                <div class="up" style="display: none; opacity: 1;">掌上厦心</div>
                <div class="code"><img src="/image/barcode_app.gif" alt=""></div>
            </a>-->
            <a style="display: block;">
                <img src="/image/img12.png"><i></i>
                <div class="up" style="display: none; opacity: 1;">官方微信</div>
                <!--<div class="code"><img src="/image/barcode_wx.gif" alt=""></div>-->
            </a>
            <a style="display: block;">
                <img src="/image/img13.png"><i></i>
                <div class="up" style="opacity: 1; display: none;">官方微博</div>
                <!--<div class="code"><img src="/image/barcode_wx.gif" alt=""></div>-->
            </a>
            <a href="" style="display: block;">
                <img src="/image/img14.png"><i></i>
                <div class="up" style="display: none; opacity: 1;">我要挂号</div>
            </a>
            <!--<a href="/Interactions/HospitalMails" style="display: block;">
                <img src="/image/img15.png"><i></i>
                <div class="up" style="opacity: 1; display: none;">意见信箱</div>
            </a>
            <a href="http://www.fuwaihospital.org/rsc/List.aspx" style="display: block;">
                <img src="/image/img16.png"><i></i>
                <div class="up" style="opacity: 1; display: none;">我要求职</div>
            </a>--> 
            <a class="gotop" href="#">
                <img src="/image/img18.png"><i></i>
                <div class="up" style="opacity: 1; display: none;">返回顶部</div>
            </a>
        </div>
    </body>
</html>
<script>
    $('.xm-float-right a:first').click(function(){
        if(!$(this).hasClass('hide')){
            $(this).children('p').text('展开');
            $(this).addClass('hide').nextAll(':not(:last)').css('display','none');
        }else{
            $(this).children('p').text('收起');
            $(this).removeClass('hide').nextAll(':not(:last)').css('display','block');
        }
    });
    $('.xm-float-right a').hover(function(){
        $(this).find('.up').stop().fadeToggle(300);
        $(this).find('.code').fadeToggle(300);
    });
</script>