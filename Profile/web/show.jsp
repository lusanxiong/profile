<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="w" uri="/weibo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>${profile.userProfile.userName}的动态</title>
		<%@include file="/common/meta.jsp"%>
		<%@include file="/common/taglib.jsp"%>
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css">
        <link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css">
        <link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/weibo_show.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="${basePath}/js/jquery.rotate.js"></script>
		<script type="text/javascript" src="${basePath}/js/message.js"></script>
		<script type="text/javascript" src="${basePath}/js/my.jquery.js"></script>
		<script type="text/javascript" src="${basePath}/js/weibo.js"></script>
		<script type="text/javascript" src="${basePath}/js/comment.js"></script>
		<script type="text/javascript" src="${basePath}/js/general.js"></script>
		<script type="text/javascript" src="${basePath}/js/dialog.js"></script>
		<script type="text/javascript" src="${basePath}/js/weibo_show.js"></script>
		<script type="text/javascript">
		$(function(){
			var attentionBtn = $("#attentionBtn");
			attentionBtn.click(function(){
				var tid = attentionBtn.attr("tid");
				var goupId = $(this).attr("id");
				var action = "attention";
				$.post(basePath + "/AjaxServlet", {
					"targetId" : tid,
					"group" : 5,
					"action" : action
				}, function(data) {
					if(data==1 || data==100){
						$("#relationFlag1").hide();
						$("#relationFlag2").show();
						group(tid);
					}
					else if(data==2){
						$("#relationFlag1").hide();
						$("#relationFlag3").show();
						group(tid);
					}
					else if(data==3){
						alert("自己不能关注自己.");
					}
				});
			});

			//-----------
			$("#moreCommentBtn").on("click",function(){
				loadMoreComment();
			});
		});

		function unattention(p){
			var action="unattention";
			var tid = p.tid;
			$.post(basePath + "/AjaxServlet", {
				"targetId" : tid,
				"group" : 0,
				"action" : action
			}, function(data) {
				if(data==0){
					p.obj.hide();
					$("#relationFlag1").show();
				}
				else{
					alert("取消关注失败.");
				}
			});
		}

		function group(tid){
			var setting = {
					css:{ top:'30%',left: '28%' },
					ok : function() {
						var goupId = $("#_goupId").val();
						$.post(basePath + "/AjaxServlet", {
							targetId : tid,
							group : goupId,
							action :"changegroup"
						});
					}
				};
			$.groupDialog(setting);
		}

		function sendMsg(p){
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
						receiveId : userId,
						content : content,
						callback:function(data){
							alert("发送成功")
						}
					};
					sendMessage(param);
					$.unblockUI();
				}
			};
			$.messageDialog(setting);
		}

		function loadMoreComment(){
			var weiboId = $("#weiboId").val();
			var pageIndex = $("#moreCommentBtn").attr("pageIndex");
			var commentList = $("#commentList_"+weiboId);
			var p = {
				weiboId : weiboId,
				pageIndex : pageIndex,
				showMore:0,
				success : function(msg) {
					if (msg == 500) {
						alert("未登录");
					} else if($.trim(msg)==""){
						$("#moreCommentBtn").off("click").html(Loading.over);
					}else {
						commentList.append(msg);
						$("#moreCommentBtn").attr("pageIndex",parseInt(pageIndex)+1);
					}
				}
			};
			Comment.getCommentList(p);
		}
		</script>
		
	</head>
	<body>
		<!--头部 S-->
		<%@include file="/common/header.jsp"%>
		<!--头部 E-->
		<!-- 内容块 S -->
         <div class="user">
        	<div class="user_top">
            	<span class="ut_left"></span>
                <span class="ut_mid"></span>
                <span class="ut_right"></span>           
            </div>
            <div class="user_con">
            	<div class="user_detail">
                    <div class="ud_left">
                    	<div class="information_pro"><img class="user_img" src="${profile.userProfile.headImage} " width="190" height="190" /></div>
       					<div class="information_word">
          <div class="information_friend">
            <div class="information_friend_yw">${profile.userProfile.attentionNumber}</div>
            <div class="information_friend_zw"><a href="${basePath}/friends/otherfollow.shtml?uid=${profile.userProfile.userId}" class="blues">关注</a></div>
          </div>
          
          <div class="information_friend">
            <div class="information_friend_yw">${profile.userProfile.fansNumber}</div>
            <div class="information_friend_zw"><a href="${basePath}/friends/otherfans.shtml?uid=${profile.userProfile.userId}" class="blues">粉丝</a></div>
          </div>
          
          <div class="information_friend">
            <div class="information_friend_yw">${profile.userProfile.weiboNumber}</div>
            <div class="information_friend_zw"><a href="${basePath}/profile/user.shtml?uid=${profile.userProfile.userId}" class="blues">动态</a></div>
          </div>
        </div>
        <!-- 关注按钮 S -->
        				<div style="margin-left:15px; width:173px;">
  <div class="information_button" id="relationFlag1"  style="display:${(flag==0 or flag==5)?'block':'none'}">
  <div class="hrl"><img id="attentionBtn" tid="${profile.userProfile.userId}" src="${basePath}/images/btn_jgz.gif" width="68" height="26" /></div>
  </div>
  
  <div class="information_button" id="relationFlag2" style="display:${(flag==1 or flag==6)?'block':'none'}">
  <div class="ygz">
  <div class="word">已关注<span class="w_line">|</span><a href="javascript:void(0);" onclick="unattention({obj:$('#relationFlag2'),tid:${profile.userProfile.userId}})" class="juhuang">取消</a></div>
  </div>
  </div>
  
  <div class="information_button" id="relationFlag3" style="display:${(flag==2 or flag==7)?'block':'none'}">
  <div class="hxgz">
  <div class="word">互相关注<span class="w_line">|</span><a href="javascript:void(0);" onclick="unattention({obj:$('#relationFlag3'),tid:${profile.userProfile.userId}})" class="juhuang">取消</a></div>
  </div>
  </div>
  
  <c:if test="${flag>=5}"> 
 	<div class="inbut_fsx"><a href="javascript:void(0);" onclick="sendMsg({userName:'${profile.userProfile.userName}',userId:'${profile.userProfile.userId}'})" class="blues">发私信</a></div>
  </c:if>
</div>
        <!-- 关注按钮 E -->
                    </div>
                    <div class="ud_right">
                    	<div id="weiboDiv" class="information_cons">
 <%@ include file="/common/weibo_iterator2.jsp" %>
</div>
<div class="clear"></div>
<!-- 加载更多 S -->
<s:if test="commentList!=null">
<div id="moreLoadDiv">
<div id="moreLoading" align="center" style="display: none">
 <img src="${basePath}/images/loading.gif" />正在加载，请稍候...
</div>
<div class="loadmores"><span id="moreCommentBtn" pageIndex="2" userId="${profile.userProfile.userId}" type="self">更多</span></div>
</div>
</s:if>
<!-- 加载更多E -->
                    </div>  
                </div>          
            </div>
            <div class="user_bot">
            	<span class="ub_left"></span>
                <span class="ub_mid"> </span>
                <span class="ub_right"></span>               
            </div>
        </div>
        <!-- 内容块 E -->

<%@include file="/common/group_dialog.jsp"%>
<%@include file="/common/message_dialog.jsp"%>
<%@include file="/common/forward_dialog.jsp"%>
<%@include file="/common/confirm_dialog.jsp"%>
<%@include file="/common/smile.jsp"%>
<!--内容块 E-->

	<!--版权 S-->
	<%@include file="/common/footer.jsp"%>
	</body>
</html>
