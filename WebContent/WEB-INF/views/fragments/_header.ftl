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
						<#list columnMap as k, v>
						<#if k == key>
						<div class="navboxBase">
							<div class="navboxBg">
								<div class="navbox BaseMark">
									<div class="navMenus">
										<ul>
										
										<#list v as col>
											<!--<li class="first">
												<a href="" title="${k}">${k}<span>进入</span></a>
											</li>-->
											<li>
												<a href="list-news.html" title="${col.columnName}">${col.columnName}<span>进入</span></a>
											</li>
											<!--<li>
												<a href="video.html" title="影像厦心">影像厦心<span>进入</span></a>
											</li>
											<li>
												<a href="news-paper.html" title="电子院报">电子院报<span>进入</span></a>
											</li>-->
										</#list>
										
										</ul>
									</div>
									
									<div class="navSub2 nav_Menu02 noPic NewsSub">
										<dl class="Img02">
											<dt class="title01">"媒体看夏心"</dt>
											<dd class="pic">
												<img alt="媒体看夏心" src="./img/pic/pic_002.jpg" width="126" height="77">
											</dd>
											<dd class="Lurl">
												<em>2016-10-11</em>
												<a href="NewsDetail-8623.html" title=""></a>
											</dd>
											<dd class="url">
												<span>2017-05-08</span>
												<a href="NewsDetail-8249.html" title="尤颢：患者的信任让我全力以赴">尤颢：患者的信任让我全力以赴</a>
											</dd>
											<dd class="url">
												<span>2017-05-03</span>
												<a href="NewsDetail-8248.html" title="特区新闻广场：【劳动者的一天】医生叶涛：让生命更有尊严">特区新闻广场：【劳动者的一天】医生叶涛：让生命更有尊严</a>
											</dd>
											<dd class="url">
												<span>2017-05-03</span>
												<a href="NewsDetail-7246.html" title="厦视新闻：厦门市政协委员考察心血管病医院：提高患者急救意识">厦视新闻：厦门市政协委员考察心血管病医院：提高患者急救意识</a>
											</dd>
										</dl>
										<div class="BottomHidden"></div>
										<dl>
											<dt class="title01">医院新闻</dt>
											<dd class="url">
												<span>2017-04-28</span>
												<a href="NewsDetail-8972.html" title="“天使之心 至善之行”——空中天使邂逅白衣天使">“天使之心 至善之行”——空中天使邂逅白衣天使</a>
											</dd>
											<dd class="url">
												<span>2017-03-13</span>
												<a href="NewsDetail-8971.html" title="心血管病医院开展植树节义务劳动">心血管病医院开展植树节义务劳动</a>
											</dd>
											<dd class="url">
												<span>2017-01-26</span>
												<a href="NewsDetail-8970.html" title="保障春节，护航金砖——我院开展节前安全生产大排查">保障春节，护航金砖——我院开展节前安全生产大排查</a>
											</dd>
											<dd class="url">
												<span>2017-01-26</span>
												<a href="NewsDetail-8969.html" title="我院领导为全体员工拜年送“福”">我院领导为全体员工拜年送“福”</a>
											</dd>
										</dl>
									</div>
									<div class="navSub4 nav_Menu02 noPic">
										<dl>
											<dt class="title02">影像夏心</dt>
											<#--<dd class="url">
												<span>2017-02-07</span>
												<a href="NewsDetail-8561.html" title="血管外科成功完成全省首例血管仿生支架植入术">血管外科成功完成全省首例血管仿生支架植入术</a>
											</dd>
											<dd class="url">
												<span>2016-12-13</span>
												<a href="NewsDetail-8482.html" title="我院成功实施首例ECMO院间转运">我院成功实施首例ECMO院间转运</a>
											</dd>
											<dd class="url">
												<span>2016-12-13</span>
												<a href="NewsDetail-8481.html" title="介入科经桡动脉治疗93岁高龄颈动脉狭窄患者">介入科经桡动脉治疗93岁高龄颈动脉狭窄患者</a>
											</dd>-->
										</dl>
										<div class="BottomHidden"></div>
										<dl>
											<dt class="title02">电子院报</dt>
											<#--  <dd class="url">
												<span>2016-09-07</span>
												<a href="NewsDetail-8113.html" title="PICU完成全省首例超低体重儿食管狭窄球囊扩张术">PICU完成全省首例超低体重儿食管狭窄球囊扩张术</a>
											</dd>
											<dd class="url">
												<span>2016-09-06</span>
												<a href="NewsDetail-8094.html" title="全省首例单纯超声引导下 肺动脉瓣狭窄球囊扩张术成功救治8岁患儿">全省首例单纯超声引导下 肺动脉瓣狭窄球囊扩张术成功救治8岁患儿</a>
											</dd>
											<dd class="url">
												<span>2016-09-06</span>
												<a href="NewsDetail-8093.html" title="心电生理中心完成我院首例 心腔内超声指导下三维射频消融术">心电生理中心完成我院首例 心腔内超声指导下三维射频消融术
												</a>
											</dd>-->
										</dl>
										<div class="BottomHidden"></div>
										<#--  <dl>
											<dt class="title02">媒体看省医</dt>
											<dd class="url">
												<span>2016-11-09</span>
												<a href="NewsDetail-8345.html" title="好消息！河南省人民医院将免费救助百名先心病患儿">好消息！河南省人民医院将免费救助百名先心病患儿</a>
											</dd>
											<dd class="url">
												<span>2016-09-26</span>
												<a href="NewsDetail-8173.html" title="驻村就是驻心:第一书记打通驻马店村民奔小康的路">驻村就是驻心:第一书记打通驻马店村民奔小康的路</a>
											</dd>
											<dd class="url">
												<span>2016-09-26</span>
												<a href="NewsDetail-8172.html" title="《河南日报》百年省医孕育诞生河南省首家生殖专科医院 在尊重、关怀和爱中迎接一个个新的生命">《河南日报》百年省医孕育诞生河南省首家生殖专科医院 在尊重、关怀和爱中迎接一个个新的生命</a>
											</dd>
										</dl>-->
									</div>
									<div class="clear"></div>
								</div>
							</div>
						</div>
						</#if>
						</#list>
					</li>
					<#-- <li class="xm-navbar-item"><a class="xm-navbar-item-info" href="./expert.html"><span>名医名科</span><i></i></a></li>
					<li class="xm-navbar-item"><a class="xm-navbar-item-info" href="#"><span>就医服务</span><i></i></a></li>
					<li class="xm-navbar-item"><a class="xm-navbar-item-info" href="#"><span>党群工作</span><i></i></a></li>
					<li class="xm-navbar-item"><a class="xm-navbar-item-info" href="#"><span>科研教学</span><i></i></a></li>
					<li class="xm-navbar-item"><a class="xm-navbar-item-info" href="#"><span>护理天地</span><i></i></a></li>
					<li class="xm-navbar-item"><a class="xm-navbar-item-info" href="#"><span>招贤纳士</span><i></i></a></li>-->
					</#list>
					</ul>
				</div>
			</div>
		</div>