package com.dao;

import java.util.Properties;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import util.common.FileTools;

public class temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			DriverManagerDataSource dataSource=new DriverManagerDataSource();
			dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			dataSource.setUrl("jdbc:oracle:thin:@10.221.18.36:1521:ipnet");
			dataSource.setUsername("nhm");
			dataSource.setPassword("SHnhm!23$");
			JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
			temp temp = new temp();
			String str = "2017-09-02 14:00:00";
			String sql = temp.getPrepareSql("temp");
			for(int i = 39;i>=0;i--){
				jdbcTemplate.update(sql,str,i,str,i,str,i,str,i,str,i);
				System.out.println("i--->>>"+i);
			}
		
	}
	
	public String getPrepareSql(String key){
		Properties properties = FileTools.getProperties("PrepareSql.properties");
		return properties.getProperty(key);
	}

}
