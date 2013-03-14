package com.job528.ejb.tencentToken.bean;

import com.job528.ejb.entity.TencentToken;

public interface TencentTokenDao {
 
	/**
   * 腾讯微博同步
   */	
	public int addTencentToken(TencentToken tencentToken);
	
	
	
	/**
	 * 修改同步状态
	 */
	public int updateTencentWeiBoActive(String openId, int status);
	
	
	/**
	 * 删除同步
	 */
	public int deleteTencentWeiBo(int userId,String  openId);
	
	
	/**
	 * 通过腾讯微博唯一标识去找是否有这个用户的id
	 * @param openid
	 * @return
	 */
	public int getUserIdByOpenid(String openid);
	
	
	//腾讯微博登录更新同步
	
	public int sycTencentUpdate(TencentToken tencentToken);
}
