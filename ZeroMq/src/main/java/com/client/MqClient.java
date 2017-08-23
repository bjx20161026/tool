package com.client;

import org.zeromq.ZMQ;

import com.common.MyThread;

public class MqClient {
	public int pioThreads = 1;
	public String paddr = "tcp://localhost:5555";
	public int gioThreads = 2;
	public String gaddr = "tcp://localhost:6666";
	public void push(){
	       ZMQ.Context context = ZMQ.context(pioThreads);
	       ZMQ.Socket requester = context.socket(ZMQ.REQ);
	       requester.connect(paddr);
	       for (int requestNbr = 0; requestNbr != 100; requestNbr++) {
	           String request = "Hello";
	           System.out.println("Sending Message " + requestNbr);
	           requester.send(request.getBytes(), 0);
	           byte[] reply = requester.recv(0);
	           System.out.println("Received " + new String(reply) + " " + requestNbr);
	       }
	       requester.close();
	       context.term();
	   }
	
	public void get(){
		 ZMQ.Context context = ZMQ.context(gioThreads);
	       ZMQ.Socket requester = context.socket(ZMQ.REQ);
	       requester.connect(gaddr);
	       for (int requestNbr = 0; requestNbr != 100; requestNbr++) {
	           String request = "Hello";
	           System.out.println("get Message " + requestNbr);
	           requester.send(request.getBytes(), 0);
	           byte[] reply = requester.recv(0);
	           System.out.println("Received " + new String(reply) + " " + requestNbr);
	       }
	       requester.close();
	       context.term();
	}
	
	public void init(){
		try{
			MyThread myThread = new MyThread(); 
			myThread.setClassName("com.client.MqClient");
			myThread.setMethodName("push");
			myThread.start();
			MyThread myThreads = new MyThread(); 
			myThreads.setClassName("com.client.MqClient");
			myThreads.setMethodName("get");
			myThreads.start();
		}catch(Exception e){
			e.printStackTrace();
			init();
		}
	}

	public static void main(String[] args){
		MqClient mqClient = new MqClient();
		mqClient.init();
	}
}
