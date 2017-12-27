		<#if firstColumnName != "首页">
		    <div class="list-pagination">
                <ul class="paginations">
                    <#if pageInfo?? && (pageInfo.pages > 0)>
                        <#if pageInfo.pages lt 5><!-- 如果页面总是小于5，直接显示完 -->
                            <#list 1..pageInfo.pages as i>
                                <#if pageInfo.pageNum == i>
                                    <li><a href="?page=${i}" class="current">${i}</a></li>
                                <#else>
                                    <li><a href="?page=${i}">${i}</a></li>
                                </#if>
                            </#list>
                        <#else>
                            <#if pageInfo.pageNum gt 3 >
                                <li><a href="?page=${pageInfo.prePage}"><<</a></li>
                            </#if>
                                <#if pageInfo.pageNum <= 2 >  
                                    <#list  1..(pageInfo.pageNum + (5 - pageInfo.pageNum)) as i> <!-- 前两页开头显示5页 -->
                                         <#if pageInfo.pageNum == i>
                                     <li><a href="?page=${i}" class="current">${i}</a></li>
                                     <#else>
                                     <li><a href="?page=${i}">${i}</a></li>
                                     </#if>
                                 </#list>
                                 <li><a href="?page=${pageInfo.pageNum+1}">>></a></li>
                                <#elseif (pageInfo.pageNum gt 2) && (pageInfo.pageNum lt pageInfo.pages - 2)> 
                                    <#list (pageInfo.pageNum - 2)..(pageInfo.pageNum + 2) as i>
                                        <#if pageInfo.pageNum == i>
                                     <li><a href="?page=${i}" class="current">${i}</a></li>
                                     <#else>
                                     <li><a href="?page=${i}">${i}</a></li>
                                     </#if>
                                 </#list>
                                 <li><a href="?page=${pageInfo.pageNum+1}">>></a></li>
                             <#else>
                                 <#list (pageInfo.pages - 4)..pageInfo.pages as i> <!-- 后两页结尾显示5页 -->
                                        <#if pageInfo.pageNum == i>
                                     <li><a href="?page=${i}" class="current">${i}</a></li>
                                     <#else>
                                     <li><a href="?page=${i}">${i}</a></li>
                                     </#if>
                                 </#list>
                            </#if>
                            </#if>
                    </#if>
                </ul>
            </div>
		</#if>
		
		<!-- 搜索页 -->
		<#if isSearch?? && isSearch>
		    <div class="list-pagination">
                <ul class="paginations">
                    <#if pageInfo?? && (pageInfo.pages > 0)>
                        <#if pageInfo.pages lt 5><!-- 如果页面总是小于5，直接显示完 -->
                            <#list 1..pageInfo.pages as i>
                                <#if pageInfo.pageNum == i>
                                    <li><a href="?type=3&keywords=医&page=${i}" class="current">${i}</a></li>
                                <#else>
                                    <li><a href="?type=3&keywords=医&page=${i}">${i}</a></li>
                                </#if>
                            </#list>
                        <#else>
                            <#if pageInfo.pageNum gt 3 >
                                <li><a href="?type=${type}&keywords=${keywords}&page=${pageInfo.prePage}"><<</a></li>
                            </#if>
                                <#if pageInfo.pageNum <= 2 >  
                                    <#list  1..(pageInfo.pageNum + (5 - pageInfo.pageNum)) as i> <!-- 前两页开头显示5页 -->
                                         <#if pageInfo.pageNum == i>
                                     <li><a href="?type=${type}&keywords=${keywords}&page=${i}" class="current">${i}</a></li>
                                     <#else>
                                     <li><a href="?type=${type}&keywords=${keywords}&page=${i}">${i}</a></li>
                                     </#if>
                                 </#list>
                                 <li><a href="?type=${type}&keywords=${keywords}&page=${pageInfo.pageNum+1}">>></a></li>
                                <#elseif (pageInfo.pageNum gt 2) && (pageInfo.pageNum lt pageInfo.pages - 2)> 
                                    <#list (pageInfo.pageNum - 2)..(pageInfo.pageNum + 2) as i>
                                        <#if pageInfo.pageNum == i>
                                     <li><a href="?type=${type}&keywords=${keywords}&page=${i}" class="current">${i}</a></li>
                                     <#else>
                                     <li><a href="?type=${type}&keywords=${keywords}&page=${i}">${i}</a></li>
                                     </#if>
                                 </#list>
                                 <li><a href="?type=${type}&keywords=${keywords}&page=${pageInfo.pageNum+1}">>></a></li>
                             <#else>
                                 <#list (pageInfo.pages - 4)..pageInfo.pages as i> <!-- 后两页结尾显示5页 -->
                                        <#if pageInfo.pageNum == i>
                                     <li><a href="?type=${type}&keywords=${keywords}&page=${i}" class="current">${i}</a></li>
                                     <#else>
                                     <li><a href="?type=${type}&keywords=${keywords}&page=${i}">${i}</a></li>
                                     </#if>
                                 </#list>
                            </#if>
                            </#if>
                    </#if>
                </ul>
            </div>
		</#if>
		
		
		<div class="xm-footer">
			<div class="xm-footer-main">
			    <#if language??>
                    <#if language == 0>
                     <div class="xm-footer-link">
                        <a href="http://www.xmhealth.gov.cn/" target="_blank">厦门市卫生和计划生育委员会</a>
                        <span>|</span>
                        <a href="http://www.xmsmjk.com/" target="_blank">厦门市民健康信息系统</a>
                        <span>|</span>
                        <a href="http://www.xmu.edu.cn/" target="_blank">厦门大学</a>
                        <span>|</span>
                        <a href="http://med.xmu.edu.cn/" target="_blank">厦门大学医学院</a>
                        <span>|</span>
                        <a href="http://www.xmwsrc.com/" target="_blank">厦门卫生人才服务中心</a>
                        <span>|</span>
                        <a href="http://www.cma.org.cn/" target="_blank">中华医学会</a>
                        <span>|</span>
                        <a href="http://www.ccahouse.org/index.html" target="_blank">中国心血管健康联盟</a>
                    </div>
                    <div class="xm-footer-link">
                        <a href="/mapDetail?id=29"  target="_blank">网站地图</a>
                        <span>|</span>
                        <a href="#">法律声明</a>
                        <span>|</span>
                        <a href="#">版权声明</a>
                        <span>|</span>
                        <a href="#">隐私安全</a>
                        <span>|</span>
                        <a href="#">帮助信息</a>
                    </div>
                    <#else> 
                        
                    </#if>
                <#else>
                 <div class="xm-footer-link">
                    <a href="http://www.xmhealth.gov.cn/" target="_blank">厦门市卫生和计划生育委员会</a>
                    <span>|</span>
                    <a href="http://www.xmsmjk.com/" target="_blank">厦门市民健康信息系统</a>
                    <span>|</span>
                    <a href="http://www.xmu.edu.cn/" target="_blank">厦门大学</a>
                    <span>|</span>
                    <a href="http://med.xmu.edu.cn/" target="_blank">厦门大学医学院</a>
                    <span>|</span>
                    <a href="http://www.xmwsrc.com/" target="_blank">厦门卫生人才服务中心</a>
                    <span>|</span>
                    <a href="http://www.cma.org.cn/" target="_blank">中华医学会</a>
                    <span>|</span>
                    <a href="http://www.ccahouse.org/index.html" target="_blank">中国心血管健康联盟</a>
                </div>
                <div class="xm-footer-link">
                    <a href="/mapDetail?id=29"  target="_blank">网站地图</a>
                    <span>|</span>
                    <a href="#">法律声明</a>
                    <span>|</span>
                    <a href="#">版权声明</a>
                    <span>|</span>
                    <a href="#">隐私安全</a>
                    <span>|</span>
                    <a href="#">帮助信息</a>
                </div>
                </#if>
			
			   
				
				<p class="xm-footer-info">
				    <#if language??>
                        <#if language == 0>
                        版权所有：厦门大学附属心血管病医院（本网站所有内容未经许可，不得以任何形式进行转载）
                        <#else> 
                        
                        Copyright © 2017 Xiamen Cardiovascular Hospital Xiamen University. All rights reserved
                        </#if>
                    <#else> 
                        版权所有：厦门大学附属心血管病医院（本网站所有内容未经许可，不得以任何形式进行转载）
                    </#if>
                </p>
                
                <#if language??>
                    <#if language == 0>
                    <#else> 
                        <p class="xm-footer-info">
                        Address : No.205, Hubin South Street,Xiamen,China
                        </p>
                    </#if>
                <#else>      
                </#if>
				<p class="xm-footer-info">闽ICP备09051364号-1</p>
				<script src="http://dcs.conac.cn/js/14/215/0000/41619365/CA142150000416193650001.js"></script>
			</div>
		</div>
		<script src="/js/third_party/jquery.min.js"></script>
		<script src="/js/respond.min.js"></script>
		<script src="/js/swiper-3.4.2.jquery.min.js"></script>
		<script type="text/javascript" src="./js/third_party/jquery.jplayer.min.js"></script>
    		<script type="text/javascript" src="./js/third_party/jplayer.playlist.min.js"></script>
		<script src="/js/common.js"></script>
		
		<#--<#if firstColumnName != "首页">
        <div class="xm-float-right">
            <a>
                <img src="/image/img21.png">
                <p>收起</p>
            </a>
            <a style="display: block;">
                <img src="/image/img11.png"><i></i>
                <div class="up" style="display: none; opacity: 1;">掌上厦心</div>
                <div class="code"><img src="/image/barcode_app.gif" alt=""></div>
            </a>
            <a href="#" style="display: block;">
                <img src="/image/img12.png"><i></i>
                <div class="up" style="display: none; opacity: 1;">官方微信</div>
                <!--<div class="code"><img src="/image/barcode_wx.gif" alt=""></div>
            </a>
            <a href="#" style="display: block;">
                <img src="/image/img13.png"><i></i>
                <div class="up" style="opacity: 1; display: none;">官方微博</div>
                <!--<div class="code"><img src="/image/barcode_wx.gif" alt=""></div>
            </a>
            <a href="#" style="display: block;">
                <img src="/image/img14.png"><i></i>
                <div class="up" style="display: none; opacity: 1;">我要挂号</div>
            </a>
            <!--<a href="/Interactions/HospitalMails" style="display: block;">
                <img src="/image/img15.png"><i></i>
                <div class="up" style="opacity: 1; display: none;">意见信箱</div>
            </a>
            <a href="http://www.fuwaihospital.org/rsc/List.aspx" style="display: block;">
                <img src="/image/img16.png"><i></i>
                <div class="up" style="opacity: 1; display: none;">我要求职</div>
            </a>
            <a class="gotop" href="#">
                <img src="/image/img18.png"><i></i>
                <div class="up" style="opacity: 1; display: none;">返回顶部</div>
            </a>
        </div>
        </#if>-->
    </body>
