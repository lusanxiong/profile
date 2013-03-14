<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="w" uri="/weibo-tags" %>
<s:iterator value="weiboList">
<dl id="weiboDL_${weibo.id}" onmouseout="$('#delBtn_${weibo.id}').hide();" onmouseover="$('#delBtn_${weibo.id}').show();">
    <dt class="pub_img"><a href="${basePath}/profile/user.shtml?uid=${weibo.userId}">
    <s:if test="weibo.headImage == null">
    	<img src="${basePath}/images/people.gif" width="50" height="50" class="img_1" />
    </s:if>
    <s:elseif test="weibo.headImage.indexOf('http://') > -1">
    	<img src="${weibo.headImage}" width="50" height="50" class="img_1" />
    </s:elseif>
    <s:elseif test="weibo.headImage.indexOf('http://') == -1">
    	<img src="${basePath}${weibo.headImage}" width="50" height="50" class="img_1" />
    </s:elseif>
    </a></dt>
    <dd class="pub_cons"><span><a href="${basePath}/profile/user.shtml?uid=${weibo.userId}" class="bl">${weibo.userName}</a></span>：<span id="texts_${weibo.id}"><w:text value="weibo.texts" /></span>
	<!-- 内容图片 S -->
	<s:if test="null!=weibo.imagePath && ''!=weibo.imagePath">
	    <div class="pub_addimgs">
	  		<p class="pub_img"><img class="zoomSmall" onclick="zoomImage($(this),1);" src="${basePath}${weibo.imagePath}"/></p>
	    </div>
    	<div class="img_larges" style="display:none">
	   		<div class="img_turns">
	            <span><a target="_blank" href="about:blank" class="it_1">查看原图</a></span>
	            <span><a href="javascript:void(0);" onclick="$('#wb_img_${weibo.id}').rotateLeft();" class="it_2">左旋</a></span>
	            <span><a href="javascript:void(0);" onclick="$('#wb_img_${weibo.id}').rotateRight();" class="it_3">右旋</a></span>
	            <span><a href="javascript:void(0);" onclick="$('#wb_img_${weibo.id}').click();" class="it_4">关闭</a></span>
	    	</div>
			<img id="wb_img_${weibo.id}" onclick="zoomImage($(this),2);" class="zoomBig" src="about:blank" />
		</div>
	</s:if>
	<!-- 内容图片 E -->

<!-- 转发信息 S -->
<s:if test="null != weibo.sourceId && weibo.sourceId>0">
	<div class="quotes_box">
		<div class="comment_box_tle" style=" position: relative; top:1px">
        <span class="comment_block_closes"><img src="${basePath}/images/xiaosanjiaos.gif" width="17" height="9" /></span></div>
    	<div class="quotes">
   		<ul class="zhuanfas">
   		<li class="comment_details">
   			<s:if test="null != forwardWeibo">
	   			<span class="quotes_word"><a href="${basePath}/profile/user.shtml?uid=${forwardWeibo.userId}" class="blues">${forwardWeibo.userName}</a>：<span id="ftexts_${forwardWeibo.id}"><w:text value="forwardWeibo.texts" /></span></span>
	   			<!-- 内容图片 S -->
				<s:if test="null!=forwardWeibo.imagePath && ''!=forwardWeibo.imagePath">
				    <div class="pub_addimg">
				  		<p class="pub_img"><img class="zoomSmall" onclick="zoomImage($(this),1);" src="${basePath}${forwardWeibo.imagePath}"/></p>
				    </div>
			    	<div class="img_large" style="display:none">
				   		<div class="img_turn">
				            <span><a target="_blank" href="about:blank" class="it_1">查看原图</a></span>
				            <span><a href="javascript:void(0);" onclick="$('#fwb_img_${forwardWeibo.id}').rotateLeft();" class="it_2">左旋</a></span>
				            <span><a href="javascript:void(0);" onclick="$('#fwb_img_${forwardWeibo.id}').rotateRight();" class="it_3">右旋</a></span>
				            <span><a href="javascript:void(0);" onclick="$('#fwb_img_${forwardWeibo.id}').click();" class="it_4">关闭</a></span>
				    	</div>
						<img id="fwb_img_${forwardWeibo.id}" onclick="zoomImage($(this),2);" class="zoomBig" src="about:blank" />
					</div>
				</s:if>
				<!-- 内容图片 E -->
	    		<p class="operate"><span class="pub_caozuo">
	    		<a href="${basePath}/show/?wid=${forwardWeibo.id}" class="blues">原文转发<s:if test="forwardWeibo.forwardNumber>0">(${forwardWeibo.forwardNumber})</s:if></a>|
	    		<a href="${basePath}/show/?wid=${forwardWeibo.id}" class="blues">原文评论<s:if test="forwardWeibo.commentNumber>0">(${forwardWeibo.commentNumber})</s:if></a>
	    		</span></p>
   			</s:if>
   			<s:else>
				<span style="color:#ccc;font-size:12px;">该条动态已被原作者删除<br />&nbsp;</span>
			</s:else>
   		</li>
    	</ul>
		</div>
	</div>
