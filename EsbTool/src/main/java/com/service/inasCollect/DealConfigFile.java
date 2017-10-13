package com.service.inasCollect;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.dao.inasCollect.DmCoBaTaskRecord;

import util.common.FileTools;
import util.excel.ExcelWriterForExitence;


public class DealConfigFile {
	
	Logger logger = Logger.getLogger(getClass());
	
	public List<Map<String,String>> list = new ArrayList<Map<String,String>>();
	public Map<String,String> map;
	
	public String path;
	public String logFilePath = "../record/FTPconfigRecord.xlsx";
	public String serverIp = "localhost";
	public String enable = "0";
	public String isInsert = "false";
	public String dbid = "Ipmsp";
	

	public void Deal() throws IOException{
		File file=new File(path);
		CreatConfigByTemplate creatConfigByTemplate = new CreatConfigByTemplate();
		creatConfigByTemplate.setEnable(enable);
		creatConfigByTemplate.setServerIp(serverIp);
		creatConfigByTemplate.setIsInsert(isInsert);
		if(file.isDirectory()){
			List<String> filePaths = FileTools.listFiles(path);
			for(String filePath:filePaths){
				creatConfigByTemplate.setPath(filePath);
				creatConfigByTemplate.ParseExcel();
				list.add(creatConfigByTemplate.CreatConfig());
			}
		}else{
			creatConfigByTemplate.setPath(path);
			creatConfigByTemplate.ParseExcel();		
			list.add(creatConfigByTemplate.CreatConfig());	
		}
		logger.info(list.get(0).get("CONFIG"));
		ExcelWriterForExitence excelWriterForExitence = new ExcelWriterForExitence();
		String head = "DEALTIME,ISINSERT,ID,TIMETYPE,TIMEINVOKEPOINT,TIMEPOINT,ENABLED,SUBID,SERVER_IP,ID,TYPE,CONFIG";
		excelWriterForExitence.setHeads(head.split(","));
		excelWriterForExitence.setList(list);
		excelWriterForExitence.dealExcel(logFilePath);
		if(isInsert.equals("true")){
			DmCoBaTaskRecord dmCoBaTaskRecord = new DmCoBaTaskRecord(dbid);
			for(Map<String,String> map:list){
				dmCoBaTaskRecord.insertInto(map.get("ID"), map.get("TIMETYPE"), map.get("TIMEINVOKEPOINT"), map.get("TIMEPOINT"), map.get("ENABLED"), map.get("SUBID"), map.get("SERVER_IP"), map.get("CONFIG"), map.get("TYPE"));
			}
		}
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getLogFilePath() {
		return logFilePath;
	}

	public void setLogFilePath(String logFilePath) {
		this.logFilePath = logFilePath;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getIsInsert() {
		return isInsert;
	}

	public void setIsInsert(String isInsert) {
		this.isInsert = isInsert;
	}
	
	public String getDbid() {
		return dbid;
	}

	public void setDbid(String dbid) {
		this.dbid = dbid;
	}
	
	public static void main(String[] args) throws IOException{
		DealConfigFile dealConfigFile = new DealConfigFile();
		dealConfigFile.setPath("F:/BAK/temp/新建 FTP采集模板 - 样例.xlsx");
		dealConfigFile.setLogFilePath("F:/BAK/temp/FTP采集配置记录.xlsx");
//		dealConfigFile.setIsInsert("true");
		dealConfigFile.Deal();
	}
}
