package com.job528.profile.service;

import java.util.List;

import com.job528.ejb.entity.WeiboToken;
import com.job528.profile.vo.SendWeiboDTO;
import com.job528.profile.vo.UserWeiboInfoDTO;
import com.job528.profile.vo.WeiboOauthDTO;

/**
 * 新浪微博同步服务
 * @author lusanxiong
 *
 */
public interface IWeiboTokenService {
	
	/**
	 * 微博同步功能
	 */
	public int weiboSyn(WeiboToken weiboToken);
	
	/**
	 * 微博同步更新功能
	 */
	public int weiboSynUpdate(String sinaUserId, String accessToken);
	
	/**
	 * 暂停同步
	 */
	public int pauseSynWeibo(String sinaUserId);
	
	/**
	 * 恢复微博同步
	 */
	public int recoverSynWeibo(String sinaUserId);
	
	/**
	 * 取消同步
	 */
	public int cancelSynWeibo(String sinaUserId);
	
	
	/**
	 * 删除同步
	 */
	public int delSynWeibo(int userId,String sinaUserId);
	
	/**
	 * 删除授权
	 * 
	 * @param id : 主键ID
	 * 
	 * @return 删除的记录数
	 */
	public int delSynWeibo(int id);
	
	/**
	 * 查询某个新浪用户是否授权
	 *
	 * @param sinaUserId : 新浪用户ID
	 * @return true:已授权，false没有授权
	 */
	public boolean isActvieForUser(String sinaUserId);
	
	/**
	 * 判断用户是否同步了微博
	 * @param sinaUserId
	 * @return UserId:为空，说明没有同步，不为空，说明已经同步
	 */
	public int getWeiboTokenInfo(String sinaUserId) ;
	
	/**
	 * 调用新浪API发送新浪微博
	 * @param SendWeiboDTO
	 * 
	 * @return 
	 */
	public void sendSinaWeibo(SendWeiboDTO sendWeiboDTO);
	
	/**
	 * 获取新浪微博授权之后，用户授权信息
	 * @param code
	 * 
	 * @return WeiboOauthDTO
	 */
	public WeiboOauthDTO getWeiboOauthInfo(String code);
	
	/**
	 * 获取用户授权的所有微博服务商的同步信息
	 * 
	 * @param userid:用户ID
	 * @return List<UserWeiboInfoDTO>
	 */
	public List<UserWeiboInfoDTO> getUserWeiboInfoList(int userId);
	
	
	
	

}
