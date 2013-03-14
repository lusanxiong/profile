<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<div class="resume_left">
	<table width="100%" border="0" cellspacing="1" cellpadding="0">
		<tr>
			<th width="99" align="right" nowrap="nowrap">
				在职时间：
			</th>
			<td  colspan="3">
				<span style="float: left; margin-left: 5px;">${experience.myWorkExp.beginDate} — ${experience.myWorkExp.endDate}</span>
			</td>
		</tr>
		<tr>
			<th width="99" align="right" nowrap="nowrap">
				公司名称：
			</th>
			<td  colspan="3">
				<span style="float: left; margin-left: 5px;">${experience.myWorkExp.memName}</span>
			</td>
		</tr>
		<tr>
			<th width="99" align="right" nowrap="nowrap">
				公司性质：
			</th>
			<td width="563" colspan="3" align="center">
				<span style="float: left; margin-left: 5px;">${experience.companyType}</span>
			</td>
		</tr>
		<tr>
			<th width="99" align="right" nowrap="nowrap">
				行业分类：
			</th>
			<td width="563" colspan="3" align="left">
				<span style="float: left; margin-left: 5px;">${experience.calling}</span>
			</td>
		</tr>
		<tr>
			<th width="99" align="right" nowrap="nowrap">
				担任职务：
			</th>
			<td  width="563" colspan="3" align="left">
				<span style="float: left; margin-left: 5px; display: inline"
					id="spCalling${experience.myWorkExp.id}">${experience.post}</span>
			</td>
		</tr>
		<tr>
			<th width="99" align="right" nowrap="nowrap">
				工作描述：
			</th>
			<td  align="left" colspan="3">
				<span
					style="float: left; margin-left: 5px; display: inline; line-height: 18px" id="workExpDescription">${experience.myWorkExp.description}</span>
			</td>
		</tr>
		<tr>
			<th width="99" align="right" nowrap="nowrap">
				离职原因：
			</th>
			<td  colspan="3" align="left">
				<span style="float: left; margin-left: 5px; display: inline">${experience.myWorkExp.leftReason}</span>
			</td>
		</tr>
	</table>

</div>
<div class="resume_right">
	<a href="javascript:void(0);"
		onclick="Experience.edit(${experience.myWorkExp.id});"
		class="new_FB_a_1"><img src="../images/resume/btn_modify.gif" />
	</a>
	<a href="javascript:void(0);"
		onclick="Experience.del(${experience.myWorkExp.id});"
		class="new_FB_a_1"><img src="../images/resume/btn_del.gif" /> </a>
</div>