package com.job528.lucene.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.job528.profile.util.ResumeUtil;
import com.job528.util.StrUtils;

/**
 * 朋友信息
 * @author lusanxiong
 *
 */
public class UserInfo {

	/**
	 * 用户Id
	 */
	private int uid;
	
	/**
	 * 名字
	 */
	private String name;
	
	/**
	 * 性别
	 */
	private int sex;
	
	/**
	 * 籍贯
	 */
	private String houseHold ;
	
	
	
	/**
	 * 现居地
	 */
	private String place;
	
	

	/**
	 * 照片地址
	 */
	private String photo;
	
	/**
	 * 专业
	 */
	private String speciality;
	
    /**
     * 学校
     */
	private String school;
	
	
	/**
	 * 工作行业
	 */
	private String workCalling; 
	
	/**
	 * 工作公司
	 */
	private String workCompany; 
	
	
	/**
	 * 意向工作地
	 */
	private String intentionCity;
	
	
	/**
	 * 意向职位
	 */
	private String intentionPosition;
	
	/**
	 * 更新时间
	 */
	private Date updateDate;
	
	/**
	 * 简历状态
	 */
	private int status;
	
	
	/**
	 * 删除标志
	 */
	private int checkflag;
	
	
	/**
	 * 简介（自我介绍）
	 */
	private String introduction;
	
	/**
	 * 工作年
	 */
	private int workedYear;
	
	/**
	 * 工作月
	 */
	private int workedMonth;
	
	/**
	 * 工作公司数
	 */
	private int workedCompany;
	
	/**
	 * 全文搜索
	 */
	private String allContex;
	
	//朋友类型描述
	private String friendTypeDescription;
	
	//朋友类型
	private int friendType;
	
	//最近一次工作担任的职务
	private String lastPostName;
	
	//用户的标签(从lucene中查询出来的标签,默认逗号分隔)
	private String userLabelInfo;
	
	//用户的标签(用于界面上显示,包括选中的样式)
	private List<String> userLabelList;
	
	//用户选中的标签名称(用于界面搜索,每个标签 使用空格分隔)
	//private String selectUserLabel;
	
	public List<String> getUserLabelList() {
		List<String> list = null;
		
		String userLabel = userLabelInfo!=null ? userLabelInfo.trim() : "";
		if("".equals(userLabel)) return new ArrayList<String>(0);
		
		String[] labels = userLabel.split(",");
		if(labels!=null && labels.length > 0) {
			list = new ArrayList<String>(labels.length+1);
			
			String labelName = "";
			
			String labelStyle_start = "<p class=\"label_hover\"><span>";
			String labelStyle_end = "</span><em></em></p>";
			for(int i=0; i<labels.length; i++) {
				labelName = labels[i] !=null ? labels[i] : "";
				//selectUserLabel = selectUserLabel.concat(selectUserLabel);
				
				if(labelName.indexOf("<font color=\"red\">") > -1) {
					labelName = labelName.replaceAll("<font color=\"red\">", "")
										 .replaceAll("</font>", "");
					labelName = labelStyle_start+labelName+labelStyle_end;
				}else {
					labelName = "<p><span>"+labelName+labelStyle_end;
				}
				
				
				list.add(labelName);
			}
		}
		//System.out.println("list==="+list);
		
		
		return list;
	}


	public void setUserLabelList(List<String> userLabelList) {
		this.userLabelList = userLabelList;
	}

	public String getUserLabelInfo() {
		return userLabelInfo!=null ? userLabelInfo.trim() : "";
	}
	
	
	public void setUserLabelInfo(String userLabelInfo) {
		this.userLabelInfo = userLabelInfo;
	}

	public String getFriendTypeDescription() {
		return friendTypeDescription;
	}

	public void setFriendTypeDescription(String friendTypeDescription) {
		this.friendTypeDescription = friendTypeDescription;
	}

	public int getFriendType() {
		return friendType;
	}

	public void setFriendType(int friendType) {
		this.friendType = friendType;
	}

	public String getLastPostName() {
		return lastPostName;
	}

	public void setLastPostName(String lastPostName) {
		this.lastPostName = lastPostName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
	public int getCheckflag() {
		return checkflag;
	}

	public void setCheckflag(int checkflag) {
		this.checkflag = checkflag;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	

	public int getResumeStatus() {
		return resumeStatus;
	}

	public void setResumeStatus(int resumeStatus) {
		this.resumeStatus = resumeStatus;
	}

	protected int resumeStatus;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	

	public String getPhoto() {
		if(StrUtils.isNull(photo))
			photo = ResumeUtil.defaultHeadImg;
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	public String getWorkCalling() {
		return workCalling;
	}

	public void setWorkCalling(String workCalling) {
		this.workCalling = workCalling;
	}

	public String getWorkCompany() {
		return workCompany;
	}

	public void setWorkCompany(String workCompany) {
		this.workCompany = workCompany;
	}

	public String getAllContex() {
		return allContex;
	}

	public void setAllContex(String allContex) {
		this.allContex = allContex;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getIntentionCity() {
		return intentionCity;
	}

	public void setIntentionCity(String intentionCity) {
		this.intentionCity = intentionCity;
	}

	public String getIntentionPosition() {
		return intentionPosition;
	}

	public void setIntentionPosition(String intentionPosition) {
		this.intentionPosition = intentionPosition;
	}

	public String getHouseHold() {
		if(StrUtils.isNull(houseHold))
			houseHold = houseHold.replace(",", " ");
		return houseHold;
	}

	public void setHouseHold(String houseHold) {
		this.houseHold = houseHold;
	}

	public String getPlace() {
		if(!StrUtils.isNull(place))
			place = place.replace(",", " ");
		
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public int getWorkedYear() {
		return workedYear;
	}

	public void setWorkedYear(int workedYear) {
		this.workedYear = workedYear;
	}

	public int getWorkedMonth() {
		return workedMonth;
	}

	public void setWorkedMonth(int workedMonth) {
		this.workedMonth = workedMonth;
	}

	public int getWorkedCompany() {
		return workedCompany;
	}

	public void setWorkedCompany(int workedCompany) {
		this.workedCompany = workedCompany;
	}

	
}
