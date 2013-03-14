package com.job528.profile.service.impl;

import java.util.List;

import com.job528.ejb.entity.Friend;
import com.job528.ejb.entity.Friends;
import com.job528.ejb.entity.Pager;
import com.job528.ejb.entity.Relationship;
import com.job528.ejb.relationship.bean.RelationshipDao;
import com.job528.profile.service.IRelationshipService;

public class RelationshipServiceImpl implements IRelationshipService {

	private RelationshipDao relationshipDao;
	public void setRelationshipDao(RelationshipDao relationshipDao) {
		this.relationshipDao = relationshipDao;
	}

	
	@Override
	public Integer deleteRelationship(Relationship relationship) {
		return relationshipDao.deleteRelationship(relationship);
	}

	@Override
	public List<Friends> getAttentionByUserIdForPager(Integer userId,Integer groupId, Integer pageIndex, Integer pageSize) {
		return relationshipDao.getAttentionByUserIdForPager(userId,groupId,pageIndex, pageSize);
	}

	@Override
	public List<Friends> getFansByUserIdForPager(Integer userId,Integer groupId, Integer pageIndex, Integer pageSize) {
		return relationshipDao.getFansByUserIdForPager(userId,groupId, pageIndex, pageSize);
	}

	@Override
	public Integer saveRelationship(Relationship relationship) {
		return relationshipDao.saveRelationship(relationship);
	}


	@Override
	public Pager<Friend> getAttentionByGroupId(Integer userId, Integer groupId, Integer pageIndex, Integer pageSize) {
		return relationshipDao.getAttentionByGroupId(userId, groupId, pageIndex, pageSize);
	}


	@Override
	public Pager<Friend> getFansByGroupId(Integer userId, Integer groupId, Integer pageIndex, Integer pageSize) {
		return relationshipDao.getFansByGroupId(userId, groupId, pageIndex, pageSize);
	}


	@Override
	public Integer updateGroupId(Integer userId, Integer otherUserId, Integer newGroupId) {
		return relationshipDao.updateGroupId(userId, otherUserId, newGroupId);
	}


	@Override
	public Integer getRelationshipFlag(Integer userId, Integer otherUserId) {
		if(userId.equals(otherUserId)) { //自己
			return 3;
		}
		return relationshipDao.getRelationshipFlag(userId, otherUserId);
	}
	
	
	public Friend getRelationshipByUserId(Integer userId,Integer otherUserId){
		return relationshipDao.getRelationshipByUserId(userId, otherUserId);
	}


	@Override
	public Integer getCountByUserId(Integer userId, Integer groupId) {
		return this.relationshipDao.getCountByUserId(userId, groupId);
	}

}
