package com.dao.inasCollect;
/*性能采集共享记录表
 * 
 */

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.dao.GetJdbcTemplate;

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
