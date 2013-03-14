<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
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
        <script type="text/javascript" src="${basePath}/js/my.jquery.js"></script>
        <script type="text/javascript" src="${basePath}/js/validator.js"></script>
        <script type="text/javascript" src="${basePath}/js/dialog.js"></script>
		<script type="text/javascript" src="${basePath}/js/general.js"></script>
		<script type="text/javascript" src="${basePath}/js/friend.js"></script>     
        <script type="text/javascript" src="${basePath}/js/invite.js"></script>
        <script type="text/javascript">
        	 function showDiv(index){
       	 		var self = $("#inviteBtn"+index)
               	var cls = self.attr("class");
               	if(cls=="title title"+index+" up"){
            		self.attr("class","title title"+index+" down")
                }else{
                	self.attr("class","title title"+index+" up")
                }
                $("#inviteDiv"+index).toggle();
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
					<li><a href="search.shtml"><b>搜索朋友</b></a></li>
					<li><a href="follow.shtml"><b>我关注的</b></a></li>
					<li><a href="fans.shtml"><b>关注我的</b></a></li>
                    <li><a href="invite.jsp" class="bhover"><b class="chover">邀请好友</b></a></li>
					</ul>
				</div>
			</div>
            
			<div class="people_content">
            <!-------------------------邀请 S------------------------->
			<div class="invite_box">
                 <div class="inviteoperate">
    	   	  <div class="invite-title"><img src="${basePath}/images/search_friends.gif" width="658" height="27" /></div>
				 <div class="note">
					 <!-- <span>请选择适合你的邀请方式。被邀请的人注册528招聘网后，就会自动关注你了。</span>-->
					 <!-- <a href="#" class="invite-history">查看邀请记录</a> -->
				</div>
                <!--1 S-->
              
			 <div class="method method1">
				<div class="title title1 up" id="inviteBtn1" onclick="showDiv('1');">
					<div class="operate"></div>
						</div>
                            <div class="block" style="display:none;" id="inviteDiv1">
							<div class="cell">
								<input id="url" type="text" value="http://528.cn/personal/reg/my_regone.jsp" readonly="true" class="enterBox inviteInput">
								<input type="button" value="复制链接" onclick="$.copyToClipboard($('#url').val());" class="btn">
							</div>
		<div class="tips">通过QQ、MSN、电子邮件将邀请链接发给你的朋友。他们注册后，会自动关注你。</div>
                           </div>
				</div>
                 <!--1 E-->
                 <!--2 S-->
			 <div class="method method2">
				<div class="title title2 up" id="inviteBtn2" onclick="showDiv('2');">
					<div class="operate"></div>
						</div>
						<form id="emailInviteForm" action="${basePath}/friends/importInvite.shtml" method="post">
                            <div class="block" style="display:none" id="inviteDiv2">
							<div class="emaill">
								<span class="yx">你的邮箱：</span>
                                <span><input id="emailUserName" name="username" type="text" class="bloack" /></span>
                                <span class="fh">@</span>
                                <span>
                                <select name="emailType" id="emailType">
                                  <option value="0">选择邮箱</option>
                                  <option value="163">163.com</option>
									<option value="126">126.com</option>
									<option value="yeah">yeah.net</option>
									<option value="sina">sina.com</option>
									<option value="gmail">gmail.com</option>
									<option value="sohu">sohu.com</option>
									<option value="tom">tom.com</option>
									<option value="yahoo">yahoo.cn</option>
                                </select>
                                </span>
                              </div>
                             <div class="emaill">
								<span class="yx">你的密码：</span>
                                <span><input id="emailPassword" name="password" type="password" class="bloack" /></span>
                                <span><input id="mailBtn" type="button" value="查看好友并邀请" class="btn"></span>
                              </div>                                
							<div class="tips" id="mailInfoTip">528招聘网不会存储你的邮箱密码，请放心使用。</div>
                            <div class="tips" style="display: none" id="mailloadingTip"><img src="${basePath}/images/loading.gif" width="16" height="16" /><span>正在查找，这需要几秒钟，请耐心等待</span></div>
                           </div>
                           </form>
				</div>
                 <!--2 E-->
                 <!--3 S-->
			 <div class="method method3">
				<div class="title title3 up" id="inviteBtn3" onclick="showDiv('3');">
					<div class="operate"></div>
						</div>
						<form id="msnInviteForm" action="${basePath}/friends/msnInvite.shtml" method="post">
                            <div class="block" style="display:none" id="inviteDiv3">
							<div class="emaill">
								<span class="yx">你的MSN账号：</span>
                                <span><input name="username" id="msnUserName" type="text" class="bloack" /></span>
                                <span class="fh">如：msn@hotmail.com</span>
							</div>
                            <div class="emaill">
								<span class="yx">你的MSN密码：</span>
                                <span><input id="msnPassword" name="password" type="password" class="bloack" /></span>
                                <span><input type="button" id="msnBtn" value="查看好友并邀请" class="btn"></span>
							</div>
							<div class="tips" id="msnInfoTip">528招聘网不会存储你的MSN密码，请放心使用。</div>
					        <div class="tips" id="msnLoadingTip" style="display: none"><img src="${basePath}/images/loading.gif" width="16" height="16" /><span>正在查找，这需要几秒钟，请耐心等待</span></div>
					        <div class="tips" id="msnLoginTip" style="display: none"><span>登陆失败，重新测试</span></div>
					        <div class="tips" id="msnNoTip" style="display: none"><span>你的MSN没有联系人，请通过其他方式邀请好友</span></div>
					        <div class="tips"><span>温馨提示：</span>邀请MSN好友时，您的MSN会暂时下线，请不要担心。</div>
					        </div>
					        </form>
				</div>
                 <!--3 E-->
                 <!--4 S-->
			 <div class="method method4">
				<div class="title title4 up" id="inviteBtn4" onclick="showDiv('4');">
					<div class="operate"></div>
						</div>
                            <div class="block" style="display:none" id="inviteDiv4">
							<div class="cell">
								<input type="text" id="myEmail" value="" class="enterBox inviteInput">
								<input type="button" id="myEmailBtn" value="发送邀请" class="btn">
							</div>
		<div class="tips" id="myEmailTip">输入好友Email直接邀请，多个Email请用;分开。</div>
		<div class="tips" id="myLoadingTip" style="display: none"><img src="${basePath}/images/loading.gif" width="16" height="16" /><span>邮件发送中，这需要几秒钟，请耐心等待</span></div>
        <div class="tips">请输入完整的Email，如：example@163.com;test@126.com;id@yeah.net</div>
             <!--5 S-->
                <div class="pro">
                <div class="pre">
                <div class="txt">预览邀请邮件</div>
                </div>
                <div class="tle">Hi，我是<i><input id="userName" value="${sessionScope.login_user_resume.myResume.perName }" type="text" class="blod" /></i></div>
                <div class="con">我在528招聘网开通账号了！现在我和朋友们在528招聘网上记录自己的生活点滴。关注、交流身边以及世界上正在发生的事情。<br />
528招聘网是中国著名招聘网站，
赶紧来吧，点击下面的链接20秒就能注册528招聘网！<br /><br />
<a href="http://528.cn/personal/reg/my_regone.jsp" class="sblue">http://528.cn/personal/reg/my_regone.jsp</a><br />
<u>（如果以上链接点击无效，请复制该链接地址到浏览器地址栏中打开）</u><br />
玩得开心哟！<br />
528招聘网</div>
                 </div>
                 <!--5 E-->         
                 </div>
				 </div>
                 <!--4 E-->
                 
                </div>		
<style type="text/css">
        .dialog .client {
    -moz-border-bottom-colors: none;
    -moz-border-image: none;
    -moz-border-left-colors: none;
    -moz-border-right-colors: none;
    -moz-border-top-colors: none;
    background-color: #FFFFFF;
    border-color: #888888;
    border-style: solid;
    border-width: 0 1px;
	height:58px;
	_height:86px;
    padding: 14px;
	text-align:left;
	width:350px;
	_width:376px;
	overflow:hidden;
}

.dialog .buttons {
    -moz-border-bottom-colors: none;
    -moz-border-image: none;
    -moz-border-left-colors: none;
    -moz-border-right-colors: none;
    -moz-border-top-colors: none;
    background-color: #F6F6F6;
    background-position: 8px center;
    border-color: #CCCCCC #888888 #888888;
    border-right: 1px solid #888888;
    border-style: solid;
    border-width: 1px;
	height:26px;
	width:370px;
	_width:376px;
    clear: both;
    padding: 8px 8px 8px 0;
    text-align: right;
}
        </style>
               <!-------------------------邀请 s------------------------->
                <div class="hot_people" id="_hotUserShow">
               	  <%@include file="/html/hot_user0.jsp" %>
               	  </div>
               	  <!-------------------------邀请 E------------------------->
                </div>	
                </div>
			<div class="clear"></div>
		</div>
<%@include file="/common/group_dialog.jsp"%>
		<!--版权 S-->
		<%@include file="/common/footer.jsp"%>
	</body>
</html>
