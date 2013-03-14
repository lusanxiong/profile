package com.job528.util.email;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

/**
 * 线程池并发执行任务类
 * @author lusanxiong
 *
 */
public class ExecutorTaskManager implements Runnable{
	private static Logger logger = Logger.getLogger(ExecutorTaskManager.class);
	
	private static final int THREAD_POOL_SIZE = 10; //线程池大小
	private static final Tasks tasks = new Tasks(); //多线程通信 通过同一个tasks对象的共享任务队列
	
	private static ExecutorService threadPoolExecutor = null; 
	
	//初始化线程池
	static {
		if(threadPoolExecutor == null) {
			threadPoolExecutor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
		}
	}
	
	private static ExecutorService getInstance() {
		if(threadPoolExecutor == null) {
			threadPoolExecutor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
		}
		return threadPoolExecutor;
	}
	
	@Override
	public void run() {
		System.out.println("调度开始....");
		long s_time = System.currentTimeMillis();
		try {
			executorTasks();
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("线程池并发执行发送邮件错误",e);
		}
		System.out.println("调度结束...花费时间.."+(System.currentTimeMillis()-s_time));
	}
	
	/**
	 * 并发执行任务
	 * 
	 * 该并发执行任务 交给外部线程周期的进行调度.
	 */
	private static void executorTasks() {
		threadPoolExecutor = getInstance();
		
		//获取要执行的任务列表长度
		int len = Tasks.getTaskLength();
		
		for(int i=0; i<len; i++) {
			threadPoolExecutor.execute(tasks);
		}
	}
	
	/**
	 * 往任务队列中添加新的任务
	 * 
	 * @param emailInfoList新的任务信息
	 */
	public static void addNewEmailTask(List<String[]> emailInfoList) {
		tasks.addEmail(emailInfoList);
	}
	
	public static void main(String[] args) {
		executorTasks();
	}
	
}
