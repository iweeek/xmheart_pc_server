<#include "./fragments/_header.ftl"> 
	<!-- list container -->
	<div class="chestCenterBg"></div>
	<div class="chestContainer">
		<ul class="chestCenter3Col clearfix_n">
			<li>
			<#list secondColList as key, value>
				<#if key == "认证中心">
				<div class="chestListTitle">
					<span class="chestIcon1"></span>
					<#list xtfirstColumns as xtkey, xtvalue>
						<#if xtkey == key>
						<em>${xtkey}</em>
						</#if>
					</#list>
				</div>
				<div class="chestListLink">
					<#list value as secCol>
            			<#list thirdColList as key1, value1>
               				<a href="${secCol.url}" title="${secCol.columnName}">${secCol.columnName}</a>
                		</#list>
                	</#list>
				</div>
				</#if>
			</#list>
			</li>
			
			<li class="chestCenter3Col_li2">
			<#list secondColList as key, value>
				<#if key == "示范中心">
				<div class="chestListTitle">
					<span class="chestIcon2"></span>
					<#list xtfirstColumns as xtkey, xtvalue>
						<#if xtkey == key>
						<em>${xtkey}</em>
						</#if>
					</#list>
				</div>
				<div class="chestListLink top20">
					<#list value as secCol>
            			<#list thirdColList as key1, value1>
               				<a href="${secCol.url}" title="${secCol.columnName}">${secCol.columnName}</a>
                		</#list>
                	</#list>
				</div>
				</#if>
			</#list>
			</li>	
			
			<li>
			<#list secondColList as key, value>
				<#if key == "胸痛中心动态">
				<div class="chestListTitle">
					<span class="chestIcon3"></span>
					<#list xtfirstColumns as xtkey, xtvalue>
						<#if xtkey == key>
						<em>${xtkey}</em>
						</#if>
					</#list>
				</div>
				<div class="chestListLink top20">
					<#list value as secCol>
            			<#list thirdColList as key1, value1>
               			<a href="${secCol.url}" title="${secCol.columnName}">${secCol.columnName}</a>
                		</#list>
                	</#list>
				</div>
				</#if>
			</#list>
			</li>			
		</ul>
		<div class="clear"></div>
		
		<h3 class="chestCenterTitle_30">胸痛中心简介</h3>
		<div class="chestCenterInfo_l">
			<!--<h5>我们的成长故事</h5>-->
			<p>2013年，厦门大学附属心血管病医院在市委市政府的大力支持和市科技局、市卫生计生委的帮助下，设立胸痛中心，牵头启动区域协同胸痛急救网络，并获厦门市重大科技创新平台资助。</p>
			<p>2015年底，该体系再获认可，经中华医学会心血管病学分会下设的中国胸痛中心协会认定，厦门市心血管病医院获批设立“国家胸痛中心区域认证中心”，在全国范围内仅有四家。并于2016年举办“加速推进中国胸痛中心系统化建设”项目区域认证中心启动会，未来三年将与其它三家认证中心共同承担全国千家胸痛中心的认证工作，同时承担华东区域胸痛中心建设的培训、推进重任。</p>
			<p>2017年，在市卫生计生委的组织下，由厦门大学附属心血管病医院牵头的厦门市胸痛中心联盟正式成立，16家厦门市二级以上综合性医院（中医医院）组团建设全市覆盖的胸痛中心。</p>
		</div>
		<div class="chestCenterInfo_r">
			<div class="bannerBase BaseMark">
			  <div class="Banners">
				<div class="swiper-container xt-swiper" id="xtSwiper">
				  <div class="swiper-wrapper">
					  <div class="swiper-slide"><a href="${index.bannerImage1ActionUrl}"><img src="${index.bannerImage1Url}" alt=""></a></div>
					  <div class="swiper-slide"><a href="${index.bannerImage2ActionUrl}"><img src="${index.bannerImage2Url}" alt=""></a></div>
					  <div class="swiper-slide"><a href="${index.bannerImage3ActionUrl}"><img src="${index.bannerImage3Url}" alt=""></a></div>
				  </div>
				  <div class="swiper-pagination"></div>
				</div>
			  </div>
			</div>
		</div>
		<div class="clear"></div>		
	</div>
		
	<div class="newsCenter">
		<h3 class="chestCenterTitle_30">资讯中心</h3>
		<ul class="clearfix_n">
			<#list navMap as key, news>
			<#if key == "胸痛中心简介">
				<#list news as new>
				<#if new?index < 3>
				<li>
					<div class="newsDate">${new.publishTime?string('yyyy-MM-dd')}</div>
					<a class="newsTitle" target="_blank" href="${new.url}" title="${new.articleTitle}">${new.articleTitle}</a>
					<a target="_blank" href="${new.url}" title="${new.brief}">${new.brief}</a>
				</li>
				</#if>
				</#list>
			</#if>
			</#list>
		</ul>
	</div>
	
<#include "./fragments/_footer.ftl">
