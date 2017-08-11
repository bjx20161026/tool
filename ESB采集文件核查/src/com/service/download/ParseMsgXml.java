package com.service.download;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import util.common.RegularTool;

public class ParseMsgXml {
	Logger logger = Logger.getLogger(ParseMsgXml.class);

	public String GetFtpInfo(String xml) throws DocumentException{
		String ftpUrl = "";
		Document dom = null;
		logger.info("xml--->>"+xml);
		dom = DocumentHelper.parseText(xml);
		Element root=dom.getRootElement();
		Element ftpInfo;
		if(root.getName().equals("fileInfo")){
			 ftpInfo=root.element("ftpInfo");
		}else{
			 ftpInfo=root;
		}
		Element ConnectionString = ftpInfo.element("ConnectionString");
		Element Path = ftpInfo.element("Path");
		Element UserName = ftpInfo.element("userName");
		Element Password = ftpInfo.element("password");
		Element files = ftpInfo.element("files");
		Element file = files.element("file");
		Element FileName = file.element("fileName");
		String connection = ConnectionString.getTextTrim();
		String path = Path.getTextTrim();
		String userName = UserName.getTextTrim();
		String password = Password.getTextTrim();
		String fileName = FileName.getTextTrim();
		if(path.endsWith("/")){
			path = path.substring(0,path.length()-1);
		}
		if(path.startsWith("/")){
			path = path.substring(1,path.length());
		}
		if(RegularTool.isMatcher(connection, "ftp://(.*?):(.*?)@(\\d+\\.\\d+\\.\\d+\\.\\d+):21")){
			ftpUrl = connection+"/"+path+"/"+fileName;
		}else{
			connection = RegularTool.MatcherValue(connection,".*?(\\d+\\.\\d+\\.\\d+\\.\\d+:21)");
			String format = "ftp://%s:%s@%s/%s/%s";
			ftpUrl = String.format(format, userName,password,connection,path,fileName);
		}
		return ftpUrl;
	}
	
	public static void main(String[] args){
//		ParseMsgXml getFtpInfo = new ParseMsgXml();
////		String xml = "<fileInfo><ftpInfo><Type>update</Type><DataCatalog>NHM-CPU-MEM-KPI</DataCatalog><WorkMode>sync</WorkMode><SystemID>GCNI</SystemID><SessionID>20170803_11501737221</SessionID><MsgSerial>1501746916528</MsgSerial><DeliveryTime>2017-08-03 15:55:16</DeliveryTime><ReadyStatusCode>1</ReadyStatusCode><ConnectionString>ftp://GCP_PUT:W1n3m5s#@10.221.232.135:21</ConnectionString><Path>GCP_APP/DATA.PM.NHM_CPU_MEM_KPI.GCP_APP</Path><userName>GCP_PUT</userName><password>W1n3m5s#</password><FileList>D_ASIA_DB_RADIUS-SYS_PM_NHM-CPU-MEM-KPI_001_5_20170803-1550P0.xml.gz</FileList><files><file><fileName>D_ASIA_DB_RADIUS-SYS_PM_NHM-CPU-MEM-KPI_001_5_20170803-1550P0.xml.gz</fileName><FileFormat>xml.gz</FileFormat><FileSize>0</FileSize><IsEncryption>false</IsEncryption><CipherKey></CipherKey><CipherFile></CipherFile><IsCompressed>true</IsCompressed><CompressKey></CompressKey><CharSet>utf-8</CharSet><DataInfo></DataInfo><FieldSeparator></FieldSeparator><LineSeparator></LineSeparator><XmlSchema></XmlSchema><FileCheckInfo></FileCheckInfo></file></files></ftpInfo></fileInfo>";
//		String xml = "<ftpInfo><Type>UPDATE</Type><DataCatalog></DataCatalog><WorkMode></WorkMode><SystemID></SystemID><SessionID></SessionID><MsgSerial></MsgSerial><DeliveryTime>2017-08-03 11:19:59</DeliveryTime><ReadyStatusCode></ReadyStatusCode><ReadyStatusDescription></ReadyStatusDescription><ConnectionString>10.221.232.135:21</ConnectionString><Path>/NETVISTA_APP/DATA.PM.CMNETWANGLUOZHILIANG.NETVISTA_APP/</Path><userName>NETVISTA_PUT</userName><password>W1n3m5s#</password><FileList>CMNETwangluozhiliang-20170803-111000.csv</FileList><files><file><fileName>CMNETwangluozhiliang-20170803-111000.csv</fileName><FileFormat>csv</FileFormat><FileSize></FileSize><IsEncryption></IsEncryption><CipherKey></CipherKey><CipherFile></CipherFile><IsCompressed>false</IsCompressed><CompressKey></CompressKey><DataInfo></DataInfo><FieldSeparator>,</FieldSeparator><LineSeparator></LineSeparator><XmlSchema>XmlSchema</XmlSchema><CharSet>GBK</CharSet><FileCheckInfo></FileCheckInfo></file></files></ftpInfo>";
//		try {
//			System.out.println(getFtpInfo.GetFtpInfo(xml));)
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		boolean is = RegularTool.isMatcher("ftp://GCP_PUT:W1n3m5s#@10.221.232.137:21", "ftp://(.*?):(.*?)@(\\d+\\.\\d+\\.\\d+\\.\\d+):21");
	    System.out.println(is);
	    String abc = RegularTool.MatcherValue("ftp://GCP_PUT:W1n3m5s#@10.221.232.137:21",".*?(\\d+\\.\\d+\\.\\d+\\.\\d+:21)");
	    System.out.println("abc--->>>"+abc);
	}
}
