package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class DmCoBaTaskRecord {
	JdbcTemplate jdbcTemplate;
	String getCountDaysql;
	
	public List<Map<String,Object>> GetCountDay(){
		GetJdbcTemplate getJdbcTemplate = new GetJdbcTemplate();
		jdbcTemplate = getJdbcTemplate.getIpmsdm();
		getCountDaysql = getJdbcTemplate.getPrepareSql("DmCoBaTaskRecord.getCountDaysql");
		return jdbcTemplate.queryForList(getCountDaysql);
	}
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
