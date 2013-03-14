<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
$(function(){
	$("span.del[tid]").click(function(){
		var obj = $(this);
		if(confirm("你确定要删除该项培训经历吗？")) {
			var tid = $(this).attr("tid");
			$.post(basePath+"/profile/trainingDel.shtml","id="+tid);
			$("#trainingEditContainer").hide();
			obj.closest("tr").hide();
		}
	});

	$("span.edit[tid]").click(function(){
		var tid = $(this).attr("tid");
		$("#trainingEditContainer").load(basePath+"/profile/trainingEdit.shtml","id="+tid).show();
	});
	
	$("#trainingAddBtn").click(function(){
		if(!$.trim($("#trainingEditContainer").html())) {
			$("#trainingEditContainer").load(basePath+"/profile/trainingAdd.shtml").show();
		}else {
			$("#trainingEditContainer").show();
		}
	});
});
</script>
<div class="w720">
   <table width="100%" border="0" cellspacing="1" cellpadding="0">
  
  <c:forEach items="${trainingList}" var="training" varStatus="status">
  	<c:if test="${status.index==0}">
  	<tr>
	    <th width="160"  align="center" nowrap="nowrap"> 起始时间 </th>
	    <th width="160"  align="center" nowrap="nowrap"> 培训机构 </th>
	    <th width="160"  align="center" nowrap="nowrap"> 培训项目 </th>
	    <th width="160"  align="center" nowrap="nowrap"> 获得证书 </th>
	    <th width="104"  align="center" nowrap="nowrap"> 操作 </th>
  	</tr>
  	</c:if>
    <tr>
      <td width="160"  align="center">&nbsp;
        ${training.myTraining.beginDate}至${training.myTraining.endDate} </td>
      <td width="160"  align="center">&nbsp;${training.myTraining.organization} </td>
      <td width="160"  align="center">&nbsp;${training.myTraining.course} </td>
      <td width="160"  align="center">&nbsp;${training.myTraining.certificate} </td>
      <td width="104"  align="center">
      <span class="edit" tid="${training.myTraining.id}" style=" cursor:pointer;" title="编辑"></span>
	  <span class="del" tid="${training.myTraining.id}" style=" cursor:pointer;" title="删除"></span></td>
    </tr>
  </c:forEach>
</table></div>
		<p class="add_info"><input type="button" id="trainingAddBtn"  value="增加培训" class="resume_addInfo" />
	<span id="_bsSubmitMsg" style="color:red;margin-left: 5px;"></span>
</p>
       