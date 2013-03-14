<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>上传照片</title>
<%@include file="/common/taglib.jsp"%> 
<%@include file="/common/meta.jsp"%>
<script type="text/javascript" src="${basePath}/js/jquery.Jcrop.min.js"></script>
<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css">
<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css">
<link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${basePath}/css/jquery.Jcrop.css" type="text/css" />
<script language="Javascript">
jQuery(document).ready(function(){
	var width = ${width};
	var height = ${height};
	var temp = Math.min(Math.min(width,height),190);
	jQuery('#cropbox').Jcrop({
		aspectRatio:1,
		${(width>height?height:width)>80?'minSize:[80,80],':''}
		setSelect:[0,0,temp,temp], //初始化选中区域 
		onChange: showCoords,
		onSelect: showCoords,
		onRelease: hidePreview
	});

	$("#submitBtn").click(function(){
		$("#cutForm").submit();
	});
	
	$preview = $("#preview");

	function showCoords(c) {
		jQuery('#x').val(c.x);
		jQuery('#y').val(c.y);
		jQuery('#x2').val(c.x2);
		jQuery('#y2').val(c.y2);
		jQuery('#w').val(c.w);
		jQuery('#h').val(c.h);

		if (parseInt(c.w) > 0) {
	      var rx = 80 / c.w;
	      var ry = 80 / c.h;

	      $preview.css({
	        width: Math.round(rx * width) + 'px',
	        height: Math.round(ry * height) + 'px',
	        marginLeft: '-' + Math.round(rx * c.x) + 'px',
	        marginTop: '-' + Math.round(ry * c.y) + 'px'
	      }).show();
	    }	
	}

	function hidePreview(){
		$preview.stop().fadeOut('fast');
	}
	
});




</script>
		
</head>

<body>
<form method="post" id="cutForm" action="${basePath }/profile/cut.shtml">
<input type="hidden" size="4" id="srcpath" name="srcpath" value="${srcpath}" />
<input type="hidden" size="4" id="x" name="x" value="0"/>
<input type="hidden" size="4" id="y" name="y" value="0"/>
<input type="hidden" size="4" id="x2" name="x2" value="0" />
<input type="hidden" size="4" id="y2" name="y2" value="0"/>
<input type="hidden" size="4" id="w" name="w" value="0" />
<input type="hidden" size="4" id="h" name="h" value="0"/>
</form>
<!--头部 S-->
<%@include file="/common/header.jsp"%>
<!--头部 E-->
<!--求职 S-->
<div class="index_content">
<%@include file="/common/left.jsp"%>
  <div class="photo_con">
  <div class="photo_con_tle">调整虚线框截取满意的头像。<span><a href="${basePath }/profile/photo.shtml" class="blue">重新上传</a></span></div>
   <div class="photo_l"><span><img id="cropbox" src="${basePath}${srcpath}"/></span></div>
   <div class="photo_r">
   <p class="photo_prof" style="width:80px;height:80px;overflow:hidden;"><img id="preview" src="${basePath}${srcpath}"/></p>
   <p class="photo_btn"><img id="submitBtn" src="${basePath}/images/thoto_save.gif" width="64" height="26" /></p>
   </div>
   <div class="clear"></div>
</div>
</div>
<!--求职 E-->
<div class="clear"></div>
<!--版权 S-->
<%@include file="/common/footer.jsp"%>
<!--版权 E-->
</body>
</html>