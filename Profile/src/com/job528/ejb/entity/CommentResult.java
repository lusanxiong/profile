package com.job528.ejb.entity;

import java.io.Serializable;
import java.math.BigInteger;

@SuppressWarnings("serial")
public class CommentResult implements Serializable{
	private Comment comment;
	private BigInteger forwardWeiboId; // 评论同事转发的微博id , 如果不转发 return null
	
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public BigInteger getForwardWeiboId() {
		return forwardWeiboId;
	}
	public void setForwardWeiboId(BigInteger forwardWeiboId) {
		this.forwardWeiboId = forwardWeiboId;
	}
	
	
}
