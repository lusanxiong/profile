package com.job528.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.job528.util.email.ScheduledExecutorManager;

/**
 * servelt容器初始化时,启动批量(并行)发送邮件任务
 * @author lusanxiong
 *
 */
public class BatchSendEmailListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		long initDelay = 0; //调度器初始延迟调度时间,以毫秒为单位
		long period = 10*1000;    //调度器调度周期,以毫秒为单位
		
		System.out.println("批量发送邮件任务启动....");
		//ScheduledExecutorManager.periodExecutorTask(initDelay, period);
		
		System.out.println("按固定周期转移缓冲区的任务启动....");
		
		int initDelay_buffer = 0;//以秒为单位
		int period_buffer = 10;//以秒为单位
		
		//ScheduledExecutorManager.addTaskBuffer(initDelay_buffer,period_buffer);
	}

	 
}
