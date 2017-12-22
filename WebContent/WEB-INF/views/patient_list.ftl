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
                <div class="title01">患者表扬</div>
                <div class="clear"></div>
                <div class="media-wrapper video-wrapper">
                    <#list articleList as v>
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
