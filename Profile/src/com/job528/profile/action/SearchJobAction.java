package com.job528.profile.action;

import com.job528.lucene.bean.Condition;
import com.job528.profile.service.IApplyService;
import com.job528.profile.service.IPositionService;
import com.job528.profile.util.JobUtil;
import com.job528.profile.vo.Position;
import com.job528.util.Pager;


public class SearchJobAction extends ResumeAction {

	private IPositionService positionService;
	private IApplyService applyService;
	private Pager<Position> positionPager = new Pager<Position>();
	
	public String execute() {

		Condition condition = new Condition();
		condition = JobUtil.convertRequest2Condition(condition, request);
		int page = this.getParameter("pageNo") != null ? Integer.parseInt(this
				.getParameter("pageNo").toLowerCase()) : 1;
		int pageSize = this.getParameter("pageSize") != null ? Integer
				.parseInt(this.getParameter("pageSize").toLowerCase()) : 30;

		positionPager = positionService.getPositionByCondition(condition, page,
				pageSize);
		return SUCCESS;
	}

	
	
	
	
	public Pager<Position> getPositionPager() {
		return positionPager;
	}

	public void setPositionPager(Pager<Position> positionPager) {
		this.positionPager = positionPager;
	}

	public IApplyService getApplyService() {
		return applyService;
	}

	public void setApplyService(IApplyService applyService) {
		this.applyService = applyService;
	}


	public IPositionService getPositionService() {
		return positionService;
	}


	public void setPositionService(IPositionService positionService) {
		this.positionService = positionService;
	}
	
	
}
