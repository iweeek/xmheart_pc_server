exports = this;
exports.XPW = exports.EDIT || {};
exports.XPW.NavEdit = (function() {
  function NavEdit() {
    // 初始化页面处理。
    NavEdit.firstNavLoad();
    NavEdit.firstSelectHandle();
    NavEdit.postDialogHandle();
  }
  NavEdit.firstNavLoad = function () {
	$.ajax({
	  url: '/xmheart_pc_server/columns',
      type: 'GET',
      dataType: 'json'
    })
   .done(function(data) {
     var firstColumnTemplate = $('#firstColumnTemplate').html();
     Mustache.parse(firstColumnTemplate);   // optional, speeds up future uses
     var rendered = Mustache.render(firstColumnTemplate, {data});
     $('#typeSelectInput').html(rendered);
   })
  }

  NavEdit.firstSelectHandle = function () {
    $('#typeSelectInput').change(function(){
    	  var val = $(this).val();
      if (val!== '1') {
    	  	NavEdit.firstColumnData(val);
      }
    })
  }

  NavEdit.firstColumnData = function (val) {
    $.ajax({
      url: '/xmheart_pc_server/navs',
      type: 'GET',
      dataType: 'json',
      data: {columnId: val}
    })
    .done(function(data) {
    		$.each(data, function(name, val){
    	   	  val.publishTime = NavEdit._dateFilter(val.publishTime)
    	    })
    		var secondColumnTemplate = $('#secondColumnTd').html();
    	    Mustache.parse(secondColumnTemplate);   // optional, speeds up future uses
    	    var rendered = Mustache.render(secondColumnTemplate, {data});
    	    $('#secondTable').html(rendered);
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
	$('postSelect').select2();
    $('#secondTable').on('click', '.post-btn-edit', function() {
      $('#postModal').modal('show');
    })
  }

  return NavEdit;
})();
