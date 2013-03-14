package com.job528.profile.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.job528.common.DataDictionary.SessionAttrName;
import com.job528.profile.LoginInfo;
import com.job528.profile.model.MyMessage;
import com.job528.profile.model.MyResume;
import com.job528.profile.service.IFriendService;
import com.job528.profile.service.IMessageService;
import com.job528.profile.service.IMyResumeService;
import com.job528.profile.service.IPositionService;
import com.job528.profile.service.ISessionService;
import com.job528.profile.service.IUserService;
import com.job528.profile.model.MessageQueue;
import com.job528.profile.vo.Resume;
import com.job528.util.JsonUtils;
import com.job528.util.StringUtil;
import com.job528.util.web.WebUtil;

public class AjaxServlet extends HttpServlet {

	
	private static final String ATTENTION = "attention";
	private static final String BATCH_ATTENTION = "batchattention";
	
	private static final String UN_ATTENTION = "unattention";
	private static final String BATCH_UN_ATTENTION = "batchunattention";
	private static final String RECOMMOND_JOB = "recommendjob";
	private static final String CHANGE_GROUP = "changegroup";
	
	private static final String BATCH_EDIT_GROUP = "batcheditgroup";
	private static final String RESUME_PER = "resumeper";
	private static final String USER_LOGIN = "userlogin";
	private static final String CHANGE_JOBSTATE = "changejobstate";
	private static final String DELETE_MESSAGE = "deletemessage";
	private static final String SEND_MESSAGE = "sendmessage";
	private static final String BATCH_SEND_PRIVATEMESSAGE = "batchsendprivatemessage";
	private static final String REPLY_MESSAGE = "replymessage";
	private static final String EDIT_WEPINFO = "editwepinfo";
	private static final String VERIFICATE_EMAIL = "verificatemail";
	private static final String DEL_FANCES = "delfans";
	private static final String BATCH_DEL_FANCES = "batchdelfans";
	private static final String TOTAL_FRIENDS = "totalfriend";
	
