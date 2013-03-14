package com.job528.profile.service.impl;

import java.math.BigInteger;
import java.util.List;

import com.job528.ejb.comment.bean.CommentDao;
import com.job528.ejb.entity.Comment;
import com.job528.ejb.entity.CommentResult;
import com.job528.profile.service.ICommentService;

public class CommentServiceImpl implements ICommentService {

	private CommentDao commentDao;
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Override
	public Integer deleteCommentById(BigInteger id,Integer userId) {
		return commentDao.deleteCommentById(id,userId);
	}

	@Override
	public Comment getCommentById(BigInteger id) {
		return commentDao.getCommentById(id);
	}

	@Override
	public List<Comment> getCommentByWeiboIdForPager(BigInteger weiboId, Integer pageIndex, Integer pageSize) {
		return commentDao.getCommentByWeiboIdForPager(weiboId, pageIndex, pageSize);
	}

	@Override
	public CommentResult saveComment(Comment comment,boolean checked) {
		return commentDao.saveComment(comment,checked);
	}

}
