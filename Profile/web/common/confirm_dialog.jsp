<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<div id="_confirm_dialog" class="dialog" style="display:none;">
<div class="dialogcon" style=" position:relative; left:10px">
<div class="titlebar">
<h1 id="_confirm_dialog_title">删除动态</h1>
<a class="close" onclick="$.unblockUI();" title="关闭" href="javascript:void(0);">关闭</a>
</div>
<div class="client">
<div class="g9" id="_confirm_dialog_content">
<span class="b large">确认删除该动态吗?</span>
<br />
<span>若删除,该条动态的评论和回复将同时被删除。</span>
</div>
</div>
<div class="buttons">
<span class="normal" onclick="$.unblockUI();">取 消</span>
<span class="default" id="_confirm_dialog_ok">确 定</span>
</div>
</div>
</div>