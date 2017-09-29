package com.service.model;

import java.util.Map;
import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders={"id","url","maxTimeSql","insertSql","insertParam","parerClass","extInfo"})
public class FastCollectConfig {
	private String id;
	private String url;
	private String maxTimeSql;
	private String insertSql;
	private String insertParam;
	private String parerClass;
	private Map<String,String> extInfo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getInsertSql() {
		return insertSql;
	}
	public void setInsertSql(String insertSql) {
		this.insertSql = insertSql;
	}
	public String getInsertParam() {
		return insertParam;
	}
	public void setInsertParam(String insertParam) {
		this.insertParam = insertParam;
	}
	public String getParerClass() {
		return parerClass;
	}
	public void setParerClass(String parerClass) {
		this.parerClass = parerClass;
	}
	public Map<String, String> getExtInfo() {
		return extInfo;
	}
	public void setExtInfo(Map<String, String> extInfo) {
		this.extInfo = extInfo;
	}

}
