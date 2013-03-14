package com.job528.profile.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.job528.lucene.bean.Condition;
import com.job528.profile.model.MyResume;
import com.job528.profile.model.MySearcher;
import com.job528.util.AreaUtil;
import com.job528.util.Job;
import com.job528.util.StrUtils;
import com.job528.util.StringUtil;
import com.job528.util.web.InitServlet;

public class JobUtil {
	
	
	
	/**
	 * 根据求职意向，初始化职位查询条件
	 * @param resume
	 * @param simple 简单为：true， 只查询希望职位关键字和地区
	 * @return
	 */
	public static Condition getConditionByIntention(MyResume resume, boolean simple){
		Condition condition = null;
		if(resume != null){
			String jobFunction1 = resume.getJobFunction1().toString();
			String jobFunction2 = resume.getJobFunction2().toString();
			String jobFunction3 = resume.getJobFunction3().toString();
			String providesalary = resume.getSalary().toString();
			if(simple){
				jobFunction1 = "0";
				jobFunction2 = "0";
				jobFunction3 = "0";
				providesalary = "0";
			}
			

			String jobLocation1 = resume.getJobLocation1();
			String jobLocation2 = resume.getJobLocation2();
			String jobLocation3 = resume.getJobLocation3();

			String calling1 = "";
			String calling2 = "";
			String calling3 = "";

			String positionPostDate = "";
			String ReqWorkyear = "";
			String degreeID = "";
			String properity = "";
			String keyword = "";
			String keywordType = "0";
			
            
            String jobSeeking1 = resume.getJobSeeking1();
            String jobSeeking2 = resume.getJobSeeking2();
            String jobSeeking3 = resume.getJobSeeking3();
            
            if(!StrUtils.isNull(jobSeeking1)){
            	keyword += jobSeeking1 + " ";
            }
            
            if(!StrUtils.isNull(jobSeeking2)){
            	keyword += jobSeeking2 + " ";
            }
            
            if(!StrUtils.isNull(jobSeeking3)){
            	keyword += jobSeeking3 + " ";
            }
			
			condition = new Condition();
			
			if(StringUtil.isValidStr(calling1)){
				String cName = JobUtil.getJobById(calling1);
				condition.setCalling1Name(cName);
			}else{
				condition.setCalling1Name("");
			}
			
			if(StringUtil.isValidStr(calling2)){
				String cName = JobUtil.getJobById(calling2);
				condition.setCalling2Name(cName);
			}else{
				condition.setCalling2Name("");
			}
			
			if(StringUtil.isValidStr(calling3)){
				String cName = JobUtil.getJobById(calling3);
				condition.setCalling3Name(cName);
			}else{
				condition.setCalling3Name("");
			}
			
			if(StringUtil.isValidStr(jobFunction1)){
				String cName = JobUtil.getJobById(jobFunction1);
				condition.setJobFunction1Name(cName);
			}else{
				condition.setJobFunction1Name("");
			}
			
			if(StringUtil.isValidStr(jobFunction2)){
				String cName = JobUtil.getJobById(jobFunction2);
				condition.setJobFunction2Name(cName);
			}else{
				condition.setJobFunction2Name("");
			}
			
			if(StringUtil.isValidStr(jobFunction3)){
				String cName = JobUtil.getJobById(jobFunction3);
				condition.setJobFunction3Name(cName);
			}else{
				condition.setJobFunction3Name("");
			}
			
			
			//
			if(StringUtil.isValidStr(jobLocation1)){
				String jobLocationName = AreaUtil.getAddressById(jobLocation1);
				condition.setJobLocation1_Name(jobLocationName);
			}else{
				condition.setJobLocation1_Name("");
			}
			
			if(StringUtil.isValidStr(jobLocation2)){
				String jobLocationName = AreaUtil.getAddressById(jobLocation2);
				condition.setJobLocation2_Name(jobLocationName);
			}else{
				condition.setJobLocation2_Name("");
			}
			
			if(StringUtil.isValidStr(jobLocation3)){
				String jobLocationName = AreaUtil.getAddressById(jobLocation3);
				condition.setJobLocation3_Name(jobLocationName);
			}else{
				condition.setJobLocation3_Name("");
			}
			
			
			if(StringUtil.isValidStr(positionPostDate)){
				condition.setPositionPostDate(Integer.parseInt(positionPostDate));
			}else{
				condition.setPositionPostDate(0);
			}
			
			
			if(StringUtil.isValidStr(ReqWorkyear)){
				condition.setReqWorkyear(Integer.parseInt(ReqWorkyear));
			}else{
				condition.setReqWorkyear(11);
			}
			
			if(StringUtil.isValidStr(degreeID)){
				condition.setDegreeID(Integer.parseInt(degreeID));
			}else{
				condition.setDegreeID(-1);
			}
			
			if(StringUtil.isValidStr(properity)){
				condition.setProperity(Integer.parseInt(properity));
			}else{
				condition.setProperity(-1);
			}
			
			if(StringUtil.isValidStr(providesalary)){
				condition.setProvidesalary(Integer.parseInt(ResumeUtil.getSalaryBaseById(providesalary)));
			}else{
				condition.setProvidesalary(-1);
			}
			
			if(StringUtil.isValidStr(keyword)){
				condition.setKeyword(keyword);
			}else{
				condition.setKeyword("");
			}
			
			
			if(StringUtil.isValidStr(keywordType)){
				condition.setKeywordType(Integer.parseInt(keywordType));
			}else{
				condition.setKeywordType(2);
			}
		
            
		}
		return condition;
	}

	
	
	
	
	
	
