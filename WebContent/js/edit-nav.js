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
    		var secondColumnTemplate = $('#secondColumnTd').html();
    	    Mustache.parse(secondColumnTemplate);   // optional, speeds up future uses
    	    var rendered = Mustache.render(secondColumnTemplate, {data});
    	    $('#secondTable').html(rendered);
    })
  }

 

  return NavEdit;
})();
