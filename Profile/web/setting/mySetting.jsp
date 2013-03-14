<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/common/taglib.jsp"%>
<%menu = "set";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<title>信息设置</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="Content-Language" content="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
	    <link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css">
		<link href="${basePath}/css/index.css" rel="stylesheet" type="text/css">
        <link href="${basePath}/css/mysetting.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="${basePath}/js/jquery.js"></script>
		<script type="text/javascript">
		    function editEmail(){
		        var oldEmail = "${account.email}";
		        var newEmail = $.trim($("#email").val());
		        var re = /^[0-9a-zA-Z_\.\-]+@[0-9a-zA-Z_\-]+(\.[0-9a-zA-Z_\-]+)+$/;
		        if(newEmail == ""){
		           $("#_emailSpMsg").html("请输入email！");
		           return;
		        }
		        if(oldEmail == newEmail){
		           $("#_emailSpMsg").html("请输入新的邮箱！");
		           return;
		        }
		        if(!re.test(newEmail)){
		           $("#_emailSpMsg").html("邮箱格式不正确！");
		           return;
		        }
		        
		        $.post(basePath + "/AjaxServlet", {
						email : newEmail,
						action : "verificatemail"
					  }, function(data) {
						 if(data == "1"){
						   $("#_emailSpMsg").html("此邮箱邮已被注册！");
		                   return;
						 }
				      });
			    $("#act").val("2");
			    document.thisForm.submit();
		    }
		    
		    function editPassWord(){
		        var passreg = /^[\w-]{6,20}$/;
		        var oldPwd = $.trim($("#oldPwd").val());
		        var pwd = $.trim($("#pwd").val());
		        var pwd1 = $.trim($("#pwd1").val());
		        if(oldPwd == ""){
		            $("#_pwdSpMsg").html("请输入原密码！");
		            return;
		        }
		        if(pwd == "" || pwd1==""){
		            $("#_pwdSpMsg").html("请输入新密码！");
		            return;
		        }
		        if(pwd != pwd1){
		            $("#_pwdSpMsg").html("两次输入新密码不一致！");
		            return;
		        }
		        if(!passreg.test(pwd)){
		            $("#_pwdSpMsg").html("新密码格式不准确！6~20个字符，由英文字母，下划线，数字组成");
		            return;
		        }
		        $("#act").val("1");
			    document.thisForm.submit();
		    }
		    
		    function editRights(){
		        if($("#chkResumeStatus").val()=="2"){
		           var comName = $.trim($("#txtCompany").val());
		           if(comName == ""){
		              $("#_rightSpMsg").html("请填写要屏蔽的公司！");
		              return;
		           }
		        }
		        $("#act").val("0");
			    document.thisForm.submit();
		    }
		    
		    function changeRight(){
		        if($("#chkResumeStatus").val()=="2"){
		            $("#_spCom").show();
		        }
		    }
		</script>
		
	</head>
	<body>
		<!--头部 S-->
		<%@include file="/common/header.jsp"%>
		<!--头部 E-->
		<!--内容块 S-->
<div class="index_content">
<%@include file="/common/left.jsp"%>
<!--内容块左 S-->
<div  class="set_rigbox">
<!--密码设置 S-->
    <div class="set">
      <div class="set_tle">
        <div class="set_tle_left">密码设置</div>
        <div class="set_tle_center"></div>
        <div class="set_tle_right"><a href="applications.html"><img src="${basePath}/images/set_tle_right.gif" width="10" height="31" /></a></div>
      </div>
      
      <div class="set_down">
       <div class="set_dw">
       <span class="set_down_mynews">原&nbsp; 密&nbsp; 码：</span>
       <span><input type="password" class="resume_profile_wbk" name="oldPwd" id="oldPwd" style="width: 180px" maxlength="20"/></span>
       </div>
       <div class="set_dw">
       <span class="set_down_mynews">新&nbsp; 密&nbsp; 码：</span>
       <span>
       <input type="password"  name="pwd" id="pwd" class="resume_profile_wbk" style="width: 180px" maxlength="20"/>
      </span>
       </div>
        <div class="set_dw" style=" margin-bottom:20px">
        <span class="set_down_mynews">再次输入：</span>
        <span>
        <input type="password" name="pwd1" id="pwd1"  class="resume_profile_wbk" style="width: 180px" maxlength="20"/>
        </span>
       
        <span><input name="input" type="button" onclick="editPassWord()" class="set_down_button" value="确 定" /></span>
        <span style="color: red;" id="_pwdSpMsg"></span>
       </div>
       <div class="clear"></div>
    </div>
    <div class="clear"></div>
  </div>
<!--密码设置/关注 E-->

<!--邮件设置 S-->

    <div class="set">
      <div class="set_tle">
        <div class="set_tle_left">邮件设置</div>
        <div class="set_tle_center"></div>
        <div class="set_tle_right"><a href="applications.html"><img src="${basePath}/images/set_tle_right.gif" width="10" height="31" /></a></div>
      </div>
      
      <div class="set_down">
        <div class="set_dw" style=" margin-bottom:20px">
        <span class="set_down_mynews">邮　　箱：</span>
        <span>
        <input type="text" name="email" id="email"  class="resume_profile_wbk" value="${account.email}" style="width: 180px"/>
        </span>
        <span><input name="input" type="button" class="set_down_button" value="确 定" onclick="editEmail();"/></span>
        <span style="color: red;" id="_emailSpMsg"></span>
       </div>
       <div class="clear"></div>
    </div>
    <div class="clear"></div>
  </div>
  </form>
<!--邮件设置/关注 E-->
  </div>
<!--内容块左 E-->

</div>
<div class="clear"></div>
<!--内容块 E-->

		<!--版权 S-->
		<%@include file="/common/footer.jsp"%>
	</body>
</html>
