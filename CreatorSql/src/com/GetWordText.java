package com;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

public class GetWordText {
    public static void main(String[] args) {
        try {
//            InputStream is = new FileInputStream(new File("F:/中国移动上海公司ESB项目_性能分析小区无线MR性能指标KPI小时粒度数据共享服务_V0.1.doc"));
//            byte[] byt = new byte[is.available()];
//
//            is.read(byt);
//           
//           ByteArrayInputStream isa = new ByteArrayInputStream(byt);
//            WordExtractor ex = new WordExtractor(isa);
//            String text2003 = ex.getText();
//            System.out.println(text2003);
        	
        	FileInputStream fis = new FileInputStream(new File("F:/中国移动上海公司ESB项目_性能分析小区无线MR性能指标KPI小时粒度数据共享服务_V0.1.doc"));
            HWPFDocument doc = new HWPFDocument(fis);
            String doc1 = doc.getDocumentText();
//            System.out.println(doc1);
//            StringBuilder doc2 = doc.getText();
//            System.out.println(doc2);
//            Range rang = doc.getRange();
//            String doc3 = rang.text();
//            System.out.println(doc3);
//            System.out.println("@@@@@@@@@  ----->>>>"+doc1.length());
//
//            System.out.println("@@@@@@@@@  ----->>>>"+doc1.lastIndexOf("服务编码"));
//            System.out.println("@@@@@@@@@  ----->>>>"+doc1.lastIndexOf("服务编码命名规则"));
//            doc1 = doc1.replaceAll("\r|\n", "");
//            String str=  doc1.substring(doc1.lastIndexOf("服务编码服务编码")+"服务编码服务编码".length(), doc1.lastIndexOf("服务编码命名规则"));
//            System.out.println(str.trim());
//            fis.close();
//
            OPCPackage opcPackage = POIXMLDocument.openPackage("F:/中国移动上海公司ESB项目_性能分析小区无线MR性能指标KPI小时粒度数据共享服务_V0.1.docx");
            POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
            String text2007 = extractor.getText();
//            System.out.println(text2007);
            text2007 = text2007.replaceAll("\r|\n", "");
            String str1=  text2007.substring(text2007.lastIndexOf("服务编码服务编码")+"服务编码服务编码".length(), text2007.lastIndexOf("服务编码命名规则"));
            System.out.println(str1.trim());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}