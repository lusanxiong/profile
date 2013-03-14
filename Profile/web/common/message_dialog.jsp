<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<div class="forward" id="_message_dialog" style="display: none;">
<div class="forward_up"></div>
<div class="forward_cr">
<div class="forwardcon">
<div class="forward_tle">
<h1>发私信</h1>
<a class="close" href="javascript:void(0);" onclick="$.unblockUI();"></a>
</div>
<div class="forward_con">
<div class="fg"><span>发 给：</span><span id="_messsage_userName" class="fgk"></span></div>
<div class="forward_bxs">
<div id="_message_wordsTip" class="forward_txt">还可以输入<span class="share_tle_yw">140</span> 字</div>
</div>
<div class="nrk"><span class="nr">内 容：</span><span style="float:left"><textarea id="_message_text" class="forward_blocks" onkeyup="validateLength($.trim($(this).val()),$('#_message_wordsTip'));" onkeydown="ctrlEnter(event,$('#_message_ok'));"></textarea></span></div>
<div class="forward_bqs"><img onclick="showSmile($(this), $('#_message_text'));" flag="smileBtn" src="${basePath}/images/icon_01.gif" width="19" height="19" /></div>
<div class="buttons">
<div class="right">
<span class="forward_default" id="_message_ok" title="Ctrl+Enter快速提交">发 送</span>
</div>
</div>
</div>
</div>
</div>
<div class="forward_dw"></div>
</div>