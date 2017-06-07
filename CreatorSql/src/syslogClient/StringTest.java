package syslogClient;

public class StringTest {
	
	public void Stringffciency(){
		String str = "";
		long start=System.currentTimeMillis();
		for(int i = 0;i<100000;i++)
			str = str+i;
		long end=System.currentTimeMillis();
		System.out.println(end-start);
		
		StringBuffer strb = new StringBuffer();
		long start2=System.currentTimeMillis();
		for(int i = 0;i<1000000;i++)
			strb = strb.append(i);
		long end2=System.currentTimeMillis();
		System.out.println(end2-start2);
		String str2 = strb.toString();
//		if(str.equals(str2)) System.out.println("str 和  str2 相等");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder builder=new StringBuilder();
		long start3=System.currentTimeMillis();
		for(int i = 0;i<1000000;i++)
			builder = builder.append(i);
		long end3=System.currentTimeMillis();
		System.out.println(end3-start3);
	}

	public Runa Creat(){
		Runa runa = new Runa();
		return runa;
	}
	
	public class Runa implements Runnable{
		public Runa(){
			
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i = 0;i<6;i++){
				System.out.println("A");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	public Runb CreatB(){
		Runb runb = new Runb();
		return runb;
	}
	
	public class Runb implements Runnable{
		public Runb(){
			
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i = 0;i<6;i++){
				System.out.println("B");
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		
	}
//	
//	public class MyThread extends Thread{
//		StringBuilder builder=new StringBuilder();
//		@Override
//		public void run(){
//			for(int i = 0;i<10;i++){
//				builder.append(i);
//			}
//		}
//	}
//	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		long star =System.currentTimeMillis();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		long end=System.currentTimeMillis();
//		System.out.println(end - star);
//		StringTest stringTest = new StringTest();
//		Runa runa = stringTest.Creat();
//		Runb runb = stringTest.CreatB();
//		Thread thread1 = new Thread(runa);
//		Thread thread2 = new Thread(runb);
//		thread1.start();
//		thread2.start();
		StringBuilder builder = new StringBuilder();
		MyThread abc = new MyThread(builder,"a");
		MyThread efg = new MyThread(builder,"b");
		abc.start();
		efg.start();
		
	}
}
