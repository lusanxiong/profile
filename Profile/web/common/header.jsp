<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript" src="${basePath}/js/search.js"></script>
<script type="text/javascript" src="${basePath}/js/message_queue.js"></script>

<div class="head">
<div class="logo"><img src="${basePath}/images/logos.gif" width="224" height="63"></div>
<div class="submenu">
<div class="submenu_r">
	<ul>
    <li><span class="findman"><a href="${basePath}/friends/search.shtml">找人</a></span></li>
    <li class="list">
    <a id="messageBtn" href="${basePath}/messages/">
    <span class="word">消息</span>
    <span class="but"><img src="${basePath}/images/sub_button.gif" width="5" height="3" /></span></a>
    </li>
    <li class="list">
    <a id="settingsBtn" href="javascript:void(0);">
    <span class="word">设置</span>
    <span class="but"><img src="${basePath}/images/sub_button.gif" width="5" height="3" /></span></a>
    </li>
     <li><span class="findman"><a href="${mainWeb}/personal/center/resume_cn/resumeindexcn.do">返回旧版</a></span></li>
    </ul>
</div>  

<div class="submenu_l">
<ul>
<li><span class="email"><a href="${basePath}/profile/user.shtml?uid=${cookieUserId}">${loginResume.myResume.perName}</a></span></li>
</ul>
</div>
<!--<div class="submenu_c"><a href="${basePath}/messages/"><img src="${basePath}/images/msg.png" /></a></div>--> 
</div>

<div id="messageQueueBox" style="position: relative; z-index:1;display:none">
<div style=" position:absolute; top:40px; left:732px; *top:-1px; *left:732px;*top:41px; _left:118px; _top:0px;">
<div class="prompt_message">
<div class="prompt_message_l">
<ul id="messageQueueUL">
<li id="privateNumberLi"><span>1</span>条新私信，<a href="${basePath}/messages/messagelist.shtml" class="blues">查看私信</a></li>
<li id="fansNumberLi"><span>1</span>位新粉丝， <a href="${basePath}/friends/fans.shtml" class="blues">查看粉丝</a></li>
<li style="display:none">1条新通知， <a href="#" class="blues">查看通知</a></li>
</ul>
</div>
<div class="prompt_message_r"><a id="closeMessageQueueBtn" href="javascript:void(0);"></a></div>
</div>
</div>
</div>


<div id="messageBox" class="layer_list" style="position: relative; z-index:1;display:none">
<div style=" position:absolute; top:39px; left:744px; *top:-1px; *left:196px; _left:194px;">
<div class="layer_list_t"><img src="${basePath}/images/layer_list_t.gif" width="131" height="1" /></div>
<div class="layer_list_c">
<ul>
<li><a href="${basePath}/messages/messagelist.shtml"><span>我的私信</span></a></li>
<li><a href="${basePath}/messages/"><span>关注信息</span></a></li>
</ul>
</div>
</div>
</div>


<div id="settingsBox" class="layer_list" style="position: relative; z-index:1;display:none">
<div style=" position:absolute; top:39px; left:796px; *top:-1px; *left:248px; _left:246px;">
<div class="layer_list_t"><img src="${basePath}/images/layer_list_t.gif" width="131" height="1" /></div>
<div class="layer_list_c">
<ul>
<li><a href="${basePath}/profile/photo.shtml"><span>头像设置</span></a></li>
<li><a href="${basePath}/setting/"><span>账号设置</span></a></li>
<li><a href="${basePath}/logOut.shtml"><span>退出</span></a></li>
</ul>
</div>
</div>
</div>

<!--搜索下拉 S-->
<div style="position: relative; z-index:10;" >
<div style="position:absolute; top:95px;left: 744px; _left:130px; _top:49px; display:none;" id="_hSearch">
<div class="index_search_list">
<div class="box">
<div class="word"><a href="javascript:void(0);" class="hover mar_l" id="_sf">搜<span>“好友”</span>相关用户>></a></div>
<div class="word"><a href="javascript:void(0);" class="mar_l" id="_sp">搜<span>“职位”</span>相关用户>></a></div>
</div>
</div>
</div>
</div>
<!--搜索下拉 E-->
<div class="menu">
 <div class="job_search">
 <form name="_frmSearch" method="post">
 <span><input name="keyword" id="hkeyWord" type="text" class="block" autocomplete = "off"/></span>
 </form>
 <div class="fdj"><img src="${basePath}/images/job_searchfdj.gif" width="29" height="22" id="_imgS"/></div>
 </div>
 <ul>
    <li><a href="${job528Domain}">首　页</a></li>
    <li><a href="${basePath}/" <%if(menu==""){%>class="ahover"<%}%>>个人主页</a></li>
     <li><a href="${basePath}/profile/index.shtml">简历中心</a></li>
    <li><a href="${basePath}/friends/" <%if(menu=="friend"){%>class="ahover"<%}%>>人脉拓展</a></li>
    <li><a href="${basePath}/jobs/" <%if(menu=="job"){%>class="ahover"<%}%>>求　职</a></li>
 </ul>  
</div> 
</div>
<script type="text/javascript">
    //顶部导航
    $(function(){
    	$("#settingsBtn,#settingsBox").hover(
			function(){
				$("#settingsBtn").removeClass("hover").addClass("hover");
				$("#settingsBox").show();
			},
			function(){
				$("#settingsBtn").removeClass("hover");
				$("#settingsBox").hide();
			}
    	 );
   	 
    	$("#messageBtn,#messageBox").hover(
   			function(){
   				$("#messageBtn").removeClass("hover").addClass("hover");
   				$("#messageBox").show();
   			},
   			function(){
   				$("#messageBtn").removeClass("hover");
   				$("#messageBox").hide();
   			}
       	 );
    });
    </script>
