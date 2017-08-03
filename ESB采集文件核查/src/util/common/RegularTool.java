package util.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularTool {
	public static boolean IsNumber(String str){
		String format = "^(-?\\d+)(\\.\\d+)?$";
		 Pattern p = Pattern.compile(format,Pattern.CASE_INSENSITIVE|Pattern.MULTILINE);  
	     Matcher matcher = p.matcher(str);  
		return matcher.find();	
	}
	
	public static boolean isMatcher(String str,String format){
		Pattern p = Pattern.compile(format,Pattern.CASE_INSENSITIVE|Pattern.MULTILINE);  
	     Matcher matcher = p.matcher(str);  
		return matcher.find();
	}
	
	public static void main(String[] args){
		System.out.println(RegularTool.IsNumber("1234234.34"));
	}

}
