package com.creatorFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class InsertTest {
//	Logger logger = Logger.getLogger(InsertTest.class);
	public void findSqlErr(JdbcTemplate jdbcTemplate) throws Exception {
		int i;
		String temp;
		String paras;
		File file = new File("F:/HW_Ring_15_201705211630.csv");
		InputStream inputStream = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
		br.readLine();
		for (i = 2; (temp = br.readLine()) != null; i++) {
//			paras = temp;
//			paras = paras.replaceAll(",", "\",\"");
//			paras = "\""+paras;
//			paras+="\"";
			System.out.println(i);
			String[] strs=temp.split(",");
			String[] data = new String[20];
			for(int j=0;j<20;j++){
				try{
				data[j] = strs[j];
			}catch(Exception e){
				data[j]="";
			}
			}
			
			try {
				jdbcTemplate.update(
						"insert into my_test(STAT_TIME,LOOP_LINK_NAME,NETWORK_LEVEL,LOOP_NE_1,LOOP_NE_2,CAPACITY,REGION,LOOP_NETWORK,STRUCTURE_TYPE,NODE_NUMBER_ON_LOOP,DOWN_LOOP_NUM,IS_ACCESS_LTE_SITE,LTE_SITE_ACCESS_POINT_NUM,GUARANTEED_BANDWIDTH,FLOW,MEAN_FLOW_RATE,PEAK_FLOW_RATE,MEAN_UTILIZATION,PEAK_UTILIZATION,MEAN_GUARANTEED_BANDWIDTH_UTIL,PEAK_GUARANTEED_BANDWIDTH_UTIL) values(to_date('20160523 000000','yyyymmdd hh24miss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
						data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7],data[8],data[9],data[10],data[11],data[12],data[13],data[14],data[15],data[16],data[17],data[18],data[19]);
			} catch (Exception e) {
				System.out.println("第 " + i + " 行出现问题");
				e.printStackTrace();
//				System.exit(0);
			}
		}
			
	}

	public static void main(String[] args) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.247.47:1521/ipms");
		dataSource.setUsername("IPMSDM");
		dataSource.setPassword("SHipmsdm!23$");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		InsertTest insertTest = new InsertTest();
		try {
			insertTest.findSqlErr(jdbcTemplate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
