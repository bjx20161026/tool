package com.service.messageCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.esbCollect.MetaDtTaskRecord;
import com.service.cache.SqlResultCache;

public class CountDay {
	List<Map<String, Object>> countDay;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Map<String,Object>> Series(){
		if (SqlResultCache.Count.get("countDay") != null) {
			countDay = (List<Map<String, Object>>) SqlResultCache.Count.get("countDay");
		} else {
			MetaDtTaskRecord metaDtTaskRecord = new MetaDtTaskRecord();
			countDay = metaDtTaskRecord.GetCountDay();
			SqlResultCache.Count.put("countDay", countDay);
			}
		Map<String,Object> series = new HashMap<String,Object>();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		List<Object> listA = new ArrayList<Object>();
		for(Map map:countDay){
			listA.add(map.get("RECEIVE"));
		}
		series.put("name", "总量");
		series.put("data", listA);
		list.add(series);
		List<Object> listB = new ArrayList<Object>();
		for(Map map:countDay){
			listB.add(map.get("EFFECTIVE"));
		}
		Map<String,Object> series2 = new HashMap<String,Object>();
		series2.put("name", "有效数量");
		series2.put("data", listB);
		list.add(series2);
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, Object> Categories() {
		if (SqlResultCache.Count.get("countDay") != null) {
			countDay = (List<Map<String, Object>>) SqlResultCache.Count.get("countDay");
		} else {
			MetaDtTaskRecord metaDtTaskRecord = new MetaDtTaskRecord();
			countDay = metaDtTaskRecord.GetCountDay();
			SqlResultCache.Count.put("countDay", countDay);
		}
		Map<String,Object> categories = new HashMap<String,Object>();
		List<Object> list = new ArrayList<Object>();
		for(Map map:countDay){
			list.add(map.get("PERIOD"));
		}
		categories.put("categories", list);
		return categories;
	}

}
