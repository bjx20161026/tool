package com.dao;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class MetaDtTaskRecord {
	JdbcTemplate jdbcTemplate;
	String getDatFileNamesql;
	public Map<String,Object> GetDateFileName(String protocol){
		GetJdbcTemplate getJdbcTemplate = new GetJdbcTemplate();
		jdbcTemplate = getJdbcTemplate.getIpmsdm();
		getDatFileNamesql = getJdbcTemplate.getPrepareSql("MetaDtTaskRecord.getDatFileNamesql");
		return jdbcTemplate.queryForMap(getDatFileNamesql,"%"+protocol+"%");
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public String getGetDatFileNamesql() {
		return getDatFileNamesql;
	}
	public void setGetDatFileNamesql(String getDatFileNamesql) {
		this.getDatFileNamesql = getDatFileNamesql;
	}
	
	public static void main(String[] args){
		MetaDtTaskRecord metaDtTaskRecord = new MetaDtTaskRecord();

	}


}
