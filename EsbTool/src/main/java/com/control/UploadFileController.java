package com.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.util.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import com.service.inasCollect.DealConfigFile;  
@Path(value = "file")
public class UploadFileController {
	Logger log = Logger.getLogger(getClass());
	
	    private final String UPLOADED_FILE_PATH = "F:/upload/";
	    @POST
	    @Path(value = "/upload") 
	    @Consumes("multipart/form-data")
	    public Response uploadFile(MultipartFormDataInput input) {
	        String fileName = "";
	        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
	        List<InputPart> inputParts = uploadForm.get("file_upload");
	        for (InputPart inputPart : inputParts) {
	         try {
	            MultivaluedMap<String, String> header = inputPart.getHeaders();
	            fileName = getFileName(header);
	            //convert the uploaded file to inputstream
	            InputStream inputStream = inputPart.getBody(InputStream.class,null);
	            byte [] bytes = IOUtils.toByteArray(inputStream);
	            //constructs upload file path
	            fileName = UPLOADED_FILE_PATH + fileName;
	            writeFile(bytes,fileName);
	          } catch (IOException e) {
	            e.printStackTrace();
	          }
	        }
	        return Response.status(200)
	            .entity("uploadFile is called, Uploaded file name : " + fileName).build();
	    }
	 
	    private String getFileName(MultivaluedMap<String, String> header) {
	        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");
	        for (String filename : contentDisposition) {
	            if ((filename.trim().startsWith("filename"))) {
	                String[] name = filename.split("=");
	                String finalFileName = name[1].trim().replaceAll("\"", "");
	                return finalFileName;
	            }
	        }
	        return "unknown";
	    }
	    
	    //save to somewhere
	    private void writeFile(byte[] content, String filename) throws IOException {
	        File file = new File(filename);
	        if (!file.exists()) {
	            file.createNewFile();
	        }
	        FileOutputStream fop = new FileOutputStream(file);
	        fop.write(content);
	        fop.flush();
	        fop.close();
	    }
	    
	    @POST
		@Path("/upload/multiple")
		@Consumes(MediaType.MULTIPART_FORM_DATA)
		public String uploadMultipleFile(MultipartFormDataInput input) throws IOException{
			Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
			Date now = new Date();
			
			int year = 12;
			int month = 12;
			
			List<InputPart> dbids = uploadForm.get("dbid");
			String dbid = "";
			//获取数据库代号
			for(InputPart inputPart : dbids){
				try {
					dbid = inputPart.getBody(String.class, null);
				} catch (IOException e) {
					e.printStackTrace();
					return "-1";
				}
			}
			if(dbid == null||dbid.equals("")){
				dbid = "Ipmsp";
			}
		       log.info("dbid--->>>"+dbid);
			
			List<InputPart> isinserts = uploadForm.get("isinsert");
			String isinsert = "false";
			//获取是否插入
			for(InputPart inputPart : isinserts){
				try {
					isinsert = inputPart.getBody(String.class, null);
				} catch (IOException e) {
					e.printStackTrace();
					return "-1";
				}
			}
			if(isinsert == null||isinsert.equals("")){
				isinsert = "false";
			}
			 log.info("isinsert--->>>"+isinsert);	
			File file = new File("../upload");
			if(!file.exists()) file.mkdir();
			//获取图片数
			List<InputPart> imageNumParts = uploadForm.get("imageNum");
			int imageNum = 0;
			for(InputPart inputPart : imageNumParts){
				try {
					imageNum = inputPart.getBody(int.class, null);
				} catch (IOException e) {
					e.printStackTrace();
					return "-1";
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i != imageNum; i++){
				
				List<InputPart> imageParts = uploadForm.get("image"+i);
				
				for (InputPart inputPart : imageParts) {
					try {
						MultivaluedMap<String, String> header = inputPart.getHeaders();
						byte[] bytes = IOUtils.toByteArray(inputPart.getBody(InputStream.class, null));//IOUtils来自commons.io
						log.info("上传文件字节大小：" + bytes.length);			
//						File desti = new File(makeFilePath(typeCode, year, month, header));
//						
//						while(desti.exists()){
//							desti = new File(makeFilePath(typeCode, year, month, header));
//						}
//						//来自commons.io包
//						FileUtils.writeByteArrayToFile(desti, bytes);
						
						String fileName = getFileName(header);
						 writeFile(bytes,"../upload/"+fileName);
//						//虚拟路径
//						sb.append("/img/" + typeCode + "/" + year + "/" 
//								+ (month < 10 ? ("0" + month) : month) 
//								+ "/temp/" + desti.getCanonicalPath()
//								.substring(desti.getCanonicalPath().lastIndexOf("\\") + 1));
						 sb.append("../upload/"+fileName);
						if(i !=  imageNum - 1){
							sb.append(',');
						}
						
					} catch (IOException e) {
						e.printStackTrace();
						log.error("上传文件失败!");
						return "-1";
					}
				}
			}
			
			log.info("成功上传文件!");
			log.info("上传成功后返回文件的路径：" + sb.toString());
			String[] filePaths = sb.toString().split(",");
			for(int i = 0;i<filePaths.length;i++){
				DealConfigFile dealConfigFile = new DealConfigFile();
				dealConfigFile.setPath(filePaths[i]);
				dealConfigFile.setIsInsert(isinsert);
				dealConfigFile.setDbid(dbid);
				dealConfigFile.Deal();
			}
			return sb.toString();
		}    
}
