$(function() {
	/*var moreWeiboBtn = $("#moreWeiboBtn");
	moreWeiboBtn.on("click", function() {
		loadMoreWeibo($(this));
	});
	moreWeiboBtn.click();
	 */
	$(document).click(function(e) {
		closeSmileDiv(e);
	});
});

function forwardWeibo(p) {
	$("#_forward_dialog_check").attr("checked", false);// 还原checkbox
	$("#_forward_dialog_check2").attr("checked", false);// 还原checkbox
	var obj = $("#_forward_dialog_texts");

	if (p.fuserName) {
		$("#_forward_dialog_check2").parent().show();
		obj.val("//" + p.userName + "：" + p.texts);
	} else {
		$("#_forward_dialog_check2").parent().hide();
		obj.val(""); // 清空转发文字
	}
	
	var setting = {
		userName : p.userName,
		fuserName : p.fuserName,
		content : p.contentTarget.html(),
		forwardId : p.forwardId,
		sourceId : p.sourceId,
		css : {
			left : "40%"
		},
		validate : function() {
			var texts = $.trim(obj.val());
			if (texts == "") {
				texts = "转发微博。"
			}
			var target = $("#_forward_dialog_wordsTip");
			if (!validateLength(texts, target)) {
				$.colorTip(target);
				return false;
			}
			p.texts = texts;
			return true;
		},
		ok : function() {
			doForwardWeibo(p);
		}
	};
	$.forwardDialog(setting);
}

function doForwardWeibo(p) {
	var checkBox = $("#_forward_dialog_check");
	var checkBox2 = $("#_forward_dialog_check2");
	var commentFlag = checkBox.attr("checked") ? 1 : 0; // 1同时评论给作者
	var fcommentFlag = checkBox2.attr("checked") ? 1 : 0; // 1同时评论给原文作者
	Weibo.publish( {
		"texts" : p.texts,
		"imagePath" : "",
		"sourceId" : p.sourceId,
		"forwardId" : p.forwardId,
		"commentFlag" : commentFlag,
		"fcommentFlag" : fcommentFlag,
		"success" : function(msg) {
			if (msg == 500) {
				alert(Message.text500);
			} else if (msg == 404) {
				alert(Message.text404);
			} else {
				$("#_forward_dialog_texts").val("");
				validateLength("", $("#_forward_dialog_wordsTip"));
				alert("转发成功");
			}
		}
	});
}

function deleteWeibo(weiboId) {
	var setting = {
		title : Dialog.weibo.confirmTitle,
		content : Dialog.weibo.confirmContent,
		css:{ top:'25%',left: '40%' },
		ok : function() {
			doDeleteWeibo(weiboId);
		}
	};
	$.confirmDialog(setting);
}

function deleteComment(commentId) {
	var setting = {
			title:Dialog.comment.confirmTitle,
			content:Dialog.comment.confirmContent,
			css:{ top:'25%',left: '40%' },
			ok:function(){
				doDeleteComment(commentId);
		    }};
	$.confirmDialog(setting);
}