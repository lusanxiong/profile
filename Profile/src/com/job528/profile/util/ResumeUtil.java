package com.job528.profile.util;

import com.job528.util.StrUtils;

public class ResumeUtil {

	public static String defaultHeadImg = "images/people.gif";
	public static String[][] degree() {

		String[][] degree = { 
				
				{ "70", "博士", "Doctorate" },
				{ "60", "硕士", "Master" },
				{ "55", "MBA", "MBA" },
				{ "50", "本科", "Bachelor" },
				{ "40", "大专", "Associate" }, 
				{ "30", "中专", "Polytechnic" },
				{ "25", "中技", "Technical School" },
				{ "20", "高中", "High School     " },
				{ "10", "初中", "Junior High" },
				{ "90", "不限", "No limit" },
		};
		return degree;
	}
	
	
	public static String[][] companyType() {

		String[][] type = { 		
				{"1","外资"}, 
				{"2","合资"}, 
				{"3","国企"}, 
				{"4","民营公司"}, 
				{"5","其它性质"}
		};
		return type;
	}
	
	
	public static String[][] language() {

		String[][] language = {
		{ "1", "英语" },
		{ "2", "日语" },
		{ "3", "俄语" },
		{ "4", "阿拉伯语" },
		{ "5", "法语" },
		{ "6", "德语" },
		{ "7", "西班牙语" },
		{ "8", "葡萄牙语" },
		{ "9", "意大利语" }, 
		{ "10", "韩语/朝鲜语" },
		{ "11", "普通话" },
		{ "12", "粤语" },
		{ "13", "闽南语" },
		{ "14", "上海话" },
		{ "15", "其他" } 
		};
		return language;
	}

	public static String[][] languageLevel() {

		String[][] languageLevel = {
		{ "0", "不限" },
		{ "1", "一般" },
		{ "2", "良好" },
		{ "3", "熟练" },
		{ "4", "精通" } 
		};
		return languageLevel;
	}
	
	public static String[][] englishLevel() {

		String[][] englishLevel = {
				{"0","无"}, 
				  {"3","三级"}, 
				  {"4","四级"}, 
				  {"6","六级"}, 
				  {"8","八级"}, 
				  {"9","专业四级"}, 
				  {"10","专业八级"}
				  };
		return englishLevel;
	}

	
	
	public static String[][] japanLevel() {

		String[][] japanLevel = {
				  {"0","无"}, 
				  {"1","一级"}, 
				  {"2","二级"}, 
				  {"3","三级"}, 
				  {"4","四级"}
				  };
		return japanLevel;
	}
	
	public static String[][] computerLevel() {

		String[][] computerLevel = {
				{"1","初级"}, 
				  {"2","中级"}, 
				  {"3","高级"}, 
				  {"4","高校非计算机专业二级"}, 
				  {"5","高校非计算机专业三级(偏软)"}, 
				  {"6","高校非计算机专业三级(偏硬)"}, 
				  {"7","初级程序员"}, 
				  {"8","程序员"}, 
				  {"9","高级程序员"}, 
				  {"10","系统分析员"}, 
				  {"11","网络程序员"}, 
				  {"12","网络设计师"}, 
				  {"13","全国计算机等级考试一级"}, 
				  {"14","全国计算机等级考试二级"}, 
				  {"15","全国计算机等级考试三级"}, 
				  {"16","全国计算机等级考试四级"}, 
				  {"17","微软认证产品专家"}, 
				  {"18","微软认证网站建造专家(MCP+Site Builder)"}, 
				  {"19","微软认证系统工程师(MCSE)"}, 
				  {"20","微软认证数据库管理员(MCDBA)"}, 
				  {"21","微软认证开发专家(MCSD)"}, 
				  {"22","Cisco职业资格认证CCNA"}, 
				  {"23","Cisco职业资格认证CCDP"}, 
				  {"24","Cisco职业资格认证CCNP"}, 
				  {"25","Cisco职业资格认证CCIE"}, 
				  {"26","Oracle8数据库管理员"}, 
				  {"27","Lotus资格认证"}, 
				  {"28","Lotus-CLS资格认证"}, 
				  {"29","Lotus-CLI资格认证"}, 
				  {"30","Notes应用开发工程师"}, 
				  {"31","Notes系统管理工程师 "}, 
				  {"32","Notes高级应用开发工程师"}, 
				  {"33","Notes高级系统管理工程师"}, 
				  {"34","IBM-DB2数据库管理员"}, 
				  {"34","IBM-DB2应用开发专家"}, 
				  {"36","IBM-MQSeries工程师"}
				  };
		return computerLevel;
	}
	
	
	public static String[][] salary() {

		String[][] salary = {
				  {"0","面议"}, 
				  {"1","1500元/月以下"}, 
				  {"2","2000-2999元/月"}, 
				  {"3","3000-4499元/月"}, 
				  {"4","4500-5999元/月"}, 
				  {"5","6000-7999元/月"}, 
				  {"6","8000-9999元/月"}, 
				  {"7","10000-14999元/月"}, 
				  {"8","15000-19999元/月"}, 
				  {"9","20000-29999元/月"}, 
				  {"10","30000-49999元/月"}, 
				  {"11","50000及以上"}
				  };
		return salary;
	}
	
	
	/**
	 * 薪水起点
	 * @return
	 */
	public static String[][] salaryBase() {

		String[][] salary = {
				  {"0","0"}, 
				  {"1","1500"}, 
				  {"2","2000"}, 
				  {"3","3000"}, 
				  {"4","4500"}, 
				  {"5","6000"}, 
				  {"6","8000"}, 
				  {"7","10000"}, 
				  {"8","15000"}, 
				  {"9","20000"}, 
				  {"10","30000"}, 
				  {"11","50000"}
				  };
		return salary;
	}
	
