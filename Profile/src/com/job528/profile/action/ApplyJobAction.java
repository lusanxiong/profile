package com.job528.profile.action;


import com.job528.profile.vo.ApplyJob;
import com.job528.util.Pager;
import com.job528.util.StrUtils;

public class ApplyJobAction extends JobAction {
	
	private Pager<ApplyJob> appPage;
	public String execute() {
		delete();	
		int resId = this.getLoginResume().getMyResume().getResId();
		appPage = applyService.getApplyJobByResId(resId, this.getPage(),20);
		return this.SUCCESS;
	}

	
	private void delete(){
		String appIds = this.getParameter("appIds");
		if(StrUtils.isNull(appIds))return;
		applyService.delUserApplyJobByIds(appIds);
	}


	public Pager<ApplyJob> getAppPage() {
		return appPage;
	}


	public void setAppPage(Pager<ApplyJob> appPage) {
		this.appPage = appPage;
	}
	
}
