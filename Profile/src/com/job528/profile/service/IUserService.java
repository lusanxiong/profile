package com.job528.profile.service;

import com.job528.profile.LoginInfo;
import com.job528.profile.model.MyUsers;

public interface IUserService {

	/**
	 * 修改个人密码
	 * 返回：0 :操作成功；1：原密码输入不正确；2：操作失败
	 * @param userId
	 * @param oldPwd
	 * @param newPwd
	 * @return 
	 */
	public Integer updatePassword(Integer userId,String oldPwd,String newPwd);
	
	
	/**
	 * 获取账号信息
	 * @param userId
	 * @return
	 */
	public MyUsers getAccountInfoByUserId(Integer userId);
	
	/**
	 * 获取账号信息
	 * @param email
	 * @return
	 */
	public MyUsers getAccountInfoByEmail(String email);
	
	
	/**
	 * 验证邮箱是否被其他用户占用
	 * @param myUserId
	 * @param email
	 * @return
	 */
	public boolean verificateMail(Integer myUserId,String email);
	
	
	/**
     * 登录
     * @param loginName
     * @param pwd
     * @param ip
     * @param loginInfo
     * @return
     */
	public Integer login(String loginName, String pwd, String ip, LoginInfo loginInfo);
	
	/**
	 * 获取会员的朋友数
	 * @param userId
	 * @return
	 */
	public String getFriendCount(int userId);
	
	/**
	 * 初始化用户信息
	 * @param userId
	 */
	public void initUserInfoFristTime(int userId);
	
}
