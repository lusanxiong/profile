<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>${profile.resume.myResume.perName}的个人主页</title>
		<%@include file="/common/taglib.jsp"%>
		<%@include file="/common/meta.jsp"%>
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/weibo_user.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${basePath}/js/jquery.rotate.js"></script>
		<script type="text/javascript" src="${basePath}/js/message.js"></script>
		<script type="text/javascript" src="${basePath}/js/my.jquery.js"></script>
		<script type="text/javascript" src="${basePath}/js/weibo.js"></script>
		<script type="text/javascript" src="${basePath}/js/comment.js"></script>
		<script type="text/javascript" src="${basePath}/js/general.js"></script>
		<script type="text/javascript" src="${basePath}/js/dialog.js"></script>
		<script type="text/javascript" src="${basePath}/js/weibo_user.js"></script>
		<script type="text/javascript" src="${basePath}/js/privateMessage.js"></script>
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
						}
					};
					PM.sendMessage(param);
					$.unblockUI();
				}
			};
			$.messageDialog(setting);
		}
		</script>
		
	</head>
	<body>
		<!--头部 S-->
		<%@include file="/common/header.jsp"%>
		<!--头部 E-->
		<!--内容块 S-->
        <div class="user">
        	<div class="user_top">
            	<span class="ut_left"></span>
                <span class="ut_mid"></span>
                <span class="ut_right"></span>           
            </div>
            <div class="user_con">
            <!-- 个人信息 S -->
            	<div class="user_detail">
                	<div class="ud_left">
                    <!--  头像 S -->
                    	<div class="information_pro" style="text-align: center">
    <c:if test="${fn:indexOf(profile.resume.imgHead, 'http://') > -1}">
                        <img class="user_img" src="${profile.resume.imgHead}" width="190" height="190" />
                        </c:if>
                         <c:if test="${fn:indexOf(profile.resume.imgHead, 'http://') == -1}">
                        <img class="user_img" src="${basePath}/${profile.resume.imgHead}" width="190" height="190" />
                        </c:if>
    					</div>
                     <!-- 头像 E -->
                     <!--关注  粉丝 S -->
                     	<div class="information_word">
      <div class="information_friend">
        <div class="information_friend_yw">${profile.userProfile.attentionNumber}</div>
        <div class="information_friend_zw"><a href="${basePath}/friends/otherfollow.shtml?uid=${profile.resume.myResume.myUserId}" class="blues">关注</a></div>
      </div>
      
      <div class="information_friend">
        <div class="information_friend_yw">${profile.userProfile.fansNumber}</div>
        <div class="information_friend_zw"><a href="${basePath}/friends/otherfans.shtml?uid=${profile.resume.myResume.myUserId}" class="blues">粉丝</a></div>
      </div>
      
      <div class="information_friend">
        <div class="information_friend_yw">${profile.userProfile.weiboNumber}</div>
        <div class="information_friend_zw"><a href="javascript:void(0);" class="blues">动态</a></div>
      </div>
    </div>
                     <!-- 关注 粉丝 E -->
                     <!-- 关注按钮 S -->
                     <div style="margin-left:15px; width:173px;">
  <div class="information_button" id="relationFlag1"  style="display:${(flag==0 or flag==5)?'block':'none'}">
  <div class="hrl"><img id="attentionBtn" tid="${profile.resume.myResume.myUserId}" src="${basePath}/images/btn_jgz.gif" width="68" height="26" /></div>
  </div> 
  <div class="information_button" id="relationFlag2" style="display:${(flag==1 or flag==6)?'block':'none'}">
  <div class="ygz">
  <div class="word">已关注<span class="w_line">|</span><a href="javascript:void(0);" onclick="unattention({obj:$('#relationFlag2'),tid:${profile.resume.myResume.myUserId}})" class="juhuang">取消</a></div>
  </div>
  </div>
  
  <div class="information_button" id="relationFlag3" style="display:${(flag==2 or flag==7)?'block':'none'}">
  <div class="hxgz">
  <div class="word">互相关注<span class="w_line">|</span><a href="javascript:void(0);" onclick="unattention({obj:$('#relationFlag3'),tid:${profile.resume.myResume.myUserId}})" class="juhuang">取消</a></div>
  </div>
  </div>
  
  <c:if test="${flag>=5}"> 
 	<div class="inbut_fsx"><a href="javascript:void(0);" onclick="sendMyMsg({userName:'${profile.resume.myResume.perName}',userId:'${profile.resume.myResume.myUserId}'})" class="blues">发私信</a></div>
  </c:if>
