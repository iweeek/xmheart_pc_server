exports = this;
exports.XPW = exports.EDIT || {};
exports.XPW.NavEdit = (function() {
  function NavEdit() {
    // 初始化页面处理。
    NavEdit.firstNavLoad();
    NavEdit.firstSelectHandle();
    NavEdit.postDialogHandle();
    NavEdit.select2Handle()
    NavEdit.bindNavNews()
  }
  NavEdit.firstNavLoad = function () {
	$.ajax({
	  url: '/columns',
      type: 'GET',
      dataType: 'json',
      data: {parentColumnId: 0}
    })
   .done(function(data) {
     var firstColumnTemplate = $('#firstColumnTemplate').html();
     Mustache.parse(firstColumnTemplate);   // optional, speeds up future uses
     var rendered = Mustache.render(firstColumnTemplate, {data});
     $('#typeSelectInput').html(rendered);
   })
  }

  NavEdit.firstSelectHandle = function () {
    $('#columnSearch').click(function() {
    		var val = $('#typeSelectInput').val();
    		NavEdit.firstColumnData(val);
    })
  }

  NavEdit.firstColumnData = function (val) {
    $.ajax({
      url: '/navs',
      type: 'GET',
      dataType: 'json',
      data: {columnId: val}
    })
    .done(function(data) {
    		if (data.length > 0) {
    			$.each(data, function(name, val){
    	    	   	  val.publishTime = NavEdit._dateFilter(val.publishTime)
    	    	    })
    	    		var secondColumnTemplate = $('#secondColumnTd').html();
    	    	    Mustache.parse(secondColumnTemplate);   // optional, speeds up future uses
    	    	    var rendered = Mustache.render(secondColumnTemplate, {data});
    	    	    $('#secondTable').html(rendered);
    		} else {
    			swal({ 
    				  title: "当前一级栏目下没有二级栏目", 
    				  timer: 1500, 
    				  showConfirmButton: false 
    			});
    		}
    })
  }

  NavEdit._dateFilter = function (date, formatString) {
  	if (!date) return '';
  	var date = new Date(date);

  	formatString = formatString || 'yyyy-MM-dd';

  	var dateMap = {
  		year: date.getFullYear(),
  		month: date.getMonth() + 1,
  		day: date.getDate(),
  		hour: date.getHours(),
  		minutes: date.getMinutes(),
  		seconds: date.getSeconds()
  	};

  	for (var key in dateMap) {
  		var value = dateMap[key];
  		value = value < 10 ? '0' + value : value;
  		dateMap[key] = value.toString();
  	}

  	var year = dateMap.year,
  	    month = dateMap.month,
  	    day = dateMap.day,
  	    hour = dateMap.hour,
  	    minutes = dateMap.minutes,
  	    seconds = dateMap.seconds;

  	var formatDate = formatString.replace(/y+/, function ($0) {
  		return year.substring(year.length, -$0.length);
  	}).replace(/M+/, function () {
  		return month;
  	}).replace(/d+/, function () {
  		return day;
  	}).replace(/H+/, function () {
  		return hour;
  	}).replace(/h+/, function () {
  		return hour % 12 === 0 ? 12 : hour % 12;
  	}).replace(/m+/, function () {
  		return minutes;
  	}).replace(/s+/, function () {
  		return seconds;
  	});
  	return formatDate;
  };

  NavEdit.postDialogHandle = function () {
    $('#secondTable').on('click', '.post-btn-edit', function() {
    	  $('#secondColumnId').val($(this).data('column-name'));
    	  $('#secondColumnId').data('column-id', $(this).data('column-id'))
    	  $('#postModal').modal('show');
    })
  }
  
  NavEdit.select2Handle = function () {
	  $('#postModal').on('shown.bs.modal', function(e) {
		  $('#postSelect').select2({
		      placeholder: '请输入要查询的文章标题...',
		      allowClear: true,
		      minimumInputLength: 1,
		      minimumResultsForSearch: Infinity,
		      ajax: {
		        url: '/news/articles/show',
		        dataType: 'json',
		        data: function (params) {
		        		var query = {
	  		        		  keyword: params.term
	  		            }
	  		        return query;
		        },
		        processResults: function (data, params) {
		          var de;
		          return {
		            results: (function () {
		              var i, len, results;
		              results = [];
		              for (i = 0, len = data.length; i < len; i++) {
		                de = data[i];
		                results.push({
		                  id: de.id,
		                  text: de.title
		                });
		              }
		              return results;
		            })()
		          };
		        },
		        cache: true
		      },
		      language: 'zh-CN',
		    });
	  })
	  //	 解决 select2 在 bootstarp 弹窗中无法输入问题
	  $.fn.modal.Constructor.prototype.enforceFocus = function () { };
  }
  
  NavEdit.bindNavNews = function () {
	  $('#postModal').on('click', '#bindNavTitle', function() {
		  var id = $('#secondColumnId').data('column-id')
		  var postId = $('#postSelect').val();
		  $.ajax({
		      url: '/navs/' + id,
		      type: 'POST',
		      data: {id: id, articleId: postId}
		   })
		   .done(function() {
			   $('#postModal').modal('hide');
			   window.location.reload()
		    })
	  })
  }

  return NavEdit;
})();
