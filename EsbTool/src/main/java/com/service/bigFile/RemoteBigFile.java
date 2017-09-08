package com.service.bigFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

import com.dao.MetaDtMsgRecord;
import com.service.download.ParseMsgXml;

import util.common.PostfixTool;
import util.ftp.FileOperate;
import util.ftp.FtpFileObject;

public class RemoteBigFile {
	public int startLine = 0;
	public int endLine = 10;
	public String charset = "utf-8";

	public InputStream getRemoteStream(String ftpUrl) throws Exception {
//		System.out.println("ftpUrl--->>>" + ftpUrl);
		FtpFileObject ffo = new FtpFileObject(ftpUrl);
		FileOperate fo = new FileOperate(ftpUrl);
		String fileName = ffo.getName();
		fo.login();
		fo.cd();
		InputStream is = fo.get(fileName);
		if (PostfixTool.getPostfix(fileName).equals("gz")) {
			is = new GZIPInputStream(is);
		}
		return is;
	}

	public String ReadRemoteBigFile(String ftpUrl) throws Exception {
		RemoteBigFile remoteBigFile = new RemoteBigFile();
		BufferedReader br = new BufferedReader(new InputStreamReader(remoteBigFile.getRemoteStream(ftpUrl), charset));
		for (int i = 0; i < startLine; i++) {
			if (br.readLine() == null)
				return null;
			br.readLine();
		}
		StringBuilder stb = new StringBuilder();
		String temp = "";
		for (int i = startLine; i < endLine; i++) {
			if ((temp = br.readLine()) != null) {
				stb.append(temp + "\n");
			} else {
				return stb.toString();
			}
		}
		return stb.toString();
	}

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
	
	public String Read(String protocol,String day) throws Exception{
		MetaDtMsgRecord dealMetaDtMsgRecord = new MetaDtMsgRecord();
		String msg = dealMetaDtMsgRecord.GetMsg(protocol,day);
		ParseMsgXml parseMsgXml = new ParseMsgXml();
		String ftpUrl=parseMsgXml.GetFtpInfo(msg);
		setCharset(parseMsgXml.getCharset());
		return ReadRemoteBigFile(ftpUrl);
	}

	public static void main(String[] args) throws Exception {
		RemoteBigFile remoteBigFile = new RemoteBigFile();
		remoteBigFile.setStartLine(0);
		remoteBigFile.setEndLine(100);
		remoteBigFile.setCharset("gbk");
		// System.out.println(remoteBigFile.ReadRemoteBigFile("ftp://PAS_PUT:W1n3m5s#@10.221.246.87:21/PAS_APP/DATA.PM.DW_FT_SE_DN1_50_D.PAS_APP/DW_FT_SE_DN1_50_D_20170808000000.csv.gz"));
		System.out.println(remoteBigFile.ReadRemoteBigFile(
				"ftp://inas:1Na512#$@10.221.18.29:21//home/BassFtpUser/informlist/temp_usr_m2m_20170904.csv"));
	}
}
