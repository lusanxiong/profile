package com.job528.profile.action;

import com.job528.profile.vo.Favouriate;
import com.job528.util.Pager;
import com.job528.util.StrUtils;

public class FavouriateJobAction extends JobAction {
	
	private Pager<Favouriate> favPager = new Pager<Favouriate>();
	public String execute() {
		delFavouriateJobs();
		favPager = applyService.getFavouriateJobs(this.getUserId(), this.getPage(), 20);
		return this.SUCCESS;
	}
	
	
	private void delFavouriateJobs(){
		String favIds = this.getParameter("favIds");
		if(StrUtils.isNull(favIds))
			return;
		applyService.delFavouriateJobs(favIds);
	}
	
	public Pager<Favouriate> getFavPager() {
		return favPager;
	}
	public void setFavPager(Pager<Favouriate> favPager) {
		this.favPager = favPager;
	}	
}
