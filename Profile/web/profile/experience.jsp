<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<title>个人资料</title>
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${basePath}/js/jquery.js"></script>
		<script type="text/javascript" src="${basePath}/js/validator.js"></script>
		<script type="text/javascript" src="${basePath}/js/jquery.blockUI.js"></script> 
        <script type="text/javascript" src="${basePath}/js/calling.js"></script>
        <script type="text/javascript" src="${basePath}/js/callingdialog.js"></script>
        <script type="text/javascript" src="${basePath}/js/experience_old.js"></script>
        
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
                                <div class="basic_l"><span>工作经验</span></div>
                                <div class="basic_r" style="display:none"><span>English</span></div>
                                </div>
							<div id="divInfo">
								<c:forEach items="${experiences}" var="experience"
									varStatus="con">

									<table width="769" style=" float:left">
										<tr>
											<td width="600" rowspan="4">
												<table width="600" style=" float:left">
													<c:if test="${con.index==0}">
														<tr>
															<td>
																
																
															<table width="600" height="32" style="border: 1px dashed #d8e8f5;">
															<tr>
																<td width="320">
																	<table border="0" cellspacing="0" cellpadding="0"
																		width="100%">
																		<tbody>
																			<tr>
																				<td width="208">
																					我有：
																					<input type="text"
																						class="resume_profile_wbks" id="workedYear" value="${loginResume.myResume.workedYear}"/>
																					年
																					<input  type="text"
																						class="resume_profile_wbks" id="workedMonth" value="${loginResume.myResume.workedMonth}"/>
																					月工作经验
																				</td>
																			</tr>
																		</tbody>
																	</table>
																</td>
																<td width="252">
																	曾在
																	<input type="text"
																		class="resume_profile_wbks" size="1" id="workedComNumber" value="${loginResume.myResume.workedComNumber}"/>
																	家企业工作
																</td>
																<td width="191">
																	<span id="btnEditWEInfo" style="background: url(${basePath}/images/jobseeker_icon.png) 0 -40px; float: left; width: 16px; height: 16px; display: block; cursor: pointer"></span>
																	<span id="_bsSubmitMsg1" style="color:red;margin-left: 5px;"></span>
																</td>
															</tr>
														</table>
																
															</td>
														</tr>
													</c:if>
													<tr>
														<td>
															<table width="600" cellspacing="1" bgcolor="e9edf1">
																<tr>
																	<td width="83" height="32" align="center"
																		bgcolor="#f3f7f9">
																		在职时间：
																	</td>
																	<td height="32" colspan="3" bgcolor="#FFFFFF">
																		<span
																			style="float: left; margin-left: 5px; ">${experience.myWorkExp.beginDate} — ${experience.myWorkExp.endDate}</span>
																	</td>
																</tr>
																<tr>
																	<td width="83" height="32" align="center"
																		bgcolor="#f3f7f9">
																		公司名称：
																	</td>
																	<td height="32" colspan="3" bgcolor="#FFFFFF">
																		<span
																			style="float: left; margin-left: 5px; ">${experience.myWorkExp.memName}</span>
																	</td>
																</tr>
																<tr>
																	<td width="83" height="32" align="center"
																		bgcolor="#f3f7f9">
																		公司性质：
																	</td>
																	<td width="162" colspan="3" height="32" align="center"
																		bgcolor="#FFFFFF">
																		<span
																			style="float: left; margin-left: 5px; ">${experience.companyType}</span>
																	</td>
                                                                    </tr>
                                                                    <tr>
																	<td width="69" height="32" align="center" bgcolor="#f3f7f9">
																		行业分类：
																	</td>
																	<td width="271" colspan="3" align="left" bgcolor="#FFFFFF">
																		<span
																			style="float: left; margin-left: 5px; ">${experience.calling}</span>
																	</td>
																</tr>
																<tr>
																	<td width="83" height="32" align="center"
																		bgcolor="#f3f7f9">
																		担任职务：
																	</td>
																	<td height="32" width="153" colspan="3" bgcolor="#FFFFFF" align="left">
																		<span style=" float:left;margin-left:5px; display:inline" id="spCalling${experience.myWorkExp.id}">${experience.post}</span>
																	</td>
																</tr>
																<tr>
																	<td width="83" height="32" align="center"
																		bgcolor="#f3f7f9">
																		工作描述：
																	</td>
																	<td height="32" align="left" colspan="3" bgcolor="#FFFFFF">
																		<span
																			style="float: left; margin-left: 5px; display:inline; line-height:18px ">${experience.myWorkExp.description}</span>
																	</td>
																</tr>
																<tr>
																	<td width="83" height="32" align="center"
																		bgcolor="#f3f7f9">
																		离职原因：
																	</td>
																	<td height="32" colspan="3" bgcolor="#FFFFFF" align="left">
																		<span style="float:left; margin-left:5px; display:inline">${experience.myWorkExp.leftReason}</span>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</td>
											<td width="123" height="22">
												&nbsp;
												<input type="hidden" id="ej${experience.myWorkExp.id}"
													value="${experience.jsonString}" />
											</td>
										</tr>
										<tr>
											<td height="21" align="center" valign="middle">
												<input type="button" class="info_table_3_button_c"
													value="删 除"   onclick="javascript:window.location.href='experience.shtml?did=${experience.myWorkExp.id}'"/>
											</td>
										</tr>
										<tr>
											<td height="21" align="center" valign="middle">
												<input type="button" class="info_table_3_button_c"
													value="修 改"  onclick="editWorkExp('${experience.myWorkExp.id}');"/>
											</td>
										</tr>
										<tr>
											<td>&nbsp;
												
											</td>
										</tr>
									</table>
									<table width="735" border="0" cellspacing="0" cellpadding="0" style="float:left">
										<tr>
											<td></td>
										</tr>
										<tr>
											<td style="border-bottom: 1px dashed #a9a9a9">&nbsp;
												
											</td>
										</tr>
										<tr>
											<td height="10px"></td>
										</tr>
									</table>

								</c:forEach>

                           </div>
                           <form action="experience.shtml" method="post" name="frmExperience">
						<table width="769" style="display:none; float:left" id="tbSave">
									<tr>
										<td width="600" rowspan="4">
											<table width="600">
												<tr>
													<td>
														<table width="600" cellspacing="1" bgcolor="e9edf1">
															<tr>
																<td width="83" height="32" align="center"
																	bgcolor="#f3f7f9">
																	<span class="font_hilite">*</span>在职时间：
																</td>
																<td height="32" colspan="3" bgcolor="#FFFFFF">
																	<span
																		style="margin-left: 5px; float: left; ">
																		<input name="beginDate" id="beginDate" type="text"
																			class="resume_profile_wbk"  onclick="WdatePicker({dateFmt:'yyyy-MM'});" size="7" /> </span>
																	
																	<span
																		style="float: left; margin: 4px 0 0 5px; ">—</span>
																	<span
																		style="margin-left: 5px; float: left; ;">
																		<input name="endDate" id="endDate" type="text"
																			class="resume_profile_wbk" onclick="WdatePicker({dateFmt:'yyyy-MM'});"
																			size="7" /> </span>
																	<span
																		style="float: left; margin: 4px 0 0 5px; ">(如:2011-12)</span>
																</td>
															</tr>
															<tr>
																<td width="83" height="32" align="center"
																	bgcolor="#f3f7f9">
																	<span class="font_hilite">*</span>公司名称：
																</td>
																<td height="32" colspan="3" bgcolor="#FFFFFF">
																	<span
																		style="float: left; margin-left: 5px; ">
																		<input name="memName" id="memName" type="text" size="40"
																			class="resume_profile_wbk" maxlength="50"/> </span>
																</td>
															</tr>
															<tr>
																<td width="83" height="29" align="center"
																	bgcolor="#f3f7f9">
																	<span class="font_hilite">*</span>公司性质：
																</td>
																<td width="153" colspan="3" height="29" align="center"
																	bgcolor="#FFFFFF">
																	<span
																		style="float: left; margin-left: 5px; ">
																		<select size="1" name="memType" id="memType">
																		
																			<option value="1">
																				外资
																			</option>
																			<option value="2">
																				合资
																			</option>
																			<option value="3">
																				国企
																			</option>
																			<option value="4">
																				民营公司
																			</option>
																			<option value="5">
																				其它性质
																			</option>


																		</select> </span>
																</td>
                                                                </tr>
                                                                <tr>
																<td width="129" height="32" align="center" bgcolor="#f3f7f9">
																	<span class="font_hilite">*</span><span>行业分类：</span>
																</td>
																<td width="220" colspan="3" align="left" bgcolor="#FFFFFF">
																	<span
																		style="float: left; margin-left: 5px; ">
																		<select size="1" name="memCalling" id="memCalling">
																			<option value="1000">计算机/IT/互联网/电子商务</option>
																			<option value="1100">高级管理</option>
																			<option value="1200">人力资源</option>
																			<option value="1300">销售类</option>
																			<option value="1400">客服及技术支持</option>
																			<option value="1600">财务/审计/税务</option>
																			<option value="1500">市场/营销</option>
																			<option value="1700">生产/营运</option>
																			<option value="1800">行政/后勤</option>
																			<option value="1900">通信技术开发及应用</option>
																			<option value="2000">银行</option>
																			<option value="2100">金融/证券/期货/投资</option>
																			<option value="2200">贸易/进出口</option>
																			<option value="2300">机械/模具/工程/能源</option>
																			<option value="2400">汽车</option>
																			<option value="2500">建筑/监理/施工/市政建设</option>
																			<option value="2600">房地产</option>
																			<option value="2700">物业管理</option>
																			<option value="2800">医疗</option>
																			<option value="2900">生物/制药/医疗器械</option>
																			<option value="3000">印刷/包装/造纸</option>
																			<option value="3100">酒店/旅游</option>
																			<option value="3200">餐饮/娱乐</option>
																			<option value="3300">化工</option>
																			<option value="3400">服装/纺织</option>
																			<option value="3500">教育</option>
																			<option value="3600">美容/美发/保健/体育</option>
																			<option value="3700">照明</option>
																			<option value="3800">矿产/地质勘查/冶金</option>
																			<option value="3900">造船</option>
																			<option value="4000">交通运输服务</option>
																			<option value="4100">物流/仓储</option>
																			<option value="4200">电力/电源</option>
																			<option value="4300">艺术/设计</option>
																			<option value="4400">百货/连锁/零售服务</option>
																			<option value="4500">律师/法务/合规</option>
																			<option value="4600">技工</option>
																			<option value="4700">采购</option>
																			<option value="4800">翻译</option>
																			<option value="4900">环保/节能</option>
																			<option value="5000">农业/养殖</option>
																			<option value="9900">其它</option>

																		</select> </span>
																</td>
															</tr>
															<tr>
																<td width="83" height="32" align="center"
																	bgcolor="#f3f7f9">
																	担任职务：
																</td>
																<td width="153" colspan="3" height="32" align="left"
																	bgcolor="#FFFFFF">
																	<input type="hidden" id="jobFunctionId" name="jobFunctionId" value=""/>
													
																	<span id="spCalling" style=" background:url(${basePath}/images/profile_sel.gif); width:93px; height:22px; line-height:22px; text-align:left; padding-left:6px; padding-right:27px; overflow:hidden; float:left; margin-left:5px;"></span>
																</td>
                                                                </tr>
                                                                <tr>
																<td width="129" height="32" align="center" bgcolor="#f3f7f9">
																	其他职务：
																</td>
																<td width="220" colspan="3" height="32" align="left" bgcolor="#FFFFFF">
																	<span
																		style="float: left; margin-left: 5px; ">
																		<input type="text" name="otherPosition" id="otherPosition" class="resume_profile_wbk"
																			size="25" maxlength="50"/> </span>
																</td>
															</tr>
															<tr>
																<td width="83" height="32" align="center"
																	bgcolor="#f3f7f9">
																	<span class="font_hilite">*</span>工作描述：
																</td>
																<td height="32" colspan="3" bgcolor="#FFFFFF" align="left">
																	<p
																		style="width: 460px; float: left; margin-left:5px; display:inline; margin-top:5px ">
																		<textarea name="description" id="description" rows="5" class="resume_profile_tblocks" maxlength="2000"></textarea>
																	</p>
																	<p
																		style="width: 470px; line-height: 18px; float: left; margin-left: 5px; display:inline ">
																		<font style="font-weight: bold; color: #FF0000">温馨提示：</font>您的工作描述未满100字,请完善.以便得到更多的面试机会！
																		<br />
																		限2000个中文字，请详细描述您的职责范围、工作任务以及取得的成绩等
																	</p>
																</td>
															</tr>
															<tr>
																<td width="83" height="32" align="center"
																	bgcolor="#f3f7f9">
																	离职原因：
																</td>
																<td height="32" colspan="3" bgcolor="#FFFFFF" align="left">
																	<p
																		style="width: 490px; float: left; margin: 5px; display:inline ">
																		<textarea name="leftReason" id="leftReason" rows="3" class="resume_profile_tblocks" maxlength="50"></textarea>
																	</p>
																	<p
																		style="width: 470px; line-height: 18px; float: left; margin-left: 5px; ">
																		简明扼要地阐述离职原因，字数在50字以内。
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
										<td height="21" align="center" valign="middle">
										<input type="hidden" id="eid" name="id"/>
											<input type="button" class="info_table_3_button_c"
												value="保 存" id="btnSave"/>
										</td>
									</tr>
									<tr>
										<td height="21" align="center" valign="middle">
											<input type="button" class="info_table_3_button_c"
												value="返 回" id="btnCancel"/>
										</td>
									</tr>
									<tr>
										<td valign="top">&nbsp;
											<span id="_bsSubmitMsg" style="color:red;margin-left: 5px;"></span>
										</td>
									</tr>
								</table>
						  </form>		
								<table width="735" style="margin-top: 10px;" id="tbAdd">
									<tr>
										<td>
											<input type="submit" name="Submit" value="增加信息"
												class="resume_addInfo" id="btnAdd"/>
										</td>
									</tr>
								</table>
							</div>

			</div>
		</div><div class="clear"></div>
		</div>
		<!--人脉 E-->
        <%@include file="/common/calling_dialog.jsp" %>
		<div class="clear"></div>
		<!--版权 S-->
		<%@include file="/common/footer.jsp"%>
		<!--版权 E-->
		<script language="javascript" type="text/javascript" src="${basePath}/js/My97DatePicker/WdatePicker.js"></script>
	</body>
</html>