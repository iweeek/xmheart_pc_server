exports = this;
exports.XPW = exports.EDIT || {};
exports.XPW.NavEdit = (function() {
  function NavEdit() {
    // 初始化页面处理。
    NavEdit.firstNavLoad();
    NavEdit.firstSelectHandle();
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
	  if (!date) return ''
	  var date = new Date(date)

	  formatString = formatString || 'yyyy-MM-dd'

	  var dateMap = {
	    year: date.getFullYear(),
	    month: date.getMonth() + 1,
	    day: date.getDate(),
	    hour: date.getHours(),
	    minutes: date.getMinutes(),
	    seconds: date.getSeconds()
	  }

	  for (var key in dateMap) {
	    let value = dateMap[key]
	    value = value < 10 ? ('0' + value) : value
	    dateMap[key] = value.toString()
	  }

	  const { year, month, day, hour, minutes, seconds } = dateMap

	  const formatDate = formatString
	    .replace(/y+/, ($0) => (year.substring(year.length, -$0.length)))
	    .replace(/M+/, () => month)
	    .replace(/d+/, () => day)
	    .replace(/H+/, () => hour)
	    .replace(/h+/, () => hour % 12 === 0 ? 12 : hour % 12)
	    .replace(/m+/, () => minutes)
	    .replace(/s+/, () => seconds)
	  return formatDate
	}
 

  return NavEdit;
})();
