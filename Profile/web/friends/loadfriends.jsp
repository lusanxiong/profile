<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<input type="hidden" id="recommendPosId" />
<input type="hidden" id="recommendMemId" />
<div class="serch_job_box" id="divRecommend"
	style="background-color: #fff; display: none;">
	<div class="serch_job_up"></div>
	<div class="serch_job_cr">
		<div class="serch_job">
			<div class="top">
				<ul>
					<li>
						<h1>我的粉丝</h1>
					</li>
					
				</ul>
				<span><a href="javascript:void(0);" onclick="$.unblockUI();"><img
							src="${basePath}/images/tm_block.gif" width="19" height="19" />
				</a>
				</span>
			</div>
			<div class="down" id="divFriends">
				<img src="${basePath}/images/loading.gif" alt="正在加载数据"
					style="margin-top: 5px; margin-buttom: 5px;" />
			</div>
			<div class="clear"></div>
			<div class="fenye">
				<div class="left">
					<span><img src="${basePath}/biaoqing/3.gif"/>
					</span><span style="width: 100px;" id="spReMsg">请选择粉丝！</span>
				</div>
				<div class="right">
					<ul>
						
						<li onclick="recommendJob();">
							推 荐
						</li>
						<li id="liMoreFrd" >
							更 多
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="serch_job_dw"></div>
</div>
