 <#include "./fragments/_header.ftl"> 
	<div class="xm-main">
		<div class="xm-container">
			<div class="xm-banner-slide">
				<div class="swiper-container" id="bannerSwiper">
			    <div class="swiper-wrapper">
		        <div class="swiper-slide"><a href="${index.bannerImage1ActionUrl}"><img src="${index.bannerImage1Url}" alt=""></a></div>
		        <div class="swiper-slide"><a href="${index.bannerImage2ActionUrl}"><img src="${index.bannerImage2Url}" alt=""></a></div>
		        <div class="swiper-slide"><a href="${index.bannerImage3ActionUrl}"><img src="${index.bannerImage3Url}" alt=""></a></div>
			    </div>
			    <div class="swiper-pagination"></div>
				</div>
			</div>
			<div class="xm-info">
				<div class="xm-online-service">
					<h5 class="online-service-title">在线预约</h5>
					<ul class="online-service-list">
						<li><a href="http://www.xmsmjk.com/urponline"><img src="img/index/online-service-list1.png" alt=""><span>预约挂号</span></a></li>
						<li><a href="#"><img src="img/index/online-service-list2.png" alt=""><span>体检中心</span></a></li>
						<li><a href="http://www.xmsmjk.com/UrpOnline/Home/Hospital/182"><img src="img/index/online-service-list3.png" alt=""><span>门诊排班</span></a></li>
						<li><a href="#"><img src="img/index/online-service-list4.png" alt=""><span>报告查询</span></a></li>
						<li><a href="http://oa.xmheart.com/xzzx"><img src="img/index/online-service-list5.png" alt=""><span>院内办公</span></a></li>
						<li><a href="#"><img src="img/index/online-service-list4.png" alt=""><span>暂时待定</span></a></li>
					</ul>
				</div>
				<div class="xm-notice">
					<div class="swiper-container" id="noticeSwiper">
				    <div class="swiper-wrapper">
				        <div class="swiper-slide">
				        	<h5 class="xm-notice-title"><span class="xm-notice-tag">媒体看厦心</span>王焱：用爱心和医术筑起“心”的健康</h5>
							<p class="xm-notice-info">医生、教师、记者、工程师、演员、运动员，第五批厦门市拔尖人才分布在全市50多个单位，涉及社会、经济、文化、教育、卫生、体育等不同行业，他们在各自领域中做出杰出业绩成为熠熠发光的明星，他们在不同的岗位上为厦门新一轮跨越式发展贡献着智慧和汗水。</p>
				        </div>
				        <div class="swiper-slide">Slide 2</div>
				        <div class="swiper-slide">Slide 3</div>
				    </div>
				    <div class="swiper-pagination"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- banner -->
	<div class="xm-banner">
		<div class="xm-container">
			<a href="xtIndex" target="_blank" class="xm-banner-list xm-list1">
				<div class="list-info">
					<h3 class="list-info-title">胸痛中心</h3>
					<p class="list-info-desc">迅速定位您的问题</p>
				</div>
			</a>
			<a href="#" class="xm-banner-list xm-list2">
				<div class="list-info">
					<h3 class="list-info-title">院务公开</h3>
					<p class="list-info-desc">了解最新医院公告</p>
				</div>
			</a>
			<a href="#" class="xm-banner-list xm-list3">
				<div class="list-info">
					<h3 class="list-info-title">医院导航</h3>
					<p class="list-info-desc">快速找到我们</p>
				</div>
			</a>
			<a href="#" class="xm-banner-list mr-0 xm-list4">
				<div class="list-info">
					<h3 class="list-info-title">下载专区</h3>
					<p class="list-info-desc">为您特殊定制</p>
				</div>
			</a>
		</div>
	</div>

<#include "./fragments/_footer.ftl">
