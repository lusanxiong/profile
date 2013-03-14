package com.job528.util.email;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;


/**
 * 任务调度管理类
 * @author lusanxiong
 *
 */
public class ScheduledExecutorManager {
	private static Logger logger = Logger.getLogger(ScheduledExecutorManager.class);
	
	//创建单个线程的调度器
	private static final ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
	private static final ScheduledExecutorService bufferTaskScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
	
	//模拟往任务列表中添加新任务的调度器(仅做为测试用,真实环境由用户的并发请求产生新任务)
	private static final ScheduledExecutorService scheduledExecutor_test = Executors.newScheduledThreadPool(1);
	
	/**
	 * 周期的调度任务
	 * 
	 * 程序启动时初始延迟调度,之后按指定的周期调度任务.直至程序终止
	 * 
	 * @param initDelay :初始延迟时间,单位ms
	 * @param period :周期时间,单位ms
	 * 
	 */
	public static void periodExecutorTask(long initDelay,long period) {
		Runnable etm = new ExecutorTaskManager();
		try {
			scheduledExecutor.scheduleAtFixedRate(etm,initDelay,period,TimeUnit.MILLISECONDS);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("调度器调度发送邮件任务错误:",e);
		}
	}
	
	/**
	 * 按固定周期从把缓冲区任务队列中的任务全部转移到实际任务队列中
	 */
	public static void addTaskBuffer(int initDelay,int period) {
		TasksBuffer tb = TasksBuffer.taskBuffer;
		bufferTaskScheduledExecutor.scheduleAtFixedRate(tb, initDelay, period, TimeUnit.SECONDS);
	}
	
	
	public  static void main(String[] args) {
		List<String[]> emailInfoList = new LinkedList<String[]>();
		String[] email = new String[] {"卢三雄","罗日成","845985600@qq.com"};
		String[] email2 = new String[] {"卢三雄","罗日成2","670772901@qq.com"};
		String[] email3 = new String[] {"卢三雄","卢三雄1","sanxionglu@msn.cn"};
		String[] email4 = new String[] {"卢三雄","卢三雄2","sanxionglu3@gmail.com"};
		for(int i=0; i<10; i++) {
			emailInfoList.add(email);
			emailInfoList.add(email2);
			emailInfoList.add(email3);
			emailInfoList.add(email4);
		}
		
		ExecutorTaskManager.addNewEmailTask(emailInfoList);
		periodExecutorTask(1000,10*1000);
		
		//模拟添加新任务
		TasksTest t = new TasksTest();
		scheduledExecutor_test.scheduleAtFixedRate(t, 60, 10, TimeUnit.SECONDS);
		
		//addTaskBuffer();
	}
}
