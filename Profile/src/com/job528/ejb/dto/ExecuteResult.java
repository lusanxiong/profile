package com.job528.ejb.dto;

import java.io.Serializable;


/**
 * 方法执行结果 数据传输对象
 * 
 * @author lusanxiong
 *
 */
public class ExecuteResult implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private boolean flag;     //执行是否成功. 
	private String  message;  //执行结果信息
	private String  resultId; //执行结果返回的唯一标识
	
	public ExecuteResult(boolean flag, String message, String resultId) {
		this.flag = flag;
		this.message = message;
		this.resultId = resultId;
	}
	
	public ExecuteResult() {
		
	}
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getResultId() {
		return resultId;
	}
	public void setResultId(String resultId) {
		this.resultId = resultId;
	}
	
	@Override
	public String toString() {
		return "flag="+flag+"|message="+message+"|resultId="+resultId;
	}
	
	
	
}
