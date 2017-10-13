package com.dao;

import java.util.Properties;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import util.common.FileTools;

public class GetJdbcTemplate {
	public JdbcTemplate getIpmsdm(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.247.47:1521/ipms");
		dataSource.setUsername("IPMSDM");
		dataSource.setPassword("SHipmsdm!23$");
		return new JdbcTemplate(dataSource);
	}
	
	public JdbcTemplate getIpmsp(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@192.168.1.198:1521/ipnet");
		dataSource.setUsername("ipmsp");
		dataSource.setPassword("SHipmsp!23$");
		return new JdbcTemplate(dataSource);
	}
	
	public JdbcTemplate getWlanIpnet(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.18.39:1521:ipnet");
		dataSource.setUsername("ipnet");
		dataSource.setPassword("SHipnet!23$");
		return new JdbcTemplate(dataSource);
	}
	
	public String getPrepareSql(String key){
		Properties properties = FileTools.getProperties("PrepareSql.properties");
		return properties.getProperty(key);
	}
}
