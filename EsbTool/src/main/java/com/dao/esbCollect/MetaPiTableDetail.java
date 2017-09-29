package com.dao.esbCollect;
/*
 *esb采集表字段关系表 
 */

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.dao.GetJdbcTemplate;

public class MetaPiTableDetail {
	JdbcTemplate jdbcTemplate;
	String getDetialsql;
	public List<Map<String,Object>> getDetail(String tableName){
		GetJdbcTemplate getJdbcTemplate = new GetJdbcTemplate();
		jdbcTemplate = getJdbcTemplate.getIpmsdm();
		getDetialsql = getJdbcTemplate.getPrepareSql("MetaPiTableDetail.getDetialsql");
		return jdbcTemplate.queryForList(getDetialsql, "%"+tableName+"%");
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public String getGetDetialsql() {
		return getDetialsql;
	}
	public void setGetDetialsql(String getDetialsql) {
		this.getDetialsql = getDetialsql;
	}
}
