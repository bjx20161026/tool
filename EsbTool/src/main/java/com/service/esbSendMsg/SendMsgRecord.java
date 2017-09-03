package com.service.esbSendMsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.MetaDtMsgSendRecord;
import com.service.download.ParseMsgXml;

public class SendMsgRecord {
	public List<Map<String,String>> getMsgRecord() throws Exception{
		MetaDtMsgSendRecord metaDtMsgSendRecord = new MetaDtMsgSendRecord();
		List<Map<String,Object>> list = metaDtMsgSendRecord.getRecord("DW_", "1/24");
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		Map<String,Object> map2;
		ParseMsgXml parseMsgXml = new ParseMsgXml();
		long starTime=System.currentTimeMillis();
		for(Map map:list){
			map2 =new HashMap<String, Object>();
			map2.put("CALL_RESULT", map.get("CALL_RESULT"));
			map2.put("SEND_TIME_STAMP",map.get("SEND_TIME_STAMP"));
			map2.put("ESB_MSG", parseMsgXml.GetFtpInfo((String)map.get("ESB_MSG")));
		}
		long end=System.currentTimeMillis();
		System.out.println(end-starTime);
		return null;
	}
	
	public static void main(String[] args) throws Exception{
		SendMsgRecord sendMsgRecord = new SendMsgRecord();
		sendMsgRecord.getMsgRecord();
	}

}
