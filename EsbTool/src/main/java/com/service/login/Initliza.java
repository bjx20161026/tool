package com.service.login;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import util.timedTask.Shedual;

public class Initliza implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		Shedual shedual = new Shedual();
		shedual.init();
	}
}
