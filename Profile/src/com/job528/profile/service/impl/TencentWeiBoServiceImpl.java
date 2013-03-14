package com.job528.profile.service.impl;

import com.job528.common.DataDictionary.WeiboActive;
import com.job528.ejb.entity.TencentToken;
import com.job528.ejb.tencentToken.bean.TencentTokenDao;
import com.job528.profile.service.ITencentWeiBoService;
import com.job528.profile.vo.TencentVo;
import com.job528.tencent.weibo.TencentWeiBo;
public class TencentWeiBoServiceImpl implements ITencentWeiBoService {
    private TencentTokenDao  tencentTokenDao;
	public TencentTokenDao getTencentTokenDao() {
		return tencentTokenDao;
	}

	public void setTencentTokenDao(TencentTokenDao tencentTokenDao) {
		this.tencentTokenDao = tencentTokenDao;
	}

	@Override
	public Integer addTencentToken(TencentToken tencentToken) {
		tencentToken.setActive(Integer.parseInt(WeiboActive.ACTIVE_ING.toString()));
		return tencentTokenDao.addTencentToken(tencentToken);
	}

	@Override
	public Integer deleteTencentWeiBo(int userId, String openId) {
	
		return tencentTokenDao.deleteTencentWeiBo(userId, openId);
	}


	@Override
	public int getUserIdByOpenid(String openId) {
		if(openId==null|| "".equals(openId)){
			return 0;
		}
		return tencentTokenDao.getUserIdByOpenid(openId);
	}

	@Override
	public void sendTencentWeibo(TencentVo tv) {
		if(tv.getActive()!=Integer.parseInt(WeiboActive.ACTIVE_ING.toString())){
			//不是同步中的不能发微博
			return;
		}		
		new TencentWeiBo(tv).start();
		
		
	}

	@Override
	public Integer recoverTencentWeibo(String tencentId) {
		if(tencentId == null || "".equals(tencentId))
			return -1;
		
		int status = Integer.parseInt(WeiboActive.ACTIVE_ING.toString());
		
		int count = 0;
		try {
			count = tencentTokenDao.updateTencentWeiBoActive(tencentId, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int pauseTencentWeibo(String tencentId) {
		

		if(tencentId == null || "".equals(tencentId))
			return -1;
		
		int status = Integer.parseInt(WeiboActive.ACTIVE_PAUSE.toString());
		
		int count = 0;
		try {
			count = tencentTokenDao.updateTencentWeiBoActive(tencentId, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	
	}

	@Override
	public Integer sycTencentUpdate(String openid,String tencentToken) {
		

		if(null==openid || openid.equals(""))
			return 0;
		
		if(null==tencentToken || tencentToken.equals(""))
			return 0;
		
		TencentToken tt = new TencentToken();
		tt.setTencentUserId(openid);
		tt.setToken(tencentToken);
		
		int id = 0;
		try {
			id = tencentTokenDao.sycTencentUpdate(tt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	
	}

	
}
