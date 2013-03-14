<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>528 个人中心</title>
    <%@include file="/common/taglib.jsp"%> 
	<%@include file="/common/meta.jsp"%>
	<script type="text/javascript" src="${basePath}/js/message.js"></script>
    <script type="text/javascript" src="${basePath}/js/my.jquery.js"></script>
    <script type="text/javascript" src="${basePath}/js/jquery.rotate.js"></script>
    <script type="text/javascript" src="${basePath}/js/validator.js"></script>
    <script type="text/javascript" src="${basePath}/js/topic.js"></script>
    <script type="text/javascript" src="${basePath}/js/weibo.js"></script>
    <script type="text/javascript" src="${basePath}/js/comment.js"></script>
    <script type="text/javascript" src="${basePath}/js/general.js"></script>
    <script type="text/javascript" src="${basePath}/js/weibo_home.js"></script>
    <script type="text/javascript" src="${basePath}/js/dialog.js"></script>
    <script type="text/javascript" src="${basePath}/js/recommend.js"></script>
    <script type="text/javascript" src="${basePath}/js/home.js"></script>
    
    <link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}/css/weibo_home.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}/css/css.css" rel="stylesheet" type="text/css" />
</head>
 
<body>
  <!--头部 S-->
<%@include file="/common/header.jsp"%> 
<!--头部 E-->

<div class="index_content">
<!--左 S-->
<%@include file="/common/left.jsp"%> 
<!--左 E-->

<div class="index_con_c">
<!--发布信息 S--> 
<form id="weiboForm" action="/publish.shtml" method="post">

<div class="share">
  <input type="hidden" id="imagePath" name="imagePath" value=""/>
  <div class="share_left"><img src="images/share_left.gif" width="9" height="162" /></div>
    <div class="share_center">
    <div class="share_tle">
    <div class="share_tle_img"><img src="images/share_tle.gif" width="221" height="21" /></div>
    <div class="share_tle_txt" id="wordsTip">还可以输入<span class="share_tle_yw">140</span> 字</div>
    </div>
    <p>
      <textarea id="texts" name="texts" cols="" rows="" class="share_box" onkeydown="ctrlEnter(event,$('#publishBtn'));"></textarea>
    </p>
    <div id="publishOK" style="position:relative;z-index:1000;display:none;">
    <div style="position:absolute; top:25px; left:204px; _top:-50px;"><img src="images/publishing.gif" width="125" height="20" /></div>
    </div>
    <div class="share_dw">
    <ul>
    <li><a href="javascript:void(0);" id="uploadBtn"><span class="share_dw_icon"><img src="images/icon_02.gif" width="19" height="19" /></span><span class="share_dw_word">图片</span></a></li>
    <li><a href="javascript:void(0);" id="smileBtn"><span class="share_dw_icon"><img src="images/icon_01.gif" width="19" height="19" /></span><span class="share_dw_word">表情</span></a></li>
    </ul>
    <div class="weiboIco"><em class="sina"><a class="${sinaStatus=='同步中'?'open':'noOpen'}" title="${sinaStatus}" href="${basePath}/setting/weiboSync.shtml"></a></em><em class="qq"><a class="${tencentStatus=='同步中'?'open':'noOpen'}" title="${tencentStatus}" href="${basePath}/setting/weiboSync.shtml"></a></em><span id="publishBtn"  title="Ctrl+Enter快速提交" class="share_dw_button"><a href="javascript:void(0);" ></a></span></div>
    </div>
  </div>
<div class="share_right"><img src="images/share_right.gif" width="9" height="162" /></div>
</div>
</form>

 <!-- 插入图片 S -->
 <form id="uploadForm" action="upload.shtml" method="post" enctype="multipart/form-data" target="uploadIframe">
	<div id="uploadDiv" style="position:relative;z-index:1; display:none">
	  <div class="insert_block_word" style="position:absolute; top:157px; left:27px; _left:-525px;">
      <div class="insert_block_word_up"></div>
      <div class="insert_block_word_cer">
	  <ul>
	  <li><p></p><input id="imageFile" type="file" name="image" style="outline: medium none; font-size:26px;  _font-size:19px;width:70px; height:34px;left:80px;top:38px; display:block; visibility: visible;background:none repeat scroll 0 0 transparent;border:medium none;cursor:pointer;opacity:0;position:absolute;*filter:alpha(opacity=0)" /></li>
	  <li><span>仅支持JPG、JPEG、GIF、PNG格式
	且文件不超过5M</span>
	</li>
	  </ul>
      </div>
      <div class="insert_block_word_dw"></div>
	  </div>
	</div>