	public static Condition convertRequest2Condition(Condition condition,HttpServletRequest request){
		if(condition == null || request == null)
			return null;
		String jobFunction1 = request.getParameter("jobFunction1");
		String jobFunction2 = request.getParameter("jobFunction2");
		String jobFunction3 = request.getParameter("jobFunction3");

		String jobLocation1 = request.getParameter("jobLocation1");
		String jobLocation2 = request.getParameter("jobLocation2");
		String jobLocation3 = request.getParameter("jobLocation3");

		String calling1 = request.getParameter("calling1");
		String calling2 = request.getParameter("calling2");
		String calling3 = request.getParameter("calling3");

		String positionPostDate = request.getParameter("positionPostDate");
		String ReqWorkyear = request.getParameter("ReqWorkyear");
		String degreeID = request.getParameter("degreeID");
		String properity = request.getParameter("properity");
		String providesalary = request.getParameter("providesalary");
		String keyword = request.getParameter("keyword");
		String keywordType = request.getParameter("keywordType");
	
		
		if(StringUtil.isValidStr(calling1)){
			String cName = JobUtil.getJobById(calling1);
			condition.setCalling1Name(cName);
		}else{
			condition.setCalling1Name("");
		}
		
		if(StringUtil.isValidStr(calling2)){
			String cName = JobUtil.getJobById(calling2);
			condition.setCalling2Name(cName);
		}else{
			condition.setCalling2Name("");
		}
		
		if(StringUtil.isValidStr(calling3)){
			String cName = JobUtil.getJobById(calling3);
			condition.setCalling3Name(cName);
		}else{
			condition.setCalling3Name("");
		}
		
		if(StringUtil.isValidStr(jobFunction1)){
			String cName = JobUtil.getJobById(jobFunction1);
			condition.setJobFunction1Name(cName);
		}else{
			condition.setJobFunction1Name("");
		}
		
		if(StringUtil.isValidStr(jobFunction2)){
			String cName = JobUtil.getJobById(jobFunction2);
			condition.setJobFunction2Name(cName);
		}else{
			condition.setJobFunction2Name("");
		}
		
		if(StringUtil.isValidStr(jobFunction3)){
			String cName = JobUtil.getJobById(jobFunction3);
			condition.setJobFunction3Name(cName);
		}else{
			condition.setJobFunction3Name("");
		}
		
		
		//
		if(StringUtil.isValidStr(jobLocation1)){
			String jobLocationName = AreaUtil.getAddressById(jobLocation1);
			condition.setJobLocation1_Name(jobLocationName);
		}else{
			condition.setJobLocation1_Name("");
		}
		
		if(StringUtil.isValidStr(jobLocation2)){
			String jobLocationName = AreaUtil.getAddressById(jobLocation2);
			condition.setJobLocation2_Name(jobLocationName);
		}else{
			condition.setJobLocation2_Name("");
		}
		
		if(StringUtil.isValidStr(jobLocation3)){
			String jobLocationName = AreaUtil.getAddressById(jobLocation3);
			condition.setJobLocation3_Name(jobLocationName);
		}else{
			condition.setJobLocation3_Name("");
		}
		
		
		if(StringUtil.isValidStr(positionPostDate)){
			condition.setPositionPostDate(Integer.parseInt(positionPostDate));
		}else{
			condition.setPositionPostDate(0);
		}
		
		
		if(StringUtil.isValidStr(ReqWorkyear)){
			condition.setReqWorkyear(Integer.parseInt(ReqWorkyear));
		}else{
			condition.setReqWorkyear(11);
		}
		
		if(StringUtil.isValidStr(degreeID)){
			condition.setDegreeID(Integer.parseInt(degreeID));
		}else{
			condition.setDegreeID(-1);
		}
		
		if(StringUtil.isValidStr(properity)){
			condition.setProperity(Integer.parseInt(properity));
		}else{
			condition.setProperity(-1);
		}
		
		if(StringUtil.isValidStr(providesalary)){
			condition.setProvidesalary(Integer.parseInt(ResumeUtil.getSalaryBaseById(providesalary)));
		}else{
			condition.setProvidesalary(-1);
		}
		
		if(StringUtil.isValidStr(keyword)){
			condition.setKeyword(keyword);
		}else{
			condition.setKeyword("");
		}
		
		
		if(StringUtil.isValidStr(keywordType)){
			condition.setKeywordType(Integer.parseInt(keywordType));
		}else{
			condition.setKeywordType(2);
		}
	
		return condition;
	}
	
	
	public static MySearcher convertRequest2Searcher(MySearcher searcher,HttpServletRequest request){
		if(searcher == null || request == null)
			return null;
		String jobFunction1 = request.getParameter("jobFunction1");
		String jobFunction2 = request.getParameter("jobFunction2");
		String jobFunction3 = request.getParameter("jobFunction3");

		String jobLocation1 = request.getParameter("jobLocation1");
		String jobLocation2 = request.getParameter("jobLocation2");
		String jobLocation3 = request.getParameter("jobLocation3");

		String calling1 = request.getParameter("calling1");
		String calling2 = request.getParameter("calling2");
		String calling3 = request.getParameter("calling3");

		String positionPostDate = request.getParameter("positionPostDate");
		String ReqWorkyear = request.getParameter("ReqWorkyear");
		String degreeID = request.getParameter("degreeID");
		String keyword = request.getParameter("keyword") != null ?  request.getParameter("keyword") : "";
		
		Integer keywordType = request.getParameter("keywordType") != null ?  Integer.parseInt(request.getParameter("keywordType")) : 2;
		
		searcher.setKeyword(keyword);
		searcher.setKeywordType(keywordType);
		
		if(StringUtil.isValidStr(calling1)){
			searcher.setCalling1(Integer.parseInt(calling1));
		}else{
			searcher.setCalling1(0);
		}
		
		if(StringUtil.isValidStr(calling2)){
			searcher.setCalling2(Integer.parseInt(calling2));
		}else{
			searcher.setCalling2(0);
		}
		
		if(StringUtil.isValidStr(calling3)){
			searcher.setCalling3(Integer.parseInt(calling3));
		}else{
			searcher.setCalling3(0);
		}
		
		//
		if(StringUtil.isValidStr(jobFunction1)){
			searcher.setJobFunction1(Short.valueOf(jobFunction1));
		}else{
			searcher.setJobFunction1(Short.valueOf("0"));
		}
		
		if(StringUtil.isValidStr(jobFunction2)){
			searcher.setJobFunction2(Short.valueOf(jobFunction2));
		}else{
			searcher.setJobFunction2(Short.valueOf("0"));
		}
		
		if(StringUtil.isValidStr(jobFunction3)){
			searcher.setJobFunction3(Short.valueOf(jobFunction3));
		}else{
			searcher.setJobFunction3(Short.valueOf("0"));
		}
		
		
		//
		if(StringUtil.isValidStr(jobLocation1)){
			searcher.setJobLocation1(jobLocation1);
		}else{
			searcher.setJobLocation1("");
		}
		
		if(StringUtil.isValidStr(jobLocation2)){
			searcher.setJobLocation2(jobLocation2);
		}else{
			searcher.setJobLocation2("");
		}
		
		if(StringUtil.isValidStr(jobLocation3)){
			searcher.setJobLocation3(jobLocation3);
		}else{
			searcher.setJobLocation3("");
		}
		
		
		if(StringUtil.isValidStr(positionPostDate)){
			searcher.setPositionPostDate(Integer.parseInt(positionPostDate));
		}else{
			searcher.setPositionPostDate(0);
		}
		
		
		if(StringUtil.isValidStr(ReqWorkyear)){
			searcher.setWorkedYear1(Integer.parseInt(ReqWorkyear));
		}else{
			searcher.setWorkedYear1(0);
		}
		
		searcher.setWorkedYear2(-1);
		
		if(StringUtil.isValidStr(degreeID)){
			searcher.setDegreeId1(Integer.parseInt(degreeID));
		}else{
			searcher.setDegreeId1(-1);
		}
		searcher.setDegreeId2(-1);
		
		
		String ckMobileOrder = request.getParameter("ckMobileOrder");
		String ckEmailOrder = request.getParameter("ckEmailOrder");
		
		//searcher.setMyUserId(this.getUserId());
		searcher.setOtherflag(0);
		searcher.setRegisterDate(new java.sql.Date(new Date().getTime()));
		searcher.setSearcherName(request.getParameter("searcherName"));
		searcher.setSex(Short.valueOf("0")); //default 0
		searcher.setAge(Short.valueOf("0")); //default 0
		
		if(StringUtil.isValidStr(ckMobileOrder)){
			searcher.setPhoneOrder(true);
			searcher.setMobileNum(ckMobileOrder);
		}else{
			searcher.setPhoneOrder(false);
			searcher.setMobileNum("");
		}
		if(StringUtil.isValidStr(ckEmailOrder)){
			searcher.setSubscibeFlag(true); //邮件订阅
			searcher.setEmail(ckEmailOrder);
		}else{
			searcher.setSubscibeFlag(false); //邮件订阅
			searcher.setEmail("");
		}
		
		return searcher;
	}
	
	
	public static String JOB_CALLING = "_job_calling";
	public static String JOB_JOB = "_job_job";


