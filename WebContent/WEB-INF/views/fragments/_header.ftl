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
            <div class="xm-container">
                <div class="header-icon">
                    <!--<span class="header-icon-lang">English</span>-->
                    <a href="#" class="header-icon-wechat"></a>
                    <a href="#" class="header-icon-weibo"></a>
                </div>
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
                    <#if firstColumnName == key>
                        <li class="xm-navbar-item active">
                    <#else>
                    
                        <li class="xm-navbar-item">
                    </#if>
                    
                    <#if key == "首页" >
                        <a class="xm-navbar-item-info no-bg" href="${value}"><span>${key}</span><i></i></a>
                    <#else>
                        <a class="xm-navbar-item-info" href="${value}"><span>${key}</span><i></i></a>
                        
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
                                 	   
                                     <#if key == "走进厦心">
										<#list secondColNavMap as skey,sv>                        		
                                    	   <#if skey == "医院简介">
                                    	       <#list sv as scol>
                                    	       <div class="navSub5">
											<h3 class="title01">${skey}</h3>
											<img src="${scol.imgUrl}" alt="" height="100px" width="225px">
											<br/>
											&#8195;&#8195;
											<!--<p class="first hospital-desc">
                                    		    <a href="${scol.url}" title="${scol.articleTitle}">${scol.articleTitle}</a>-->
                                                <#if scol.brief?length lt 120>
                                                ${scol.brief}......
                                                <#else>
                                                ${scol.brief[0..120]}......
                                                </#if>
                                            </#list>
                                      		<a href="#" class="more">查看详细</a>
										  </div>	
										</#if>
											
										<#if skey == "厦心荣誉">	
										    <div class="navSub6">
										        <#list sv as scol>
                                                     <h3 class="title01">${skey}</h3>
                                                     <img src="${scol.imgUrl}" alt="" height="100px" width="225px">
                                                     <br/>
                                                     &#8195;&#8195;
                                                     <#if scol.brief?length lt 120>
                                                     ${scol.brief}......
                                                     <#else>
                                                     ${scol.brief[0..120]}......
                                                     </#if>
                                                 </#list>
                                                 <a href="#" class="more">查看详细</a>
                                             </div>
										</#if>
											
										<#if skey == "文化理念">
										    <div class="navSub7">
                                                <#list sv as scol>
                                                     <h3 class="title01">${skey}</h3>
                                                     <img src="${scol.imgUrl}" alt="" height="100px" width="225px">
                                                     <br/>
                                                     &#8195;&#8195;
                                                     <#if scol.brief?length lt 120>
                                                     ${scol.brief}......
                                                     <#else>
                                                     ${scol.brief[0..120]}......
                                                     </#if>
                                                 </#list>
                                                 <a href="#" class="more">查看详细</a>
											</div>										
										</#if>
									</#list>
									</#if>   
                                
                                
								    <#if key == "新闻公告">
                                    <div class="navSub2 nav_Menu02 noPic NewsSub">
                                    <#list secondColNavMap as skey, sv>                             
                                        <#if skey == "媒体看厦心">
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
                                            </#if>
                                            </#list>
                                            </dl>
                                          </#if>    
                                              
                                        <#if skey == "医院新闻">
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
                                        </#if>  
                             
                                    <#if skey == "影像厦心">
                                    </div>
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
                                    
                                    <#if skey == "电子院报">
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
                                     </#if>   
                                              
                                    </#list>    
                                    </div>  
                                    </#if>
									
                    <#-- 新增1 -->           
                                    <#if key == "名医名科">
                                    <div class="navSub2 nav_Menu02 noPic NewsSub">
									<#list secondColNavMap as skey, sv>   
									                     		
                                    	<#if skey == "心血管外科">
                                    	  	<dl class="Img02">
                                    	  	    <#list sv as scol>
                                             <#if scol?index == 0>
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
											</#if>
                                    	  	</#list>
                                    	  	</dl>
                                    	  </#if>	
                                    	   	  
                                    	<#if skey == "心血管内科">
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
										</#if>	
							
							<#-- 新增2 -->			
									
									   <#if skey == "心功能科">
									   </div>
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
									
							<#-- 新增2 -->		
									
									</#list>	
									</div>	
									</#if>
			                <#-- 新增1 -->  		
							
                                    <div class="clear"></div>
                                </div>
                                </#if>
                                </#list>
                                <div class="clear"></div>
                            </div>
                        </div>
                     
                        </#if>
                        </#list>
                        </li>
                        		
                    </ul>
                </div>
            </div>
        </div>

        <#list firstColumns as key, value>
        <#if parentColumnName??>
        <#if key == parentColumnName>
        <div class="breadcrumb">
            <div class="xm-container">
                <span class="icon"></span>您当前所在位置<a href="/index"> 首页</a> &gt <a href="${value}" title="${parentColumnName}">${parentColumnName}</a> 
            </div>
        </div>
        </#if>
        </#if>
        </#list>
    
    