package com.job528.profile.action;

import com.job528.profile.service.IPositionService;
import com.job528.profile.vo.Position;
import com.job528.util.Pager;

/**
 *@author tanggh
 */
public class CompleteAction extends ResumeAction{
	private static final long serialVersionUID = 1L;
	private Pager<Position> positionPager;
	private IPositionService positionService;

	@Override
	public String execute() throws Exception {
		if(!isLogin()){
			return LOGIN;
		}
		positionPager = positionService.getIntentionPosition(getLoginResume(),1,10);
		if(positionPager.getList() == null){
			positionPager = positionService.getSimpleIntentionPosition(this.getLoginResume(), 1, 10);
		}
		return SUCCESS;
	}

	public Pager<Position> getPositionPager() {
		return positionPager;
	}

	public void setPositionPager(Pager<Position> positionPager) {
		this.positionPager = positionPager;
	}

	public void setPositionService(IPositionService positionService) {
		this.positionService = positionService;
	}
	
}
