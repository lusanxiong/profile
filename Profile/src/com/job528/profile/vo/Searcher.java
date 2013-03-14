package com.job528.profile.vo;

import com.job528.profile.model.MySearcher;
import com.job528.profile.util.JobUtil;
import com.job528.profile.util.ResumeUtil;
import com.job528.util.AreaUtil;
import com.job528.util.DateUtil;
import com.job528.util.StringUtil;

public class Searcher extends BaseVO {

	private MySearcher mySearcher;
	
	private String orderSumary;
	
	private String upDateTime;
	
	private String location;
	
	private String calling;
	
	private String function;
	
	private String postDateStr;
	
	private String workYearStr;
	
	private String degreeStr;

	
	public MySearcher getMySearcher() {
		return mySearcher;
	}

	public void setMySearcher(MySearcher mySearcher) {
		this.mySearcher = mySearcher;
	}

	public String getOrderSumary() {
		if(this.mySearcher == null)
			return "";
		orderSumary = "";
		if(this.mySearcher.getPhoneOrder()){
			orderSumary = "手机";
		}
		if(this.mySearcher.getSubscibeFlag()){
			if(orderSumary != ""){
				orderSumary += "、";
			}
			orderSumary += "邮件";
		}
		if(orderSumary ==""){
			orderSumary = "未";
		}
		orderSumary += "订阅";
		return orderSumary;
	}
	
	public String getUpDateTime() {
		if(this.mySearcher == null)
			return "";
		upDateTime = DateUtil.dateToString(this.mySearcher.getRegisterDate());
		return upDateTime;
	}

	public String getLocation() {
		if(this.mySearcher == null)
			return "职位地区";
		location = "";
		if (this.mySearcher.getJobLocation1() != ""){
			String loc = AreaUtil.getAddressById(this.mySearcher.getJobLocation1());
			if(StringUtil.isValidStr(loc)){
				location += loc;
			}
		}
		if (this.mySearcher.getJobLocation2() != ""){
			String loc = AreaUtil.getAddressById(this.mySearcher.getJobLocation3());
			if(StringUtil.isValidStr(loc)){
				location += " " + loc;
			}
		}
		
		if (this.mySearcher.getJobLocation3() != ""){
			String loc = AreaUtil.getAddressById(this.mySearcher.getJobLocation3());
			if(StringUtil.isValidStr(loc)){
				location += " " + loc;
			}
		}
		if(location == ""){
			location = "职位地区";
		}
		return location;
	}

	public String getCalling() {
		if(this.mySearcher == null)
			return "所在行业";
		calling = "";
		if(this.mySearcher.getCalling1() > 0){
			String call = JobUtil.getJobById(this.mySearcher.getCalling1().toString());
			if(StringUtil.isValidStr(call)){
				calling  += call;
			}
		}
		
		if(this.mySearcher.getCalling2() > 0){
			String call = JobUtil.getJobById(this.mySearcher.getCalling2().toString());
			if(StringUtil.isValidStr(call)){
				calling  += " " + call;
			}
		}
		
		if(this.mySearcher.getCalling3() > 0){
			String call = JobUtil.getJobById(this.mySearcher.getCalling3().toString());
			if(StringUtil.isValidStr(call)){
				calling  += " " + call;
			}
		}
		if(calling == ""){
			calling = "所在行业";
		}
		return calling;
	}

	public String getFunction() {
		if(this.mySearcher == null)
			return "岗位类别";
		function = "";
		if(this.mySearcher.getJobFunction1() > 0){
			String fun = JobUtil.getJobById(this.mySearcher.getJobFunction1().toString());
			if(StringUtil.isValidStr(fun)){
				function  += " " + fun;
			}
		}
		
		if(this.mySearcher.getJobFunction2() > 0){
			String fun = JobUtil.getJobById(this.mySearcher.getJobFunction2().toString());
			if(StringUtil.isValidStr(fun)){
				function  += " " + fun;
			}
		}
		
		if(this.mySearcher.getJobFunction3() > 0){
			String fun = JobUtil.getJobById(this.mySearcher.getJobFunction3().toString());
			if(StringUtil.isValidStr(fun)){
				function  += " " + fun;
			}
		}
		
		if(function == ""){
			function = "岗位类别";
		}
		return function;
	}

	public String getPostDateStr() {
		if(this.mySearcher == null)
			return "";
		Integer pid = this.getMySearcher().getPositionPostDate();
		String text = ResumeUtil.getPostDateById(pid.toString());
		if(text != null && text != ""){
		postDateStr = "<option value=\""+pid+"\" selected=\"selected\"> "+text+" </option>";
		}
		return postDateStr;
	}

	public String getWorkYearStr() {
		if(this.mySearcher == null)
			return "";
		Integer wid = this.getMySearcher().getWorkedYear1();
		String text = ResumeUtil.getWorkYearById(wid.toString());
		if(text != null && text != ""){
		workYearStr = "<option value=\""+wid+"\" selected=\"selected\"> "+text+" </option>";
		}
		return workYearStr;
	}

	public String getDegreeStr() {
		if(this.mySearcher == null)
			return "";
		Integer did = this.getMySearcher().getDegreeId1();
		String text = ResumeUtil.getDegreeById(did.toString());
		if(text != null && text != ""){
		degreeStr = "<option value=\""+did+"\" selected=\"selected\"> "+text+" </option>";
		}
		return degreeStr;
	}

	@Override
	protected boolean validator() {
		// TODO Auto-generated method stub
		return false;
	}

}