</div>
                     <!-- 关注按钮 E -->
                    </div>
                    <div class="ud_right">
                    	<p class="user_name"><span class="un_name">${profile.resume.myResume.perName}</span><span class="un_area">${profile.resume.provinceLocation}</span></p>
                        <p class="user_assess"><span class="ua_title">自我评价</span><span class="ua_detail">${profile.resume.myResume.selfDescription}</span></p>
                          <c:if test="${profile.resume.myResume.resumeStatus==1}">
	  						<div class="information_line"></div>
	  							<div class="informations">
                                      <ul>
                                      <li>
                                      <span class="informations_img"><img src="${basePath}/images/informations.gif" /></span><span class="informations_word">${profile.resume.myResume.perName}设置了权限，你无法查看他的信息！</span>
                                      </li>
                                      </ul>	  
	  							</div>
	 						 <div class="information_line"></div>
	  					  </c:if>
                    	  <!-- 工作经历+教育经历 S -->
                          <c:if test="${profile.resume.myResume.resumeStatus!=1}">
                          <dl class="user_exp">
                          	<dt class="ua_title">工作经历</dt>
                            <dd class="ua_detail">
                            	<ul class="ue_content">
                                <c:forEach items="${profile.experience}" var="workExp" >
                                	<li>${workExp.myWorkExp.memName}</li>
                                    <li>${workExp.calling}</li>
                                    <li>${workExp.myWorkExp.beginDate}
								  <c:if test="${workExp.myWorkExp.endDate != ''}">-${workExp.myWorkExp.endDate}</c:if>
								  <c:if test="${workExp.myWorkExp.endDate == ''}">-至今</c:if></li>
                                 </c:forEach>
                                </ul>
                            </dd>
                           </dl>
                           <dl class="user_exp">
                          	<dt class="ua_title">教育经历</dt>
                            <dd class="ua_detail">
                            	<ul class="ue_content">
                                 <c:forEach items="${profile.education}" var="education" >
                                	<li>${education.myEducation.schoolName}</li>
                                    <li>${education.myEducation.speciality}</li>
                                    <li>${education.myEducation.beginDate}-${education.myEducation.endDate}</li>
                                 </c:forEach>
                                </ul>
                            </dd>
                           </dl>
                            </c:if>
                          <!-- 工作经历+教育经历 E -->
                          <p class="user_label">
                          <c:forEach  items="${labels}" var="label">
 
                          	<a href="<c:url value='${basePath}/friends/search.shtml'><c:param name='tag' value='${label.labelName}'/></c:url>"><span>${label.labelName}</span><em></em></a> 
 
                          </c:forEach>
                          </p>
                    </div>
                </div>
            <!-- 个人信息 E -->
            <!-- 个人动态 S -->
            	<div class="user_trend">
                	<div class="ut_top_n"><img src="../images/trend_tit.gif"/></div>
                    <div class="ut_con_n">
                    	<div class="ut_con_del">
                    	<div id="weiboDiv" class="information_cons"></div>
<!-- 加载更多S -->
<div id="moreLoadDiv">
<div id="moreLoading" align="center" style="display: none">
 <img src="${basePath}/images/loading.gif" />正在加载，请稍候...
</div>
<div class="loadmores"><span id="moreWeiboBtn" pageIndex="1" userId="${profile.resume.myResume.myUserId}" type="self">更多</span></div>
</div>
</div>
<!-- 加载更多E -->
                    </div>
                    <div class="ut_bot_n"></div>
                </div>
            <!-- 个人动态 E -->
            </div>
            <div class="user_bot">
            	<span class="ub_left"></span>
                <span class="ub_mid"> </span>
                <span class="ub_right"></span>               
            </div>
        </div>
        <!--内容块 E-->

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
