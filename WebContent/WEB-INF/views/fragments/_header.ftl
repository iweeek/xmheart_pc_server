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
												<img alt="媒体看夏心" src="./img/pic/pic_002.jpg" width="126" height="77">
											</dd>
											<dd class="Lurl">
												<em>2016-10-11</em>
												<a href="${v[0].url}" title="${v[0].articleTitle}">${v[0].articleTitle}</a>
											</dd>
											<dd class="url">
												<span>2017-05-08</span>
												<a href="${v[1].url}" title="${v[1].articleTitle}">${v[1].articleTitle}</a>
											</dd>
											<dd class="url">
												<span>2017-05-08</span>
												<a href="${v[2].url}" title="${v[2].articleTitle}">${v[2].articleTitle}</a>
											</dd>
											<dd class="url">
												<span>2017-05-08</span>
												<a href="${v[3].url}" title="${v[3].articleTitle}">${v[3].articleTitle}</a>
											</dd>
										</dl>
										<div class="BottomHidden"></div>
										<dl>
											<dt class="title01">${v[4].childColumnName}</dt>
											<dd class="url">
												<span>2017-07-25</span>
												<a href="${v[4].url}" title="${v[4].articleTitle}">${v[4].articleTitle}</a>
											</dd>
											<dd class="url">
												<span>2017-07-25</span>
												<a href="${v[5].url}" title="${v[5].articleTitle}">${v[5].articleTitle}</a>
											</dd>
											<dd class="url">
												<span>2017-07-25</span>
												<a href="${v[6].url}" title="${v[6].articleTitle}">${v[6].articleTitle}</a>
											</dd>
											<dd class="url">
												<span>2017-07-25</span>
												<a href="${v[7].url}" title="${v[7].articleTitle}">${v[7].articleTitle}</a>
											</dd>
										</dl>
									</div>
									<div class="navSub4 nav_Menu02 noPic">
										<dl>
											<dt class="title02">${v[8].childColumnName}</dt>
											<dd class="url">
												<span>2017-02-07</span>
												<a href="${v[8].url}" title="${v[8].articleTitle}">${v[8].articleTitle}</a>
											</dd>
											<dd class="url">
												<span>2016-12-13</span>
												<a href="${v[9].url}" title="${v[9].articleTitle}">${v[9].articleTitle}</a>
											</dd>
											<dd class="url">
												<span>2016-12-13</span>
												<a href="${v[10].url}" title="${v[10].articleTitle}">${v[10].articleTitle}</a>
											</dd>
											<dd class="url">
												<span>2016-12-13</span>
												<a href="${v[11].url}" title="${v[11].articleTitle}">${v[11].articleTitle}</a>
											</dd>
										</dl>
										<div class="BottomHidden"></div>
										<dl>
											<dt class="title02">${v[12].childColumnName}</dt>
											<dd class="url">
												<span>2016-09-07</span>
												<a href="${v[12].url}" title="${v[12].articleTitle}">${v[12].articleTitle}</a>
											</dd>
											<dd class="url">
												<span>2016-09-06</span>
												<a href="${v[13].url}" title="${v[13].articleTitle}">${v[13].articleTitle}</a>
											</dd>
											<dd class="url">
												<span>2016-09-06</span>
												<a href="${v[14].url}" title="${v[14].articleTitle}">${v[14].articleTitle}</a>
											</dd>
											<dd class="url">
												<span>2016-09-06</span>
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
					</li>
					</#list>
					</ul>
				</div>
			</div>
		</div>