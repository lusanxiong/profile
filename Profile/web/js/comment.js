var Comment = {};

Comment.publish = function(p) {
	$.ajax( {
		type : "POST",
		dataType : "html",
		url : basePath + "/publishComment.shtml",
		data : "weiboId=" + p.weiboId + "&toUserId=" + p.toUserId + "&checked="
				+ p.checked + "&texts=" + encodeURIComponent(p.texts),
		success : function(msg) {
			p.success(msg);
		}
	});
}

Comment.getCommentList = function(p) {
	$.ajax( {
		type : "POST",
		dataType : "html",
		url : basePath + "/commentList.shtml",
		data : "weiboId=" + p.weiboId+"&pageIndex="+p.pageIndex+"&showMore="+p.showMore,
		success : function(msg) {
			p.success(msg);
		}
	});
}

Comment.reply = function(p) {
	var target = p.target;
	target.focus();
	target.val(Message.replyPrefix + p.userName + "：");
	target.focus();
}

Comment.del = function(p) {
	$.ajax( {
		type : "POST",
		dataType : "html",
		url : basePath + "/deleteComment.shtml",
		data : "commentId=" + p.commentId,
		success : function(msg) {
			p.success(msg);
		}
	});
}