/*******************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.job528.util;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import com.job528.util.exception.InvalidDataException;


 
public class DateUtil implements Serializable {

    public static final int SECOND = 1000;

    public static final int MINUTE = SECOND * 60;

    public static final int HOUR = MINUTE * 60;

    public static final int DAY = HOUR * 24;

    public static final int WEEK = DAY * 7;

    public static final int YEAR = DAY * 365; // or 366 ???

   
    public static long millionSecondsOfDay = 86400000;
 
    public static Date newDate(int month, int date, int year) {
        Calendar inst = Calendar.getInstance();
        inst.clear();
        inst.set(year, month - 1, date);
        return inst.getTime();
    }

 
    public static boolean between(Date date, Date start, Date end) {
        return 0 <= getDay(start, date) && 0 >= getDay(end, date);
    }

   
    public static Date getDate(Date date, int i) {

        if (null == date)
            return null;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, i);

        return calendar.getTime();

    }

    public static int compare(Date date1, Date date2) {
        return getDay(date1, date2);
    }

  
    public static boolean compareHour(String sTime, String bTime) {
      
        bTime = getTimeFromString(bTime);
        boolean bigger = false;
        int bTimeHour = 0;
        int sTimeHour = 0;
        if (StringUtil.isValidStr(sTime) && StringUtil.isValidStr(bTime)) {
            bTimeHour = Integer.parseInt(bTime);
            sTimeHour = Integer.parseInt(sTime);
        }
        if (bTimeHour > sTimeHour) {
            bigger = true;
        }
        return bigger;
    }

 
    public static Date getDateByHour(Date date, int hour) {

        if (null == date)
            return null;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hour);

        return calendar.getTime();

    }
    
  
    public static Date getDateByMonth(Date date,int month){
    	if(null==date) return null;
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

 
    public static int getDay(Date date1, Date date2) {
        if (null == date1 || null == date2)
            return 0;

        date1 = getDate(date1);
        date2 = getDate(date2);

        return Long.valueOf((date2.getTime() - date1.getTime()) / millionSecondsOfDay).intValue();
    }

   
    public static int getWeekOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return 0 == (calendar.get(Calendar.DAY_OF_WEEK) - 1) ? 7 : calendar
            .get(Calendar.DAY_OF_WEEK) - 1;
    }
	
 
    public static int getMinsDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY)*60+calendar.get(Calendar.MINUTE);
    }

   
    public static boolean isMatchWeek(Date date, int week) {
        return getWeekOfDate(date) == week;
    }

    public static boolean isMatchWeek(Date date, Integer[] weeks) throws InvalidDataException {
        if (null == weeks)
            throw new InvalidDataException("weeks cannot be null!");

        int len = weeks.length;

        for (int m = 0; m < len; m++) {

            if (isMatchWeek(date, weeks[m].intValue()))
                return true;
        }

        return false;
    }

    public static boolean isMatchWeek(Date date, String[] weeks) throws InvalidDataException {
        if (null == weeks)
            throw new InvalidDataException("weeks cannot be null!");

        int len = weeks.length;

        for (int m = 0; m < len; m++) {

            if (isMatchWeek(date, Integer.valueOf(weeks[m]).intValue()))
                return true;
        }

        return false;
    }

    public static java.sql.Date getSqlDate(Date date) {
        if (null == date)
            return null;
        return new java.sql.Date(date.getTime());
    }

    public static Date getDate(Date date) {
        if (null == date)
            return null;
        return getDate(DateUtil.dateToString(date));

    }

    public static Date getDefaultDateTime(Date date) {
        if (null == date)
            return null;
        String str = dateToString(date) + " 12:00";

        return stringToDatetime(str);
    }

  
    public static List<Date> getDates(Date date1, Date date2) {
        if (null == date1 || null == date2)
            return new ArrayList<Date>(0);

        int day = getDay(date1, date2);

        List<Date> dates = new ArrayList<Date>(day);
        for (int i = 0; i <= day; i++) {
            dates.add(getDate(date1, i));
        }
        
        return dates;
    }

    /**
     * 格式 ： yyyy-MM-dd
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        if (null == date)
            return "";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        return sdf.format(date);
    }

    /**
     * 格式 ： yyyyMMdd
     * @param date
     * @return
     */
    public static String dateToStringNew(Date date) {
        if (null == date)
            return "";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
        return sdf.format(date);
    }

    public static String datetimeToString(Date date) {
        if (null == date)
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        return sdf.format(date);
    }

    public static String toStringByFormat(Date date, String format) {
        if (null != date) {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
            return sdf.format(date);
        }
        return "";
    }

    public static Date toDateByFormat(String str, String format) {
        if (null == str || str.equals(""))
            return null;
       
        if (0 < str.indexOf("CST")) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",
                    Locale.US);
                Date d = sdf.parse(str);
                return d;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date stringToDate(String str) {
        if (null == str || str.equals(""))
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm", Locale.CHINA);
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

   
    public static Date stringToDateMain(String datestr, String format) {
        if (null == datestr || datestr.equals(""))
            return null;
        
        if (0 < datestr.indexOf("CST")) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",
                    Locale.US);
                Date d = sdf.parse(datestr);
                return d;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        try {
            return sdf.parse(datestr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date stringToDateTime(String str) {
        if (null == str || str.equals(""))
            return null;
        
        if (0 < str.indexOf("CST")) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",
                    Locale.US);
                Date d = sdf.parse(str);
                return d;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public static Date stringToDateMinute(String str) {
        if (null == str || str.equals(""))
            return null;
       if (0 < str.indexOf("CST")) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",
                    Locale.US);
                Date d = sdf.parse(str);
                return d;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date stringToDatetime(String str) {
        if (null == str || str.equals(""))
            return null;
            if (0 < str.indexOf("CST")) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",
                    Locale.US);
                Date d = sdf.parse(str);
                return d;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date getDate(String str) {
        if (null == str || str.equals(""))
            return null;
          if (0 < str.indexOf("CST")) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",
                    Locale.US);
                Date d = sdf.parse(str);
                return d;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static String getTimeString(int duration) {
        int hours = duration / DateUtil.HOUR;
        int remain = duration - (hours * DateUtil.HOUR);
        int minutes = remain / DateUtil.MINUTE;
        StringBuffer time = new StringBuffer(64);
        if (0 != hours) {
            if (1 == hours) {
                time.append("1 hour and ");
            } else {
                time.append(hours).append(" hours and ");
            }
        }
        if (1 == minutes) {
            time.append("1 minute");
        } else {
         
            time.append(minutes).append(" minute(s)");
        }
        return time.toString();
    }

   
    // public static String getICSDate(String str) throws ParseException {
    // if (str == null || str.equals(""))
    // return null;
    //
    // SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    //
    // Date date = sdf.parse(str);
    //
    // return com.sune365.air.bookingEngine.util.DateUtil.dateToString(date,
    // "ddMMMyy");
    // }
    
    public static int getYearOfSysTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

     
    public static int getMonthOfSysTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static int getDayOfSysTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DATE);
    }

   
    public static void main(String[] args) {
        System.out.println(stringToDateTime("2008-07-03 11:44:13").getTime() / (1000 * 60));
    }
    public static Date getDate(int year,int month){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		Date date = cal.getTime();
		return date;
    }
     
    public static String getBeginDate(Date date){
    	Date beginDay;
        Calendar   cDay1   =   Calendar.getInstance();   
        cDay1.setTime(date);   
        beginDay   =   cDay1.getTime();   
        beginDay.setDate(cDay1.getActualMinimum(Calendar.DAY_OF_MONTH));   
    	return dateToString(beginDay);
    }
    
    public static String getEndDate(Date date){
    	Date endDay;
        Calendar   cDay1   =   Calendar.getInstance();   
        cDay1.setTime(date);     
        endDay   =   cDay1.getTime();   
        endDay.setDate(cDay1.getActualMaximum(Calendar.DAY_OF_MONTH));
    	return dateToString(endDay);
    }
    
    public static String getTimeFromString(String sTime) {
        String dTime = "";
        if (sTime.contains(":")) {
            dTime = sTime.replace(":", "");
        } else {
            dTime = sTime;
        }
        return dTime;
    }

    public static Date getSystemDate() {
        return new Date();
    }

    public static String formatDateToSQLString(Date srcDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        return sdf.format(srcDate);
    }

    public static String formatDateToYMDHMS(Date srcDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss", Locale.CHINA);
        return sdf.format(srcDate);
    }

    public static String formatDateToYMDHMS1(Date srcDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        return sdf.format(srcDate);
    }

    public static String formatDateToMMDD(Date srcDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd", Locale.CHINA);
        return sdf.format(srcDate);
    }

    public static String formatTimeToString(Date srcDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.CHINA);
        return sdf.format(srcDate);
    }

    public static String formatTimeHToString(Date srcDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH", Locale.CHINA);
        return sdf.format(srcDate);
    }

   
    public static String formatHourTimeHToString(Date srcDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm", Locale.CHINA);
        return sdf.format(srcDate);
    }

    public static String weeksToString(String[] week) {
        if (null == week) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        String result = "";
        for (int i = 0; i < week.length; i++) {
            if (i == week.length - 1) {
                sb.append(week[i]);
            } else {
                sb.append(week[i]).append(",");
            }
            result = sb.toString();
        }
        return result;
    }

    
    public static Date[] getDateWithWeek(Date beginDate, Date endDate, Integer[] weeks) {
        int dateNum = compare(beginDate, endDate);
        List datelist = new ArrayList();
        for (int i = 0; i <= dateNum; i++) {
            if (isMatchWeek(getDate(beginDate, i), weeks)) {
                datelist.add(getDate(beginDate, i));
            }
        }
        Date[] dates = new Date[datelist.size()];
        for (int j = 0; j < datelist.size(); j++) {
            dates[j] = (Date) datelist.get(j);
        }
        return dates;
    }

    public static Date[] getDateWithWeek(Date beginDate, Date endDate, String[] weeks) {
        int dateNum = compare(beginDate, endDate);
        List datelist = new ArrayList();
        for (int i = 0; i < dateNum; i++) {
            if (isMatchWeek(getDate(beginDate, i), weeks)) {
                datelist.add(getDate(beginDate, i));
            }
        }
        Date[] dates = new Date[datelist.size()];
        for (int j = 0; j < datelist.size(); j++) {
            dates[j] = (Date) datelist.get(j);
        }
        return dates;
    }

    public static Date minusDate(Date date, int day) {
        long time = date.getTime() - 24 * 60 * 60 * 1000 * day;
        Date date1 = null;
        try {
            date1 = new Date(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date1;
    }

    public static String formatDateToMD(Date date) {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM", Locale.CHINA);
        return fmt.format(date);
    }

      public static int getDayOverToday(Date date) {
        if (null == date) {
            return 4;
        } else {
            Date now = new Date();
            Calendar c1 = Calendar.getInstance();
            c1.setTime(now);
            Calendar c2 = Calendar.getInstance();
            c2.setTime(date);
            Calendar c3 = Calendar.getInstance();
            c3.set(c1.get(Calendar.YEAR), 11, 31);
            int j = c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR);
            if (0 == c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR)) {
                // System.out.println(c2.get(c2.DAY_OF_YEAR)-c1.get(c1.DAY_OF_YEAR));
                if (0 == j) {
                    return 0;
                } else if (1 == j) {
                    return 1;
                } else {
                    return 3;
                }
            } else if (1 == c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR)) {
                j = (c3.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR))
                    + c2.get(Calendar.DAY_OF_YEAR);
                if (0 == j) {
                    return 0;
                } else if (1 == j) {
                    return 1;
                } else {
                    return 3;
                }
            } else {
                return 3;
            }
        }
    }

    
    public static int getOrderAccomplishTime(Date enterDate, boolean isDepartment,
        boolean isAllpoint) {
        if (isAllpoint) {
            return 5;
        }
        if (isDepartment) {
            return 4;
        }
        SimpleDateFormat fmt = new SimpleDateFormat("HHmm", Locale.CHINA);
        Calendar currentCalendar = Calendar.getInstance();
        Calendar enterCalendar = Calendar.getInstance();
        enterCalendar.setTime(enterDate);
        int i = Integer.parseInt(fmt.format(currentCalendar.getTime()));
        if (0 <= i && 729 > i) {
            return 1;
        }
        if (729 <= i && 2159 >= i) {
            return 2;
        } else {
            if (currentCalendar.get(Calendar.YEAR) == enterCalendar.get(Calendar.YEAR)
                && currentCalendar.get(Calendar.MONTH) == enterCalendar.get(Calendar.MONTH)
                && currentCalendar.get(Calendar.DATE) == enterCalendar.get(Calendar.DATE)) {// 当天入住
                return 2;
            } else {
                return 3;
            }
        }
    }

    public static Date getDateWithoutWeekend(Date source, int days) {
        int i = 0, j = 0;
        while (j <= days) {
            int dayOfweek = getWeekOfDate(getDate(source, -i));
            i++;
            if (6 == dayOfweek || 7 == dayOfweek) {
                continue;
            } else {
                j++;
            }
        }
        return getDate(source, -(i - 1));
    }

    
    public static String addStringDate(String dateStr, int offset) {
        if (null == dateStr || dateStr.equals(""))
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        Date tempDate = new Date();
        Calendar cal = Calendar.getInstance();
        try {
            tempDate = sdf.parse(dateStr);
            cal.setTime(tempDate);
            cal.set(Calendar.DAY_OF_MONTH, (cal.get(Calendar.DAY_OF_MONTH) + offset));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd", Locale.CHINA);
        return sdf1.format(cal.getTime());
    }
    
        
    public static String formatDate(Date date) {
        SimpleDateFormat fmt = new SimpleDateFormat("MM/dd", Locale.CHINA);
        return fmt.format(date);
    }
    
    public static String formatDateToMDStr(Date date) {
        SimpleDateFormat fmt = new SimpleDateFormat("MM月dd日", Locale.CHINA);
        return fmt.format(date);
    }

    /**
     * 
     * @param dateStr
     * @param offset
     * @return
     */

    
    public static String addStringDateALL(String dateStr, int offset) {
        if (null == dateStr || dateStr.equals(""))
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        Date tempDate = new Date();
        Calendar cal = Calendar.getInstance();
        try {
            tempDate = sdf.parse(dateStr);
            cal.setTime(tempDate);
            cal.set(Calendar.DAY_OF_MONTH, (cal.get(Calendar.DAY_OF_MONTH) + offset));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        return sdf1.format(cal.getTime());
    }

    
    public static String addStringDateALLMain(String dateStr, int offset, String format) {
        if (null == dateStr || dateStr.equals(""))
            return null;
        if (null == format || format.equals(""))
            format = "yyyyMMdd";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Date tempDate = new Date();
        Calendar cal = Calendar.getInstance();
        try {
            tempDate = sdf.parse(dateStr);
            cal.setTime(tempDate);
            cal.set(Calendar.DAY_OF_MONTH, (cal.get(Calendar.DAY_OF_MONTH) + offset));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat(format, Locale.CHINA);
        return sdf1.format(cal.getTime());
    }

    
    public static List<String> getDateStrList(Date startDate, Date endDate, boolean forOneWeek) {

        int difdays = DateUtil.getDay(startDate, endDate);

        List dateStrList = new ArrayList();

        difdays = forOneWeek ? (7 <= difdays ? 7 : difdays) : difdays;
        for (int i = 0; i < difdays; i++) {
            Date reservationDate = DateUtil.getDate(startDate, i);
            int week = reservationDate.getDay();

            String dateStr = (reservationDate.getMonth() + 1) + "/" + reservationDate.getDate()
                + " 周" + (0 == week ? "日" : week);
            dateStrList.add(dateStr);
        }

        return dateStrList;
    }

     
    public static Date getDateFromOriDateStr(String strDate) {
        Date date = null;
        if (null == strDate || "".equals(strDate)) {
            return null;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
            try {
                date = sdf.parse(strDate);
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return null;
            }
        }
        return date;
    }

   
    public static boolean compareDateTimeToSys(Date compaDate, String compaTime) {
        boolean bigger = false;
        if (0 < compare(DateUtil.getDate(DateUtil.getSystemDate()), compaDate)
            || (0 == compare(DateUtil.getDate(DateUtil.getSystemDate()), compaDate) && compareHour(
            	formatHourTimeHToString(DateUtil.getSystemDate()),compaTime))) {
            bigger = true;
        }
        return bigger;
    }
    
    
    
    public static boolean compareDateTimeToSysBig(Date compaDate, String compaTime) {
        boolean bigger = false;
        if (0 < compare(compaDate,DateUtil.getDate(DateUtil.getSystemDate()))
            || (0 == compare(compaDate,DateUtil.getDate(DateUtil.getSystemDate())) && compareHour(
            compaTime,formatHourTimeHToString(DateUtil.getSystemDate())))) {
            bigger = true;
        }
        return bigger;
    }

    /**
     * 判断????日期是否在一个起止日期之间，是返回true 比如 2009-02-17 ??2009-02-17??2009-02-18之间，返回true add by
     * 
     * @param betwDate
     * @param beginDate
     * @param endDate
     * @return
     */
    public static boolean isBetween(Date betwDate, Date beginDate, Date endDate) {
        boolean isBetween = false;
        if (null != betwDate && null != beginDate && null != endDate
            && (0 <= compare(beginDate, betwDate) && 0 < compare(betwDate, endDate))) {
            isBetween = true;
        }
        return isBetween;
    }

    /**
     * 判断当前系统时间是否在一个起止日期之间，是返回true 比如 2009-02-17 09:00 ??2009-02-16 09:00 ??2009-02-18 09??0之间，返回true add by
  
     * 
     * @param beTime
     * @param beginDate
     * @param endDate
     * @param endTime
     * @return
     */
    public static boolean isBetweenDateTime(Date beginDate,String beTime, Date endDate,String endTime) {
        boolean isBetween = false;
        
        if (null != beginDate && null != beTime && null != endDate && null !=endTime
	            && compareDateTimeToSys(endDate,endTime)
	            && compareDateTimeToSysBig(beginDate,beTime)
            ) {
            isBetween = true;
        }
        return isBetween;
    }
    
    public static String formatDateToMDTwo(Date date) {
        SimpleDateFormat fmt = new SimpleDateFormat("d/M", Locale.CHINA);
        return fmt.format(date);
    }

    /**
  
     * 
     * @param s
     *            待转换的字符串，为yyyymmdd格式
     * @return
     */
    public static String getString4Paydate(String s) {
        String ss = "";
        try {
            String yyyy = s.substring(0, 4);
            String mm = s.substring(4, 6);
            String dd = s.substring(6, 8);
            ss = yyyy + "年" + mm + "月" + dd + "日";
        } catch (Exception e) {
            // TODO: handle exception
        }
        return ss;

    }
    
 
    public static Date getB2BDate(String s){
    	try{
    		GregorianCalendar g=new GregorianCalendar();
            String year =String.valueOf( g.get(Calendar.YEAR));
            String dd = s.substring(0,2);
            String mm = s.substring(3,5);
            StringBuffer a = new StringBuffer();
            a.append(year);
            a.append("-");
            a.append(mm);
            a.append("-");
            a.append(dd);
    		return DateUtil.getDate(a.toString());
    	}catch(Exception e){
    		e.printStackTrace();
    		return null;
    	}
    	
    }
    /**
     * ????日期是否在日期区间中，并且在规定的日期中 
     * @param checkedDate
     * @param begin
     * @param end
     * @param week 1,2,3,4,5,6,7
     * @return
     */
    public static boolean checkDateBetween(Date checkedDate,Date begin,Date end,String week){
    	boolean checkResult = false;
    	//????日期是否在规则的????结束日期区间
    	boolean isBetween = DateUtil.between(checkedDate, begin, end);
		if(isBetween){
			String weekOfDate = String.valueOf(DateUtil.getWeekOfDate(checkedDate));
			//????日期是否在规定的星期??
			if(week.indexOf(weekOfDate) >= 0){
				checkResult = true;
			}
		}
    	return checkResult;
    }
    
    /**
	 * 获得某一日期的后 
	 * @param date
	 * @return Date
	 */
	public static Date getNextDate(Date date){
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		int day=calendar.get(Calendar.DATE);
		calendar.set(Calendar.DATE,day+1);
		return getSqlDate(calendar.getTime());
	}
	
	 /**
	 * 获得当前日期  
	 * @param date
	 * @return Date
	 */
	public static Date getDateTwo(Date date){
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		int day=calendar.get(Calendar.DATE);
		calendar.set(Calendar.DATE,day);
		return getSqlDate(calendar.getTime());
	}
	
	/**
	 * 获得某一日期的前 
	 * @param date
	 * @return Date
	 */
	public static Date getPreviousDate(Date date){
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		int day=calendar.get(Calendar.DATE);
		calendar.set(Calendar.DATE,day-1);
		return getSqlDate(calendar.getTime());
	}
	
	/**
	 * 传进来time??500 返回 15:00格式 
	 * @param strTime
	 * @return
	 */
	public static String subStrTime(String strTime){
		String inTime = strTime.substring(0,2);
		String outTime = strTime.substring(2,strTime.length());	
		return inTime+":"+outTime;
	}
	/**
     * 取得两个日期之间的日期，包括起止两天  
     * @param begin
     * @param end
     * @return
     */
    public static Date[] getDaysBetween(Date beginDate,Date endDate){
    	if(null != beginDate && null != endDate){
    		int count = DateUtil.getDay(beginDate, endDate);
    		Date[] days = new Date[count+1];
    		Calendar cal = Calendar.getInstance();
    		cal.setTime(beginDate);
    		days[0] = cal.getTime();
    		for (int i = 1; i <= count; i++) {
    			cal.add(Calendar.DAY_OF_MONTH, 1);
    			days[i] = cal.getTime();
			}
    		return days;
    	}
    	return null;
    }
	public static String getDayAndMonth(String dateStr){
    	if(StringUtil.isValidStr(dateStr))
    		return null;
    	Date date = DateUtil.getDate(dateStr);
    	if(date != null){
    		DateUtil.getDayAndMonth(date);
    	}
    	return null;
    	
    }
    public static String getDayAndMonth(Date date){
    	if(date != null){
    		Calendar cal = Calendar.getInstance();
    		cal.setTime(date);
    		return cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH)+1);
    	}
    	return null;
    }
    
    /**
     * 比较两个日期是否为同????
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDate(Date date1, Date date2){    	
    	return dateToString(date1).equals(dateToString(date2));
    }
}
