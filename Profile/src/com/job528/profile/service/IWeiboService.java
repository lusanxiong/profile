package com.job528.profile.service;

import java.math.BigInteger;
import java.util.List;

import com.job528.ejb.entity.Weibo;
import com.job528.ejb.entity.WeiboResult;
import com.job528.ejb.entity.WeiboType;

public interface IWeiboService {
	/**
	 * 保存微博,成功返回该微博,否则返回null
	 * @param weibo
	 * @param commentFlag 在转发时,同时评论给作者 1是 0否
	 * @param commentFlag 在转发时,同时评论给原文作者 1是 0否
	 * @return Weibo
	 */
	public WeiboResult saveWeibo(Weibo weibo,Integer commentFlag,Integer fcommentFlag);
	
	/**
	 * 根据微博Id查询微博
	 * @param id
	 * @return Weibo
	 */
	public WeiboResult getWeiboById(BigInteger id);
	
	/**
	 * 根据微博Id 删除微博
	 * @param id
	 * @param userId 当前登录用户id
	 * @return 0 删除成功, 100该微博不存在(已删除), 500 删除失败
	 */
	public Integer deleteWeiboById(BigInteger id,Integer userId);
	
	/**
	 * 分页查询微博
	 * @param pageIndex 页数
	 * @param pageSize 查询多少条
	 * @param userId 用户id
	 * @param type 查询微博类型
	 * @return List<Weibo> 如何 为null 表示没有数据
	 */
	public List<WeiboResult> getWeiboByUserIdForPager(Integer userId,Integer pageIndex, Integer pageSize,WeiboType type);
	
}
