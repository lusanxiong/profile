<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<div style="position:relative;z-index:500; display:none">
<div class="popdiv" id="_add_box" style="display: none;">
	<div class="popdiv_top">
		<h1>
			请选择地点(您最多选择<b id="_add_apt_count">3</b>项)
		</h1>
		<div class="popdiv_fun">
			<a href="javascript:void(0);" id="_add_box_ok">确定</a>
		</div>
	</div>
	<div class="popdiv_con">
		<!--以选择地区S-->
		<div class="popdiv_selectedAreaTitle">
			已选择城市
		</div>
		<ul class="popdiv_selectedArea" id="_add_selected_ul">
			
		</ul>
		<div>
			<p class="popdiv_areaTitle">
				主要城市
			</p>
			<ul class="main_city">
				<li>
					<b class="city_letter">B</b>
					<a href="javascript:void(0);" id="_l_0100" class="city_city" onclick="AddressDialog.showArea(this);">北京</a>
					<a href="javascript:void(0);" id="_l_2804" class="city_city" onclick="AddressDialog.showArea(this);">包头市</a>
				</li>
				<li>
					<b class="city_letter">C</b>
					<a href="javascript:void(0);" id="_l_0600" class="city_city" onclick="AddressDialog.showArea(this);">重庆</a>
					<a href="javascript:void(0);" id="_l_0705" class="city_city" onclick="AddressDialog.showArea(this);">常州市</a>
					<a href="javascript:void(0);" id="_l_0902" class="city_city" onclick="AddressDialog.showArea(this);">成都市</a>
					<a href="javascript:void(0);" id="_l_1902" class="city_city" onclick="AddressDialog.showArea(this);">长沙市</a>
					<a href="javascript:void(0);" id="_l_2402" class="city_city" onclick="AddressDialog.showArea(this);">长春市</a>
					<a href="javascript:void(0);" id="_l_2803" class="city_city" onclick="AddressDialog.showArea(this);">赤峰市</a>
				</li>
				<li>
					<b class="city_letter">D</b>
					<a href="javascript:void(0);" id="_l_0308" class="city_city" onclick="AddressDialog.showArea(this);">东莞市</a>
					<a href="javascript:void(0);" id="_l_2303" class="city_city" onclick="AddressDialog.showArea(this);">大连市</a>
				</li>
				<li>
					<b class="city_letter">F</b>
					<a href="javascript:void(0);" id="_l_0306" class="city_city" onclick="AddressDialog.showArea(this);">佛山市</a>
					<a href="javascript:void(0);" id="_l_1102" class="city_city" onclick="AddressDialog.showArea(this);">福州市</a>
				</li>
				<li>
					<b class="city_letter">G</b>
					<a href="javascript:void(0);" id="_l_030200" class="city_city" onclick="AddressDialog.showArea(this);">广州市</a>
					<a href="javascript:void(0);" id="_l_2602" class="city_city" onclick="AddressDialog.showArea(this);">贵阳市</a>
				</li>
				<li>
					<b class="city_letter">H</b>
					<a href="javascript:void(0);" id="_l_0802" class="city_city" onclick="AddressDialog.showArea(this);">杭州市</a>
					<a href="javascript:void(0);" id="_l_1002" class="city_city" onclick="AddressDialog.showArea(this);">海口市</a>
					<a href="javascript:void(0);" id="_l_1502" class="city_city" onclick="AddressDialog.showArea(this);">合肥市</a>
					<a href="javascript:void(0);" id="_l_2202" class="city_city" onclick="AddressDialog.showArea(this);">哈尔滨市</a>
					<a href="javascript:void(0);" id="_l_2802" class="city_city" onclick="AddressDialog.showArea(this);">呼和浩特市</a>
				</li>
				<li>
					<b class="city_letter">J</b>
					<a href="javascript:void(0);" id="_l_1202" class="city_city" onclick="AddressDialog.showArea(this);">济南市</a>
					<a href="javascript:void(0);" id="_l_2403" class="city_city" onclick="AddressDialog.showArea(this);">吉林市</a>
					<a href="javascript:void(0);" id="_l_0806" class="city_city" onclick="AddressDialog.showArea(this);">金华市</a>
					<a href="javascript:void(0);" id="_l_0807" class="city_city" onclick="AddressDialog.showArea(this);">嘉兴市</a>
				</li>
				<li>
					<b class="city_letter">K</b>
					<a href="javascript:void(0);" id="_l_2502" class="city_city" onclick="AddressDialog.showArea(this);">昆明市</a>
					<a href="javascript:void(0);" id="_l_0706" class="city_city" onclick="AddressDialog.showArea(this);">昆山市</a>
				</li>
				<li>
					<b class="city_letter">L</b>
					<a href="javascript:void(0);" id="_l_2702"  class="city_city" onclick="AddressDialog.showArea(this);">兰州市</a>
				</li>
				<li>
					<b class="city_letter">N</b>
					<a href="javascript:void(0);" id="_l_0702"  class="city_city" onclick="AddressDialog.showArea(this);">南京市</a>
					<a href="javascript:void(0);" id="_l_0803"  class="city_city" onclick="AddressDialog.showArea(this);">宁波市</a>
					<a href="javascript:void(0);" id="_l_1302"  class="city_city" onclick="AddressDialog.showArea(this);">南昌市</a>
					<a href="javascript:void(0);" id="_l_1402"  class="city_city" onclick="AddressDialog.showArea(this);">南宁市</a>
					<a href="javascript:void(0);" id="_l_0709"  class="city_city" onclick="AddressDialog.showArea(this);">南通市</a>
				</li>
				<li>
					<b class="city_letter">Q</b>
					<a href="javascript:void(0);" id="_l_1203"  class="city_city" onclick="AddressDialog.showArea(this);">青岛市</a>
					<a href="javascript:void(0);" id="_l_1104"  class="city_city" onclick="AddressDialog.showArea(this);">泉州市</a>
				</li>
				<li>
					<b class="city_letter">S</b>
					<a href="javascript:void(0);" id="_l_0200" class="city_city" onclick="AddressDialog.showArea(this);">上海</a>
					<a href="javascript:void(0);" id="_l_031100" class="city_city" onclick="AddressDialog.showArea(this);">深圳</a>
					<a href="javascript:void(0);" id="_l_0703" class="city_city" onclick="AddressDialog.showArea(this);">苏州市</a>
					<a href="javascript:void(0);" id="_l_1602" class="city_city" onclick="AddressDialog.showArea(this);">石家庄市</a>
					<a href="javascript:void(0);" id="_l_2302" class="city_city" onclick="AddressDialog.showArea(this);">沈阳市</a>
					<a href="javascript:void(0);" id="_l_0805" class="city_city" onclick="AddressDialog.showArea(this);">绍兴市</a>
					<a href="javascript:void(0);" id="_l_1003" class="city_city" onclick="AddressDialog.showArea(this);">三亚市</a>
				</li>
				<li>
					<b class="city_letter">T</b>
					<a href="javascript:void(0);" id="_l_0500" class="city_city" onclick="AddressDialog.showArea(this);">天津</a>
					<a href="javascript:void(0);" id="_l_2102" class="city_city" onclick="AddressDialog.showArea(this);">太原市</a>
					<a href="javascript:void(0);" id="_l_0808" class="city_city" onclick="AddressDialog.showArea(this);">台州市</a>
				</li>
				<li>
					<b class="city_letter">W</b>
					<a href="javascript:void(0);" id="_l_0704" class="city_city" onclick="AddressDialog.showArea(this);">无锡市</a>
					<a href="javascript:void(0);" id="_l_0804" class="city_city" onclick="AddressDialog.showArea(this);">温州市</a>
					<a href="javascript:void(0);" id="_l_1802" class="city_city" onclick="AddressDialog.showArea(this);">武汉市</a>
					<a href="javascript:void(0);" id="_l_3102" class="city_city" onclick="AddressDialog.showArea(this);">乌鲁木齐市</a>
				</li>
				<li>
					<b class="city_letter">X</b>
					<a href="javascript:void(0);" id="_l_1103" class="city_city" onclick="AddressDialog.showArea(this);">厦门市</a>
					<a href="javascript:void(0);" id="_l_2002" class="city_city" onclick="AddressDialog.showArea(this);">西安市</a>
					<a href="javascript:void(0);" id="_l_0711" class="city_city" onclick="AddressDialog.showArea(this);">徐州市</a>
				</li>
				<li>
					<b class="city_letter">Y</b>
					<a href="javascript:void(0);" id="_l_1204" class="city_city" onclick="AddressDialog.showArea(this);">烟台市</a>
					<a href="javascript:void(0);" id="_l_0708" class="city_city" onclick="AddressDialog.showArea(this);">扬州市</a>
				</li>
				<li>
					<b class="city_letter">Z</b>
					<a href="javascript:void(0);" id="_l_0305" class="city_city" onclick="AddressDialog.showArea(this);">珠海市</a>
					<a href="javascript:void(0);" id="_l_0307" class="city_city" onclick="AddressDialog.showArea(this);">中山市</a>
					<a href="javascript:void(0);" id="_l_1702" class="city_city" onclick="AddressDialog.showArea(this);">郑州市</a>
					<a href="javascript:void(0);" id="_l_0710" class="city_city" onclick="AddressDialog.showArea(this);">镇江市</a>
					<a href="javascript:void(0);" id="_l_1105" class="city_city" onclick="AddressDialog.showArea(this);">漳州市</a>
				</li>
			</ul>
		</div>
		<!--以选择地区E-->
		<!--地区大类S-->
		<div class="popdiv_areaTitle">
			所有省份
		</div>
		<ul class="popdiv_area1">
			<li class="area">
				A-G
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city" id="_l_0300" onclick="AddressDialog.showArea(this);">广东</a>
			</li>
			<li >
				<a href="javascript:void(0);" class="city_city" id="_l_1100" onclick="AddressDialog.showArea(this);">福建</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_1400" onclick="AddressDialog.showArea(this);">广西</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city" id="_l_1500" onclick="AddressDialog.showArea(this);">安徽</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city" id="_l_2600" onclick="AddressDialog.showArea(this);">贵州</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city" id="_l_2700" onclick="AddressDialog.showArea(this);">甘肃</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city" id="_l_3400" onclick="AddressDialog.showArea(this);">澳门</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_3600" onclick="AddressDialog.showArea(this);">国外</a>
			</li>
		</ul>
		<ul class="popdiv_area1">
			<li class="area">
				H-J
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_0700"  onclick="AddressDialog.showArea(this);">江苏</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_1000" onclick="AddressDialog.showArea(this);">海南</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_1300" onclick="AddressDialog.showArea(this);">江西</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_1600" onclick="AddressDialog.showArea(this);">河北</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_1700" onclick="AddressDialog.showArea(this);">河南</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_1800" onclick="AddressDialog.showArea(this);">湖北</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_1900" onclick="AddressDialog.showArea(this);">湖南</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_2200" onclick="AddressDialog.showArea(this);">黑龙江</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_2400" onclick="AddressDialog.showArea(this);">吉林</a>
			</li>
		</ul>
		<ul class="popdiv_area1">
			<li class="area">
				L-S
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_0900" onclick="AddressDialog.showArea(this);">四川</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_1200" onclick="AddressDialog.showArea(this);">山东</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_2000" onclick="AddressDialog.showArea(this);">陕西</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_2100" onclick="AddressDialog.showArea(this);">山西</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_2300" onclick="AddressDialog.showArea(this);">辽宁</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_2800" onclick="AddressDialog.showArea(this);">内蒙古</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_2900" onclick="AddressDialog.showArea(this);">宁夏</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_3200" onclick="AddressDialog.showArea(this);">青海</a>
			</li>
		</ul>
		<ul class="popdiv_area1">
			<li class="area">
				T-Z
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city" id="_l_0800" onclick="AddressDialog.showArea(this);">浙江</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_2500" onclick="AddressDialog.showArea(this);">云南</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_3000" onclick="AddressDialog.showArea(this);">西藏</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_3100" onclick="AddressDialog.showArea(this);">新疆</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_3300" onclick="AddressDialog.showArea(this);">香港</a>
			</li>
			<li>
				<a href="javascript:void(0);" class="city_city"  id="_l_3500" onclick="AddressDialog.showArea(this);">台湾</a>
			</li>
		</ul>
		<!--地区大类E-->
	</div>
</div>

<div id="_add_child_box" class="popdiv_area2" style="display: none; position: absolute;">
</div>
</div>