	private static final String GET_RELATION_FLAG = "getrelationflag";
	private static final String MESSAGE_QUEUE = "messagequeue";
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		LoginInfo loginInfo = new LoginInfo(request,response);
        if(ATTENTION.equals(action)){    	
        	int group = Integer.parseInt(request.getParameter("group"));
        	int targetId = Integer.parseInt(request.getParameter("targetId"));
        	IFriendService friendService = (IFriendService)WebUtil.getBean(getServletContext(), "friendService");
        	int result = friendService.attentionFriend(loginInfo.getLoginUserId(), targetId, group);
        	out.write(result + "");
        }else if(BATCH_ATTENTION.equals(action)){
        	int group = StringUtil.getIntValue(request.getParameter("group"),5);
        	String targetIds = request.getParameter("targetIds");
        	IFriendService friendService = (IFriendService)WebUtil.getBean(getServletContext(), "friendService");
        	int result = friendService.batchAttentionFriend(targetIds, loginInfo.getLoginUserId(), group);
        	out.write(result + "");
        }else if(UN_ATTENTION.equals(action)){
        	int targetId = Integer.parseInt(request.getParameter("targetId"));
        	IFriendService friendService = (IFriendService)WebUtil.getBean(getServletContext(), "friendService");
        	int result = friendService.unAttentionFriend(loginInfo.getLoginUserId(), targetId);
        	out.write(result + "");
        	
        }else if(BATCH_UN_ATTENTION.equals(action)){
        	String targetIds = request.getParameter("targetIds");
        	IFriendService friendService = (IFriendService)WebUtil.getBean(getServletContext(), "friendService");
        	int result = friendService.batchUnAttentionFriend(targetIds, loginInfo.getLoginUserId());
        	out.write(result + "");
        }else if(DEL_FANCES.equals(action)){
        	int targetId = Integer.parseInt(request.getParameter("targetId"));
        	IFriendService friendService = (IFriendService)WebUtil.getBean(getServletContext(), "friendService");
        	int result = friendService.unAttentionFriend(targetId, loginInfo.getLoginUserId());
        	out.write(result + "");
        	
        }else if(BATCH_DEL_FANCES.equals(action)){
        	String targetIds = request.getParameter("targetIds");
        	IFriendService friendService = (IFriendService)WebUtil.getBean(getServletContext(), "friendService");
        	int result = friendService.batchDelFans(targetIds, loginInfo.getLoginUserId());
        	out.write(result + "");
        	
        }else if(RECOMMOND_JOB.equals(action)){
        	String tragetIds = request.getParameter("tragetIds");
        	String posId = request.getParameter("posId");
        	String memId = request.getParameter("memId");
        	if(!StringUtil.isValidStr(tragetIds) || !StringUtil.isValidStr(posId)) {
        		out.write("0");
        	}else{
        		IPositionService positionService = (IPositionService)WebUtil.getBean(getServletContext(), "positionService");
        	    List<Integer> tIds = new ArrayList<Integer>();
        	    String ids[] = tragetIds.split(",");
        	    for(String tid : ids){
        	    	if(StringUtil.isValidStr(tid)){
        	    	    tIds.add(Integer.parseInt(tid));
        	    	}
        	    }
        	    
        	    if(tIds.size() > 0){
        	    	positionService.addRecommendJob(tIds, loginInfo.getLoginUserId(), Integer.parseInt(posId),Integer.parseInt(memId));
        	    	out.write("1");
        	    }
        	    else{
        	    	out.write("0");
        	    }
        	}	
        }else if(CHANGE_GROUP.equals(action)){
        	Integer userId = loginInfo.getLoginUserId();
        	Integer otherUserId = Integer.parseInt(request.getParameter("targetId"));
        	Integer newGroupId = Integer.parseInt(request.getParameter("group"));
        	IFriendService friendService = (IFriendService)WebUtil.getBean(getServletContext(), "friendService");
        	Integer result = friendService.changeFriendGroup(userId, otherUserId, newGroupId);
        	out.write(result+"");
        }else if(BATCH_EDIT_GROUP.equals(action)){
        	Integer userId = loginInfo.getLoginUserId();
        	String targetIds = request.getParameter("targetIds");
        	Integer newGroupId = Integer.parseInt(request.getParameter("group"));
        	IFriendService friendService = (IFriendService)WebUtil.getBean(getServletContext(), "friendService");
        	Integer result = friendService.batchEditFriendGroup(targetIds, userId, newGroupId);
        	out.write(result+"");
        }
        else if(RESUME_PER.equals(action)){
        	IMyResumeService resumeService = (IMyResumeService)WebUtil.getBean(getServletContext(), "resumeService");
        	String result = resumeService.getResumeStatePer(loginInfo.getLoginUserId(), 0);
        	out.write(result);
        }else if(USER_LOGIN.equals(action)){
        	String loginName = request.getParameter("loginName");
        	String pwd = request.getParameter("pwd");
        	String ip = WebUtil.getIpAddr(request);
        	IMyResumeService resumeService = (IMyResumeService)WebUtil.getBean(getServletContext(), "resumeService");
        	
        	int result = resumeService.login(loginName, pwd, ip, loginInfo);
        	
        	HttpSession session = request.getSession();
        	session.setAttribute(LoginInfo.LOGIN_USER_RESUME, null);
        	
        	//设置session属性
        	setUserSesssionAllAttr(request);
        	
    		out.write(result+"");
        }else if(CHANGE_JOBSTATE.equals(action)){
        	String jobState = request.getParameter("jobState");
        	IMyResumeService resumeService = (IMyResumeService)WebUtil.getBean(getServletContext(), "resumeService");
        	
        	Resume resume = loginInfo.getLoginResume();
        	if(resume == null){
        		resume = new Resume();
        		MyResume myResume = resumeService.getResumeByUserId(loginInfo.getLoginUserId());
        		resume.setMyResume(myResume);
        	}
        	
        	MyResume myResumeUpdate = resume.getMyResume();
        	myResumeUpdate.setFlother(jobState);
        	java.sql.Date date = new java.sql.Date((new Date()).getTime());
        	
        	myResumeUpdate.setUpdateDate(date);
        	resume.setMyResume(myResumeUpdate);
        	
        	resumeService.updateResume(myResumeUpdate,false);
        	loginInfo.setLoginUserId(myResumeUpdate.getMyUserId().toString());
        	loginInfo.setLoginResume(resume);
        	out.write("");
        	
        }else if(DELETE_MESSAGE.equals(action)){
        	int id = Integer.parseInt(request.getParameter("id"));
        	IMessageService messageService = (IMessageService)WebUtil.getBean(getServletContext(), "messageService");
        	messageService.deleteMessage(id);
        	out.write("");
        }else if(REPLY_MESSAGE.equals(action)){
        	int id = Integer.parseInt(request.getParameter("id"));
        	String reply = request.getParameter("reply");
        	IMessageService messageService = (IMessageService)WebUtil.getBean(getServletContext(), "messageService");
        	MyMessage message = new MyMessage();
        	message = messageService.getMessage(id);
        	if(message != null){
        		message.setReply(reply);
        		messageService.updateMessage(message);
        	}
        	out.write("");
        }else if(SEND_MESSAGE.equals(action)){
        
        	int receiveId = Integer.parseInt(request.getParameter("receiveId"));
        	String content = request.getParameter("content");
        	IMessageService messageService = (IMessageService)WebUtil.getBean(getServletContext(), "messageService");
        	MyMessage message = new MyMessage();
        	message.setContent(content);
        	message.setIsRead(false);
        	message.setReply("");
        	message.setSendId(loginInfo.getLoginUserId());
        	message.setTargetId(receiveId);
        	message.setType(2);
        	message.setCreateDate(new Date());
        	messageService.sendMessage(message);
        	out.write("");
        
        }else if(BATCH_SEND_PRIVATEMESSAGE.equals(action)){
        	String targetIds = request.getParameter("targetIds");
        	String message = request.getParameter("message");
        	IMessageService messageService = (IMessageService)WebUtil.getBean(getServletContext(), "messageService");
        	messageService.batchSendPrivateMessage(loginInfo.getLoginUserId(), targetIds, message);
        }else if(EDIT_WEPINFO.equals(action)){
        	int workedYear = Integer.parseInt(request.getParameter("workedYear"));
        	int workedMonth = Integer.parseInt(request.getParameter("workedMonth"));
        	Short workedComNumber = Short.parseShort(request.getParameter("workedComNumber"));
        	IMyResumeService resumeService = (IMyResumeService)WebUtil.getBean(getServletContext(), "resumeService");
        	
        	Resume resume = loginInfo.getLoginResume();
        	if(resume == null){
        		resume = new Resume();
        		MyResume myResume = resumeService.getResumeByUserId(loginInfo.getLoginUserId());
        		resume.setMyResume(myResume);
        	}
        	
        	MyResume myResumeUpdate = resume.getMyResume();
        	myResumeUpdate.setWorkedComNumber(workedComNumber);
        	myResumeUpdate.setWorkedMonth(workedMonth);
        	myResumeUpdate.setWorkedYear(workedYear);
        	java.sql.Date date = new java.sql.Date((new Date()).getTime());
        	
        	myResumeUpdate.setUpdateDate(date);
        	resume.setMyResume(myResumeUpdate);
        	
        	resumeService.updateResume(myResumeUpdate,false);
        	loginInfo.setLoginUserId(myResumeUpdate.getMyUserId().toString());
        	loginInfo.setLoginResume(resume);
        	out.write("");
        }else if(VERIFICATE_EMAIL.equals(action)){
        	IMyResumeService resumeService = (IMyResumeService)WebUtil.getBean(getServletContext(), "resumeService");
        	String email = request.getParameter("email");
        	if(resumeService.verificateMail(loginInfo.getLoginUserId(),email)){
        		out.write("1");
        	}else{
        		out.write("0");
        	}
        }else if(TOTAL_FRIENDS.equals(action)){
        	IUserService userService = (IUserService)WebUtil.getBean(getServletContext(), "userService");
        	out.write(userService.getFriendCount(loginInfo.getLoginUserId()));
        }else if(GET_RELATION_FLAG.equals(action)){
        	int otherUserId = StringUtil.getIntValue(request.getParameter("otherUserId"), 0);
        	IFriendService friendService = (IFriendService)WebUtil.getBean(getServletContext(), "friendService");
        	int result = -1;
        	result = friendService.getRelationFlag(loginInfo.getLoginUserId(), otherUserId);
        	out.write(result+"");
        }else if(MESSAGE_QUEUE.equals(action)) {
        	int type = Integer.parseInt(request.getParameter("type")); // 1表示读取消息 2表示清除当前用户所有消息
        	IMessageService messageService = (IMessageService)WebUtil.getBean(getServletContext(), "messageService");
        	if(type==1){
	        	MessageQueue mq = messageService.getMessageQueue(loginInfo.getLoginUserId());
	        	out.write(JsonUtils.getJsonString(mq));
        	}
        	else if(type==2) {
        		messageService.deleteMessageQueue(loginInfo.getLoginUserId(),0);//清除所有消息
        	}
        }
        out.close();
	}
	
	/*
	 * 重新设置该用户的全部session属性
	 */
	private void setUserSesssionAllAttr(HttpServletRequest request) {
		Object userid = request.getAttribute("cookieUserId");
		String userIdStr = (userid!=null ? (String)userid : "");
		
		int userIdInt = -1;
		if(!userIdStr.equals("")) {
			userIdInt = Integer.parseInt(userIdStr);
		}
		 
		ISessionService sessionService = (ISessionService)WebUtil.getBean(getServletContext(), "sessionService");
    	Map<SessionAttrName, Object> sessionMap = sessionService.getUserSessionData(userIdInt);
    	System.out.println("sessionMap=="+sessionMap);
    	setHttpSession(sessionMap,request);
	}
	
	
	/**
	 * 存放session
	 * 
	 * @param sessionMap: 存放session属性键值对
	 * 
	 * @return 把指定的session属性键值对存入servelt session中。
	 */
	private void setHttpSession(Map<SessionAttrName, Object> sessionMap,HttpServletRequest request) {
		if(sessionMap==null || sessionMap.size()==0)
			return;
		
		HttpSession session = request.getSession(true);
		for(Map.Entry<SessionAttrName, Object> m : sessionMap.entrySet()) {
			 if(m.getValue() == null || "".equals(m.getValue()) || m.getKey() == null) {
				 continue;
			 }
			 session.setAttribute(m.getKey().toString(), m.getValue());
		}
	}
	
}
