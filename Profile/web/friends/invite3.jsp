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
            <!---------------------------右边内容块 S------------------------------->
			<div class="msnlist">
    	<table cellspacing="0" cellpadding="0" border="0" width="500" style=" float:left; margin-left:300px; padding-top:130px; padding-bottom:130px; display:inline; clear:both">
  		<tbody>
        <tr>
        <td width="130" valign="middle"><span class="inend_1">你的邀请已成功发送！</span></td>
        <td align="left" width="342"><span class="inend_2"><a href="/invite/inviteAction.do">返回邀请页</a></span></td>
        <td width="28">&nbsp;</td>
        </tr>
		</tbody>
        </table>
   		</div>
				
			</div>
			<div class="clear"></div>
		</div>

		<!--版权 S-->
		<%@include file="/common/footer.jsp"%>
	</body>
</html>
