package com.dao.thirtynine;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.dao.GetJdbcTemplate;

public class DmCoBaCfgClt {
	JdbcTemplate jdbcTemplate;
	public List<Map<String,Object>> GetAll(){
		GetJdbcTemplate getJdbcTemplate = new GetJdbcTemplate();
		jdbcTemplate = getJdbcTemplate.getWlanIpnet();
		String sql = getJdbcTemplate.getPrepareSql("WlanIpnetTask");
		return jdbcTemplate.queryForList(sql);
	}

	public int InsertNew(List<Map<String,String>> list){
		GetJdbcTemplate getJdbcTemplate = new GetJdbcTemplate();
		jdbcTemplate = getJdbcTemplate.getWlanIpnet();
		String sql = getJdbcTemplate.getPrepareSql("WlanIpnetTaskInsert");
		int i = 0;
		for(Map map:list){
			i+=jdbcTemplate.update(sql,map.get("ID"),map.get("CONFIG"),map.get("TYPE"));
		}
		return i;
	}
	
	public List<Map<String,Object>> GetAllIpnet(){
		GetJdbcTemplate getJdbcTemplate = new GetJdbcTemplate();
		jdbcTemplate = getJdbcTemplate.getWlanIpnet();
		String sql = getJdbcTemplate.getPrepareSql("WlanIpnetNew");
		return jdbcTemplate.queryForList(sql);
	}
}
