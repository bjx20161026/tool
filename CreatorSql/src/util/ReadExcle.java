package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import common.Common;

public class ReadExcle {
	Logger logger = Logger.getLogger(ReadExcle.class);
	List<Map<String, String>> list;
	HashMap<String, String> map;
	List<String> heads;
	String value;
	XSSFWorkbook xssfWorkbook;
	XSSFSheet xssfSheet;
	XSSFRow xssfRow;
	HSSFWorkbook hssfWorkbook;
	HSSFSheet hssfSheet;
	HSSFRow hssfRow;
	/**
	 * read the Excel file
	 * 
	 * @param path
	 *            the path of the Excel file
	 * @return
	 * @throws IOException
	 */
	public List<Map<String, String>> readExcel(String path) throws IOException {
		if (path == null || Common.EMPTY.equals(path)) {
			return null;
		} else {
			String postfix = PostfixTool.getPostfix(path);
			if (!Common.EMPTY.equals(postfix)) {
				if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
					return readXls(path);
				} else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
					return readXlsx(path);
				}
			} else {
				logger.info(path + Common.NOT_EXCEL_FILE);
			}
		}
		return null;
	}

	/**
	 * Read the Excel 2007 or later
	 * 
	 * @param path
	 *            the path of the excel file
	 * @return list
	 * @throws IOException
	 */
	public List<Map<String, String>> readXlsx(String path) throws IOException {
		logger.info(Common.PROCESSING + path);
		InputStream is = new FileInputStream(path);
		list = new ArrayList<Map<String, String>>();
		xssfWorkbook = new XSSFWorkbook(is);
		for (int numSheet = 0; numSheet < 1/*xssfWorkbook.getNumberOfSheets()*/; numSheet++) {
			xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			if (xssfSheet == null)
				continue;
			xssfRow = xssfSheet.getRow(0);
			heads = new ArrayList<String>();
			try {
				for (int i = 0; (value = getValue(xssfRow.getCell(i))) != null; i++) {
					heads.add(value);
				}
			} catch (NullPointerException e) {
			}
			map = new HashMap<String, String>();
			map.put("heads", heads.toString());
			list.add(map);
			for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
				xssfRow = xssfSheet.getRow(rowNum);
				if (xssfRow != null) {
					map = new HashMap<String, String>();
					for (int j = 0; j < heads.size(); j++) {
						map.put(heads.get(j), getValue(xssfRow.getCell(j)));
					}
					list.add(map);
				}
			}
		}
		logger.info("list.size:"+list.size());
		return list;
	}

	/**
	 * Read the Excel 2003
	 * 
	 * @param path
	 *            the path of the Excel
	 * @return
	 * @return
	 * @return list
	 * @throws IOException
	 */
	public List<Map<String, String>> readXls(String path) throws IOException {
		logger.info(Common.PROCESSING + path);
		InputStream is = new FileInputStream(path);
		list = new ArrayList<Map<String, String>>();
		hssfWorkbook = new HSSFWorkbook(is);
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null)
				continue;
			hssfRow = hssfSheet.getRow(0);
			heads = new ArrayList<String>();
			try {
				for (int i = 0; (value = getValue(hssfRow.getCell(i))) != null; i++)
					heads.add(value);
			} catch (NullPointerException e) {
			}
			map = new HashMap<String, String>();
			map.put("heads", heads.toString());
			list.add(map);
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				xssfRow = xssfSheet.getRow(rowNum);
				if (xssfRow != null) {
					map = new HashMap<String, String>();
					for (int j = 0; j < heads.size(); j++) {
						map.put(heads.get(j), getValue(hssfRow.getCell(j)));
					}
					list.add(map);
				}
			}
		}
		return list;
	}

	@SuppressWarnings({ "deprecation" })
	protected String getValue(XSSFCell xssfRow) {
		try {
			if (xssfRow.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
				return String.valueOf(xssfRow.getBooleanCellValue());
			} else if (xssfRow.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				if (DateUtil.isCellDateFormatted(xssfRow)) {
					return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.format(DateUtil.getJavaDate(xssfRow.getNumericCellValue()));
				} else {
					DecimalFormat df = new DecimalFormat("0");
					return String.valueOf(df.format(xssfRow.getNumericCellValue()));
				}
			} else {
				return String.valueOf(xssfRow.getStringCellValue());
			}
		} catch (NullPointerException e) {
			return null;
		}
	}

	@SuppressWarnings({ "deprecation" })
	protected String getValue(HSSFCell hssfCell) {
		try {
			if (hssfCell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
				return String.valueOf(hssfCell.getBooleanCellValue());
			} else if (hssfCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				if (DateUtil.isCellDateFormatted(hssfCell)) {
					return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.format(DateUtil.getJavaDate(hssfCell.getNumericCellValue()));
				} else {
					DecimalFormat df = new DecimalFormat("0");
					return String.valueOf(df.format(hssfCell.getNumericCellValue()));
				}
			} else {
				return String.valueOf(hssfCell.getStringCellValue());
			}
		} catch (NullPointerException e) {
			return null;
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		ReadExcle readExcle = new ReadExcle();
		List<Map<String,String>>  datas = readExcle.readExcel("F:/test.xlsx");
		for(int i = 0;i<datas.size();i++){
//			System.out.println(i);
			@SuppressWarnings("rawtypes")
			Map data = datas.get(i);
			System.out.println(data.get("1"));
			System.out.println(data.get("2"));
			System.out.println(data.get("3"));
		}
	}
}
