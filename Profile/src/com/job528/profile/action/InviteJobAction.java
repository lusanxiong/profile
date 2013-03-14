package com.job528.profile.action;

import com.job528.profile.vo.ApplyJob;
import com.job528.util.Pager;
import com.job528.util.StrUtils;

public class InviteJobAction extends JobAction {
	
	private Pager<ApplyJob> appPage;
	
	public String execute() {
		
		delInviteJob();
		
		int resId = this.getLoginResume().getMyResume().getResId();
		appPage = applyService.getUserInviteJobPagerByResId(resId, this.getPage(), 20);
		return this.SUCCESS;
	}
	
	private void delInviteJob(){
		String ids = this.getParameter("inIds");
		if(StrUtils.isNull(ids))
			return;
		applyService.delInviteJob(ids);
	}
	
	public Pager<ApplyJob> getAppPage() {
		return appPage;
	}
	
	public void setAppPage(Pager<ApplyJob> appPage) {
		this.appPage = appPage;
	}
}
