<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<title>个人资料</title>
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css">
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css">
		<link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${basePath}/js/jquery.js"></script>
		<script type="text/javascript" src="${basePath}/js/jquery.blockUI.js"></script>
		<script type="text/javascript" src="${basePath}/js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="${basePath}/js/address.js"></script>
        <script type="text/javascript" src="${basePath}/js/addressdialog.js"></script> 
        <script type="text/javascript" src="${basePath}/js/calling.js"></script>
        <script type="text/javascript" src="${basePath}/js/callingdialog.js"></script>
		<script type="text/javascript" src="${basePath}/js/intentions.js"></script>
		<%@include file="/common/taglib.jsp"%>
	</head>

	<body>
		<!--头部 S-->
		<%@include file="/common/header.jsp"%>
		<!--头部 E-->


		<!--人脉 S-->
		<div class="index_content">
				<!---------------------------左边分目录 S------------------------------->
				<%@include file="/common/left.jsp"%>
				<!---------------------------左边分目录 E------------------------------->
				<!---------------------------右边内容块 S------------------------------->
							<div class="resume_profile_dw">
                            <div class="basic">
                                <div class="basic_l"><span>求职意向</span></div>
                                <div class="basic_r" style="display:none"><span>English</span></div>
                                </div>
								<table width="750" id="tbInfo">
									<tr>
										<td width="750" rowspan="4">
											<table width="600" cellspacing="1" bgcolor="e9edf1">
												<tr>
													<td width="81" height="34" align="center" bgcolor="#f3f7f9">
														发展方向：
													</td>
													<td width="516" align="left" valign="middle" bgcolor="#FFFFFF" style="padding:5px;">
														&nbsp;${intention.myResume.careerDirection}
													</td>
												</tr>
												<tr>
													<td width="81" height="34" align="center" bgcolor="#f3f7f9">
														岗位类别：
													</td>
													<td valign="middle" align="left"  bgcolor="#FFFFFF">
														&nbsp;${intention.calling1} ${intention.calling2} ${intention.calling3}
													</td>
												</tr>
												<tr>
													<td width="81" height="34" align="center" valign="middle"
														bgcolor="#f3f7f9">
														希望职位：
													</td>
													<td align="left" valign="middle" bgcolor="#FFFFFF">
														<span
															style="width: 215px; margin:10px 5px 0 5px; float: left; display: inline;">${intention.post}</span>
														<span
															style="float: left; text-align:center; background-color: #f3f7f9; border-left: 1px solid #e9edf1; border-right: 1px solid #e9edf1; height: 34px; line-height: 34px; width: 81px;">工作地点:</span>
														<span
															style="margin: 10px 5px 0 5px; float: left; display: inline;">
															${intention.jobLocation1} ${intention.jobLocation2} ${intention.jobLocation3}</span>
													</td>
												</tr>
												<tr>
													<td width="81" height="34" align="center" valign="middle"
														bgcolor="#f3f7f9">
														工资待遇：
													</td>
													<td align="left" valign="middle" bgcolor="#FFFFFF">
														<span
															style="width: 215px; margin: 8px 5px 0 5px; float: left; display: inline;">${intention.salary} 
															<c:if test="${intention.myResume.houseNeeded == true}">
															要求提供住房
															</c:if></span>
														<span
															style="float: left; text-align:center; background-color: #f3f7f9; border-left: 1px solid #e9edf1; border-right: 1px solid #e9edf1; height: 34px; line-height: 34px; width: 81px;">到岗时间:</span>
														<span
															style="margin: 8px 5px 0 5px; float: left; display: inline;">${intention.toPost} 
															
															</span>
													</td>
												</tr>
												<tr>
													<td width="81" height="34" align="center" valign="middle"
														bgcolor="#f3f7f9">
														其他要求：
													</td>
													<td align="left" valign="middle" bgcolor="#FFFFFF">
														<span
															style="width: 215px; margin:0 5px; float: left; display: inline;">${intention.myResume.otherRequirement}</span>
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
												value="修 改" id="btnEdit"/>
										</td>
									</tr>
									<tr>
										<td height="26" align="center" valign="middle">&nbsp;
											
										</td>
									</tr>
									<tr>
										<td>&nbsp;
											
										</td>
									</tr>
								</table>
                               <form action="intentions.shtml" method="post" name="frmSave">
								<table width="750" style="display:none; float:left" id="tbEdit">
									<tr>
										<td width="600" rowspan="4">
											<table width="600">
												<tr>
													<td>
														<table width="600" cellspacing="1" bgcolor="e9edf1">
															<tr>
																<td width="83" height="28" align="center"
																	bgcolor="#f3f7f9">
																	<span class="font_hilite">*</span>岗位类别：
																</td>
																<td height="28" align="center" bgcolor="#FFFFFF">
																<input type="hidden" name="resId" value="${intention.myResume.resId}"/>
																<input type="hidden" id="jobFunction1" name="jobFunction1" value="${intention.myResume.jobFunction1}" jname="${intention.calling1}"/>
																<input type="hidden" id="jobFunction2" name="jobFunction2" value="${intention.myResume.jobFunction2}" jname="${intention.calling2}"/>
																<input type="hidden" id="jobFunction3" name="jobFunction3" value="${intention.myResume.jobFunction3}" jname="${intention.calling3}"/>
																	<span id="spCalling" style="background: url(${basePath}/images/resume_profile_select.gif); width:145px; height: 22px; line-height: 22px; text-align: left; padding-left: 6px; padding-right: 27px; overflow: hidden; float: left; margin-left: 5px;cursor: pointer">${intention.calling1} ${intention.calling2} ${intention.calling3}</span>
																</td>
															</tr>
															<tr>
																<td width="83" height="28" align="center"
																	bgcolor="#f3f7f9">
																	<span class="font_hilite">*</span>寻求职位：
																</td>
																<td height="28" bgcolor="#FFFFFF">
																
																	<span
																		style="float: left; margin-left: 5px; display: inline"><input
																			name="jobSeeking1" id="jobSeeking1" type="text" size="20"
																			class="resume_profile_wbk" value="${intention.myResume.jobSeeking1}"/>
																	</span>
																	<span
																		style="float: left; margin-left: 5px; display: inline"><input
																			name="jobSeeking2" id="jobSeeking2" type="text" size="20"
																			class="resume_profile_wbk" value="${intention.myResume.jobSeeking2}"/>
																	</span>
																	<span
																		style="float: left; margin-left: 5px; display: inline"><input
																			name="jobSeeking3" id="jobSeeking3" type="text" size="20"
																			class="resume_profile_wbk" value="${intention.myResume.jobSeeking3}"/>
																	</span>
																</td>
															</tr>
															<tr>
																<td width="83" height="29" align="center"
																	bgcolor="#f3f7f9">
																	<span class="font_hilite">*</span>工作地点：
																</td>
																<td height="28" align="center" bgcolor="#FFFFFF">
																<input type="hidden" id="jobLocation1" name="jobLocation1" value="${intention.myResume.jobLocation1}" lname="${intention.jobLocation1}"/>
																<input type="hidden" id="jobLocation2" name="jobLocation2" value="${intention.myResume.jobLocation2}" lname="${intention.jobLocation2}"/>
																<input type="hidden" id="jobLocation3" name="jobLocation3" value="${intention.myResume.jobLocation3}" lname="${intention.jobLocation3}"/>
																	<span
																		style="background: url(${basePath}/images/resume_profile_select.gif); width: 145px; height: 22px; line-height: 22px; text-align: left; padding-left: 6px; padding-right: 27px; overflow: hidden; float: left; margin-left: 5px; display: inline; cursor: pointer"  id="spLocation" >${intention.jobLocation1} ${intention.jobLocation2} ${intention.jobLocation3}</span>
																</td>
															</tr>
															<tr>
																<td width="83" height="28" align="center"
																	bgcolor="#f3f7f9">
																	<span class="font_hilite">*</span>工资待遇：
																</td>
																<td height="28" align="center" bgcolor="#FFFFFF">
																    <input type="hidden" id="salary" value="${intention.myResume.salary}"/>
																	<span
																		style="float: left; margin-left: 5px; display: inline">
																		<select name="salary" id="selSalary">
																			<option value="0">
																				面议
																			</option>
																			<option value="1">
																				1500以下
																			</option>
																			<option value="2">
																				2000-2999
																			</option>
																			<option value="3">
																				3000-4499
																			</option>
																			<option value="4">
																				4500-5999
																			</option>
																			<option value="5">
																				6000-7999
																			</option>
																			<option value="6">
																				8000-9999
																			</option>
																			<option value="7">
																				10000-14999
																			</option>
																			<option value="8">
																				15000-19999
																			</option>
																			<option value="9">
																				20000-29999
																			</option>
																			<option value="10">
																				30000-49999
																			</option>
																			<option value="11">
																				50000及以上
																			</option>
																		</select> </span>
																	<span
																		style="float: left; margin-left: 5px;">
																		<c:if test="${intention.myResume.houseNeeded == false}">
																		<input name="houseNeeded" type="checkbox"/> 
																		</c:if>
																		
																		<c:if test="${intention.myResume.houseNeeded == true}">
																		<input name="houseNeeded" type="checkbox" checked="checked"/> 
																		</c:if>
																		</span>
																	<span style="float: left; margin-left: 5px; line-height: 20px;">
																		要求提供住房 </span>
																</td>
															</tr>
															<tr>
																<td width="83" height="28" align="center" bgcolor="#f3f7f9">
																	<span class="font_hilite">*</span>到岗时间：
																</td>
																<td height="28" align="center" bgcolor="#FFFFFF">
																	<span style="float: left; margin-left: 5px;">
																	   <input name="checkinDate" type="radio"
																	    <c:if test="${postType == 0}">
																		checked="checked"
																		</c:if>
																		 value="随时到岗"/>
																	</span>
																	<span style="float: left; margin-left: 5px; line-height: 20px;">随时到岗</span>
																	<span style="float: left; margin-left: 5px;">
																	    <input name="checkinDate" id="checkinDateD"
																	     <c:if test="${postType == 1}">
																		checked="checked"
																		</c:if>
																	     type="radio"/>
																	</span>
																	<span style="float: left; margin-left: 5px;">
																	<input type="text" class="resume_profile_wbk" size="7" 
																	 <c:if test="${postType == 1}">
																		value="${intention.myResume.checkinDate}"
																		</c:if>
																	onFocus="WdatePicker({onpicked:pickedFunc});" id="dgDate" name="dgDate"/>
																	</span>
																	<span style="margin-left: 5px; float: left;cursor: pointer">
																		<img src="${basePath}/images/date_book.gif" width="14" height="16" onclick="WdatePicker({el:'dgDate',onpicked:pickedFunc})"/>
																	</span>
																	<span
																		style="margin-left: 5px; float: left; line-height: 20px;">以后</span>
																	<span style="float: left; margin-left: 5px;">
																	  <input name="checkinDate" id="checkinDateY" 
																	   <c:if test="${postType == 2}">
																		checked="checked"
																		</c:if>
																	  type="radio" value="半"/>
																	</span>
																	<span style="float: left; margin-left: 5px;">
																		<select name="checkinDateScale" id="checkinDateScale" onchange="checkinDateScaleChange(this.value);">
																		  <option value="半">半</option> 
																		  <option value="1">1</option> 
																		  <option value="2">2</option> 
																		  <option value="3">3</option> 
																		  <option value="4">4</option> 
																		  <option value="5">5</option> 
																		  <option value="6">6</option> 
																		  <option value="7">7</option> 
																		  <option value="8">8</option> 
																		  <option value="9">9</option> 
																		  <option value="10">10</option> 
																		  <option value="11">11</option> 
																		  <option value="12">12</option> 
																	   </select>
                                                                    </span>
																	<span
																		style="margin-left: 5px; float: left; line-height: 20px;">个月以内</span>
																		
																		<script>
																		function pickedFunc(){
																		    $dp.$('checkinDateD').value=$dp.cal.getDateStr();
																		
																		}
																		function checkinDateScaleChange(v){
																		    $("#checkinDateY").val(v);   
																		}
																	</script>
																</td>
															</tr>
															<tr>
																<td width="83" height="28" align="center"
																	bgcolor="#f3f7f9">
																	发展方向：
																</td>
																<td height="28" bgcolor="#FFFFFF">
																	<p
																		style="width: 490px; float: left; margin: 5px; display: inline">
																		<textarea cols="58" name="careerDirection" rows="5" class="resume_profile_tblocks">${intention.myResume.careerDirection}</textarea>
																	</p>
																	<p
																		style="width: 480px; line-height: 18px; float: left; margin-left: 13px; display: inline; text-align:left">
																		限500个中文字，输入您对自己的简短评价。请简明扼要的说明您最大的优势是什么，避免使 用一些空洞老套的话。
																	</p>
																</td>
															</tr>
															<tr>
																<td width="83" height="28" align="center"
																	bgcolor="#f3f7f9">
																	其他要求：
																</td>
																<td height="28" bgcolor="#FFFFFF">
																	<p
																		style="width: 490px; float: left; margin:0 0 0 5px; display: inline">
																		<textarea cols="58" name="otherRequirement" rows="5" class="resume_profile_tblocks">${intention.myResume.otherRequirement}</textarea>
																	</p>
																</td>
															</tr>
														</table>
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
												value="保 存" id="btnSave"/>
										</td>
									</tr>
									<tr>
										<td height="26" align="center" valign="middle">
											<input type="button" class="info_table_3_button_c"
												value="返 回" id="btnCancel"/>
										</td>
									</tr>
									<tr >
										<td valign="top"><span id="_bsSubmitMsg" style="color:red;margin-left: 5px;"></span>
										</td>
									</tr>
								</table>
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

        <!-- S地区 -->
        <%@include file="/common/address_dialog.jsp"%> 
        <%@include file="/common/calling_dialog.jsp"%> 
		
		<!-- E地区 -->
		
		

		<div class="clear"></div>
		<!--版权 S-->
		<%@include file="/common/footer.jsp"%>
		<!--版权 E-->
	</body>
</html>