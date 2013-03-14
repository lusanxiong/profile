package com.job528.profile.action.recommendPosition;

import java.util.HashMap;
import java.util.Map;


import com.googlecode.jsonplugin.annotations.JSON;
import com.job528.profile.model.RecommendPosition;
import com.job528.profile.service.IRecommendPositionService;
import com.job528.profile.vo.ExecuteResult;
import com.job528.util.BeanUtil;
import com.job528.util.webwork.GenericAction;
import com.opensymphony.xwork2.Action;

/**
 * 向站内好友推荐职位
 * @author lusanxiong
 *
 */
public class RecommendPostionToFriendAction extends GenericAction {
	private static final long serialVersionUID = 1L;
	private ExecuteResult er;
	
	private IRecommendPositionService recommendPositionService;
	
	/**
	 * 推荐职位给站内好友
	 * 
	 * @return json格式信息
	 */
	public String recommendPositionToFriend() {
		String recommendTargetUsersId = request.getParameter("recommendTargetUsersId");
		if(recommendTargetUsersId == null || "".equals(recommendTargetUsersId))
			return "";
		
		System.out.println("test=="+recommendTargetUsersId);
		String[] usersId = recommendTargetUsersId.split(";");
		int[] targetUsersId = new int[usersId.length]; 
		for(int i=0; i<usersId.length; i++) {
			targetUsersId[i] = Integer.parseInt(usersId[i]);
		}
		
		RecommendPosition rp = new RecommendPosition();
		BeanUtil.setObjectFromRequest(request, rp);
		//PrintBean.PrintBeanProperty(rp);
		System.out.println("job name==="+rp.getRecommendJobName());
		er = recommendPositionService.recommendPosition(targetUsersId, rp);
		
		return Action.SUCCESS;
	}
	
	@JSON(serialize=false)
	public IRecommendPositionService getRecommendPositionService() {
		return recommendPositionService;
	}

	public void setRecommendPositionService(
			IRecommendPositionService recommendPositionService) {
		this.recommendPositionService = recommendPositionService;
	}

	@JSON(name="result")
	public ExecuteResult getEr() {
		return er;
	}

	public void setEr(ExecuteResult er) {
		this.er = er;
	}

	public static void main(String[] args) {
		
	}
}
