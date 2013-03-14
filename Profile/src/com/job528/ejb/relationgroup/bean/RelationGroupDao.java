package com.job528.ejb.relationgroup.bean;

import java.util.List;

import com.job528.ejb.entity.RelationGroup;

public interface RelationGroupDao {

	/**
	 * 保存一个用户组
	 * @param group
	 * @return 0 保存成功 , 100组名称已经存在 , 500保存失败
	 */
	public Integer saveRelationGroup(RelationGroup group);
	
	/**
	 * 删除一个用户组
	 * @param id 组id
	 * @param userId 用户id,必须从cookie中取得
	 * @return 受影响的行数 0删除成功, 100 该组已经删除 ,500删除失败
	 */
	public Integer deleteRelationGroup(Integer id,Integer userId);
	
	/**
	 * 根据用户Id 查询其所有组
	 * @param userId
	 * @return List<RelationGroup> null 表示没有分组
	 */
	public List<RelationGroup> getRelationGroupByUserId(Integer userId);
	
}
