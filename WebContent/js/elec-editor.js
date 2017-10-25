$(function() {
	var title = $('#elecNewspaperTitle');
	var year = $('#year');
	var times = $('#times');
	var page = $('#page');
	var imageUrl;
	var article = {};
	var ctrl = {
		// 获取url中的参数
		getUrlParam : function(name) {
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
			var r = window.location.search.substr(1).match(reg); // 匹配目标参数
			console.log(window.location.search);
			console.log(window.location.search.substr(1));
			if (r != null)
				return unescape(r[2]);
			return null; // 返回参数值
		},

		publish : function() {
			var $this = $(this);

			var imgUrl = $('.upload-img').attr('src');
			console.log(imgUrl);
			var params = {
				title : title.val(),
				year : year.val(),
				times : times.val(),
				page : page.val(),
				isPublished : true,
				download_url : '#',
				imageUrl : imgUrl,
			};

			if (!ctrl.valid(params, 'publish')) {
				return;
			}
			$this.attr('disabled', 'disabled');
			// 编辑模式
			// var articleId = ctrl.getUrlParam('articleId');
			// console.log(articleId);
			// if (articleId) {
			var url = '/newspapers';
			$.post(url, params, function(res) {
				$this.removeAttr('disabled');
				swal({
					title : "上传成功",
					text : "返回上一页？",
					type : "success",
					showCancelButton : true,
					confirmButtonColor : "#8cd4f5",
					confirmButtonText : "返回上一页",
					cancelButtonText : "新增一页",
					closeOnConfirm : false
				}, function() {
					window.history.go(-1);
				});
			}).error(function() {
				$this.removeAttr('disabled');
				sweetAlert("哎呀", "服务器开小差了~请稍后再试", "error");
			});

			return;
			
		},
		/* save : function() {
			var $this = $(this);

			var imgUrl = $('.upload-img').attr('src');
			console.log(imgUrl);
			var params = {
				title : title.val(),
				year : year.val(),
				times : times.val(),
				page : 1,
				isPublished : true,
				download_url : '#',
				imageUrl : imgUrl,
			};

			// if (!ctrl.valid(params)) {
			// return;
			// }
			$this.attr('disabled', 'disabled');
			// 编辑模式
			var articleId = ctrl.getUrlParam('articleId');
			if (articleId) {
				var url = '/articles/' + articleId;
				$.post(url, params, function(res) {
					$this.removeAttr('disabled');
					swal({
						title : "保存成功",
						type : "success",
						showCancelButton : true,
						confirmButtonColor : "#8cd4f5",
						confirmButtonText : "发表文章",
						cancelButtonText : "取消",
						closeOnConfirm : false
					}, function() {
						ctrl.publish();
					});
				}).error(function() {
					$this.removeAttr('disabled');
					sweetAlert("哎呀", "服务器开小差了~请稍后再试", "error");
				});

				return;
			}

			$.post('/articles', params, function(res) {
				$this.removeAttr('disabled');
				// $('#wordCount textarea').val(brief);
				swal({
					title : "新建文章成功",
					type : "success",
					showCancelButton : true,
					confirmButtonColor : "#8cd4f5",
					confirmButtonText : "返回上一页",
					cancelButtonText : "取消",
					closeOnConfirm : false
				}, function() {
					ctrl.cancel();
				});
			}).error(function() {
				$this.removeAttr('disabled');
				sweetAlert("哎呀", "服务器开小差了~请稍后再试", "error");
			});
		},
		*/
		valid : function(params, type) {
			var articleId = ctrl.getUrlParam('articleId');

			if (!params.title) {
				sweetAlert("信息不完整", "请填写标题", "error");
				return false;
			}

			if (!params.year) {
				sweetAlert("信息不完整", "请填写年份", "error");
				return false;
			}
			if (!params.times) {
				sweetAlert("信息不完整", "请填写期数", "error");
				return false;
			}
			if (params.imageUrl == "#") {
				sweetAlert("信息不完整", "请选择图片", "error");
				return false;
			}
			

			return true;
		},
		// preview: function () {
		// $('#preview-panel').html(ue.getContent());
		// },
		cancel : function() {
			// 取消(直接返回上一级，不做接口交互)
			window.history.go(-1);
		},
		// getColumn: function (columnId, htmlId, selectTitle) {
		// var url ="/columns/" + columnId
		// $.get(url, function (data) {
		// $('.ui-loading').hide();
		// var optionString = '';
		// for (var i in data) {
		// var jsonObj = data[i];
		// optionString += "<option value=\"" + jsonObj.id + "\" >" +
		// jsonObj.columnName + "</option>";
		// $(htmlId).html("<option value='请选择'>请选择</option> " + optionString);
		// }
		// $(selectTitle).show();
		// });
		// },
		uploadImg: function () {
		
		    		$('.add-img-list').on('click', '#addImgBtn', function (){
		    			$(this).siblings('.upload-form').find('.add-img-file').trigger('click');
		    		})
		    		$('.add-img-list').on('change', '.add-img-file', function (){
		    			$(this).siblings('.add-img-submit').trigger('click');
		    		})
		    		$('#uploadForm').submit(function(){
		    			$this = $(this);
		    			$this.ajaxSubmit({
		    				success: function (responseText) {
		    					var img = responseText;
		    					$this.siblings('.add-image-url').find('.upload-img').attr('src', img);
		    					$this.siblings('.add-image-button').hide();
		    					$this.siblings('.add-image-url').show();
		    				}
		    			});
		    			return false;
		    		})
		    		$('.add-img-list').on('mouseover', '.add-image-url, .add-image-edit', function (){
		    			$('.add-image-edit').show();
		    		})
		    		$('.add-img-list').on('mouseleave', '.add-image-url, .add-image-edit', function (){
		    			$('.add-image-edit').hide();
		    		})
		    		$('.add-img-list').on('click', '.add-image-edit', function (){
		    			$(this).siblings('.upload-form').find('.add-img-file').trigger('click');
		    		})
		},
		init : function() {
//			$('.ui-loading').show();
//			var articleId = ctrl.getUrlParam('articleId');
			// // 编辑模式
			// // ctrl.getColumn(0, '#J_select_first');
			// // if (articleId) {
			// // ctrl.getArticle(articleId);
			// // }
			$('.ui-loading').hide();
		}
	}
	ctrl.init();
	// ctrl.initDate();
	ctrl.uploadImg();

	$('#publish').on('click', ctrl.publish);
	$('#save').on('click', ctrl.save)
//	$('#preview').on('click', ctrl.preview);
	$('#cancel').on('click', ctrl.cancel);
//
//	$('#editColumn').on('click', function() {
//		$('.column-create').show();
//		$('.column-edit').hide();
//	})
})