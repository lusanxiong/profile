package com.job528.profile.action;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.job528.common.DataDictionary.SessionAttrName;
import com.job528.ejb.entity.Comment;
import com.job528.ejb.entity.UserProfile;
import com.job528.ejb.entity.Weibo;
import com.job528.ejb.entity.WeiboResult;
import com.job528.ejb.entity.WeiboType;
import com.job528.profile.service.ICommentService;
import com.job528.profile.service.IRelationshipService;
import com.job528.profile.service.ITencentWeiBoService;
import com.job528.profile.service.IUserProfileService;
import com.job528.profile.service.IWeiboService;
import com.job528.profile.service.IWeiboTokenService;
import com.job528.profile.vo.Profile;
import com.job528.profile.vo.SendWeiboDTO;
import com.job528.profile.vo.TencentVo;
import com.job528.util.Config;
import com.job528.util.StringUtil;
/**
 * 
 * @author Sunday
 *
 */
@SuppressWarnings("serial")
public class WeiboAction extends ResumeAction {

	private Integer flag;
	private List<WeiboResult> weiboList;
	private List<Comment> commentList;
	private Profile profile;
	private IWeiboService weiboService;
	private ICommentService commentService;
	private IUserProfileService userProfileService;
	private IRelationshipService relationshipService;
	private IWeiboTokenService weiboTokenService;
	private ITencentWeiBoService tencentWeiBoService;



	public String publishWeibo() throws Exception {
		if (!isLogin()) {
			return writeText("500");
		}
		String texts = StringUtil.trim(request.getParameter("texts"));
		String imagePath = request.getParameter("imagePath");
		Integer commentFlag = StringUtil.toInteger(request.getParameter("commentFlag"), 0);
		BigInteger forwardId = StringUtil.toBigInteger(request.getParameter("forwardId"), 0);
		Integer fcommentFlag = StringUtil.toInteger(request.getParameter("fcommentFlag"), 0);
		BigInteger sourceId = StringUtil.toBigInteger(request.getParameter("sourceId"), 0);
		
		imagePath = StringUtil.isEmpty(imagePath)?null:imagePath; 
		System.out.println(imagePath);
		Weibo weibo = new Weibo();
		weibo.setUserId(getUserId());
		weibo.setForwardId(forwardId);
		weibo.setSourceId(sourceId);
		weibo.setTexts(texts);
		weibo.setImagePath(imagePath);
		weibo.setIp(getIp());
	
		WeiboResult wr = weiboService.saveWeibo(weibo,commentFlag,fcommentFlag);
		if (null == wr) {
			return writeText("404");
		}
		weiboList = new ArrayList<WeiboResult>(1);
		weiboList.add(wr);
		
		//发送新浪微博
		sendSinaWeibo(texts,imagePath);
		//同步内容到腾讯微博
		sendTencentWeibo(texts,imagePath);
		return SUCCESS;
	}
	
