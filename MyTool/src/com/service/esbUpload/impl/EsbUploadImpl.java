package com.service.esbUpload.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.mapping.META_PI_CFG_ESB_SHARE;
import com.dao.mapping.dm_co_ba_cfg_clt;
import com.dao.mapping.dm_co_ba_cfg_task_mng;
import com.dao.mapping.ipmsdm.dm_co_ba_cfg_cltMapper;
import com.dao.mapping.ipmsdm.dm_co_ba_cfg_task_mngMapper;
import com.dao.mapping.ipmsds.META_PI_CFG_ESB_SHAREMapper;
import com.service.esbUpload.EsbUpload;
import com.service.model.EsbUpConfig;
import com.service.model.EsbUploadMsg;
import com.service.util.common.FileTools;
import com.service.util.excle.ReadExcle;
import com.service.util.ftp.FileOperate;

@Service
public class EsbUploadImpl implements EsbUpload {
	Logger logger = Logger.getLogger(EsbUploadImpl.class);
	List<Map<String, String>> list;
	Map<String, String> map;
	Properties pro;
	String temp;
	String maxSql;
	boolean flag = true;
	@Autowired
	dm_co_ba_cfg_task_mngMapper taskTableDao;
	@Autowired
	META_PI_CFG_ESB_SHAREMapper shareTableDao;
	@Autowired
	dm_co_ba_cfg_cltMapper configTableDao;
	@Autowired
	EsbUpConfig esbUpConfig;
	@Autowired
	EsbUploadMsg esbUploadMsg;

