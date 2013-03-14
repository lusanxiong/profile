<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<title>个人资料-培训信息</title>
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css">
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css">
		<link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${basePath}/js/jquery.js"></script>
		<%@include file="/common/taglib.jsp"%>
	</head>

	<body>
		<!--头部 S-->
		<%@include file="/common/header.jsp"%>
		<!--头部 E-->

		<style type="text/css">
<!--
.edit {
	width: 36px;
	height: 16px;
	float: left;
	cursor: pointer;
	margin-left:45px;
	display: inline;
	background: url(${basePath}/images/jobseeker_icon.png) no-repeat center
		-40px;
}

.del {
	width: 36px;
	height: 16px;
	float: left;
	cursor: pointer;
	background: url(${basePath}/images/jobseeker_icon.png) no-repeat center
		-70px;
}
-->
</style>


		<script type="text/javascript">
var editTraining = function(action,id){
   
    switch(action){
      case 0:
         $("#tbEditTraining").show();
         break;
      case 1:
         $("#tbEditTraining").show();
         var training = eval("[" + $("#tj"+id).val() + "]");
         initEdit(training[0]);
         break;
      case 2:
         window.location.href = "training.shtml?did=" + id;
         break;
      case 3:
         var message = $("#_bsSubmitMsg");
         if($.trim($("#beginDate").val()) == "" || $.trim($("#endDate").val()) == "" ){
            message.html("请填写开始和结束时间");
            return;
         }
         if($.trim($("#organization").val()) == ""){
            message.html("请填写培训机构");
            return;
         }
         if($.trim($("#course").val()) == ""){
            message.html("请选择培训项目!");
            return;
         }
         var form = document.frmTraining;
         form.submit();
         break;
      case 4:
         cancel();
         $("#tbEditTraining").hide();
         break;
    }
}

