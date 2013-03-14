<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="w" uri="/weibo-tags" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>我收到的私信-消息中心</title>
		<%@include file="/common/meta.jsp"%>
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/css/index.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="${basePath}/js/general.js"></script>
        <script type="text/javascript" src="${basePath}/js/my.jquery.js"></script> 
        <script type="text/javascript" src="${basePath}/js/dialog.js"></script>
		<script type="text/javascript" src="${basePath}/js/mymessage.js"></script>
		<script type="text/javascript" src="${basePath}/js/privateMessage.js"></script>
		<script type="text/javascript">
		$(function() {
			$(document).click(function(e) {
				closeSmileDiv(e);
			});
		});
		
		function sendMyMsg(p){
			$("#_messsage_userName").html(p.userName);
			var setting = {
				css:{ top:'30%',left: '28%' },
				ok : function() {
					var text = $("#_message_text");
					var userId = p.userId;
					var content = $.trim(text.val());
					if (content == "") {
						$.colorTip(text);
						return;
					}
					var target = $("#_message_wordsTip");
					if (!validateLength(content, target)) {
						$.colorTip(target);
						return;
					}
					var param = {
						targetId : userId,
						message : content,
						success:function(data){
							alert("发送成功:");
						}
					};
					PM.sendMessage(param);
					$.unblockUI();
				}
			};
			$.messageDialog(setting);
		}

		var showJobState = function(show){
           if(show==0){
              $("#divJobState").hide();
           }else{
              $("#divJobState").show();
           }
        }
    
        var changeJobState = function(state){
        var jobStateIndex = state.selectedIndex;  
        $.post(basePath+"/AjaxServlet", {"action" : "changejobstate","jobState":jobStateIndex
	  			}, function(data) {
		       $("#jobState").html("<br>" + state.options[jobStateIndex].text);
		       $("#divJobState").hide();
	       });
        }
		
		</script>
	</head>
	<body>
		<!--头部 S-->
		<%@include file="/common/header.jsp"%>
		<!--头部 E-->
		<!--内容块 S-->
		<div class="index_content">
			<!--内容块左 S-->
			<div class="index_content_left">

				<!--好友申请/关注 S-->
				<div class="application">
					<div class="application_tle">
						<ul>
						<li><a href="${basePath}/messages/"><b>关注信息</b></a></li>
						<li><a href="messagelist.shtml" class="bhover"><b class="chover">我的私信</b></a></li>
						</ul>
                    </div>

					<div class="application_down">
<s:iterator value="list">
<div class="application_down_con" id="divMessage${message.id}">
	<div class="application_down_con_l">
		<a href="${basePath}/profile/user.shtml?uid=${myMessageInfo.userId==cookieUserId ? myMessageInfo.targetId:myMessageInfo.userId}">
		<img src="${headImage}" width="50" height="50" />
		</a>
	</div>
	
	    <div class="comment_messages">
			<p><font style=" font-weight:bold; white-space:nowrap;"><a class="blues" href="${basePath}/profile/user.shtml?uid=${myMessageInfo.userId==cookieUserId ? myMessageInfo.targetId:myMessageInfo.userId}" id="spaSender${message.id}">${userName}</a>：</font><font id="spcSender${message.id}">
			<s:if test="#request.cookieUserId==myMessageInfo.userId">
				<w:text value="myMessageInfo.ulastMessage" />
			</s:if>
			<s:else>
				<w:text value="myMessageInfo.tlastMessage" />
			</s:else>
			</font>
		</p>
		
		<p class="operate">
		<span class="pub_time">${myMessageInfo.userId==cookieUserId ? myMessageInfo.ucreateDate:myMessageInfo.tcreateDate}</span>
		<span class="pubb_caozuo">
		<span id="delBtn_103">
		</span>
		<a class="blues" href="${basePath }/messages/messageinfo.shtml?tid=${myMessageInfo.userId==cookieUserId ? myMessageInfo.targetId:myMessageInfo.userId}">共${myMessageInfo.userId==cookieUserId ? myMessageInfo.ucount:myMessageInfo.tcount}条私信</a>
		|
		<a class="blues" href="javascript:void(0);" onclick="sendMyMsg({userName:'${userName}',userId:${myMessageInfo.userId==cookieUserId ? myMessageInfo.targetId:myMessageInfo.userId}});">回复</a>
		</span>
		</p>
		</div>
		</div>
</s:iterator>
						<c:if test="${messagePager.dataCount <= 0}">
						<div style="text-align: center;margin-top: 10px;">
						<font id="noWeiboTip" style="color:#999;font-size:14px;">还没有人给你发私信，你可以给他人发私信哦~~</font>
						</div>
						</c:if>
						<div class="clear"></div>
						<c:if test="${messagePager.dataCount > 30}">
						<div class="job_con_center_list_fenye">
							<div class="job_con_center_list_fenye_l">
								<ul>
									<li>
										<input type="button" value="上一页"
											class="job_con_center_list_fenye_ls" />
									</li>
									<li>
										<input type="button" value="下一页"
											class="job_con_center_list_fenye_ls" />
									</li>
								</ul>
							</div>
						</div>
						</c:if>
						<div class="clear"></div>
					</div>
				</div>
				<div class="clear"></div>
				<!--好友申请/关注 E-->
			</div>
			<!--内容块左 E-->

			<!--内容块右 S-->
			<div class="index_con_r">
<!--个人信息 S-->   
    <%@include file="/common/my_head.jsp"%>  

<div class="per_pro">
<div class="personal_top"><img src="${basePath}/images/personal_top.gif" width="205" height="10" /></div>
<div class="personal_cer">
<div class="per_pro_tles"></div>
<div class="per_pro_friend" id="divRandomFriend">
<img src="${basePath}/images/loading.gif">

</div></div>
<div class="personal_down"><img src="${basePath}/images/personal_dw.gif" width="205" height="10" /></div>
</div>
</div>
			<!--内容块右 E-->
		</div>
		<div class="clear"></div>
		<!--内容块 E-->
        <%@include file="/common/message_dialog.jsp"%>
        <%@include file="/common/smile.jsp"%>
		<!--版权 S-->
		<%@include file="/common/footer.jsp"%>
	</body>
</html>
