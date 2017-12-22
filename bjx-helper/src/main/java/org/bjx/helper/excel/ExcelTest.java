package org.bjx.helper.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {
Logger logger = Logger.getLogger(ExcelReader.class);
	
	public String heads;//指定返回的List<Map<String,Object>> 的表头，用","进行分隔
	public int startLine = 0;//文件的起始行
	public int startColumn = 0;//文件的起始列
	public int headLine = -1;//作为文件返回表头的行,当heads为空，而且headLind>-1是启用
	public String sheetName;//文件的sheet名，当sheetName==null时，程序只解析文件的第一个sheet
	public String simpleDateFormat = "yyyy-MM-dd HH:mm:ss";//格式化时间对象转成字符串
	
	public List<Map<String, String>> list;
	public XSSFWorkbook xssfWorkbook;
	public XSSFSheet xssfSheet;
	public XSSFRow xssfRow;
	public HSSFWorkbook hssfWorkbook;
	public HSSFSheet hssfSheet;
	public HSSFRow hssfRow;
	public String value;
	public HashMap<String, String> map;
	
	public static void main(String[] args) {
		ExcelTest excelTest = new ExcelTest();
		try {
			excelTest.readXlsx("F:/test.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void readXlsx(String path) throws IOException {
		logger.info(ExcelSet.PROCESSING + path);
		InputStream is = new FileInputStream(path);
		list = new ArrayList<Map<String, String>>();
		xssfWorkbook = new XSSFWorkbook(is);
		for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
			for (int rowNum = startLine; rowNum <= 16; rowNum++) {
				xssfSheet = xssfWorkbook.getSheet("sheet1"); 
				xssfRow = xssfSheet.getRow(rowNum);
//				System.out.println(xssfRow.getCell(0).getCellStyle().getFillBackgroundColor());
//				System.out.println(xssfRow.getCell(0).getCellStyle().getBottomBorderColor());
				System.out.println(xssfRow.getCell(0).getCellStyle().getFillForegroundColor());
		}
		xssfWorkbook.close();
	}
	}

}
