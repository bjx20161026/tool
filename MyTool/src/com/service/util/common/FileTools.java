package com.service.util.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class FileTools {
	/*
	 * List all filenames under the path and subfolders
	 */
	public static List<String> listFiles(String dir) {
		List<String> result = new ArrayList<String>();
		File file = new File(dir);
		File[] fts = file.listFiles();
		for (File ft : fts) {
			if (ft.isDirectory()) {
				result.addAll(listFiles(ft.getAbsolutePath()));
			} else {
				result.add(ft.getAbsolutePath());
			}
		}
		return result;
	}
/* 读取配置文件，返回properties 对象
 * 
 */
	public static Properties getProperties(String path) {
		Properties pro = new Properties();
		FileTools fileTools = new FileTools();
		InputStream in = fileTools.getClass().getClassLoader().getResourceAsStream(path);
		try {
			pro.load(in);
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pro;
	}
	
	/*修改或添加配置参数
	 * 
	 */
	public static void setProperties(Map<String,String> map,String path) throws Exception{
		    Properties prop = new Properties();
	        InputStream fis = new FileInputStream("config/"+path);
	        // 从输入流中读取属性列表（键和元素对）
	        prop.load(fis);
	        // 调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。
	        // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
	        OutputStream fos = new FileOutputStream("config/"+path);
	        for(String key:map.keySet()){
	        	prop.setProperty(key, map.get(key));
	        }
	        // 以适合使用 load 方法加载到 Properties 表中的格式，
	        // 将此 Properties 表中的属性列表（键和元素对）写入输出流
	        prop.store(fos,"last update");
	        //关闭文件
	        fis.close();
	        fos.close();
	}
}
