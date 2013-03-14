<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="w" uri="/weibo-tags"%>
<s:iterator value="list">
<s:if test="#request.cookieUserId==myMessageData.userId">
	<div class="myinput" id="pm_${myMessageData.id }">
		<div style="position: absolute;">
			<div
				style="position: relative; left: 487px; top: 20px; _left: -1px;">
				<img src="${basePath}/images/send_block_rights.gif" width="7"
					height="14" />
			</div>
		</div>
		<div class="left">
			<div class="top">
				<img src="${basePath}/images/send_block_tops.gif" width="488"
					height="6" />
			</div>
			<div class="cer">
				<div class="con">
					<p>
						<span>我：</span><span><w:text value="myMessageData.message" />
						</span>
					</p>
					<p>
						<span style="float: left">${myMessageData.createDate}</span><span
							style="float: right; color: #e6e6e6">
							<a href="javascript:void(0);" onclick="deleteMessage(${myMessageData.id});"	class="blues">删除</a> | 
							<a href="javascript:void(0);" onclick="goReply();" class="blues">回复</a> 
							</span>
					</p>
				</div>
			</div>
			<div class="dw">
				<img src="${basePath}/images/send_block_dw.gif" width="488"
					height="6" />
			</div>
		</div>
		<div class="right">
			<img src="${loginResume.imgHead}" width="50" height="50" />
		</div>
	</div>
</s:if>

<s:else>
	<div class="mysend" id="pm_${myMessageData.id }">
		<div class="right">
			<img src="${headImage}" width="50" height="50" />
		</div>
		<div style="position: absolute;">
			<div style="position: relative; left: 55px; top: 20px; _left: 5px;">
				<img src="${basePath}/images/send_block_left.gif" width="7"
					height="14" />
			</div>
		</div>
		<div class="left">
			<div class="top">
				<img src="${basePath}/images/send_block_top.gif" width="488"
					height="6" />
			</div>
			<div class="cer">
				<div class="con">
					<p>
						<span><a href="${basePath }/profile/user.shtml?uid=${myMessageData.userId}" class="blues">${userName}</a>： <w:text
								value="myMessageData.message" /> </span>
					</p>
					<p>
						<span style="float: left">${myMessageData.createDate}</span><span
							style="float: right; color: #e6e6e6">
							<a href="javascript:void(0);" onclick="deleteMessage(${myMessageData.id});"	class="blues">删除</a> | 
							<a href="javascript:void(0);" onclick="goReply();" class="blues">回复</a> 
							</span>
					</p>
				</div>
			</div>
			<div class="dw">
				<img src="${basePath}/images/send_block_dws.gif" width="488"
					height="6" />
			</div>
		</div>
	</div>
	<!--我收到的私信 E-->
</s:else>
</s:iterator>
