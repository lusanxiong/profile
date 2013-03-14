<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<%@include file="/common/taglib.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<title>个人资料-语言能力</title>
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css">
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css">
		<link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${basePath}/js/jquery.js"></script>
		<script type="text/javascript" src="${basePath}/js/language_old.js"></script>		
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
								
											<table width="760" cellspacing="1" bgcolor="e9edf1"
												style="margin-bottom: 7px">
												<c:forEach items="${languageAbility.languages}"
													var="language">
													<tr>
														<td width="139" height="28" align="center"
															bgcolor="#f3f7f9">
															语言类别
														</td>
														<td width="172" height="28" align="center"
															bgcolor="#FFFFFF">
															${language.language}
														</td>
														<td width="139" height="28" align="center"
															bgcolor="#f3f7f9">
															掌握程度
														</td>
														<td width="172" height="28" align="center"
															bgcolor="#FFFFFF">
															${language.mastery}
														</td>
														<td align="center" bgcolor="#FFFFFF">
														<input type="hidden" id="lj${language.myLanguage.languageId}" value="${language.jsonString}" />
														<input type="button" class="resume_addInfo"
															value="修 改" onclick="editLanguage(${language.myLanguage.languageId})"/>
													</td>
													</tr>

													<tr>
														<td width="139" height="28" align="center"
															bgcolor="#FFFFFF">
															读写能力
														</td>
														<td width="172" height="28" align="center"
															bgcolor="#FFFFFF">
															${language.literacy}
														</td>
														<td width="139" height="28" align="center"
															bgcolor="#FFFFFF">
															听说能力
														</td>
														<td width="172" height="28" align="center"
															bgcolor="#FFFFFF">
															${language.listenAndSpeak}
														</td>
														<td align="center" bgcolor="#FFFFFF">
														<input type="button" class="resume_addInfo"
															value="删 除" onclick="delLanguage(${language.myLanguage.languageId})"/>
													</td>
													</tr>
													<tr>
													<td colspan="5" style="height: 10px;" bgcolor="#FFFFFF"></td>
													</tr>
												</c:forEach>
											</table>
									<form action="language.shtml" method="post" name="frmLanguage">
									<input type="hidden" name="languageId" id="languageId"/>
								<table width="735"
									style="margin:10px 0 0 0;border-bottom:1px dashed #a9a9a9;display:none;" id="tbEditLUG">
									<tr>
										<td>
											<table width="600" cellspacing="1" bgcolor="e9edf1"
												style="margin-bottom: 7px">
												<tr>
													<td width="139" height="28" align="center"
														bgcolor="#f3f7f9">
														语言类别
													</td>
													<td width="172" height="28" align="left" bgcolor="#FFFFFF">
														<span
															style="float: left; margin-left: 20px; display: inline">

															<select name="languageTyep" id="languageTyep">
																
																<option selected="selected" value="1">
																	英语
																</option>
																<option value="2">
																	日语
																</option>
																<option value="3">
																	俄语
																</option>
																<option value="4">
																	阿拉伯语
																</option>
																<option value="5">
																	法语
																</option>
																<option value="6">
																	德语
																</option>
																<option value="7">
																	西班牙语
																</option>
																<option value="8">
																	葡萄牙语
																</option>
																<option value="9">
																	意大利语
																</option>
																<option value="10">
																	韩语/朝鲜语
																</option>
																<option value="11">
																	普通话
																</option>
																<option value="12">
																	粤语
																</option>
																<option value="13">
																	闽南语
																</option>
																<option value="14">
																	上海话
																</option>
																<option value="15">
																	其他
																</option>
															</select> </span>
													</td>
													<td width="139" height="28" align="center"
														bgcolor="#f3f7f9">
														掌握程度
													</td>
													<td width="172" height="28" align="left" bgcolor="#FFFFFF">
														<span
															style="float: left; margin-left: 20px; display: inline">

															<select size="1" name="mastery" id="mastery">
																<option value="0">
																	不限
																</option>
																<option selected="" value="1">
																	一般
																</option>
																<option value="2">
																	良好
																</option>
																<option value="3">
																	熟练
																</option>
																<option value="4">
																	精通
																</option>

															</select> </span>
													</td>
												</tr>
												<tr>
													<td width="139" height="28" align="center"
														bgcolor="#FFFFFF">
														读写能力
													</td>
													<td width="172" height="28" align="left" bgcolor="#FFFFFF">
														<span
															style="float: left; margin-left: 20px; display: inline">

															<select size="1" name="literacy" id="literacy">
																<option value="0">
																	不限
																</option>
																<option selected="" value="1">
																	一般
																</option>
																<option value="2">
																	良好
																</option>
																<option value="3">
																	熟练
																</option>
																<option value="4">
																	精通
																</option>

															</select> </span>
													</td>
													<td width="139" height="28" align="center"
														bgcolor="#FFFFFF">
														听说能力
													</td>
													<td width="172" height="28" align="left" bgcolor="#FFFFFF">
														<span
															style="float: left; margin-left: 20px; display: inline">

															<select size="1" name="listenAndSpeak" id="listenAndSpeak">
																<option value="0">
																	不限
																</option>
																<option selected="" value="1">
																	一般
																</option>
																<option value="2">
																	良好
																</option>
																<option value="3">
																	熟练
																</option>
																<option value="4">
																	精通
																</option>

															</select> </span>
													</td>
												</tr>
											</table>
										</td>
										<td>
											<table width="124">
												<tr>
													<td align="center">
														<input type="button" class="info_table_3_button_c"
															value="保 存" onclick="save()"/>
													</td>
												</tr>
												<tr>
													<td align="center">
														<input type="button" class="info_table_3_button_c"
															value="返 回" onclick="cancel()"/>
													</td>
												</tr>
												<tr>
													<td>&nbsp;
														
													</td>
												</tr>
											</table>

										</td>
									</tr>
								</table>
								</form>	
								<table width="735" style="margin-top: 10px;" id="tbAdd">
									<tr>
										<td>
											<input type="submit" name="Submit" value="增加信息"
												class="resume_addInfo" onclick="addLG();"/>
											<span id="_bsSubmitMsg" style="color:red;margin-left: 5px;"></span>
										</td>
									</tr>
								</table>
								<table id="tbInfoLL" width="735" style="margin: 10px 0 0 0; display: block; border-bottom: 1px dashed #a9a9a9">
									<tr>
										<td>
											<table width="600" cellspacing="1" bgcolor="e9edf1"
												style="margin-bottom: 7px">
												<tr>
													<td width="80" height="28" align="center" bgcolor="#f3f7f9">
														英语等级
													</td>
													<td width="110" height="28" align="center"
														bgcolor="#FFFFFF">
														${languageAbility.englishLevel}
													</td>
													<td width="80" height="28" align="center" bgcolor="#f3f7f9">
														TOEFL
													</td>
													<td width="110" height="28" align="center"
														bgcolor="#FFFFFF">
														${languageAbility.myResume.toefl}
													</td>
													<td width="80" height="28" align="center" bgcolor="#f3f7f9">
														GRE
													</td>
													<td width="110" height="28" align="center"
														bgcolor="#FFFFFF">
														${languageAbility.myResume.gre}
													</td>
												</tr>
												<tr>
													<td width="80" height="28" align="center" bgcolor="#f3f7f9">
														日语等级
													</td>
													<td width="110" height="28" align="center"
														bgcolor="#FFFFFF">
														${languageAbility.japanLevel}
													</td>
													<td width="80" height="28" align="center" bgcolor="#f3f7f9">
														GMAT
													</td>
													<td width="110" height="28" align="center"
														bgcolor="#FFFFFF">
														${languageAbility.myResume.gmat}
													</td>
													<td width="80" height="28" align="center" bgcolor="#f3f7f9">
														IELTS
													</td>
													<td width="110" height="28" align="center"
														bgcolor="#FFFFFF">
														${languageAbility.myResume.ielts}
													</td>
												</tr>
											</table>
										</td>
										<td>
											<table width="124">
												<tr>
													<td>&nbsp;
														
													</td>
												</tr>
												<tr>
													<td align="center">
														<input type="button" class="info_table_3_button_c"
															value="修 改" onclick="editLL()"/>
													</td>
												</tr>
												<tr>
													<td>&nbsp;
														
													</td>
												</tr>
											</table>

										</td>
									</tr>
								</table>
								<form action="language.shtml" method="post" name="frmLL">
								<table width="735"
									style="margin: 10px 0 0 0; display: none; border-bottom: 1px dashed #a9a9a9" id="tbEditLL">
									<tr>
										<td>
											<table width="600" cellspacing="1" bgcolor="e9edf1"
												style="margin-bottom: 7px">
												<tr>
													<td width="80" height="28" align="center" bgcolor="#f3f7f9">
														英语等级
													</td>
													<td width="110" height="28" align="center"
														bgcolor="#FFFFFF">
														<select size="1" name="engLevel" id="engLevel">
	${languageAbility.englishLevelStr}					
  <option value="0">无</option> 
  <option value="3">三级</option> 
  <option value="4">四级</option> 
  <option value="6">六级</option> 
  <option value="8">八级</option> 
  <option value="9">专业四级</option> 
  <option value="10">专业八级</option> 

					</select>
													</td>
													<td width="80" height="28" align="center" bgcolor="#f3f7f9">
														TOEFL
													</td>
													<td width="110" height="28" align="center"
														bgcolor="#FFFFFF">
														<input type="text" name="toefl" id="toefl" value="${languageAbility.myResume.toefl}" class="resume_profile_wbk" size="7">
													</td>
													<td width="80" height="28" align="center" bgcolor="#f3f7f9">
														GRE
													</td>
													<td width="110" height="28" align="center"
														bgcolor="#FFFFFF">
														<input type="text" name="gre" id="gre" value="${languageAbility.myResume.gre}" class="resume_profile_wbk" size="7">
													</td>
												</tr>
												<tr>
													<td width="80" height="28" align="center" bgcolor="#f3f7f9">
														日语等级
													</td>
													<td width="110" height="28" align="center"
														bgcolor="#FFFFFF">
														<select class="FieldHZ" style="WIDTH: 70px" size="1" name="japanLevel" id="japanLevel">
  ${languageAbility.japanLevelStr}					 
  <option value="0">无</option> 
  <option value="1">一级</option> 
  <option value="2">二级</option> 
  <option value="3">三级</option> 
  <option value="4">四级</option> 


				</select>
													</td>
													<td width="80" height="28" align="center" bgcolor="#f3f7f9">
														GMAT
													</td>
													<td width="110" height="28" align="center"
														bgcolor="#FFFFFF">
														<input type="text" name="gmat" id="gmat" value="${languageAbility.myResume.gmat}" class="resume_profile_wbk" size="7">
													</td>
													<td width="80" height="28" align="center" bgcolor="#f3f7f9">
														IELTS
													</td>
													<td width="110" height="28" align="center"
														bgcolor="#FFFFFF">
														<input type="text" name="ielts" id="ielts" value="${languageAbility.myResume.ielts}" class="resume_profile_wbk" size="7">
													</td>
												</tr>
											</table>
										</td>
										<td>
											<table width="124">
												<tr>
													<td>&nbsp;
														
													</td>
												</tr>
												<tr>
													<td align="center">
														<input type="button" class="info_table_3_button_c"
															value="保存" onclick="saveLL()"/>
													</td>
												</tr>
												<tr>
													<td>&nbsp;
														
													</td>
												</tr>
											</table>

										</td>
									</tr>
								</table>
                               </form>

					</div>
					<!---------------------------右边内容块 E------------------------------->
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