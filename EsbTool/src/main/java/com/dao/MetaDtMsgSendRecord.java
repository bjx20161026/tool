package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class MetaDtMsgSendRecord {
	JdbcTemplate jdbcTemplate;
	public String gerRecordsql;
	public List<Map<String,Object>> getRecord(String protocol,String day){
		GetJdbcTemplate getJdbcTemplate = new GetJdbcTemplate();
		jdbcTemplate = getJdbcTemplate.getIpmsdm();
		gerRecordsql = getJdbcTemplate.getPrepareSql("MetaDtMsgSendRecordsql.gerRecordsql");
		return jdbcTemplate.queryForList(gerRecordsql,"%"+protocol+"%",day);
	}
	
	public static void main(String[] args){
		MetaDtMsgSendRecord metaDtMsgSendRecord = new MetaDtMsgSendRecord();
		List<Map<String,Object>> list = metaDtMsgSendRecord.getRecord("DW_", "0.1");
		for(Map map:list){
			System.out.println(map.get("SEND_TIME_STAMP"));
		}
	}
}
