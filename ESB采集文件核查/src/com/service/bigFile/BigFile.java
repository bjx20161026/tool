package com.service.bigFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BigFile {
	public int startLine = 0;
	public int endLine = 10;
	public String charset = "utf-8";
	public int getStartLine() {
		return startLine;
	}

	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}

	public int getEndLine() {
		return endLine;
	}

	public void setEndLine(int endLine) {
		this.endLine = endLine;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String ReadBigFile(String filePath) throws Exception{
		File file = new File(filePath);
		InputStream is = new FileInputStream(file);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new InputStreamReader(is,charset));
		for(int i=0;i<startLine;i++){
			if(br.readLine()==null)
				return null;
		br.readLine();
		}
		StringBuilder stb = new StringBuilder();
		String temp = "";
		for(int i=startLine;i<endLine;i++){
			if((temp=br.readLine())!=null){
				stb.append(temp+"\n");
			}else{
				return stb.toString();
			}	
		}
		return stb.toString();
	}
	
	public static void main(String[] args){
		BigFile bigFile = new BigFile();
		bigFile.setCharset("utf-8");
		bigFile.setStartLine(200000);
		bigFile.setEndLine(200100);
		try {
			System.out.println(bigFile.ReadBigFile("F:/FtpFile/2017-08-08/LWT_APP/DATA.PM.LTE_VOLTESIMPLE_DAY.LWT_APP/LTE_VOLTESIMPLE_DAY_20170806.csv"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
