<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>消息中心</title>
		<%@include file="/common/meta.jsp"%>
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/css/index.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="${basePath}/js/dialog.js"></script>
		<script type="text/javascript" src="${basePath}/js/mymessage.js"></script>
		<script type="text/javascript">
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
						<li><a href="${basePath}/messages/" class="bhover"><b class="chover">关注信息</b></a></li>
						<li><a href="messagelist.shtml"><b>我的私信</b></a></li>
						</ul>
                    </div>

					<div class="application_down">
						<c:forEach items="${messagePager.messageList}" var="message">
						<div class="application_down_con">
							<div class="application_down_con_l">
								<a href="information.html"><img
										src="${basePath}${message.sender.photo}" width="50" height="50" />
								</a>
							</div>
							<div class="application_down_con_r">
								<span class="application_down_con_r_name" ><a
									href="${basePath}/profile/user.shtml?uid=${message.sender.uid}" class="juhuang" >${message.sender.name}</a>
								</span><span class="application_down_con_r_corner">${message.sendType}</span>
								<div class="clear"></div>
                                <div class="application_down_con_r_email">${message.content}
								
                                </div>
						</div>
                       </div>
						</c:forEach>
						<c:if test="${messagePager.dataCount <= 0}">
						<div style="text-align: center;margin-top: 10px;">
						<font id="noWeiboTip" style="color:#999;font-size:14px;">近期没有人关注你， 要加油哦~~</font>
						</div>
						</c:if>
						<div class="clear"></div>
						<c:if test="${messagePager.dataCount > 30}">
						<div class="job_con_center_list_fenye" >
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
        <%@include file="/common/reply_dialog.jsp"%> 
		<!--版权 S-->
		<%@include file="/common/footer.jsp"%>
	</body>
</html>
