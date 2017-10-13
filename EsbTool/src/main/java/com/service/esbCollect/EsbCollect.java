package com.service.esbCollect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.DocumentException;

import com.dao.esbCollect.MetaDtMsgRecord;
import com.service.cache.SqlResultCache;
import com.service.download.ParseMsgXml;

public class EsbCollect {
	public List<Map<String,Object>> list;
	public void getMstRecord(String protocol,String startTime,String endTime){
		MetaDtMsgRecord metaDtMsgRecord = new MetaDtMsgRecord();
		list = metaDtMsgRecord.GetMsgList(protocol, startTime, endTime);
	}
	
	public List<Map<String,Object>> Parse(){
		List<Map<String,Object>> listResult = new ArrayList<Map<String,Object>>();
		Map mapResult;
		for(Map map:list){
			mapResult = new HashMap<String,Object>();
			mapResult.put("ID", map.get("ID"));
			mapResult.put("TIMES",map.get("RECEIVE_TIME_STAMP"));
			String msg  = (String) map.get("MSG_CONTENT");
			ParseMsgXml parseMsgXml = new ParseMsgXml();
			try {
				String ftpUrl = parseMsgXml.GetFtpInfo(msg);
				SqlResultCache.EsbCollectFtpUrl.put(parseMsgXml.getMyFileName(), ftpUrl);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mapResult.put("FILENAME", parseMsgXml.getMyFileName());
			mapResult.put("CHARSET", parseMsgXml.getCharset());
			listResult.add(mapResult);
		}
		return listResult;
	}
	
	public List<Map<String,Object>> Deal(String protocol,String startTime,String endTime){
		getMstRecord(protocol, startTime, endTime);
		return Parse();
	}
}
