<#include "./fragments/_header.ftl">
<!-- list container -->
<div class="breadcrumb">
	<div class="xm-container">
        <span class="icon"></span><a href="#">您当前所在位置 首页 &gt ${parentColumnName} &gt ${columnName}</a>
		<#--  <a href="#">${parentColumnName}</a><i>/</i><span>${columnName}</span>-->
	</div>
</div>
<div class="list-container">
	<div class="list-main">
		<div class="list-main-nav">
			<h4 class="list-nav-title">${parentColumnName}</h4>
			<ul class="list-nav-list">
			<#list leftNav as k>
				<#if k.columnName == columnName>
					<li class="active"><a href="${k.url}">${k.columnName}</a>
				<#else>
					<li><a href="${k.url}">${k.columnName}</a></li>
				</#if>
			</#list>
			</ul>
		</div>
		<div class="baseRight list-media">
			<div class="title01">${columnName}</div>
			<div class="media-wrapper">
				<#list pinnedArticleList as key>
				<div class="media-item">
					<a href="${key.url}">
						<div class="media-img"><img src="${key.imgUrl}" alt=""></div>
						<div class="media-info">
							<h4 class="media-info-title">${key.title}</h4>
							<p class="media-info-desc">内容摘要，暂时缺乏该字段</p>
							<!-- <#if key.brief?length gt 20>
								<p class="media-info-desc">${key.brief[0..20]}</p>
							<#else>
								<p class="media-info-desc">${key.brief}</p>
							</#if> -->
							<div class="media-bottom">
								<span class="date">${key.publishTime?date}</span>
							</div>
						</div>
					</a>
				</div>
				</#list>
			</div>
			<div class="newList">
				<ul>
					<#list noPinnedArticleList as k>
					<li>
						<div class="headLines">
							<span class="labelTitle">${k.columnName}</span>
							<a href="${k.url}" title="${k.columnName}" target="_blank"class="title" >${k.title}</a>
							<!--<p>●7月6日，检验科举办了第二次“翻转课堂”，围绕影响生化结果的常见因素、降钙素原等话题进行了交流学习。 (检验科 朱亚）●7月6日，我院与太康县人民医院互联智慧分级诊疗远程云心电项目正式...</p>-->
							<#if k.brief?length gt 100>
								样式存在问题。
								<p>${k.brief[0..100]}</p>
							<#else>
								<p>${k.brief}</p>
							</#if>
						</div>
						<div class="date">
							<h3>发布时间</h3>
							<h4>${k.publishTime?date}</h4>
						</div>
						<div class="listBtn">
							<a href="${k.url}" title="综合简讯" target="_blank">查看详情</a>
						</div>
						<div class="clear"></div>
					</li>
					</#list>
			    </ul>
		     </div>
			<div class="clear"></div>
			<div class="list-pagination">
				<ul class="paginations">
					<#if pageInfo.pageNum != 1>
						<li><a href="?page=${pageInfo.prePage}"><<</a></li>
					</#if>
					<#if pageInfo.pageNum + 4 lt pageInfo.pages>
    					<#list pageInfo.pageNum..pageInfo.pageNum + 4 as i>
    						<li><a href="?page=${i}">${i}</a></li>
                        </#list>
    					<li><a href="?page=${pageInfo.pageNum+5}">>></a></li>
    				<#else>
                        <#list 2..pageInfo.pages as i>
						  <li><a href="?page=${i}">${i}</a></li>
                        </#list>
					</#if>
				</ul>
			</div>
		</div>
	</div>
</div>
<#include "./fragments/_footer.ftl">
