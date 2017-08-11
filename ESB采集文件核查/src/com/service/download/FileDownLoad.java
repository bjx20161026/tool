package com.service.download;

import java.io.File;
import java.io.FileOutputStream;

import com.dao.MetaDtMsgRecord;

import util.common.FileTools;
import util.common.MyDate;
import util.ftp.FileOperate;
import util.ftp.FtpFileObject;


public class FileDownLoad {
	public String FtpFile(String ftpUrl) throws Exception{
		MyDate myDate = new MyDate();
		String dateString = myDate.getDayString(0);
		String localUrl = "F:/FtpFile";
		FtpFileObject ffo = new FtpFileObject(ftpUrl);
		localUrl = String.format("%s/%s/%s/%s",localUrl,dateString,ffo.getDir(),ffo.getName());
		File ftpFile = FileTools.CtreatFile(localUrl);
		FileOperate fo = new FileOperate(ftpUrl);
		fo.login();
		fo.cd();
		FileOutputStream fos = new FileOutputStream(ftpFile);
		fo.get(fos);
		fos.close();
		fo.disConnect();
		return localUrl;
	}
	
	public String DownLoad(String protocol) throws Exception{
		MetaDtMsgRecord dealMetaDtMsgRecord = new MetaDtMsgRecord();
		String msg = dealMetaDtMsgRecord.GetMsg(protocol);
		ParseMsgXml parseMsgXml = new ParseMsgXml();
		String ftpUrl=parseMsgXml.GetFtpInfo(msg);
		return FtpFile(ftpUrl);
	}
	
	public static void main(String[] args) throws Exception{
		FileDownLoad fileDownLoad = new FileDownLoad();
		String str = fileDownLoad.DownLoad("DATA.PM.ISMG_HYRT_IA_REPORT_EC_SI_SMSC.GCP_APP");
		System.out.println("str--->>>"+str);
	}
}
