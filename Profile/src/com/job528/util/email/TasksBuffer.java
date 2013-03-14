package com.job528.util.email;

import java.util.LinkedList;

import org.apache.log4j.Logger;
/**
 * 
 * @author lusanxiong
 * 
 * 为避免与客户端线程竟争任务队列锁
 * 
 * 建立一个任务队列缓冲区,创建单个线程按固定周期从任务队列缓冲区中取一批量任务放入实际任务队列中.
 * 
 * 执行任务的线程不间断的从实际任务队列中取出任务执行.
 *
 */
public class TasksBuffer implements Runnable{
	private static Logger logger = Logger.getLogger(ExecutorTaskManager.class);
	private final static Object lock = new Object();
	
	//缓冲区任务队列
	private final static LinkedList<String[]> emailTasksBuffer = new LinkedList<String[]>();
	public final static TasksBuffer taskBuffer = new TasksBuffer();
	
	@Override
	public void run() {
		LinkedList<String[]> list = Tasks.getEmailTaskListInstance();
		System.out.println("buffer size=="+emailTasksBuffer.size());
		if(list.size() == 0) {
			System.out.println("任务队列空了空了.........");
			addTasks();
		}
	}
	 
	/*
	 * 从缓冲区任务队列中取出一批量任务放入实际任务队列中
	 */
	public void addTasks() {
		synchronized(lock) {
			System.out.println("重新给它加任务了.......");
			LinkedList<String[]> list = Tasks.getEmailTaskListInstance();
			list.addAll(emailTasksBuffer);
			emailTasksBuffer.clear();
		}
	}
	
	public static void setTaskBuffer(LinkedList<String[]> list){
		synchronized (lock) {
			emailTasksBuffer.addAll(list);
		}
	}
	
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		for(int i=0; i<10; i++) {
			list.add(String.valueOf(i));
		}
		
		LinkedList<String> list2 = new LinkedList<String>();
		for(int i=10; i>0; i--) {
			list2.add(String.valueOf(i));
		}
		
		
		
		System.out.println("list=="+list);
		System.out.println("list=="+list2);
		list.addAll(list2);
		System.out.println("list=="+list);
		list2.clear();
		System.out.println("list=="+list);
		System.out.println("list=="+list2);
	}
}
