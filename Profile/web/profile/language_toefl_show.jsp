<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<div class="resume_left">
	<table width="100%" border="0" cellspacing="1" cellpadding="0">
		<tr>
			<th width="80"  align="center" nowrap="nowrap">
				英语等级
			</th>
			<td width="110"  align="center">
				${languageAbility.englishLevel}
			</td>
			<th width="80"  align="center" nowrap="nowrap">
				TOEFL
		  </th>
			<td width="110"  align="center">
				${languageAbility.myResume.toefl}
			</td>
			<th width="80"  align="center" nowrap="nowrap">
				GRE
			</th>
			<td width="110"  align="center">
				${languageAbility.myResume.gre}
			</td>
		</tr>
		<tr>
			<th width="80"  align="center" nowrap="nowrap">
				日语等级
			</th>
			<td width="110"  align="center">
				${languageAbility.japanLevel}
			</td>
			<th width="80"  align="center" nowrap="nowrap">
				GMAT
		  </th>
			<td width="110"  align="center">
				${languageAbility.myResume.gmat}
			</td>
			<th width="80"  align="center" nowrap="nowrap">
				IELTS
			</th>
			<td width="110"  align="center">
				${languageAbility.myResume.ielts}
			</td>
		</tr>
	</table>
</div>
<div class="resume_right">
	<a href="javascript:void(0);" onclick="Language.toefl.edit();" class="new_FB_a_1"><img
			src="../images/resume/btn_modify.gif" />
	</a>
</div>
