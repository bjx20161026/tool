package com.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class MetaDtTaskRecord {
	JdbcTemplate jdbcTemplate;
	String getDatFileNamesql;
	public String GetDateFileName(String protocol){
		GetJdbcTemplate getJdbcTemplate = new GetJdbcTemplate();
		jdbcTemplate = getJdbcTemplate.getIpmsdm();
		getDatFileNamesql = getJdbcTemplate.getPrepareSql("MetaDtTaskRecord.getDatFileNamesql");
		return jdbcTemplate.queryForObject(getDatFileNamesql, String.class,"%"+protocol+"%");
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
		String str = metaDtTaskRecord.GetDateFileName("DATA.PM.NEIRONGYUANBOCEHTTP.NETVISTA_APP");
		System.out.println("DatFileName--->>>"+str);
	}


}
