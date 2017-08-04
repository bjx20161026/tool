package com.dao;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class MetaPiFileSource {
	JdbcTemplate jdbcTemplate;
	String getTablesql;
	public Map<String,Object> GetTable(String protocol){
		GetJdbcTemplate getJdbcTemplate = new GetJdbcTemplate();
		jdbcTemplate = getJdbcTemplate.getIpmsdm();
		getTablesql = getJdbcTemplate.getPrepareSql("MetaPiFileSource.getTablesql");
		return jdbcTemplate.queryForMap(getTablesql,"%"+protocol+"%"); 
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public String getGetTablesql() {
		return getTablesql;
	}
	public void setGetTablesql(String getTablesql) {
		this.getTablesql = getTablesql;
	}
	public static void main(String[] args){
		MetaPiFileSource metaPiFileSource = new MetaPiFileSource();
		Map<String,Object> map = metaPiFileSource.GetTable("DATA.PM.NHM_CPU_MEM_KPI.GCP_APP");
		System.out.println("tableName--->>>"+map.get("TABLE_NAME"));
	}
}
