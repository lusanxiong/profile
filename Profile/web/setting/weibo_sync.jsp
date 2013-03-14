<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.job528.tencent.weibo.WeiBoOAuth" %>
<%@include file="/common/taglib.jsp"%>
<%
	menu = "set";
	
	//新浪授权页URL
	String sinaOauthUrl = com.job528.sina.weibo.Oauth2.getAuthorizationURL();
	
	//腾讯微博登陆url
	 String authoUrl= WeiBoOAuth.generateAuthorizationURL();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<title>微博同步</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="Content-Language" content="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
	    <link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/index.css" rel="stylesheet" type="text/css" />
        <link href="../css/mysetting.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${basePath}/js/jquery.js"></script>		

		<script type="text/javascript" src="${basePath}/js/jquery.js"></script>
	<script type="">
      var sinaWeiboOauthUrl = '<%=sinaOauthUrl%>'; //新浪微博授权url
      var authoUrl = '<%=authoUrl%>'
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
<!--新浪同步 S-->
    <div class="set">
      <div class="set_tle">
        <div class="set_tle_left">新浪同步</div>
        <div class="set_tle_center"></div>
        <div class="set_tle_right"><a href="applications.html"><img src="${basePath}/images/set_tle_right.gif" width="10" height="31" /></a></div>
      </div>
      <div class="set_down">
   		<div class="tongbu">
            	<p class="tongbu_text">你可以设置一个与528同步的外部微博账号，这样，不仅你在528上发布的微博可以实时同步到你的其他微博中，而且你在其他微博中发布的内容也会同步显示到你的528账户之中。 </p>
            <p class="tongbu_img"><img src="../images/setting/sina_change.gif" /></p>
            	<div class="tongbu_table" id="userWeiboSynInfoDiv">
                	<!-- 内容动态加载 -->	
               </div>
        </div>
            </div>
      </div>
    </div>
<!--新浪同步 E-->
  </div>
<!--内容块左 E-->

</div>
<script type="" src="${basePath}/js/weibo/weibo_syn.js"></script>
<script type="">getUserWeiboSynInfo();</script>
<div class="clear"></div>
<!--内容块 E-->

		<!--版权 S-->
		<%@include file="/common/footer.jsp"%>
	</body>
</html>
