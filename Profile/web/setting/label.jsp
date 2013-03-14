<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<title>标签设置</title>
		<%@ include file="/common/meta.jsp" %>
	    <link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css">
		<link href="${basePath}/css/index.css" rel="stylesheet" type="text/css">
        <link href="${basePath}/css/mysetting.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="${basePath}/js/validator.js"></script>
		<script type="text/javascript" src="${basePath}/js/label.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#labelName").focus(function(){
					var clazz = $("#labelSpan").attr("class");
					if("label_input_h"==clazz){
						$("#labelSpan").removeClass("label_input_h").addClass("label_input");
					}
				});

				$("#hotLabelContainer a").each(function(){
					$(this).hover(
						function(){
							$(this).addClass("label_hover");
						},
						function(){
							$(this).removeClass("label_hover");
						}
					);
				});
			});
		</script>
	</head>
	<body>
		<!--头部 S-->
		<%@include file="/common/header.jsp"%>
		<!--头部 E-->
		<!--内容块 S-->
<div class="index_content">
<%@include file="/common/left.jsp"%>
<!--内容块左 S-->
<div  class="set_rigbox">
<!--标签设置 S-->
    <div class="set">
      <div class="set_tle">
        <div class="set_tle_left">标签设置</div>
        <div class="set_tle_center"></div>
        <div class="set_tle_right"><a href="applications.html"><img src="${basePath}/images/set_tle_right.gif" width="10" height="31" /></a></div>
      </div>
      <div class="set_down">
      		<div class="label">
            	<span class="label_tit">个人标签：</span>
                <div class="label_detail">
                	<!-- 选的标签显示  S -->
                	<div class="label_num" id="labelContainer">        
                    	 <%@ include file="/common/label_iterator.jsp" %>                               
                	 </div>
                    <!-- 选的标签显示  E -->
                    <span id="labelTip" style="float: left;display: none; color:#ff0000;"><img src="../images/resume/icon_error.gif" />中英文、数字  10个字符内</span>
                    <span id="labelMore" style="float: left;display: none; color:#ff0000;"><img src="../images/resume/icon_error.gif" />最多可添加10个标签</span>
                 	<p class="add_label"><span id="labelSpan" class="label_input"><label><input name="labelName" maxlength="10" type="text" id="labelName" /></label></span><span class="label_but"><label><input name="button" type="button" onclick="Label.add();" value="添加标签" /></label> <span style="color:#666; margin-left:10px">(最多只能添加10个标签)</span></span></p>
                    <div class="label_num" id="hotLabelContainer">
						<%@ include file="/common/label_hot_iterator.jsp" %>     
                    </div>
                    <p class="label_change" onclick="Label.next();">换一换</p>
                </div>
            </div>
      </div>
    </div>
<!--标签设置 E-->
  </div>
<!--内容块左 E-->

</div>
<div class="clear"></div>
<!--内容块 E-->

		<!--版权 S-->
		<%@include file="/common/footer.jsp"%>
		
	</body>
</html>
