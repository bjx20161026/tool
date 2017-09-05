package com.service.esbSendMsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.MetaDtMsgSendRecord;
import com.service.download.ParseMsgXml;

public class SendMsgRecord {
	public List<Map<String,Object>> getMsgRecord(String protocol,String day) throws Exception{
		MetaDtMsgSendRecord metaDtMsgSendRecord = new MetaDtMsgSendRecord();
		List<Map<String,Object>> list = metaDtMsgSendRecord.getRecord(protocol, day);
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		Map<String,Object> map2;
		ParseMsgXml parseMsgXml = new ParseMsgXml();
		long starTime=System.currentTimeMillis();
		for(Map map:list){
			map2 =new HashMap<String, Object>();
			map2.put("ID", map.get("ID"));
			map2.put("CALL_RESULT", map.get("CALL_RESULT"));
			map2.put("SEND_TIME_STAMP",map.get("SEND_TIME_STAMP"));
			parseMsgXml.GetFtpInfoForSend((String)map.get("ESB_MSG"));
			String fileName = null;
			fileName = parseMsgXml.getMyFileName();
			if(fileName == null) fileName = "文件名解析失败";
			map2.put("MSG_CONTENT",fileName);
			list2.add(map2);
		}
		long end=System.currentTimeMillis();
		System.out.println(end-starTime);
		return list2;
	}
	
	public static void main(String[] args) throws Exception{
		SendMsgRecord sendMsgRecord = new SendMsgRecord();
//		sendMsgRecord.getMsgRecord();
	}

}
