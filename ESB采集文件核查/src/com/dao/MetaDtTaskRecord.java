package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class MetaDtTaskRecord {
	JdbcTemplate jdbcTemplate;
	String getDatFileNamesql;
	String getCountDaysql;
	
	public List<Map<String,Object>> GetCountDay(){
		GetJdbcTemplate getJdbcTemplate = new GetJdbcTemplate();
		jdbcTemplate = getJdbcTemplate.getIpmsdm();
		getCountDaysql = getJdbcTemplate.getPrepareSql("MetaDtTaskRecord.getCountDaysql");
		return jdbcTemplate.queryForList(getCountDaysql);
	}
	
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
}
