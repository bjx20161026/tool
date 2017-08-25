package com.service.loadDataCheck;

import java.text.ParseException;

import util.common.DateTools;
import util.common.RegularTool;

public class Formate {
	public static String RegexFormate(String str,String formate){
		if(formate.equals("regexp_replace(?,',|-','')")){
			str = str.replaceAll(",|-", "");
		}
		if(formate.equals("regexp_replace(?,'^--$','')")){
			str = str.replaceAll("^--$", "");
		}
		if(formate.equals("regexp_substr(?,'[0-9]+')")){
			str = RegularTool.MatcherValue(str,".*?([0-9]+).*?");
		}
		if(formate.equals("replace(?,'--','')")){
			str = str.replace("--", "");
		}
		if(formate.equals("replace(?,'null','')")){
			str = str.replace("null", "");
		}
		if(formate.equals("replace(replace(?,'M',''),'G','000')")){
			str = str.replace("M", "");
			str = str.replace("G", "000");
		}
		if(formate.equals("substr(?,15)")){
			str = str.substring(14);
		}
		if(formate.equals("to_number(replace(replace(?,'null','0'),'%',''))/100")){
			str = str.replace("null", "0");
			str = str.replace("%", "");
		}
		if(formate.equals("")){
			
		}
		if(formate.equals("(to_date(substr(?,1,17),'yy-mm-dd hh24:mi:ss') - to_date('1970-01-01','yyyy-mm-dd'))*24*60*60")){	
			str = str.substring(0,17);
			try {
				str = String.valueOf(DateTools.CountAbsolutelySecond(str, "yy-mm-dd hh24:mi:ss"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return str;
	}
}
