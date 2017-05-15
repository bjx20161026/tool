package com.readExcle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import common.Common;
import util.Util;

public class ReadExcle {
    /**
     * read the Excel file
     * @param path the path of the Excel file
     * @return
     * @throws IOException
     */
    public List<HashMap<String, String>> readExcel(String path) throws IOException {
        if (path == null || Common.EMPTY.equals(path)) {
            return null;
        } else {
            String postfix = Util.getPostfix(path);
            if (!Common.EMPTY.equals(postfix)) {
                if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
                    return readXls(path);
                } else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
                    return readXlsx(path);
                }
            } else {
                System.out.println(path + Common.NOT_EXCEL_FILE);
            }
        }
        return null;
    }  
    /**
     * Read the Excel 2010
     * @param path the path of the excel file
     * @return list
     * @throws IOException
     */
    public List<HashMap<String, String>> readXlsx(String path) throws IOException {
        System.out.println(Common.PROCESSING + path);
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        List<HashMap<String, String>> list=new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;
        // Read the Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                	map=new HashMap<String, String>();
                	XSSFCell valueA = xssfRow.getCell(0);
                    XSSFCell valueB = xssfRow.getCell(1);
                    XSSFCell valueC = xssfRow.getCell(2);
                    XSSFCell valueD = xssfRow.getCell(3);
                    XSSFCell valueE = xssfRow.getCell(4);
                    XSSFCell valueF = xssfRow.getCell(5);
                    XSSFCell valueG= xssfRow.getCell(6);
                    XSSFCell valueH= xssfRow.getCell(7);
                    XSSFCell valueI= xssfRow.getCell(9);
                    XSSFCell valueJ= xssfRow.getCell(9);
                    XSSFCell valueK= xssfRow.getCell(10);
                    XSSFCell valueL= xssfRow.getCell(11);
                    XSSFCell valueM= xssfRow.getCell(12);
                    XSSFCell valueN= xssfRow.getCell(13);
                    XSSFCell valueO= xssfRow.getCell(14);
                    
                    String fileName = path.substring(path.lastIndexOf("/") + 1);
                    fileName = fileName.replace(".xls", "");
                    System.out.println("fileName-->"+fileName);
                    map.put("A", fileName);
                	map.put("0", getValue(valueA));
                	map.put("1", getValue(valueB));
                	map.put("2", getValue(valueC));
                	map.put("3", getValue(valueD));
                	map.put("4", getValue(valueE));
                	map.put("5", getValue(valueF));
                	map.put("6", getValue(valueG));
                	map.put("7", getValue(valueH));
                	map.put("8", getValue(valueI));
                	map.put("9", getValue(valueJ));
                	map.put("10", getValue(valueK));
                	map.put("11", getValue(valueL));
                	map.put("12", getValue(valueM));
                	map.put("13", getValue(valueN));
                  	map.put("14", getValue(valueO));
                	list.add(map);
                }
            }
        }
        xssfWorkbook.close();
        return list;
    }
    public List<HashMap<String, String>> readXlsx2(String path) throws IOException {
        System.out.println(Common.PROCESSING + path);
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        List<HashMap<String, String>> list=new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;
        // Read the Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                	map=new HashMap<String, String>();
                	XSSFCell valueA = xssfRow.getCell(0);
                    XSSFCell valueB = xssfRow.getCell(1);
                    XSSFCell valueC = xssfRow.getCell(2);
                    XSSFCell valueD = xssfRow.getCell(3);
//                    XSSFCell valueE = xssfRow.getCell(4);

                	map.put("0", getValue(valueA));
                	map.put("1", getValue(valueB));
                	map.put("2", getValue(valueC));
                	map.put("3", getValue(valueD));
//                	map.put("4", getValue(valueE));
                	list.add(map);
                }
            }
        }
        xssfWorkbook.close();
        return list;
    }
    /**
     * Read the Excel 2003-2007
     * @param path the path of the Excel
     * @return list
     * @throws IOException
     */
    public List<HashMap<String, String>> readXls(String path) throws IOException {
        System.out.println(Common.PROCESSING + path);
        InputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        List<HashMap<String, String>> list=new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;
     
        // Read the Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                	map=new HashMap<String, String>();
                	HSSFCell valueA = hssfRow.getCell(0);
                    HSSFCell valueB = hssfRow.getCell(1);
                    HSSFCell valueC = hssfRow.getCell(2);
                    HSSFCell valueD = hssfRow.getCell(3);
                    HSSFCell valueE = hssfRow.getCell(4);
                    HSSFCell valueF = hssfRow.getCell(5);
                    HSSFCell valueG= hssfRow.getCell(6);
                    HSSFCell valueH= hssfRow.getCell(7);
                    HSSFCell valueI= hssfRow.getCell(9);
                    HSSFCell valueJ= hssfRow.getCell(9);
                    HSSFCell valueK= hssfRow.getCell(10);
                    HSSFCell valueL= hssfRow.getCell(11);
                    HSSFCell valueM= hssfRow.getCell(12);
                    HSSFCell valueN= hssfRow.getCell(13);
                    HSSFCell valueO= hssfRow.getCell(14);
                    String fileName = path.substring(path.lastIndexOf("\\") + 1);
                    fileName = fileName.replace(".xls", "");
                    System.out.println("fileName-->"+fileName);
                    map.put("A", fileName);
                	map.put("0", getValue(valueA));
                	map.put("1", getValue(valueB));
                	map.put("2", getValue(valueC));
                	map.put("3", getValue(valueD));
                	map.put("4", getValue(valueE));
                	map.put("5", getValue(valueF));
                	map.put("6", getValue(valueG));
                	map.put("7", getValue(valueH));
                	map.put("8", getValue(valueI));
                	map.put("9", getValue(valueJ));
                	map.put("10", getValue(valueK));
                	map.put("11", getValue(valueL));
                	map.put("12", getValue(valueM));
                	map.put("13", getValue(valueN));
                  	map.put("14", getValue(valueO));
                	list.add(map);
                }
            }
        }
        hssfWorkbook.close();
        return list;
    }
    @SuppressWarnings({ "static-access", "deprecation" })
    private String getValue(XSSFCell xssfRow) {
    	try{
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
//        	DateUtil.isCellDateFormatted(xssfRow);
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
        	DecimalFormat df = new DecimalFormat("0");  
            return String.valueOf(df.format(xssfRow.getNumericCellValue()));
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    	}catch(Exception e){
    		return null;
    	}
    }
    @SuppressWarnings({ "static-access", "deprecation" })
    private String getValue(HSSFCell hssfCell) {
    	try{
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
        	DecimalFormat df = new DecimalFormat("0");  
            return String.valueOf(df.format(hssfCell.getNumericCellValue()));
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    	}catch(Exception e){
    		return null;
    	}
    }
}
