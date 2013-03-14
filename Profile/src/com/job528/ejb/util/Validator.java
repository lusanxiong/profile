package com.job528.ejb.util;

import java.math.BigInteger;


/**
 * 验证器
 * @author Sunday
 *
 */
public class Validator {

	public static void validateUserId(String exp,Integer userId){
		validateNumber(exp, "userId", userId);
	}
	
	public static void validateWeiboId(String exp,BigInteger weiboId){
		validateBigInteger(exp, "weiboId", weiboId);
	}
	
	public static void validateCommentId(String exp,BigInteger commentId){
		validateBigInteger(exp, "commentId", commentId);
	}
	
	public static void validatePageIndex(String exp,Integer pageIndex){
		validateNumber(exp, "pageIndex", pageIndex);
	}
	
	public static void validatePageSize(String exp,Integer pageSize){
		validateNumber(exp, "pageSize", pageSize);
	}
	
	public static void validateBigInteger(String exp,String name,BigInteger num){
		if(null == num) {
			throw new NullPointerException(exp + name +" 不能为 null");
		}
		if(num.compareTo(BigInteger.valueOf(1))<0) {
			throw new RuntimeException(exp + name +" 不能小于 1");
		}
	}
	
	public static void validateNumber(String exp,String name ,Integer num){
		if(null == num){
			throw new NullPointerException(exp + name+ " 不能为 null");
		}
		if(num < 1) {
			throw new RuntimeException(exp + name + " 不能小于 1");
		}
	}
	
	public static void validateObject(String exp,Object obj){
		if(null == obj){
			throw new NullPointerException(exp + " 对象不能为 null");
		}
	}
}
