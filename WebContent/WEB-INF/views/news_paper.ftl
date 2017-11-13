<#include "./fragments/_header.ftl">
	<!-- list container -->
	<!--<div class="breadcrumb">
		<div class="xm-container">
			<a href="#">新闻中心</a><i>/</i><span>媒体聚焦</span>
		</div>
	</div>-->
	<div class="list-container">
		<div class="list-main">
			<div class="list-main-nav">
			<h4 class="list-nav-title">新闻中心</h4>
			<ul class="list-nav-list">
			<#list leftNav as k>
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
				<#if newsPaperList?? && (newsPaperList?size>0)>
				<div class="title07">${newsPaperList[page - 1].title}
				</#if>
					<form>
						<select id="ddlYears2">
							<#list years as year>
							    <#if year != curYear> 
								<option value=${year}>${year}年</option>
								<#else>
								<option value=${year} selected="selected">${year}年</option>
								</#if>
							</#list>
						</select>
						<select id="ddlTimes2">
							<#list times as time>
							   <#if time != curTimes> 
                                <option value=${time}>${time}期</option>
                                <#else>
                                <option value=${time} selected="selected">${time}期</option>
                                </#if>
							</#list>>
						</select>
						<input type="button" id="GoToNewspaper2" value="阅览">
					</form>
					<div class="clear"></div>
				</div>
				<div class="inst">
					<div class="instRleft">
						<ul>
						    <#if newsPaperList??>
							<#list newsPaperList as key>
							<#if key_index == 0>
								<li class="first">
								<#-- index从0开始，page从1开始-->
								<#if key_index == page - 1>
									<a class="active" href="${key.url}">${key_index + 1}
								<#else>
									<a href="${key.url}">${key_index + 1}
								</#if>
										<em class="animated">
											<span class="title">第${key_index + 1}页</span>
										</em>
									</a>
								</li>
							<#else>
								<li >
								<#if key_index == page - 1>
									<a class="active" href="${key.url}">${key_index + 1}
								<#else>
									<a href="${key.url}">${key_index + 1}
								</#if>
										<em class="animated">
											<span class="title">第${key_index + 1}页</span>
										</em>
									</a>
								</li>
							</#if>
							</#list>
							</#if>
						</ul>
					</div>
					<div class="instRright">
					    <#if newsPaperList??>
						<#--${newsPaperList[page].content}-->
					   <p>
					       <span style="font-size:16px;">下载链接：</span>
					       <a href="${newsPaperList[page - 1].downloadUrl}" target="_blank">
					           <span style="font-size:16px;">${newsPaperList[page - 1].title}</span>
					       </a>
                       </p>
                       <p>
                            <img src="${newsPaperList[page - 1].imageUrl}" alt="" />
                        </p>
                        </#if>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</div>
<#include "./fragments/_footer.ftl">
