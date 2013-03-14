<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<title>个人资料-教育经历</title>
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${basePath}/js/jquery.js" />
		<script type="text/javascript" src="${basePath}/js/validator.js" />
        <%@include file="/common/taglib.jsp" %>
	</head>

	<body>
		<!--头部 S-->
		<%@include file="/common/header.jsp"%>
		<!--头部 E-->

		<script type="text/javascript">
var editEducation = function(action,id){
    var message = $("#_bsSubmitMsg");
    switch(action){
      case 0:
         $("#divEditEducation").show();
         break;
      case 1:
         $("#divEditEducation").show();
         var education = eval("[" + $("#ej"+id).val() + "]");
         initEdit(education[0]);
         break;
      case 2:
         window.location.href = "education.shtml?did=" + id;
         break;
      case 3:
         if($.trim($("#beginDate").val()) == "" || $.trim($("#endDate").val()) == "" ){
            message.html("请填写开始和结束时间");
            break;
         }
         if($.trim($("#schoolName").val()) == "" || $.trim($("#speciality").val()) == "" ){
            message.html("请填写学校信息");
            break;
         }
         if($("#degreeId ").val() == "-1"){
            message.html("请选择学历!");
            break;
         }
         var form = document.frmEducation;
         form.submit();
         break;
      case 4:
         cancel();
         $("#divEditEducation").hide();
         break;
    }
}

var initEdit = function(education){
    $("#id").val(education.id);
    $("#beginDate").val(education.beginDate);
    $("#endDate").val(education.endDate);
    $("#schoolName").val(education.schoolName);
    $("#speciality").val(education.speciality);
    $("#certificate").val(education.certificate);
    $("#degreeId").val(education.degreeId);
    $("#degreeName").val(education.degreeName);
}
var cancel = function(){
    $("#id").val("");
    $("#beginDate").val("");
    $("#endDate").val("");
    $("#schoolName").val("");
    $("#speciality").val("");
    $("#certificate").val("");
    $("#degreeId ").val("-1");
    $("#degreeName").val("");
}


</script>

