package com.service.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.resteasy.logging.Logger;

import com.dao.esbCollect.MetaDtTaskRecord;
import com.dao.inasCollect.DmCoBaCfgClt;
import com.dao.inasCollect.DmCoBaTaskRecord;

public class SqlResultCache {
	Logger logger = Logger.getLogger(SqlResultCache.class);
	public static Map<String,Object> Count = new HashMap<String,Object>();
	public static Map<String,String> EsbCollectFtpUrl = new HashMap<String,String>();
	public void init(){
		MetaDtTaskRecord metaDtTaskRecord = new MetaDtTaskRecord();
		List<Map<String, Object>> countDay = metaDtTaskRecord.GetCountDay();
		SqlResultCache.Count.put("countDay", countDay);
		DmCoBaTaskRecord dmCoBaTaskRecord = new DmCoBaTaskRecord();
		List<Map<String, Object>> countShare = dmCoBaTaskRecord.GetCountDay();
		SqlResultCache.Count.put("countShare", countShare);
		DmCoBaCfgClt inasPolicyTable = new DmCoBaCfgClt();
		List<Map<String,Object>> inasPolicy =  inasPolicyTable.getPolicy();
		SqlResultCache.Count.put("inasPolicy", inasPolicy);
		EsbCollectFtpUrl = new HashMap<String,String>();
	}
}