</form>	
	
	<div id="showImageDiv" style="display:none;position:relative;z-index:1;">
	  <div id="showImageBox" class="insert_block_word" style="position:absolute; top:157px; left:27px; _left:-525px;">
      <div class="insert_block_word_up"></div>
      <div class="insert_block_word_cer_1">
	  <p class="insert_p">图片已上传成功！<a id="deleteImageBtn" href="javascript:void(0);" class="juhuang">删除</a></p>
	  <p class="insert_block_word_cer_btn"><img id="uploadImage" src="${basePath}/images/btn_ceshi.gif" /></p>
      </div>
      <div class="insert_block_word_dw"></div><div class="clear"></div>
	  </div>
      
      <div id="uploadingBox" style="display:none;position:relative;z-index:3;">
	  <div class="insert_block_word" style="position:absolute; top:157px; left:27px; _left:-525px;">
      <div class="insert_block_word_up"></div>
      <div class="insert_block_word_cer_1">
      <span class="insert_block_pics"><img src="${basePath}/images/loading.gif" width="16" height="16" /></span><span class="insert_block_words">图片上传中...</span>
      </div>
      <div class="insert_block_word_dw"></div>
      </div>
      </div>
	</div>
    <!-- 插入图片 E -->
<div class="clear"></div>

<div class="bestnews">
<div class="title">
<ul id="secondNav">
<li><a id="jobBtn" href="javascript:void(0);"><img src="${basePath}/images/index_recom_2.gif" width="102" height="34" /></a></li>
<li><a id="weiboBtn" type="attention" href="javascript:void(0);" ><img src="${basePath}/images/index_friends_1.gif" width="102" height="34" /></a></li>
<li><a id="myWeiboBtn" type="self" href="javascript:void(0);"><img src="${basePath}/images/index_me_1.gif" width="102" height="34" /></a></li>
</ul>
</div>
<div class="bestnews_box">
<div class="job_list" id="job_list_box">
<c:forEach items="${positionPager.list}" var="position" varStatus="con">
<dl>
<dt>
  <span class="job_post"><a href="${job528Domain}/resume/util/p${position.memSearchBean.posID}.html" class="blue" target="_blank">${position.memSearchBean.posName}</a></span>
  <span class="job_add">${position.location}</span>
  <span class="job_date">${position.postDate}</span>
  <span class="job_app"><a href="javascript:r_open(${position.memSearchBean.posID});" class="blues">申请</a></span>
</dt>
<dd>
  <span class="job_company">${position.memSearchBean.memName}</span>
  <span class="job_wage">${position.salary}</span>
  <span class="job_recom"><a href="javascript:recommend(${position.memSearchBean.posID},${position.memSearchBean.memID});" class="blues">推荐</a></span>
</dd>
</dl>

</c:forEach>
<c:if test="${positionPager.totalSize<=0}">
<div  class="information_cons" ><font id="noWeiboTip" style="color:#999;font-size:14px;">没有可以推荐的职位哦,赶快完善你的<a href="${basePath}/profile/index.shtml#jobIntention" class="blue">求职意向</a>吧~~</font></div>
</c:if>
</div>

<div id="weiboDiv" class="information_cons">
<%@ include file="/common/weibo_iterator.jsp" %>
</div>
<!-- 加载更多B -->
<div id="moreLoadDiv" style="display: none">
<div id="moreLoading" style="display: none">
 <img src="${basePath}/images/loading.gif" />正在加载，请稍候...
</div>
<div class="loadmore"><span id="moreWeiboBtn" pageIndex="2" userId="${loginResume.myResume.myUserId}" type="attention">更多</span></div>
</div>
<!-- 加载更多E -->

<div class="bestnews_down"><img src="${basePath}/images/bestnewsdw.gif" width="555" height="8" /></div>
</div>
</div>
</div>
<!--发布信息 E-->  

<div class="index_con_r">
<!--个人信息 S-->   
 <%@include file="/common/my_head.jsp"%>  
<!-- 可能认识的朋友 S -->
    <div class="per_pro">
        <div class="personal_top"><img src="${basePath}/images/personal_top.gif" width="205" height="10" /></div>
        <div class="personal_cer">
            <div class="per_pro_tles"></div>
            <div class="per_pro_friend" id="divRandomFriend">
                <img src="${basePath}/images/loading.gif" />
            </div>
         </div>
        <div class="personal_down"><img src="${basePath}/images/personal_dw.gif" width="205" height="10" /></div>
    </div>
<!-- 可能认识的朋友 E -->
<!-- 谁来看过我 S -->
    <div class="per_pro">
        <div class="personal_top"><img src="${basePath}/images/personal_top.gif" width="205" height="10" /></div>
        <div class="personal_cer">
            <div class="per_pro_tles_2"></div>
            <div class="per_pro_friend" id="userAccessHistoryInfoDiv">
              	 <img src="${basePath}/images/loading.gif" />
            </div>
         </div>
        <div class="personal_down" style="_margin-top:-5px;"><img src="${basePath}/images/personal_dw.gif" width="205" height="10" /></div>
    </div>
<!-- 谁来看过我 E -->
</div>

<div class="clear"></div>
</div>
<div class="clear"></div>
</div>
<%@include file="/common/forward_dialog.jsp"%>
<%@include file="/common/confirm_dialog.jsp"%>
<%@ include file="/common/smile.jsp" %>
<%@include file="/friends/loadfriends.jsp"%>
<iframe id="uploadIframe" name="uploadIframe" width="0" height="0" ></iframe>
<div class="clear"></div>
<%@include file="/common/footer.jsp"%> 

</body>
</html>
