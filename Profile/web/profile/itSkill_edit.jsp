<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function() {
		$("#itSkillSave").click(function() {
			$.post(basePath + "/profile/itSkillUpdate.shtml", $("#itSkillForm").serialize(), function() {
				$("#itSkillContainer").load(basePath + "/profile/itSkillShow.shtml");
			});
		});

		$("#itSkillBack").click(function() {
			$("#itSkillContainer").load(basePath + "/profile/itSkillShow.shtml");
		});
	});
</script>
<div class="resume_left">
	<form method="post" id="itSkillForm">
		<input type="hidden" name="edtag" value="1" />
		<table width="100%" border="0" cellspacing="1" cellpadding="0">
			<tr>
				<th width="83"  align="right" nowrap="nowrap">
					技术职称：
				</th>
				<td width="508" align="left" valign="middle">
					<input name="techTitle" type="text" class="resume_profile_wbk"
						value="${myResume.techTitle}" />
				</td>
				<th width="83"  align="right" nowrap="nowrap">
					<span class="font_hilite">*</span>计算机能力:
					</span>
				</th>
				<td width="83"  align="left">
					<input type="hidden" id="computerLevel"
						value="${myResume.computerLevel}" />
					<select name="computerLevel" id="selComputerLevel"
						style="width: 206px">
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
					</select>
				</td>
			</tr>
			<tr>
				<th width="83"  align="right" valign="middle"
					nowrap="nowrap">
					技能描述：
				</th>
				<td align="left" valign="middle" colspan="3">
					<textarea name="computerSkills" cols="57" rows="4"
						class="resume_profile_tks">${myResume.computerSkills}</textarea>
				</td>
			</tr>
		</table>
	</form>
</div>
<div class="resume_right">
	<a href="javascript:void(0);" id="itSkillSave" class="new_FB_a_1"><img
			src="../images/resume/btn_save.gif" /> </a><a href="javascript:void(0);" id="itSkillBack"
		class="new_FB_a_1"><img src="../images/resume/btn_reback.gif" />
	</a>
</div>
