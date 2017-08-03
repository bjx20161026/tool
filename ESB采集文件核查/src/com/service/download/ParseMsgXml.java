package com.service.download;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class ParseMsgXml {

	public String GetFtpInfo(String xml) throws DocumentException{
		Document dom = null;
		dom = DocumentHelper.parseText(xml);
		Element root=dom.getRootElement();
		Element ftpInfo=root.element("ftpInfo");
		Element ConnectionString = ftpInfo.element("ConnectionString");
		String connection = ConnectionString.getTextTrim();
		return null;
	}
}