	public static Map<String, Job> getJob(String callingId){
		
		if(StrUtils.isNull(callingId))
			return null;
		
		Job tempJob = null;
		Job callingJob = new Job();
		Job jobJob = new Job();
		if(InitServlet.jobMap.containsKey(callingId)){
			tempJob = InitServlet.jobMap.get(callingId);
			jobJob.setId(callingId);
			jobJob.setName(tempJob.getName());
			callingJob.setId(tempJob.getPid());
			callingId = tempJob.getPid();
		}
		if(InitServlet.callingMap.containsKey(callingId)){
			tempJob = InitServlet.callingMap.get(callingId);
			callingJob.setId(callingId);	
			callingJob.setName(tempJob.getName());
		}
		
		
		Map<String, Job> job = new HashMap<String, Job>(2);
		if(jobJob != null){
			job.put(JOB_JOB, jobJob);
		}
		if(callingJob != null){
			job.put(JOB_CALLING, callingJob);
		}
		
		
		return job;
	}
	
	
	public static String getCallingById(String callingId){
		if(StrUtils.isNull(callingId))
			return "";
		if(!InitServlet.callingMap.containsKey(callingId))
			return "";
		Job job = InitServlet.callingMap.get(callingId);
		if(job == null)
			return "";
		
		return job.getName();	
	}
	
	public static String getJobById(String jobId){
		if(StrUtils.isNull(jobId))
			return "";
		if(InitServlet.jobMap.containsKey(jobId))
			return InitServlet.jobMap.get(jobId).getName();
		if(InitServlet.callingMap.containsKey(jobId)){
			return InitServlet.callingMap.get(jobId).getName();
		}
		
		return "";
	}
	
}
