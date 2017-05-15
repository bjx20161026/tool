package com.service.esbUpload.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mapping.dm_co_ba_cfg_task_mng;
import com.dao.mapping.ipmsdm.dm_co_ba_cfg_task_mngMapper;
import com.service.esbUpload.EsbUpload;
import com.service.util.common.FileTools;
import com.service.util.excle.ReadExcle;

@Service
public class EsbUploadImpl implements EsbUpload {
	List<Map<String, String>> list;
	Map<String, String> map;
	Properties pro;
	@Autowired
	dm_co_ba_cfg_task_mngMapper taskTableDao;
	@Override
	public String CreatUploadConfig(String path) throws IOException {
		// TODO Auto-generated method stub
		ReadExcle readExcle = new ReadExcle();
		list = readExcle.readExcel(path);
		@SuppressWarnings("unused")
		String[] heads = toStrings(list.get(0).get("heads"));
		InsertTaskTable(list);
		return null;
	}
	
	public int InsertTaskTable(List<Map<String,String>> list){
		dm_co_ba_cfg_task_mng taskTable = new dm_co_ba_cfg_task_mng();
		map = list.get(1);
		taskTable.setID("esb-"+map.get("name")==null?"":map.get("name"));
		Map<String, String> maptimeType = timeTypeTransfer(map.get("timeType"));
		taskTable.setTIMETYPE(maptimeType.get("timetype"));
		taskTable.setTIMEINVOKEPOINT(maptimeType.get("timeinvokepoint"));
		taskTable.setTIMEPOINT("timepoint");
		taskTable.setENABLED((short)0);
		taskTable.setPRIORITY((short)0);
		taskTable.setSUBID("esb://esb-"+map.get("id"));
		taskTable.setSERVER_IP(map.get("serverIp")==null?"10.221.18.29":map.get("serverIp"));
		return taskTableDao.insert(taskTable);	
	}
	
	public Map<String,String> timeTypeTransfer(String timeType){
		pro = FileTools.getProperties("propertiesTest.properties");
		Map<String, String> maptimeType = new HashMap<String,String>();
		maptimeType.put("timetype", pro.getProperty("timetype."+timeType));
		maptimeType.put("timeinvokepoint", pro.getProperty("timeinvokepoint."+timeType));
		maptimeType.put("timepoint", pro.getProperty("timepoint."+timeType));
		maptimeType.put("mtime", pro.getProperty("mtime."+timeType));
		return map;
	}

	public String[] toStrings(String str) {
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
		EsbUpload esbUpload = new EsbUploadImpl();
		try {
			esbUpload.CreatUploadConfig("F:/EsbUploadModel.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
