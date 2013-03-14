function LoginSynWeibo(code) {
	if(code == '') {
		location.href = basePath+'/home.shtml';
		return; 
	}
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
					var accessToken = msg.result.accessToken;
					location.href = 'http://www.528.cn/personal/reg/my_regone.jsp?sinaUserId='+sinaUserId+'&accessToken='+accessToken;
				}else {
					
					//是否是登录用户认证授权后跳转
					if(msg.result.isLoginUserOauth == true) {
						alert("您的账户与新浪微博同步成功!");
						location.href = basePath+'/setting/weiboSync.shtml';
						return;
					}
					
					var userid = msg.result.userid;
					location.href = basePath+'/home.shtml';
				}
			 }else {
				alert('微博授权失败!');
			 }
		}
	});
}

$(document).ready(function() {
	   
		$("#sinaWeiboLoginBtn").click(function() {
			window.location = $("#sinaOauthUrl").val();
		});
		
		$("#sendWeiboButton").click(function(){
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

//528老用户登录后，绑定新浪微博用户
function loginBindWeiboAccount() {
  var sinaUserId = $("#sinaUserId").val();
  var accessToken = $("#accessToken").val();
  
  if(sinaUserId == '' || accessToken == '') {return;}
  if(sinaUserId == 'undefined' || accessToken == 'undefined') {return;}
	 
  $.ajax({
		type:"POST",
		dataType :"json",
		url: basePath + "/weiboToken/weiboToken!synWeibo.shtml",
		data:{"sinaUserId":sinaUserId,"accessToken":accessToken},
	    success: function(msg) {
			try {
				 msg = eval("("+msg+")");
			 }catch(e) {}
			 var flag = msg.result.flag;
			 if(flag == true) {
				 alert("与新浪微博用户绑定成功!");
			 }else {
				 alert("与新浪微博用户绑定失败!"); 
			 }
		}
	})
	 
}
