package com.service.sys.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.service.sys.LoginInformation;
import com.service.util.common.FileTools;
@Service
public class LoginInformationImpl implements LoginInformation {

	/*
	 * get password from properties file by name
	 * @see com.service.sys.LoginInformation#GetPassword(java.lang.String)
	 */
	@Override
	public String GetPassword(String name) {
		// TODO Auto-generated method stub
		Properties pro = FileTools.getProperties("users.properties");
		return pro.getProperty(name);
	}

	@Override
	public void SetAccount(String name, String password) throws Exception {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String,String>();
		map.put(name, password);
		FileTools.setProperties(map, "users.properties");
	}
	
	public static void main(String[] args){
		Properties pro = FileTools.getProperties("users.properties");
		System.out.println(pro.getProperty("1234bjx"));
	}
}
