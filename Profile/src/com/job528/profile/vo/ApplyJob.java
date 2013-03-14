package com.job528.profile.vo;

import java.util.Date;

import com.job528.util.AreaUtil;
import com.job528.util.DateUtil;
import com.job528.util.StringUtil;

public class ApplyJob extends BaseVO {

	private String applyDate;
	
	private int applyId;
	
	private int memId;
	
	private int posId;
	
	private int applyNumber;
	
	private String inviteFlag;
	
	private String memFlag;
	
	private String posState;
	
	private String memName;
	
	private String posName;
	
	private String jobLocation;
	
	
	
	private String endValidDate;
	
	private String memMemo;
	
	
	private String memReply;
	
	
	
	
	public String getMemMemo() {
		return memMemo;
	}




	public void setMemMemo(String memMemo) {
		this.memMemo = memMemo;
	}




	public String getApplyDate() {
		return applyDate;
	}




	public void setApplyDate(String appDate) {
		if(StringUtil.isValidStr(appDate)){	
			Date date = DateUtil.stringToDateTime(appDate);
			this.applyDate = DateUtil.dateToString(date);
		}
	}




	public int getApplyId() {
		return applyId;
	}




	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}




	public int getMemId() {
		return memId;
	}




	public void setMemId(int memId) {
		this.memId = memId;
	}




	public int getPosId() {
		return posId;
	}




	public void setPosId(int posId) {
		this.posId = posId;
	}




	public int getApplyNumber() {
		return applyNumber;
	}




	public void setApplyNumber(int applyNumber) {
		this.applyNumber = applyNumber;
	}




	public String getInviteFlag() {
		return inviteFlag;
	}




	public void setInviteFlag(String inviteFlag) {
		this.inviteFlag = inviteFlag;
	}




	public String getMemFlag() {
		if("0".equals(memFlag))
			//memFlag = "未阅读";
		    memFlag = "0";
		else if(Integer.parseInt(memFlag) > 0){
			memFlag = "1";
			//memFlag = "已阅读";
		}
		
		if(this.memReply!=null&&this.memReply.length()>0){
			//memFlag="<IMG alt=有回复 src='../images/mail4_ico.gif' border=0>";
			memFlag = "2";
		}
		return memFlag;
	}




	public void setMemFlag(String memFlag) {
		this.memFlag = memFlag;
	}




	public String getPosState() {
		return posState;
	}




	public void setPosState(String posState) {
		this.posState = posState;
	}




	public String getMemName() {
		return memName;
	}




	public void setMemName(String memName) {
		this.memName = memName;
	}




	public String getPosName() {
		return posName;
	}




	public void setPosName(String posName) {
		this.posName = posName;
	}




	public String getJobLocation() {
		return jobLocation;
	}




	public void setJobLocation(String jobLocation) {
		if(StringUtil.isValidStr(jobLocation)){
			this.jobLocation = AreaUtil.getAddressById(jobLocation);
		}
	}



	public String getEndValidDate() {
		return endValidDate;
	}




	public void setEndValidDate(String endValidDate) {
		this.endValidDate = endValidDate;
	}



	public String getMemReply() {
		return memReply;
	}




	public void setMemReply(String memReply) {
		this.memReply = memReply;
	}




	@Override
	protected boolean validator() {
		// TODO Auto-generated method stub
		return false;
	}

}
