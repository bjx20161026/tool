package com.service.loadDataCheck;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;

import util.common.FileTools;
import util.ftp.FileOperate;

public class LoadFile {
	Logger logger = Logger.getLogger(LoadFile.class);
	public String ftpUrlPrefix;
	public String getFtpUrl(String fileName) throws Exception{
		Properties properties = FileTools.getProperties("FileLoad.properties");
		ftpUrlPrefix = properties.getProperty("ftpUrlPrefix");
		String ftpCatalog = properties.getProperty("FtpCatalog");
		String[] catalogs = ftpCatalog.split(",");
		String format="%s/%s/%s";
		String[] ls;
		for(int i=0;i<catalogs.length;i++){
			FileOperate fo = new FileOperate(ftpUrlPrefix+"/"+catalogs[i]+"/");
			fo.login();
			fo.cd();
			System.out.println("fo.getUrl--->>>"+fo.getUrl());
			ls = fo.ls();
			for(int j=0;j<ls.length;j++){
				if(ls[j].equals(fileName)) return String.format(format, ftpUrlPrefix,catalogs[i],fileName);
			}
			fo.disConnect();
		}
		logger.error("Dat文件没有找到--->>>"+fileName);
		System.out.println("Dat文件没有找到--->>>"+fileName);
		return null;
	}
	
	public InputStream getDatStream(String fileName) throws Exception{
		String ftpUrl = getFtpUrl(fileName);
		System.out.println("ftpUrl--->>>"+ftpUrl);
		FileOperate fo = new FileOperate(ftpUrl);
		fo.login();
		fo.cd();
		return fo.get(fileName);
	}
	
	public static void main(String[] args) throws Exception{
		LoadFile loadFile = new LoadFile();
		BufferedReader br = new BufferedReader(new InputStreamReader(loadFile.getDatStream("IPMSDW.O_RE_ST_PTN_PORT_TRFC_15M_2017080815244500_216700.dat"),"gbk"));
		System.out.println(br.readLine());
	}

}
