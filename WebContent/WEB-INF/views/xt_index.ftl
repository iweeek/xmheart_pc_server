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
              <#list secondColList as key, value>
            	<#if key == "认证中心">
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
            <a href="" target="_blank" class="firstA"><em>示范中心</em><i class="style02"></i><span></span></a>
            <div class="QMSub QMSubMenus" style="top: -73px; display: none;">
              <ul>
              <#list secondColList as key, value>
            	 <#if key== "示范中心" >
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
            <a href="DutyTime.html" class="firstA"><em>胸痛中心动态</em><i class="style03"></i><span></span></a>
            <div class="QMSub QMSubMenus" style="top: -134px; display: none;">
              <ul>
              <#list secondColList as key, value>
              	<#if key == "胸痛中心动态" >
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
        <div class="notice notice01">
          <a href="XTindex-list.html" class="more">更多</a>
          <div class="title"><em>最新公告</em><span>Latest Announcement</span></div>
          <div class="first">
            <a href="" id="ANoticeFirst" target="_blank" title="2017年7月29日（周六）、7月30日（周日）出诊医师排班表">
              <img src="images/pic_005.jpg" class="load" width="126" height="76" original="images/pic_005.jpg" style="display: block;"></a>
              <div>
                <span>2017-07-21</span>
                <a href="" title="2017年7月29日（周六）、7月30日（周日）出诊医师排班表" target="_blank">2017年7月29日（周六）、7月30日（周日）出诊医师排班表</a>
              </div>
              <div class="clear"></div>
          </div>
          <ul>
            <li>
              <span>2017-07-14</span>
              <a target="_blank" href="" title="2017年7月22日（周六）、7月23日（周日）出诊医师排班表">2017年7月22日（周六）、7月23日（周日）出诊医师排班表</a>
            </li>
            <li>
              <span>2017-07-07</span>
              <a target="_blank" href="" title="2017年7月15日（周六）、7月16日（周日）出诊医师排班表">2017年7月15日（周六）、7月16日（周日）出诊医师排班表</a>
            </li>
            <li>
              <span>2017-07-01</span>
              <a target="_blank" href="" title="2017年7月8日（周六）、7月9日（周日）出诊医师排班表">2017年7月8日（周六）、7月9日（周日）出诊医师排班表</a>
            </li>
          </ul>
        </div>
        <div class="notice notice02">
          <a href="XTindex-list.html" class="more">更多</a>
          <div class="title"><em>快讯</em><span>Hospital News</span></div>
          <div class="first">
            <a href="" id="ANewsFirst" target="_blank" title="综合简讯"><img src="pic/pic_005.jpg" class="load" width="126" height="76" original="pic/pic_005.jpg" style="display: block;"></a>
            <div>
              <span>2017-07-25</span>
              <a href="" title="综合简讯" target="_blank">综合简讯</a>
            </div>
            <div class="clear"></div>
          </div>
          <ul>
            <li>
              <span>2017-07-25</span>
              <a target="_blank" href="" title="厦门市约有30多万市民患高血压">厦门市约有30多万市民患高血压</a>
            </li>
            <li>
              <span>2017-07-25</span>
              <a target="_blank" href="" title="厦门市约有30多万市民患高血压">厦门市约有30多万市民患高血压</a>
            </li>
            <li>
              <span>2017-07-25</span>
              <a target="_blank" href="" title="厦门市约有30多万市民患高血压">厦门市约有30多万市民患高血压</a>
            </li>
          </ul>
        </div>
      </div>
      <div class="clear"></div>
    </div>
	</div>
<#include "./fragments/_footer.ftl">
