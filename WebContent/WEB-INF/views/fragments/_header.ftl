<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <!--引用百度地图API-->
    <style type="text/css">
        html,body{margin:0;padding:0;}
        .iw_poi_title {color:#CC5522;font-size:14px;font-weight:bold;overflow:hidden;padding-right:13px;white-space:nowrap}
        .iw_poi_content {font:12px arial,sans-serif;overflow:visible;padding-top:4px;white-space:-moz-pre-wrap;word-wrap:break-word}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
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
        <link rel="stylesheet" href="/css/jplayer.blue.monday.min.css">
        <!--[if lt IE 9]>
            <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="/js/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="xm-header">
            <div class="xm-header-container">
                <div class="header-icon">
                    <!--<span class="header-icon-lang">English</span>-->
                    <div class="header-icon-wechat-wrapper" id="wechatCode">
                            <a href="#" class="header-icon-wechat"></a>
                            <img src="/img/layout/wechat_code.jpg" class="wechat-code">
                    </div>
                    <a href="#" class="header-icon-weibo"></a>
                </div>
                <a href="#" class="header-logo"><img src="/img/layout/logo.png" alt=""></a>
                <div class="header-search">
                		<div class="search-type-wrapper">
                			<div class="search-type" id="searchType">文章查找</div>
                			<ul class="search-type-list" id="searchTypeList">
                				<#--<li data-id="1">全站内容</li>-->
                				<li data-id="2">医生查找</li>
                				<li data-id="3">文章查找</li>
                				<#--<li data-id="4">科室查找</li>-->
                			</ul>
                		</div>
                		<form action="/search" method="get" onsubmit="return CheckSearchForm()">
                			<input type="hidden" name="type" id="searchTypeInput" value="3">
                    		<input type="text" name="keywords" id="searchValInput" class="header-search-text">
                    		<input type="submit" class="header-search-button">
                    </form>
                </div>
            </div>
        </div>
        
        <div style="height:60px;">
            <div class="xm-nav">
                <div class="xm-nav-container">
                    <ul class="xm-navbar-nav">
                    <#list firstColumns as key, value>
                        <#if firstColumnName == key>
                            <li class="xm-navbar-item active">
                        <#else>
                            <li class="xm-navbar-item">
                        </#if>
                            <#if key == "首页">
                                <a class="xm-navbar-item-info no-bg" href="${value}"><span>${key}</span><i></i></a>
                            <#else>
                                <a class="xm-navbar-item-info" href="${value}"><span>${key}</span><i></i></a>
                                    <#list columnMap as kc, vc>
                                    <#if kc == key && !(key?index == 5 || key?index == 6 || key?index == 8) >
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
                            
                                                    <#if key?index == 1 || key?index == 2 || key?index == 3>
                                                    <#list columnNavMap as columnName, navList>     
                                                    <#if columnName == key>       
                                                    <#list navList as nav>                    
                                                    <div class="navSub5">
                                                    <h3 class="title01">${nav.childColumnName}</h3>
                                                    <img src="${nav.imgUrl}" height="100px" width="100%" alt="">
                                                    <br/>
                                                        <!--<a href="${nav.url}" title="${nav.articleTitle}">${nav.articleTitle}</a>-->
                                                    <p class="first hospital-desc">
                                                        <#if nav.brief?length lt 120>
                                                           ${nav.brief}......
                                                        <#else>
                                                           ${nav.brief[0..120]}......
                                                        </#if>
                                                    </p>
                                                        <a href="${nav.url}" class="more">查看详细</a>
                                                    </div>    
                                                    </#list>
                                                    </#if>
                                                    </#list>
                                                    </#if>   
                       
                                                    <#if key?index == 4 || key?index == 7>
                                                    <div class="navSub2 nav_Menu02 noPic NewsSub">
                                                    <#list secondColNavMap as skey, sv>
                                                        <#if skey == vc[0].columnName>
                                                        <#list sv as scol>
                                                            <#if scol?index == 0>
                                                            <dl class="Img02">
                                                            <dt class="title01">${skey}</dt>
                                                            <dd class="pic">
                                                                <img alt="最新公告" src="${scol.imgUrl}" width="126" height="77">
                                                            </dd>
                                                            <dd class="Lurl">
                                                                <em>${scol.publishTime?string('yyyy-MM-dd')}</em>
                                                                <a href="${scol.url}" title="${scol.articleTitle}">${scol.articleTitle}</a>
                                                            </dd>
                                                            <#else>
                                                            <dd class="url">
                                                                <span>${scol.publishTime?string('yyyy-MM-dd')}</span>
                                                                <a href="${scol.url}" title="${scol.articleTitle}">${scol.articleTitle}</a>
                                                            </dd>
                                                            </dl>
                                                            </#if>
                                                        </#list>
                                                        </#if>
                                                      
                                                        <#if skey == vc[1].columnName>
                                                        <div class="BottomHidden"></div>
                                                        <dl>
                                                        <dt class="title01">${skey}</dt>
                                                        <#list sv as scol>
                                                        <dd class="url">
                                                            <span>${scol.publishTime?string('yyyy-MM-dd')}</span>
                                                            <a href="${scol.url}" title="${scol.articleTitle}">${scol.articleTitle}</a>
                                                        </dd>
                                                        </#list>
                                                        </dl>
                                                        </div>
                                                        </#if>
                                                            
                                                        <#if skey == vc[2].columnName>
                                                        <div class="navSub4 nav_Menu02 noPic">
                                                        <dl>
                                                        <dt class="title02">${skey}</dt>
                                                        <#list sv as scol>
                                                        <dd class="url">
                                                            <span>${scol.publishTime?string('yyyy-MM-dd')}</span>
                                                            <a href="${scol.url}" title="${scol.articleTitle}">${scol.articleTitle}</a>
                                                        </dd>
                                                        </#list>
                                                        </dl>
                                                        </#if>
                                            
                                                        <#if skey == vc[3].columnName>
                                                        <div class="BottomHidden"></div>
                                                        <dl>
                                                            <dt class="title02">${skey}</dt>
                                                            <#list sv as scol>
                                                            <dd class="url">
                                                                <span>${scol.publishTime?string('yyyy-MM-dd')}</span>
                                                                <a href="${scol.url}" title="${scol.articleTitle}">${scol.articleTitle}</a>
                                                            </dd>
                                                            </#list>
                                                        </dl>   
                                                        </div> 
                                                        </#if>   
                                                    </#list>  
                                                    </#if>
                                                     <div class="clear"></div>
                                                 </div>
                                                 <div class="clear"></div>
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

        <#if parentColList??>
        <div class="breadcrumb">
            <div class="xm-container">
                <span class="icon"></span>
                您当前所在位置<a href="/index"> 首页 </a>
                <#list parentColList as column>
                    &gt <a href="${column.url}" title="${column.columnName}">${column.columnName}</a>
                </#list>
            </div>
        </div>
        <#else>
        <#list firstColumns as key, value>
        <#if parentColumnName??>
        <#if key == parentColumnName>
        <div class="breadcrumb">
            <div class="xm-container">
                <span class="icon"></span>您当前所在位置<a href="/index"> 首页 </a> &gt <a href="${value}" title="${parentColumnName}">${parentColumnName}</a> 
            </div>
        </div>
        </#if>
        </#if>
        </#list>
        </#if>
