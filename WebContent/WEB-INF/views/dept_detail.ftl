<#include "./fragments/_header.ftl"> <!-- list container -->
<div class="breadcrumb">
    <div class="xm-container">
        <a href="#">名医名科</a>
        <i>/</i><span>科室介绍</span>
    </div>
</div>
<div class="list-container">
    <div class="list-main">
        <div class="list-main-nav">
            <h4 class="list-nav-title">${dept.name}</h4>
            <ul class="list-nav-list">
                <li class="active"><a href="">科室简介</a></li>
                <!--<li><a href=""></a></li>
                <li><a href=""></a></li>
                <li><a href=""></a></li>-->
            </ul>
        </div>
        <div class="partRight">
            <div class="title01">科室简介</div>
            <div id="DIVContent" class="article intro">
                <p>${dept.intro}</p>
                <p>
                    <br>
                </p>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<#include "./fragments/_footer.ftl">