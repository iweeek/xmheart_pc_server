<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">  
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="renderer" content="webkit">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>厦门心脏医院</title>
		<link rel="stylesheet" href="./css/reset.css">
		<link rel="stylesheet" href="./css/swiper-3.4.2.min.css">
		<link rel="stylesheet" href="./css/layout.css">
		<link rel="stylesheet" href="./css/index.css">
		<link rel="stylesheet" href="./css/list.css">
		<link rel="stylesheet" href="./css/common.css">
		<!--[if lt IE 9]>
		    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		    <script src="../js/respond.min.js"></script>
  		<![endif]-->
	</head>
    <body>
	    <div class="xm-header">
			<div class="xm-container">
				<div class="header-icon">
					<span class="header-icon-lang">English</span>
					<a href="#" class="header-icon-wechat"></a>
					<a href="#" class="header-icon-weibo"></a>
				</div>
				<a href="#" class="header-logo"><img src="img/layout/logo.png" alt=""></a>
				<div class="header-search">
					<input type="text" class="header-search-text">
					<input type="button" class="header-search-button">
				</div>
			</div>
		</div>
		
		<div style="height: 44px;">
			<div class="xm-nav">
				<div class="xm-nav-container">
					<#-- <a href="#" class="xm-nav-brand">首页</a> -->
				<ul class="xm-navbar-nav">
					<#list firstColumns as key, value>
					<#--  <li class="xm-navbar-item"><a class="xm-navbar-item-info" href="#"><span>走进厦心</span><i></i></a></li>-->
					<li class="xm-navbar-item">
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
												<a href="" title="${col.columnName}">${col.columnName}<span>进入</span></a>
											</li>
											<#else>
											<li>
												<a href="list-news.html" title="${col.columnName}">${col.columnName}<span>进入</span></a>
											</li>
											</#if>
										</#list>
										</ul>
									</div>
									
									<div class="navSub2 nav_Menu02 noPic NewsSub">
									<#list navMap as k, v>
									<#if k == key>
										<dl class="Img02">
											<dt class="title01">"${v[0].columnName}"</dt>
											<dd class="pic">
												<img alt="媒体看夏心" src="./img/pic/pic_002.jpg" width="126" height="77">
											</dd>
											<dd class="Lurl">
												<em>2016-10-11</em>
												<a href="NewsDetail-8623.html" title="${v[0].articleTitle}">${v[0].articleTitle}</a>
											</dd>
											<dd class="url">
												<span>2017-05-08</span>
												<a href="NewsDetail-8249.html" title="${v[1].articleTitle}">${v[1].articleTitle}</a>
											</dd>
											<dd class="url">
												<span>2017-05-08</span>
												<a href="NewsDetail-8249.html" title="${v[2].articleTitle}">${v[2].articleTitle}</a>
											</dd>
											<dd class="url">
												<span>2017-05-08</span>
												<a href="NewsDetail-8249.html" title="${v[3].articleTitle}">${v[3].articleTitle}</a>
											</dd>
										</dl>
									</#if>
									</#list>
									</div>
									<div class="clear"></div>
								</div>
							</div>
						</div>
						</#if>
						</#list>
					</li>
					</#list>
					</ul>
				</div>
			</div>
		</div>