</html>
<script>
    //创建和初始化地图函数：
    function initMap(){
        createMap();//创建地图
        setMapEvent();//设置地图事件
        addMapControl();//向地图添加控件
        addMarker();//向地图中添加marker
    }
    
    //创建地图函数：
    function createMap(){
        var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
        var point = new BMap.Point(118.104588,24.477125);//定义一个中心点坐标
        map.centerAndZoom(point,17);//设定地图的中心点和坐标并将地图显示在地图容器中
        window.map = map;//将map变量存储在全局
    }
    
    //地图事件设置函数：
    function setMapEvent(){
        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
        map.enableScrollWheelZoom();//启用地图滚轮放大缩小
        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
        map.enableKeyboard();//启用键盘上下左右键移动地图
    }
    
    //地图控件添加函数：
    function addMapControl(){
        //向地图中添加缩放控件
    var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
    map.addControl(ctrl_nav);
        //向地图中添加缩略图控件
    var ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:1});
    map.addControl(ctrl_ove);
        //向地图中添加比例尺控件
    var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
    map.addControl(ctrl_sca);
    }
    
        //标注点数组
    var markerArr = [{title:"厦门大学附属心血管医院",content:"地址：厦门市湖滨南路205号振河大楼",point:"118.104525|24.476845",isOpen:1,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}];
    //创建marker
    function addMarker(){
        for(var i=0;i<markerArr.length;i++){
            var json = markerArr[i];
            var p0 = json.point.split("|")[0];
            var p1 = json.point.split("|")[1];
            var point = new BMap.Point(p0,p1);
            var iconImg = createIcon(json.icon);
            var marker = new BMap.Marker(point,{icon:iconImg});
            var iw = createInfoWindow(i);
            var label = new BMap.Label(json.title,{"offset":new BMap.Size(json.icon.lb-json.icon.x+10,-20)});
            marker.setLabel(label);
            map.addOverlay(marker);
            label.setStyle({
                        borderColor:"#808080",
                        color:"#333",
                        cursor:"pointer"
            });
            
            (function(){
                var index = i;
                var _iw = createInfoWindow(i);
                var _marker = marker;
                _marker.addEventListener("click",function(){
                    this.openInfoWindow(_iw);
                });
                _iw.addEventListener("open",function(){
                    _marker.getLabel().hide();
                })
                _iw.addEventListener("close",function(){
                    _marker.getLabel().show();
                })
                label.addEventListener("click",function(){
                    _marker.openInfoWindow(_iw);
                })
                if(!!json.isOpen){
                    label.hide();
                    _marker.openInfoWindow(_iw);
                }
            })()
        }
    }
    //创建InfoWindow
    function createInfoWindow(i){
        var json = markerArr[i];
        var iw = new BMap.InfoWindow("<b class='iw_poi_title' title='" + json.title + "'>" + json.title + "</b><div class='iw_poi_content'>"+json.content+"</div>");
        return iw;
    }
    //创建一个Icon
    function createIcon(json){
        var icon = new BMap.Icon("http://app.baidu.com/map/images/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
        return icon;
    }
    
    initMap();//创建和初始化地图
    
    $('.xm-float-right a:first').click(function(){
        if(!$(this).hasClass('hide')){
            $(this).children('p').text('展开');
            $(this).addClass('hide').nextAll(':not(:last)').css('display','none');
        }else{
            $(this).children('p').text('收起');
            $(this).removeClass('hide').nextAll(':not(:last)').css('display','block');
        }
    });
    $('.xm-float-right a').hover(function(){
        $(this).find('.up').stop().fadeToggle(300);
        $(this).find('.code').fadeToggle(300);
    });
    
	function CheckSearchForm () {
	  	var obj = $("#searchValInput");
	  	var str = $.trim(obj.val());
	  	if (str == "") {
	      	obj.focus();
	      	return false;
	  	}
	  	return true;
	}
    
</script>