package com.job528.profile.action;

import com.job528.profile.service.IApplyService;

public class JobAction extends ResumeAction {
	protected IApplyService applyService;
	public IApplyService getApplyService() {
		return applyService;
	}
	public void setApplyService(IApplyService applyService) {
		this.applyService = applyService;
	}
}
