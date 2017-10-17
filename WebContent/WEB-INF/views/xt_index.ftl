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
            <a href="ArticleList-54.html" class="firstA">
              <em>认证中心</em>
              <i class="style01"></i>
              <span></span>
            </a>
            <div class="QMSub QMSubMenus" style="top: -12px; display: none;">
              <ul>
                <li>
                  <a href="/newsDetail?id=79" title="胸痛中心简介">胸痛中心简介<span>进入</span></a>
                </li>
                <li>
                  <a href="/newsDetail?id=79" title="胸痛认证标准">胸痛认证标准<span>进入</span></a>
                </li>
                <li>
                    <a href="/newsDetail?id=79" title="申报胸痛中心">申报胸痛中心<span>进入</span></a>
                </li>
                <li>
                    <a href="/col/82" title="在线视频学习">在线视频学习<span>进入</span></a>
                </li>
                <li class="second">
                    <a href="/newsDetail?id=256" title="规范化建设参考资料">规范化建设参考资料<span>进入</span></a>
                    <div class="third-menus">
                    		<ul>
                    			<li><a href="/newsDetail?id=256" title="在线视频学习">文件<span>进入</span></a></li>
                    			<li><a href="/newsDetail?id=256" title="在线视频学习">流程图<span>进入</span></a></li>
                    			<li><a href="/newsDetail?id=256" title="在线视频学习">培训教育<span>进入</span></a></li>
                    		</ul>
                    </div>
                </li>
              </ul>
              <div class="clear"></div>
            </div>
          </li>
          <li class="first">
            <a href="" target="_blank" class="firstA"><em>示范中心</em><i class="style02"></i><span></span></a>
            <div class="QMSub QMSubMenus" style="top: -73px; display: none;">
              <ul>
                <li><a href="">申请流程<span>进入</span></a></li>
                <li><a href="">注意事项<span>进入</span></a></li>
                <li><a href="">申请表下载<span>进入</span></a></li>
              </ul>
              <div class="clear"></div>
            </div>
          </li>
          <li class="first">
            <a href="DutyTime.html" class="firstA"><em>胸痛中心动态</em><i class="style03"></i><span></span></a>
            <div class="QMSub QMSubMenus" style="top: -134px; display: none;">
              <ul>
                <li>
                  <a href="/newsDetail?id=256" title="新闻快讯">新闻快讯<span>进入</span></a>
                </li>
                <li><a href="/newsDetail?id=256" title="会议邀请">会议邀请<span>进入</span></a></li>
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
