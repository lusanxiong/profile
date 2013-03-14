package com.job528.profile.service.impl;

import java.math.BigInteger;
import java.util.List;

import com.job528.ejb.entity.Weibo;
import com.job528.ejb.entity.WeiboResult;
import com.job528.ejb.entity.WeiboType;
import com.job528.ejb.weibo.bean.WeiboDao;
import com.job528.profile.service.IWeiboService;

public class WeiboServiceImpl implements IWeiboService {
	
	private WeiboDao weiboDao;
	public void setWeiboDao(WeiboDao weiboDao) {
		this.weiboDao = weiboDao;
	}

	@Override
	public Integer deleteWeiboById(BigInteger id,Integer userId) {
		return weiboDao.deleteWeiboById(id,userId);
	}

	@Override
	public WeiboResult getWeiboById(BigInteger id) {
		return weiboDao.getWeiboById(id);
	}

	@Override
	public List<WeiboResult> getWeiboByUserIdForPager(Integer userId, Integer pageIndex, Integer pageSize,WeiboType type) {
		return weiboDao.getWeiboByUserIdForPager(userId, pageIndex, pageSize,type);
	}

	@Override
	public WeiboResult saveWeibo(Weibo weibo,Integer commentFlag,Integer fcommentFlag) {
		return weiboDao.saveWeibo(weibo,commentFlag,fcommentFlag);
	}


}
