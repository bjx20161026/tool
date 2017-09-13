package com.service.wlanIpnet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.dao.thirtynine.DmCoBaCfgClt;
import com.service.model.CreateObject;

import util.common.FileTools;

public class DealTaskTable {
	
	public List<Map<String,Object>> getAll(){
		DmCoBaCfgClt dmCoBaCfgClt = new DmCoBaCfgClt();
		return dmCoBaCfgClt.GetAll();
	}

	public List<String> getAllTableName(){
		List<Map<String,Object>> list = getAll();
		for(Map map:list){
			String config = (String) map.get("CONFIG"); 
			CreateObject co = JSON.parseObject(config, CreateObject.class);
//			System.out.println(co.getUrl());
//			System.out.println(co.getQuerySql());
			System.out.println((String) map.get("ID"));
		}
		return null;
	}
	
	public List<Map<String,String>> transToAnotherFtp(){
		List<Map<String,Object>> list = getAll();
		List<Map<String,String>> nlist = new ArrayList<Map<String,String>>();
		Map nMap;
		String id;
		String config;
		String type;
		String WlanNew = getPrepareSql("WlanNew");
		String WlanOld = getPrepareSql("WlanOld");
		for(Map map:list){
			 nMap = new HashMap<String,String>();
			 id = ((String)map.get("ID")).replace("esb-", "esb-NEW-");
			 config = ((String)map.get("CONFIG")).replace(WlanOld, WlanNew);
			 type = (String)map.get("TYPE");
			 System.out.println("id--->>>"+id);
			 System.out.println("config--->>>"+config);
			 nMap.put("ID", id);
			 nMap.put("CONFIG", config);
			 nMap.put("TYPE", type);
			 nlist.add(nMap);
		}
		return nlist;
	}
	
	public String getPrepareSql(String key){
		Properties properties = FileTools.getProperties("PrepareString.properties");
		return properties.getProperty(key);
	}
	
	public static void main(String[] args){
		DealTaskTable dealTaskTable = new DealTaskTable();
		dealTaskTable.getAllTableName();
//		List<Map<String,String>> list = dealTaskTable.transToAnotherFtp();
//		DmCoBaCfgClt dmCoBaCfgClt = new DmCoBaCfgClt();
//		int i = dmCoBaCfgClt.InsertNew(list);
//		System.out.println("共插入 "+i+" 条");
	}
	
}
