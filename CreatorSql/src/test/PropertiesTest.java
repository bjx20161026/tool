package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args){
		Properties pro=new Properties();
		PropertiesTest PropertiesTest = new PropertiesTest();
		InputStream is=PropertiesTest.getClass().getClassLoader().getResourceAsStream("propertiesTest.properties");
		try {
			pro.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(pro.getProperty("test.first"));
	}
}
