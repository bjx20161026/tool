package com.service.util.word;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import com.service.util.common.PostfixTool;
/*
 * 读取word文件，返回文件的文本内容
 */
public class GetWordText {
	public String getWordText(String path) throws Exception{
		if(PostfixTool.getPostfix(path).equals("doc")){
			return getDocText(path);
		}else if(PostfixTool.getPostfix(path).equals("docx")){
			return getDocxText(path);
		}
		return null;
	}
	
	public String getDocText(String path) throws Exception{
    	FileInputStream fis = new FileInputStream(new File(path));
        @SuppressWarnings("resource")
		HWPFDocument doc = new HWPFDocument(fis);
		return doc.getDocumentText().replaceAll("\r|\n", "");
	}
	
	public String getDocxText(String path) throws Exception{
		 OPCPackage opcPackage = POIXMLDocument.openPackage(path);
         @SuppressWarnings("resource")
		POIXMLTextExtractor docx = new XWPFWordExtractor(opcPackage);
		return docx.getText().replaceAll("\r|\n", "");
	}

}
