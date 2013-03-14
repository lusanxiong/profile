var PM = {};

PM.sendMessage = function(p) {
	var param = {
		url:"/messages/savePrivateMessage.shtml",
		data:"targetId="+p.targetId+"&message="+encodeURIComponent(p.message),
		success:function(msg){
			p.success(msg);
		}
	};
	PM.ajax(param);
}

PM.deleteMessage = function(p) {
	var param = {
		url:"/messages/deletePrivateMessage.shtml",
		data:"messageId="+p.messageId,
		success:function(msg){
			p.success(msg);
		}
	};
	PM.ajax(param);
}

PM.ajax = function(p) {
	$.ajax( {
		type : "POST",
		dataType : "html",
		url : basePath + p.url,
		data : p.data,
		success : function(msg) {
			p.success(msg);
		}
	});
}