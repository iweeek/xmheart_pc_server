 <#include "./fragments/_header.ftl"> 
 
    <div class="xm-main">
        <div class="xm-container">
			<h3 class="title30">PACS报告查询          <a href="/reportList">-> 切换为LIS报告查询</a>  </h3>
			<div class="reportSearch">
				<label for="reportName">姓名</label>
				<input id="reportName" class="commonInput" placeholder="请输入您的真实姓名" />
				<!--<label for="reportNo">编号</label>
				<input id="reportNo" class="commonInput" placeholder="请输入您的编号" />-->
				<label for="hospitalNo">门诊号或住院号</label>
				<input id="hospitalNo" class="commonInput" placeholder="请输入门诊号或住院号" />
				<button class="blueBtn" id="reportSearchPacs">查询报告</button>
			</div>
			
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

<#include "./fragments/_footer.ftl">