<style type="text/css">
<!--
.edit {
	width: 36px;
	height: 16px;
	float: left;
	cursor: pointer;
	margin-left: 15px;
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
		<!--人脉 S-->
		<div class="index_content">
				<!---------------------------左边分目录 S------------------------------->
				<%@include file="/common/left.jsp"%>
				<!---------------------------左边分目录 E------------------------------->
                
				<!---------------------------右边内容块 S------------------------------->
					<div class="resume_profile_dw">
                    <div class="basic">
                                <div class="basic_l"><span>教育经历</span></div>
                                <div class="basic_r" style="display:none"><span>English</span></div>
                                </div>
								<table width="769" cellspacing="1" bgcolor="e9edf1">
									<tr>
										<td width="122"  align="center" bgcolor="#f3f7f9">
											教育时间
										</td>
										<td width="212"  align="center" bgcolor="#f3f7f9">
											学校名称
										</td>
										<td width="91"  align="center" bgcolor="#f3f7f9">
											专 业
										</td>
										<td width="124"  align="center" bgcolor="#f3f7f9">
											证书编号
										</td>
										<td width="53"  align="center" bgcolor="#f3f7f9">
											学历
										</td>
										<td width="88"  align="center" bgcolor="#f3f7f9">
											操作
										</td>
									</tr>
									<c:forEach items="${educations}" var="education">
										<tr>
											<td width="122"  align="center" bgcolor="#FFFFFF">
												${education.myEducation.beginDate}
												至${education.myEducation.endDate}
											</td>
											<td width="212"  align="center" bgcolor="#FFFFFF">
												${education.myEducation.schoolName}
											</td>
											<td width="91"  align="center" bgcolor="#FFFFFF">
												${education.myEducation.speciality}
											</td>
											<td width="124"  align="center" bgcolor="#FFFFFF">
												${education.myEducation.certificate}
											</td>
											<td width="53"  align="center" bgcolor="#FFFFFF">
												${education.myEducation.degreeName}
											</td>
											<td width="88"  align="center" bgcolor="#FFFFFF">
												<input type="hidden" id="ej${education.myEducation.id}"
													name="ej${education.myEducation.id}"
													value="${education.jsonString}" />
												<span class="edit"
													onclick="editEducation(1,${education.myEducation.id});"></span>
												<span class="del"
													onclick="editEducation(2,${education.myEducation.id});">
												</span>
											</td>
										</tr>
									</c:forEach>
								</table>
								<table width="750" style="margin-top: 10px;">
									<tr>
										<td>
											<input type="button" value="增加信息" class="resume_addInfo"
												onclick="editEducation(0,0);" />
												<span id="_bsSubmitMsg" style="color:red;margin-left: 5px;"></span>
										</td>
									</tr>
								</table>
								<form action="education.shtml" method="post" name="frmEducation"
									id="frmEducation">
									<div style="display: none;" id="divEditEducation">
										<table width="750" style="margin-top: 5px">
											<tr>
												<td width="600" rowspan="4">
													<table width="600" cellspacing="1" bgcolor="e9edf1">
														<tr>
															<td width="81" height="34" align="center"
																bgcolor="#f3f7f9">
																<input type="hidden" id="id" name="id" value="" />
																<span class="font_hilite">*</span>教育时间：
															</td>
															<td width="516" valign="middle" bgcolor="#FFFFFF">
																<span
																	style="margin-left: 5px; float: left; display: inline">
																	<input name="beginDate" type="text"
																		class="resume_profile_wbk" value="" size="7"
																		id="beginDate" maxlength="7"/>
																</span>
																<!-- <span
																	style="margin-left: 5px; float: left; display: inline; cursor: pointer">
																	<img src="${basePath}/images/date_book.gif" width="14"
																		height="16" />
																</span>-->
																<span
																	style="float: left; margin: 4px 0 0 5px; display: inline">至</span>
																<span
																	style="margin-left: 5px; float: left; display: inline;">
																	<input name="endDate" type="text"
																		class="resume_profile_wbk" value="至今" size="7"
																		id="endDate" />
																</span>
																<span id="msgTimeShow" style="float:left;margin:4px 0 0 5px;display:inline;">(格式：2011-09)</span>
															</td>
														</tr>
														<tr>
															<td width="81" height="34" align="center"
																bgcolor="#f3f7f9">
																<span class="font_hilite">*</span>学校名称：
															</td>
															<td valign="middle" bgcolor="#FFFFFF">
																<span
																	style="margin-left: 5px; float: left; display: inline;"><input
																		name="schoolName" type="text" size="26"
																		class="resume_profile_wbk" id="schoolName" maxlength="50"/> </span>
																<span id="msgTimeShow" style="float:left;margin:4px 0 0 5px;display:inline;">(格式：2011-09)</span>
															</td>
														</tr>
														<tr>
															<td width="81" height="34" align="center" valign="middle"
																bgcolor="#f3f7f9">
																<span class="font_hilite">*</span>专 业：
															</td>
															<td align="center" valign="middle" bgcolor="#FFFFFF">
																<span
																	style="margin:0 5px; float: left; display: inline;">
																	<input name="speciality" type="text"
																		class="resume_profile_wbk" size="26" id="speciality" maxlength="50"/>
																</span>
															</td>
														</tr>
														<tr>
															<td width="81" height="34" align="center" valign="middle"
																bgcolor="#f3f7f9">
																证书编号：
															</td>
															<td align="center" valign="middle" bgcolor="#FFFFFF">
																<span
																	style="margin: 0 5px; float: left; display: inline;">
																	<input name="certificate" type="text"
																		class="resume_profile_wbk" size="26" id="certificate" maxlength="50"/>
																</span>
															</td>
														</tr>
														<tr>
															<td width="81" height="34" align="center" valign="middle"
																bgcolor="#f3f7f9">
																<span class="font_hilite">*</span>学 历：
															</td>
															<td align="center" valign="middle" bgcolor="#FFFFFF">
																<span
																	style="margin:0 5px; float: left; display: inline;">
																	 <select name="degreeId" id="degreeId">

																		<option value="-1" selected="selected">
																			请选择学历
																		</option>
																		<option value="10">
																			初中
																		</option>
																		<option value="20">
																			高中
																		</option>
																		<option value="25">
																			中技
																		</option>
																		<option value="30">
																			中专
																		</option>
																		<option value="40">
																			大专
																		</option>
																		<option value="50">
																			本科
																		</option>
																		<option value="55">
																			MBA
																		</option>
																		<option value="60">
																			硕士
																		</option>
																		<option value="70">
																			博士
																		</option>
																		<option value="90">
																			不限
																		</option>
																	</select> </span>
															</td>
														</tr>
													</table>
												</td>
												<td width="123" height="22">&nbsp;
													
												</td>
											</tr>
											<tr>
												<td height="26" align="center" valign="middle">
													<input type="button" class="info_table_3_button_c"
														value="保 存" onclick="editEducation(3,0);" />
												</td>
											</tr>
											<tr>
												<td height="26" align="center" valign="middle">
													<input type="button" class="info_table_3_button_c"
														value="返 回" onclick="editEducation(4,0);" />
												</td>
											</tr>
											<tr>
												<td>&nbsp;
													
												</td>
											</tr>
										</table>
									</div>
								</form>

					</div>
					<div class="clear"></div>
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