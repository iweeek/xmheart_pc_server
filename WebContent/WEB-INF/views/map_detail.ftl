<#include "./fragments/_header.ftl"> <!-- list container -->
<div class="list-container">
    <div class="list-main">
        <div class="list-main-nav">
            <h4 class="list-nav-title">${parentColumnName}</h4>
            <ul class="list-nav-list">
                <#list leftNav as k> <#if k.columnName== article.columnName>
                <li class="active"><a href="${k.url}">${k.columnName}</a> <#else>
                    <li><a href="${k.url}">${k.columnName}</a></li>
                </#if> </#list>
            </ul>
        </div>
        <div class="baseRight list-news">
            <div class="title01">${article.columnName}</div>
            <br/>
            <p>乘车路线</p>
            <br/>
            <p>怎么走：乘坐958，43，99，10，45，23，27，30，136，941，856，20，123，122，118，656，309，758至中山医院站。</p>
            <br/>
            <p>预约电话：0592－96166/0592－2292999</p>
            <br/>
            <p>地址：厦门市湖滨南路205号振河大楼</p>
            <br/>
            <!--百度地图容器-->
            <div style="width: 697px; height: 550px; border: #ccc solid 1px;" id="dituContent"></div>
        </div>
    </div>
</div>
<#include "./fragments/_footer.ftl">