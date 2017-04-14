package com.creatorSql;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.readExcle.ReadExcle;

import common.Common;

public class CreatInsert {
	String column=Common.EMPTY;
	String value=Common.EMPTY;
	String column1,column2;
	/**
	 * 
	 * @param list
	 * @return String
	 */
	public String InsertSql(List<HashMap<String, String>> list){
		for (int i = 0; i < list.size(); i++) {
			Map<String, String> map = list.get(i);
			column1=map.get("1");
			column2=map.get("2");
			if(i==0){
				column=column1;
				value=column2;
			}else{
			column=column+","+column1;
			value=value+","+column2;
			}
		}
		return "("+column+")values("+value+")";
	}
	public static void main(String[] args) throws IOException{
		 List<HashMap<String, String>> list;
		 ReadExcle readExcle=new ReadExcle();
		 list=readExcle.readExcel("F:/insert.xlsx");
		 CreatInsert crp=new CreatInsert();
		 String abc=crp.InsertSql(list);
		 System.out.println(abc);
	}
}
