<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/common/taglib.jsp"%>
<%menu = "friend";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>我关注的-我的人脉</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="Content-Language" content="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${basePath}/js/jquery.js"></script>	
		<script type="text/javascript" src="${basePath}/js/my.jquery.js"></script>
		<script type="text/javascript" src="${basePath}/js/jquery.blockUI.js"></script>
		<script type="text/javascript" src="${basePath}/js/dialog.js"></script>
		<script type="text/javascript" src="${basePath}/js/general.js"></script>
		<script type="text/javascript" src="${basePath}/js/friend.js"></script>
		<script type="text/javascript" src="${basePath}/js/privateMessage.js"></script>
		<script type="text/javascript">
		$(document).ready(function() {
		  $.post(basePath + "/AjaxServlet", {
					action :"totalfriend"
				}, function(data) {
					var json = eval(data);
					var obj = json[0];
					 $("#_all").html(obj.ALL);
					 $("#_peer").html(obj.Peer);
					 $("#_colleague").html(obj.Colleague);
					 $("#_fellow").html(obj.Fellow);
					 $("#_classmate").html(obj.Classmate);
					 $("#_other").html(obj.Other);
				});
		})
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
					<li><a href="follow.shtml" class="bhover"><b class="chover">我关注的</b></a></li>
					<li><a href="fans.shtml"><b>关注我的</b></a></li>
                    <li><a href="invite.jsp"><b>邀请好友</b></a></li>
					</ul>
				</div>
			</div>

			<div class="people_content">
			<!--左边 S-->
            <div class="people_con_box">

            <div class="people_con_list">
            <div class="qb">
            
            <span class="word"><a href="follow.shtml" class="ble">全部</a></span>
            <span class="number" id="_all"></span>
            
            
             
            <span class="line">|</span>
            
            
            <span class="word"><a href="?gid=1" class="ble">同行</a></span>
            <span class="number" id="_peer"> </span>
            
            
            <span class="line">|</span>
            
            
            <span class="word"><a href="?gid=2" class="ble">同事</a></span>
            <span class="number" id="_colleague"> </span>
            
            
            <span class="line">|</span>
            
            <span class="word"><a href="?gid=3" class="ble">同乡</a></span>
            <span class="number" id="_fellow"> </span>
            
            
            <span class="line">|</span>
            
            <span class="word"><a href="?gid=4" class="ble">同学</a></span>
            <span class="number" id="_classmate"> </span>
            
             <span class="line">|</span>
            
            <span class="word"><a href="?gid=5" class="ble">其他</a></span>
            <span class="number" id="_other"> </span>
            
            </div>
            <div class="qx">
            <span><input type="checkbox" class="fxk" onclick="allChk(this)"/></span>
            <span class="txt">全选</span>
            <span class="plgz"><a href="javascript:void(0);" onclick="batchUnAttention();" class="ble">批量取消关注</a></span>
           </div>
            <c:forEach items="${friends.list}" var="friend">
            	<div class="people_con_lists" id="_li${friend.friend.userId}">
           	    	<div class="block" duid="${friend.friend.userId}">
                        <div class="fxk"><input name="_ckTid" type="checkbox" class="fxks" value="${friend.friend.userId}"/></div>
                        <div class="pro" style="text-align: center;">
                        <a href="${basePath}/profile/user.shtml?uid=${friend.friend.userId}" target="_black">
                        <c:if test="${fn:indexOf(friend.uhead, 'http://') > -1}">
                        <img src="${friend.uhead}" height="68" width="68"/>
                        </c:if>
                         <c:if test="${fn:indexOf(friend.uhead, 'http://') == -1}">
                        <img src="${basePath}/${friend.uhead}" height="68" width="68"/>
                        </c:if>
                        </a>
                        </div>
                        <div class="con">
                        	<div class="up">
                            <a href="${basePath}/profile/user.shtml?uid=${friend.friend.userId}" target="_black" class="bl"><span class="name">${friend.userInfo.name}</span></a>
                            <span class="icon">
                            <c:if test="${friend.userInfo.sex==1}">
                            <img src="${basePath}/images/search_friends_men.gif"/>
                            </c:if>
                            <c:if test="${friend.userInfo.sex!=1}">
                            <img src="${basePath}/images/search_friends_women.gif"/>
                            </c:if>
                            </span>
                            <span class="txt">${friend.place}</span>
                            <span class="txt">${friend.school}</span>
                            <span class="txt">${friend.speciality}</span>
                       	 	</div>
                              <div class="cer">
                              <span class="txt">关注</span>
                              <span class="number">${friend.follewsNum}</span>
                              <span class="line">|</span>
                              <span class="txt">粉丝</span>
                              <span class="number">${friend.fansNum}</span>
                              <span class="line">|</span>
                              <span class="txt">动态</span>
                              <span class="number">${friend.messageNum}</span>
                             
                              </div>
                              <div class="dw">自我介绍：${friend.introduction} </div>
                      </div> 
                            <div class="jgz">
                       <span class="xgfz" style="display:none" id="etg${friend.friend.userId}"><img src="${basePath}/images/btn_xgfz.gif" width="64" height="19" onclick="group(${friend.friend.userId},${friend.friend.groupId});"/></span>
                       <c:if test="${friend.followEach}">
                       <span class="hxgz" id="stg${friend.userInfo.uid}"><a href="#" class="ble">${friend.groupName}</a></span>
                       </c:if>
                       <c:if test="${!friend.followEach}">
                       <span class="ycfs" id="stg${friend.userInfo.uid}" >${friend.groupName}</span>
                       </c:if>
                       <span class="ycfs" onclick="unattention(${friend.friend.userId})"><a href="#" class="ble">取消关注</a></span>
                       <c:if test="${friend.followEach}">
                       <span class="ycfs" onclick="sendMyMsg({userName:'${friend.userInfo.name}',userId:'${friend.friend.userId}'})"><a href="#" class="ble">发私信</a></span>
                       </c:if>
                            </div>
            		</div>  
            	</div>
             </c:forEach>  
             <form action="follow.shtml" method="post" name="thisForm">
             <input type="hidden" name="page" id="page" value="${page}"/>
             <input type="hidden" name="gid" id="_gid" value="${group}"/>
             </form>
             <c:if test="${friends.totalPages>1}">
                <div class="search_but">
              
            <span class="left">
            <c:if test="${page<=1}"><img src="${basePath}/images/search_but_l.gif" width="28" height="21" /></c:if>
             <c:if test="${page>1}"><img src="${basePath}/images/search_but_lr.gif" width="28" height="21" onclick="goPage(${page-1})"/></c:if>
            </span>
            <span class="lefts" style=" display:none"><img src="${basePath}/images/search_but_lr.gif" width="28" height="21" /></span>
           ${friends.pagerString}
            <c:if test="${friends.pageNo>=friends.totalPages}"><img src="${basePath}/images/search_but_rr.gif" width="28" height="21" /></c:if>
            <c:if test="${friends.pageNo<friends.totalPages}"><img src="${basePath}/images/search_but_r.gif" width="28" height="21" onclick="goPage(${page+1})"/></c:if>
           
            <span class="top"><img src="${basePath}/images/search_but_top.gif" width="54" height="21" /></span>
            </div>
            </c:if>
            </div>
            
            </div>
            <!--左边 E-->
                     
                      <!---------------右边 S--------------->
                       <div class="hot_people" id="_hotUserShow">
               	  <%@include file="/html/hot_user0.jsp" %>
               	  </div>
                      <!---------------右边 E--------------->
			</div>
			<div class="clear"></div>
		</div>
		<!--人脉 E-->
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
		<%@include file="/common/message_dialog.jsp"%>
		<%@include file="/common/group_dialog.jsp"%>
		<%@include file="/common/smile.jsp"%>
		<!--版权 S-->
		<%@include file="/common/footer.jsp"%>
	</body>
</html>
