package com.creatorSql;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.readExcle.ReadExcle;

public class CreatGet {
	String str="";
	public String getSql(List<HashMap<String, String>> list,String tempName){
		for (int i = 0; i < list.size(); i++) {
			Map<String, String> map = list.get(i);
			String column1=map.get("1");
			if(i==0){
				str=tempName+".get"+column1+"()";
			}else{
			str=str+","+tempName+".get"+column1+"()";
			}
			}
		return str;	
	}
	public static void main(String[] args) throws IOException{
		 List<HashMap<String, String>> list;
		 ReadExcle readExcle=new ReadExcle();
		 list=readExcle.readExcel("F:/工单.xlsx");
		 CreatGet crp=new CreatGet();
		 String abc=crp.getSql(list,"workJob");
		 System.out.println(abc);
	}

}
