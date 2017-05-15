package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
	public static Properties getProperties(String path){
		Properties pro = new Properties();
		FileInputStream in;
		try {
			in = new FileInputStream("./config/"+path);
			pro.load(in);
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pro;
	}
	public static void main(String[] args){
//		Properties pro=new Properties();
//		PropertiesTest PropertiesTest = new PropertiesTest();
//		InputStream is=PropertiesTest.getClass().getClassLoader().getResourceAsStream("propertiesTest.properties");
//		try {
//			pro.load(is);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(pro.getProperty("test.first"));
		
		Properties pro = getProperties("propertiesTest.properties");
		System.out.println("获取不存在"+pro.getProperty("test.2"));
	}
}
