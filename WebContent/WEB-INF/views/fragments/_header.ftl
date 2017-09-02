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
				<#list columns as key, value>
				<#--  <li class="xm-navbar-item"><a class="xm-navbar-item-info" href="#"><span>走进厦心</span><i></i></a></li>-->
				<li class="xm-navbar-item">
					<a class="xm-navbar-item-info" href="#"><span>${key}</span><i></i></a>
					<div class="navboxBase">
						<div class="navboxBg">
							<div class="navbox BaseMark">
								<div class="navMenus">
									<#list value as key, value>
									<ul>
										<#--<li class="first">
											<a href="${value}" title="媒体看厦心">${key}<span>进入</span></a>
										</li>
										<li>
											<a href="list-news.html" title="医院新闻">医院新闻<span>进入</span></a>
										</li>
										<li>
											<a href="video.html" title="影像厦心">影像厦心<span>进入</span></a>
										</li>
										<li>
											<a href="news-paper.html" title="电子院报">电子院报<span>进入</span></a>
										</li>-->
										<li>
											<a href="${value}" title="${key}">${key}<span>进入</span></a>
										</li>
									</ul>
									</#list>
								</div>
								<div class="navSub2 nav_Menu02 noPic NewsSub">
									<dl class="Img02">
										<dt class="title01">最新公告</dt>
										<dd class="pic">
											<img alt="最新公告" src="./img/pic/pic_002.jpg" width="126" height="77">
										</dd>
										<dd class="Lurl">
											<em>2017-03-09</em>
											<a href="NewsDetail-8623.html" title="河南省人民医院实验技术人员招聘公告">河南省人民医院实验技术人员招聘公告</a>
										</dd>
										<dd class="url">
											<span>2016-10-21</span>
											<a href="NewsDetail-8249.html" title="河南省立眼科医院（河南省眼科研究所）基础研究部门正、副科级干部竞聘实施方案（面向国内外）">河南省立眼科医院（河南省眼科研究所）基础研究部门正、副科级干部竞聘实施方案（面向国内外）</a>
										</dd>
										<dd class="url">
											<span>2016-10-21</span>
											<a href="NewsDetail-8248.html" title="河南省立眼科医院（河南省眼科研究所）临床部门干部竞聘实施方案（面向国内外）">河南省立眼科医院（河南省眼科研究所）临床部门干部竞聘实施方案（面向国内外）</a>
										</dd>
										<dd class="url">
											<span>2015-10-13</span>
											<a href="NewsDetail-7246.html" title="河南省人民医院公开招聘超声医师的公告">河南省人民医院公开招聘超声医师的公告</a>
										</dd>
									</dl>
									<div class="BottomHidden"></div>
									<dl>
										<dt class="title01">省医快讯</dt>
										<dd class="url">
											<span>2017-07-25</span>
											<a href="NewsDetail-8972.html" title="综合简讯">综合简讯</a>
										</dd>
										<dd class="url">
											<span>2017-07-25</span>
											<a href="NewsDetail-8971.html" title="学界动态">学界动态</a>
										</dd>
										<dd class="url">
											<span>2017-07-25</span>
											<a href="NewsDetail-8970.html" title="王思勤荣获全国对口支援新疆先进个人称号">王思勤荣获全国对口支援新疆先进个人称号</a>
										</dd>
										<dd class="url">
											<span>2017-07-25</span>
											<a href="NewsDetail-8969.html" title="争当先锋模范 筑牢战斗堡垒 我院一批基层党组织和共产党员获上级表彰">争当先锋模范 筑牢战斗堡垒 我院一批基层党组织和共产党员获上级表彰</a>
										</dd>
									</dl>
								</div>
								<div class="navSub4 nav_Menu02 noPic">
									<dl>
										<dt class="title02">新业务新技术</dt>
										<dd class="url">
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
										</dd>
									</dl>
									<div class="BottomHidden"></div>
									<dl>
										<dt class="title02">服务动态</dt>
										<dd class="url">
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
										</dd>
									</dl>
									<div class="BottomHidden"></div>
									<dl>
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
									</dl>
								</div>
								<div class="clear"></div>
							</div>
						</div>
					</div>
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