package com.creatorSql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class SMSMoniterConfig {
	
	public String EsbCollectTable(String filePath) throws Exception{
		String esbStr = "";
		File file = new File(filePath);
		List<String> lists =new ArrayList<String>();
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis,"gbk"));
		String str;
		while((str = br.readLine()) != null){
			lists.add(str.trim());
		}
		for(String list:lists){
			String[] strs=list.split(";");
			esbStr+="select 'Esb采集' as service_type,'"+strs[0]+"'as tablename,sum(case when "+strs[1]+">sysdate-3 then 1 else 0 end) as cnt,1 tr,max("+strs[1]
					+") as last_timestamp from "+strs[0]+" where "+strs[1]+">sysdate-3";
			esbStr+="\n union all \n";
		}
		return esbStr;
	}
	
	public String FtpCollectTable(String filePath) throws Exception{
		String ftpStr = "";
		File file = new File(filePath);
		List<String> lists =new ArrayList<String>();
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis,"gbk"));
		String str;
		while((str = br.readLine()) != null){
			lists.add(str.trim());
		}
		for(String list:lists){
			String[] strs=list.split(";");
			ftpStr+="select 'Ftp采集' as service_type,'"+strs[0]+"' as tablename,sum(case when "+strs[1]+">sysdate-3 then 1 else 0 end) as cnt,1 tr,max("+strs[1]
					+") as last_timestamp from "+strs[0]+" where "+strs[1]+">sysdate-3";
			ftpStr+="\n union all \n";
		}
		return ftpStr;
	}
	
	@SuppressWarnings({ "deprecation" })
	public static void main(String[] args) throws Exception{
		
		SMSMoniterConfig sMSMoniterConfig = new SMSMoniterConfig();
		
		String esbCollect = sMSMoniterConfig.EsbCollectTable("F:/SMS_Moniter_Config/SMS_Moniter_Config_ESB_Collect.txt");
		
		String ftpCollect = sMSMoniterConfig.FtpCollectTable("F:/SMS_Moniter_Config/SMS_Moniter_Config_FTP_Collect.txt");
		String abc = esbCollect+ftpCollect;
		abc = abc.substring(0,abc.lastIndexOf("3")+1);
		String prep = "select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') as time_stamp,service_type,tablename,cnt,tr,to_char(last_timestamp,'yyyy-mm-dd hh24:mi:ss') last_timestamp from (\n%s\n) where 1=1 and cnt<tr or last_timestamp is null";
		abc = String.format(prep, abc);
		System.out.println(abc);

		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.18.36:1521/IPNET");
		dataSource.setUsername("rm");
		dataSource.setPassword("SHrm!23$");
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		int num = jdbcTemplate.queryForInt("select count(*) from rm_sms_ext_config where CHECKNAME = '文件采集核查@SIZE条'");
        System.out.println(num);
		jdbcTemplate.update("update rm_sms_ext_config set QUERYSQL = ? where CHECKNAME = '文件采集核查@SIZE条'",abc);

	}

}
