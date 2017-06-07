package syslogClient;


public class MyThread extends Thread{
	StringBuilder builder;
	String str;
//	StringBuffer builder;
	
	public MyThread(StringBuilder builder,String str){
		this.builder = builder;
		this.str=str;
	}
	@Override
	public void run(){
		for(int i = 0;i<10;i++){
			builder.append(i+str);
			System.out.println(builder.toString());
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
