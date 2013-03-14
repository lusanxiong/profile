package com.job528.profile.vo;

import java.util.Map;

import com.job528.profile.model.MyResume;
import com.job528.profile.util.ResumeUtil;
import com.job528.util.Area;
import com.job528.util.AreaUtil;
import com.job528.util.DateUtil;
import com.job528.util.JsonUtils;
import com.job528.util.StrUtils;

public class Resume extends BaseVO{

	private MyResume myResume;
	
	private String cardType;
	
	private String jobState;
	
	private String maritalStatus;
	
	private String birthDay;
	
	private String homeTown;
	
	private String location;
	
	private String provinceLocation; //包括省份+城市
	
	private String lastPostName;//最近一次工作经历所担任的职务名称
	

	public String getLastPostName() {
		return lastPostName;
	}


	public void setProvinceLocation(String provinceLocation) {
		this.provinceLocation = provinceLocation;
	}



	public void setLastPostName(String lastPostName) {
		this.lastPostName = lastPostName;
	}



	public String getImgHead() {
		
		if(this.myResume == null)
			return ResumeUtil.defaultHeadImg;
		if(StrUtils.isNull(this.myResume.getPhotoName()))
			return ResumeUtil.defaultHeadImg;
		return this.myResume.getPhotoName();
	}



	public MyResume getMyResume() {
		return myResume;
	}



	public void setMyResume(MyResume myResume) {
		this.myResume = myResume;
	}



	public String getCardType() {
		cardType = ResumeUtil.getCardTypeById(this.myResume.getCardType().toString());
		return cardType;
	}



	public String getJobState() {
		jobState = ResumeUtil.getJobStateById(this.myResume.getFlother());
		return jobState;
	}



	public String getMaritalStatus() {
		maritalStatus = ResumeUtil.getMaritalStatusById(this.myResume.getMaritalStatus().toString());
		return maritalStatus;
	}



	public String getBirthDay() {
		birthDay = DateUtil.dateToString(this.myResume.getBirthday());
		return birthDay;
	}



	public String getHomeTown() {
		homeTown = AreaUtil.getAddressById(this.myResume.getHometown());
		return homeTown;
	}



	public String getHomeCity() {
		
		Map<String, Area>  area = AreaUtil.getAddress(this.myResume.getHometown());
		if(area == null || area.size() <=0)
			return "";
		Area city = area.get(AreaUtil.ADDRESS_CITY);
		if(city == null){
			return "";
		}
		return city.getName();
	}



	public String getHomeProvince() {
		Map<String, Area>  area = AreaUtil.getAddress(this.myResume.getHometown());
		if(area == null || area.size() <=0)
			return "";
		Area province = area.get(AreaUtil.ADDRESS_PROVINCE);
		if(province == null){
			return "";
		}
		return province.getName();
	}



	public String getLocation() {
		location = AreaUtil.getAddressById(this.myResume.getLocation());
		return location;
	}
	
	public String getProvinceLocation() {
		String locationCode = this.myResume.getLocation();
		Map<String, Area> locationArea = AreaUtil.getAddress(locationCode);
		
		String place = "";
		if(locationArea!=null){
			 Area cityArea = locationArea.get(AreaUtil.ADDRESS_CITY);
			 Area provinceArea = locationArea.get(AreaUtil.ADDRESS_PROVINCE);
			 
			 if(provinceArea != null && !StrUtils.isNull(provinceArea.getName())){
				 place += provinceArea.getName();
			 }
			 
			 if(cityArea != null && !StrUtils.isNull(cityArea.getName())){
				 if(place.length() > 0){
					 place += " ";
				 }
				 place += cityArea.getName();
			 }
		}
		provinceLocation = place;
		return provinceLocation;
	}

	public String getJsonString(){
		return JsonUtils.getJsonString4JavaPOJO(this.myResume);
	} 


	@Override
	protected boolean validator() {
		// TODO Auto-generated method stub
		return false;
	}

}
