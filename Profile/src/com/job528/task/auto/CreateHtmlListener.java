package com.job528.task.auto;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class CreateHtmlListener implements ServletContextListener {


	private Timer timer = null;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		timer = new java.util.Timer(true);
		timer.schedule(new CreateHtmlTast(),1000, 24*60*60);
		
	}


}
