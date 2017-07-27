package com.creatorSql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import util.FileTools;

public class ImportData {
	static JdbcTemplate jdbcTemplate;
	String column = "STAT_TIME,ONLINE_USER_NUM,REG_USER_NUM,LIVE_NUM,REQUEST_NUM,NO_FAULT_USER_NUM,OCCASIONAL_FAULT_USER_NUM,MORE_FAULT_USER_NUM,SERIOUS_FAULT_USER_NUM,AREA_NAME";
	String table = "IPMSDW.O_SE_ST_DATA_TEST_FSD_YHQK_H";
	String para = "to_date(?,'yyyyMMddhh24miss'),?,?,?,?,?,?,?,?,?";
	String head = "PROBE,WEBSITE,RELATIVE_START_DELAY,START_TIME,BLOCKING_DELAY,DNS_ANALYTIC_DELAY,CONNECTION_DELAY,TRANSMISSION_DELAY,WAITING_DELAY,RECEIVING_DELAY,READ_CACHE_DELAY,\"SIZE\",DURATION,SPEED_RATE,RESULT,TYPE,IP,IP_POSITION,URL";
	static String split = "\\|\\|";
	public List<Map<String, String>> ReadLocalFile(String path) throws Exception {
		File file = new File(path);
		InputStream is = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"gbk"));
		br.readLine();
		String[] heads = head.split(",");
		int length = heads.length;
		List<String[]> list = new ArrayList<String[]>();
		String[] string;
		String str;
		int j = 0;
		while ((str = br.readLine()) != null) {
			j++;
			string = new String[length];
			try{
			for (int i = 0; i < length - 1; i++) {
//				System.out.println(str);
				String str1 = str.substring(0, str.indexOf("||"));
				str = str.substring(str.indexOf("||") + 2, str.length());
				string[i] = str1;
			}
			if(str.length()>1024){
				str = str.substring(0,1024);
			}
			string[length-1] = str;
			System.out.println(length-1);
			list.add(string);
			if (j % 20000 == 0) {
				insertInto(list);
				list =new ArrayList<String[]>();
			}
			}catch(Exception e){
				System.out.println(str);
				System.out.println("j---->>>>>>"+j);
				e.printStackTrace();
			}
		}
		insertInto(list);
		return null;
	}

	public int insertInto(List<String[]> list) {
		// String para = "";
		// for(int i=0;i<column.split(",").length;i++){
		// para += "?,";
		// }
		// para = para.substring(0,para.length()-1);
		String sql = String.format("insert into %s (%s)values(%s)", table, column, para);
//		jdbcTemplate.batchUpdate(sql, list);
		String[] atrc = null;
		try{
		for(String[] strs:list){
	    System.out.println(strs[18]);
		atrc = strs;
		jdbcTemplate.update("insert into IPMSDW.O_SE_ST_DATA_TEST_PT_FOC_WEB_H(PROBE,WEBSITE,RELATIVE_START_DELAY,START_TIME,BLOCKING_DELAY,DNS_ANALYTIC_DELAY,CONNECTION_DELAY,TRANSMISSION_DELAY,WAITING_DELAY,RECEIVING_DELAY,READ_CACHE_DELAY,\"SIZE\",DURATION,SPEED_RATE,RESULT,TYPE,IP,IP_POSITION,URL) values(?,?,?,to_date(substr(?,0,19),'yyyy-mm-dd hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",strs[0],strs[1],strs[2],strs[3],strs[4],strs[5],strs[6],strs[7],strs[8],strs[9],strs[10],strs[11],strs[12],strs[13],strs[14],strs[15],strs[16],strs[17],strs[18] );
		}
		}catch(Exception e){
			for(int i=0;i<atrc.length;i++)
			System.out.println(i+"--->>"+atrc[i]);
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) throws Exception {
//		File file = new File("F:/common/split.CSV");
//		InputStream is = new FileInputStream(file);
//		BufferedReader br = new BufferedReader(new InputStreamReader(is,"gbk"));
//		split = br.readLine().trim();
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.247.47:1521/ipms");
		dataSource.setUsername("IPMSDM");
		dataSource.setPassword("SHipmsdm!23$");
		jdbcTemplate = new JdbcTemplate(dataSource);
		ImportData importData = new ImportData();
//		List<String> files  =  FileTools.listFiles("F:/common/esb");
//		for(String filepath:files){
//			System.out.println(filepath);
//			importData.ReadLocalFile(filepath);
//		}
		importData.ReadLocalFile("F:/common/abc.dat");
		System.out.println("OK!");
		
	}

	

}
