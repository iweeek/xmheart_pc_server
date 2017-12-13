<#include "./fragments/_header.ftl">
<!-- list container -->
<div class="breadcrumb">
    <div class="xm-container">
       <span class="icon"></span>您当前所在位置 <a href="index">首页</a> &gt <a href="doctorDept">名医名科</a> 
    </div>
</div>
<div class="list-container">
		<div class="list-main">
		<#list depts as dept>
        <!-- office-doctor start-->
        <div class="officesBase BaseMark">
            <div class="toolsBase">
                <div class="title">
                    <em>${dept.name}</em> <span>${dept.nameEn}</span>
                </div>
                <div class="tools">
                    <a href="javascript:;" class="ASwitch" id="OSearchSwitch">快速查找科室</a>
                    <a href="DepartmentNav.html" class="Amore">更多 &gt;&gt;</a>
                    <a href="javascript:;" class="Aprev"></a>
                    <a href="javascript:;" class="Anext"></a>
                </div>
                <div class="clear"></div>
            </div>
            <div class="contents">
                <div class="contentsOffice">
                    <!-- <i class="ico01"></i> -->
                    <div class="img animated">
                        <img alt="${dept.name}" src="${dept.imageUrl}" width="80" height="80">
                    </div>
                    <a href="/deptDoctor?id=${dept.id}&deptCode=&doctorCode=&status=0&workTime=0" title="${dept.name}" class="office">${dept.name}</a>
                    <div class="dept-intro">
                        <#if dept.brief?length lt 50>
                                    &#8195;&#8195;${dept.brief}......
                                    <#else>
                                    &#8195;&#8195;${dept.brief[0..50]}......
                                    <a href="/deptDoctor?id=${dept.id}&deptCode=&doctorCode=&status=0&workTime=0" title="${dept.name}" class="btn more">查看详细</a>
                        </#if>
                    </div>
                   <!-- <p>${dept.brief}</p>
                    <a href="deptDetail?id=${dept.id}" title="${dept.name}" class="btn more">查看详细</a> -->
                    <!--<a href="ExpertInfo-11.html" title="心内科医生" class="btn doctor">科室专家</a>-->
                </div>
                <div class="contentsDoctor swiper-container">
                    <ul data-num="0" class="swiper-wrapper">
                        <#list doctors as doctor>
                        <#if doctor.deptId == dept.id>
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
                                <#if doctor.brief?length lt 35>
                                &#8195;&#8195;${doctor.brief}......
                                <#else>
                                &#8195;&#8195;${doctor.brief[0..35]}......
                                <a href="doctorDetail?id=${doctor.id}&deptCode=&doctorCode=${doctor.hisId}
                                    &status=2&workTime=0" title="${dept.name}" class="show-more a_post">查看详细</a>
                                </#if>
                            </div>
                            <!-- <a href="doctorDetail?id=${doctor.id}" title="${doctor.name}" target="_blank" class="post">${doctor.duty}</a> -->
                            <!--<a href="deptDetail?id=${dept.id}" title="${dept.name}" target="_blank" class="btn more">详细</a>
                            <a href="./order-detail.html" target="_blank" class="btn date">预约</a>-->
                        </li>
                        </#if>
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
        </div>
        <!-- office-doctor end-->
    </#list>
		</div>
</div>

<#include "./fragments/_footer.ftl">
