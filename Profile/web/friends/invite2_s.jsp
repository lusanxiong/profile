<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/common/taglib.jsp"%>
<%menu = "friend";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>我的人脉</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="Content-Language" content="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/css/invite.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="${basePath}/js/jquery.js"></script>	
		<script type="text/javascript" src="${basePath}/js/jquery.blockUI.js"></script>
		<script type="text/javascript" src="${basePath}/js/jobdialog.js"></script>
		<script type="text/javascript" src="${basePath}/js/friend.js"></script>

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
						<li><a href="search.shtml"><b>我关注的</b></a></li>
						<li><a href="follow.shtml"><b>关注我的</b></a></li>
						<li><a href="fans.shtml"><b>可能认识的</b></a></li>
                        <li><a href="invite.jsp" class="bhover"><b class="chover" >邀请好友</b></a></li>
					</ul>
				</div>
			</div>
            
			<div class="people_content">
<!-------------------------邀请 S------------------------->
	<div class="invite_box">
       <div class="invitelist">
          <div class="recommend-box ">
             <div class="bd invSetting">邀请好友加入528招聘网，畅享职场生活</div>
                <div class="bd">
                  	<div class="banner current2" style="display:none">
                  	    <div class="operateBanner num1"><a href="invite2.jsp" class="title title1"></a></div>
                  	<div class="operateBanner num2"><a href="invite2_s.jsp" class="title title2"></a></div>
                </div>
            <div class="invite-box">
		        <div class="select-all">
		        <input type="checkbox" checked="true" >&nbsp;
		        <label for="selectAll">全选</label>
		        <span class="select-tips">还有14个联系人还没有加入528招聘网，请他们加入吧。</span>
                <div class="email-box">
                <ul>
                <li><span><input name="" type="checkbox" value="" class="fxk"/></span><span class="name">唐高红</span><span class="email">tanggaohong@163.com</span></li>
                <li><span><input name="" type="checkbox" value="" class="fxk"/></span><span class="name">唐高红</span><span class="email">tanggaohong@163.com</span></li>
                <li><span><input name="" type="checkbox" value="" class="fxk"/></span><span class="name">唐高红</span><span class="email">tanggaohong@163.com</span></li>
                <li><span><input name="" type="checkbox" value="" class="fxk"/></span><span class="name">唐高红</span><span class="email">tanggaohong@163.com</span></li>
                <li><span><input name="" type="checkbox" value="" class="fxk"/></span><span class="name">唐高红</span><span class="email">tanggaohong@163.com</span></li>
                </ul>
                </div>
                <div class="attention"><a href="#" class="write">发送邀请</a></div>
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
