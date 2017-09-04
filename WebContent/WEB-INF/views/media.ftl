<#include "./fragments/_header.ftl"> 
<!-- list container -->
<div class="breadcrumb">
	<div class="xm-container">
		<a href="#">新闻中心</a><i>/</i><span>媒体聚焦</span>
	</div>
</div>
<div class="list-container">
	<div class="list-main">
		<div class="list-main-nav">
			<h4 class="list-nav-title">新闻中心</h4>
			<ul class="list-nav-list">
			<#list listMainNav as k>
				<#if k.columnName == pageName>
					<li class="active"><a href="${k.url}">${k.columnName}</a>
				<#else>
					<li><a href="${k.url}">${k.columnName}</a></li>
				</#if>
			</#list>
			</ul>
		</div>
		<div class="baseRight list-media">
			<div class="title01">${pageName}</div>
			<div class="media-wrapper">
				<#list pinnedMediaNewsList as key>
				<div class="media-item">
					<a href="${key.url}">
						<div class="media-img"><img src="${key.imgUrl}" alt=""></div>
						<div class="media-info">
							<h4 class="media-info-title">${key.title}</h4>
							<p class="media-info-desc">屡屡刷新厦门“心速度”之后，厦门市心血管病医院（厦门市心脏中心）在成...</p>
							<div class="media-bottom">
								<span class="date">2017/08/10</span>
								<span class="visit">10000</span>
							</div>
						</div>
					</a>
				</div>
				</#list>
			</div>
			<div class="title02">
				<!--  <a href="#" id="DateAscOrDesc" class="current">发布时间排序</a>
				<a href="#" id="HitAscOrDesc">阅览次数排序</a>-->
				<div class="itemBase">
					<!--<div class="divType" data-state="0">全部年份</div>
						<ul>
							<li><a href="NewsList-20.html?year=2017">2017年</a></li>
							<li><a href="NewsList-20.html?year=2016">2016年</a></li>
							<li><a href="NewsList-20.html?year=2015">2015年</a></li>
							<li><a href="NewsList-20.html?year=2014">2014年</a></li>
							<li><a href="NewsList-20.html?year=2013">2013年</a></li>
							<li><a href="NewsList-20.html?year=2012">2012年</a></li>
						</ul>
					</div>
					<span class="count">共发布文章<em id="EMCount">1844</em>篇</span>-->
				</div>
				<div class="clear"></div>
				<div class="newList">
					<ul>
						<#list noPinnedMediaNewsList as k>
						<li>
							<div class="headLines">
								<a href="${k.url}" title="${k.columnName}" target="_blank"class="title" >${k.columnName}</a>
								<p>●7月6日，检验科举办了第二次“翻转课堂”，围绕影响生化结果的常见因素、降钙素原等话题进行了交流学习。 (检验科 朱亚）●7月6日，我院与太康县人民医院互联智慧分级诊疗远程云心电项目正式...</p>
							</div>
							<div class="date">
								<h3>发布时间</h3>
								<h4>2017/7/25</h4>
								<p>阅览次数<span>117</span></p>
							</div>
							<div class="listBtn">
								<a href="./media-detail" title="综合简讯" target="_blank">查看详情</a>
							</div>
							<div class="clear"></div>
						</li>
						<!--<li>
							<div class="headLines">
								<a href="NewsDetail-8971.html" title="学界动态" target="_blank" class="title">学界动态</a>
								<p>张连仲当选中国超声医学工程学会第七届常务理事会常务理事 7月7-9日，第十三届全国超声医学学术交流大会暨中国超声医学工程学会第七届会员代表大会在安徽召开。副院长张连仲当选中国超声医学工程学会第...</p>
							</div>
							<div class="date">
								<h3>发布时间</h3>
								<h4>2017/7/25</h4>
								<p>阅览次数<span>134</span></p>
							</div>
							<div class="listBtn">
								<a href="NewsDetail-8971.html" title="学界动态" target="_blank">进入</a>
							</div>
							<div class="clear"></div>
						</li>-->
						</#list>
				</ul>
			</div>
			<div class="clear"></div>
			<div class="list-pagination">
				<ul class="paginations">
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">6</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<#include "./fragments/_footer.ftl">
