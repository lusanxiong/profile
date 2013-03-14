<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
	<head>
		<title>上传照片</title>
		<%@include file="/common/taglib.jsp"%> 
		<%@include file="/common/meta.jsp"%>
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css">
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css">
		<link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${basePath}/js/message.js"></script>
		<script type="text/javascript" src="${basePath}/js/validator.js"></script>
		<script type="text/javascript" >
			$(function(){
				$("#imageFile").change(function(){
					var filePath = $(this).val();
					if(!(filePath && filePath.endWith(".jpg|.png|.jpeg"))){
						alert(Message.invalidFormat);
						return ;
					}
					$("#uploadForm").submit();
				});
			});
			
			function callback(msg) {
				var msg  = $.parseJSON(msg);
				if(msg.flag==0){
					alert(msg.src);
				}
				else{
					alert(msg.msg);
				}
			}
		</script>
	</head>

	<body>
		<!--头部 S-->
		<%@include file="/common/header.jsp"%>
		<!--头部 E-->

		<!--上传照片 S-->
		<div class="index_content">
           <%@include file="/common/left.jsp"%>
				<!-----------------------内容块 S-------------------------->
                <div class="basic" style=" float:right;">
                <div class="basic_l"><span>上传照片</span></div>
                </div>
				<div class="photo_con">
				  <div class="photo_con_downs_img"><a href="javascript:void(0);">
				  <c:if test="${fn:indexOf(loginResume.imgHead, 'http://') > -1}">
                        <img src="${loginResume.imgHead}" width="190" height="190" />
                        </c:if>
                         <c:if test="${fn:indexOf(loginResume.imgHead, 'http://') == -1}">
                        <img src="${basePath}/${loginResume.imgHead}" width="190" height="190" />
                        </c:if>
				  
				  </a></div>
						<div class="photo_con_downs">
							<div class="photo_con_downs_s">
								<div class="photo_con_downs_s_l">
									<div class="photo_con_downs_s_l_u">
										请点击<span>上传照片</span>按钮选择照片文件，然后开始上传
									</div>
                                    <div class="photo_con_downs_s_l_d">
									<form id="uploadForm" action="${basePath }/profile/upload.shtml" method="post" enctype="multipart/form-data">
									<input id="imageFile" type="file" name="image" style="outline: medium none; font-size:5px; *+font-size:18px; _font-size:13px; overflow:hidden; width:93px; height:26px;display:block; visibility: visible;background:none repeat scroll 0 0 transparent;cursor:pointer;opacity:0;position: relative;*filter:alpha(opacity=0);" />									
									</form>
                                    </div>
							  </div>
						  </div>

							<div class="photo_con_downs_x">
								<span>1.请使用脸部清晰、容易辨认的真实照片 <br /> 2.你选择的照片中头像应尽量供于中央以便于截取
									<br /> 3.支持jpg/png/jpeg格式的文件，大小不要超过2.5M </span>
							</div>
						</div>
						<div class="clear"></div>
		  </div>
				</div>
                </div>
			</div>
			<div class="clear"></div>
		</div>
		<!--求职 E-->
		<div class="clear"></div>
		<!--版权 S-->
		<%@include file="/common/footer.jsp"%>
		<!--版权 E-->
	</body>
</html>