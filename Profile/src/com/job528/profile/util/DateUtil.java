package com.job528.profile.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;


public class DateUtil {
	static final long nd = 1000*24*60*60;  //一天的毫秒数
	static final long nh = 1000*60*60;//一小时的毫秒数
	static final long nm = 1000*60;//一分钟的毫秒数
	static final long ns = 1000;//一秒钟的毫秒数
	
	public static int strConvertNumber(String date) {
		if(date == null || "".equals(date))
			return 0;
		
		if(date.length() > 10) 
			date = date.substring(0,10);
		
		String[] dateNum = date.split("\\D");
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<dateNum.length; i++) {
			sb.append(dateNum[i]);
		}
		
		return Integer.parseInt(sb.toString());
	}
	
	public static Date StrFormateDate(String dateStr) {
		
		char splitChar = dateStr.charAt(4); 
		String splitStr = String.valueOf(splitChar);
		
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy"+splitStr+"MM"+splitStr+"dd" );
			date = sdf.parse(dateStr);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
	public static Date StrFormateTime(String dateStr) {
			
			char splitChar = dateStr.charAt(4); 
			String splitStr = String.valueOf(splitChar);
			
			String formatConst = "yyyy"+splitStr+"MM"+splitStr+"dd HH:mm:SS";
			
			Date date = null;
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(formatConst);
				date = sdf.parse(dateStr);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return date;
	}
	
	public static String numFormateDate(String splitChar, Date date) throws Exception{
		
		String dateStr = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy"+splitChar+"MM"+splitChar+"dd");
			dateStr = sdf.format(date);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		dateStr = dateStr.substring(0, 10);
		
		return dateStr;
	}
	
	public static Calendar strFormateCal(String datetimeStr) throws Exception{
		if(datetimeStr == null) 
			return null;
		
		Calendar cal =  Calendar.getInstance(TimeZone.getTimeZone("GMT+8"), Locale.getDefault()); //"GMT+8"//代表北京时间
		Date date = DateUtil.StrFormateTime(datetimeStr);
		cal.setTime(date);
		
		return cal;
	}
	
	public static Calendar dateStrFormatCal(String dateStr) throws Exception{
		if(dateStr == null) 
			return null;
		
		Calendar cal =  Calendar.getInstance(TimeZone.getTimeZone("GMT+8"), Locale.getDefault()); //"GMT+8"//代表北京时间
		Date date = DateUtil.StrFormateDate(dateStr);
		cal.setTime(date);
		
		return cal;
	}
	
	public static int compareDate(String firstDate, String secondDate){
		int firstDate_num = 0;
		int secondDate_num = 0;
		try {
			firstDate_num = DateUtil.strConvertNumber(firstDate);
			secondDate_num = DateUtil.strConvertNumber(secondDate);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return (secondDate_num - firstDate_num);
	}
	
	/*
	 * 比较日期 
	 * 不包括时间，只比较日期
	 */
	public static int compareDate(Calendar firstCal, Calendar secondCal) {
		
		/*String first = DateUtility.formatToDay(firstCal);
		String second = DateUtility.formatToDay(secondCal);
		
		int firstDate_num = DateUtil.strConvertNumber(first.substring(0,10));
		int secondDate_num = DateUtil.strConvertNumber(second.substring(0,10));
		
		return secondDate_num - firstDate_num;*/
		return 0;
	}
	
	/*
	 * 比较时间
	 *
	 */
	public static int compareTime(String  firstStr, String secondStr) throws Exception {
		
		Calendar secondCal = null;
		Calendar firstCal = null;
		try {
			firstCal = strFormateCal(firstStr);
			secondCal  = strFormateCal(secondStr);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//int a = secondCal.compareTo(firstCal);
		return secondCal.compareTo(firstCal);
	}
	
	/*
	 * 获取２个日期相差的天数
	 */
	public static long compareDay(String startDate, String endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date start_d = sdf.parse(startDate);
			Date end_d   = sdf.parse(endDate);
			
			long time = end_d.getTime() - start_d.getTime();
			return time/nd;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/*
	 * 获取２个日期相差的小时数
	 */
	public static long compareDayHour(String startDate, String endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdHHmm");
		try {
			Date start_d = sdf.parse(startDate);
			Date end_d   = sdf.parse(endDate);
			
			long time = end_d.getTime() - start_d.getTime();
			return time/nh;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/*
	 * 获取２个日期相差的分钟数
	 */
	public static long compareDayMinute(String startDate, String endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		try {
			Date start_d = sdf.parse(startDate);
			Date end_d   = sdf.parse(endDate);
			
			long time = end_d.getTime() - start_d.getTime();
			return time/nm;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	
	/*
	 * 根据本周的星期 获取对应的本周星期的日期
	 * 
	 * @param day_of_week :星期几
	 */
	public static String getWeekDate(String day_of_week) {
		String date = "";
		
		//存放本周 第X天与星期的关联. key: 是本周的第X天， value: 是星期几
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "7");
		map.put("2", "1");
		map.put("3", "2");
		map.put("4", "3");
		map.put("5", "4");
		map.put("6", "5");
		map.put("7", "6");
		
		Calendar cal = Calendar.getInstance();
		
		//获取今天是 本周的第X天
		int week_today_day = cal.get(Calendar.DAY_OF_WEEK);
		
		for(Map.Entry<String, String> m : map.entrySet()) {
			if(m.getValue().equals(day_of_week)) {
				
				int day = Integer.parseInt(m.getKey());
				
				cal.add(Calendar.DAY_OF_WEEK, day-week_today_day);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				date = sdf.format(cal.getTime());
				//System.out.println("所在的日期＝"+date);
			}
		}
		
		return date;
	}
	
	/*
	 * 根据本周的星期 获取对应的本周星期的日期
	 * 
	 * @param day_of_week :星期几
	 */
	/*public static String[] getWeekDate(String[] days_of_week) {
		String[] date = new String[days_of_week.length];
		
		//存放本周 第X天与星期的关联. key: 是本周的第X天， value: 是星期几
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "7");
		map.put("2", "1");
		map.put("3", "2");
		map.put("4", "3");
		map.put("5", "4");
		map.put("6", "5");
		map.put("7", "6");
		
		Calendar cal = Calendar.getInstance();
		
		//获取今天是 本周的第X天
		int week_today_day = cal.get(Calendar.DAY_OF_WEEK);
		
		for(Map.Entry<String, String> m : map.entrySet()) {
			
			for(int i=0; i<days_of_week.length; i++) {
				if(m.getValue().equals(days_of_week[i])) {
					
					int day = Integer.parseInt(m.getKey());
					
					cal.add(Calendar.DAY_OF_WEEK, day-week_today_day);
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					date[i] = sdf.format(cal.getTime());
					//System.out.println(days_of_week[i]+"所在的日期＝"+date[i]);
					break;
				}
			}
		}
		
		return date;
	}*/
	
	/*
	 * 获取日期是上午,下午,还是晚上
	 */
	public static String getDateAM_PM(Calendar cal) {
	  int hour = cal.get(Calendar.HOUR_OF_DAY);
	  if (hour >= 1 && hour <= 12) {
		  return "morning";
	  } else if (hour >= 12 && hour < 18) {
		  return "afternoon";
	  } else {
		  return "night";
	  }
	}
	
	/*
	 * 获取当天是星期几
	 */
	
	public static int getWeekDay(Calendar cal) {
		
		//获取传进来的日期当中的day值  是 本周的第X天
		int week_today_day = cal.get(Calendar.DAY_OF_WEEK);
		
		//存放本周 第X天与星期的关联. key: 是本周的第X天， value: 是星期几
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 7);
		map.put(2, 1);
		map.put(3, 2);
		map.put(4, 3);
		map.put(5, 4);
		map.put(6, 5);
		map.put(7, 6);
		
		for(Map.Entry<Integer, Integer> m : map.entrySet()) {
			if(m.getKey().equals(week_today_day)) {
				return m.getValue();
			}
		}
		
		return 0;
	}
	
	
	 /**   
	  * 得到本月的第一天   
	  * @return   
	  */    
	 public static String getMonthFirstDay() {     
	     Calendar calendar = Calendar.getInstance();     
	     calendar.set(Calendar.DAY_OF_MONTH, calendar     
	             .getActualMinimum(Calendar.DAY_OF_MONTH));
	     
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	     
	     return sdf.format(calendar.getTime());   
	 }     
	     
	 /**   
	  * 得到本月的最后一天   
	  *    
	  * @return   
	  */    
	 public static String getMonthLastDay() {     
	     Calendar calendar = Calendar.getInstance();     
	     calendar.set(Calendar.DAY_OF_MONTH, calendar     
	             .getActualMaximum(Calendar.DAY_OF_MONTH));     
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	     
	     return sdf.format(calendar.getTime());     
	 } 
	 
     /** 
        *  
        * @param year 
        *            int 年份 
        * @param month 
        *            int 月份 
        *            
        * // 需要注意的是：月份是从0开始的，比如说如果输入5的话，实际上显示的是4月份的最后一天，千万不要搞错了哦
        *  
        * @return int 某年某月的最后一天 
        */  
       private int getLastDayOfMonth(int year, int month) {  
           Calendar cal = Calendar.getInstance();  
           cal.set(Calendar.YEAR, year);  
           cal.set(Calendar.MONTH, month);  
           // 某年某月的最后一天  
           return cal.getActualMaximum(Calendar.DATE);  
       }  
	     
       /**
   	 * 界面上显示的访问日期
   	 * @param dateStr 格式:2012-07-24 08:19:10
   	 * @return
   	 */
   	public static String getShowAccessDate(String dateStr) {
   		//界面上显示的接收时间
           String show_time = "";
           
           //当天的日期
   		Calendar cal = Calendar.getInstance();
   		String currentDate = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
           
           //如果访问日期是今年,只显示月和日期
           if(dateStr.substring(0,4).equals(currentDate.substring(0,4))) {
           	String month = dateStr.substring(5,7);
           	String day   = dateStr.substring(8,10);
           	
           	//且访问日期是今天
           	int dateStr_int = Integer.parseInt(dateStr.substring(0, 10).replaceAll("-", ""));
           	if(Integer.parseInt(currentDate) == dateStr_int) {
           		
                   String r_time = dateStr.substring(0,16).replaceAll("-","").replaceAll(":","").replaceAll(" ","");
                   //System.out.println("r_time"+r_time);
                   
           		long minutes = DateUtil.compareDayMinute(r_time,new SimpleDateFormat("yyyyMMddHHmm").format(new Date()));
           		if(minutes > 60) {
           			show_time = (minutes/ 60)+"小时前" ;
           		}else {
           			show_time = minutes+"分钟前";
           		}
               } else {
               	show_time = month+"月"+day+"日";
               }
           	
           	
           }else {
           	String month = dateStr.substring(4,6);
               String day   = dateStr.substring(6,8);
               show_time = dateStr.substring(0,4)+"年"+month+"月"+day+"日";
           }
           return show_time;
   	}
   	
   	public static String getShowAccessDate(Date datetime) {
   		if(datetime == null) return "";
   		String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(datetime);
   		String showTime = getShowAccessDate(str);
   		return showTime;
   	}
   	
   	public static void main(String args[]) {
   		System.out.println(getShowAccessDate(new Date()));
   	}
	
}