	@Override
	public String CreatUploadConfig(String path) throws Exception {
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
	
	public void DealFile(String filePath){
		try {
			ReadExcle readExcle = new ReadExcle();
			list = readExcle.readExcel(filePath);
			int cc = InsertConfigTable(list);
			int sc = 1;
			if(flag==true){
				sc =	InsertShareTable(list);
			}
			int tc = InsertTaskTable(list);
			esbUploadMsg.setMsg(cc, sc, tc, filePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			esbUploadMsg.setErr(e.getMessage(), filePath);
			e.printStackTrace();
		}	
	}
	

	public int InsertConfigTable(List<Map<String, String>> list) throws Exception {
		dm_co_ba_cfg_clt configTable = new dm_co_ba_cfg_clt();
		map = list.get(1);
		configTable.setID("esb-" + map.get("id"));
		esbUpConfig.setId(map.get("id"));
		Map<String, String> maptimeType = timeTypeTransfer(map.get("timeType"));
		esbUpConfig.setMtime(Integer.parseInt(maptimeType.get("mtime")));
		temp = "ftp://PAS_PUT:W1n3m5s#@10.221.246.84:21/PAS_APP/";
		String ftpUrl = map.get("ftpUrl") == null ? temp : map.get("ftpUrl");
		if(flag == true){
		temp = map.get("id").substring(8, map.get("id").indexOf(".", 10));
		}else{
		temp = map.get("id");
		}
		String fileName = map.get("fileName") == null ? (temp + "_(.*?).csv") : map.get("fileName");
		fileName = map.get("gz") == null ? fileName : (fileName + ".gz");
		if(flag == true){
			esbUpConfig.setUrl(ftpUrl + map.get("id") + "/" + fileName);
		}else{
		esbUpConfig.setUrl(ftpUrl + fileName);
		}
		if(flag==true){
		FileOperate fo = new FileOperate(esbUpConfig.getUrl());
		fo.MakeRemoteDir();
			}
		String schema = map.get("schema") == null ? "ipmsdw." : (map.get("schema") + ".");
		String table = map.get("table") == null ? temp : map.get("table");
		if (map.get("timeStamp") == null)
			maxSql = "select trunc(sysdate-1) from dual";
		else
			maxSql = "select max(" + map.get("timeStamp") + ") " + "from " + schema + table;
		esbUpConfig.setMaxTimeSql(maxSql);
		String querySql = "", headsName = "", properiesName = "";
		Map<String, String> mapTemp = new HashMap<String, String>();
		for (int i = 1; i < list.size(); i++) {
			mapTemp = list.get(i);
			if (mapTemp.get("type") != null
					&& (mapTemp.get("type").equals("date") || mapTemp.get("type").equals("DATE"))) {
				querySql += "to_char(" + mapTemp.get("column") + ",'yyyy-mm-dd hh24:mi:ss') as " + mapTemp.get("column")
						+ ",";
			} else {
				querySql += mapTemp.get("column") + ",";
			}
			properiesName += mapTemp.get("column") + ",";
			headsName += (mapTemp.get("heads") == null ? mapTemp.get("column") : mapTemp.get("heads")) + ",";
		}
		querySql = "select " + querySql.substring(0, querySql.length() - 1) + " from " + schema + table;
		properiesName = properiesName.substring(0, properiesName.length() - 1);
		headsName = headsName.substring(0, headsName.length() - 1);
		if (map.get("timeStamp") != null)
			querySql += " where " + map.get("timeStamp") + " = to_date('@timestamp','yyyymmddhh24miss')";
		esbUpConfig.setQuerySql(querySql);
		String defCreaterClass = "com.eastcom_sw.inas.collect.creater.TxtCreater";
		esbUpConfig.setCreaterClass(map.get("createrClass") == null ? defCreaterClass : map.get("createrClass"));
		esbUpConfig.setExtInfo(extInfoCreater(map, properiesName, headsName));
		String config = JSON.toJSONString(esbUpConfig, true);
		logger.info(config);
		configTable.setCONFIG(config);
		configTable.setTYPE("1");
		return configTableDao.insert(configTable);
	}

	public int InsertShareTable(List<Map<String, String>> list) {
		META_PI_CFG_ESB_SHARE shareTable = new META_PI_CFG_ESB_SHARE();
		map = list.get(1);
		shareTable.setSERVICE_CODE(map.get("id"));
		Map<String, String> maptimeType = timeTypeTransfer(map.get("timeType"));
		shareTable.setTIME_TYPE(Integer.parseInt(maptimeType.get("mtime")));
		shareTable.setTIME_FILES(1);
		shareTable.setTABLE_NAME(map.get("id").substring(8, map.get("id").indexOf(".", 10)));
		shareTable.setIS_COMPLETE((short) 1);
		shareTable.setIS_SHARED((short) 1);
		shareTable.setFTP_IP(map.get("ftpIp") == null ? "10.221.246.84" : map.get("ftpIp"));
		shareTable.setFILE_PATTERN(map.get("id").substring(8, map.get("id").indexOf(".", 10)) + "_");
		shareTable.setSERVICE_NAME(map.get("name") == null ? "" : map.get("name"));
		shareTable.setIS_MONITOR((short) 1);
		return shareTableDao.insert(shareTable);
	}

	public int InsertTaskTable(List<Map<String, String>> list) {
		dm_co_ba_cfg_task_mng taskTable = new dm_co_ba_cfg_task_mng();
		map = list.get(1);
		taskTable.setID("esb-" + (map.get("name") == null ? "" : map.get("name")));
		Map<String, String> maptimeType = timeTypeTransfer(map.get("timeType"));
		taskTable.setTIMETYPE(maptimeType.get("timetype"));
		taskTable.setTIMEINVOKEPOINT(maptimeType.get("timeinvokepoint"));
		taskTable.setTIMEPOINT(maptimeType.get("timepoint"));
		taskTable.setENABLED((short) 1);
		taskTable.setPRIORITY((short) 0);
		taskTable.setSUBID("esb://esb-" + map.get("id"));
		taskTable.setSERVER_IP(map.get("serverIp") == null ? "10.221.18.29" : map.get("serverIp"));
		return taskTableDao.insert(taskTable);
	}
/*
 * 设置extInfoCreater中的参数
 */
	public Map<String, String> extInfoCreater(Map<String, String> map, String properiesName, String headsName) {
		Map<String, String> extInfo = new HashMap<String, String>();
		extInfo.put("timeformat", map.get("timeformat") == null ? "yyyyMMddHHmmss" : map.get("timeformat"));
		extInfo.put("timeIndex", map.get("timeIndex") == null ? "0" : map.get("timeIndex"));
		extInfo.put("charset", map.get("charset") == null ? "utf-8" : map.get("charset"));
		extInfo.put("seperator", map.get("seperator") == null ? "|" : map.get("seperator"));
		extInfo.put("endSeparater", map.get("endSeparater") == null ? "\n" : map.get("endSeparater"));
		pro = FileTools.getProperties("EsbUpload.properties");
		String extStr = pro.getProperty("extInfo");
		String[] extStrs = extStr.split(",");
		for (String ext : extStrs) {
			if (map.get(ext) != null)
				extInfo.put(ext, map.get(ext));
		}
		extInfo.put("properiesName", properiesName);
		extInfo.put("headsName", headsName);
		return extInfo;
	}
/*
 * 转换时间成对应参数
 */
	public Map<String, String> timeTypeTransfer(String timeType) {
		pro = FileTools.getProperties("EsbUpload.properties");
		Map<String, String> maptimeType = new HashMap<String, String>();
		maptimeType.put("timetype", pro.getProperty("timetype." + timeType));
		maptimeType.put("timeinvokepoint", pro.getProperty("timeinvokepoint." + timeType));
		maptimeType.put("timepoint", pro.getProperty("timepoint." + timeType));
		maptimeType.put("mtime", pro.getProperty("mtime." + timeType));
		return maptimeType;
	}

	public String[] toStrings(String str) {
		System.out.println(str);
		String[] strs = str.split(",");
		strs[0] = strs[0].substring(1).trim();
		int length = strs.length;
		for (int i = 1; i < length - 1; i++) {
			strs[i] = strs[i].trim();
		}
		strs[length - 1] = strs[length - 1].substring(0, strs[length - 1].length() - 1).trim();
		return strs;
	}

	public static void main(String[] args) {
		System.out.println("\\n");

	}
}
