package com.job528.profile.service.impl;

import java.util.List;

import com.job528.ejb.entity.RelationGroup;
import com.job528.ejb.relationgroup.bean.RelationGroupDao;
import com.job528.profile.service.IRelationGroupService;

public class RelationGroupServiceImpl implements IRelationGroupService {

	private RelationGroupDao relationGroupDao;
	public void setRelationGroupDao(RelationGroupDao relationGroupDao) {
		this.relationGroupDao = relationGroupDao;
	}

	@Override
	public Integer deleteRelationGroup(Integer id, Integer userId) {
		return relationGroupDao.deleteRelationGroup(id, userId);
	}

	@Override
	public List<RelationGroup> getRelationGroupByUserId(Integer userId) {
		return relationGroupDao.getRelationGroupByUserId(userId);
	}

	@Override
	public Integer saveRelationGroup(RelationGroup group) {
		return relationGroupDao.saveRelationGroup(group);
	}

}
