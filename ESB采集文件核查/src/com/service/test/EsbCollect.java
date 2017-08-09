package com.service.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EsbCollect {
	public String protocol;
	public int start;
	public int end;
	public String pre;
	public String HandleMsg(String str){
		String pattern = "(.*?) (\\d+) (\\d+)(.*)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(str);
	      if (m.find( )) {
	    	 System.out.println("Found count: " + m.groupCount());
	         System.out.println("Found value: " + m.group(0) );
	         System.out.println("Found value: " + m.group(1) );
	         System.out.println("Found value: " + m.group(2) );
	         System.out.println("Found value: " + m.group(3) ); 
	         System.out.println("Found value: " + m.group(4) ); 
	      } else {
	         System.out.println("NO MATCH");
	      }
		return str;
	}
	public static void main(String[] args){
		String str = "0123456789";
		str = str.substring(2);
		System.out.println(str);
	}
}
