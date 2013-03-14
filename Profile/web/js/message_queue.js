
$(function(){
	getMessageQueue();
	var t = setInterval(function(){
		getMessageQueue();
	},60000);
	
	function getMessageQueue() {
		$.post(
			basePath+"/AjaxServlet",
			{"action":"messagequeue","type":1}, //type等于1 表示读取消息
			function(data){
				var data = $.parseJSON(data);
				var privateNumber = data.privateNumber;
				var fansNumber = data.fansNumber;
				var commentNumber = data.commentNumber;
				if((privateNumber+fansNumber+commentNumber)==0){
					$("#messageQueueBox").hide();
					return;
				}
				if(privateNumber>0){
					$("#privateNumberLi").show().find("span").html(privateNumber);
				}
				else{
					$("#privateNumberLi").hide();
				}
				if(fansNumber>0){
					$("#fansNumberLi").show().find("span").html(fansNumber);
				}
				else{
					$("#fansNumberLi").hide();
				}
				
				$("#messageQueueBox").show();
			});
	}
	
	$("#closeMessageQueueBtn").click(function(){
		clearInterval(t); //关闭主动请求
		$.post(basePath+"/AjaxServlet",{"action":"messagequeue","type":2});//type等于2 表示清除所有消息
		$("#messageQueueBox").hide();
	});
});