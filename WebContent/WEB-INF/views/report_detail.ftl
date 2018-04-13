 <#include "./fragments/_header.ftl"> 
    <div class="xm-main">
       <div class="xm-container">
			<h3 class="title30">${reportTitle}</h3>
			<div class="reportContent">
				<!--
					<div class="clearfix_n">
					<p>一列字段</p>
					<p class="col_50">两列字段</p>
					<p class="col_50">两列字段</p>
					<p class="col_33">三列字段</p>
					<p class="col_33">三列字段</p>
					<p class="col_33">三列字段</p>
				</div>
				-->
				<div class="lightBlueBg clearfix_n">
					<dl class="reportInfo">
						<dt>${patientName}</dt>
						<dd>${lisDetail.patientAge}</dd>
					</dl>
					<dl>
						<dt>住院号</dt>
						<dd>${lisDetail.visitNo}</dd>
					</dl>
					<dl>
						<dt>床号</dt>
						<dd>${lisDetail.bedNo}</dd>
					</dl>
					<dl>
						<dt>主管医生</dt>
						<dd>${lisDetail.applyOperator}</dd>
					</dl>
					<!--<dl>
						<dt>入院日期</dt>
						<dd>2018/03/04</dd>
					</dl>
					<dl>
						<dt>出院日期</dt>
						<dd>2018/03/08</dd>
					</dl>-->
				</div>
				<p><img class="report_image" id="reportImage" image="${lisDetail.reportPdfurl}" alt="报告图片" /></p>
			</div>
	   </div>
    </div>


<#include "./fragments/_footer.ftl">
