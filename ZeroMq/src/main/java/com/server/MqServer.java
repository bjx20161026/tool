package com.server;

import org.zeromq.ZMQ;

import com.common.MqCache;
import com.common.MyThread;

public class MqServer{
	public int rioThreads = 1;
	public String charset = "utf-8";
	public String raddr = "tcp://*:5555";
	public String rreply = "succeed";
	public int sioThreads = 2;
	public String saddr = "tcp://*:6666";

	public void Receive() throws Exception{
		    ZMQ.Context context = ZMQ.context(rioThreads);
	        ZMQ.Socket responder = context.socket(ZMQ.REP);
	        responder.bind(raddr);
	        while (!Thread.currentThread().isInterrupted()) {
	            byte[] request = responder.recv(0);
	            MqCache.mqQueue.offer(new String(request,charset));
	            Thread.sleep(500);
	            System.out.println("Receive<--->Mq队列长度--->>>"+MqCache.mqQueue.size());
	            responder.send(rreply.getBytes(), 0);
	        }
	        responder.close();
	        context.term();
	}
	
	public void Send() throws Exception{
	    ZMQ.Context context = ZMQ.context(sioThreads);
        ZMQ.Socket responder = context.socket(ZMQ.REP);
        responder.bind(saddr);
        while (!Thread.currentThread().isInterrupted()) {
            @SuppressWarnings("unused")
			byte[] request = responder.recv(0);
            System.out.println("Send<--->Mq队列长度--->>>"+MqCache.mqQueue.size());
        	Thread.sleep(1000);
            while(MqCache.mqQueue.size()==0){
            	Thread.sleep(1000);
            }
            responder.send(MqCache.mqQueue.poll().getBytes(), 0);
        }
        responder.close();
        context.term();
	}
	
	public void init(){
		try{
			MyThread myThread = new MyThread(); 
			myThread.setClassName("com.server.MqServer");
			myThread.setMethodName("Receive");
			myThread.start();
			MyThread myThreads = new MyThread(); 
			myThreads.setClassName("com.server.MqServer");
			myThreads.setMethodName("Send");
			myThreads.start();
		}catch(Exception e){
			e.printStackTrace();
			init();
		}
	}
	
	public int getRioThreads() {
		return rioThreads;
	}

	public void setRioThreads(int rioThreads) {
		this.rioThreads = rioThreads;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getRaddr() {
		return raddr;
	}

	public void setRaddr(String raddr) {
		this.raddr = raddr;
	}

	public String getRreply() {
		return rreply;
	}

	public void setRreply(String rreply) {
		this.rreply = rreply;
	}

	public int getSioThreads() {
		return sioThreads;
	}

	public void setSioThreads(int sioThreads) {
		this.sioThreads = sioThreads;
	}

	public String getSaddr() {
		return saddr;
	}

	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}

	
	public static void main(String[] args){
		MqServer mqServer = new MqServer();
		mqServer.init();
	}

}
