package com.job528.ejb.userGroup.bean;

import com.job528.ejb.dto.ExecuteResult;
import com.job528.ejb.entity.UserGroup;

/**
 * 用户组 接口
 * @author lusanxiong
 *
 */
public interface UserGroupDao {
	
	/**
	 * 创建组
	 * 
	 * @param UserGroup eneity
	 * 
	 * @rerun  ExcuteResult dto
	 * 
	 */
	public ExecuteResult createGroup(UserGroup group);
	
	/**
	 * 删除组
	 * 
	 * @param id :组标识
	 * @return 删除记录数
	 * 
	 */
	public int delGroup(int id);
	
	
	/**
	 * 修改组
	 * 
	 * @param UserGroup eneity
	 * 
	 * @rerun  ExcuteResult dto
	 */
	public ExecuteResult updateGroup(UserGroup group);
	
	/**
	 * 修改组成员
	 * 
	 * @param sourceGroupId:原组标识
	 * @param targetGroupId:目标组标识
	 * @param mermberId: 组成员标识
	 * 
	 * @return  ExcuteResult dto
	 */
	public ExecuteResult modifyGroupMember(int sourceGroupId, int targetGroupId, int memberId);
	
	/**
	 * 移除组成员
	 * 
	 * @param groupId:组标识
	 * @param memberId:组成员标识
	 * 
	 * @return ExecuteResult dto
	 */
	public ExecuteResult removeGroupMember(int gourpId, int memberId);

}
