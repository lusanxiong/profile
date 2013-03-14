package com.job528.profile.action;

import com.job528.profile.vo.RecommendJob;
import com.job528.util.Pager;
import com.job528.util.StrUtils;

public class RecommendAction extends JobAction {
	
	private Pager<RecommendJob> jobPager;
	
	public String execute() {
		this.delRecommendJob();
		jobPager = applyService.getRecommendMeJobs(this.getUserId(),this.getPage(), 20);
		return this.SUCCESS;
	}

	private void delRecommendJob(){
		String reIds = this.getParameter("reIds");
		if(StrUtils.isNull(reIds))
			return;
		applyService.delRecommendJob(reIds);
	}
	
	public Pager<RecommendJob> getJobPager() {
		return jobPager;
	}

	public void setJobPager(Pager<RecommendJob> jobPager) {
		this.jobPager = jobPager;
	}
}
