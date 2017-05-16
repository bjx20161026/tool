package com.service.util.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class FileTools {
	/*
	 * List all filenames under the path and subfolders
	 */
	public static List<String> listFiles(String dir){
		List<String> result=new ArrayList<String>();
		File file=new File(dir);
		File[] fts=file.listFiles();
		for(File ft:fts){
			if(ft.isDirectory()){
				result.addAll(listFiles(ft.getAbsolutePath()));
			}else{
				result.add(ft.getAbsolutePath());
			}
		}
		return result;
	}
	
	public static Properties getProperties(String path){
		Properties pro = new Properties();
//		FileInputStream in;
		FileTools fileTools = new FileTools();
		InputStream in=fileTools.getClass().getClassLoader().getResourceAsStream(path);
		try {
//			in = new FileInputStream("./config/"+path);
			pro.load(in);
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pro;
	} 
}
