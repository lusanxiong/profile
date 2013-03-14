<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<div class="dialog" id="_group_dialog" style="position:relative; z-index:1;display: none;">
<div class="dialogcon" style="position: absolute; left:10px">
<div class="titlebar">
<h1>关注成功,请设置分组</h1>
<a class="close" title="关闭" href="javascript:void(0);" onclick="$.unblockUI();">关闭</a>
</div>
<div class="client">
<p></p>
<div class="g9" ><font id="_titleMsg" style="color: #0179E7;">取消保存，则默认为"其他"分组</font>
<div class="gzfyk">
<input type="hidden" value="5" id="_goupId" />
<ul id="relationList">
<li><input id="r1" name="_grp_frd" type="checkbox" value="1" class="gzfyks"/><label for="r1">同行</label></li>
<li><input id="r2" name="_grp_frd" type="checkbox" value="2" class="gzfyks"/><label for="r2">同事</label></li>
<li><input id="r3" name="_grp_frd" type="checkbox" value="3" class="gzfyks"/><label for="r3">同乡</label></li>
<li><input id="r4" name="_grp_frd" type="checkbox" value="4" class="gzfyks"/><label for="r4">同学</label></li>
<li><input id="r5" name="_grp_frd" type="checkbox" value="5" class="gzfyks" checked="checked"/><label for="r5">其他</label></li>
</ul>
</div>
</div>
</div>
<div class="buttons">
<span class="normal" onclick="$.unblockUI();">取消</span>
<span class="default" id="_group_dialog_ok">保存</span>
</div>
</div>
</div>
<script type="text/javascript">
	$(function(){
		 $("#relationList>li>input").click(function(){
			 $("#relationList input").attr("checked",false);
			 $("#_goupId").val($(this).val());
			 $(this).attr("checked",true);
		 });
		
	});
</script>