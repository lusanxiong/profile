<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<div class="resume_left">
	<table width="100%" border="0" cellspacing="1" cellpadding="0">
		<tr>
			<th width="139"  align="center" nowrap="nowrap">
				语言类别
			</th>
			<td width="172"  align="center">
				${language.language}
			</td>
			<th width="139"  align="center" nowrap="nowrap">
				掌握程度
		  </th>
			<td width="172"  align="center">
				${language.mastery}
			</td>
		</tr>

		<tr>
			<th width="139"  align="center" nowrap="nowrap">
				读写能力
			</th>
			<td width="172"  align="center">
				${language.literacy}
			</td>
			<th width="139"  align="center" nowrap="nowrap">
				听说能力
		  </th>
			<td width="172"  align="center">
				${language.listenAndSpeak}
			</td>
		</tr>
	</table>
</div>
<div class="resume_right">
	<a href="javascript:void(0);"
		onclick="Language.edit(${language.myLanguage.languageId});"
		class="new_FB_a_1"><img src="../images/resume/btn_modify.gif" />
	</a><a href="javascript:void(0);"
		onclick="Language.del(${language.myLanguage.languageId});"
		class="new_FB_a_1"><img src="../images/resume/btn_del.gif" /> </a>
</div>
