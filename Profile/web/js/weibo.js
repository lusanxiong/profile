var Weibo = {};

Weibo.publish = function(p) {
	$.ajax( {
		type : "POST",
		dataType : "html",
		url : basePath + "/publishWeibo.shtml",
		data : "texts="+encodeURIComponent(p.texts)+"&imagePath="+p.imagePath+"&sourceId="+p.sourceId+"&forwardId="+p.forwardId+"&commentFlag="+p.commentFlag+"&fcommentFlag="+p.fcommentFlag,
		success : function(msg) {
			p.success(msg);
		}
	});
}

Weibo.getWeiboList = function(p) {
	$.ajax( {
		type : "POST",
		dataType : "html",
		url : basePath + "/weiboList.shtml",
		data : "userId="+p.userId+"&pageIndex="+p.pageIndex+"&type="+p.type,
		success : function(msg) {
			p.success(msg);
		}
	});
}

Weibo.getWeibo = function(p) {
	$.ajax( {
		type : "POST",
		dataType : "html",
		url : basePath + "/getWeibo.shtml",
		data : "weiboId="+p.weiboId,
		success : function(msg) {
			p.success(msg);
		}
	});
}

Weibo.del = function(p) {
	$.ajax( {
		type : "POST",
		dataType : "html",
		url : basePath + "/deleteWeibo.shtml",
		data : "weiboId="+p.weiboId,
		success : function(msg) {
			p.success(msg);
		}
	});
}