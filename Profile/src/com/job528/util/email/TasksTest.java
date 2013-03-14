package com.job528.util.email;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import java.util.concurrent.TimeUnit;

public class TasksTest implements Runnable   {
	public static void main(String[] args) {
		 
	}
	/**
	 * 不断的往任务队列中添加新的任务
	 */
	
	@Override
	public void run() {
		long s_time = System.currentTimeMillis();
		System.out.println("添加新任务开始...."+Thread.currentThread().getName());
		LinkedList<String[]> emailInfoList = new LinkedList<String[]>();
		String[] email = new String[] {"卢三雄","罗日成","1145927211@qq.com"};
		for(int i=0; i<50; i++) {
			emailInfoList.add(email);
		}
		TasksBuffer.taskBuffer.setTaskBuffer(emailInfoList);
		//ExecutorTaskManager.addNewEmailTask(emailInfoList);
		/*try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		System.out.println("添加新任务结束..speed time.."+(System.currentTimeMillis()-s_time)+"ms");
	}
	
}
