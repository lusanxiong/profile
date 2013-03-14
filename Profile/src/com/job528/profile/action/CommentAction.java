package com.job528.profile.action;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.job528.ejb.entity.Comment;
import com.job528.ejb.entity.CommentResult;
import com.job528.profile.service.ICommentService;
import com.job528.util.StringUtil;
import com.job528.util.Config;
import com.job528.util.webwork.GenericAction;

@SuppressWarnings("serial")
public class CommentAction extends GenericAction{
	
	private ICommentService commentService;
	private List<Comment> commentList;
	
	public String publishComment() throws Exception{
		if(!isLogin()) {
			return writeText("500"); //未登录
		}
		Comment comment = new Comment();
		BigInteger weiboId = StringUtil.toBigInteger(request.getParameter("weiboId"), 0);
		Integer toUserId = StringUtil.toInteger(request.getParameter("toUserId"), 0);
		String texts = StringUtil.trim(request.getParameter("texts"));
		boolean checked = StringUtil.toInteger(request.getParameter("checked"), 0)==1?true:false;
		
		if(StringUtil.isInvalid(weiboId) || "".equals(texts) || toUserId<1) {
			return writeText("400"); //数据不完整
		}
		
		comment.setFromUserId(getUserId());
		comment.setToUserId(toUserId);
		comment.setWeiboId(weiboId);
		comment.setTexts(texts);
		comment.setIp(getIp());
		
		CommentResult cr = commentService.saveComment(comment,checked);
		if(null==cr){
			return writeText("404"); //异常
		}
		commentList = new ArrayList<Comment>(1);
		commentList.add(cr.getComment());
		request.setAttribute("weiboId", weiboId); //页面需要使用weiboId
		request.setAttribute("forwardWeiboId", cr.getForwardWeiboId());
		return SUCCESS;
	}

	
	public String commentList() throws Exception{
		if(!isLogin()) {
			return writeText("500");
		}
		BigInteger weiboId = StringUtil.toBigInteger(request.getParameter("weiboId"), 0);
		if(StringUtil.isInvalid(weiboId)) {
			return writeText("400");
		}
		Integer pageIndex = StringUtil.toInteger(request.getParameter("pageIndex"), 1);
		Integer showMore = StringUtil.toInteger(request.getParameter("showMore"),0);
		commentList = commentService.getCommentByWeiboIdForPager(weiboId, pageIndex, Config.comment.pageSize);
		if(null==commentList) {
			return writeText("");
		}
		request.setAttribute("weiboId", weiboId); //页面需要使用weiboId
		request.setAttribute("showMore", showMore); //标识是否显示 更多 按钮
		request.setAttribute("commentList", commentList);
		return SUCCESS;
	}
	
	
	public String deleteComment() throws Exception {
		if(!isLogin()) {
			return writeText("500");
		}
		BigInteger commentId = StringUtil.toBigInteger(request.getParameter("commentId"), 0);
		if(StringUtil.isInvalid(commentId)) {
			return writeText("400");
		}
		int result = commentService.deleteCommentById(commentId,getUserId());
		return writeText(result+"");
	}
	
	
	
	//--------------------------
	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	
}
