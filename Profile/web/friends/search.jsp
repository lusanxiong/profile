<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/common/taglib.jsp"%>
<%menu = "friend";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>搜索朋友-我的人脉</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="Content-Language" content="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/css/mysetting.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${basePath}/js/jquery.js"></script>	
		<script type="text/javascript" src="${basePath}/js/jquery.blockUI.js"></script>
		<script type="text/javascript" src="${basePath}/js/dialog.js"></script>
		<script type="text/javascript" src="${basePath}/js/friend.js"></script>
		<script type="text/javascript" src="${basePath}/js/address.js"></script>
        <script type="text/javascript" src="${basePath}/js/addressdialog.js"></script> 
        <script type="text/javascript" src="${basePath}/js/calling.js"></script>
        <script type="text/javascript" src="${basePath}/js/callingdialog.js"></script>

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
				    <li><a href="search.shtml" class="bhover"><b class="chover">搜索朋友</b></a></li>
					<li><a href="follow.shtml"><b>我关注的</b></a></li>
					<li><a href="fans.shtml"><b>关注我的</b></a></li>
                    <li><a href="invite.jsp"><b>邀请好友</b></a></li>
					</ul>
				</div>
			</div>

			<div class="people_content">
			<!--左边 S-->
            <div class="people_con_box">
            <!--搜索 S-->
            <div class="people_con_search">
            
            <form action="search.shtml" method="post" name="thisForm">
            <input type="hidden" name="intCity" id="_intCity" value="${ucondition.intCity}"/>
            <input type="hidden" name="intPost" id="_intPost" value="${ucondition.intPost}"/>
            <input type="hidden" name="calling" id="_calling" value="${ucondition.calling}"/>
            <input type="hidden" name="company" id="_company" value="${ucondition.company}"/>
            <input type="hidden" name="school" id="_school" value="${ucondition.school}"/>
            <input type="hidden" name="homeProvince" id="_homeProvince" value="${ucondition.homeProvince}"/>
            <input type="hidden" name="homeCity" id="_homeCity" value="${ucondition.homeCity}"/>
            <input type="hidden" name="page" id="page" value="${page}"/>
            <div class="top"><img src="${basePath}/images/search_friends_t.gif" width="652" height="7" /></div>
			<div class="cer">
				<span class="qzyx">求职意向：</span>
				<input type="hidden" id="_jloc"/>
				<input type="hidden" id="_jfoc"/>
				<span class="gzdd" id="spLocation" style="overflow: hidden;">工作地点</span>
				<span class="gzdd" id="spCalling" style="overflow: hidden;">岗位类别</span>
				<span><input type="text" class="srk" name="keyword" id="_keyword" onfocus="kFocus(this);" onblur="kBlur(this)" value="${ucondition.keyword}" /></span>
				<span class="xz"><img src="${basePath}/images/search_friends_xz.gif" width="175" height="33" onclick="searchFriend();" /></span>
			</div>

			<div class="dw"><img src="${basePath}/images/search_friends_d.gif" width="652" height="7" /></div>
            </form>
            </div>
            <!--搜索 E-->
            

            <div class="people_con_list">
            <div class="tle"><span class="all">共找到<b>${friends.totalSize}</b>个用户：</span>
           ${showCondition}
            </div>
            <div class="qx"><span><input type="checkbox" class="fxk" onclick="allChk(this)"/></span><span class="txt">全选</span><span class="plgz" style=" margin-left:542px; _margin-left:532px;"><a href="javascript:void(0);" onclick="batchAttention();" class="ble">批量关注</a></span></div>
            	<c:forEach items="${friends.list}" var="friend">
            	
            	<div class="people_con_lists">
           	    	<div class="block">
                        <div class="fxk"><input name="_ckTid" type="checkbox" class="fxks" id="_ckTidId${friend.userInfo.uid}" value="${friend.userInfo.uid}" fflag="${friend.friend.flag}"/></div>
                        <div class="pro">
                        <a href="${basePath}/profile/user.shtml?uid=${friend.userInfo.uid}" target="_black">
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
                            <span class="name"><a href="${basePath}/profile/user.shtml?uid=${friend.userInfo.uid}" class="bl">${friend.userInfo.name}</a></span>
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
                              <span class="line">|</span>
                              </div>
                              <div class="dw">自我介绍：${friend.introduction}</div>

                              <div id="hotLabelContainer" class="label_num">
							  <c:forEach items="${friend.userInfo.userLabelList}" var="labelInfo" varStatus="label" >
                               	<a onclick="searchFriendByLabel('${friend.userInfo.uid }_label_${label.index}')" id="${friend.userInfo.uid }_label_${label.index}" href="javascript:void(0);"  title="搜索">${labelInfo}</a>
                              </c:forEach>
                    </div>

                            </div> 
                            <div class="jgz">
                       <c:if test="${friend.friend.flag==-1}">     
                       <span class="ycfs" id="_attf${friend.userInfo.uid}"><img src="${basePath}/images/hot_concern.gif" width="71" height="17" onclick="attention(${friend.userInfo.uid});"/></span>
                       </c:if>
                       <c:if test="${friend.friend.flag>-1}">   
                         
                         <span class="thhy"  id="stg${friend.userInfo.uid}" >已关注</span>
                       </c:if>
                      </div>
            		</div>  
            	</div>
            	
            	
            	
            	
                </c:forEach>
               
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
                      <div class="search_term">
                      <div class="search_term_top"><span class="word">搜索条件</span></div>
                      <div class="search_term_cer">
                      <div class="content">
                      <dl>
                      <dt>我工作过的行业</dt>
                      
                      <c:forEach items="${calls}" var="call">
                      <dd ><a href="javascript:void(0);" class="ble" cid="_calling" onclick="setCondition(this);">${call}</a></dd>
                      </c:forEach>
                       <c:if test="${calls==null}">
                      <dd><a href="${basePath}/profile/experience.shtml" style="color: #0179E7">马上完善!</a></dd>
                      </c:if>
                      </dl>
                      <dl>
                      <dt>我工作过的公司</dt>
                       <c:forEach items="${comps}" var="cmp">
                      <dd><a href="javascript:void(0);"  class="ble" cid="_company" onclick="setCondition(this);">${cmp}</a></dd>
                      </c:forEach>
                      <c:if test="${comps==null}">
                      <dd><a href="${basePath}/profile/experience.shtml" style="color: #0179E7">马上完善!</a></dd>
                      </c:if>
                      </dl>
                      
                      <dl>
                      <dt>我的家乡</dt>
                      <dd>
                          <c:if test="${loginResume.homeProvince!='' || loginResume.homeCity!=''}">
                          <a style="color: #0179E7" cid="_homeProvince" onclick="setCondition(this);" class="ble">${loginResume.homeProvince}</a>  
                          <a style="color: #0179E7" cid="_homeCity" onclick="setCondition(this);" class="ble">${loginResume.homeCity}</a> 
                          </c:if>
                          <c:if test="${loginResume.homeProvince=='' && loginResume.homeCity==''}">
                          <a href="${basePath}/profile/" style="color: #0179E7">马上完善!</a>
                          </c:if>
                       </dd>
                      
                      </dl>
                      <dl>
                      <dt>我的学校</dt>
                      <c:forEach items="${schools}" var="sch">
                      <dd ><a href="javascript:void(0);" class="ble" cid="_school" onclick="setCondition(this);">${sch}</a></dd>
                      </c:forEach>
                      <c:if test="${schools==null}">
                      <dd><a href="${basePath}/profile/education.shtml" style="color: #0179E7">马上完善!</a></dd>
                      </c:if>
                      </dl>
                      </div>
                      </div>
                      <div class="search_term_dw"></div>
                      </div>
                      <!---------------右边 E--------------->
                      
			</div>
			<div class="clear"></div>
		</div>
		<!--人脉 E-->
        <%@include file="/common/address_dialog.jsp"%>
		<%@include file="/common/calling_dialog.jsp"%>
		<%@include file="/common/group_dialog.jsp"%>
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

		<!--版权 S-->
		<%@include file="/common/footer.jsp"%>
	</body>
</html>
