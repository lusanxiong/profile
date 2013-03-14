$(function() {
	$(window).on("scroll", function() {
		$("#smileDiv").hide();
	});
});

function loadMoreWeibo(btn) {
	var pageIndex = btn.attr("pageIndex");
	var userId = btn.attr("userId");
	var type = btn.attr("type");
	var weiboDiv = $("#weiboDiv");
	$("#moreLoading").show();
	
	Weibo.getWeiboList( {
		pageIndex : pageIndex,
		userId: userId,
		type:type,
		success : function(msg) {
			if ($.trim(msg) == "") {
				if(pageIndex==1){ //页码为1表示 ,页面加载 ,如果没有内容这隐藏 "更多" 按钮
					$("#moreLoadDiv").hide();
				}
				btn.html(Loading.over).off("click");
			} else {
				weiboDiv.append(msg);
				btn.attr("pageIndex", parseInt(pageIndex) + 1);
			}
			$("#moreLoading").hide();
		}
	});
}

function publishComment(p) {
	var commentObj = $("#comment_" + p.weiboId);
	var texts = $.trim(commentObj.val());
	if (texts == "") {
		$.colorTip(commentObj);
		return;
	}
	var commentList = $("#commentList_" + p.weiboId);
	var forwardBox = $("#forwardBox_" + p.weiboId)
	var checked = forwardBox.attr("checked") ? 1 : 0; // 1表示评论同事转发
	var p = {
		weiboId : p.weiboId,
		texts : texts,
		toUserId : p.toUserId,
		checked : checked,
		success : function(msg) {
			if (msg == 500) {
				alert(Message.text500);
			} else if (msg == 400) {
				alert(Message.text400);
			} else if (msg == 404) {
				alert(Message.text404);
			} else {
				commentList.prepend(msg);
				var child = commentList.children(":first-child");
				child.hide().fadeIn("slow");
				if (checked == 1) { // 转发同事评论
			var forwardWeiboId = child.attr("forwardWeiboId");
			getWeibo(forwardWeiboId);
		}
	}
}
	};
	Comment.publish(p);
	commentObj.val("");
}

function commentList(p) {
	var commentDiv = $("#commentBox_" + p.weiboId);
	var commentList = $("#commentList_" + p.weiboId);
	if (commentDiv.css("display") == "block") {
		commentDiv.hide();
	} else {
		commentDiv.show();
		commentList.html(Message.loading);
		var p = {
			weiboId : p.weiboId,
			pageIndex : 1,
			showMore:1,
			success : function(msg) {
				if (msg == 500) {
					alert("未登录");
				} else {
					commentList.html(msg);
				}
			}
		};
		Comment.getCommentList(p);
	}
	$("#comment_"+p.weiboId).focus();
}

function doDeleteWeibo(weiboId) {
	var p = {
		weiboId : weiboId,
		success : function(msg) {
			var comment = $("#weiboDL_" + weiboId)
			if (msg == 0) {
				comment.fadeOut("slow");
			}
			if (msg == 500) {
				alert(Message.text500);
			}
			if (msg == 100) {
				alert(Message.text100);
			}
		}
	};
	Weibo.del(p);
}

function doDeleteComment(commentId) {
	var p = {
		commentId:commentId,
		success:function(msg){
			var weibo = $("#commentDL_"+commentId)
			if(msg==0){
				weibo.fadeOut("slow");
			}
			if(msg==500){
				alert(Message.text500);
			}
			if(msg==100){
				alert(Message.text100);
			}
		}
	};
	Comment.del(p);
}

function showSmile(obj, target) {
	var offset = obj.offset();
	var top = offset.top;
	var left = offset.left;
	top = top + 20;
	left = left - 7;
	doShowSmile(top, left, target);
}

function doShowSmile(top, left, target) {
	$("#smileDiv").css("top", top + "px").css("left", left + "px").show();
	$("#smileUL>li>img").off("click").on("click", function() {
		var title = "[" + $(this).attr("title") + "]";
		$.insertContent(target, title);
		$("#smileDiv").hide();
	});
}

function closeSmileDiv(e){
	var target = $(e.target);
	if(target.closest("#smileDiv").length>0){
		return ;
    }
	var flag = target.attr("flag");
	var parentId = target.parent().attr("id");
	var parentId2 = target.parent().parent().attr("id");
	if(parentId=="smileBtn" || parentId2=="smileBtn" || "smileBtn"==flag){
		return ;
	}else {
		$("#smileDiv").hide();
	}
}

function zoomImage(obj,type) {
	if(type==1) {
    	var smallImgDiv = obj.parent().parent();
    	var bigImgDiv = smallImgDiv.next();
		var img = bigImgDiv.find("img");
		if(img.attr("src")=="about:blank") {
			var src = obj.attr("src");
    		var mSrc = src.replace("_t.","_m.");
    		var lSrc = src.replace("_t.","_l.");
    		bigImgDiv.find("a:first").attr("href",lSrc);
    		
    		img.attr("src",mSrc);
    		img.load(function(){
    			smallImgDiv.hide();
    			bigImgDiv.show();
        	});
		}else {
			smallImgDiv.hide();
			bigImgDiv.show();
		}
	}
	else {
		var bigImgDiv = obj.parent();
		var smallImgDiv = bigImgDiv.prev();
		bigImgDiv.hide();
		smallImgDiv.show();
    }
}

function ctrlEnter(event, obj) {
	if (event.ctrlKey && event.keyCode == 13) {
		obj.click();
	}
}

function validateLength(str, target) {
	var num = $.stringLength(str);
	num = 140 - num;
	if (num >= 0) {
		target.html("还可以输入<span class='share_tle_yw'>" + num + "</span> 字");
		return true;
	} else {
		target.html("已经超出了<span class='share_tle_red'>" + Math.abs(num)
				+ "</span> 字");
		return false;
	}
}

function sendMessage(p) {
	$.post(basePath + "/AjaxServlet", {
		receiveId : p.receiveId,
		content : p.content,
		action :"sendmessage"
	},function(data) {
		p.callback(data);
	});
}



















