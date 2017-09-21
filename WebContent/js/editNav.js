exports = this;
exports.EDIT = exports.EDIT || {};
exports.EDIT.NavEdit = (function() {
  function NavEdit() {
    // 初始化页面处理。
    NavEdit.firstSelectHandle();
    NavEdit.SecondSelectHandle();
    NavEdit.dialogHandle();
    NavEdit.firstColumnData();
    NavEdit.postList();
    // NavEdit.secondColumnData();
    NavEdit.postNav = 0;
  }
    NavEdit.firstSelectHandle = function () {
      $('.select-title-first').change(function(){
        if ($(this).val() !== '0') {
          $('.select-title-second').show()
          // 调取二级导航接口
          NavEdit.secondColumnData($(this).val());
        } else {
          $('.select-title-second').hide()
          $('#column').hide()
        }
      })
    }
    NavEdit.SecondSelectHandle = function () {
      $('.select-title-second').change(function(){
        if ($(this).val() !== '0') {
          $('#column').show()
        } else {
          $('#column').hide()
        }
      })
    }

    NavEdit.dialogHandle = function () {
      $('.column-wrapper').on('click', '.column-list .column-list-num', function () {
        $('#dialogBack').show();
        $('#dialog').show();
        NavEdit.postNav = $(this).parent().index();
      })
      $('#dialog').click(function (e) {
        if (e.target.className == 'dialog') {
          $('#dialogBack').hide();
          $('#dialog').hide();
        }
      })
      $('#dialogClose').click (function() {
        $('#dialogBack').hide();
        $('#dialog').hide();
      })
    }

    NavEdit.firstColumnData = function () {
      $.ajax({
        url: 'http://localhost:8080/xmheart_pc_server/column/first',
        type: 'GET',
        dataType: 'json'
      })
     .done(function(data) {
       $('#cloumnFirst').html('');
       var html = '';
       for (var i = 0; i< data.length; i++) {
         html += '<option value = "' + data[i].id + '">' + data[i].columnName + '</option>'
       }
       $('#cloumnFirst').html(html);
     })
    }

    NavEdit.secondColumnData = function (val) {
      $.ajax({
        url: 'http://localhost:8080/xmheart_pc_server/column/second',
        type: 'GET',
        dataType: 'json',
        data: {id: val}
      })
      .done(function(data) {
        $('#cloumnSecond').html('');
        var html = '<option value = "0">请选择二级导航</option>';
        for (var i = 0; i< data.length; i++) {
          html += '<option value = "' + data[i].id + '">' + data[i].columnName + '</option>'
        }
        $('#cloumnSecond').html(html);
      })
    }

    NavEdit.searchPost = function () {
      $('.search').on('click', '.search-button', function() {
        $.ajax({
          url: 'http://localhost:8080/xmheart_pc_server/column/second',
          type: 'GET',
          dataType: 'json',
          data: {id: val}
        })
        .done(function(data) {
          $('#searchPostList').html('');
          var html = '';
          for (var i = 0; i< data.length; i++) {
            html += '<li data-id = "' + data[i].id + '">' + data[i].columnName + '</li>'
          }
          $('#searchPostList').html(html);
        })
      })
    }

    NavEdit.postList = function () {
      $('.search-result').on('click', 'li', function() {
        var title = $(this).text();
        var postId = $(this).data('id');
        $('.column-list').eq(NavEdit.postNav).find('.column-list-title').text(title);
        $('.column-list').eq(NavEdit.postNav).find('.column-list-title').data(id, postId);
        $('#dialogBack').hide();
        $('#dialog').hide();
      })
    }

    NavEdit.postSubmit = function () {
      $('.btn-group').on('click', '#postSubmit', function() {
        // var firstColumnVal = $('.select-title-first').val()
        // var secondColumnVal = $('.select-title-second').val()
        // var postNav1 = $('.column-list').eq(0).find('.column-list-title').data(id);
        // var postNav2 = $('.column-list').eq(1).find('.column-list-title').data(id);
        // var postNav3 = $('.column-list').eq(2).find('.column-list-title').data(id);
        // var postNav4 = $('.column-list').eq(3).find('.column-list-title').data(id);
        // $.ajax({
        //   url: 'http://localhost:8080/xmheart_pc_server/column/second',
        //   type: 'GET',
        //   dataType: 'json',
        //   data: {id: val}
        // })
        // .done(function(data) {
        //   console.log(123);
        // })
      })
    }

    return NavEdit;
})();
