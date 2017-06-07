package com.service.fastCollect.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.mapping.dm_co_ba_cfg_clt;
import com.dao.mapping.dm_co_ba_cfg_task_mng;
import com.dao.mapping.ipmsdm.dm_co_ba_cfg_cltMapper;
import com.dao.mapping.ipmsdm.dm_co_ba_cfg_task_mngMapper;
import com.service.fastCollect.FastCollect;
import com.service.model.EsbUploadMsg;
import com.service.model.FastCollectConfig;
import com.service.util.common.FileTools;
import com.service.util.excle.ReadExcle;
@Service
public class FastCollectImpl implements FastCollect {
	Logger logger = Logger.getLogger(FastCollectImpl.class);
	List<Map<String, String>> list;
	Map<String, String> map;
	Properties pro;
	@Autowired
	dm_co_ba_cfg_task_mngMapper taskTableDao;
	@Autowired
	dm_co_ba_cfg_cltMapper configTableDao;
	@Autowired
	FastCollectConfig fastCollectConfig;
	@Autowired
	EsbUploadMsg esbUploadMsg;
	@Override
	public String CreatFastCollectConfig(String path) throws Exception {
		// TODO Auto-generated method stub
		File file=new File(path);
		if(file.isDirectory()){
			List<String> filePaths = FileTools.listFiles(path);
			for(String filePath:filePaths){
				DealFile(filePath);
			}
		}else{
			DealFile(path);
		}
		return esbUploadMsg.toString();
	}
	private void DealFile(String filePath) {
		// TODO Auto-generated method stub
		ReadExcle readExcle = new ReadExcle();
		try {
			list = readExcle.readExcel(filePath);
			int cc = InsertConfigTable(list);
			int tc = InsertTaskTable(list);
			esbUploadMsg.setMsg(cc, 0, tc, filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			esbUploadMsg.setErr(e.getMessage(), filePath);
			e.printStackTrace();
		}
	}
	private int InsertTaskTable(List<Map<String, String>> list) {
		// TODO Auto-generated method stub
		dm_co_ba_cfg_task_mng taskTable = new dm_co_ba_cfg_task_mng();
		map = list.get(1);
		taskTable.setID("HG-" + "rclt-"+map.get("id"));
		Map<String, String> maptimeType = timeTypeTransfer(map.get("timeType"));
		taskTable.setTIMETYPE(maptimeType.get("timetype"));
		taskTable.setTIMEINVOKEPOINT(maptimeType.get("timeinvokepoint"));
		taskTable.setTIMEPOINT(maptimeType.get("timepoint"));
		taskTable.setENABLED((short) 1);
		taskTable.setPRIORITY((short) 0);
		taskTable.setSUBID("collect://" + "rclt-"+map.get("id"));
		taskTable.setSERVER_IP(map.get("serverIp") == null ? "10.221.18.29" : map.get("serverIp"));
		return taskTableDao.insert(taskTable);
	}
	private Map<String, String> timeTypeTransfer(String timeType) {
		// TODO Auto-generated method stub
		pro = FileTools.getProperties("EsbUpload.properties");
		Map<String, String> maptimeType = new HashMap<String, String>();
		maptimeType.put("timetype", pro.getProperty("timetype." + timeType));
		maptimeType.put("timeinvokepoint", pro.getProperty("timeinvokepoint." + timeType));
		maptimeType.put("timepoint", pro.getProperty("timepoint." + timeType));
		maptimeType.put("mtime", pro.getProperty("mtime." + timeType));
		return maptimeType;
	}
	private int InsertConfigTable(List<Map<String, String>> list) {
		// TODO Auto-generated method stub
		dm_co_ba_cfg_clt configTable = new dm_co_ba_cfg_clt();
		map = list.get(1);
		configTable.setID("rclt-"+map.get("id"));
		configTable.setTYPE("0");
		fastCollectConfig.setId("id");
		fastCollectConfig.setUrl(map.get("url"));
	    String schema = map.get("schema") == null ? "ipmsdw." : (map.get("schema") + ".");
		fastCollectConfig.setMaxTimeSql(String.format("select nvl(max(%s),trunc(sysdate-3)) from %s%s", map.get("timeStamp"),schema,map.get("table")));
		String insertSql = "insert into %s%s(%s) values(%s)";
		String column = "";
		String type = "";
		Map<String, String> mapTemp = new HashMap<String, String>();
		for(int i =1;i<list.size();i++){
			mapTemp = list.get(i);
			column+=mapTemp.get("column")+",";
			if (mapTemp.get("type") != null&& (mapTemp.get("type").equals("date") || mapTemp.get("type").equals("DATE"))) {
				type+="to_date(?,'SYYYY-MM-DD HH24:MI:SS'),";
			}else{
				type+="?,";
			}
		}
		column = column.substring(0, column.length() - 1);
		type = type.substring(0, type.length() - 1);
		insertSql = String.format(insertSql, schema,map.get("table"),column,type);
		fastCollectConfig.setInsertSql(insertSql);
		fastCollectConfig.setInsertParam(column);
		fastCollectConfig.setParerClass(map.get("parerClass")==null?"com.eastcom_sw.inas.collect.parser.TxtParser":map.get("parerClass"));
		Map<String, String> extInfo = new HashMap<String, String>();
		extInfo.put("seperator", map.get("seperator") == null ? "|" : map.get("seperator"));
		extInfo.put("timeIndex", map.get("timeIndex") == null ? "0" : map.get("timeIndex"));
		extInfo.put("charset", map.get("charset") == null ? "utf-8" : map.get("charset"));
		extInfo.put("headsName", column);
		extInfo.put("x", map.get("x") == null ? "1" : map.get("x"));
		fastCollectConfig.setExtInfo(extInfo);
		String config = JSON.toJSONString(fastCollectConfig, true);
		logger.info(config);
		configTable.setCONFIG(config);
		return configTableDao.insert(configTable);
	}
	

}
