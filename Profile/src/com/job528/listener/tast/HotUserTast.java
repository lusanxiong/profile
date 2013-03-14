package com.job528.listener.tast;

import java.util.List;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import com.job528.lucene.bean.UserInfo;
import com.job528.profile.service.IFriendService;
import com.job528.profile.vo.Follower;
import com.job528.util.FileHelper;
import com.job528.util.StrUtils;
import com.job528.util.web.WebUtil;

public class HotUserTast extends TimerTask{

	private static String TEMPLATE_FILE_HOTUSER = "template\\hot_user";
	private static String RESULT_FILE_HOTUSER = "html\\hot_user";
	private static String TEMPLATE_FILE_SUFFIX = ".jsp";
	private static boolean isRunning = false;
	private ServletContext context = null;
	public HotUserTast(ServletContext context) {
		this.context=context;
	}
	
	@Override
	public void run() {
		if (!isRunning) 
		{ 
				isRunning = true;
				context.log("开始执行生成任务");
				String root = getRootPath();
				StringBuffer hotString = FileHelper.readFileByLines(root + TEMPLATE_FILE_HOTUSER + TEMPLATE_FILE_SUFFIX);
				
				if(!StrUtils.isNull(hotString.toString())){
					this.buildHotUserFile(hotString.toString());
				}
				isRunning = false;
				context.log("生成任务执行结束");
		} else 
		{
			context.log("上一次生成任务执行还未结束");
		}
	}

	
	private void buildHotUserFile(String tempString){
		String root = getRootPath(); 
		IFriendService friendService = (IFriendService)WebUtil.getBean(this.context, "friendService");
		List<Follower> follows = friendService.getTopHotUser(10);
		if(follows != null && follows.size() >0){
			String hids = "";
			for(int i=0; i<follows.size(); i++){
				Follower follow = follows.get(i);
				if(hids != "")
					hids += ",";
				hids += follow.getFriend().getUserProfile().getUserId();
			}
			for(int i=0; i<follows.size(); i++){
				String writeString = tempString;
				writeString = writeString.replace("#hids#", hids);
				 
			    int prve = i - 1;
			    int next = i + 1;
			    if(prve < 0) prve = 9;
			    if(next > 9) next = 0;
			    
			    writeString = writeString.replace("#prve#", prve+"");
			    writeString = writeString.replace("#next#", next+"");
				Follower follow = follows.get(i);
				UserInfo user = follow.getUserInfo();
			    writeString = writeString.replace("#name#", user != null ? user.getName() : "");
			   
			    String headImg = follow.getUhead();
			    if(StrUtils.isNull(headImg)){
			    	headImg = "../images/people.gif";
			    }else{
			    	if(headImg.indexOf("http://") == -1){
			    		headImg = "../" + headImg;
			    	}
			    }
			    
			    writeString = writeString.replace("#head#", headImg);
			    
			    String sexImg = "../images/search_friends_men.gif";
			    if(user != null && user.getSex() != 1){
			    	sexImg = "../images/search_friends_women.gif";
			    }
			   
			    String place = "";
			    if(user != null && user.getPlace() != null){
			    	place = user.getPlace().replace(",", " ");
			    }
			    writeString = writeString.replace("#sex#", sexImg);
			    writeString = writeString.replace("#uid#", follow.getFriend().getUserProfile().getUserId()+"");
			    writeString = writeString.replace("#place#", place);
			    writeString = writeString.replace("#school#", follow.getSchool());
			    writeString = writeString.replace("#speciality#", follow.getSpeciality());
			    writeString = writeString.replace("#num1#", follow.getFollewsNum()+"");
			    writeString = writeString.replace("#num2#", follow.getFansNum()+"");
			    writeString = writeString.replace("#num3#", follow.getMessageNum()+"");
			    FileHelper.writeFile(root + RESULT_FILE_HOTUSER + i + TEMPLATE_FILE_SUFFIX , writeString);
			}
		}
	}
	
	
	private String getRootPath(){
		return this.context.getRealPath("/");
	}
	
	public static void main(String args[]){
		String root = "D:\\jboss-5.1.0.GA\\server\\default\\deploy\\Profile.war";
		String templateFileName = root + "\\template\\hot_user.html"; 
		String newFileName = root + "\\html\\hot_user.html"; 
		
		StringBuffer hotString = FileHelper.readFileByLines(templateFileName);
		
		if(!StrUtils.isNull(hotString.toString())){
			String writeString = hotString.toString();
			writeString = writeString.replace("#name#", "528会员");
			FileHelper.writeFile(newFileName, writeString);
		}
	}

}
