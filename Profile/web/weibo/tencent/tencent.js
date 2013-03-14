function TencentLogin(code,openid,openkey){
	$.ajax({
		   type: "POST",
		   url: basePath + "/weiboToken/tencentToken!tencentToken.shtml", //TencentTokenAction.java
		   data:"code="+code+"&openid="+openid+"&openkey="+openkey,
		   dataType:"json",
		   success: function(msg){
	         var flag=msg.result.flag;
	         var isBoundAccount = msg.result.isBoundAccount;
	         if(flag==true){
	        	 if(isBoundAccount==false){//微博与528账户未绑定
	        		  //跳到注册页面  openid带上
						var openid = msg.result.openid;
						var accessToken = msg.result.accessToken;
						location.href = 'http://www.528.cn/personal/reg/my_regone.jsp?openid='+openid+'&accessToken='+accessToken;
					
	        	 }else{
	        		 
	        		 //微博认证   登录用户是以登录状态认证授权
	        		 if(msg.result.isLogin==true){
	        			 //跳转到认证同步界面
	        			 location.href = basePath+'/setting/weiboSync.shtml';
	        			 return;
	        			 
	        		 }
	        		 
	        		 //登陆成功 528用户的userId拿到
	        		 var userId = msg.result.userId;
						location.href = basePath+'/index.jsp?userId='+userId;
	        	 }
	         }else{
					alert('微博登录失败!');
				 
	         }
	}
	
  }); 
}

