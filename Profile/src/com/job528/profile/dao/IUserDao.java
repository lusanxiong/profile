package com.job528.profile.dao;

public interface IUserDao {

	/**
	 * 修改个人密码
	 * 返回：0 :操作成功；1：原密码输入不正确；2：操作失败
	 * @param userId
	 * @param oldPwd
	 * @param newPwd
	 * @return 
	 */
	public Integer updatePassword(Integer userId, String oldPwd, String newPwd);
}
