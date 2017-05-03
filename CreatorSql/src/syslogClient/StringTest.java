package syslogClient;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "";
//		long start=System.currentTimeMillis();
//		for(int i = 0;i<100000;i++)
//			str = str+i;
//		long end=System.currentTimeMillis();
//		System.out.println(end-start);
//		
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

}
