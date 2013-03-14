package com.job528.common;

import org.junit.Test;

import com.job528.common.DataDictionary.JobFunction;


public class DataDictionaryTest {
	
	public enum JobFunction {
		EMPTY(0); //岗位类别为空,值为0
		
		private int jobFunctionId;
		private JobFunction(int jobFunctionId) {
			this.jobFunctionId = jobFunctionId;
		}
		
		@Override
        public String toString() {
			return String.valueOf(this.jobFunctionId);
        } 
	}
	
	public static final int test1 = 0;
	public static final int test2 = 1;
	
	@Test
	public void test() {
		System.out.println(Integer.parseInt(JobFunction.EMPTY.toString()));
		System.out.println(test1);
		System.out.println(test2);
		
	}

}
