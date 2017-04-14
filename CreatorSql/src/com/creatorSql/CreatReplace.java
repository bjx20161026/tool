package com.creatorSql;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.readExcle.ReadExcle;

public class CreatReplace {
	String str="?";
	public String ReplaceSql(List<HashMap<String, String>> list){
		String name,value;
		for (int i = 0; i < list.size(); i++) {
			Map<String, String> map = list.get(i);
		    name=map.get("1");
			value=map.get("2");
			str="REPLACE("+str+","+name+",'"+value+"')";
		}
		return str;
	}
	public String JK4Replace(List<HashMap<String, String>> list){
		String sheetA,sheetB,sheetC;
		for(int i=0;i<list.size();i++){
			Map<String, String> map = list.get(i);
			if(StringUtils.isNotBlank(map.get("3"))){
				sheetA=map.get("1");
				sheetB=map.get("2");
				sheetC=map.get("3");
				System.out.println(sheetC);
				str="REPLACE("+str+",'"+sheetA+sheetC+"','"+sheetB+"')";
			}
		}
		return str;
	}
	public String JK5Replace(List<HashMap<String,String>> list){
		String sheetA,sheetC,sheetD,sheetE;
		for(int i=0;i<list.size();i++){
			Map<String, String> map = list.get(i);
			if(StringUtils.isNotBlank(map.get("5"))){
				sheetA=map.get("1");
				sheetC=map.get("3");
				sheetD=map.get("4");
				sheetE=map.get("5");
				System.out.println(sheetE);
				str="REPLACE("+str+",'"+sheetA+sheetC+sheetE+"','"+sheetD+"')";
			}
		}
		return str;
	}
	public String JK6Replace(List<HashMap<String,String>> list){
		String sheetA,sheetC,sheetE,sheetF,sheetG;
		for(int i=0;i<list.size();i++){
			Map<String, String> map = list.get(i);
			if(StringUtils.isNotBlank(map.get("7"))){
				sheetA=map.get("1");
				sheetC=map.get("3");
				sheetE=map.get("5");
				sheetF=map.get("6");
				sheetG=map.get("7");
				System.out.println(sheetG);
				str="REPLACE("+str+",'"+sheetA+sheetC+sheetE+sheetG+"','"+sheetF+"')";
			}
		}
		return str;
	}
//	public static void main(String[] args) throws IOException{
//		 List<HashMap<String, String>> list;
//		 ReadExcle readExcle=new ReadExcle();
//		 list=readExcle.readExcel("F:/province_gorweizhiqianyi.xlsx");
//		 CreatReplace crp=new CreatReplace();
//		 String abc=crp.ReplaceSql(list);
//		 System.out.println(abc);
//	}
//	public static void main(String[] args) throws IOException{
//		 List<HashMap<String, String>> list;
//		 ReadExcle readExcle=new ReadExcle();
//		 list=readExcle.readExcel("F:/Example.xlsx");
//		 CreatReplace crp=new CreatReplace();
//		 String abc=crp.JK4Replace(list);
//		 System.out.println(abc);
//	}
	
//	public static void main(String[] args) throws IOException{
//		 List<HashMap<String, String>> list;
//		 ReadExcle readExcle=new ReadExcle();
//		 list=readExcle.readExcel("F:/Example.xlsx");
//		 CreatReplace crp=new CreatReplace();
//		 String abc=crp.JK5Replace(list);
//		 System.out.println(abc);
//	}
//	
	public static void main(String[] args) throws IOException{
		 List<HashMap<String, String>> list;
		 ReadExcle readExcle=new ReadExcle();
		 list=readExcle.readExcel("F:/Example.xlsx");
		 CreatReplace crp=new CreatReplace();
		 String abc=crp.JK6Replace(list);
		 System.out.println(abc);
	}
}

