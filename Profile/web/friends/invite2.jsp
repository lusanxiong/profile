<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="/common/taglib.jsp"%>
<%menu = "friend";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>我的人脉</title>
		<%@include file="/common/meta.jsp"%>
	    <link href="${basePath}/css/css.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/css/invite.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="${basePath}/js/validator.js"></script>
        <script type="text/javascript">
        	$(function(){
            	$("#allChecked").click(function(){
					if($(this).attr("checked")){
						$("#emailUL input").attr("checked",true);
					}else{
						$("#emailUL input").attr("checked",false);
					}
                });

				$("#inviteBtn").click(function(){
					var sb = new StringBuffer();
					$("#emailUL input[checked='checked']").each(function(){
						sb.append($(this).val());
						sb.append(";");
					});
					var list = sb.toString();
					if(list==""){
						alert("请选择邀请好友.");
					}else{
						invite(list);
					}
				});
            })
            
            function invite(list){
        		$.ajax({
					type : "POST",
					dataType : "html",
					url : basePath + "/friends/sendMail.shtml",
					data : "emails="+list,
					success : function(msg) {
						if(msg==0){
							alert("发送成功");
							window.location=basePath+"/friends/invite.jsp"
						}
						else if(msg==500){
							alert("未登录");
						}
						else if(msg==404){
							alert("数据部正确");
						}
        			}
        		});
        	}
        </script>
	</head>
	<body>
		<!--头部 S-->
		<%@include file="/common/header.jsp"%>
		<!--头部 E-->
		<!--人脉 S-->
		<div class="people_box">
			<div class="people">
				<div class="people_tle">
					<ul>
						<li>
							<a href="search.shtml">
							<b>我关注的</b>
							</a>
						</li>
						<li>
							<a href="follow.shtml">
							<b>关注我的</b>
							</a>
						</li>
						<li>
							<a href="fans.shtml">
							<b>可能认识的</b>
							</a>
						</li>
                        <li>
							<a href="invite.jsp" class="bhover">
							<b class="chover" >邀请好友</b>
							</a>
						</li>
					</ul>
				</div>
			</div>
            
			<div class="people_content">
<!-------------------------邀请 S------------------------->
	<div class="invite_box">
       <div class="invitelist">
          <div class="recommend-box ">
             <div class="bd invSetting">邀请好友加入528招聘网</div>
                <div class="bd">
                  	<div class="banner current1" style=" display:none">
                  	    <div class="operateBanner num1"><a href="invite2.jsp" class="title title1"></a></div>
                  	<div class="operateBanner num2"><a href="invite2_s.jsp" class="title title2"></a></div>
                </div>
            <div class="invite-box">
		        <div class="select-all">
		        <input id="allChecked" type="checkbox" checked="true" >&nbsp;
		        <label for="selectAll">全选</label>
		        <!--<span class="select-tips">你的邮箱的联系人已经有1个加入528招聘网，加他们为关注吧。</span>-->
                <div class="email-box">
                <ul id="emailUL">
                <s:iterator value="contacts">
                <li><span><input checked="checked" type="checkbox" value="${email }" class="fxk"/></span><span class="name">${username}</span><span class="email">${email}</span></li>
                </s:iterator>
                </ul>
                </div>
                <div class="attention"><a href="javascript:void(0);" id="inviteBtn" class="write">发送邀请</a></div>
		        </div>                   
		    </div>
          </div>
        </div>
      </div>
    </div>
<!-------------------------邀请 E------------------------->
				
			</div>
			<div class="clear"></div>
		</div>

		<!--版权 S-->
		<%@include file="/common/footer.jsp"%>
	</body>
</html>
