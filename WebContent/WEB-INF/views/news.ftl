<#include "./fragments/_header.ftl">
<!-- list container -->
<!-- <div class="breadcrumb">
	<div class="xm-container">
        <span class="icon"></span><a href="#">您当前所在位置 首页 &gt ${parentColumnName} &gt ${columnName}</a>
		<#--  <a href="#">${parentColumnName}</a><i>/</i><span>${columnName}</span>-->
	</div>
</div> -->
<div class="list-container">
	<div class="list-main">
		<#if parentColumnName == '党群工作'>
			<div class="list-main-nav party-work">
		<#else>
			<div class="list-main-nav">
		</#if>
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
                <#if pinnedArticleList??>
				<#list pinnedArticleList as key>
				<div class="media-item">
					<a href="${key.url}">
						<div class="media-img"><img src="${key.imgUrl}" alt=""></div>
						<div class="media-info">
						    <#if key.title?length gt 20>
                                <h4 class="media-info-title">${key.title[0..20]}......</h4>
                            <#else>
                                <h4 class="media-info-title">${key.title}</h4>
                            </#if>
							<#if key.brief?length gt 30>
								<p class="media-info-desc">${key.brief[0..30]}......</p>
							<#else>
								<p class="media-info-desc">${key.brief}</p>
							</#if>
							<div class="media-bottom">
								<span class="date">${key.publishTime?string('yyyy-MM-dd')}</span>
							</div>
						</div>
					</a>
				</div>
				</#list>
                </#if>
			</div>
			<div class="newList">
				<ul>
                    <#if noPinnedArticleList??>
    					<#list noPinnedArticleList as k>
    					<li>
    						<div class="headLines">
    							<span class="labelTitle">${k.columnName}</span>
    							<a href="${k.url}" title="${k.columnName}" target="_blank"class="title" >${k.title}</a>
    							<#if k.brief?length gt 100>
    								<p>&#8195;&#8195;${k.brief[0..100]}......</p>
    							<#else>
    								<p>&#8195;&#8195;${k.brief}</p>
    							</#if>
    						</div>
    						<div class="date">
    							<h3>发布时间</h3>
    							<h4>${k.publishTime?string('yyyy-MM-dd')}</h4>
    						</div>
    						<div class="listBtn">
    							<a href="${k.url}" title="综合简讯" target="_blank">查看详情</a>
    						</div>
    						<div class="clear"></div>
    					</li>
    					</#list>
                    </#if>
			    </ul>
		     </div>
			<div class="clear"></div>
		</div>
	</div>
</div>
<#include "./fragments/_footer.ftl">
