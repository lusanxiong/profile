package com.job528.ejb.favorite.bean;

import java.math.BigInteger;
import java.util.List;

import com.job528.ejb.entity.Favorite;

public interface FavoriteDao {

	/**
	 * 添加一条收藏记录
	 * @param userId 
	 * @param weiboId
	 * @return 0 成功, 100已经收藏, 500失败
	 */
	public Integer saveFavorite(Integer userId,BigInteger weiboId);
	
	/**
	 * 删除一条收藏记录
	 * @param userId
	 * @param weiboId
	 * @return 0成功 , 500失败
	 */
	public Integer deleteFavorite(Integer userId,BigInteger weiboId);
	
	/**
	 * 根据分页查询收藏记录
	 * @param userId
	 * @param pageIndex 页码
	 * @param pageSize 每页多少条
	 * @return List<Favorite> , null表示没有收藏
	 */
	public List<Favorite> getFavoriteByUserIdForPager(Integer userId,Integer pageIndex,Integer pageSize);
}
