package com.job528.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.job528.listener.tast.HotUserTast;


public class HotUserListener implements ServletContextListener{

	private Timer timer = null;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		timer = new java.util.Timer(true);
		timer.schedule(new HotUserTast(event.getServletContext()),1000, 3*60*60*1000);
		
	}

}
