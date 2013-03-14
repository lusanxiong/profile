/**
*微博同步js
**/
var sinaWeibo = 1;  //新浪微博
var tencentWeibo = 2;//腾讯微博


/**
 * 获取微博同步状态信息
 */
function getUserWeiboSynInfo() {
	$.post(basePath+"/weiboToken/userWeibo!getUserWeiboSynInfo.shtml",function(data) {
		$("#userWeiboSynInfoDiv").html(data);
	});
}

$(document).ready(function() {
	 
})

/**
 * 暂停微博同步
 * @return
 */
function pauseSyncWeibo(weiboServiceType) {
	
	//新浪微博
	if(weiboServiceType == sinaWeibo) {
		pauseSinaWeiboSync();
		return;
	}
	
	
	//腾讯微博
	 if(weiboServiceType==tencentWeibo){
		 pauseTencentWeibo();
	    return;	
	    }
	
}

/**
 *恢复微博同步
 * @return
 */
function recoverSyncWeibo(weiboServiceType) {
	//新浪微博
	if(weiboServiceType == sinaWeibo) {
		recoverSinaSyncWeibo();
		return;
	}
	
	
	//腾讯微博
	if(weiboServiceType==tencentWeibo){
		recoverTencentWeibo();
		return;
	}
}

/**
 * 微博授权
 * @return
 */
function weiboOauth(weiboServiceType) {
	//新浪微博
	if(weiboServiceType == sinaWeibo) {
		sinaWeiboOauth();
		return;
	}
	
	//腾讯微博
	
	if(weiboServiceType==tencentWeibo){
	  tencentWeiboOauth();
	  return;
	}
}

/**
 * 新浪微博授权
 */
function sinaWeiboOauth() {
	window.location=sinaWeiboOauthUrl;
}

/**
 * 删除微博账户
 */
function delWeiSync(weiboServiceType) {
	//新浪微博
	if(weiboServiceType == sinaWeibo) {
		delSinaSyn();
		return;
	}
	
	//腾讯微博
    if(weiboServiceType==tencentWeibo){
    	delTencentWeibo();
    	return;
    }
}

/**
 * 暂停同步新浪微博
 */
function pauseSinaWeiboSync() {
	$.ajax({
		type:"POST",
		dataType:"json",
	    url: basePath + "/weiboToken/weiboToken!pauseWeibo.shtml",
	    success: function(msg) {
			try {
				 msg = eval("("+msg+")");
			 }catch(e) {}
			 var flag = msg.result.flag;
			 if(flag == true) {
				 //alert("暂停同步成功!");
				 getUserWeiboSynInfo();
			 }else {
				 alert("暂停同步失败!"); 
			 }
		}
	})
}

/**
 * 恢复同步新浪微博
 * @return
 */
function recoverSinaSyncWeibo() {
	$.ajax({
		type:"POST",
		dataType:"json",
	    url: basePath + "/weiboToken/weiboToken!recoverWeibo.shtml",
	    success: function(msg) {
			try {
				 msg = eval("("+msg+")");
			 }catch(e) {}
			 var flag = msg.result.flag;
			 if(flag == true) {
				 //alert("恢复微博同步成功!");
				 getUserWeiboSynInfo();
			 }else {
				 alert("恢复微博同步失败!"); 
			 }
		}
	})
}

/**
 * 删除新浪微博同步
 */
function delSinaSyn() {
	if(!window.confirm('确认要删除您的新浪微博账户吗?')){return;}
	$.ajax({
		type:"POST",
		dataType:"json",
	    url: basePath + "/weiboToken/weiboToken!cancelWeibo.shtml",
	    success: function(msg) {
			try {
				 msg = eval("("+msg+")");
			 }catch(e) {}
			 var flag = msg.result.flag;
			 if(flag == true) {
				 //alert("删除微博同步成功!");
				 getUserWeiboSynInfo();
			 }else {
				 alert("删除微博同步失败!"); 
			 }
		}
	})
}

 

//腾讯微博认证授权
 function tencentWeiboOauth(){
	 window.location=authoUrl;
	 
 }

//腾讯微博的暂停
function  pauseTencentWeibo(){
	$.ajax({
		type:"POST",
		url: basePath + "/weiboToken/tencentToken!pauseTencentWeibo.shtml",
		dataType:"json",	    
	    success: function(msg) {
			 var flag = msg.result.flag;
			 if(flag == true) {
				 //alert("暂停同步微博成功!");
				 getUserWeiboSynInfo();
			 }else {
				 alert("暂停同步微博失败!"); 
			 }
		}
	})
	
	
}

//腾讯微博的恢复
function recoverTencentWeibo(){
	$.ajax({
		type:"POST",
		url: basePath + "/weiboToken/tencentToken!recoverTencentWeibo.shtml",
		dataType:"json",	    
	    success: function(msg) {
			 var flag = msg.result.flag;
			 if(flag == true) {
				 //alert("微博同步成功!");
				 getUserWeiboSynInfo();
			 }else {
				 alert("微博同步失败!"); 
			 }
		}
	})
		

}

//腾讯微博的删除
function delTencentWeibo(){
	
	if(!window.confirm('确认要删除您的微博账户吗?')){return;}
	$.ajax({
		type:"POST",
		url: basePath + "/weiboToken/tencentToken!delTencentWeibo.shtml",
		dataType:"json",	    
	    success: function(msg) {
			 var flag = msg.result.flag;
			 if(flag == true) {
				 //alert("删除微博同步成功!");
				 getUserWeiboSynInfo();
			 }else {
				 alert("删除微博同步失败!"); 
			 }
		}
	})
	
}
