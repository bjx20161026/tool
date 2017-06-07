package com.service.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONType;
@Service
@JSONType(orders={"id","mtime","url","maxTimeSql","querySql","createrClass","extInfo"})
public class EsbUpConfig {
	private String id;
	private int mtime;
	private String url;
	private String maxTimeSql;
	private String querySql;
	private String createrClass;
	private Map<String,String> extInfo;
	

	public void setId(String id) {
		this.id = id;
	}
	public int getMtime() {
		return mtime;
	}
	public void setMtime(int mtime) {
		this.mtime = mtime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMaxTimeSql() {
		return maxTimeSql;
	}
	public void setMaxTimeSql(String maxTimeSql) {
		this.maxTimeSql = maxTimeSql;
	}
	public String getQuerySql() {
		return querySql;
	}
	public void setQuerySql(String querySql) {
		this.querySql = querySql;
	}
	public String getCreaterClass() {
		return createrClass;
	}
	public void setCreaterClass(String createrClass) {
		this.createrClass = createrClass;
	}
	public Map<String, String> getExtInfo() {
		return extInfo;
	}
	public void setExtInfo(Map<String, String> extInfo) {
		this.extInfo = extInfo;
	}
	public String getId() {
		return id;
	}
	
	public static void main(String[] args){
		EsbUpConfig esbUpConfig = new EsbUpConfig();
		esbUpConfig.setId("DATA.RM.DW_FT_RE_ST_PTN_NNI_PORT_H.PAS_APP");
		esbUpConfig.setMtime(60);
		esbUpConfig.setUrl("ftp://PAS_PUT:W1n3m5s#@10.221.246.84:21/PAS_APP/DATA.RM.DW_FT_RE_ST_PTN_NNI_PORT_H.PAS_APP/DW_FT_RE_ST_PTN_NNI_PORT_H_(.*?).csv");
		esbUpConfig.setMaxTimeSql("select max(stat_time) from ipmsdw.DW_FT_RE_ST_PTN_NNI_PORT_H");
		esbUpConfig.setQuerySql("select to_char(STAT_TIME,'yyyy-mm-dd hh24:mi:ss') STAT_TIME,PORT_NAME,VENDOR,PLANE,AREA_1,NE_NAME,NE_LEVEL,PORT_TYPE_1,PORT_BANDWIDTH,GUARANTEED_BANDWIDTH,GUARANTEED_BANDWIDTH_SHARE,PEAK_RECEIVED_FLOW_RATE,PEAK_SENT_FLOW_RATE,FLOW,MEAN_FLOW_RATE,PEAK_FLOW_RATE,MEAN_BANDWIDTH_UTILIZATION,PEAK_BANDWIDTH_UTILIZATION,BANDWIDTH_BUSY_RATIO from ipmsdw.DW_FT_RE_ST_PTN_NNI_PORT_H where stat_time=to_date('@timestamp','yyyymmddhh24miss')");
		esbUpConfig.setCreaterClass("com.eastcom_sw.inas.collect.creater.TxtCreater");
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map = new HashMap<String,String>();
		map.put("seperator", ",");
		map.put("timeIndex","0");
		map.put("charset","utf-8");
		list.add(map);
		esbUpConfig.setExtInfo(map);
		String json = JSON.toJSONString(esbUpConfig,true);
		System.out.println(json);
	}
}
