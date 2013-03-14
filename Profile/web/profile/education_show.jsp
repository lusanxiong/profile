<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	$(function() {
		$("span.del[eduId]").click(
				function() {
					var obj = $(this);
					if (confirm("你确定要删除该项教育经历吗？")) {
						var eduId = $(this).attr("eduId");
						$.post(basePath + "/profile/educationDel.shtml",
								"eduId=" + eduId, function() {
									$("#educationEditContainer").hide();
									obj.closest("tr").hide();
								});
					}
				});

		$("span.edit[eduId]").click(
				function() {
					var eduId = $(this).attr("eduId");
					$("#educationEditContainer").load(
							basePath + "/profile/educationEdit.shtml",
							"eduId=" + eduId).show();
				});

		$("#educationAddBtn").click(
				function() {
					if (!$.trim($("#educationEditContainer").html())) {
						$("#educationEditContainer").load(
								basePath + "/profile/educationAdd.shtml")
								.show();
					} else {
						$("#educationEditContainer").show();
					}
				});
	});
</script>
<div class="w720">
	<table width="100%" border="0" cellspacing="1" cellpadding="0">
		<c:forEach items="${educations}" var="education" varStatus="status">
			<c:if test="${status.index==0}">
				<tr>
					<th width="122"  align="center" nowrap="nowrap">
						教育时间
					</th>
					<th width="212"  align="center" nowrap="nowrap">
						学校名称
					</th>
					<th width="91"  align="center" nowrap="nowrap">
						专 业
					</th>
					<th width="124"  align="center" nowrap="nowrap">
						证书编号
					</th>
					<th width="53"  align="center" nowrap="nowrap">
						学历
					</th>
					<th width="88"  align="center" nowrap="nowrap">
						操作
					</th>
				</tr>
			</c:if>
			<tr>
				<td width="122"  align="center">
					${education.myEducation.beginDate}
					至${education.myEducation.endDate}
				</td>
				<td width="212"  align="center">
					${education.myEducation.schoolName}
				</td>
				<td width="91"  align="center">
					${education.myEducation.speciality}
				</td>
				<td width="124"  align="center">
					${education.myEducation.certificate}
				</td>
				<td width="53"  align="center">
					${education.myEducation.degreeName}
				</td>
				<td width="88"  align="center" valign="middle">
					<input type="hidden" id="ej${education.myEducation.id}"
						name="ej${education.myEducation.id}"
						value="${education.jsonString}" />
					<span class="edit" eduId="${education.myEducation.id}" style=" cursor:pointer;" title="编辑"></span>
					<span class="del" eduId="${education.myEducation.id}" style=" cursor:pointer;" title="删除"></span>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<p class="add_info">
	<input type="button" id="educationAddBtn" value="增加信息"
		class="resume_addInfo" />
	<span id="_bsSubmitMsg" style="color: red; margin-left: 5px;"></span>
</p>

