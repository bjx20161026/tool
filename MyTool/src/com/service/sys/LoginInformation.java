package com.service.sys;

public interface LoginInformation {
	public String GetPassword(String name);
	public void SetAccount(String name,String password) throws Exception;
}