	/**
	 * 发送新浪微博
	 */
	private void sendSinaWeibo(String content,String imagePath) throws Exception{
		
		Object accessToken = super.getHttpSessionAttribute(SessionAttrName.SINA_ACESS_TOKEN);
		String accessTokenStr = (accessToken!=null ? (String)accessToken : "");
		
		Object weiboActive = super.getHttpSessionAttribute(SessionAttrName.SINA_ACTIVE);
		int active = (weiboActive!=null ? (Integer)weiboActive : -1);
		
		Object sinaUserId = super.getHttpSessionAttribute(SessionAttrName.SINA_USERID);
		String sinaUserIdStr = (sinaUserId!=null ? (String)sinaUserId : "");
		
		SendWeiboDTO dto = new SendWeiboDTO();
		dto.setAccessToken(accessTokenStr);
		dto.setContent(content);
		dto.setWeiboActive(active);
		dto.setSinaUserId(sinaUserIdStr);
		try {
			weiboTokenService.sendSinaWeibo(dto);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	 //调用微博发布
	 public void sendTencentWeibo(String texts,String imagePath){
		// String content = request.getParameter("content");
		 //发送微博   令牌  微博内容  ip地址 openid
		 Map<SessionAttrName, Object> map = getUserSessionAllValue();

		 Object accessToken = map.get(SessionAttrName.TENCENT_ACESS_TOKEN);
		 String token=(accessToken!=null?(String)accessToken:"");
		 Object tencentId = map.get(SessionAttrName.TENCENT_OPENID);
		 Object activeObj = map.get(SessionAttrName.TENCENT_ACTIVE);
		 String  openid = (tencentId!=null?(String)tencentId:"");
		 int active = (activeObj!=null?(Integer)activeObj:-1);
	    

		 TencentVo tv = new TencentVo();
		 tv.setContent(texts);
		 tv.setAccessToken(token);
		 tv.setClientIp(getIp());
		 tv.setOpenid(openid);
		 tv.setActive(active);
		// tv.setImagePath(imagePath);
		
		try {
			tencentWeiBoService.sendTencentWeibo(tv);
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	 }
	public String weiboList() throws Exception {
		if(!isLogin()) {
			return writeText("500");
		}
		Integer pageIndex = StringUtil.toInteger(request.getParameter("pageIndex"),1);
		Integer userId = StringUtil.toInteger(request.getParameter("userId"), 0);
		String typeStr = StringUtil.trim(request.getParameter("type"));
		WeiboType type = null;
		if("self".equals(typeStr)){
			type = WeiboType.SELF;
		}else{
			type = WeiboType.ATTENTION;
		}
		weiboList = weiboService.getWeiboByUserIdForPager(userId,pageIndex,Config.weibo.pageSize,type);
		return SUCCESS;
	}
	
	public String getWeibo() throws Exception {
		if(!isLogin()) {
			return writeText("500");
		}
		BigInteger weiboId = StringUtil.toBigInteger(request.getParameter("weiboId"), 0);
		if(StringUtil.isInvalid(weiboId)) {
			return writeText("400");
		}
		WeiboResult wr = weiboService.getWeiboById(weiboId);
		if(null == wr) {
			return writeText("404");
		}
		weiboList = new ArrayList<WeiboResult>(1);
		weiboList.add(wr);
		return SUCCESS;
	}
	
	public String deleteWeibo() throws Exception {
		if(!isLogin()) {
			return writeText("500");
		}
		BigInteger weiboId = StringUtil.toBigInteger(request.getParameter("weiboId"), 0);
		if(StringUtil.isInvalid(weiboId)) {
			return writeText("400");
		}
		int result = weiboService.deleteWeiboById(weiboId,getUserId());
		return writeText(result+"");
	}
	
	/**
	 * 显示单条微博
	 * @return
	 * @throws Exception
	 */
	public String showWeibo() throws Exception {
		BigInteger weiboId = StringUtil.toBigInteger(request.getParameter("wid"), 0);
		if(StringUtil.isInvalid(weiboId)) {
			return ERROR;
		}
		WeiboResult wr = weiboService.getWeiboById(weiboId);
		if(null == wr) {
			return ERROR;
		}
		Integer userId = wr.getWeibo().getUserId();
		UserProfile userProfile = userProfileService.getUserProfileById(userId);
		if(userProfile == null){
			userProfile = new UserProfile();
			userProfile.setAttentionNumber(0);
			userProfile.setFansNumber(0);
			userProfile.setWeiboNumber(0);
		}
		profile = new Profile();
		profile.setUserProfile(userProfile);
		
		flag = relationshipService.getRelationshipFlag(getUserId(), userId); //获取用户关系
		
		weiboList = new ArrayList<WeiboResult>(1);
		weiboList.add(wr);
		
		Integer pageIndex = StringUtil.toInteger(request.getParameter("pageIndex"), 1);
		commentList = commentService.getCommentByWeiboIdForPager(weiboId, pageIndex, Config.comment.pageSize);
		return SUCCESS;
	}
	
	
	//------------------------------
	public void setWeiboService(IWeiboService weiboService) {
		this.weiboService = weiboService;
	}
	public List<WeiboResult> getWeiboList() {
		return weiboList;
	}
	public void setWeiboList(List<WeiboResult> weiboList) {
		this.weiboList = weiboList;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public void setUserProfileService(IUserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public void setRelationshipService(IRelationshipService relationshipService) {
		this.relationshipService = relationshipService;
	}

	public IWeiboTokenService getWeiboTokenService() {
		return weiboTokenService;
	}

	public void setWeiboTokenService(IWeiboTokenService weiboTokenService) {
		this.weiboTokenService = weiboTokenService;
	}
	
	public ITencentWeiBoService getTencentWeiBoService() {
		return tencentWeiBoService;
	}

	public void setTencentWeiBoService(ITencentWeiBoService tencentWeiBoService) {
		this.tencentWeiBoService = tencentWeiBoService;
	}
}
