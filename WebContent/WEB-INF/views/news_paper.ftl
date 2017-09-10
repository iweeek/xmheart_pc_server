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
			<div class="baseRight news-paper">
				<div class="title01">${pageName}</div>
				<div class="title07">2017年第14期第1版
					<form>
						<select id="ddlYears2">
							<option value="0">选择年份</option>
							<option value="2017">2017年</option>
							<option value="2016">2016年</option>
							<option value="2015">2015年</option>
							<option value="2014">2014年</option>
						</select>
						<select id="ddlTimes2">
							<option value="0">选择期数</option>
						</select>
						<input type="button" id="GoToNewspaper2" value="阅览">
					</form>
					<div class="clear"></div>
				</div>
				<div class="inst">
					<div class="instRleft">
						<ul>
							<#list newsPaperList as key>
							<#if key_index == 0>
								<li class="first">
								<#if key_index == pageInfo.pageNum>
									<a class="active" href="?page=${key_index + 1}">${key_index + 1}
								<#else>
									<a href="?page=${key_index + 1}">${key_index + 1}
								</#if>
										<em class="animated">
											<span class="title">${key.title}</span>
										</em>
									</a>
								</li>
							<#else>
								<li >
								<#if key_index == pageInfo.pageNum - 1>
									<a class="active" href="?page=${key_index + 1}">${key_index + 1}
								<#else>
									<a href="?page=${key_index + 1}">${key_index + 1}
								</#if>
										<em class="animated">
											<span class="title">${key.title}</span>
										</em>
									</a>
								</li>
							</#if>
							</#list>
						</ul>
					</div>
					<div class="instRright">
						${newsPaperList[0].content}
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</div>
<#include "./fragments/_footer.ftl">
