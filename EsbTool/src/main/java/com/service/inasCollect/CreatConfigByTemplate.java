package com.service.inasCollect;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.service.model.FastCollectConfig;

import util.common.DateTools;
import util.excel.ExcelReader;

public class CreatConfigByTemplate {
	
	public List<Map<String,String>> list;
	public ExcelReader excelReader;
	public String path;
	
	public String serverIp = "localhost";
	public String enable = "0";
	public String isInsert = "false";
	
	public void ParseExcel() throws IOException{
		 excelReader = new ExcelReader();
			excelReader.setHeadLine(1);
			excelReader.setStartLine(1);
			list = excelReader.readExcel(path);
	}
	
	public Map<String,String> CreatConfig(){
		HashMap<String, String> configMap = new HashMap<String, String>();
		Map<String, String> firstMap = list.get(0);
		configMap.put("ID",firstMap.get("任务标识"));
		Map<String, String> typeMap = dealPeriod(firstMap.get("调度周期"));
		configMap.put("DEALTIME", DateTools.getDayString(0));
		configMap.put("ISINSERT",isInsert);
		configMap.put("TIMETYPE",typeMap.get("TIMETYPE"));
		configMap.put("TIMEINVOKEPOINT",typeMap.get("TIMEINVOKEPOINT"));
		configMap.put("TIMEPOINT",typeMap.get("TIMEPOINT"));
		configMap.put("ENABLED",enable);
		configMap.put("SUBID","collect://"+firstMap.get("任务标识"));
		configMap.put("SERVER_IP",serverIp);
		configMap.put("TYPE","0");
		configMap.put("CONFIG", ConfigString(firstMap));
		return configMap;
	}
	
	public Map<String,String> dealPeriod(String type){
		Map<String,String> map = new HashMap<String, String>();
		if(type.equals("5分钟")){
			map.put("TIMETYPE", "hour");
			map.put("TIMEINVOKEPOINT", "00,05,10,15,20,25,30,35,40,45,50,55");
			map.put("TIMEPOINT", null);
		}else if(type.equals("15分钟")){
			map.put("TIMETYPE", "hour");
			map.put("TIMEINVOKEPOINT", "00,15,30,45");
			map.put("TIMEPOINT", null);
		}else if(type.equals("30分钟")){
			map.put("TIMETYPE", "hour");
			map.put("TIMEINVOKEPOINT", "00,30");
			map.put("TIMEPOINT", null);
		}else if(type.equals("小时")){
			map.put("TIMETYPE", "hour");
			map.put("TIMEINVOKEPOINT", "00");
			map.put("TIMEPOINT", null);
		}else if(type.equals("天")){
			map.put("TIMETYPE", "day");
			map.put("TIMEINVOKEPOINT", "00");
			map.put("TIMEPOINT", "01");
		}else if(type.equals("周")){
			map.put("TIMETYPE", "week");
			map.put("TIMEINVOKEPOINT", "00");
			map.put("TIMEPOINT", "01_01");
		}else if(type.equals("周")){
			map.put("TIMETYPE", "month");
			map.put("TIMEINVOKEPOINT", "00");
			map.put("TIMEPOINT", "01_01");
		}	
		return map;
	}

	public String ConfigString(Map<String, String> firstMap){
		FastCollectConfig fastCollectConfig = new FastCollectConfig();
		fastCollectConfig.setId(firstMap.get("任务标识"));
		fastCollectConfig.setUrl(String.format("ftp://%s:%s@%s:21%s/%s", firstMap.get("用户名"),firstMap.get("密码"),firstMap.get("主机"),firstMap.get("路径"),firstMap.get("文件名")));
		if(firstMap.get("时间字段")==null){
			fastCollectConfig.setMaxTimeSql("select sysdate-3 from dual");
		}else{
			fastCollectConfig.setMaxTimeSql(String.format("select nvl(max(%s),trunc(sysdate-3)) from %s.%s", firstMap.get("时间字段"),firstMap.get("模式名"),firstMap.get("表名")));
		}
		String columns = "";
		String values = "";
		String paras = "";
		String head = "";
		for(int i = 0;i<list.size();i++){
			Map<String, String> map = list.get(i);
			columns += map.get("入库表字段")+",";
			if(map.get("特殊格式")!=null){
				values+=map.get("特殊格式")+",";
			}else if(map.get("字段类型").toUpperCase().equals("DATE")){
				values+= "to_date(?,'SYYYY-MM-DD HH24:MI:SS'),";
			}else{
				values+="?,";
			}
			paras += map.get("对应关系")+",";
			if(map.get("文件表头")!=null){
			head += map.get("文件表头")+",";
			}
		}
		fastCollectConfig.setInsertSql(String.format("insert into %s.%s (%s) values (%s)",firstMap.get("模式名"),firstMap.get("表名"),columns.substring(0,columns.length()-1),values.substring(0, values.length()-1))); 
		fastCollectConfig.setInsertParam(paras.substring(0, paras.length()-1));
		if(firstMap.get("文件类型").equals("TXT或非标准CSV")){
			fastCollectConfig.setParerClass("com.eastcom_sw.inas.collect.parser.TxtParser");
		}else if(firstMap.get("文件类型").equals("标准CSV")){
			fastCollectConfig.setParerClass("com.eastcom_sw.inas.collect.parser.CsvParser");
		}else if(firstMap.get("文件类型").equals("XML")){
			fastCollectConfig.setParerClass("com.eastcom_sw.inas.collect.parser.XmlParser");
		}
		Map<String, String> extInfo = new HashMap<String, String>(); 
		if(head.length() != 0){
			extInfo.put("headsName", head.substring(0, head.length()-1));
		}
		extInfo.put("seperator",firstMap.get("分隔符")==null?",":firstMap.get("分隔符"));
		extInfo.put("charset",firstMap.get("文件编码")==null?"gbk":firstMap.get("文件编码"));
		extInfo.put("x",firstMap.get("数据起始行")==null?"1":firstMap.get("数据起始行"));
		fastCollectConfig.setExtInfo(extInfo);
		return JSON.toJSONString(fastCollectConfig, true);
	}
	
	public List<Map<String, String>> getList() {
		return list;
	}

	public void setList(List<Map<String, String>> list) {
		this.list = list;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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

}
