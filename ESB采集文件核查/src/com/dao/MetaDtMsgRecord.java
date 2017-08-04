package com.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class MetaDtMsgRecord {
	JdbcTemplate jdbcTemplate;
	String getMsgsql;
/**
 * select esbmsg by protocol or file name
 */
	public String GetMsg(String protocol){
		GetJdbcTemplate getJdbcTemplate = new GetJdbcTemplate();
		jdbcTemplate = getJdbcTemplate.getIpmsdm();
		getMsgsql = getJdbcTemplate.getPrepareSql("MetaDtMsgRecord.getMsgsql");
		return jdbcTemplate.queryForObject(getMsgsql,String.class,"%"+protocol+"%","%"+protocol+"%");
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public String getGetMsgsql() {
		return getMsgsql;
	}
	public void setGetMsgsql(String getMsgsql) {
		this.getMsgsql = getMsgsql;
	}
	
	public static void main(String[] args){
		MetaDtMsgRecord dealMetaDtMsgRecord = new MetaDtMsgRecord();
		String msg = dealMetaDtMsgRecord.GetMsg("DATA.PM.CMNETWANGLUOZHILIANG.NETVISTA_APP");
		System.out.println("msg--->>>"+msg);
	}
}
