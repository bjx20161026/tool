package org.bjx.helper.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcleWriter {
	
Logger logger = Logger.getLogger(ExcelWriterForExitence.class);
	
	public List<Sheet> sheets;
//	public XSSFWorkbook xssfWorkbook;
//	public XSSFSheet xssfSheet;
//	public XSSFRow xssfRow;
//	public HSSFWorkbook hssfWorkbook;
//	public HSSFSheet hssfSheet;
//	public HSSFRow hssfRow;
//	public HashMap<String, String> map;
	
	public List<Sheet> getSheets() {
		return sheets;
	}
	public void setSheets(List<Sheet> sheets) {
		this.sheets = sheets;
	}


	@SuppressWarnings("unchecked")
	public void XlsxWriter(OutputStream outputStream) throws IOException {
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		for(Sheet sheet:sheets) {
			XSSFSheet xssfSheet = xssfWorkbook.createSheet(sheet.getSheetName());

			//设定默认列格式
			if(sheet.getColumnStyle()!=null) {
				Map<Integer, Map<String, Object>> columnStyles = sheet.getColumnStyle();
				for(Object key:columnStyles.keySet()) {
					xssfSheet.setDefaultColumnStyle((Integer) key, setStyle(xssfWorkbook,columnStyles.get(key)));				
				}
				String[] heads = sheet.getHeadName().split(",");
				for(int rowNum=0;rowNum<sheet.getDatas().size();rowNum++) {
					Map<String,Object> map = sheet.getDatas().get(rowNum);
					Row row = xssfSheet.createRow(rowNum);
					for(int column=0;column<heads.length;column++) {
						Cell cell = row.createCell(column);
						Map<String,Object> cellMap = (Map<String, Object>) map.get(heads[column]);
						cell.setCellValue(cellMap.get("value")==null?"":cellMap.get("value").toString());
						if(cellMap.get("style")!=null) {
							cell.setCellStyle(setStyle(xssfWorkbook, (Map<String, Object>) cellMap.get("style")));
						}
						if(cellMap.get("comment")!=null) {
							cell.setCellComment(setComment(xssfSheet, cellMap.get("comment").toString()));
						}
					}
				}
				if(sheet.getMergeCell()!=null) {
					mergeCell(xssfSheet, sheet.getMergeCell());
				}
			}
		}
		xssfWorkbook.write(outputStream);
		outputStream.flush();
	}
	
	public CellStyle setStyle(XSSFWorkbook xssfWorkbook,Map<String,Object> map) {
		CellStyle style = xssfWorkbook.createCellStyle();
		if(map.get("BorderLeft")!=null)
			style.setBorderLeft((Short) map.get("BorderLeft"));
		if(map.get("BorderRight")!=null)
			style.setBorderRight((Short) map.get("BorderRight"));
		if(map.get("BorderTop")!=null)
			style.setBorderTop((Short) map.get("BorderTop"));
		if(map.get("BorderBottom")!=null)
			style.setBorderBottom((Short) map.get("BorderBottom"));
		if(map.get("groundColor")!=null) {
			style.setFillForegroundColor((Short)map.get("groundColor"));
			style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		}
		if(Boolean.valueOf((String)map.get("center"))) {
			style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			style.setAlignment(CellStyle.ALIGN_CENTER);
		}
		if(map.get("front")!=null)
			style.setFont((Font) map.get("front"));
		return style;
	}
	
	
	public XSSFComment setComment(XSSFSheet xssfSheet,String comment) {
		XSSFDrawing xssfDrawing =  xssfSheet.createDrawingPatriarch();
		XSSFComment xssfComment  = xssfSheet.createDrawingPatriarch().createCellComment(xssfDrawing.createAnchor(0, 0, 0, 0, 5, 1, 8,3));
		xssfComment.setString(comment);
		return xssfComment;
	}
	
	public void mergeCell(XSSFSheet xssfSheet,List<Map<String,Integer>> list) {
		for(Map<String,Integer> map:list) {
			CellRangeAddress region=new CellRangeAddress(map.get("firstRow"), map.get("lastRow"), map.get("firstColumn"), map.get("lastColumn"));
			xssfSheet.addMergedRegion(region);
		}
	}

	
	
	public static void main(String[] args) throws Exception{
		ExcleWriter excleWriter = new ExcleWriter();
		List<Sheet> sheets = new ArrayList<Sheet>();
		for(int i=0;i<10;i++) {
			Sheet sheet = new Sheet();
			sheet.setSheetName("TestSheet"+i);
			sheets.add(sheet);
			Map<Integer, Map<String, Object>> columnStyles = new HashMap<Integer, Map<String,Object>>();
			for(int j=0;j<10;j++) {
		    Map<String,Object> map = new HashMap<String, Object>();
			map.put("BorderRight", (short)j);
			map.put("groundColor", (short)44);			
			columnStyles.put(j, map);
			}
			sheet.setColumnStyle(columnStyles);
			
			//DATA
			String[] heads = "one,two,three.four,five".split(",");
			for(int j=0;j<10;j++)
				for(int k=0;k<heads.length;k++) {
					
				}
			}
		excleWriter.setSheets(sheets);
		excleWriter.XlsxWriter(new FileOutputStream("F:/excel/Excel2ColumnStyle.xlsx"));
	}
		
}
