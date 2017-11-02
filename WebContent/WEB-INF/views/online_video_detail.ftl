<#include "./fragments/_header.ftl">
	<!-- list container -->
	<div class="breadcrumb">
		<div class="xm-container">
			<a href="#">${parentColumnName}</a><i>/</i><span>${columnName}</span>
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
			<div class="baseRight list-news">
				<div class="title01">在线视频学习</div>
				<div class="article detail">
					<h2 id="H2Title" data-src="${video.videoUrl}">${video.title}</h2>
					<div id="DIVTool" class="title04">
						<span id="SPANDate">发布日期：${video.publishTime?string('yyyy-MM-dd')}</span>
						<!-- <span>字号调整
							<em id="EMChange">
								<img src="img/detail/font_ico02.png" alt="" width="22" height="23">
								<a class="font-size-1" href="javascript:;" data-type="0"></a>
								<a class="font-size-2" href="javascript:;" data-type="1"></a>
								<a class="font-size-3" href="javascript:;" data-type="2"></a>
							</em>
							<b id="FontState">14px</b>
						</span> -->
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
					<div class="video-img-content">
						<div id="jp_container_1" class="jp-video" role="application" aria-label="media player">
							<div class="jp-type-playlist">
								<div id="jquery_jplayer_1" class="jp-jplayer"></div>
								<div class="jp-gui">
									<div class="jp-video-play">
										<button class="jp-video-play-icon" role="button" tabindex="0">play</button>
									</div>
									<div class="jp-interface">
										<div class="jp-progress">
											<div class="jp-seek-bar">
												<div class="jp-play-bar"></div>
											</div>
										</div>
										<div class="jp-current-time" role="timer" aria-label="time">&nbsp;</div>
										<div class="jp-duration" role="timer" aria-label="duration">&nbsp;</div>
										<div class="jp-controls-holder">
											<div class="jp-controls">
												<button class="jp-previous" role="button" tabindex="0">previous</button>
												<button class="jp-play" role="button" tabindex="0">play</button>
												<button class="jp-next" role="button" tabindex="0">next</button>
												<button class="jp-stop" role="button" tabindex="0">stop</button>
											</div>
											<div class="jp-volume-controls">
												<button class="jp-mute" role="button" tabindex="0">mute</button>
												<button class="jp-volume-max" role="button" tabindex="0">max volume</button>
												<div class="jp-volume-bar">
													<div class="jp-volume-bar-value"></div>
												</div>
											</div>
											<div class="jp-toggles">
												<button class="jp-repeat" role="button" tabindex="0">repeat</button>
												<button class="jp-shuffle" role="button" tabindex="0">shuffle</button>
												<button class="jp-full-screen" role="button" tabindex="0">full screen</button>
											</div>
										</div>
										<div class="jp-details">
											<div class="jp-title" aria-label="title">&nbsp;</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- <div class="thumb-up">
            <span>你认为本篇文章有用吗？</span>
            <i class="up fa fa-thumbs-o-up"></i>
            <span>25个赞</span>
          </div> -->
				</div>
			</div>
		</div>
	</div>
<#include "./fragments/_footer.ftl">
