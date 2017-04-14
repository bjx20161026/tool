package com.creatorFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.readExcle.ReadExcle;

import common.Common;
import util.FileTools;
import util.Util;

public class CreatEsbUpload {
	public void EsbUploadFile(List<HashMap<String, String>> list,String fileName) {
		try {
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			String id="";
			String mtime="";
			String table="";
			String timestamp="";
//			String filnaem="";
			String querySql="";
			String headsName="";
			String properiesName="";
			String sheetA,sheetB,sheetC,sheetD;
			for (int i = 0; i < list.size(); i++) {
				Map<String, String> map = list.get(i);
				sheetA=map.get("0");
				sheetB=map.get("1");
				sheetC=map.get("2");
				sheetD=map.get("3");
//				sheetE=map.get("4");
				if(i==0){
					id=sheetA;
					table=sheetB;
					mtime=sheetC;
					timestamp=sheetD;
//					filnaem=sheetE;
				}else{
					headsName+=sheetA+",";
					properiesName+=sheetB+",";
					querySql+=sheetC+",";
				}
			}
			headsName=headsName.substring(0,headsName.length()-1);
			properiesName=properiesName.substring(0,properiesName.length()-1);
			querySql=querySql.substring(0,querySql.length()-1);
			bw.write("{\n");
			bw.write("  \"id\":\""+id+"\",\n");
			bw.write("  \"mtime\":"+mtime+",\n");
			bw.write("  \"url\":\"ftp://PAS_PUT:W1n3m5s#@10.221.246.84:21/PAS_APP/"+id+"/"+table+"_(.*?).csv\",\n");
//			bw.write("  \"maxTimeSql\":\"select max("+timestamp+") from ipmsdw."+table+"\",\n");
			bw.write("  \"maxTimeSql\":\"select trunc(sysdate -1) from dual\",\n");
//			bw.write("  \"querySql\":\" select "+querySql+" from ipmsdw."+table+" where "+timestamp+"=to_date('@timestamp','yyyymmddhh24miss')\",\n");
			bw.write("  \"querySql\":\" select "+querySql+" from ipmsdw."+table+"\",\n");

			bw.write("  \"createrClass\":\"com.eastcom_sw.inas.collect.creater.TxtCreater\",\n");
			bw.write("  \"extInfo\":{\n");
			bw.write("        \"seperator\":\"@!\",\n");
			bw.write("        \"endSeparater\":\"\\n\",\n");
			bw.write("        \"timeIndex\":\"0\",\n");
			bw.write("        \"charset\":\"utf-8\",\n");
			bw.write("        \"timeformat\":\"yyyyMMddHHmmss\",\n");
			bw.write("        \"headsName\":\""+headsName+"\",\n");
			bw.write("        \"properiesName\":\""+properiesName+"\"\n");
			bw.write("      }\n");
			bw.write("}\n");
			bw.flush();
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		CreatEsbUpload creatEsbUpload=new CreatEsbUpload();
//		creatEsbUpload.EsbUploadFile("D:/test.json");
		List<String> strs=FileTools.listFiles("C:/Users/BJX/Desktop/亚信/文件处理");
		for(String path:strs){
			if(Common.OFFICE_EXCEL_2010_POSTFIX.equals(Util.getPostfix(path))){
				System.out.println("path: "+path);
				String fileName=path.replace("xlsx", "json");
				 ReadExcle readExcle=new ReadExcle();
				 List<HashMap<String, String>> list =readExcle.readExcel(path);
				 creatEsbUpload.EsbUploadFile(list, fileName);
			}
		}
		 System.out.println("处理完成");
	}
	
	
	
}
