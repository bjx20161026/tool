//package com.creatorFile;
//
//import java.io.BufferedReader;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import com.csvreader.CsvWriter;
//
//public class CreatorFile {
//	private CsvWriter cw;
//    private static String excelPath = "data.xlsx";
//	
//	public FileOutputStream CreatCsv(String[] heads,List<Map<String,Object>> datas) throws IOException{
//		FileOutputStream bos=new FileOutputStream("F:/jiakuan.csv");
//		cw=new CsvWriter(new PrintWriter(new OutputStreamWriter(bos,"gbk")),',');
//		cw.writeRecord(heads,true);
//	    cw.flush();
//		for(Map<String,Object> data:datas){
//			Object[] records = map2Array(data, heads);
//			for(Object s:records){
//				System.out.println(String.valueOf(s).equals("null")?"":String.valueOf(s));
//				cw.write(String.valueOf(s).equals("null")?"":String.valueOf(s));
//			}
//			cw.endRecord();
//		}
//		cw.flush();
//		bos.flush();
//		bos.close();
//		return bos;
//	}
//	
//    public static Object[] map2Array(Map map, String[] properiesName) {
//        int len = properiesName.length;
//        Object[] objs = new Object[len];
//        for (int i = 0; i < len; i++) {
//           System.out.println(objs[i] = map.get(properiesName[i]));
//        }
//        return objs;
//    }
//    
//    
//
//
//	public static void main(String[] args){
//		DriverManagerDataSource dataSource=new DriverManagerDataSource();
//		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//		dataSource.setUrl("jdbc:oracle:thin:@10.221.18.39:1521:ipnet");
//		dataSource.setUsername("res");
//		dataSource.setPassword("SHres!23$");
//		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
//		List<Map<String,Object>> datas = jdbcTemplate.queryForList("select t.*,rowid from work_order t order by operatetime desc");
//		CreatorFile creatorFile = new CreatorFile();
//		
//		String[] heads = {"workjob_id","title","worker","department","send_time","handle_time","hotspotname","shield_start","shield_end","location","area","ftp","statement","issucced","workjob_type","nasid","finishtime","receipt","include","operatetime","xmltext","localfile","failed_reason","order_user"};
//////		List<Map<String,Object>> datas = new ArrayList<Map<String,Object>>();
//////		Map map = new HashMap();
//////		map.put("1", "A");
//////		map.put("2", "B");
//////		datas.add(map);
////		try {
////			FileOutputStream bo = creatCsv.CreatCsv(heads, datas);
////			System.out.println(bo.toString());
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		
//        if(creatorFile.createExcelFile(heads, datas)) {
//            System.out.println("data.xlsx is created successfully.");
//        }
//        
//
//		
//	}
//	public boolean createExcelFile(String[] heads,List<Map<String,Object>> datas) {
//        boolean isCreateSuccess = false;
//        Workbook workbook = null;
//        try {
//            // XSSFWork used for .xslx (>= 2007), HSSWorkbook for 03 .xsl
////            workbook = new XSSFWorkbook();//HSSFWorkbook();//WorkbookFactory.create(inputStream);
//            workbook = new HSSFWorkbook();
//        }catch(Exception e) {
//            System.out.println("It cause Error on CREATING excel workbook: ");
//            e.printStackTrace();
//        }
//        if(workbook != null) {
//            Sheet sheet = workbook.createSheet("sheet1");
//            Row row0 = sheet.createRow(0);
//            for(int i = 0; i < heads.length; i++) {
//            	Cell cell = row0.createCell(i, Cell.CELL_TYPE_STRING);
//                cell.setCellValue(heads[i]);
//            }
//            for (int rowNum = 1; rowNum < datas.size(); rowNum++) {
//            	Map<String, Object> map = datas.get(rowNum-1);
//                Row row = sheet.createRow(rowNum);
//                for(int i = 0; i <  heads.length; i++) {
//                    Cell cell = row.createCell(i, Cell.CELL_TYPE_STRING);
//                    cell.setCellValue(String.valueOf(map.get(heads[i])).equals("null")?"":String.valueOf(map.get(heads[i])));
//                }
//            }
//            try {
//                FileOutputStream outputStream = new FileOutputStream("F:/data.xls");
//                workbook.write(outputStream);
//                outputStream.flush();
//                outputStream.close();
//                isCreateSuccess = true;
//            } catch (Exception e) {
//                System.out.println("It cause Error on WRITTING excel workbook: ");
//                e.printStackTrace();
//            }
//        }
//        File sss = new File("F:/data.xls");
//        System.out.println(sss.getAbsolutePath());
//        return isCreateSuccess;
//    }
//	
//}
