package org.bjx.helper.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
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
	
	public List<Map<String, Map<String,Object>>> list; //内容，带格式
	public String[] heads;//表头
	public int numSheet = 0;//处理的sheet序号
	public XSSFWorkbook xssfWorkbook;
	public XSSFSheet xssfSheet;
	public XSSFRow xssfRow;
	public HSSFWorkbook hssfWorkbook;
	public HSSFSheet hssfSheet;
	public HSSFRow hssfRow;
	public HashMap<String, String> map;
	
	public static void main(String[] args) throws IOException {
		FileOutputStream out=new FileOutputStream("F:/Example6.xlsx");
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		XSSFSheet xssfSheet = xssfWorkbook.createSheet("just for fun");
		XSSFRow xssfRow =  xssfSheet.createRow(0);
	//	XSSFCell cell = xssfRow.createCell(1);
//		cell.setCellValue("just for fun !");
//		StylesTable styleTable = new StylesTable();
//		styleTable.setTheme(null);

		//cell.setCellStyle(style);
		//cell.setCellValue("just for fun !");
		XSSFCell cell=xssfRow.createCell(0);
		cell.setCellValue("合并列");
		CellRangeAddress region=new CellRangeAddress(0, 4, 5, 6);
		xssfSheet.addMergedRegion(region);
		
//		for(int i=0;i<64;i++){
//			CellStyle style = xssfWorkbook.createCellStyle();
//			style.setBorderLeft(CellStyle.BORDER_THICK);
//			//style.setFillForegroundColor((short)10);
//			style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
//		XSSFCell cell2 = xssfRow.createCell(i);
//		style.setFillForegroundColor((short)i);
//		cell2.setCellStyle(style);
//		cell2.setCellValue(i);
//		XSSFDrawing xssfDrawing =  xssfSheet.createDrawingPatriarch();
//		XSSFComment comment  = xssfSheet.createDrawingPatriarch().createCellComment(xssfDrawing.createAnchor(0, 0, 0, 0, 5, 1, 8,3));
//		comment.setAuthor("b j x");
//		comment.setString("this a comment");
//		cell2.setCellComment(comment);
//		}
		xssfWorkbook.write(out);
		out.flush();
		out.close();
	}
	
	public void excelWriter() {
		
	}

}
