<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/common/taglib.jsp"%>
<%menu = "friend";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>关注${myResume.perName}的-${myResume.perName}的人脉</title>
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
					<li><a href="otherfollow.shtml?uid=${myResume.myUserId}"><b>${myResume.perName}关注的</b></a></li>
					<li><a href="otherfans.shtml?uid=${myResume.myUserId}" class="bhover"><b class="chover">关注${myResume.perName}的</b></a></li>
					</ul>
				</div>
			</div>

			<div class="people_content">
			<!--左边 S-->
            <div class="people_con_box">

            <div class="people_con_list">
            <div class="qxs">
            <span><input type="checkbox" class="fxk" onclick="allChk(this)"/></span>
            <span class="txt">全选</span>
            <span class="plgzsd"><a href="javascript:void(0);" class="ble" onclick="batchAttention();">批量关注</a></span>
           </div>
            <c:forEach items="${friends.list}" var="friend"> 
            	<div class="people_con_lists" id="_li${friend.friend.userId}"> <c:if test=""></c:if>
           	    	<div class="block">
                        <div class="fxk"><input name="_ckTid" id="_ckTidId${friend.friend.userId}" type="checkbox" class="fxks" value="${friend.friend.userId}" fflag="<c:if test='${friend.followEach}'>0</c:if><c:if test='${!friend.followEach}'>-1</c:if>"/></div>
                        <div class="pro">
                        <a href="${basePath}/profile/user.shtml?uid=${friend.friend.userId}" target="_black">
                        
                        <c:if test="${fn:indexOf(friend.uhead, 'http://') > -1}">
                        <img src="${friend.uhead}"  width="68" height="68" />
                        </c:if>
                         <c:if test="${fn:indexOf(friend.uhead, 'http://') == -1}">
                        <img src="${basePath}/${friend.uhead}" width="68" height="68" />
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
                              <div class="dw">自我介绍：${friend.introduction}</div>
                            </div> 
                            <div class="jgz">
                                  <c:choose>
                            <c:when test="${friend.friend.flag ==0 || friend.friend.flag==5}">
                            <span class="ycfs" id="_attf${friend.friend.userId}"><img src="${basePath}/images/hot_concern.gif" height="17" onclick="attention(${friend.friend.userId});"/></span>
                            </c:when>
                           <c:otherwise>
                           <span class="thhy">已关注</span>
                           </c:otherwise>
                            </c:choose>
                            </div>
            		</div>  
            	</div>
              </c:forEach>  
               <form action="otherfans.shtml?uid=${myResume.myUserId}" method="post" name="thisForm">
             <input type="hidden" name="page" id="page" value="${page}"/>
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
