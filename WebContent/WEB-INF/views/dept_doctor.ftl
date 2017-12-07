<#include "./fragments/_header.ftl">
	<!-- list container -->
	<div class="list-container">
    <!-- banner -->
    <div class="BaseMark PartBanner PartIntro">
      <div class="bannerLeft1">
            <div class="contentsOffice">
                    <!-- <i class="ico01"></i> -->
                    <div class="img animated">
                        <img alt="${dept.name}" src="${dept.imageUrl}" width="80" height="80">
                    </div>
                    <a href="deptDoctor?id=${dept.id}&type=0&workTime=0" title="${dept.name}" class="office">${dept.name}</a>
                    <div class="dept-intro">
                        <#if dept.brief?length lt 60>
                                &#8195;&#8195;${dept.brief}......
                                <#else>
                                &#8195;&#8195;${dept.brief[0..59]}......
                                <a href="/deptDetail?id=${dept.id}" title="${dept.name}" class="btn more">查看详细</a>
                        </#if>
                    </div>
            </div>
      </div>
      <div class="bannerLeft">
        <img src="${index.bannerImage1Url}" alt="${dept.name}">
        <span class="import1"></span>
      </div>
      <div class="bannerRight">
        <div class="righttitle">
         <!-- <h1><a href="deptDoctor?id=1&deptCode=&doctorCode=&status=0&workTime=0" title="心血管内科" class="office">心血管内科</a></h1>
          <h1><a href="deptDoctor?id=2&&deptCode=&doctorCode=&status=0&workTime=0" title="心血管外科" class="office">心血管外科</a></h1>
          <h1><a href="deptDoctor?id=3&&deptCode=&doctorCode=&status=0&workTime=0" title="体检中心" class="office">体检中心</a></h1>
          
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
          -->
          <div class="clear"></div>
        </div>
        <div class="rightbtn">
          <a href="deptDoctor?id=1&deptCode=&doctorCode=&status=0&workTime=0" title="心血管内科" class="office blue">心血管内科</a>
          <a href="deptDoctor?id=2&deptCode=&doctorCode=&status=0&workTime=0" title="心血管外科" class="office green">心血管外科</a>
          <a href="deptDoctor?id=3&deptCode=&doctorCode=&status=0&workTime=0" title="体检中心" class="office blue">体检中心</a>
          <a href="#AreaDuty" id="AOnDuty" class="green">出诊安排</a>
          <a class="blue" href="/doctorDept">返回科室导航</a>
        </div>
        <!--
        <div class="righttel">
          <h2 id="H2Tel"></h2>
          <h3>本科室电话 Telephone Number</h3>
        </div>
        -->
      </div>
      <div class="clear"></div>
    </div>
    <!-- doctor -->
    <div id="AreaDoctors" class="BaseMark doctorsBase partDoctor officesBase">
      <div class="toolsPart">
        <div class="title">专家介绍<span>Expert Introduction</span></div>
        <div class="tools">
          <a href="javascript:;" class="Aprev"></a>
          <a href="javascript:;" class="Anext"></a>
        </div>
        <div class="clear"></div>
      </div>
      
      <div class="contents">
        <!--<ul data-num="0">-->
        <div class="deptDoctor swiper-container">
            <ul data-num="0" class="swiper-wrapper">
    	       <#list dept.doctors as doctor>
                <li class="swiper-slide" style="overflow:hidden;">
                    <a href="doctorDetail?id=${doctor.id}&deptCode=&doctorCode=${doctor.hisId}
                        &status=2&workTime=0" title="${doctor.name}" target="_blank" class="img a_post">
                        <img alt="${doctor.name}" title="${doctor.name}"
                            src="${doctor.imageUrl}"
                            width="120" height="162"/>
                    </a>
                    <a href="doctorDetail?id=${doctor.id}&deptCode=&doctorCode=${doctor.hisId}
                        &status=2&workTime=0" title="${doctor.name}" target="_blank" class="name a_post">${doctor.name}</a>
                    <!--<a href="Office-30.html" title="厦门大学附属心血管病医院" target="_blank" class="office">厦门大学附属心血管病医院</a>-->
                    <br/>
                    <a href="doctorDetail?id=${doctor.id}&deptCode=&doctorCode=${doctor.hisId}
                        &status=2&workTime=0" title="${doctor.name}" target="_blank" class="post a_post">${doctor.professionalTitle} &nbsp;${doctor.grade}</a>
                    <div class="doctor-intro">
                        <#if doctor.brief?length lt 40>
                        &#8195;&#8195;${doctor.brief}......
                        <#else>
                        &#8195;&#8195;${doctor.brief[0..40]}......
                        <a href="doctorDetail?id=${doctor.id}&deptCode=&doctorCode=${doctor.hisId}
                            &status=2&workTime=0" title="${dept.name}" class="show-more a_post">查看详细</a>
                        </#if>
                    </div>
                    <!-- <a href="doctorDetail?id=${doctor.id}" title="${doctor.name}" target="_blank" class="post">${doctor.duty}</a> -->
                    <!--<a href="deptDetail?id=${dept.id}" title="${dept.name}" target="_blank" class="btn more">详细</a>
                    <a href="./order-detail.html" target="_blank" class="btn date">预约</a>-->
                </li>
                </#list>
                <li class="swiper-slide">
                    <a href="doctorDetail?id=" title="" target="_blank" class="img">
                    </a>
                    <a href="" title="" target="_blank" class="name"></a>
                    <!--<a href="Office-30.html" title="厦门大学附属心血管病医院" target="_blank" class="office">厦门大学附属心血管病医院</a>-->
                    <br/>
                    <a href="" title="" target="_blank" class="post"></a>
                    <a href="" title="" target="_blank" class="post"></a>
                    <a href="" title="" target="_blank" class="post"></a>
                    <!--<a href="deptDetail?id=${dept.id}" title="${dept.name}" target="_blank" class="btn more">详细</a>
                    <a href="./order-detail.html" target="_blank" class="btn date">预约</a>-->
                </li>
    	        </ul>
            </div>
       
        </div>
        <!-- </ul>
        <div class="hackR"></div>
        <div class="hackL"></div>
      </div>  -->
    </div>
    <!-- job -->
    <!--
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
    -->
    <!-- visit -->
    <div id="AreaDuty" class="BaseMark visitDate">
      <div class="title">出诊安排<em>Visits Time</em><span></span></div>
      <div class="visitList">
        <div class="title">
          <#list currentWeek as nameOfWeek, day>
              <div class="wide${nameOfWeek?index} wides">
              ${nameOfWeek}
              <em>${day}</em>
              <span class="green">上午</span><span class="blue">下午</span>
              <#list visits as date, doctorNames>
              <#if date == day>
                  <#list doctorNames as doc>
                  <#if doc?index % 2 == 0> 
                    <span class='col'>${doc}</span>
                  <#else>
                    <span class='col'>${doc}</span>
                  </#if>
                  </#list>
              </#if>
              </#list>
              </div>
          </#list>
         <!-- <div class="wide">星期四 <em>2017/7/27</em><span class="green">上午</span><span class="blue">下午</span></div>
          <div>星期五 <em>2017/7/28</em><span class="green">上午</span><span class="blue">下午</span></div>
          <div>星期六 <em>2017/7/29</em><span class="green">上午</span><span class="blue">下午</span></div>
          <div>星期日 <em>2017/7/30</em><span class="green">上午</span><span class="blue">下午</span></div>
          <div>星期一 <em>2017/7/31</em><span class="green">上午</span><span class="blue">下午</span></div>
          <div>星期二 <em>2017/8/1</em><span class="green">上午</span><span class="blue">下午</span></div> -->
        </div>
      </div>
    </div>
	</div>
<#include "./fragments/_footer.ftl">
