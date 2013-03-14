package com.job528.profile.service.impl;

import java.math.BigInteger;
import java.util.List;

import com.job528.ejb.entity.Favorite;
import com.job528.ejb.favorite.bean.FavoriteDao;
import com.job528.profile.service.IFavoriteService;

public class FavoriteServiceImpl implements IFavoriteService {

	private FavoriteDao favoriteDao;
	public void setFavoriteDao(FavoriteDao favoriteDao) {
		this.favoriteDao = favoriteDao;
	}

	@Override
	public Integer deleteFavorite(Integer userId, BigInteger weiboId) {
		return favoriteDao.deleteFavorite(userId, weiboId);
	}

	@Override
	public List<Favorite> getFavoriteByUserIdForPager(Integer userId, Integer pageIndex, Integer pageSize) {
		return favoriteDao.getFavoriteByUserIdForPager(userId, pageIndex, pageSize);
	}

	@Override
	public Integer saveFavorite(Integer userId, BigInteger weiboId) {
		return favoriteDao.saveFavorite(userId, weiboId);
	}

}
