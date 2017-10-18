<#include "./fragments/_header.ftl"> 
	<!-- list container -->
	<div class="breadcrumb">
		<div class="xm-container xt-container">
			<span class="icon"></span><a href="#">您当前所在位置 胸痛中心</a>
		</div>
	</div>
	<div class="list-container">
		<div class="bannerBase BaseMark">
      <div class="quickMenus">
        <ul class="firstUl">
        
          <li class="first">
          <#list secondColList as key, value>
                <#if key == "认证中心">
                <#list xtfirstColumns as xtkey, xtvalue>
                <#if xtkey == key>
            <a href="${xtvalue}" class="firstA">
              <em>${xtkey}</em>
                </#if>
                </#list>
              <i class="style01"></i>
              <span></span>
            </a>
            
            <div class="QMSub QMSubMenus" style="top: -12px; display: none;">           
               <ul>
              
            		<#list value as secCol >
            			<#list thirdColList as key1, value1>     		
                			<#if key1 == secCol.columnName>
                			<li class="second">
                				<a href="${secCol.url}" title="${secCol.columnName}">${secCol.columnName}<span>进入</span></a>             			
                				<div class="third-menus">
                					<ul>
                						<#list value1 as thirdCol>
                						<li><a href="${thirdCol.url}" title="${thirdCol.columnName}">${thirdCol.columnName}<span>进入</span></a></li>
                						</#list>
                					<ul>
                				</div>
                			</li>          		
                			<#else>
                			<li>
               					<a href="${secCol.url}" title="${secCol.columnName}">${secCol.columnName}<span>进入</span></a>
                			</li>
                			</#if>
                		</#list>
                	</#list>
                </#if>
              </#list>
              </ul>
              <div class="clear"></div>
            </div>
          </li>
          <li class="first">
          <#list secondColList as key, value>
                 <#if key== "示范中心" >
                 <#list xtfirstColumns as xtkey, xtvalue>
                <#if xtkey == key>
            <a href="${xtvalue}" target="_blank" class="firstA"><em>${xtkey}</em>
            </#if>
                </#list>
            <i class="style02"></i><span></span></a>
            <div class="QMSub QMSubMenus" style="top: -73px; display: none;">
              <ul>
              
             		 <#list value as secCol >
               		 <li>
                	  <a href="${secCol.url}">${secCol.columnName}<span>进入</span></a>
              		 </li>
              		 </#list>
              	 </#if>
              </#list>
              </ul>
              <div class="clear"></div>
            </div>
          </li>
          <li class="first">
          <#list secondColList as key, value>
                <#if key == "胸痛中心动态" >
                <#list xtfirstColumns as xtkey, xtvalue>
                <#if xtkey == key>
            <a href="${xtvalue}" class="firstA"><em>${xtkey}</em>
            </#if>
                </#list>
                <i class="style03"></i><span></span></a>
            <div class="QMSub QMSubMenus" style="top: -134px; display: none;">
              <ul>
              
             	 <#list value as secCol >
                	<li>
                 	 <a href="${secCol.url}" title="${secCol.columnName}">${secCol.columnName}<span>进入</span></a>
               	 	</li>
                 </#list>
                </#if>
         	  </#list>
              </ul>            
              <div class="clear"></div>
            </div>
          </li>
        </ul>
      </div>
      <div class="Banners">
        <div class="swiper-container xt-swiper" id="xtSwiper">
          <div class="swiper-wrapper">
              <div class="swiper-slide"><img src="img/slider1.jpg" alt=""></div>
              <div class="swiper-slide">Slide 2</div>
              <div class="swiper-slide">Slide 3</div>
          </div>
          <div class="swiper-pagination"></div>
        </div>
      </div>
    </div>
    <div class="NewsBase BaseMark">
      <div class="noticeBase">
        
        <#list navMap as key, news>
        <#if key == "胸痛中心简介">
        <div class="notice notice01">
          <a href="XTindex-list.html" class="more">更多</a>
          <div class="title"><em>${key}</em><span>Latest Announcement</span></div>
            <#list news as new>
        	<#if new?index == 0>
            <div class="first">
            <a href="${new.url}" id="ANoticeFirst" target="_blank" title="${new.articleTitle}">
              <img src="image/pic_005.jpg" class="load" width="126" height="76" original="image/pic_005.jpg" style="display: block;"></a>
              <div>
                <span>${new.publishTime?date}</span>
                <a href="${new.url}" title="${new.articleTitle}" target="_blank">${new.articleTitle}</a>
              </div>
              <div class="clear"></div>
          </div>
          <ul>
          <#else>
            <li>
              <span>${new.publishTime?date}</span>
              <a target="_blank" href="${new.url}" title="${new.articleTitle}">${new.articleTitle}</a>
            </li>
            </#if>
           </#list>
          </ul>
        </div>
        </#if>
        </#list>
        
        <#list navMap as key, news>
        <#if key == "胸痛认证标准">
        <div class="notice notice02">
          <a href="XTindex-list.html" class="more">更多</a>
          <div class="title"><em>${key}</em><span>Hospital News</span></div>
          <#list news as new>
        	<#if new?index == 0>
          <div class="first">
            <a href="${new.url}" id="ANewsFirst" target="_blank" title="${new.articleTitle}"><img src="pic/pic_005.jpg" class="load" width="126" height="76" original="pic/pic_005.jpg" style="display: block;"></a>
            <div>
              <span>${new.publishTime?date}</span>
              <a href="${new.url}" title="${new.articleTitle}" target="_blank">${new.articleTitle}</a>
            </div>
            <div class="clear"></div>
          </div>
          <ul>
          <#else>
            <li>
              <span>${new.publishTime?date}</span>
              <a target="_blank" href="${new.url}" title="${new.articleTitle}">${new.articleTitle}</a>
            </li>
            </#if>
           </#list>        
          </ul>
        </div>
        </#if>
        </#list>
      </div>
      <div class="clear"></div>
    </div>
	</div>
<#include "./fragments/_footer.ftl">
