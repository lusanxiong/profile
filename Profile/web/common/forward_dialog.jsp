<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<div class="forward" id="_forward_dialog" style="display: none;">
<div class="forward_up"></div>
<div class="forward_cr">
<div class="forwardcon">
<div class="forward_tle">
<h1>转发动态</h1>
<a class="close" href="javascript:void(0);" onclick="$.unblockUI();"></a>
</div>
<div class="forward_con">
<div class="forward_ilent"><div class="usename"><span style="font-weight: bold;font-size: 15px;color:#999" id="_forward_dialog_atName">@test</span>：<span id="_forward_dialog_content">快过年了，老妈每天都从外面拎东西回家，还不时吩咐老爸去超市，几乎闲置的冰箱又塞满了。接下来几天，老妈找一本，时不时在上面记着什么。快过年了，老妈每天都从外面拎东西回家，还不时吩咐老爸去超市，几乎闲置的冰箱又塞满了...</span></div></div>
<div class="forward_bx">
<div class="forward_bq"><img onclick="showSmile($(this), $('#_forward_dialog_texts'));" id="_forward_dialog_smile" flag="smileBtn" src="${basePath}/images/icon_01.gif" width="19" height="19" /></div>
<div id="_forward_dialog_wordsTip" class="forward_txt">还可以输入<span class="share_tle_yw">140</span> 字</div>
</div>
<p><textarea id="_forward_dialog_texts" class="forward_block" onkeyup="validateLength($.trim($(this).val()),$('#_forward_dialog_wordsTip'));" onkeydown="ctrlEnter(event,$('#_forward_dialog_ok'));"></textarea></p>
<div class="buttons">
<div class="left">
<ul>
<li><input id="_forward_dialog_check" type="checkbox" class="forward_fxk"/>
<label for="_forward_dialog_check">同时评论给 <span id="_forward_dialog_userName">他</span></label>
</li>
<li><input id="_forward_dialog_check2" type="checkbox" class="forward_fxk"/>
<label for="_forward_dialog_check2">同时评论给原文作者 <span id="_forward_dialog_fuserName">他</span></label>
</li>
</ul>

</div>
<div class="right">
<span class="forward_default" id="_forward_dialog_ok" title="Ctrl+Enter快速提交">转 发</span>
</div>
</div>
</div>
</div>
</div>
<div class="forward_dw"></div>
</div>