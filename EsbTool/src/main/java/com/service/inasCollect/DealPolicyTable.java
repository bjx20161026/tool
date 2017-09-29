package com.service.inasCollect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.resteasy.logging.Logger;

import com.alibaba.fastjson.JSON;
import com.dao.inasCollect.DmCoBaCfgClt;
import com.service.cache.SqlResultCache;
import com.service.model.FastCollectConfig;

import util.common.RegularTool;

public class DealPolicyTable {
	
	Logger logger = Logger.getLogger(getClass());
	public List<Map<String,Object>> list;
	public DmCoBaCfgClt inasPolicyTable;
	
	public DealPolicyTable(){
		if(SqlResultCache.Count.get("inasPolicy") == null){
		inasPolicyTable = new DmCoBaCfgClt();
		list = inasPolicyTable.getPolicy();
		SqlResultCache.Count.put("inasPolicy", list);
		}else{
			list = (List<Map<String, Object>>) SqlResultCache.Count.get("inasPolicy");
		}
		logger.info("list.size--->>>"+list.size());
	}
	
	public void RefreshList(){
		inasPolicyTable = new DmCoBaCfgClt();
		list = inasPolicyTable.getPolicy();
	}
	
	public List<Map<String,Object>> parseConfigForCollect(String targetId,String targetConfig){
		FastCollectConfig fcc;
		List<Map<String,Object>> listCollect = new ArrayList<Map<String,Object>>();
		Map mapCollect;
		for(Map map:list){
			mapCollect = new HashMap<String,Object>();
			String id = (String) map.get("ID");
			if(targetId != null&&!id.contains(targetId)){
				continue;
			}
			String type = (String)map.get("TYPE");
			if(!type.equals("0")){
				continue;
			}
			String config = (String)map.get("CONFIG");		
			if(targetConfig != null&&!config.contains(targetConfig)){
				continue;
			}
			fcc = JSON.parseObject(config, FastCollectConfig.class);
			String url = fcc.getUrl();
		    if(url==null){
		    	continue;
		    }
			mapCollect.put("ID", id);
			mapCollect.put("FILEPATTEN",url.substring(url.lastIndexOf("/")+1,url.length()));
			mapCollect.put("TABLENAME", RegularTool.MatcherValue(fcc.getInsertSql(),"insert into (.*?)\\(.*"));
			mapCollect.put("charset", fcc.getExtInfo().get("charset")==null?"gbk":fcc.getExtInfo().get("charset"));
			mapCollect.put("seperator", fcc.getExtInfo().get("seperator")==null?",":fcc.getExtInfo().get("seperator"));	
			listCollect.add(mapCollect);
		}
		return listCollect;
	}
	
	public List<Map<String,Object>> parse(String targetType,String targetId,String targetConfig){
		if(targetType.equals("0")){
			return parseConfigForCollect(targetId, targetConfig);
		}
		return null;
	}
	
	public static void main(String[] args){
		System.out.println("asdfab".contains("asv"));
//		DealPolicyTable DealPolicyTable = new DealPolicyTable();
//		for(Map map:DealPolicyTable.parseConfigForCollect(null, null)){
//			for(Object key:map.keySet()){
//				System.out.println(map.get(key));
//			}
//		};
	}
}
