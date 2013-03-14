package com.job528.profile.vo;


import com.job528.profile.model.MemInfo;
import com.job528.profile.model.MemPosition;
import com.job528.profile.model.MyFavouriate;
import com.job528.profile.util.ResumeUtil;
import com.job528.util.AreaUtil;
import com.job528.util.DateUtil;
import com.job528.util.StrUtils;

public class Favouriate {

	private MyFavouriate myFavouriate;
	private MemPosition position;
	private MemInfo memInfo;
	
	private String favouriateDate;
	
	private String jobLocation;
	
	private String degree;
	
	private String workYear;
	
	public String getWorkYear() {
		int wy = (int)this.position.getReqWorkyear();
		switch(wy){
		case -1:
			workYear = "毕业生";
			break;
		case 11:
			workYear = "不限";
			break;
			default:
				workYear = wy + "年以上";
				break;	
			
		}
		return workYear;
	}
	public String getDegree() {
		degree = ResumeUtil.getDegreeById(this.position.getReqDegreeId().toString());
		return degree;
	}
	public String getJobLocation() {
		if(StrUtils.isNull(this.position.getJobLocation()))
			return "";
		this.jobLocation = "";
		String locs[] = this.position.getJobLocation().replace("|", ",").split(",");
		for(String loc : locs){
			String locc = AreaUtil.getAddressById(loc);
			if(!StrUtils.isNull(locc)){
				this.jobLocation += locc + "  ";
			}
			
		}
		
		return jobLocation;
	}
	public String getFavouriateDate() {

		favouriateDate = DateUtil.dateToString(this.myFavouriate.getOperateDate());
	
		return favouriateDate;
	}
	public MyFavouriate getMyFavouriate() {
		return myFavouriate;
	}
	public void setMyFavouriate(MyFavouriate myFavouriate) {
		this.myFavouriate = myFavouriate;
	}
	public MemPosition getPosition() {
		return position;
	}
	public void setPosition(MemPosition position) {
		this.position = position;
	}
	public MemInfo getMemInfo() {
		return memInfo;
	}
	public void setMemInfo(MemInfo memInfo) {
		this.memInfo = memInfo;
	}
	
	
	
	public static void main(String args[]){
		String sss = "ddddd|fffff";
		String a[] = sss.replace("|", ",").split(",");
		
		for(String a1 : a){
			System.out.print(a1);
		}
		
	}
}
