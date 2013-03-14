<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <title>个人资料</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
		<script language="javascript" type="text/javascript" src="${basePath}/js/jquery.js"></script>
		<script language="javascript" type="text/javascript" src="${basePath}/js/jquery.blockUI.js"></script>
        <script language="javascript" type="text/javascript" src="${basePath}/js/address.js"></script>
        <script language="javascript" type="text/javascript" src="${basePath}/js/addressdialog.js"></script>
        <script language="javascript" type="text/javascript" src="${basePath}/js/baseinfo.js"></script>
        <script language="javascript" type="text/javascript" src="${basePath}/js/My97DatePicker/WdatePicker.js"></script>
		<%@include file="/common/taglib.jsp"%>
	</head>

	<body>
		<!--头部 S-->
		<%@include file="/common/header.jsp"%>
		<!--头部 E-->

		<!--基本信息 S-->
			<div class="index_content">

				<!---------------------------左边分目录 S------------------------------->
				<%@include file="/common/left.jsp"%>
				<!---------------------------左边分目录 E------------------------------->

				<!---------------------------右边内容块 S------------------------------->
							<div class="resume_profile_dw">
                                <div class="basic">
                                <div class="basic_l"><span>基本信息</span></div>
                                <div class="basic_r" style="display:none"><span>English</span></div>
                                </div>
								<div class="info_table_3" id="divShowInfo">

									<table class="col_bg" cellpadding="0" cellspacing="1"
										width="100%">



										<tbody>
											<tr>

												<th width="93" height="20" align="center" valign="middle"
													nowrap="nowrap">
													姓 名：
												</th>

												<td width="228" height="20" align="left" valign="middle"
													nowrap="nowrap">
													${resume.myResume.perName}
												</td>

												<th width="116" height="20" align="center" valign="middle">
													性 别：
												</th>

												<td width="171" height="20" align="left" valign="middle"
													nowrap="nowrap">
													<c:if test="${resume.myResume.sex==1}">男</c:if>
													<c:if test="${resume.myResume.sex==2}">女</c:if>
												</td>

											</tr>

											<tr>

												<th height="20" align="center" valign="middle"
													nowrap="nowrap">
													出生日期：
												</th>

												<td height="20" align="left" valign="middle" nowrap="nowrap">
													${resume.birthDay}
												</td>

												<th height="20" align="center" valign="middle">
													民 族：
												</th>

												<td height="20" align="left" valign="middle">
													${resume.myResume.nationality}
												</td>



											</tr>

											<tr>

												<th height="20" align="center" valign="middle">
													身 高：
												</th>

												<td height="20" align="left" valign="middle">
													${resume.myResume.height}&nbsp;厘米
												</td>

												<th height="20" align="center" valign="middle">
													婚姻状况：
												</th>

												<td height="20" align="left" valign="middle">
                                                   ${resume.maritalStatus}

												</td>

											</tr>

											<tr>

												<th height="20" align="center" valign="middle"
													nowrap="nowrap">
													证件类型：
												</th>

												<td height="20" align="left" valign="middle" nowrap="nowrap">

													${resume.cardType}（证件号：${resume.myResume.idcardNum}）

												</td>

												<th height="20" align="center" valign="middle">
													最高学历：
												</th>

												<td height="20" align="left" valign="middle" nowrap="nowrap">
													${resume.myResume.degreeScript}
												</td>

											</tr>

											<tr>

												<th height="20" align="center" valign="middle">
													户 籍：
												</th>

												<td height="20" align="left" valign="middle" nowrap="nowrap">
													${resume.homeTown}
												</td>

												<th height="20" align="center" valign="middle"
													nowrap="nowrap">
													现工作地：
												</th>

												<td height="20" align="left" valign="middle" nowrap="nowrap">
													${resume.location}
												</td>
											</tr>
											<tr style="display: none;">
												<th height="20" align="center" valign="middle">
													电子邮箱：
												</th>
												<td height="20" align="left" valign="middle" nowrap="nowrap">
													<p>
														${resume.myResume.email}
													</p>
												</td>
												<th height="20" align="center" valign="middle">
													求职状态：
												</th>
												<td height="20" align="left" valign="middle" nowrap="nowrap">
													${resume.jobState}
												</td>
											</tr>
											<tr>
												<th height="20" align="center" valign="middle">
													手机号码：
												</th>
												<td height="20" align="left" valign="middle" nowrap="nowrap">
													${resume.myResume.mobileNum}
												</td>
												<th height="20" align="center" valign="middle">
													家庭电话：
												</th>
												<td height="20" align="left" valign="middle" nowrap="nowrap">
													${resume.myResume.relationPhone}
												</td>
											</tr>
											<tr>
												<th height="20" align="center" valign="middle">
													个人主页：
												</th>
												<td height="20" align="left" valign="middle">
													${resume.myResume.homepage}
												</td>
												<th height="20" align="center" valign="middle">
													QQ/MSN：
												</th>
												<td height="20" align="left" valign="middle">
													${resume.myResume.imnum}
												</td>
											</tr>
											<tr>
												<th height="20" align="left" valign="middle">
													通讯地址：
												</th>

												<td height="20" align="left" colspan="3" valign="middle">
													${resume.myResume.address}												</td>
											</tr>
											<tr>
												<th height="20" align="center" valign="middle">
													<p>
														自我评价：
													</p>
												</th>
												<td height="20" colspan="3" align="left" valign="middle">
													${resume.myResume.selfDescription}												</td>
											</tr>
											<tr>
												<th height="20" align="center" valign="middle"
													nowrap="nowrap">
													<p>
														关 键 词：
													</p>
												</th>
												<td height="20" colspan="3" align="left" valign="middle">
													${resume.myResume.selfKeyWord}
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								<form action="baseInfo.shtml" method="post" name="frmBaseInfo">
								<input type="hidden" name="resId" value="${resume.myResume.resId}"/>
								<div class="info_table_3"  id="divEditInfo" style="display:none;">
									<table class="col_bg" cellpadding="0" cellspacing="1"
										width="100%">
										<tbody>
											<tr>
												<th width="93" height="20" align="center" valign="middle"
													nowrap="nowrap">
													<span class="font_hilite">*</span>姓 名：
												</th>
												<td width="228" height="20" align="left" valign="middle"
													nowrap="nowrap">
													<input name="perName" id="perName" type="text" value="${resume.myResume.perName}"
														class="resume_profile_wbk" />
												</td>
												<th width="116" height="20" align="center" valign="middle">
													性 别：
												</th>
												<td width="171" height="20" align="left" valign="middle"
													nowrap="nowrap">
													<label>
													<c:if test="${resume.myResume.sex != 2}">
														<input name="sex" type="radio" value="1" checked="checked" />
														男
														<input type="radio" name="sex" value="2" />
														女
													</c:if>
													<c:if test="${resume.myResume.sex == 2}">
														<input name="sex" type="radio" value="1" />
														男
														<input type="radio" name="sex" value="2" checked="checked" />
														女
													</c:if>
													</label>
												</td>
											</tr>
											<tr>
												<th height="20" align="center" valign="middle"
													nowrap="nowrap">
													<span class="font_hilite">*</span>出生日期：
												</th>
												<td height="20" align="left" valign="middle" nowrap="nowrap">
													<input type="text" size="7" class="resume_profile_wbk" name="birthday" id="birthday" value="${resume.birthDay}" onFocus="WdatePicker({isShowClear:false,readOnly:true})"/>
													<span style="margin-left: 5px"><img
															src="${basePath}/images/date_book.gif" width="14" height="16" onclick="WdatePicker({el:'birthday'})"/> </span>
												</td>
												<th height="20" align="center" valign="middle">
													民 族：
												</th>
												<td height="20" align="left" valign="middle">
													<label>
													  <c:if test="${resume.myResume.nationality == '汉族' || resume.myResume.nationality == ''}"> 
														<input name="nationality" type="radio" value="汉族"
															checked="checked" />
														汉族
														<input name="nationality" id="cnNationality" type="radio"/>
														<input  name="cNationality" id="txtNationality" type="text" 
															size="3" class="resume_profile_wbk" />
													   </c:if>
													   
													   <c:if test="${resume.myResume.nationality != '汉族' && resume.myResume.nationality != ''}"> 
													   <input name="nationality" type="radio" value="汉族" />
														汉族
													   <input name="nationality" id="cnNationality" type="radio"  value="${resume.myResume.nationality}"  checked="checked" />
													   <input name="cNationality" id="txtNationality" type="text" 
															size="3" class="resume_profile_wbk" value="${resume.myResume.nationality}"/>
													   </c:if>
													</label>
													（如：回族）
												</td>
											</tr>
											<tr>
												<th height="20" align="center" valign="middle">
													<span class="font_hilite">*</span>身 高：
												</th>
												<td height="20" align="left" valign="middle">
													<label>
														<input name="height" type="text"
															class="resume_profile_wbk" id="height" value="${resume.myResume.height}"
															size="2" />
														厘米（如:170厘米）
													</label>
												</td>
												<th height="20" align="center" valign="middle">
													婚姻状况：
												</th>
												<td height="20" align="left" valign="middle">
													<select name="maritalStatus">
														<option  
                                                        <c:if test="${resume.myResume.maritalStatus ==0}">
                                                         selected="selected" 
                                                        </c:if>
                                                        value="0">
															未婚
														</option>
														<option
														  <c:if test="${resume.myResume.maritalStatus ==1}">
                                                        selected="selected" 
                                                        </c:if>
														value="1">
															已婚
														</option>
														<option
														  <c:if test="${resume.myResume.maritalStatus ==2}">
                                                        selected="selected" 
                                                        </c:if>
														value="2">
															离异
														</option>
														<option
														  <c:if test="${resume.myResume.maritalStatus ==3}">
                                                        selected="selected" 
                                                        </c:if>
														value="3">
															保密
														</option>
													</select>
												</td>
											</tr>
											<tr>
												<th height="20" align="center" valign="middle"
													nowrap="nowrap">
													<span class="font_hilite">*</span>证件类型：
												</th>
												<td height="20" align="left" valign="middle" nowrap="nowrap">
													<label>
														<select name="cardType" id="cardType">
															<option
															  <c:if test="${resume.myResume.cardType ==1}">
                                                        selected="selected" 
                                                        </c:if>
															value="1">
																身份证
															</option>
															<option
															 <c:if test="${resume.myResume.cardType ==2}">
                                                        selected="selected" 
                                                        </c:if>
															value="2">
																驾证
															</option>
															<option
															 <c:if test="${resume.myResume.cardType ==3}">
                                                        selected="selected" 
                                                        </c:if>
															value="3">
																军官证
															</option>
															<option
															  <c:if test="${resume.myResume.cardType ==4}">
                                                        selected="selected" 
                                                        </c:if>
															value="4">
																护照
															</option>
															<option
															  <c:if test="${resume.myResume.cardType ==5}">
                                                        selected="selected" 
                                                        </c:if>
															value="5">
																其他
															</option>
														</select>
													</label>
													编号:<label>
														<input type="text" name="idcardNum" id="idcardNum"
															class="resume_profile_wbk" value="${resume.myResume.idcardNum}"/>
													</label>
												</td>
												<th height="20" align="center" valign="middle">
													<span class="font_hilite">*</span>最高学历：
												</th>
												<td height="20" align="left" valign="middle" nowrap="nowrap">
													<select name="degreeId" id="degreeId">
														
														<option
														<c:if test="${resume.myResume.degreeId ==10}">
                                                        selected="selected" 
                                                        </c:if>
														value="10">
															初中
														</option>
														<option
														 <c:if test="${resume.myResume.degreeId ==20}">
                                                        selected="selected" 
                                                        </c:if>
														value="20">
															高中
														</option>
														<option
														  <c:if test="${resume.myResume.degreeId ==25}">
                                                        selected="selected" 
                                                        </c:if>
														value="25">
															中技
														</option>
														<option
														 <c:if test="${resume.myResume.degreeId ==30}">
                                                        selected="selected" 
                                                        </c:if>
														value="30">
															中专
														</option>
														<option
														 <c:if test="${resume.myResume.degreeId ==40}">
                                                        selected="selected" 
                                                        </c:if>
														value="40">
															大专
														</option>
														<option
														  <c:if test="${resume.myResume.degreeId ==50}">
                                                        selected="selected" 
                                                        </c:if>
														value="50">
															本科
														</option>
														<option
														  <c:if test="${resume.myResume.degreeId ==55}">
                                                        selected="selected" 
                                                        </c:if>
														value="55">
															MBA
														</option>
														<option
														
														 <c:if test="${resume.myResume.degreeId ==60}">
                                                        selected="selected" 
                                                        </c:if>
														value="60">
															硕士
														</option>
														<option 
														  <c:if test="${resume.myResume.degreeId ==70}">
                                                        selected="selected" 
                                                        </c:if>
														value="70">
															博士
														</option>
														<option
														 <c:if test="${resume.myResume.degreeId ==90}">
                                                        selected="selected" 
                                                        </c:if>
														value="90">
															不限
														</option>
													</select>
												</td>
											</tr>
											<tr>
												
												<th height="20" align="center" valign="middle"
													nowrap="nowrap">
													<span class="font_hilite">*</span>户 籍：
												</th>
												<td height="20" align="left" valign="middle" nowrap="nowrap">
												    <input type="hidden" name="hometown" id="hometown" value="${resume.myResume.hometown}"/>
													<input type="button" class="resume_profile_select"
														value="${resume.homeTown}" id="_hometown" />
												</td>
												<th height="20" align="center" valign="middle">
													<span class="font_hilite">*</span>现工作地：
												</th>
												<td height="20" align="left" valign="middle" nowrap="nowrap">
													<p>
													    <input type="hidden" name="location" id="location" value="${resume.myResume.location}"/>
														<input type="button" class="resume_profile_select"
															value="${resume.location}" id="_location"/>
													</p>
												</td>
											</tr>
											
											<tr>
												<th height="20" align="center" valign="middle">
													<span class="font_hilite">*</span>手机号码：
												</th>
												<td height="20" align="left" valign="middle" nowrap="nowrap">
													<input type="text" name="mobileNum" id="mobileNum"
														class="resume_profile_wbk" value="${resume.myResume.mobileNum}"/>
												</td>
												<th height="20" align="center" valign="middle">
													家庭电话：
												</th>
												<td height="20" align="left" valign="middle" nowrap="nowrap">
													<input type="text" name="relationPhone" id="relationPhone"
														class="resume_profile_wbk" value="${resume.myResume.relationPhone}"/>
												</td>
											</tr>
											<tr>
												<th height="20" align="center" valign="middle">
													个人主页：
												</th>
												<td height="20" align="left" valign="middle">
													<label>
														<input type="text" name="homepage" id="homepage"
															class="resume_profile_wbk" value="${resume.myResume.homepage}"/>
													</label>
												</td>
												<th height="20" align="center" valign="middle">
													QQ/MSN：
												</th>
												<td height="20" align="left" valign="middle">
													<input type="text" name="imnum" id="imnum"
														class="resume_profile_wbk" value="${resume.myResume.imnum}"/>
												</td>
											</tr>
											<tr>
												<th height="20" align="left" valign="middle">
													通讯地址：
												</th>
												<td height="20" align="left" valign="middle">
													<span> <input name="address" type="text" size="40"
															 class="resume_profile_wbk" value="${resume.myResume.address}"/> </span>
												</td>
												<th height="20" align="center" valign="middle">
													邮 编：
												</th>
												<td height="20" align="left" valign="middle">
													<input type="text" name="zipCode" id="zipCode"
														class="resume_profile_wbk" value="${resume.myResume.zipCode}"/>
												</td>
											</tr>
											
											<tr>
												<th height="20" align="center" valign="middle">
													<p>
														自我评价：
													</p>
												</th>
												<td colspan="3" align="left" valign="middle">
													<label>
														<textarea name="selfDescription" rows="4" class="resume_profile_textarea">${resume.myResume.selfDescription}
            </textarea>
													</label>
												</td>
											</tr>
											<tr>
												<th height="0" align="center" valign="middle"
													nowrap="nowrap">
													<p>
														关 键 词：
													</p>
												</th>
												<td height="0" colspan="3" align="left" valign="middle">
													<textarea name="selfKeyWord" rows="1" name="selfDescription" class="resume_profile_textarea">${resume.myResume.selfKeyWord}</textarea>
													<br />
													请输入代表你个人的关键字，限10个,用空格隔开。如行业、业绩、特长等，每词不超过6个汉字（12个英文字母）。
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								</form>
								
								<div class="info_table_3_button">

									<span><input type="button" class="info_table_3_button_l"
											value="修 改" id="btnSave"/> </span>

									<span><input type="button" class="info_table_3_button_r"
											value="取消" id="btnCancel"/> </span>
											<span id="_bsSubmitMsg" style="color:red;margin-left: 5px;"></span>

								</div>

					<!---------------------------右边内容块 E------------------------------->
            <%@include file="/common/address_dialog.jsp"%> 
             </div>
			</div><div class="clear"></div>

        
		</div>

		<!--人脉 E-->

		<!-- S地区 -->
		
		<!-- E地区 -->

		

		<div class="clear"></div>
		<!--版权 S-->
		<%@include file="/common/footer.jsp"%>
		<!--版权 E-->
	</body>
</html>