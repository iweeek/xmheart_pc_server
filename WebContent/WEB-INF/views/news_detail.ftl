<#include "./fragments/_header.ftl"> 
	<!-- list container -->
	<#--<div class="breadcrumb">
		<div class="xm-container">
		    <span class="icon"></span><a href="#">您当前所在位置 首页 &gt ${parentColumnName} &gt ${article.columnName}</a>
		</div>
	</div>-->
	<div class="list-container">
		<div class="list-main">
			<div class="list-main-nav">
			<h4 class="list-nav-title">${parentColumnName}</h4>
			<ul class="list-nav-list">
			<#list leftNav as k>
				<#if k.columnName == article.columnName>
					<li class="active"><a href="${k.url}">${k.columnName}</a>
				<#else>
					<li><a href="${k.url}">${k.columnName}</a></li>
				</#if>
			</#list>
			</ul>
		</div>
			<div class="baseRight list-news">
				<div class="title01">${article.columnName}</div>
				<div class="article detail">
					<h2 id="H2Title">${article.title}</h2>
					<div id="DIVTool" class="title04">
						<span id="SPANDate">发布日期：${article.publishTime?date}</span>
						<span>字号调整
							<em id="EMChange">
								<img src="img/detail/font_ico02.png" alt="" width="22" height="23">
								<a class="fot12" href="javascript:;" data-type="0"></a>
								<a class="fot14" href="javascript:;" data-type="1"></a>
								<a class="fot16" href="javascript:;" data-type="2"></a>
							</em>
							<b id="FontState">16px</b>
						</span>
						<!--<span id="SPANNum" style="border:none; margin-right:0;">浏览次数（3093）</span>
						<div class="itemBase" id="phoneArticle">
							<div class="divType">手机看新闻</div>
							<ul>
								<li><img src="uploadfiles/QR/news/8345.jpg" width="95" height="95" alt=""></li>
							</ul>
						</div>
						<div class="itemBase share">
							<div id="bdshare" class="bdshare_b divType" style="padding:0px; float:none;">分享此篇文章（<em class="shareCount" title="累计分享0次">0</em>）
							</div>
							<script type="text/javascript" id="bdshare_js" data="type=button&amp;uid=6713615" src="http://bdimg.share.baidu.com/static/js/bds_s_v2.js?cdnversion=417542"></script>
							<script type="text/javascript">document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + Math.ceil(new Date() / 3600000);</script>
						</div>-->
					</div>
					<div class="clear"></div>
					<div id="DIVContent" class="DIVContent">
						${article.content}
					</div>
		          <div class="PrevNext">
		              <p class="prev">
		              <#if articlePrev??>
		                  <a href="${articlePrev.url}" class="btn-prev-next">上一篇</a>
                          <a href="${articlePrev.url}" title="${articlePrev.title}">${articlePrev.title}</a>
		              <#else>
    		              <a href="#" class="btn-prev-next">上一篇</a>
    		              <a disabled="disabled" title="已经是第一篇">[已经是第一篇]</a>
		              </#if>
		              </p>
		              <p class="next">
		              <#if articleNext??>
		                  <a href="${articleNext.url}" class="btn-prev-next">下一篇</a>
                          <a href="${articleNext.url}" title="${articleNext.title}">${articleNext.title}</a>
		          	  <#else>
		                  <a href="#" class="btn-prev-next">下一篇</a>
		                  <a disabled="disabled" title="已经是最后一篇">[已经是最后一篇]</a>
		              </#if>
		          	</p>
		          </div>
				</div>
			</div>
		</div>
	</div>
<#include "./fragments/_footer.ftl">
