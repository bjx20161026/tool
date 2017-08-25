package com.service.messageCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.DmCoBaTaskRecord;
import com.service.cache.SqlResultCache;

public class CountShare {
	List<Map<String, Object>> countShare;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Map<String,Object>> Series(){
		if (SqlResultCache.Count.get("countShare") != null) {
			countShare = (List<Map<String, Object>>) SqlResultCache.Count.get("countShare");
		} else {
			DmCoBaTaskRecord dmCoBaTaskRecord = new DmCoBaTaskRecord();
			countShare = dmCoBaTaskRecord.GetCountDay();
			SqlResultCache.Count.put("countShare", countShare);
			}
		Map<String,Object> series = new HashMap<String,Object>();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		List<Object> listA = new ArrayList<Object>();
		for(Map map:countShare){
			listA.add(map.get("RECEIVE"));
		}
		series.put("name", "ESB共享");
		series.put("data", listA);
		list.add(series);
		List<Object> listB = new ArrayList<Object>();
		for(Map map:countShare){
			listB.add(map.get("FTPRECEIVE"));
		}
		Map<String,Object> series2 = new HashMap<String,Object>();
		series2.put("name", "FTP采集");
		series2.put("data", listB);
		list.add(series2);
		return list;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, Object> Categories() {
		if (SqlResultCache.Count.get("countShare") != null) {
			countShare = (List<Map<String, Object>>) SqlResultCache.Count.get("countShare");
		} else {
			DmCoBaTaskRecord dmCoBaTaskRecord = new DmCoBaTaskRecord();
			countShare = dmCoBaTaskRecord.GetCountDay();
			SqlResultCache.Count.put("countShare", countShare);
		}
		Map<String,Object> categories = new HashMap<String,Object>();
		List<Object> list = new ArrayList<Object>();
		for(Map map:countShare){
			list.add(map.get("PERIOD"));
		}
		categories.put("categories", list);
		return categories;
	}

}
