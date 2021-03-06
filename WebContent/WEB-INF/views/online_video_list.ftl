<#include "./fragments/_header.ftl">
    <!-- list container -->
    <div class="list-container">
        <div class="list-main">
            <div class="list-main-nav">
                <h4 class="list-nav-title">${parentColumnName}</h4>
                <ul class="list-nav-list">
                <#list leftNav as k>
                    <#if k.columnName == columnName>
                        <li class="active"><a href="${k.url}">${k.columnName}</a>
                    <#else>
                        <li><a href="${k.url}">${k.columnName}</a></li>
                    </#if>
                </#list>
                </ul>
            </div>
            <div class="baseRight list-media">
                <div class="title01">在线视频学习</div>
                <!--<div class="video-tab">
                    <div class="video-tab-item active">视频</div>
                    <div class="video-tab-item">图片</div>
                </div>
                <div class="title02">
                    <a href="#" id="DateAscOrDesc" class="current">发布时间排序</a>
                    <a href="#" id="HitAscOrDesc">阅览次数排序</a>
                    <div class="itemBase">
                        <div class="divType" data-state="0">全部年份</div>
                        <ul>
                            <li><a href="NewsList-20.html?year=2017">2017年</a></li>
                            <li><a href="NewsList-20.html?year=2016">2016年</a></li>
                            <li><a href="NewsList-20.html?year=2015">2015年</a></li>
                            <li><a href="NewsList-20.html?year=2014">2014年</a></li>
                            <li><a href="NewsList-20.html?year=2013">2013年</a></li>
                            <li><a href="NewsList-20.html?year=2012">2012年</a></li>
                        </ul>
                    </div>
                    <span class="count">共发布文章<em id="EMCount">1844</em>篇</span>
                </div>-->
                <div class="clear"></div>
                <div class="media-wrapper video-wrapper">
                    <#list videoList as v>
                    <div class="media-item">
                    <a href="${v.url}">
                        <div class="media-img"><img src="${v.imgUrl}" alt=""></div>
                        <div class="media-info">
                            <h4 class="media-info-title">${v.title}</h4>
                                <div class="media-bottom">
                                <span class="date">${v.publishTime?string('yyyy-MM-dd')}</span>
                            </div>
                        </div>
                    </a>
                    </div>
                    </#list>
                </div>
            </div>
        </div>
    </div>
<#include "./fragments/_footer.ftl">
