 <#include "./fragments/_header.ftl"> 
	<div class="list-container">
		<div class="list-main">
			<div class="Service">
				<div class="title">搜索结果</div>
				<div class="emailMain">
					<div class="tabBase">
						<#--<a href="search?type=1&amp;SearchWords=" id="ASearchAll" class="active">全站内容</a>-->
						<a href="search?type=2&amp;SearchWords=" id="ASearchDoctor">医生查询</a>
						<a href="search?type=3&amp;SearchWords=" id="ASearchNews">文章查询</a>
						<#--<a href="search?type=4&amp;SearchWords=" id="ASearchOffice">科室查询</a>-->
					</div>
					<div class="clear"></div>
					<div class="emaillist">
					    <#if articleList??>
					    <#list articleList as article>
						<div class="newsItem">
							<div class="headLines">
								<h2>
								<a href="${article.url}" target="_blank">
								${article.title}
								</a>
								</h2>
								<p><a href="${article.url}" target="_blank">
								<#if article.brief?length lt 120>
								${article.brief}
								<#else>
								${article.brief[0..120]}......
								</#if>
								</a></p>
							</div>
							<div class="date">
								<h3>发布时间</h3>
								<h4>${article.publishTime?string('yyyy-MM-dd')}</h4>
								<#--<p>来源<em>${article.columnName}/em></p>-->
							</div>
							<div class="listBtn">
								<a href="${article.url}" target="_blank">进入</a>
							</div>
							<div class="clear"></div>
						</div>
						</#list>
						<#elseif doctorList??>
						<#list doctorList as doctor>
                         <div class="newsItem">
                            <div class="headLines">
                                <h2>
                                <a href="${doctor.url}" target="_blank">
                                ${doctor.name}
                                </a>
                                </h2>
                                <p><a href="${doctor.url}" target="_blank">
                                <#if doctor.brief?length lt 120>
                                ${doctor.brief}
                                <#else>
                                ${doctor.brief[0..120]}......
                                </#if>
                                </a></p>
                            </div>
                            <#--<div class="date">
                                <h3>发布时间</h3>
                                <h4>${doctor.publishTime?string('yyyy-MM-dd')}</h4>
                                <p>来源<em>${article.columnName}/em></p>
                            </div>-->
                            <div class="listBtn">
                                <a href="${doctor.url}" target="_blank">进入</a>
                            </div>
                            <div class="clear"></div>
                        </div>
                        </#list>
						
						</#if>
					</div>
				</div>
			</div>
		</div>
	</div>
				
	

<#include "./fragments/_footer.ftl">
