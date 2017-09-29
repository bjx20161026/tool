package com.dao.inasCollect;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.dao.GetJdbcTemplate;

/*
 * 性能采集共享策略表
 */

public class DmCoBaCfgClt {
	JdbcTemplate jdbcTemplate;
	GetJdbcTemplate getJdbcTemplate;
	public DmCoBaCfgClt(){
		getJdbcTemplate = new GetJdbcTemplate();
		jdbcTemplate = getJdbcTemplate.getIpmsdm();
	}
	public List<Map<String,Object>> getPolicy(){
		String sql = getJdbcTemplate.getPrepareSql("InasCollectPolicy");
		return jdbcTemplate.queryForList(sql);
	}
}
