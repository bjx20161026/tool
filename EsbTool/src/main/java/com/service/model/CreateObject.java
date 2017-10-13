package com.service.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class CreateObject {
	private String id;
	
	private String url;
	
	private int mtime;
	
	private String maxTimeSql;
	
	private String querySql;
	private String createrClass;
	
	private Map<String,Object> extInfo=new LinkedHashMap<String,Object>();

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

	public String getCreaterClass() {
		return createrClass;
	}

	public void setCreaterClass(String createrClass) {
		this.createrClass = createrClass;
	}

	public Map<String, Object> getExtInfo() {
		return extInfo;
	}

	public void setExtInfo(Map<String, Object> extInfo) {
		this.extInfo = extInfo;
	}

	public int getMtime() {
		return mtime;
	}

	public void setMtime(int mtime) {
		this.mtime = mtime;
	}

	public String getQuerySql() {
		return querySql;
	}

	public void setQuerySql(String querySql) {
		this.querySql = querySql;
	}
}

