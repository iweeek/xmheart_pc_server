<#include "./fragments/_header.ftl">
<div class="breadcrumb">
    <div class="xm-container">
        <span class="icon"></span>您当前所在位置
        <a href="index">首页</a>
        &gt
        <a href="doctorDept">名医名科</a>
        &gt
        <a href="#">医生详情</a>
    </div>
</div>
<div class="list-container">
    <div class="list-main">
        <div class="doctorLeft">
            <img src="${doctor.imageUrl}" id="DThumb" class="DThumb" width="112" height="150"
                alt="${doctor.name}">
            <h3 id="H3Name">${doctor.name}</h3>
            <h4 id="H4Position">${doctor.professionalTitle}</h4>
            <a href="${doctor.appointmentUrl}" target="_blank">
                <img src="image/yy_ico.png" width="22" height="22">预约
            </a>
        </div>
        <div class="doctorRight">
            <div class="import import1"></div>
            <div class="title01">
                <h3>所在科室：</h3>
                <h1>${doctor.dept.name}</h1>
                <span><a href="${doctor.dept.url}" title="${doctor.dept.name}">进入科室</a></span>
            </div>
            <div class="clear"></div>
            <div id="DIVContent" class="article intro">
                <p>${doctor.intro}</p>
            </div>
              
            <div id="DIVOnDutyInfo" class="visitDate">
                <div class="title">
                    出诊安排<em>Visits Time</em>
                </div>
                <div class="visitList">
                    <div class="time">
                        <span class="green">时段</span>
                        <#list currentWeek as nameOfWeek, day>
                            <#if nameOfWeek?index % 2 == 0>
                            <div class="blue">
                                ${nameOfWeek} <em>${day}</em>
                            </div>
                            <#else>
                            <div class="green">
                                ${nameOfWeek} <em>${day}</em>
                            </div>
                            </#if>
                        </#list>
                    </div>
                    <div class="am">
                        <span>上午</span>
                        <#list isForenoonVisits as isVisits>
                            <#if isVisits == "-1">
                            <span class="dt">&nbsp;</span>
                            <#else>
                            <span class="dt"><img src="image/cz_ico3.png" width="22" height="22" alt="出诊"></span>
                            </#if>
                        </#list>
                    </div>
                    <div class="pm">
                        <span>下午</span>
                        <#list isAfternoonVisits as isVisits>
                            <#if isVisits == "-1">
                            <span class="dt">&nbsp;</span>
                            <#else>
                            <span class="dt"><img src="image/cz_ico3.png" width="22" height="22" alt="出诊"></span>
                            </#if>
                        </#list>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<#include "./fragments/_footer.ftl">