	public static String[][] resumeStatus() {
		String[][] status = {
				  {"0","完全公开我的简历"}, 
				  {"1","不公开（完全保密，任何人都搜索不到您的简历）"}, 
				  {"2","公开"}
				  };
		return status;
	}
	
	public static String getResumeStatus(String id,String partComName) {
		String result = "";
		String[][] strs = ResumeUtil.resumeStatus();
		for(String[] str : strs){
			if(str[0].equals(id)){
				result = str[1];
				break;
			}
		}
		if("2".equals(id) && (null!=partComName && !"".equals(partComName.trim()))) {
			result += "，但对"+partComName+"企业保密 ";
		}
		return result;
	}
	
	
	/**
	 * 获取薪水起点
	 * @param id
	 * @return
	 */
	public static String getSalaryBaseById(String id){
		String[][] strs = ResumeUtil.salaryBase();
		for(String[] str : strs){
			if(str[0].equals(id)){
				return str[1];
			}
		}
		return "0";
	}
	
	public static String[][] cardType() {

		String[][] cardType = {
				{"1","身份证"}, 
				{"2","驾证"}, 
				{"3","军官证"}, 
				{"4","护照"}, 
				{"5","其它"}
			};
		return cardType;
	}
	
	
	public static String getCardTypeById(String id){
		String[][] strs = ResumeUtil.cardType();
		for(String[] str : strs){
			if(str[0].equals(id)){
				return str[1];
			}
		}
		return "";
	}
	
	
	public static String[][] jobState() {

		String[][] jobState = {
				{"0","目前正在找工作"}, 
				  {"1","半年内无换工作的计划"}, 
				  {"2","一年内无换工作的计划"}, 
				  {"3","观望有好的机会再考虑"}, 
				  {"4","我暂时不想找工作"} 
			};
		return jobState;
	}
	
	
	public static String getJobStateById(String id){
		String[][] strs = ResumeUtil.jobState();
		for(String[] str : strs){
			if(str[0].equals(id)){
				return str[1];
			}
		}
		return "求职状态";
	}
	
	public static String[][] getMaritalStatus() {

		String[][] maritalStatus = {
				{"0","未婚"},
                {"1","已婚"},
                {"2","离异"},
                {"3","保密"}
			};
		return maritalStatus;
	}
	
	
	public static String[][] getPostDate() {

		String[][] postDate = {
				{"1","一天内"},
                {"3","三天内"},
                {"7","一周内"},
                {"15","半月内"},
                {"30","一月内"},
                {"90","三月内"},
                {"180","半年内"},
                {"360","一年内"},
			};
		return postDate;
	}
	
	public static String[][] getWorkYear() {

		String[][] postDate = {
				{"-1","再度学生"},
                {"0","毕业生"},
               
                {"1","1年"},
                {"2","2年"},
                {"3","3年"},
                {"5","5年"},
                {"8","8年"},
                {"10","10年"},
			};
		return postDate;
	}
	
	
	public static String getPostDateById(String id){
		String[][] strs = ResumeUtil.getPostDate();
		for(String[] str : strs){
			if(str[0].equals(id)){
				return str[1];
			}
		}
		return "";
	}
	
	public static String getWorkYearById(String id){
		String[][] strs = ResumeUtil.getWorkYear();
		for(String[] str : strs){
			if(str[0].equals(id)){
				return str[1];
			}
		}
		return "";
	}
	
	
	public static String getMaritalStatusById(String id){
		String[][] strs = ResumeUtil.getMaritalStatus();
		for(String[] str : strs){
			if(str[0].equals(id)){
				return str[1];
			}
		}
		return "";
	}
	
	
	public static String getDegreeById(String id){
		String[][] strs = ResumeUtil.degree();
		for(String[] str : strs){
			if(str[0].equals(id)){
				return str[1];
			}
		}
		return "";
	}
	
	public static String getSalaryById(String id){
		String[][] strs = ResumeUtil.salary();
		for(String[] str : strs){
			if(str[0].equals(id)){
				return str[1];
			}
		}
		return "";
	}
	
	public static String getCompanyTypeById(String id){
		String[][] strs = ResumeUtil.companyType();
		for(String[] str : strs){
			if(str[0].equals(id)){
				return str[1];
			}
		}
		return "";
	}
	
	public static String getLanguageById(String id) {
		String[][] strs = ResumeUtil.language();
		for (String[] str : strs) {
			if (str[0].equals(id)) {
				return str[1];
			}
		}
		return "";
	}
	
	public static String getLanguageLevelById(String id) {
		String[][] strs = ResumeUtil.languageLevel();
		for (String[] str : strs) {
			if (str[0].equals(id)) {
				return str[1];
			}
		}
		return "";
	}
	
	public static String getEnglishLevelById(String id) {
		String[][] strs = ResumeUtil.englishLevel();
		for (String[] str : strs) {
			if (str[0].equals(id)) {
				return str[1];
			}
		}
		return "";
	}
	
	public static String getJapanLevelById(String id) {
		String[][] strs = ResumeUtil.japanLevel();
		for (String[] str : strs) {
			if (str[0].equals(id)) {
				return str[1];
			}
		}
		return "";
	}

	public static String getComputerLevelById(String id) {
		String[][] strs = ResumeUtil.computerLevel();
		for (String[] str : strs) {
			if (str[0].equals(id)) {
				return str[1];
			}
		}
		return "";
	}
	

}
