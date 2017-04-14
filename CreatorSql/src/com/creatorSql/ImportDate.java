package com.creatorSql;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.readExcle.ReadExcle;

import util.FileTools;

public class ImportDate {
	static JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public String InsertSql(List<HashMap<String, String>> list){
		for (int i = 0; i < list.size(); i++) {
			Map<String, String> map = list.get(i);
			jdbcTemplate.update("insert into IPMSDW.DW_FT_SE_AR_HBB_COMP_ORDER_T(STARTTIME,pre_order_ids,kf_order_id,order_title,user_level,complaint_reason_classify_1,complaint_reason_classify_2,complaint_reason_classify_3,ext_state,complaint_handle_duration,accept_date,pre_deal_info,complaint_create_date,user_addr,first_response_date,grid_finish_date) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",map.get("A"),map.get("0"),map.get("1"),map.get("2"),map.get("3"),map.get("4"),map.get("5"),map.get("6"),map.get("7"),map.get("8"),map.get("9"),map.get("10"),map.get("11"),map.get("12"),map.get("13"),map.get("14"));
		}
		return null;
	}
	public static void main(String[] args){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.247.47:1521/ipms");
		dataSource.setUsername("IPMSDM");
		dataSource.setPassword("SHipmsdm!23$");
	    jdbcTemplate=new JdbcTemplate(dataSource);
	    
	    ImportDate importDate = new ImportDate();
		List<String> strs = FileTools.listFiles("F:/jiakuan");
		for (String path : strs) {
			System.out.println("path: " + path);
		 List<HashMap<String, String>> list = null;
		 ReadExcle readExcle=new ReadExcle();
		 try {
			list=readExcle.readExcel(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 importDate.InsertSql(list);
		 }
		
		 System.out.println("finished");
	}
}
