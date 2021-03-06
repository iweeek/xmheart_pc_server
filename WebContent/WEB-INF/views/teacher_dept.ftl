<#include "./fragments/_header.ftl">
<!-- list container -->
<!--<div class="breadcrumb">
    <div class="xm-container">
       <span class="icon"></span>您当前所在位置 <a href="index">首页</a> &gt <a href="doctorDept">科研教学</a> 
       &gt <a href="doctorDept">导师团队</a> 
    </div>
</div>-->
<div class="list-container">
	<div class="list-main">
	
		<div class="list-main-nav">
			<h4 class="list-nav-title">科研教学</h4>
			<ul class="list-nav-list">
				<li><a href="/col/47">科教概况</a></li>
				<li><a href="/col/48">科教动态</a></li>
				<li><a href="/col/49">临床教学</a></li>
				<li><a href="/col/50">研究生教育</a></li>
				<li><a href="/col/51">医学伦理委员会</a></li>
				<li class="active"><a href="/teacherTeam">导师团队</a></li>
			</ul>
		</div>
		
		<div class="baseRight list-media teacher-team-wrapper">
			<div class="title01">
				导师团队
				<a href="javascript:;" class="prev"></a>
				<a href="javascript:;" class="next"></a>
			</div>
				<div class="teacher-team swiper-container" id="teacherTeam">
                    <ul data-num="0" class="swiper-wrapper">
                        <#list teachers as teacher>
                        <li class="swiper-slide swiper-slide-prev">
                            <a href="${teacher.url}" title="${teacher.name}" target="_blank" class="img">
                                <img alt="${teacher.name}" title="${teacher.name}" src="${teacher.imageUrl}" width="120" height="162">
                            </a>
                            <a href="${teacher.url}" title="${teacher.name}" target="_blank" class="name">${teacher.name}</a>
                            
                            <br>
                            <a href="${teacher.url}" title="${teacher.name}" target="_blank" class="post">${teacher.professionalTitle} &nbsp;${teacher.grade}</a>
                            <#--  <div class="dept-intro">
                                &emsp;&emsp;王焱，博士，教授，主任医师，博士生导师，厦门大学附属心血管病医院（厦门市......
                                <a href="doctorDetail?id=131" title="心血管内科" class="show-more">查看详细</a>
                            </div> -->
                            <div class="dept-intro">
                                <#if teacher.brief?length lt 35>
                                &#8195;&#8195;${teacher.brief}......
                                <#else>
                                &#8195;&#8195;${teacher.brief[0..35]}......
                                <a href="${teacher.url}" title="${teacher.name}" class="show-more">查看详细</a>
                                </#if>
                            </div>
                        </li>
                        </#list>
                    </ul>
                </div>
			</div>
		</div>
	</div>
</div>

<#include "./fragments/_footer.ftl">
