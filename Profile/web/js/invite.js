$(function(){
$("#mailBtn").on("click",function(){
	var emailType = $("#emailType").val();
	var username = $.trim($("#emailUserName").val());
	var password = $.trim($("#emailPassword").val());
	if(""==username){
		$("#mailInfoTip").html("<span style='color:read'>请填写邮箱</span>");
		return;
	}
	if(emailType=="0"){
		$("#mailInfoTip").html("<span style='color:read'>请选择邮箱</span>");
		return;
	}
	if(""==password){
		$("#mailInfoTip").html("<span style='color:read'>请填写邮箱密码</span>");
		return;
	}
	$("#mailInfoTip").hide();
	$("#mailloadingTip").show();
	$("#mailNoTip").hide();
	$.ajax({
		type : "POST",
		dataType : "html",
		url : basePath + "/friends/importInvite.shtml",
		data : "emailType="+emailType+"&username="+username+"&password="+password+"&isValidate=1",
		success : function(msg) {
			if(msg==0){
				$("#emailInviteForm").submit();
			}
			else if(msg="404"){
				$("#mailloadingTip").hide();
				$("#mailInfoTip").html("<span style='color:read'>登陆失败，重新测试</span>").show();
			}
			else if(msg="400"){
				$("#mailloadingTip").hide();
				$("#mailInfoTip").html("<span style='color:read'>你的邮箱没有联系人，请通过其他方式邀请好友</span>").show();
			}
		}
	});
});

//----

$("#msnBtn").click(function(){
	var msnUserName= $.trim($("#msnUserName").val());
	var msnPassword= $.trim($("#msnPassword").val());
	if(""==msnUserName){
		$("#msnInfoTip").html("<span style='color:read'>请填写msn</span>");
		return;
	}
	if(!isEmail(msnUserName)){
		$("#msnInfoTip").html("<span style='color:read'>请填写正确msn账号</span>");
		return;
	}
	if(""==msnPassword){
		$("#msnInfoTip").html("<span style='color:read'>请填写msn密码</span>");
		return;
	}
	$("#msnInfoTip").hide();
	$("#msnLoadingTip").show();
	$.ajax({
		type : "POST",
		dataType : "html",
		url : basePath + "/friends/msnInvite.shtml",
		data : "username="+msnUserName+"&password="+msnPassword+"&isValidate=1",
		success : function(msg) {
			if(msg==0){
				$("#msnInviteForm").submit();
			}
			else if(msg="404"){
				$("#msnLoadingTip").hide();
				$("#msnInfoTip").html("<span style='color:read'>登陆失败，重新测试</span>").show();
			}
			else if(msg="400"){
				$("#msnLoadingTip").hide();
				$("#msnInfoTip").html("<span style='color:read'>你的msn没有联系人，请通过其他方式邀请好友</span>").show();
			}
		}
	});
});

//----
$("#myEmailBtn").click(function(){
	var emails = $.trim($("#myEmail").val());
	var userName = $.trim($("#userName").val());
	if(""==emails){
		$("#myEmailTip").html("<span style='color:read'>请输入邮箱.</span>");
		return;
	}
	$("#myEmailTip").hide();
	$("#myLoadingTip").show();
	$.ajax({
		type : "POST",
		dataType : "html",
		url : basePath + "/friends/sendMail.shtml",
		data : "emails="+emails+"&userName="+userName,
		success : function(msg) {
			$("#myLoadingTip").hide();
			if(msg==0){
				$("#myEmail").val("");
				alert("邀请成功.");
			}
			else if(msg="404"){
				$("#myEmailTip").html("<span style='color:read'>数据错误.</span>").show();
			}
			else if(msg="500"){
				$("#myEmailTip").html("<span style='color:read'>请登录后在发送邀请.</span>").show();
				}
			}
		});
	});
});