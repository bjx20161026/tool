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
	String head = "timestamp,在线用户数,注册用户数,直播次数,点播次数,无故障用户数,偶尔故障用户数,较多故障用户数,严重故障用户数,属地";
	static String split;
	public List<Map<String, String>> ReadLocalFile(String path) throws Exception {
		File file = new File(path);
		InputStream is = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
		br.readLine();
		String[] heads = head.split(",");
		int length = heads.length;
		List<Object[]> list = new ArrayList<Object[]>();
		String[] string;
		String str;
		int j = 0;
		while ((str = br.readLine()) != null) {
			j++;
			string = new String[length];
			try{
				string[0] = path.substring(path.lastIndexOf("_")+1,path.lastIndexOf(".CSV"));; 
			for (int i = 0; i < length - 2; i++) {
//				System.out.println(str);
				String str1 = str.substring(0, str.indexOf(split));
				str = str.substring(str.indexOf(split) + 1, str.length());
				string[i+1] = str1;
			}
			if(str.length()>1024){
				str = str.substring(0,1024);
			}
			string[length-1] = str;
			list.add(string);
			if (j % 2000 == 0) {
				insertInto(list);
				list = new ArrayList<Object[]>();
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

	public int insertInto(List<Object[]> list) {
		// String para = "";
		// for(int i=0;i<column.split(",").length;i++){
		// para += "?,";
		// }
		// para = para.substring(0,para.length()-1);
		String sql = String.format("insert into %s (%s)values(%s)", table, column, para);
		jdbcTemplate.batchUpdate(sql, list);
		return 0;
	}

	public static void main(String[] args) throws Exception {
		File file = new File("F:/common/split.CSV");
		InputStream is = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
		split = br.readLine().trim();
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.247.47:1521/ipms");
		dataSource.setUsername("IPMSDM");
		dataSource.setPassword("SHipmsdm!23$");
		jdbcTemplate = new JdbcTemplate(dataSource);
		ImportData importData = new ImportData();
		List<String> files  =  FileTools.listFiles("F:/common/esb");
		for(String filepath:files){
			System.out.println(filepath);
			importData.ReadLocalFile(filepath);
		}
		System.out.println("OK!");
		
	}

}
