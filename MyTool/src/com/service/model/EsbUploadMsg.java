package com.service.model;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class EsbUploadMsg {
	Logger logger = Logger.getLogger(EsbUploadMsg.class);
	private StringBuilder suc = new StringBuilder();
	private StringBuilder err = new StringBuilder();
	public void setMsg(int i,int j,int k,String path){
		if(i == 1&&j==1&&k==1){
			suc.append(path+"--->>成功插入config：" + i + " 条：成功插入notice：" + j + " 条  ；成功插入task：" + k + " 条  \n");
		}else{
			err.append(path+"--->>功插入config：" + i + " 条：成功插入notice：" + j + " 条  ；成功插入task：" + k + " 条  \n");
		}
	}
	public void setErr(String e,String path){
		err.append(path+"--->>"+e+"\n");
	}
	@Override
	public String toString(){
		String dealInfo = "\n成功处理的文件信息："+suc.toString()+"\n处理遇到的异常信息："+err.toString();
		logger.info(dealInfo);
		return dealInfo;
	}
}
