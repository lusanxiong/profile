<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="w" uri="/weibo-tags" %>
<s:iterator value="commentList" status="s">
	<dl id="commentDL_${id}" forwardWeiboId="${forwardWeiboId}">
		<dt>
			<a href="${basePath}/profile/user.shtml?uid=${fromUserId}" class="blues"><img src="${headImage}" width="30" height="30" /></a>
		</dt>
		<dd style="font-size:12px;">
			<a href="${basePath}/profile/user.shtml?uid=${fromUserId}" class="blues">${userName}</a>：<w:text value="texts" /> (${formatDate})
		</dd>
		<dd>
			<span>
				<s:if test="#request.cookieUserId==fromUserId">
					<a href="javascript:void(0);" onclick="deleteComment(${id});"  class="blues">删除</a> |
				</s:if>
				<a href="javascript:void(0);" onclick="Comment.reply({userName:'${userName}',target:$('#comment_${weiboId}')});" class="blues">回复</a>
			</span>
		</dd>
	</dl>
</s:iterator>
<!-- showMore 标识是否显示更多按钮 -->
<s:if test="commentList.size>9 and ${showMore==1}">
	<a href="${basePath }/show/?wid=${weiboId}" class="blues" style="float: right">更多...</a>
</s:if>
