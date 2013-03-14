<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="w" uri="/weibo-tags" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>我和 ${who} 的对话-消息中心</title>
		<%@include file="/common/meta.jsp"%>
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/css/index.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="${basePath}/js/message.js"></script>
    	<script type="text/javascript" src="${basePath}/js/my.jquery.js"></script>
        <script type="text/javascript" src="${basePath}/js/dialog.js"></script>
		<script type="text/javascript" src="${basePath}/js/mymessage.js"></script>
		<script type="text/javascript" src="${basePath}/js/general.js"></script>
		<script type="text/javascript" src="${basePath}/js/privateMessage.js"></script>
		<script type="text/javascript">
		
		$(function(){ 
			$("#messageText").focus();
			
			$("#smileBtn").click(function(){
				if($("#smileDiv").is(":visible")){
					return ;
				}
				var offset = $(this).offset();
				var top = offset.top;
				var left = offset.left;
				top = top + 26;
				doShowSmile(top,left,$("#messageText"));
			});

			$("#messageText").on("keyup",function(){
				validateLength($.trim($(this).val()),$("#wordsTip"));
			});

			$("#publishBtn").on("click",function(){
				sendMessage();
			});

			function sendMessage() {
				var messageText = $("#messageText");
				var texts = $.trim(messageText.val());
				if(texts==""){
					$.colorTip($(messageText));
					return ;
				}
				if(!validateLength(texts,$("#wordsTip"))) {
					$.colorTip($("#wordsTip"));
					return ;
				}

				messageText.attr("readOnly",true);
				$("#publishBtn").off("click");

				var p = {
					targetId:${param.tid},
					message:texts,
					success:function(msg){
						$("#publishBtn").on("click",function(){
							sendMessage();
						});
						messageText.attr("readOnly",false);
						messageText.val("");
						validateLength("",$("#wordsTip"))
						if(msg==500) {
							alert(Message.text500);
							return;
						}
						$("#pmDiv").prepend(msg);
						$("#pmDiv>div:first").hide().fadeIn("slow");
					}
				};
				PM.sendMessage(p);
			}
		});

		function goReply(){
			$("#messageText").focus();
			$('body').scrollTo(1000,200);
			$("#messageText").focus();
		}

		function deleteMessage(messageId) {
			var setting = {
				title : Dialog.pm.confirmTitle,
				content : Dialog.pm.confirmContent,
				css:{ top:'25%',left: '20%' },
				ok : function() {
					var p = {
						messageId:messageId,
						success:function(msg){
							if(msg==0){
								$("#pm_"+messageId).fadeOut("slow");								
							}
						}
					}
					PM.deleteMessage(p);
				}
			};
			$.confirmDialog(setting);
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
						<li><a href="${basePath}/messages/messagelist.shtml" class="bhover"><b class="chover">我的私信</b></a></li>
						</ul>
                    </div>

					<div class="application_down">
                    
                    <div class="box">
                    <div class="send">我和 ${who} 的对话</div>
                    <div class="send_back"><a href="messagelist.shtml" class="blues">返回所有私信</a> 共${msgCount}条私信</div>
                    <div class="send_input">
                    <div class="email"><span class="img"><img src="${basePath}/images/send_mail.gif" width="16" height="11" /></span>
                    <span class="word">发私信给：${who}</span>
                    <span id="wordsTip" class="words">还可以输入<span class="share_tle_yw">140</span>字</span></div>
                    <div class="block">
                    <div style="position:absolute;">
                  <div style="position:relative; left:487px; top:20px; _left:-1px;">
                  <img src="${basePath}/images/send_block_right.gif" width="7" height="14" /></div>
                  </div>
                    <div class="left">
                    <div class="top"><img src="${basePath}/images/send_block_top.gif" width="488" height="6" /></div>
                    <div class="cer"><textarea id="messageText" class="cers" onkeydown="ctrlEnter(event,$('#publishBtn'));"></textarea></div>
                  
                   <div class="sends_dw">
    			 <ul>
    			 <li><a href="javascript:void(0);" id="smileBtn"><span class="sends_icon"><img src="${basePath}/images/icon_01.gif" width="19" height="19" /></span><span class="sends_word">表情</span></a></li>
			    </ul>
   				 <span id="publishBtn"  title="Ctrl+Enter快速提交" class="sends_dw_button"><a href="javascript:void(0);" ></a></span>
    </div>
            <div class="dw"><img src="${basePath}/images/send_block_dw.gif" width="488" height="6" /></div>
                    </div>
                    <div class="right">
                    <img src="${loginResume.imgHead}" width="50" height="50" />
                    </div>
                    </div>
                    </div>
                    <div id="pmDiv">
                  		<%@include file="/common/pm_iterator.jsp" %>
                 	</div>
                    </div>
                    <div class="clear"></div>
				  </div>	
                    
				<!--好友申请/关注 E-->
			</div>
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
        </div>
		<div class="clear"></div>
        <%@include file="/common/smile.jsp" %>
        <%@include file="/common/confirm_dialog.jsp"%>
		<%@include file="/common/footer.jsp"%>
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
	</body>
</html>