</s:if>
<!-- 转发信息 E -->

<!-- 操作 S -->
	<p class="operate">
		<span class="pub_time"><a href="${basePath }/show/?wid=${weibo.id}">${weibo.formatDate}</a></span>
		<span class="pubb_caozuo">
		<s:if test="#request.cookieUserId==weibo.userId">
			<span id="delBtn_${weibo.id}" style="display: none"><a onclick="deleteWeibo(${weibo.id});" href="javascript:void(0);" class="blues" >删除</a> |</span> 
		</s:if>
		<a href="javascript:void(0);" class="blues" onclick="
		<s:if test="null == forwardWeibo">
		forwardWeibo({userName:'${weibo.userName}',contentTarget:$('#texts_${weibo.id }'),sourceId:'${weibo.id}'});
		</s:if>
		<s:else>
		forwardWeibo({userName:'${weibo.userName}',fuserName:'${forwardWeibo.userName}',texts:'${weibo.texts}',contentTarget:$('#ftexts_${forwardWeibo.id }'),forwardId:'${weibo.id}',sourceId:'${forwardWeibo.id}'});
		</s:else>
		" >转发<s:if test="weibo.forwardNumber>0">(${weibo.forwardNumber})</s:if></a> | 
		<a href="javascript:void(0);" onclick="commentList({weiboId:'${weibo.id}'});" class="blues" >评论<s:if test="weibo.commentNumber>0">(${weibo.commentNumber})</s:if></a>
		</span>
	</p>
<!-- 操作  E -->

<!-- 评论 S -->
    <div id="commentBox_${weibo.id}" class="comments" style="display:none">
       
   		<div class="comment_box_tle" style=" position:relative; top:1px;">
        <span class="comment_block_close" ><img src="${basePath}/images/xiaosanjiao.gif" width="17" height="9" /></span></div>
    <div class="comment_box">
    	<div class="comment_block">
         <div class="comment_box_up">
    		<div class="comment_con">
      <form id="form1" name="form1" method="post" action="">
        <label>
          <textarea id="comment_${weibo.id}" onkeydown="ctrlEnter(event,$('#commentBtn_${weibo.id}'));" name="textarea2" cols="45" rows="5" class="comment_cons" id="textarea"></textarea>
        </label>
      </form>
    		</div>
	<div class="comment_word">
		<div class="comment_word_l"><img onclick="showSmile($(this),$('#comment_${weibo.id}'));" src="${basePath}/images/icon_01.gif" flag="smileBtn"/></div>
			<div class="comment_word_c">
				<div class="comment_word_cs">
					<div class="comment_word_cs_k">
  					<input type="checkbox" id="forwardBox_${weibo.id}" class="comment_word_cs_ks"/>
					</div>
					<div class="comment_word_cs_w"><label for="forwardBox_${weibo.id}">同时转发到我的动态</label></div>
				</div>
			</div>
		<div class="comment_word_r">
			<input id="commentBtn_${weibo.id}" onclick="publishComment({weiboId:'${weibo.id}',toUserId:${weibo.userId}});" type="button" class="comment_word_rs" value="评论"/>
		</div>
</div>
            
          <div id="commentList_${weibo.id}" class="comment_box_dw">
		 </div>
		</div>
     </div>
	</div>	
</div>
<div class="clear"></div>
</dd>
</dl>
</s:iterator>