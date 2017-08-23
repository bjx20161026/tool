package com;

import com.client.MqClient;
import com.server.MqServer;

public class SimpleMqTest {
	public static void main(String[] args) throws Exception{
		MqServer mqServer = new MqServer();
		mqServer.init();
	    Thread.sleep(100);
		MqClient mqClient = new MqClient();
		mqClient.init();
		System.out.println("当前线程数--->>>"+Thread.activeCount());
	}
}
