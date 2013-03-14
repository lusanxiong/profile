package com.job528.profile.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.job528.ejb.dto.UserAccessHistoryDTO;
import com.job528.ejb.entity.UserAccessHistory;
import com.job528.ejb.userAccessHistory.bean.UserAccessHistoryDao;
import com.job528.profile.service.IUserAccessHistoryService;
import com.job528.profile.util.JobUtil;
import com.job528.profile.vo.ExecuteResult;
import com.job528.profile.vo.UserAccessHistoryInfoDTO;
import com.job528.util.AreaUtil;

public class UserAccessHistoryServiceImpl implements IUserAccessHistoryService {
	private UserAccessHistoryDao userAccessHistoryDao;

	@Override
	public ExecuteResult addUserAccessHistory(UserAccessHistory u) {
		if(u.getAccessUserId() <= 0 || u.getUserId() <=0) {
			return new ExecuteResult(false,"参数错误","");
		}
		
		//如果访问者与被访问用户是同一用户
		if( (u.getUserId()>0) && (u.getAccessUserId()==u.getUserId()) ) {
			return new ExecuteResult(false,"访问者与被访问者为同一用户.","");
		}
		
		try {
			userAccessHistoryDao.addUserAccessHistory(u);
		}catch(Exception e) {
			e.printStackTrace();
			return new ExecuteResult(false,"记录用户访问历史失败","");
		}
		return new ExecuteResult(true,"记录用户访问历史成功","");
	}

	public UserAccessHistoryDao getUserAccessHistoryDao() {
		return userAccessHistoryDao;
	}

	public void setUserAccessHistoryDao(UserAccessHistoryDao userAccessHistoryDao) {
		this.userAccessHistoryDao = userAccessHistoryDao;
	}

	@Override
	public List<UserAccessHistoryInfoDTO> getUserAccessHistoryInfo(int userid) {
		if(userid <=0 ) return null;
		
		int findCount = 6;//查询多少个好友看过我
		List<UserAccessHistoryDTO> list = userAccessHistoryDao.getUserAccessHistory(userid, findCount);
		if(list==null || list.size()==0) return null;
		
		List<UserAccessHistoryInfoDTO> result = new ArrayList<UserAccessHistoryInfoDTO>(list.size());
		for(UserAccessHistoryDTO u : list) {
			if(u == null) continue;
			
			UserAccessHistoryInfoDTO dto = new UserAccessHistoryInfoDTO();
			dto.setAccessDate(u.getAccessDate());
			dto.setAccessUserId(u.getAccessUserId());
			dto.setAccessUserJobFunctionId(u.getAccessUserJobFunctionId());
			
			//职务名称
			dto.setAccessUserPost( JobUtil.getJobById(String.valueOf(u.getAccessUserJobFunctionId())) );
			
			dto.setAccessUserName(u.getAccessUserName());
			dto.setNowPlaceId(u.getNowPlaceId());
			dto.setNowPlaceName(AreaUtil.getPCAById(u.getNowPlaceId().toString()));
			
			String photo = u.getPhoto();
			if(photo==null || "".equals(photo)) {
				photo = "/images/people.gif"; //默认头像
			}
			dto.setPhoto(photo);
			
			result.add(dto);
		}
		return result;
	}
	

}
