<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<span class="label_hover_3" myLabelId="${label.id}" title="删除" href="javascript:void(0);" >
<span class="label_focus">
	<a class="label_content_3" href="<c:url value='${basePath}/friends/search.shtml'><c:param name='tag' value='${label.labelName}'/></c:url>" target="_blank">${label.labelName}</a>
	<img onclick="Label.del(this);" labelId="${label.id}" class="label_img_3" src="../images/setting/ico_06.gif"/>
</span>
<em></em>
</span>
