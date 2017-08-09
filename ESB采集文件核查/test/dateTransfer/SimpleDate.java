package dateTransfer;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SimpleDate {
	SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//如2016-08-10 20:40  
	public int countSecond(String start,String end) throws ParseException{
		long starttime = simpleFormat.parse(start).getTime();  
		long endtime = simpleFormat.parse(end).getTime();  
		int second = (int) ((starttime - endtime)/1000);
		return second;  
	}
	
	public static void main(String[] args){
/*		SimpleDate simpleDate = new SimpleDate();
		try {
			System.out.println(simpleDate.countSecond("2017-08-07 12:00:00","1970-01-01 00:00:00"));
			System.out.println("System.currentTimeMillis()--->>>"+System.currentTimeMillis());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		String str = "abc";
		System.out.println(str.toUpperCase());
	}
}
