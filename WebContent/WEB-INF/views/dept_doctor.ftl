<#include "./fragments/_header.ftl">
	<!-- list container -->
	<div class="list-container">
    <!-- banner -->
    <div class="BaseMark PartBanner">
      <div class="bannerLeft">
        <img src="${dept.imageUrl}" alt="${dept.name}">
        <span class="import1"></span>
      </div>
      <div class="bannerRight">
        <div class="righttitle">
          <h1>${dept.name}</h1>
          <div class="btns">
            <a href="Telephone.html">
              <img src="./img/list/part_tel.png" width="46" height="45" title="其他科室电话" alt="其他科室电话">
              <em>其他科室电话</em>
            </a>
            <a href="Distribution.html" class="last">
              <img src="./img/list/part_map.png" width="46" height="45" title="科室地图查看" alt="科室地图查看">
              <em>科室地图查看</em>
            </a>
          </div>
          <div class="clear"></div>
        </div>
        <div class="rightbtn">
          <a href="javascript:;" id="AOnDuty" class="green">出诊安排</a>
          <a class="blue" href="expert-nav.html">返回科室导航</a>
        </div>
        <div class="righttel">
          <h2 id="H2Tel"></h2>
          <h3>本科室电话 Telephone Number</h3>
        </div>
      </div>
      <div class="clear"></div>
    </div>
    <!-- col -->
    <div class="BaseMark PartIntro">
      <div class="introLeft">
        <div class="lefttitle">科室栏目<span>Column sections</span></div>
        <ul>
          <li>
            <a href="office-info.html">缺乏栏目</a>
          </li>
          <li id="LIExpertInfo2">
            <a href="expert-info.html">缺乏栏目</a>
          </li>
          <li>
            <a href="OfficeNewsList-11-1.html" title="工作动态">缺乏栏目</a>
          </li>
          <li>
            <a href="OfficeNewsList-11-4.html" title="医疗设备">缺乏栏目</a>
          </li>
        </ul>
        <ul class="margRt">
          <li>
            <a href="OfficeNewsList-11-2.html" title="健康教育">缺乏栏目</a>
          </li>
        </ul>
        <div class="clear"></div>
      </div>
      <div class="introRight">
        <div class="left">
          <img src="./img/list/ksjj-1.gif" width="72" height="105">
          <h3>科室简介</h3>
          <h4>INTRODUCTION</h4>
        </div>
        <div class="right">
          <h1 id="H1Type">国家临床重点专科</h1>
          <#if dept.intro?length gt 250>
          	<p id="PDescription">${dept.intro[0..250]}......</p>
          <#else>
          	<p id="PDescription">${dept.intro}</p>
          </#if>
          <div class="rightbottom"><a href="${dept.url}" class="more">MORE</a></div>
        </div>
     	<div class="clear"></div>
    </div>
    <!-- doctor -->
    <div id="AreaDoctors" class="BaseMark doctorsBase partDoctor">
      <div class="toolsPart">
        <div class="title">专家介绍<span>Expert Introduction</span></div>
        <div class="tools">
          <a href="ExpertInfo-11.html" class="Bmore">MORE 》》</a>
          <a href="javascript:;" class="Aprev"></a>
          <a href="javascript:;" class="Anext"></a>
        </div>
        <div class="clear"></div>
      </div>
      <div class="contents">
        <ul data-num="0">
        <#list dept.doctors as k>
	        <li>
	            <a href="${k.url}" class="img">
	              <img src="${k.imageUrl}" alt="${k.name}" title="${k.name}" width="120" height="162"></a>
	              <a href="Doctor-712.html" class="name">${k.name}</a>
	              <a href="Doctor-712.html" class="office">${k.deptName}</a>
	              <a href="Doctor-712.html" class="post">${k.professionalTitle}</a>
	              <a href="Doctor-712.html" class="btn more">详细</a>
	              <a href="NewsDetail-449.html" target="_blank" class="btn date">预约</a>
	        </li>
	    </#list>
          <!--<li>
            <a href="Doctor-712.html" class="img">
              <img src="uploadfiles/thumb/2013102215334198.jpg" alt="马利军" title="马利军" width="120" height="162"></a>
              <a href="Doctor-712.html" class="name">马利军</a>
              <a href="Doctor-712.html" class="office">呼吸内科</a>
              <a href="Doctor-712.html" class="post">主任医师，科主任</a>
              <a href="Doctor-712.html" class="btn more">详细</a>
              <a href="NewsDetail-449.html" target="_blank" class="btn date">预约</a>
          </li>
          <li><a href="Doctor-714.html" class="img">
            <img src="uploadfiles/thumb/2013102215395834.jpg" alt="马厚志" title="马厚志" width="120" height="162"></a>
            <a href="Doctor-714.html" class="name">马厚志</a>
            <a href="Doctor-714.html" class="office">呼吸内科</a>
            <a href="Doctor-714.html" class="post">主任医师</a>
            <a href="Doctor-714.html" class="btn more">详细</a>
            <a href="NewsDetail-449.html" target="_blank" class="btn date">预约</a>
          </li>-->
        </ul>
        <div class="hackR"></div>
        <div class="hackL"></div>
      </div>
    </div>
    <!-- job -->
    <div class="BaseMark partDoctor jobWork">
      <div class="toolsPart">
        <div class="title">工作动态<span></span></div>
        <div class="tools"><a href="OfficeNewsList-11-1.html" title="工作动态" class="Bmore">MORE 》》</a></div>
        <div class="clear"></div>
      </div>
      <div class="contents">
        <ul>
          <li class="first">
            <a href="OfficeNewsDetail-3671.html" class="ydxx" target="_blank" title="卡氏肺孢子菌肺炎的病原学诊断">阅读详细</a>
            <div class="neir">
              <h4>2015-05-26</h4>
              <a href="OfficeNewsDetail-3671.html" target="_blank" title="卡氏肺孢子菌肺炎的病原学诊断" class="title">卡氏肺孢子菌肺炎的病原学诊断</a>
              <p>肺孢子菌肺炎（PCP），又称卡氏肺孢子虫肺炎，卡氏肺囊虫……</p>
            </div>
          </li>
          <li>
            <a href="OfficeNewsDetail-2932.html" class="ydxx" target="_blank" title="河南省首个肺癌早期诊断门诊成立">阅读详细</a>
            <div class="neir">
              <h4>2014-11-04</h4>
              <a href="OfficeNewsDetail-2932.html" target="_blank" title="河南省首个肺癌早期诊断门诊成立" class="title">河南省首个肺癌早期诊断门诊成立</a>
              <p>为进一步提高普通人群对肺部结节（肿瘤）早期诊断的认识，由……</p>
            </div>
          </li>
        </ul>
        <div class="clear"></div>
      </div>
    </div>
    <!-- visit -->
    <div id="AreaDuty" class="BaseMark visitDate">
      <div class="title">出诊安排<em>Visits Time</em><span></span></div>
      <div class="visitList">
        <div class="title">
          <div class="wide">星期三 <em>2017/7/26</em><span class="green">上午</span><span class="blue">下午</span></div>
          <div class="wide">星期四 <em>2017/7/27</em><span class="green">上午</span><span class="blue">下午</span></div>
          <div>星期五 <em>2017/7/28</em><span class="green">上午</span><span class="blue">下午</span></div>
          <div>星期六 <em>2017/7/29</em><span class="green">上午</span><span class="blue">下午</span></div>
          <div>星期日 <em>2017/7/30</em><span class="green">上午</span><span class="blue">下午</span></div>
          <div>星期一 <em>2017/7/31</em><span class="green">上午</span><span class="blue">下午</span></div>
          <div>星期二 <em>2017/8/1</em><span class="green">上午</span><span class="blue">下午</span></div>
        </div>
      </div>
    </div>
	</div>
<#include "./fragments/_footer.ftl">
