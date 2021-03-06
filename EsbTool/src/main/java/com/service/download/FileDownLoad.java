package com.service.download;

import java.io.ByteArrayOutputStream;

import com.dao.esbCollect.MetaDtMsgRecord;
import com.dao.inasCollect.MetaDtMsgSendRecord;
import com.service.cache.SqlResultCache;
import com.service.inasCollect.DealPolicyTable;

import util.ftp.FileOperate;
import util.ftp.FtpFileObject;


public class FileDownLoad {
	public String fileName;
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ByteArrayOutputStream FtpFile(String ftpUrl) throws Exception{
		FtpFileObject ffo = new FtpFileObject(ftpUrl);
		setFileName(ffo.getName());
		FileOperate fo = new FileOperate(ftpUrl);
		fo.login();
		fo.cd();
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		fo.get(bo);
		return bo;
	}
	
	public ByteArrayOutputStream DownLoad(String protocol,String day) throws Exception{
		MetaDtMsgRecord dealMetaDtMsgRecord = new MetaDtMsgRecord();
		String msg = dealMetaDtMsgRecord.GetMsg(protocol,day);
		ParseMsgXml parseMsgXml = new ParseMsgXml();
		String ftpUrl=parseMsgXml.GetFtpInfo(msg);
		return FtpFile(ftpUrl);
	}
	
	public ByteArrayOutputStream DownLoadById(String id) throws Exception{
		MetaDtMsgSendRecord metaDtMsgSendRecord = new MetaDtMsgSendRecord();
		String msg = metaDtMsgSendRecord.getMsg(id);
		ParseMsgXml parseMsgXml = new ParseMsgXml();
		String ftpUrl=parseMsgXml.GetFtpInfoForSend(msg);
		return FtpFile(ftpUrl);
	}
	
	public ByteArrayOutputStream DownLoadCollectFile(String protocol,String fileName) throws Exception{
		DealPolicyTable dealPolicyTable = new DealPolicyTable();
		String url = dealPolicyTable.GetFtpUrl(protocol);
		url = url.substring(0,url.lastIndexOf("/")+1);
		return FtpFile(url+fileName);
	}
	
	public ByteArrayOutputStream DownLoadEsbCollectFile(String id) throws Exception{
		return FtpFile(SqlResultCache.EsbCollectFtpUrl.get(id));
	}
	
	public static void main(String[] args) throws Exception{
		FileDownLoad fileDownLoad = new FileDownLoad();
		ByteArrayOutputStream str = fileDownLoad.DownLoad("DATA.PM.ZXDNA_CMCC_3G_02.ZXDNA_APP","1");
		System.out.println("str--->>>"+str);
	}
}
