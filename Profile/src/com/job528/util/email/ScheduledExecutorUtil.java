package com.job528.util.email;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/***
 * 并发执行任务工具类
 * 
 * 定时任务执行器,最多可并发执行n个定时任务
 * @author Administrator
 *
 */
public class ScheduledExecutorUtil {
	private long pointInitDelay = 0; //根据指定时间延迟后执行
	private final long period_day  = 24*60*60*1000;  //24小时为一个周期
	
	ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
	ScheduledExecutorService scheduledExecutor1 = Executors.newSingleThreadScheduledExecutor();
	
	/**
	 * 按指定整点时刻周期执行任务(只指定小时)
	 * 
	 * hours:指定每天的整点时刻，小时(24小时制)如09:00:00
	 * @param hours
	 */
	public void pointHoursRunTask(Runnable task, int hours) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"), Locale.getDefault()); //"GMT+8"//代表北京时间
		calendar.clear(Calendar.MINUTE);
		calendar.clear(Calendar.SECOND);
		calendar.set(Calendar.HOUR_OF_DAY, hours);
		long daytime = calendar.getTimeInMillis(); //每天早上09:00:00点
		
		sheduledRun(task, daytime);
	}
	
	/**
	 * 按指定时间点周期执行任务
	 * 
	 * hours:指定每天的时间点
	 * @param hours
	 * @param minute
	 * @param seconds
	 */
	public void pointTimeTask(Runnable task, int hours,int minute, int seconds) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"), Locale.getDefault()); //"GMT+8"//代表北京时间
		calendar.set(Calendar.HOUR_OF_DAY, hours);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, seconds);
		long daytime = calendar.getTimeInMillis(); //每天早上09:00:00点
		
		sheduledRun(task, daytime);
	}
	
	/**
	 * 按指定时间周期执行任务(只指定小时)
	 * 
	 * hours:指定每天的时间点 (分，秒是当前实时的)
	 * @param hours
	 */
	public void pointHoursRunTimeTask(Runnable task, int hours) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"), Locale.getDefault()); //"GMT+8"//代表北京时间
		calendar.clear(Calendar.HOUR_OF_DAY);
		calendar.set(Calendar.HOUR_OF_DAY, hours);
		long daytime = calendar.getTimeInMillis(); //每天早上09:00:00点
		
		sheduledRun(task, daytime);
	}
	
	public void sheduledRun(Runnable task, long daytime) {
		try {
			long systime = System.currentTimeMillis(); //系统时间
			
			long timestamp = systime - daytime; //时间差 
			if((period_day-timestamp) > 0) { 
				if(timestamp > 0) {
					pointInitDelay = period_day - timestamp;  //延迟执行的时间
				}else {
					pointInitDelay = period_day + timestamp;  //延迟执行的时间
				}
			}
			
			scheduledExecutor.schedule(task, 30*1000, TimeUnit.MILLISECONDS);//延迟1分钟执行,且只执行一次
			scheduledExecutor.scheduleAtFixedRate(task, pointInitDelay, period_day, TimeUnit.MILLISECONDS); //延迟后在周期执行
		} catch(Exception e) {
			e.printStackTrace();
			shutdown(scheduledExecutor);
		}
	}
	
	/**
	 *初始延时后，然后周期执行任务
	 */
	public void periodRunTask(Runnable task, long initDelay,long period) {
		
		try {
			scheduledExecutor1 = Executors.newSingleThreadScheduledExecutor();
			scheduledExecutor1.scheduleAtFixedRate(task,initDelay,period,TimeUnit.MILLISECONDS); 
		} catch(Exception e) {
			e.printStackTrace();
			shutdown(scheduledExecutor1);
		}
	}
	
	/**
	 * 关闭线程
	 */
	public void shutdown(ScheduledExecutorService scheduledExecutor) {
		if(scheduledExecutor != null) {
			scheduledExecutor.shutdown();
		}
	}
	
	/**
	 * 关闭所有线程
	 */
	public void shutdownAll() {
		if(scheduledExecutor1 != null) {
			scheduledExecutor1.shutdown();
		}
		
		if(scheduledExecutor != null) {
			scheduledExecutor.shutdown();
		}
	}
}
