<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${languageAbility.languages}" var="language">
	<script language="javascript">
	$(function(){
		var form = $("#languageForm${language.myLanguage.languageId}");
		form.find("#languageTyep").val(${language.myLanguage.languageTyep});
		form.find("#mastery").val(${language.myLanguage.mastery});
		form.find("#literacy").val(${language.myLanguage.literacy});
		form.find("#listenAndSpeak").val(${language.myLanguage.listenAndSpeak});
	});
</script>
	<form method="post" id="languageForm${language.myLanguage.languageId}" languageId="${language.myLanguage.languageId}">
		<div class="resume_left">
			<input type="hidden" name="id" value="${language.myLanguage.languageId}" />
			<table width="100%" border="0" cellspacing="1" cellpadding="0">
				<tr>
				  <th width="139"  align="center" nowrap="nowrap">
						语言类别
					</th>
					<td width="172"  align="center">
						
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
							</select>
					</td>
					<th width="139"  align="center" nowrap="nowrap">
						掌握程度
					</th>
					<td width="172"  align="center">
						
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
							</select> 
					</td>
				</tr>
				<tr>
				  <th width="139"  align="center" nowrap="nowrap">
						读写能力
					</th>
					<td width="172"  align="center">
					
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
							</select> 
					</td>
					<th width="139"  align="center" nowrap="nowrap">
						听说能力
					</th>
					<td width="172"  align="center">
					
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
							</select> 
					</td>
				</tr>
			</table>
		</div>
		<div class="resume_right">
			<a href="javascript:void(0);"
				onclick="Language.save('${language.myLanguage.languageId}');"
				class="new_FB_a_1"><img src="../images/resume/btn_save.gif" />
			</a><a href="javascript:void(0);"
				onclick="Language.back('${language.myLanguage.languageId}');"
				class="new_FB_a_1"><img src="../images/resume/btn_reback.gif" />
			</a>
		</div>
	</form>
</c:forEach>