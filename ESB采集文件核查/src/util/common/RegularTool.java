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
	    matcher.find();
		return matcher.find();
	}
	
	public static String MatcherValue(String str,String format){
		Pattern p = Pattern.compile(format,Pattern.CASE_INSENSITIVE|Pattern.MULTILINE);  
	    Matcher matcher = p.matcher(str);
	    if(matcher.find()){
	    	return matcher.group(1);
	    }
		return null;
	}
	
	public static void main(String[] args){
		System.out.println(RegularTool.MatcherValue("as10.221.232.135:21",".*?(\\d+\\.\\d+\\.\\d+\\.\\d+:21)"));
	}

}
