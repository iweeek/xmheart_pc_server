 <#include "./fragments/_header.ftl"> 
    <div class="xm-main">
        <div class="xm-container">
            <div class="xm-banner-slide">
                <div class="swiper-container" id="bannerSwiper">
                <div class="swiper-wrapper">
                <div class="swiper-slide"><a href="${index.bannerImage1ActionUrl}"><img src="${index.bannerImage1Url}" alt=""></a></div>
                <div class="swiper-slide"><a href="${index.bannerImage2ActionUrl}"><img src="${index.bannerImage2Url}" alt=""></a></div>
                <div class="swiper-slide"><a href="${index.bannerImage3ActionUrl}"><img src="${index.bannerImage3Url}" alt=""></a></div>
                </div>
                <div class="swiper-pagination"></div>
                </div>
            </div>
            <div class="xm-info">
                <div class="xm-online-service">
                    <h5 class="online-service-title">便民入口</h5>
                    <ul class="online-service-list">
                        <li><a href="http://www.xmsmjk.com/UrpOnline/Home/Index/182_____1" target="_blank"><img src="img/index/online-service-list1.png" alt=""><span>预约挂号</span></a></li>
                        <li><a href="http://www.xmheart.com/newsDetail?id=997"><img src="img/index/online-service-list3.png" alt=""><span>门诊排班</span></a></li>
                        <!--<li><a href="/deptDoctor?id=1&deptCode=&doctorCode=&status=0&workTime=0"><img src="img/index/online-service-list3.png" alt=""><span>门诊排班</span></a></li>-->
                        <!--<li><a href="http://www.xmsmjk.com/UrpOnline/Home/Hospital/182"><img src="img/index/online-service-list3.png" alt=""><span>门诊排班</span></a></li> -->
                        <!--<li><a href="/deptDoctor?id=3&deptCode=&doctorCode=&status=0&workTime=0"><img src="img/index/online-service-list2.png" alt=""><span>体检中心</span></a></li> -->
                        <li><a href="/404"><img src="img/index/online-service-list2.png" alt=""><span>体检中心</span></a></li>
                        <li><a href="/404"><img src="img/index/online-service-list4.png" alt=""><span>报告查询</span></a></li>
                        <li><a href="/newsDetail?id=978"><img src="img/index/online-service-list5.png" alt=""><span>就医流程</span></a></li>
                        <li><a href="http://oa.xmheart.com/xzzx" target="_blank"><img src="img/index/online-service-list6.png" alt=""><span>院内办公</span></a></li>
                    </ul>
                </div>
                <div class="xm-notice">
                    <div class="swiper-container" id="noticeSwiper">
                    <div class="swiper-wrapper">
                        <div class="swiper-slide">
                            <h5 class="xm-notice-title"><span class="xm-notice-tag">${index.bannerArticle1Tag}</span>
                                   <#if index.bannerArticle1Title?length lt 20>
                                   ${index.bannerArticle1Title}
                                   <#else>
                                   ${index.bannerArticle1Title[0..20]}......
                                   </#if>
                            </h5>
                            <p class="xm-notice-info">&nbsp;&nbsp;&nbsp;&nbsp;${index.bannerArticle1Brief}...
                            <a href="${index.bannerArticle1Url}" title="" class="show-more">查看详细</a>
                            </p>
                        </div>
                        <div class="swiper-slide">
                            <h5 class="xm-notice-title"><span class="xm-notice-tag">${index.bannerArticle2Tag}</span>
                                <#if index.bannerArticle2Title?length lt 20>
                                ${index.bannerArticle2Title}
                                <#else>
                                ${index.bannerArticle2Title[0..20]}......
                                </#if>
                            </h5>
                            <p class="xm-notice-info">&nbsp;&nbsp;&nbsp;&nbsp;${index.bannerArticle2Brief}...
                            <a href="${index.bannerArticle2Url}" title="" class="show-more">查看详细</a>
                            </p>
                        </div>
                        <div class="swiper-slide">
                            <h5 class="xm-notice-title"><span class="xm-notice-tag">${index.bannerArticle3Tag}</span>
                                <#if index.bannerArticle3Title?length lt 20>
                                ${index.bannerArticle3Title}......
                                <#else>
                                ${index.bannerArticle3Title[0..20]}......
                                </#if>
                            </h5>
                            <p class="xm-notice-info">&nbsp;&nbsp;&nbsp;&nbsp;${index.bannerArticle3Brief}...
                            <a href="${index.bannerArticle3Url}" title="" class="show-more">查看详细</a>
                            </p>
                        </div>
                    </div>
                    <div class="swiper-pagination"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- banner -->
    <div class="xm-banner">
        <div class="xm-container">
            <a href="xtIndex" target="_blank" class="xm-banner-list xm-list1">
                <div class="list-info">
                    <h3 class="list-info-title">国家胸痛中心</h3>
                    <h3 class="list-info-title">区域认证中心</h3>
                </div>
            </a>
            <a href="/doctorDept" class="xm-banner-list mr-0 xm-list4">
                <div class="list-info">
                    <h3 class="list-info-title">专家介绍</h3>
                    <p class="list-info-desc">了解专家信息便捷预约</p>
                </div>
            </a>
            <a href="/mapDetail?id=29" class="xm-banner-list xm-list3">
                <div class="list-info">
                    <h3 class="list-info-title">医院导航</h3>
                    <p class="list-info-desc">快速找到我们</p>
                </div>
            </a>
            <a href="/col/97" class="xm-banner-list xm-list2">
                <div class="list-info">
                    <h3 class="list-info-title">院务公开</h3>
                    <p class="list-info-desc">了解最新医院公告</p>
                </div>
            </a>
        </div>
    </div>

<#include "./fragments/_footer.ftl">
