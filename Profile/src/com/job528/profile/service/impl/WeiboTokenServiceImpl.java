package com.job528.profile.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import com.job528.common.DataDictionary.WeiboActive;
import com.job528.common.DataDictionary.WeiboService;
import com.job528.ejb.dto.UserWeiboDTO;
import com.job528.ejb.entity.WeiboToken;
import com.job528.ejb.weiboToken.bean.WeiboTokenDao;
import com.job528.profile.service.IWeiboTokenService;
import com.job528.profile.vo.SendWeiboDTO;
import com.job528.profile.vo.UserWeiboInfoDTO;
import com.job528.profile.vo.WeiboOauthDTO;
import com.job528.sina.weibo.Oauth2;
import com.job528.sina.weibo.SinaWeibo;


public class WeiboTokenServiceImpl implements IWeiboTokenService  {
	
	private WeiboTokenDao weiboTokenDao;
	
	@Override
	public int weiboSyn(WeiboToken weiboToken) {
		int status = Integer.parseInt(WeiboActive.ACTIVE_ING.toString());
		weiboToken.setActive(status);
		weiboToken.setTokenSecret("");
		
		int id = 0;
		try {
			id = weiboTokenDao.addWeiboToken(weiboToken);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public int delSynWeibo(int userId, String sinaUserId) {
		return this.weiboTokenDao.delWeiboToken(userId, sinaUserId);
	}
	
	@Override 
	public int delSynWeibo(int id) {
		return this.weiboTokenDao.delWeiboToken(id);
	}

	@Override
	public int pauseSynWeibo(String sinaUserId) {
		if(sinaUserId == null || "".equals(sinaUserId))
			return -1;
		
		int status = Integer.parseInt(WeiboActive.ACTIVE_PAUSE.toString());
		
		int count = 0;
		try {
			count = this.weiboTokenDao.updateWeiboActive(sinaUserId, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public WeiboTokenDao getweiboTokenDao() {
		return weiboTokenDao;
	}
	public void setweiboTokenDao(WeiboTokenDao weiboTokenDao) {
		this.weiboTokenDao = weiboTokenDao;
	}

	@Override
	public int cancelSynWeibo(String sinaUserId) {
		if(sinaUserId == null || "".equals(sinaUserId))
			 return -1;
		int status = Integer.parseInt(WeiboActive.ACTIVE_NO.toString());
		
		int count = 0;
		try {
			count = this.weiboTokenDao.updateWeiboActive(sinaUserId, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean isActvieForUser(String sinaUserId) {
		int userId = 0; //代表不做为查询条件
		
		int count = 0;
		try {
			count = this.weiboTokenDao.getCount(userId, sinaUserId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ( (count == 1) ? true : false );
	}

	@Override
	public int getWeiboTokenInfo(String sinaUserId) {
		if(sinaUserId == null || "".equals(sinaUserId))
			return 0;
		
		WeiboToken wt = new WeiboToken();
		wt.setSinaUserId(sinaUserId);
		
		WeiboToken weiboToken = null;
		try {
			weiboToken = weiboTokenDao.getWeiboTokenInfo(wt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(weiboToken == null || weiboToken.getUserId() == null) {
			return 0;
		} 
		
		return weiboToken.getUserId();
	}

	@Override
	public void sendSinaWeibo(SendWeiboDTO sendWeiboDTO) {
		
		//如果同步状态不是“正在同步中”则不需发送到其新浪微博
		if(sendWeiboDTO.getWeiboActive() != Integer.parseInt(WeiboActive.ACTIVE_ING.toString())) {
			return;
		}
		
		SinaWeibo sw = new SinaWeibo();
		sw.setAccess_token(sendWeiboDTO.getAccessToken());
		sw.setStatus(sendWeiboDTO.getContent());
		
		try {
			sw.sendWeibo();
		} catch (Exception e) {
			//e.printStackTrace();
			
			//此异常代表用户在新浪平台下已经取消了528网站的授权。重置该用户的微博同步状态
			this.cancelSynWeibo(sendWeiboDTO.getSinaUserId());
		}
	}
	
	public static void main(String[] args) {
		
		SinaWeibo sw = new SinaWeibo();
		//2.00Ma5eEDcnW4lC5ab2447a9262IjeE
		sw.setAccess_token("2.00Ma5eEDcnW4lC5ab2447a9262IjeE");
		sw.setStatus("test1234dfdfdfdfdfd50911");
		try {
			sw.sendWeibo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*String text = "我发的第N条微博，";
		int len = statictisWeiboLength(text);
		System.out.println("len==="+len);*/
	}

	@Override
	public WeiboOauthDTO getWeiboOauthInfo(String code) {
		WeiboOauthDTO dto = Oauth2.getAccessTokenByCode(code);
		return dto;
	}

	@Override
	public List<UserWeiboInfoDTO> getUserWeiboInfoList(int userId) {
		List<UserWeiboInfoDTO> result = new ArrayList<UserWeiboInfoDTO>(2);
		if(userId <= 0) {
			return result;
		}
		
		List<UserWeiboDTO> list = null;
		try {
			list = weiboTokenDao.getUserWeiboList(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list==null || list.size()==0) {
			return getDefaultUserWeiboInfo(); 
		}
		
		result = new ArrayList<UserWeiboInfoDTO>(2);
		for(UserWeiboDTO dto : list) {
			if(dto == null) continue;

			UserWeiboInfoDTO weiboDto = new UserWeiboInfoDTO();
			
			weiboDto.setActive(dto.getActive());
			weiboDto.setActiveName(WeiboActive.getName(dto.getActive()));
			weiboDto.setUpdateTime(dto.getUpdateTime());
			weiboDto.setUserId(dto.getUserId());
			weiboDto.setWeiboServiceName(WeiboService.getName(dto.getWeiboServiceType()));
			weiboDto.setWeiboServiceType(dto.getWeiboServiceType());
			weiboDto.setWeiboUserId(dto.getWeiboUserId());
			
			//新浪微博图标
			if(dto.getWeiboServiceType() == Integer.parseInt(WeiboService.SINA_WEIBO.toString())) {
				weiboDto.setWeiboServicePhoto("tb_sina.gif");
			}
			
			//腾讯微博图标
			if(dto.getWeiboServiceType() == Integer.parseInt(WeiboService.TENCENT_WEIBO.toString())) {
				weiboDto.setWeiboServicePhoto("tb_qq.gif");
			}
			
			result.add(weiboDto);
		}
		
		//如果用户只同步了一个微博服务商
		if(list.size() == 1) {
			UserWeiboInfoDTO weiboDto = new UserWeiboInfoDTO();
			int active = Integer.parseInt(WeiboActive.ACTIVE_NO.toString());
			weiboDto.setActive(active);
			weiboDto.setActiveName(WeiboActive.getName(active));
			
			int weiboServiceType = list.get(0).getWeiboServiceType();
			if(weiboServiceType == Integer.parseInt(WeiboService.SINA_WEIBO.toString())) {
				weiboDto.setWeiboServiceType(Integer.parseInt(WeiboService.TENCENT_WEIBO.toString()));
				weiboDto.setWeiboServicePhoto("tb_qq.gif");
			}else {
				weiboDto.setWeiboServiceType(Integer.parseInt(WeiboService.SINA_WEIBO.toString()));
				weiboDto.setWeiboServicePhoto("tb_sina.gif");
			}
			result.add(weiboDto);
		}
		
		result = sortWeiboService(result);
		return result;
	}
	
	public List<UserWeiboInfoDTO>  sortWeiboService(List<UserWeiboInfoDTO> list) {
		Collections.sort(list, 
				new Comparator<UserWeiboInfoDTO>()  {
					public int compare(UserWeiboInfoDTO u1, UserWeiboInfoDTO u2) {
						int value = u1.getWeiboServiceType()-u2.getWeiboServiceType();
						return value;
					}}
		);
		
		return list;
	}
	
	/**
	 * 获取用户默认的微博同步信息
	 */
	private List<UserWeiboInfoDTO> getDefaultUserWeiboInfo() {
		List<UserWeiboInfoDTO> result = new ArrayList<UserWeiboInfoDTO>(2);
		
		for(int i=0; i<2; i++) {
			UserWeiboInfoDTO weiboDto = new UserWeiboInfoDTO();
			
			int active = Integer.parseInt(WeiboActive.ACTIVE_NO.toString());
			weiboDto.setActive(active);
			weiboDto.setActiveName(WeiboActive.getName(active));
			
			//新浪微博
			if(i == 0) {
				weiboDto.setWeiboServiceType(Integer.parseInt(WeiboService.SINA_WEIBO.toString()));
				weiboDto.setWeiboServicePhoto("tb_sina.gif");
			}
			
			//腾讯微博
			if(i == 1) {
				weiboDto.setWeiboServiceType(Integer.parseInt(WeiboService.TENCENT_WEIBO.toString()));
				weiboDto.setWeiboServicePhoto("tb_qq.gif");
			}
			
			result.add(weiboDto);
		}
		
		return result;
	}

	@Override
	public int weiboSynUpdate(String sinaUserId, String accessToken) {
		if(sinaUserId==null || sinaUserId.equals(""))
			return 0;
		
		if(accessToken==null || accessToken.equals(""))
			return 0;
		
		WeiboToken w = new WeiboToken();
		w.setToken(accessToken);
		w.setSinaUserId(sinaUserId);
		
		int id = 0;
		try {
			id = weiboTokenDao.updateWeiboSyn(w);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public int recoverSynWeibo(String sinaUserId) {
		if(sinaUserId == null || "".equals(sinaUserId))
			return -1;
		
		int status = Integer.parseInt(WeiboActive.ACTIVE_ING.toString());
		
		int count = 0;
		try {
			count = this.weiboTokenDao.updateWeiboActive(sinaUserId, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
