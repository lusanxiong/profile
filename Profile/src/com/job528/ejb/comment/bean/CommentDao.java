package com.job528.ejb.comment.bean;

import java.math.BigInteger;
import java.util.List;

import com.job528.ejb.entity.Comment;
import com.job528.ejb.entity.CommentResult;

public interface CommentDao {
	

	/**
	 * 保存一条评论
	 * @param comment
	 * @param checked 是否评论同事转发
	 * @return null保存失败,非null成功
	 */
	public CommentResult saveComment(Comment comment,boolean checked);
	
	/**
	 * 根据id查询一条评论
	 * @param id
	 * @return Comment null表示不存在
	 */
	public Comment getCommentById(BigInteger id);
	
	/**
	 * 删除一条评论
	 * @param id 评论id
	 * @param userId 当前用户id
	 * @return 0成功  ;  100该评论已经删除 ; 500删除失败
	 */
	public Integer deleteCommentById(BigInteger id,Integer userId);
	
	/**
	 * 分页查询评论
	 * @param weiboId 微博Id
	 * @param pageIndex 页码
	 * @param pageSize 查询多少条
	 * @return List<Comment> 如何 为null 表示没有数据
	 */
	public List<Comment> getCommentByWeiboIdForPager(BigInteger weiboId,Integer pageIndex,Integer pageSize);
	
}
