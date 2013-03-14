package com.job528.profile.service;

import com.job528.ejb.entity.TencentToken;
import com.job528.profile.vo.TencentVo;

public interface ITencentWeiBoService {
	
	   /**
	   * 腾讯微博同步
	   */
	  public Integer addTencentToken(TencentToken tencentToken);
	 
	  /**
	   * 腾讯微博同步更新
	   */
		
		public Integer sycTencentUpdate(String openid,String tencentToken);
		
		/**
		 * 
	    * 暂停同步
	    */
	    public int pauseTencentWeibo(String tencentId);
	    
	    /**
	     * 
	     */
	    
	    public Integer recoverTencentWeibo(String tencentId);
	    
	    
		/**
		 * 删除同步
		 */
		public Integer deleteTencentWeiBo(int userId,String  openId);
		
		public int getUserIdByOpenid(String openId);
		
		/**
		 * 发微薄（线程发布腾讯微博）
		 */
		public void sendTencentWeibo(TencentVo tv);	
}
