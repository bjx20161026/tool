package com.creatorSql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ImportShare {
//	10.221.246.85
//	10.221.246.87
//	10.221.246.86


	public static void main(String[] args) throws Exception{
		
		File file = new File("F:/export.conf");
		List<String> lists =new ArrayList<String>();
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis,"gbk"));
		String str;
		while((str = br.readLine()) != null){
			lists.add(str);
		}
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		for(String ss:lists){
			String[] strs = ss.split("\\|");
//			for(String stra:strs)
			if(strs.length==8){
				String ip = strs[6].trim();
				if(ip.equals("10.221.246.85")||ip.equals("10.221.246.87")||ip.equals("10.221.246.86")){
					Map<String,String> map = new HashMap<String,String>();
					map.put("ip", ip);
					map.put("table", strs[1].trim());
					map.put("time", strs[2].trim());
					map.put("protocol", strs[7].trim());
					list.add(map);
				}
			}	
		}
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.247.47:1521/ipms");
		dataSource.setUsername("IPMSDM");
		dataSource.setPassword("SHipmsdm!23$");
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		for(int i= 0;i<list.size();i++){
			Map<String,String> map = list.get(i);
			System.out.println(map.get("table")+";"+map.get("time")+";"+map.get("ip")+";"+map.get("protocol"));
			int num = jdbcTemplate.queryForInt("select count(*) from ipmsds.META_PI_CFG_ESB_SHARE where SERVICE_CODE like '%"+map.get("protocol")+"%'");
            System.out.println(num);
            if(num==0){
				jdbcTemplate.update("insert into ipmsds.META_PI_CFG_ESB_SHARE (SERVICE_CODE,TIME_TYPE,TIME_FILES,TABLE_NAME,IS_COMPLETE,IS_SHARED,FTP_IP,IS_MONITOR)VALUES(?,decode(?,'hour','60','day','1440','month','43200'),'1',?,'1','1',?,'1')",map.get("protocol"),map.get("time"),map.get("table"),map.get("ip"));
            }
		}
	}
}
