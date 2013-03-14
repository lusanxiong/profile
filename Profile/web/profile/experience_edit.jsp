<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${experiences}" var="experience" varStatus="con">
<script type="text/javascript">
	$(function(){
		
		var form = $("#experienceForm${experience.myWorkExp.id}");
		form.find("#memType").val(${experience.myWorkExp.memType});
		form.find("#memCalling").val(${experience.myWorkExp.memCalling});

		form.find("#MySpCalling").click(function(){
			var callings = new Array();
			if(form.find("#jobFunctionId").val() != "")
			{
			   callings[0] = new Array(form.find("#jobFunctionId").val(), form.find("#MySpCalling").html());
			}
			CallingDialog.init(callings,1,setJobCaling);
			CallingDialog.show();
		});

		var setJobCaling = function(calling) {
			if(calling && calling.length>0) {
				form.find("#jobFunctionId").val(calling[0][0]);
				form.find("#MySpCalling").html(calling[0][1]);
			}
		}
	});
</script>
<form id="experienceForm${experience.myWorkExp.id}" experienceId="${experience.myWorkExp.id}">
	<div class="resume_left">
		<input type="hidden" name="id" value="${experience.myWorkExp.id}" />
		<table width="100%" border="0" cellspacing="1" cellpadding="0">
			<tr>
				<th width="99"  align="right" nowrap="nowrap">
					<span class="font_hilite">*</span>在职时间：
				</th>
				<td  colspan="3">
					<span style="margin-left: 5px; float: left;"> <input
							name="beginDate" id="beginDate" type="text"
							value="${experience.myWorkExp.beginDate}"
							class="resume_profile_wbk"
							onclick="WdatePicker({dateFmt:'yyyy-MM'});" size="7" style="width:77px;" /> </span>
					<span style="float: left; margin: 4px 0 0 5px;">—</span>
					<span style="margin-left: 5px; float: left;"> <input
							name="endDate" id="endDate" type="text"
							value="${experience.myWorkExp.endDate}"
							class="resume_profile_wbk"
							onclick="WdatePicker({dateFmt:'yyyy-MM'});" size="7" style="width:77px;" /> </span>
					<span style="float: left; margin: 4px 0 0 5px;"><span class="n_tishi">(如:2011-12)</span></span>
				</td>
			</tr>
			<tr>
				<th width="99"  align="right" nowrap="nowrap">
					<span class="font_hilite">*</span>公司名称：
				</th>
				<td  colspan="3">
					<span style="float: left; margin-left: 5px;"> <input
							name="memName" id="memName" type="text" size="40"
							value="${experience.myWorkExp.memName}"
							class="resume_profile_wbk" maxlength="50" style="width:183px;" /> </span>
				</td>
			</tr>
			<tr>
				<th width="99" height="29" align="right" nowrap="nowrap">
					<span class="font_hilite">*</span>公司性质：
				</th>
				<td width="153" colspan="3" height="29" align="center">
					<span style="float: left; margin-left: 5px;"> <select
							size="1" name="memType" id="memType">
							<option value="1">
								外资
							</option>
							<option value="2">
								合资
							</option>
							<option value="3">
								国企
							</option>
							<option value="4">
								民营公司
							</option>
							<option value="5">
								其它性质
							</option>
						</select></span>
				</td>
			</tr>
			<tr>
				<th width="99"  align="right" nowrap="nowrap">
					<span class="font_hilite">*</span><span>行业分类：</span>
				</th>
				<td width="220" colspan="3" align="left">
					<span style="float: left; margin-left: 5px;"> <select
							size="1" name="memCalling" id="memCalling">
							<option value="1000">
								计算机/IT/互联网/电子商务
							</option>
							<option value="1100">
								高级管理
							</option>
							<option value="1200">
								人力资源
							</option>
							<option value="1300">
								销售类
							</option>
							<option value="1400">
								客服及技术支持
							</option>
							<option value="1600">
								财务/审计/税务
							</option>
							<option value="1500">
								市场/营销
							</option>
							<option value="1700">
								生产/营运
							</option>
							<option value="1800">
								行政/后勤
							</option>
							<option value="1900">
								通信技术开发及应用
							</option>
							<option value="2000">
								银行
							</option>
							<option value="2100">
								金融/证券/期货/投资
							</option>
							<option value="2200">
								贸易/进出口
							</option>
							<option value="2300">
								机械/模具/工程/能源
							</option>
							<option value="2400">
								汽车
							</option>
							<option value="2500">
								建筑/监理/施工/市政建设
							</option>
							<option value="2600">
								房地产
							</option>
							<option value="2700">
								物业管理
							</option>
							<option value="2800">
								医疗
							</option>
							<option value="2900">
								生物/制药/医疗器械
							</option>
							<option value="3000">
								印刷/包装/造纸
							</option>
							<option value="3100">
								酒店/旅游
							</option>
							<option value="3200">
								餐饮/娱乐
							</option>
							<option value="3300">
								化工
							</option>
							<option value="3400">
								服装/纺织
							</option>
							<option value="3500">
								教育
							</option>
							<option value="3600">
								美容/美发/保健/体育
							</option>
							<option value="3700">
								照明
							</option>
							<option value="3800">
								矿产/地质勘查/冶金
							</option>
							<option value="3900">
								造船
							</option>
							<option value="4000">
								交通运输服务
							</option>
							<option value="4100">
								物流/仓储
							</option>
							<option value="4200">
								电力/电源
							</option>
							<option value="4300">
								艺术/设计
							</option>
							<option value="4400">
								百货/连锁/零售服务
							</option>
							<option value="4500">
								律师/法务/合规
							</option>
							<option value="4600">
								技工
							</option>
							<option value="4700">
								采购
							</option>
							<option value="4800">
								翻译
							</option>
							<option value="4900">
								环保/节能
							</option>
							<option value="5000">
								农业/养殖
							</option>
							<option value="9900">
								其它
							</option>
						</select></span>
				</td>
			</tr>
			<tr>
				<th width="99"  align="right" nowrap="nowrap">
					担任职务：
				</th>
				<td width="153" colspan="3"  align="left">
					<input type="hidden" id="jobFunctionId" name="jobFunctionId"
						value="${experience.myWorkExp.jobFunctionId}" />
						<span id="MySpCalling"
							style=" background:url(${basePath}/images/profile_sel.gif); width:93px; height:22px; line-height:22px; text-align:left; padding-left:6px; padding-right:27px; overflow:hidden; float:left; margin-left:5px;">
						${experience.post}
						</span>
				</td>
			</tr>
			<tr>
				<th width="99"  align="right" nowrap="nowrap">
					其他职务：
				</th>
				<td width="220" colspan="3"  align="left">
					<span style="float: left; margin-left: 5px;"> <input
							type="text" name="otherPosition" id="otherPosition"
							class="resume_profile_wbk" size="25" maxlength="50" style="width:185px;" /> </span>
				</td>
			</tr>
			<tr>
				<th width="99"  align="right" nowrap="nowrap">
					<span class="font_hilite">*</span>工作描述：
				</th>
				<td  colspan="3" align="left">
					<p
						style="width: 460px; float: left; margin-left: 5px; display: inline; margin-top: 5px">
						<textarea name="description" id="description" rows="5"
							class="resume_profile_tblocks" maxlength="2000" style="width:485px;">${experience.myWorkExp.description}</textarea>
					</p>
					<p
						style="width: 470px; line-height: 18px; float: left; margin-left: 5px; display: inline">
						<font style="font-weight: bold; color: #FF0000">温馨提示：</font>
						<br /><span class="n_tishi">限2000个中文字，请详细描述您的职责范围、工作任务以及取得的成绩等</span>
					</p>
				</td>
			</tr>
			<tr>
				<th width="99"  align="right" nowrap="nowrap">
					离职原因：
				</th>
				<td  colspan="3" align="left">
					<p style="width: 490px; float: left; margin: 5px; display: inline">
						<textarea name="leftReason" id="leftReason" rows="3"
							class="resume_profile_tblocks" maxlength="50" style="width:485px;">${experience.myWorkExp.leftReason}</textarea>
					</p>
					<p
						style="width: 470px; line-height: 18px; float: left; margin-left: 5px;">
						<span class="n_tishi">简明扼要地阐述离职原因，字数在50字以内。</span>
					</p>
				</td>
			</tr>
		</table>
	</div>
	<div class="resume_right">
		<a href="javascript:void(0);" onclick="Experience.save('${experience.myWorkExp.id}','${action}');" class="new_FB_a_1"><img
				src="../images/resume/btn_save.gif" /> </a><a
			href="javascript:void(0);"
			onclick="Experience.back('${experience.myWorkExp.id}','${action}');"
			class="new_FB_a_1"><img src="../images/resume/btn_reback.gif" />
		</a>
	</div>
	</form>
</c:forEach>
