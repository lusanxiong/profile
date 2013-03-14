<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<div style=" position:relative;z-index:500; display:none">
<div class="popdiv" id="_call_box">
	<div class="popdiv_top">
		<h1>
			请选择岗位(您最多选择<b id="_call_apt_count">3</b>项)
		</h1>
		<div class="popdiv_fun">
			<a href="javascript:void(0);" id="_call_box_ok">确定</a>
		</div>
	</div>
	<div class="popdiv_con">
		<div class="popdiv_selectedAreaTitle">
			已选择岗位
		</div>
		<ul class="popdiv_selectedArea" id="_call_selected_ul">

		</ul>
		
		<!--地区大类S-->
		<div class="popdiv_areaTitle3">所有岗位</div>
		<ul class="popdiv_area3">
		<li class="jobSortTitle" id="_c_1000" onclick="CallingDialog.showCalling(this);">计算机/IT/互联网/电子商务</li>
		<li class="jobSortTitle" id="_c_1100" onclick="CallingDialog.showCalling(this);">高级管理</li>
		<li class="jobSortTitle" id="_c_1200" onclick="CallingDialog.showCalling(this);">人力资源</li>
		<li class="jobSortTitle" id="_c_1300" onclick="CallingDialog.showCalling(this);">销售类</li>
		<li class="jobSortTitle" id="_c_1400" onclick="CallingDialog.showCalling(this);">客服及技术支持</li>
		<li class="jobSortTitle" id="_c_1600" onclick="CallingDialog.showCalling(this);">财务/审计/税务</li>
		<li class="jobSortTitle" id="_c_1500" onclick="CallingDialog.showCalling(this);">市场/营销</li>
		<li class="jobSortTitle" id="_c_1700" onclick="CallingDialog.showCalling(this);">生产/营运</li>
		<li class="jobSortTitle" id="_c_1800" onclick="CallingDialog.showCalling(this);">行政/后勤</li>
		<li class="jobSortTitle" id="_c_1900" onclick="CallingDialog.showCalling(this);">通信技术开发及应用</li>
		<li class="jobSortTitle" id="_c_2000" onclick="CallingDialog.showCalling(this);">银行</li>
		<li class="jobSortTitle" id="_c_2100" onclick="CallingDialog.showCalling(this);">金融/证券/期货/投资</li>
		<li class="jobSortTitle" id="_c_2200" onclick="CallingDialog.showCalling(this);">贸易/进出口</li>
		<li class="jobSortTitle" id="_c_2300" onclick="CallingDialog.showCalling(this);">机械/模具/工程/能源</li>
		<li class="jobSortTitle" id="_c_2400" onclick="CallingDialog.showCalling(this);">汽车</li>
		<li class="jobSortTitle" id="_c_2500" onclick="CallingDialog.showCalling(this);">建筑/监理/施工/市政建设</li>
		<li class="jobSortTitle" id="_c_2600" onclick="CallingDialog.showCalling(this);">房地产</li>
		<li class="jobSortTitle" id="_c_2700" onclick="CallingDialog.showCalling(this);">物业管理</li>
		<li class="jobSortTitle" id="_c_2800" onclick="CallingDialog.showCalling(this);">医疗</li>
		<li class="jobSortTitle" id="_c_2900" onclick="CallingDialog.showCalling(this);">生物/制药/医疗器械</li>
		<li class="jobSortTitle" id="_c_3000" onclick="CallingDialog.showCalling(this);">印刷/包装/造纸</li>
		<li class="jobSortTitle" id="_c_3100" onclick="CallingDialog.showCalling(this);">酒店/旅游</li>
		<li class="jobSortTitle" id="_c_3200" onclick="CallingDialog.showCalling(this);">餐饮/娱乐</li>
        <li class="jobSortTitle" id="_c_3300" onclick="CallingDialog.showCalling(this);">化工</li>
		<li class="jobSortTitle" id="_c_3400" onclick="CallingDialog.showCalling(this);">服装/纺织</li>
		<li class="jobSortTitle" id="_c_3500" onclick="CallingDialog.showCalling(this);">教育</li>
		<li class="jobSortTitle" id="_c_3600" onclick="CallingDialog.showCalling(this);">美容/美发/保健/体育</li>
		<li class="jobSortTitle" id="_c_3700" onclick="CallingDialog.showCalling(this);">照明</li>
		<li class="jobSortTitle" id="_c_3800" onclick="CallingDialog.showCalling(this);">矿产/地质勘查/冶金</li>
		<li class="jobSortTitle" id="_c_3900" onclick="CallingDialog.showCalling(this);">造船</li>
		<li class="jobSortTitle" id="_c_4000" onclick="CallingDialog.showCalling(this);">交通运输服务</li>
		<li class="jobSortTitle" id="_c_4100" onclick="CallingDialog.showCalling(this);">物流/仓储</li>
		<li class="jobSortTitle" id="_c_4200" onclick="CallingDialog.showCalling(this);">电力/电源</li>
		<li class="jobSortTitle" id="_c_4300" onclick="CallingDialog.showCalling(this);">艺术/设计</li>
		<li class="jobSortTitle" id="_c_4400" onclick="CallingDialog.showCalling(this);">百货/连锁/零售服务</li>
		<li class="jobSortTitle" id="_c_4500" onclick="CallingDialog.showCalling(this);">律师/法务/合规</li>
		<li class="jobSortTitle" id="_c_4600" onclick="CallingDialog.showCalling(this);">技工</li>
		<li class="jobSortTitle" id="_c_4700" onclick="CallingDialog.showCalling(this);">采购</li>
		<li class="jobSortTitle" id="_c_4800" onclick="CallingDialog.showCalling(this);">翻译</li>
		<li class="jobSortTitle" id="_c_4900" onclick="CallingDialog.showCalling(this);">环保/节能</li>
		<li class="jobSortTitle" id="_c_5000" onclick="CallingDialog.showCalling(this);">农业/养殖</li>
		<li class="jobSortTitle" id="_c_9900" onclick="CallingDialog.showCalling(this);">其它</li>
		</ul>
		<!--地区大类E-->
	</div>
</div>

<div id="_call_child_box" class="popdiv_area2" style="display: none; position: absolute;">
</div>
</div>