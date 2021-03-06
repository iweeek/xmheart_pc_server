<#include "./fragments/_header.ftl">
<!--<div class="breadcrumb">
    <div class="xm-container">
        <span class="icon"></span>您当前所在位置
        <a href="index">首页</a>
        &gt
        <a href="doctorDept">导师团队</a>
        &gt
        <a href="#">导师详情</a>
    </div>
</div>-->
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
            <!-- <div class="title01">
                <h3>所在科室：</h3>
                <h1>${doctor.dept.name}</h1>
                <span><a href="${doctor.dept.url}" title="${doctor.dept.name}">进入科室</a></span>
            </div>
            -->
            <div class="clear"></div>
            <div id="DIVContent" class="article intro">
                <p>${doctor.intro}</p>
            </div>
              
            <!--<div id="DIVOnDutyInfo" class="visitDate">
                <div class="title">
                    出诊安排<em>Visits Time</em>
                </div>
                <div class="visitList">
                    <div class="time">
                        <span class="green">时段</span>
                        <div class="blue">
                            星期三 <em>2017/7/26</em>
                        </div>
                        <div class="green">
                            星期四 <em>2017/7/27</em>
                        </div>
                        <div class="blue">
                            星期五 <em>2017/7/28</em>
                        </div>
                        <div class="green">
                            星期六 <em>2017/7/29</em>
                        </div>
                        <div class="blue">
                            星期日 <em>2017/7/30</em>
                        </div>
                        <div class="green">
                            星期一 <em>2017/7/31</em>
                        </div>
                        <div class="blue">
                            星期二 <em>2017/8/1</em>
                        </div>
                    </div>
                    <div class="am">
                        <span>上午</span><span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span><span><img
                            src="image/cz_ico3.png" width="22" height="22" alt="出诊"></span>
                    </div>
                    <div class="pm">
                        <span>下午</span><span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span><span><img
                            src="image/cz_ico3.png" width="22" height="22" alt="出诊"></span>
                    </div>
                </div>
            </div>-->
            <div class="clear"></div>
        </div>
    </div>
</div>
<#include "./fragments/_footer.ftl">