var initEdit = function(training){
    $("#id").val(training.id);
    $("#beginDate").val(training.beginDate);
    $("#endDate").val(training.endDate);
    $("#organization").val(training.organization);
    $("#course").val(training.course);
    $("#certificate").val(training.certificate);
  
}
var cancel = function(){
    $("#id").val("");
    $("#beginDate").val("");
    $("#endDate").val("");
    $("#organization").val("");
    $("#course").val("");
    $("#certificate").val("");
}
</script>
		<!--人脉 S-->
		

			<div class="index_content">
				<!---------------------------左边分目录 S------------------------------->
				<%@include file="/common/left.jsp"%>
				<!---------------------------左边分目录 E------------------------------->
				<!---------------------------右边内容块 S------------------------------->
							<div class="resume_profile_dw">
                            <div class="basic">
                                <div class="basic_l"><span>培训经历</span></div>
                                <div class="basic_r" style="display:none"><span>English</span></div>
                                </div>
								<table width="769" cellspacing="1" bgcolor="e9edf1">
									<tr>
										<td width="146" height="28" align="center" bgcolor="#f3f7f9">
											起始时间
										</td>
										<td width="146" height="28" align="center" bgcolor="#f3f7f9">
											培训机构
										</td>
										<td width="146" height="28" align="center" bgcolor="#f3f7f9">
											培训项目
										</td>
										<td width="146" height="28" align="center" bgcolor="#f3f7f9">
											获得证书
										</td>
										<td width="146" height="28" align="center" bgcolor="#f3f7f9">
											操作
										</td>
									</tr>
									<c:forEach items="${trainingList}" var="training">
										<tr>
											<td width="146" height="28" align="center" bgcolor="#FFFFFF">
												&nbsp;
												<input type="hidden" id="tj${training.myTraining.id}"
													name="tj${training.myTraining.id}"
													value="${training.jsonString}" />
												${training.myTraining.beginDate}至${training.myTraining.endDate}
											</td>
											<td width="146" height="28" align="center" bgcolor="#FFFFFF">
												&nbsp;${training.myTraining.organization}
											</td>
											<td width="145" height="28" align="center" bgcolor="#FFFFFF">
												&nbsp;${training.myTraining.course}
											</td>
											<td width="146" height="28" align="center" bgcolor="#FFFFFF">
												&nbsp;${training.myTraining.certificate}
											</td>
											<td width="146" height="28" align="center" bgcolor="#FFFFFF">
												&nbsp;
												<span class="edit"
													onclick="editTraining(1,${training.myTraining.id});"></span>
												<span class="del"
													onclick="editTraining(2,${training.myTraining.id});"></span>
											</td>
										</tr>
									</c:forEach>

								</table>
								<table width="735" style="margin-top: 10px;">
									<tr>
										<td>
											<input type="button"  value="增加培训" class="resume_addInfo" onclick="editTraining(0,0);" />
												<span id="_bsSubmitMsg" style="color:red;margin-left: 5px;"></span>
										</td>
									</tr>
								</table>
								<form action="training.shtml" method="post" name="frmTraining"
									id="frmTraining">
									<table width="735" style="margin-top: 5px; display:none;"
										id="tbEditTraining">
										<tr>
											<td width="600" rowspan="4">
												<table width="600" cellspacing="1" bgcolor="e9edf1">
													<tr>
														<td width="81" height="34" align="center"
															bgcolor="#f3f7f9">
															<span class="font_hilite">*</span>培训时间：
														</td>
														<td width="516" valign="middle" bgcolor="#FFFFFF">
															<span
																style="margin-left: 5px; float: left; display: inline">
																<input name="beginDate" id="beginDate" type="text"
																	class="resume_profile_wbk" value="" size="7"
																	maxlength="7" />
															</span>
															<span
																style="float: left; margin: 4px 0 0 5px; display: inline">至</span>
															<span
																style="margin-left: 5px; float: left; display: inline;">
																<input name="endDate" id="endDate" type="text"
																	class="resume_profile_wbk" value="" size="7"
																	maxlength="7" />
															</span>
                                                            <span id="msgTimeShow" style="float:left;margin:4px 0 0 5px;display:inline;">(格式：2011-09)</span>
														</td>
													</tr>
													<tr>
														<td width="81" height="34" align="center"
															bgcolor="#f3f7f9">
															<span class="font_hilite">*</span>培训机构：
														</td>
														<td valign="middle" bgcolor="#FFFFFF">
															<span
																style="margin-left: 5px; float: left; display: inline;"><input
																	name="organization" id="organization" type="text"
																	size="60" class="resume_profile_wbk" maxlength="60" />
															</span>
														</td>
													</tr>
													<tr>
														<td width="81" height="34" align="center" valign="middle"
															bgcolor="#f3f7f9">
															<span class="font_hilite">*</span>培训项目：
														</td>
														<td align="center" valign="middle" bgcolor="#FFFFFF">
															<span
																style="margin: 8px 5px 0 5px; float: left; display: inline;">
																<input name="course" id="course" type="text"
																	class="resume_profile_wbk" size="26" maxlength="26" />
															</span><span
																style="float: left; background-color: #f3f7f9; border-left: 1px solid #e9edf1; border-right: 1px solid #e9edf1; height: 34px; line-height: 34px; width: 81px; font-weight: bold">获得证书:</span><span
																style="margin: 8px 5px 0 5px; float: left; display: inline;">
																<input type="text" name="certificate" id="certificate"
																	class="resume_profile_wbk" size="26" maxlength="26" />
															</span>
														</td>
													</tr>
												</table>
											</td>
											<tr>
												<td width="123" height="22">&nbsp;
													
												</td>
											</tr>
											<tr>
												<td height="26" align="center" valign="middle">
												<input type="hidden" id="id" name="id" value=""/>
													<input type="button" class="info_table_3_button_c"
														value="保 存" onclick="editTraining(3,0);" />
												</td>
											</tr>
											<tr>
												<td height="26" align="center" valign="middle">
													<input type="button" class="info_table_3_button_c"
														value="返 回" onclick="editTraining(4,0);" />
												</td>
											</tr>
											<tr>
												<td>&nbsp;
													
												</td>
											</tr>
									</table>
								</form>
					</div>
					<!---------------------------右边内容块 E------------------------------->

				<!---------------------------右边内容块 E------------------------------->
			</div>
		</div>
		<div class="clear"></div>
		</div>
		<!--人脉 E-->

		<div class="clear"></div>
		<!--版权 S-->
		<%@include file="/common/footer.jsp"%>
		<!--版权 E-->
	</body>
</html>