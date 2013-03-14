function weiboLogin(oauthUrl) {
	window.location.href=oauthUrl;
}

function LoginSynWeibo(code) {
	if(code == '') {return; }
	$.ajax({
		type : "POST",
		dataType : "json",
		url : basePath + "/weiboToken/weiboToken!LoginSynWeibo.shtml",
		data :  {"code":code},
		success : function(msg) {
			 try {
				 msg = eval("("+msg+")");
			 }catch(e) {}
			 var flag = msg.result.flag;
			 
			 if(flag == true) {
				 
				 //新浪微博账户与528账户还未绑定
				 if(msg.result.isBindAccount == false) {
					var sinaUserId = msg.result.sinaUserId;
					location.href = 'http://www.528.cn/personal/reg/my_regone.jsp?sinaUserId='+sinaUserId;
				}else {
					var userid = msg.result.userid;
					location.href = basePath+'/index.jsp?userid='+userid;
				}
			 }else {
				alert('微博登录失败!');
			 }
		}
	});
}

$(document).ready(function() {
		$("#sendWeiboButton").click(function(){
			alert("0");
			var texts = $.trim($("#texts").val());
			$.ajax({
				type:"POST",
				dataType:"text",
			    url: basePath + "/weiboToken/weiboToken!sendSinaWeibo.shtml",
				data:{"texts":texts},
			    success: function(msg) {
					alert("发送微博成功!");
				}
			});
		});
		
		
		$("#synWeiboBtn").click(function(){
			alert(0);
			var oauthUrl = $("#oauthUrl").val();
			alert(oauthUrl);
			window.open(oauthUrl);
		});
		
		$("#pauseWeiboBtn").click(function(){
			$.ajax({
				type:"POST",
				dataType:"json",
			    url: basePath + "/weiboToken/weiboToken!pauseWeibo.shtml",
			    success: function(msg) {
					try {
						 msg = eval("("+msg+")");
					 }catch(e) {}
					 var flag = msg.result.flag;
					 alert(flag);
					 if(flag == true) {
						 alert("暂停同步成功!");
					 }else {
						 alert("暂停同步失败!"); 
					 }
				}
			})
		});
		
		$("#cancelWeiboBtn").click(function(){
			$.ajax({
				type:"POST",
				dataType :"json",
				url: basePath + "/weiboToken/weiboToken!cancelWeibo.shtml",
			    success: function(msg) {
					try {
						 msg = eval("("+msg+")");
					 }catch(e) {}
					 var flag = msg.result.flag;
					 alert(flag);
					 if(flag == true) {
						 alert("取消同步成功!");
					 }else {
						 alert("取消同步失败!"); 
					 }
				}
			})
		});
		
		
})

function synWeibo() {
	var code = $.trim($("#code").val());
	if(code == '') {
		return; 
	}
	$.ajax({
		type:"POST",
		dataType:"json",
	    url: basePath + "/weiboToken/weiboToken!synWeibo.shtml",
		data:{"code":code},
	    success: function(msg) {
			alert("1");
			try {
				 msg = eval("("+msg+")");
			 }catch(e) {}
			 var flag = msg.result.flag;
			 if(flag == true) {
				 alert("设置同步成功!");
			 }else {
				 alert("设置同步失败!"); 
			 }
			
		}
	});
}
