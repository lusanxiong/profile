<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<title>个人资料-附加信息</title>
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css">
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css">
		<link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${basePath}/js/jquery.js"></script>
		<script type="text/javascript" src="${basePath}/js/additional.js"></script>
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
                                <div class="basic_l"><span>语言能力</span></div>
                                <div class="basic_r" style="display:none"><span>English</span></div>
                                </div>
							<table width="750">
								<tr>
									<td align="left">
										<span style="width: 70px; font-weight: bold; color: #F66E00">相关技能</span>
									</td>
									<td>
										<span
											style="float:left; background:url(${basePath}/images/fujia_line.gif) repeat-x; width:680px; height:12px;"></span>
									</td>
								</tr>
							</table>

							<table width="735" id="tbInfo">
								<tr>
									<td width="600" rowspan="4">
										<table width="600">
											<tr>
												<td width="508" colspan="2" align="left" bgcolor="#FFFFFF">
													${myResume.otherSkills}
												</td>
											</tr>
										</table>
									</td>
									<td width="123" height="22">&nbsp;
										
									</td>
								</tr>
								<tr>
									<td height="26" align="center" valign="middle">
										<span style="float: left; margin-left: 46px;"><input
												type="button" class="info_table_3_button_c" value="修 改"
												id="btnEditInfo" /> </span>
									</td>
								</tr>
								<tr>
									<td>&nbsp;
										
									</td>
								</tr>
							</table>

							<!-- ss -->
							<form action="additional.shtml" method="post" name="frmInfo">
							   <input type="hidden" name="edtag" value="0"/>
								<table width="735"
									style="float: left; margin-left:15px; display: none;"
									id="tbEditInfo">
									<tr>
										<td width="600" rowspan="4">
											<table width="600" cellspacing="1" bgcolor="e9edf1">
												<tr>
													<td height="34" colspan="2" align="left" bgcolor="#FFFFFF">
														<span
															style="margin: 8px 5px 0 5px; padding-bottom: 8px; float: left; text-align:left; display: inline;">请详细并有重点地描述您的相关技能，字数在20~1000字之间。另外，请注明一些与您职业密切相关的关键字，如“企业管理5年经验”等，以便人事经理在查询人才时，使用这些关键字快速地找到。
														</span>
													</td>
												</tr>
												<tr>
													<td align="left" valign="middle" bgcolor="#FFFFFF">
														<span
															style="margin: 8px 5px; float: left; display: inline;">
															<textarea name="otherSkills" cols="68" rows="4" class="resume_profile_tbks"> ${myResume.otherSkills}</textarea>
														</span>
													</td>
												</tr>
											</table>
										</td>
										<td width="123" height="22">&nbsp;
											
										</td>
									</tr>
									<tr>
										<td height="26" align="center" valign="middle">
											<input type="submit" class="info_table_3_button_c"
												value="保 存" />
										</td>
									</tr>
									<tr>
										<td align="center">
											<input type="button" class="info_table_3_button_c"
												value="返 回" id="btnCancelInfo" />
										</td>
									</tr>
									<tr>
										<td>&nbsp;
											
										</td>
									</tr>
								</table>
								 
							</form>
							<!-- se -->
							<table width="750" style="float: left; margin-top: 10px">
								<tr>
									<td align="center">
										<span style="font-weight: bold; color: #F66E00; width: 54px">IT技能</span>
									</td>
									<td>
										<span
											style="float:left; background:url(${basePath}/images/fujia_line.gif) repeat-x; width:695px; height:12px;"></span>
									</td>
								</tr>
							</table>
							<div class="resume_profile_dw">
								<table width="735" id="tbIt">
									<tr>
										<td width="600" rowspan="4">
											<table width="600" cellspacing="1" bgcolor="e9edf1">
												<tr>
													<td width="83" height="34" align="center" bgcolor="#f3f7f9">
														技术职称：
													</td>
													<td width="508" align="center" valign="middle"
														bgcolor="#FFFFFF">
														<span
															style="width: 200px; margin: 8px 5px 0 5px; float: left; display: inline;">${myResume.techTitle}</span>
														<span
															style="float: left; background-color: #f3f7f9; border-left: 1px solid #e9edf1; border-right: 1px solid #e9edf1; height: 34px; line-height: 34px; width: 81px;">计算机能力:</span>
														<span
															style="width: 200px; margin: 8px 5px 0 5px; float: left; display: inline;">${computerLevel}</span>
													</td>
												</tr>
												<tr>
													<td width="83" height="34" align="center" valign="middle"
														bgcolor="#f3f7f9">
														技能描述：
													</td>
													<td align="left" valign="middle" bgcolor="#FFFFFF">
														<span
															style="margin: 0px 5px 0 5px; float: left; display: inline;">${myResume.computerSkills}</span>
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
												value="修 改" id="btnEditIt" />
										</td>
									</tr>
									<tr>
										<td>&nbsp;
											
										</td>
									</tr>
								</table>


								<!-- es -->
								<form action="additional.shtml" method="post" name="frmIt">
								    <input type="hidden" name="edtag" value="1"/>
									<table width="735" id="tbEditIt" style="display: none;">
										<tr>
											<td width="600" rowspan="4">
												<table width="600" cellspacing="1" bgcolor="e9edf1">
													<tr>
														<td width="83" height="34" align="center"
															bgcolor="#f3f7f9">
															技术职称：
														</td>
														<td width="508" align="left" valign="middle"
															bgcolor="#FFFFFF">
															<span
																style="width: 200px; margin: 8px 5px 0 5px; float: left; display: inline;">
																<input name="techTitle" type="text" class="resume_profile_wbk"  value="${myResume.techTitle}"/>
															</span>
															<span
																style="float: left; background-color: #f3f7f9; border-left: 1px solid #e9edf1; border-right: 1px solid #e9edf1; height: 34px; line-height: 34px; width: 81px; text-align: center">
																<span class="font_hilite">*</span>计算机能力:</span>
															<span
																style="width: 200px; margin: 8px 5px 0 5px; float: left; display: inline;">
																<input type="hidden" id="computerLevel"  value="${myResume.computerLevel}"/>
																<select name="computerLevel" id="selComputerLevel" style="width:206px">
																	<option value="1">
																		初级
																	</option>
																	<option value="2">
																		中级
																	</option>
																	<option value="3">
																		高级
																	</option>
																	<option value="4">
																		高校非计算机专业二级
																	</option>
																	<option value="5">
																		高校非计算机专业三级(偏软)
																	</option>
																	<option value="6">
																		高校非计算机专业三级(偏硬)
																	</option>
																	<option value="7">
																		初级程序员
																	</option>
																	<option value="8">
																		程序员
																	</option>
																	<option value="9">
																		高级程序员
																	</option>
																	<option value="10">
																		系统分析员
																	</option>
																	<option value="11">
																		网络程序员
																	</option>
																	<option value="12">
																		网络设计师
																	</option>
																	<option value="13">
																		全国计算机等级考试一级
																	</option>
																	<option value="14">
																		全国计算机等级考试二级
																	</option>
																	<option value="15">
																		全国计算机等级考试三级
																	</option>
																	<option value="16">
																		全国计算机等级考试四级
																	</option>
																	<option value="17">
																		微软认证产品专家
																	</option>
																	<option value="18">
																		微软认证网站建造专家(MCP+Site Builder)
																	</option>
																	<option value="19">
																		微软认证系统工程师(MCSE)
																	</option>
																	<option value="20">
																		微软认证数据库管理员(MCDBA)
																	</option>
																	<option value="21">
																		微软认证开发专家(MCSD)
																	</option>
																	<option value="22">
																		Cisco职业资格认证CCNA
																	</option>
																	<option value="23">
																		Cisco职业资格认证CCDP
																	</option>
																	<option value="24">
																		Cisco职业资格认证CCNP
																	</option>
																	<option value="25">
																		Cisco职业资格认证CCIE
																	</option>
																	<option value="26">
																		Oracle8数据库管理员
																	</option>
																	<option value="27">
																		Lotus资格认证
																	</option>
																	<option value="28">
																		Lotus-CLS资格认证
																	</option>
																	<option value="29">
																		Lotus-CLI资格认证
																	</option>
																	<option value="30">
																		Notes应用开发工程师
																	</option>
																	<option value="31">
																		Notes系统管理工程师
																	</option>
																	<option value="32">
																		Notes高级应用开发工程师
																	</option>
																	<option value="33">
																		Notes高级系统管理工程师
																	</option>
																	<option value="34">
																		IBM-DB2数据库管理员
																	</option>
																	<option value="34">
																		IBM-DB2应用开发专家
																	</option>
																	<option value="36">
																		IBM-MQSeries工程师
																	</option>


																</select> </span>
														</td>
													</tr>
													<tr>
														<td width="83" height="34" align="center" valign="middle"
															bgcolor="#f3f7f9">
															技能描述：
														</td>
														<td align="left" valign="middle" bgcolor="#FFFFFF">
															<span
																style="margin: 8px 5px; float: left; display: inline;"><textarea
																	name="computerSkills" cols="57" rows="4" class="resume_profile_tks">${myResume.computerSkills}</textarea> </span>
														</td>
													</tr>
												</table>
											</td>
											<td width="123" height="22">&nbsp;
												
											</td>
										</tr>
										<tr>
											<td height="26" align="center" valign="middle">
												<input type="submit" class="info_table_3_button_c"
													value="保 存"/>
											</td>
										</tr>
										<tr>
											<td align="center">
												<input type="button" class="info_table_3_button_c"
													value="返 回" id="btnCancelIt" />
											</td>
										</tr>
										<tr>
											<td>&nbsp;
												
											</td>
										</tr>
									</table>
								</form>
								<!-- ee -->
					</div>

				<!---------------------------右边内容块 E------------------------------->
			</div>
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