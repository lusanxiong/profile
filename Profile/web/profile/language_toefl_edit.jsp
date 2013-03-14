<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<form method="post" id="languageToeflForm">
<div class="resume_left">
	<table width="100%" border="0" cellspacing="1" cellpadding="0">
		<tr>
			<th width="80"  align="center" nowrap="nowrap">
				英语等级
			</th>
			<td width="110"  align="center">
				<select size="1" name="engLevel" id="engLevel">
					${languageAbility.englishLevelStr}
					<option value="0">
						无
					</option>
					<option value="3">
						三级
					</option>
					<option value="4">
						四级
					</option>
					<option value="6">
						六级
					</option>
					<option value="8">
						八级
					</option>
					<option value="9">
						专业四级
					</option>
					<option value="10">
						专业八级
					</option>
				</select>
			</td>
			<th width="80"  align="center" nowrap="nowrap">
				TOEFL
		  </th>
			<td width="110"  align="center">
				<input type="text" name="toefl" id="toefl"
					value="${languageAbility.myResume.toefl}"
					class="resume_profile_wbk" size="7">
			</td>
			<th width="80"  align="center" nowrap="nowrap">
				GRE
			</th>
			<td width="110"  align="center">
				<input type="text" name="gre" id="gre"
					value="${languageAbility.myResume.gre}" class="resume_profile_wbk"
					size="7">
			</td>
		</tr>
		<tr>
			<th width="80"  align="center" nowrap="nowrap">
				日语等级
			</th>
			<td width="110"  align="center">
				<select class="FieldHZ" style="WIDTH: 70px" size="1"
					name="japanLevel" id="japanLevel">

					${languageAbility.japanLevelStr}

					<option value="0">
						无
					</option>
					<option value="1">
						一级
					</option>
					<option value="2">
						二级
					</option>
					<option value="3">
						三级
					</option>
					<option value="4">
						四级
					</option>
				</select>
			</td>
			<th width="80"  align="center" nowrap="nowrap">
				GMAT
		  </th>
			<td width="110"  align="center">
				<input type="text" name="gmat" id="gmat"
					value="${languageAbility.myResume.gmat}" class="resume_profile_wbk"
					size="7">
			</td>
			<th width="80"  align="center" nowrap="nowrap">
				IELTS
			</th>
			<td width="110"  align="center">
				<input type="text" name="ielts" id="ielts"
					value="${languageAbility.myResume.ielts}"
					class="resume_profile_wbk" size="7">
			</td>
		</tr>
	</table>
</div>
<div class="resume_right">
	<a href="javascript:void(0);" onclick="Language.toefl.update();" class="new_FB_a_1"><img
			src="../images/resume/btn_save.gif" />
	</a>
</div>
</form>