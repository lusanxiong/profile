package com.job528.util.email;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
/**
 * 
 * @author lusanxiong
 * 
 * 因Tasks只会被实例化一次,多线程环境中,其所有的成员变量都是非线程安全.
 *
 */
public class Tasks implements Runnable{
	private static Logger logger = Logger.getLogger(ExecutorTaskManager.class);
	private static final ReentrantLock lock = new ReentrantLock();
	private static final ReentrantLock  statictiesLock = new ReentrantLock();
	
	private static long totalEmailCount = 0; //总的邮件数量,不断的累积
	private static long sendFailEmailCount = 0; //发送失败的邮件数量.
	private static long sendSuccessEmailCount = 0; //发送成功的邮件数量.
	private static long currentSendingEmailThreadCount = 0; //当前正在发送的邮件的线程数
	
	/*
	 *邮件列表任务中的每个邮件信息包含的是
	 *发件人名称
	 *收件人名称
	 *收件人邮箱 
	 */
	private final static LinkedList<String[]> totalEmailTaskList = new LinkedList<String[]>();
	
	@Override
	public void run() {
		if(getTaskLength() == 0) {
			return;
		}
		
		boolean flag = false;
		try {
			flag = sendEmail(); //执行发送邮件任务
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("发送邮件错误!",e);
			flag = false;
		}
		
		//统计发送失败的邮件数量
		statictiesLock.lock();
		try {
			if(!flag) {
				sendFailEmailCount = sendFailEmailCount + 1;
				System.out.println("发送失败的邮件数量:"+sendFailEmailCount);
			}else {
				sendSuccessEmailCount = sendSuccessEmailCount + 1;
				System.out.println("发送邮件成功!数量:"+sendSuccessEmailCount);
			}
		}finally {
			statictiesLock.unlock();
		}
	}
	
	/**
	 * 往邮件任务列表中存放邮件信息
	 */
	public void addEmail(List<String[]> emailInfoList) {
		lock.lock();//从这句开始当前线程获得独占该资源,如果是同一个线程,锁可以重进入.
		try {
			int size = emailInfoList.size();
			if(totalEmailTaskList.size()+ size> 10000) {
				//超过最大容量
			}
			totalEmailTaskList.addAll(emailInfoList);//存放在此列表的队尾
			totalEmailCount = totalEmailCount + size;//统计所有累计的需要发送的邮件数量.
		}finally {
			lock.unlock(); //这句表示当前线程已经释放该锁
		}
	}
	
	public static LinkedList<String[]> getEmailTaskListInstance() {
		return totalEmailTaskList;
	}
	
	public static int getTaskLength() {
		lock.lock();
		try {
			return totalEmailTaskList.size();
		}finally {
			lock.unlock();
		}
	}
	
	/**
	 * 发送email
	 */
	public boolean sendEmail() throws Exception {
		//获取邮件任务列表
		String[] emailInfos = getTaskList();
		
		String senderName    = emailInfos[0]; //发件人名称
		String receiverName  = emailInfos[1]; //收件人名称
		String receiverEmail = emailInfos[2]; //收件人email地址
		//String recommendPositionId = emailInfos[3] //职位ID
		//String positionJobName = emailInfos[4]; //工作岗位名称
		//String mailType = emailInfos[5];//邮件类型
		
		MailBody mb = new MailBody();
		mb.setMailContent(senderName+"==content");
		mb.setMailTitle("您的好友向您推荐的职位.");
		mb.setToEmail(receiverEmail);
		
		MailSender ms = new MailSender();
		ms.setMailBody(mb);
		
		boolean flag = false;
		try {
		   flag = ms.sendMail();
		}catch(Exception e) {
			e.printStackTrace();
			logger.info("发件人:"+senderName+"|收件人:"+receiverName+"标题:职位推荐");
			throw new Exception();
			
		}
		
		return flag;
	}
	
	/**
	 * 获取任务列表
	 * @return
	 */
	public String[] getTaskList() {
		String[] emailInfos = new String[6];
		
		//获取邮件任务列表
		lock.lock();
		try {
			emailInfos =totalEmailTaskList.poll(); //获取并移除此列表的头
			System.out.println("任务列表数量="+totalEmailTaskList.size());
			
			currentSendingEmailThreadCount = currentSendingEmailThreadCount + 1;
			
			//每3个线程之间睡10s以减轻邮件服务器的压力
			if(currentSendingEmailThreadCount%3==0) {
				TimeUnit.SECONDS.sleep(10);
				System.out.println("线程数量.........."+currentSendingEmailThreadCount);
			}
			//每5个线程之间睡10s以减轻邮件服务器的压力
			if(currentSendingEmailThreadCount%5==0) {
				TimeUnit.SECONDS.sleep(10);
				System.out.println("线程数量.........."+currentSendingEmailThreadCount);
			}
			
			if(currentSendingEmailThreadCount%50==0) {
				TimeUnit.SECONDS.sleep(20);
				System.out.println("线程数量.........."+currentSendingEmailThreadCount);
				currentSendingEmailThreadCount = 0;
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
		return emailInfos; 
	}
	
	public static void main(String[] args) {
		for(int i=0; i<50; i++) {
			MailBody mb = new MailBody();
			mb.setMailContent("test"+i+"==content");
			mb.setMailTitle("test"+i+"发给"+"");
			mb.setToEmail("1145927211@qq.com");
			
			MailSender ms = new MailSender();
			ms.setMailBody(mb);
			boolean flag = ms.sendMail();
			
			if(i%5 ==0) {
				System.out.println("i="+i);
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("end..."+Thread.currentThread().getName()+"=="+flag);
			}
		}
		//为减轻邮件服务器压力,每个线程发送之前等待3秒
		/*long s_time = System.currentTimeMillis();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("wait--time="+(System.currentTimeMillis()-s_time));
		System.out.println(""+Long.MAX_VALUE);*/
	}
	
}
