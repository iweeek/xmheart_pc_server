 <#include "./fragments/_header.ftl"> 
 
    <div class="xm-main">
        <div class="xm-container">
			<h3 class="title30">报告查询</h3>
			<div class="reportSearch">
				<label for="reportName">姓名</label>
				<input id="reportName" class="commonInput" placeholder="请输入您的真实姓名" />
				<label for="reportNo">编号</label>
				<input id="reportNo" class="commonInput" placeholder="请输入您的编号" />
				<label for="hospitalNo">门诊号或住院号</label>
				<input id="hospitalNo" class="commonInput" placeholder="请输入门诊号或住院号" />
				<button class="blueBtn" id="reportSearch">查询报告</button>
			</div>
			<div class="lightBlueBg clearfix_n">
				<dl class="reportInfo">
					<dt>洪光远</dt>
					<dd>男 / 66岁</dd>
				</dl>
				<dl>
					<dt>住院号</dt>
					<dd>614502001</dd>
				</dl>
				<dl>
					<dt>床号</dt>
					<dd>1号</dd>
				</dl>
				<dl>
					<dt>主管医生</dt>
					<dd>尤颢/D512</dd>
				</dl>
				<dl>
					<dt>入院日期</dt>
					<dd>2018/03/04</dd>
				</dl>
				<dl>
					<dt>出院日期</dt>
					<dd>2018/03/08</dd>
				</dl>
			</div>
			<ul class="reportList clearfix_n">
				<li>
					<a href="#">
						<p>急诊血常规检查（进口五分类）</p>
						<p class="reportDate">2018.03.04</p>
					</a>
				</li>
				<li>
					<a href="#">
						<p>急诊常规生化全套检查</p>
						<p class="reportDate">2018.03.04</p>
					</a>
				</li>
				<li>
					<a href="#">
						<p>急诊B型钠尿肽(BNP)测试；急诊...</p>
						<p class="reportDate">2018.03.04</p>
					</a>
				</li>
				<li>
					<a href="#">
						<p>急诊血常规检查（进口五分类）</p>
						<p class="reportDate">2018.03.04</p>
					</a>
				</li>
				<li>
					<a href="#">
						<p>急诊常规生化全套检查</p>
						<p class="reportDate">2018.03.04</p>
					</a>
				</li>
				<li>
					<a href="#">
						<p>急诊B型钠尿肽(BNP)测试；急诊...</p>
						<p class="reportDate">2018.03.04</p>
					</a>
				</li>
				<li>
					<a href="#">
						<p>急诊血常规检查（进口五分类）</p>
						<p class="reportDate">2018.03.04</p>
					</a>
				</li>
				<li>
					<a href="#">
						<p>急诊常规生化全套检查</p>
						<p class="reportDate">2018.03.04</p>
					</a>
				</li>
				<li>
					<a href="#">
						<p>急诊B型钠尿肽(BNP)测试；急诊...</p>
						<p class="reportDate">2018.03.04</p>
					</a>
				</li>
			</ul>
			<ul class="reportPager clearfix_n">
				<li><a href="#" class="current">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
			</ul>
		</div>
    </div>
    <!-- banner -->
    <div class="xm-banner">
       
    </div>

<#include "./fragments/_footer.ftl">
