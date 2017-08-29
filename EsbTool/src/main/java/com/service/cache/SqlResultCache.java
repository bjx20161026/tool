package com.service.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.resteasy.logging.Logger;

import com.dao.DmCoBaTaskRecord;
import com.dao.MetaDtTaskRecord;

public class SqlResultCache {
	Logger logger = Logger.getLogger(SqlResultCache.class);
	public static Map<String,Object> Count = new HashMap<String,Object>();
	public void init(){
		MetaDtTaskRecord metaDtTaskRecord = new MetaDtTaskRecord();
		List<Map<String, Object>> countDay = metaDtTaskRecord.GetCountDay();
		SqlResultCache.Count.put("countDay", countDay);
		DmCoBaTaskRecord dmCoBaTaskRecord = new DmCoBaTaskRecord();
		List<Map<String, Object>> countShare = dmCoBaTaskRecord.GetCountDay();
		SqlResultCache.Count.put("countShare", countShare);
	}
}
