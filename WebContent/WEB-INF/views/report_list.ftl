 <#include "./fragments/_header.ftl"> 
 
    <div class="xm-main">
        <div class="xm-container">
			<h3 class="title30">检验报告、检查报告</h3>
			
			<div class="reportSearch">
				<label for="reportName">姓名</label>
				<input id="reportName" class="commonInput" placeholder="请输入您的真实姓名" />
				<label for="hospitalNo">门诊号或住院号</label>
				<input id="hospitalNo" class="commonInput" placeholder="请输入门诊号或住院号" />
				<!-- <label for="category">就诊类型</label>
				<select id="category" class="commonInput commonSelect" placeholder="请选择就诊类型">
					<option>门急诊</option>
					<option>住院</option>
					<option>体检</option>
				</select> -->
				<label for="codeNo">验证码</label>
				<input id="codeNo" class="commonInput codeNo" placeholder="请输入验证码" />
                
                <img class="captcha_img" id="captchaImg" alt="点击刷新验证码" >  
                <span id="captchaChecked" style="display:none;color:green;font-weight:bold">√</span>
                
				<button class="blueBtn" id="reportSearch">查询报告</button>
			</div>
			
			<!-- 空提示，blankTip 和下方的lightBlueBg不同时出现 -->
			<div class="blankTip" id="reportLisBlank">抱歉，暂时搜索不到你要查找的信息！</div>
			
			<ul class="reportList clearfix_n">
                <div id="content"/>
			</ul>
			
			<!--
			<ul class="reportPager clearfix_n">
				<li><a href="#" class="current">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
			</ul>
			-->
		</div>
    </div>
    <!-- banner -->
    <div class="xm-banner">
       
    </div>
    
    <div class="loadingTip" id="reportLisLoading"></div>

<#include "./fragments/_footer.ftl">
