package com.job528.admin.label.action;

import java.util.List;

import com.googlecode.jsonplugin.annotations.JSON;
import com.job528.admin.label.common.DataDictionaryAdmin.ActionResult;
import com.job528.admin.label.common.DataDictionaryAdmin.LabelSourceType;
import com.job528.admin.label.service.IAdminLabelService;
import com.job528.admin.label.vo.ExecuteResult;
import com.job528.ejb.admin.dto.LabelDTO;
import com.job528.ejb.entity.Label;
import com.job528.util.Pager;
import com.job528.util.webwork.GenericAction;

public class AdminLabelAction extends GenericAction {
	private static final long serialVersionUID = 1L;

	private IAdminLabelService adminLabelService;
	private Pager<List<LabelDTO>> labelList;
	private String labelType; // 标签来源分类
	private int labelId; // 标签ID
	private ExecuteResult er;
	private boolean iFlag;
    private int count;
	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	/**
	 * 查询标签
	 */
	@SuppressWarnings("unchecked")
	public String getLabelInfo() {
		String pageSizeStr = request.getParameter("pageSize");// 页面传过来的分页大小
		int pageSize = (pageSizeStr != null && !pageSizeStr.equals("") ? Integer.parseInt(pageSizeStr): 15);// 现在写死了每页10条记录
		int type = 0;
		if (labelType == null || labelType.equals("")) {
			type = Integer.parseInt(LabelSourceType.ALL_LABEL.toString()); // 默认查询所用标签用户
		} else {
			type = Integer.parseInt(labelType);
		}
		labelList = adminLabelService.getLabelInfo(this.getPage(), pageSize,
				type);
		if (labelList == null) {
			labelList = new Pager();
			return SUCCESS;
		}
		labelList.setPageNo(this.getPage());
		labelList.setPageSize(pageSize);
		return SUCCESS;
	}
    
	
	public String addLabel(){
		String labelName = request.getParameter("labelName");
		String labelSort = request.getParameter("labelSort");
		String labelSource = request.getParameter("labelSource");
		String isDisplay = request.getParameter("isDisplay");
		int order=0;
		if(null==labelSort||"".equals(labelSort)){
			order = 100;
		}else{
			order = Integer.parseInt(labelSort);
		}
		
		Label label = new Label();
		label.setLabelName(labelName);
		label.setLabelSort(order);
		label.setLabelSource(Integer.parseInt(labelSource));
		label.setIsDisplay(Integer.parseInt(isDisplay));
		count = adminLabelService.saveSysLabel(label);
		return ActionResult.JSON_SUCCESS.toString();
	}
	/**
	 * 删除标签
	 *//*
	public String delLabel() {
		labelId = Integer.parseInt(request.getParameter("labelId"));
		if (labelId <= 0) {
			er = new ExecuteResult(false, "参数错不能为空", "");
			return ActionResult.JSON_SUCCESS.toString();
		}

		boolean flag = adminLabelService.delLabel(labelId);
		if (flag) {
			er = new ExecuteResult(true, "删除标签成功!", "");
		} else {
			er = new ExecuteResult(false, "删除标签失败!", "");
		}

		return ActionResult.JSON_SUCCESS.toString();
	}
 */
	/**
	 * 
	 * 批量删除标签
	 */
	public String delBatchLabel(){
		String labelIdStr = request.getParameter("labelIdStr");
		if (null == labelIdStr || "".equals(labelIdStr)) {
			return ActionResult.JSON_SUCCESS.toString();
		}
		boolean flag=adminLabelService.delBacthLabel(labelIdStr);
		if (flag) {
			er = new ExecuteResult(true, "删除标签成功!", "");
		} else {
			er = new ExecuteResult(false, "删除标签失败!", "");
		}
		return ActionResult.JSON_SUCCESS.toString();
	}
	public String updateLabel() {
		labelId = Integer.parseInt(request.getParameter("labelId"));
		String labelName = request.getParameter("labelName");
		Integer labelSort = Integer.parseInt(request.getParameter("labelSort"));
		Integer labelSource = Integer.parseInt(request
				.getParameter("labelSource"));
		Integer isDisplay = Integer.parseInt(request.getParameter("isDisplay"));
		if (null == labelName || "".equals(labelName)) {
			return ActionResult.JSON_SUCCESS.toString();
		}
		if (labelSort < 0) {
			return ActionResult.JSON_SUCCESS.toString();
		}
		Label label = new Label();
		label.setLabelName(labelName);
		label.setLabelSort(labelSort);
		label.setLabelSource(labelSource);
		label.setIsDisplay(isDisplay);
		iFlag = adminLabelService.updateLabel(label, labelId);
		return ActionResult.JSON_SUCCESS.toString();
	}

	public String getLabelType() {
		return labelType;
	}

	public void setLabelType(String labelType) {
		this.labelType = labelType;
	}

	@JSON(serialize = false)
	public Pager<List<LabelDTO>> getLabelList() {
		return labelList;
	}

	public void setLabelList(Pager<List<LabelDTO>> labelList) {
		this.labelList = labelList;
	}

	@JSON(serialize = false)
	public IAdminLabelService getAdminLabelService() {
		return adminLabelService;
	}

	public void setAdminLabelService(IAdminLabelService adminLabelService) {
		this.adminLabelService = adminLabelService;
	}

	public int getLabelId() {
		return labelId;
	}

	@JSON(name = "result")
	public ExecuteResult getEr() {
		return er;
	}

	public void setEr(ExecuteResult er) {
		this.er = er;
	}

	public void setLabelId(int labelId) {
		this.labelId = labelId;
	}

	public boolean isiFlag() {
		return iFlag;
	}

	public void setiFlag(boolean iFlag) {
		this.iFlag = iFlag;
	}

}
