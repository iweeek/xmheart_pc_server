<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">  
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="renderer" content="webkit">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>厦门大学附属心血管病医院（厦门市心脏中心）</title>
        <link rel="stylesheet" href="/css/reset.css">
        <link rel="stylesheet" href="/css/swiper-3.4.2.min.css">
        <link rel="stylesheet" href="/css/layout.css">
        <link rel="stylesheet" href="/css/index.css">
        <link rel="stylesheet" href="/css/list.css">
        <link rel="stylesheet" href="/css/common.css">
        <!--[if lt IE 9]>
            <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="/js/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="xm-header">
            <div class="xm-container">
                <!--<div class="header-icon">
                    <span class="header-icon-lang">English</span>
                    <a href="#" class="header-icon-wechat"></a>
                    <a href="#" class="header-icon-weibo"></a>
                </div>-->
                <a href="#" class="header-logo"><img src="/img/layout/logo.png" alt=""></a>
                <!--<div class="header-search">
                    <input type="text" class="header-search-text">
                    <input type="button" class="header-search-button">
                </div>-->
            </div>
        </div>
        <div style="height:60px;">
            <div class="xm-nav">
                <div class="xm-nav-container">
                    <#-- <a href="#" class="xm-nav-brand">首页</a> -->
                <ul class="xm-navbar-nav">
                    <#-- 顶部栏目导航 -->
                    <#list firstColumns as key, value>
                    <#--  <li class="xm-navbar-item"><a class="xm-navbar-item-info" href="#"><span>走进厦心</span><i></i></a></li>-->
                    ${firstColumnName}
                    <#if firstColumnName == key>
                        <li class="xm-navbar-item active">
                    <#else>
                        <li class="xm-navbar-item">
                    </#if>
                    
                    <#if key == "首页" || key == "走进厦心" || key == "名医名科" || key == "就医服务" || key == "党群工作" || key == "护理天地" 
                        || key == "科研教学" || key == "招贤纳士">
                        <a class="xm-navbar-item-info no-bg" href="${value}"><span>${key}</span><i></i></a>
                    <#else>
                        <a class="xm-navbar-item-info" href="${value}"><span>${key}</span><i></i></a>
                    
                    <#-- 悬浮导航 -->
                    <#list columnMap as kc, vc>
                    <#if kc == key>
                    <div class="navboxBase">
                        <div class="navboxBg">
                            <div class="navbox BaseMark">
                                <div class="navMenus">
                                    <ul>
                                    <#list vc as col>
                                        <#if vc?index == 0>
                                        <li class="first">
                                            <a href="${col.url}" title="${col.columnName}">${col.columnName}<span>进入</span></a>
                                        </li>
                                        <#else>
                                        <li>
                                            <a href="${col.url}" title="${col.columnName}">${col.columnName}<span>进入</span></a>
                                        </li>
                                        </#if>
                                    </#list>
                                    </ul>
                                </div>
                                
                                <#list navMap as k, v>
                                <#if k == key>
                                <div class="navSub2 nav_Menu02 noPic NewsSub">
                                    <dl class="Img02">
                                        <dt class="title01">${v[0].childColumnName}</dt>
                                        <dd class="pic">
                                            <img alt="" src="/img/pic/pic_002.jpg" width="126" height="77">
                                        </dd>
                                        <dd class="Lurl">
                                            <em>${v[0].publishTime?date}</em>
                                            <a href="${v[0].url}" title="${v[0].articleTitle}">${v[0].articleTitle}</a>
                                        </dd>
                                        <dd class="url">
                                            <span>${v[1].publishTime?date}</span>
                                            <a href="${v[1].url}" title="${v[1].articleTitle}">${v[1].articleTitle}</a>
                                        </dd>
                                        <dd class="url">
                                            <span>${v[2].publishTime?date}</span>
                                            <a href="${v[2].url}" title="${v[2].articleTitle}">${v[2].articleTitle}</a>
                                        </dd>
                                        <dd class="url">
                                            <span>${v[3].publishTime?date}</span>
                                            <a href="${v[3].url}" title="${v[3].articleTitle}">${v[3].articleTitle}</a>
                                        </dd>
                                    </dl>
                                    <div class="BottomHidden"></div>
                                    <dl>
                                        <dt class="title01">${v[4].childColumnName}</dt>
                                        <dd class="url">
                                            <span>${v[4].publishTime?date}</span>
                                            <a href="${v[4].url}" title="${v[4].articleTitle}">${v[4].articleTitle}</a>
                                        </dd>
                                        <dd class="url">
                                            <span>${v[5].publishTime?date}</span>
                                            <a href="${v[5].url}" title="${v[5].articleTitle}">${v[5].articleTitle}</a>
                                        </dd>
                                        <dd class="url">
                                            <span>${v[6].publishTime?date}</span>
                                            <a href="${v[6].url}" title="${v[6].articleTitle}">${v[6].articleTitle}</a>
                                        </dd>
                                        <dd class="url">
                                            <span>${v[7].publishTime?date}</span>
                                            <a href="${v[7].url}" title="${v[7].articleTitle}">${v[7].articleTitle}</a>
                                        </dd>
                                    </dl>
                                </div>
                                <div class="navSub4 nav_Menu02 noPic">
                                    <dl>
                                        <dt class="title02">${v[8].childColumnName}</dt>
                                        <dd class="url">
                                            <span>${v[8].publishTime?date}</span>
                                            <a href="${v[8].url}" title="${v[8].articleTitle}">${v[8].articleTitle}</a>
                                        </dd>
                                        <dd class="url">
                                            <span>${v[9].publishTime?date}</span>
                                            <a href="${v[9].url}" title="${v[9].articleTitle}">${v[9].articleTitle}</a>
                                        </dd>
                                        <dd class="url">
                                            <span>${v[10].publishTime?date}</span>
                                            <a href="${v[10].url}" title="${v[10].articleTitle}">${v[10].articleTitle}</a>
                                        </dd>
                                        <dd class="url">
                                            <span>${v[11].publishTime?date}</span>
                                            <a href="${v[11].url}" title="${v[11].articleTitle}">${v[11].articleTitle}</a>
                                        </dd>
                                    </dl>
                                    <div class="BottomHidden"></div>
                                    <dl>
                                        <dt class="title02">${v[12].childColumnName}</dt>
                                        <dd class="url">
                                            <span>${v[12].publishTime?date}</span>
                                            <a href="${v[12].url}" title="${v[12].articleTitle}">${v[12].articleTitle}</a>
                                        </dd>
                                        <dd class="url">
                                            <span>${v[13].publishTime?date}</span>
                                            <a href="${v[13].url}" title="${v[13].articleTitle}">${v[13].articleTitle}</a>
                                        </dd>
                                        <dd class="url">
                                            <span>${v[14].publishTime?date}</span>
                                            <a href="${v[14].url}" title="${v[14].articleTitle}">${v[14].articleTitle}</a>
                                        </dd>
                                        <dd class="url">
                                            <span>${v[15].publishTime?date}</span>
                                            <a href="${v[15].url}" title="${v[15].articleTitle}">${v[15].articleTitle}</a>
                                        </dd>
                                    </dl>
                                    <div class="BottomHidden"></div>
                                </div>
                                </#if>
                                </#list>
                                <div class="clear"></div>
                            </div>
                        </div>
                    </div>
                    </#if>
                    </#list>
                    </#if>
                    </li>
                    </#list>
                    </ul>
                </div>
            </div>
        </div>