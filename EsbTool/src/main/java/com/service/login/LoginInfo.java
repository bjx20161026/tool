package com.service.login;

import java.util.Properties;

import util.common.FileTools;

public class LoginInfo {
	public String GetPassWord(String name){
		Properties properties = FileTools.getProperties("users.properties");
		return properties.getProperty(name);
	}
	public static void main(String[] args){
		LoginInfo loginInfo = new LoginInfo();
		System.out.println("loginInfo.getPassWord--->>>"+loginInfo.GetPassWord("1234bjx"));
	}
}
