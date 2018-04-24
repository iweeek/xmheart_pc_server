 <#include "./fragments/_header.ftl"> 
 
    <div class="xm-main">
        <div class="xm-container report-container">
			<h3 class="title30">报告查询</h3>
			
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
                <span id="captchaChecked" style="display:none;color:green;font-weight:bold;font-size: 20px;float: left;padding-top: 10px;">√</span>
                <span id="captchaCheckedError" style="display:none;color:red;font-weight:bold;font-size: 20px;float: left;padding-top: 10px;">×</span>
                
				<button class="blueBtn" id="reportSearch" style="float: left;margin-left: 50px;">查询报告</button>
				
				<img src="../../img/layout/icon_document.png" style="float:left;padding-left: 80px;">
				<span style="float:left;padding-top: 15px;">&nbsp;&nbsp;&nbsp;检验报告</span>
				<img src="../../img/layout/icon_document_pacs.jpg" style="float:left;padding-left:20px">
				<span style="float:left;padding-top: 15px;">&nbsp;&nbsp;&nbsp;检查报告</span>
			</div>
			
			<!-- 空提示，blankTip 和下方的lightBlueBg不同时出现 -->
			<div class="blankTip" id="reportLisBlank">很抱歉！无法查询到相关病人信息，可能尚未出报告或病人信息输入有误！</div>
			
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
