package org.bjx.helper.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.bjx.helper.common.PostfixTool;

public class ExcelWriterForExitence {
	Logger logger = Logger.getLogger(ExcelWriterForExitence.class);
	
	public List<Map<String, String>> list; //追加的内容
	public String[] heads;//表头
	public int numSheet = 0;//处理的sheet序号

	public XSSFWorkbook xssfWorkbook;
	public XSSFSheet xssfSheet;
	public XSSFRow xssfRow;
	public HSSFWorkbook hssfWorkbook;
	public HSSFSheet hssfSheet;
	public HSSFRow hssfRow;
	public HashMap<String, String> map;
	
	/**
	 * 对已经存在的excle追加内容，需要sheet已经存在，
	 * 追加内容从已有内容的最后一行+1开始插入
	 * @param String path
	 * @param List<Map<String, String>> list
	 * @param String[] heads
	 * @param int numSheet
	 * 
	 * @return int 
	 * 
	 */
	public int dealExcel(String path) throws IOException {
		if (path == null || ExcelSet.EMPTY.equals(path)) {
			logger.info(path + "IS NULL");
			return 0;
		} else {
			String postfix = PostfixTool.getPostfix(path);
			if (!ExcelSet.EMPTY.equals(postfix)) {
				if (ExcelSet.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
					return readXls(path);
				} else if (ExcelSet.OFFICE_EXCEL_2007_POSTFIX.equals(postfix)) {
					return readXlsx(path);
				}
			} else {
				logger.info(path + ExcelSet.NOT_EXCEL_FILE);
			}
		}
		return 0;
	}

	@SuppressWarnings("rawtypes")
	private int readXlsx(String path) throws IOException {
		logger.info(path +" : "+ExcelSet.PROCESSING);
		InputStream is = new FileInputStream(path);
		xssfWorkbook = new XSSFWorkbook(is);
		xssfSheet = xssfWorkbook.getSheetAt(numSheet);
		int lastRowNum = xssfSheet.getLastRowNum();
		FileOutputStream out=new FileOutputStream(path);
		for(int rowNum = lastRowNum+1;rowNum<list.size()+lastRowNum+1;rowNum++){
			xssfRow = xssfSheet.createRow(rowNum);
			Map map = list.get(rowNum - lastRowNum -1);		
				for(int i=0;i<heads.length;i++){
					xssfRow.createCell(i).setCellValue((String) map.get(heads[i]));
				}
		}
		out.flush();
		xssfWorkbook.write(out);
		out.close();	
		xssfWorkbook.close();
		return list.size();
	}

	@SuppressWarnings("rawtypes")
	private int readXls(String path) throws IOException {
		logger.info(path +" : "+ExcelSet.PROCESSING);
		InputStream is = new FileInputStream(path);
		hssfWorkbook = new HSSFWorkbook(is);
		hssfSheet = hssfWorkbook.getSheetAt(numSheet);
		int lastRowNum = hssfSheet.getLastRowNum();
		FileOutputStream out=new FileOutputStream(path);
		for(int rowNum = lastRowNum+1;rowNum<list.size()+lastRowNum+1;rowNum++){
			hssfRow = hssfSheet.createRow(rowNum);
			Map map = list.get(rowNum - lastRowNum -1);		
				for(int i=0;i<heads.length;i++){
					hssfRow.createCell(i).setCellValue((String) map.get(heads[i]));
				}
		}
		out.flush();
		hssfWorkbook.write(out);
		out.close();	
		hssfWorkbook.close();
		return list.size();
	}
	
	public List<Map<String, String>> getList() {
		return list;
	}

	public void setList(List<Map<String, String>> list) {
		this.list = list;
	}

	public int getNumSheet() {
		return numSheet;
	}

	public void setNumSheet(int numSheet) {
		this.numSheet = numSheet;
	}

	public String[] getHeads() {
		return heads;
	}

	public void setHeads(String[] heads) {
		this.heads = heads;
	}

}
