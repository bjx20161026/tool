package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class justforfun {
	public static void main(String[] args){
//		try{
////			System.exit(0);
//			List<Map<String,String>> list = new ArrayList<Map<String,String>>();
//			Map<String,String> map = new HashMap<String,String>();
//			for(int i=1;;i++){
//				map.put(String.valueOf(i), String.valueOf(i));
//				list.add(map);
//			}
//		}finally {
//			
//			System.out.println(1+1);
//		}
		
		String  str = "STB_YHQK_20170720090000.CSV";
		str = str.substring(str.lastIndexOf("_")+1,str.lastIndexOf(".CSV"));
		System.out.println(str);
	}

}
