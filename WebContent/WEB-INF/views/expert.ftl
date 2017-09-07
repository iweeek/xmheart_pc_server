<#include "./fragments/_header.ftl"> 
	<!-- list container -->
	<div class="breadcrumb">
		<div class="xm-container">
			<a href="#">首页</a><i>/</i><span>名医名科</span>
		</div>
	</div>
	<div class="list-container">
		<div class="list-main">
      <!-- doctor -->
			<div class="doctorsBase BaseMark">
        		<div class="toolsBase">
          			<div class="title">
            			<em>专家介绍</em>
            			<span>Expert Introduction</span>
          			</div>
          			<div class="tools">
	            		<a href="javascript:;" class="ASwitch" id="DSearchSwitch">快速查找</a>
	            		<form method="get" class="search" action="http://www.hnsrmyy.net/Search.html" onsubmit="return Kunyi.CheckSearchFrom()">
	              		<input type="hidden" name="Type" value="2">
	              		<input type="text" name="SearchWords" placeholder="请输入医生名字" class="animated" value="" autocomplete="off" maxlength="28">
	              		<input class="btn" type="submit" value="">
	            		</form>
	            		<a href="DepartmentNav.html" class="Amore">更多 &gt;&gt;</a>
			            <a href="javascript:;" class="Aprev"></a>
			            <a href="javascript:;" class="Anext"></a>
          			</div>
          			<div class="clear"></div>
        		</div>
		        <div class="contents swiper-container" id="expertSwiper">
		          <ul data-num="0" class="swiper-wrapper">
		          	<#list experts as expert>
			            <li class="swiper-slide">
			              <a href="${expert.url}" title="${expert.name}" target="_blank" class="img">
			                <img alt="${expert.name}" title="${expert.name}" src="${expert.imageUrl}" width="120" height="162">
			              </a>
			              <a href="${expert.url}" title="${expert.name}" target="_blank" class="name">${expert.name}</a>
			              <a href="Office-30.html" title="厦门大学附属心血管病医院" target="_blank" class="office">厦门大学附属心血管病医院</a>
			              <a href="${expert.url}" title="${expert.name}" target="_blank" class="post">
			              	<#if expert.duty != "">
			              	${expert.duty}，
			              	</#if>
			              	<#if expert.grade != "">
			              	${expert.grade}，
			              	</#if>
			              	<#if expert.professionalTitle != "">
			              	${expert.professionalTitle}
			              	</#if>
			              	</a>
			              <a href="${expert.url}" title="${expert.name}" target="_blank" class="btn more">详细</a>
			              <a href="./order-detail.html" target="_blank" class="btn date">预约</a>
			            </li>
		            </#list>
		          </ul>
		          <div class="hackR"></div>
		          <div class="hackL"></div>
		        </div>
		        <div class="DFastSearch">
		          <div class="DFTitle">
		            <label>按医生姓名首字母查找</label>
		            <button class="animated">关闭查找</button>
		          </div>
		          <div class="DFContent">
		            <div class="DListBase"></div>
		            <div class="IndexWords">
		              <ul>
		                <li data-index="0">A</li>
		                <li data-index="1" class="other">B</li>
		                <li data-index="2">C</li>
		                <li data-index="3" class="other">D</li>
		                <li data-index="4">E</li>
		                <li data-index="5" class="other">F</li>
		                <li data-index="6">G</li>
		                <li data-index="7" class="other">H</li>
		                <li data-index="8">I</li>
		                <li data-index="9" class="other">J</li>
		                <li data-index="10">K</li>
		                <li data-index="11" class="other">L</li>
		                <li data-index="12">M</li>
		              </ul>
		              <ul>
		                <li data-index="13" class="other">N</li>
		                <li data-index="14">O</li>
		                <li class="other" data-index="15">P</li>
		                <li data-index="16">Q</li>
		                li data-index="17" class="other">R</li>
		                <li data-index="18">S</li>
		                <li data-index="19" class="other">T</li>
		                <li data-index="20">U</li>
		                <li data-index="21" class="other">V</li>
		                <li data-index="22">W</li>
		                <li data-index="23" class="other">X</li>
		                <li data-index="24">Y</li>
		                <li data-index="25" class="other">Z</li>
		              </ul>
		            </div>
		          </div>
		        </div>
      		</div>
      <!--doctor-->
	      <div class="officesBase BaseMark">
	        <div class="toolsBase">
	          <div class="title">
	            <em>重点专科</em>
	            <span>Key Specialty</span>
	          </div>
	          <div class="tools">
	            <a href="javascript:;" class="ASwitch" id="OSearchSwitch">快速查找科室</a>
	            <a href="DepartmentNav.html" class="Amore">更多 &gt;&gt;</a>
	            <a href="javascript:;" class="Aprev"></a>
	            <a href="javascript:;" class="Anext"></a>
	          </div>
	          <div class="clear"></div>
	        </div>
	        <div class="contents swiper-container" id="officeSwiper">
	          <ul data-num="0" class="swiper-wrapper">
	          	<#list depts as dept>
		            <li class="swiper-slide">
		              <i class="ico01"></i>
		              <div class="img animated">
		                <img alt="心内科" src="pic/pic_007.png" width="80" height="80">
		              </div>
		              <a href="${dept.url}" title="${dept.name}" class="office">${dept.name}</a>
		              <#--  <#if dept.intro?length gt 20>
						<p>${dept.intro[0..20]}</p>
					  <#else>
						<p>${dept.intro}</p>
					  </#if>-->
					  <p>厦门大学附属心血管病医院心内科是国家临床重点专科，卫生部国家级心血管疾病介入培训基地，……</p>
		              <a href="${dept.url}" title="${dept.name}" class="btn more">查看详细</a>
		              <a href="ExpertInfo-11.html" title="心内科医生" class="btn doctor">科室专家</a>
		            </li>
	            </#list>
	          </ul>
	        </div>
			<div class="hackR"></div>
			<div class="hackL"></div>
	        <div class="hiddenLineR"></div>
	        <div class="hiddenLineL"></div>
	        <div class="OFastSearch">
	          <div class="OFTitle">
	            <label>快速查找科室</label>
	            <button class="animated">返回重点科室</button>
	          </div>
	          <div class="OFContent">
	            <div class="OListBase"></div>
	          </div>
	        </div>
	      </div>
		</div>
	</div>
<#include "./fragments/_footer.ftl">
