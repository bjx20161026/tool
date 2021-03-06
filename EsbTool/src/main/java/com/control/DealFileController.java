package com.control;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;

import com.service.bigFile.BigFile;
import com.service.bigFile.RemoteBigFile;
import com.service.download.FileDownLoad;

@Path("/dealFile")
public class DealFileController {
	Logger logger = Logger.getLogger(DealFileController.class);
	@GET
	@Path("/local")
	public Response OpenLocalFile(@Context HttpServletRequest request) throws Exception{
		BigFile bigFile = new BigFile();
		String path = request.getParameter("path");
		int startLine = Integer.parseInt(request.getParameter("startLine"));
		int endLine = Integer.parseInt(request.getParameter("endLine"));
		String charset = request.getParameter("charset");
		bigFile.setCharset(charset);
		bigFile.setStartLine(startLine);
		bigFile.setEndLine(endLine);
		ResponseBuilder response = Response.ok(bigFile.ReadBigFile(path));
		return response.build();
	}
	
	@GET
	@Path("/remote")
	@Produces("text/plain; charset=utf-8")  
	public Response RemoteFile(@Context HttpServletRequest request) throws Exception{
		RemoteBigFile remoteBigFile = new RemoteBigFile();
		String protocol = request.getParameter("protocol").trim();
		int startLine = Integer.parseInt(request.getParameter("startLine"));
		int endLine = Integer.parseInt(request.getParameter("endLine"));
		String day = request.getParameter("day");
		remoteBigFile.setStartLine(startLine);
		remoteBigFile.setEndLine(endLine);
		String str = remoteBigFile.Read(protocol,day);
		logger.info("打开远程文件--->>>"+str);
		ResponseBuilder response = Response.ok(str);
		return response.build();
	}
	@GET
	@Path("/download")
	public Response DownloadFile(@Context HttpServletRequest request) throws Exception{
		String protocol = request.getParameter("protocol").trim();
		String day = request.getParameter("day");
		FileDownLoad fileDownLoad = new FileDownLoad();
		ResponseBuilder response = Response.ok(fileDownLoad.DownLoad(protocol, day).toByteArray());
		String dfileName = fileDownLoad.getFileName();
		response.header("Content-Disposition", "attachment; filename=\"" + dfileName + "\"");
		return response.build();
	}
	@GET
	@Path("/downloadbyid")
	public Response DownloadFileByID(@Context HttpServletRequest request) throws Exception{
		String id = request.getParameter("ID");
		FileDownLoad fileDownLoad = new FileDownLoad();
		ResponseBuilder response = Response.ok(fileDownLoad.DownLoadById(id).toByteArray());
		String dfileName = fileDownLoad.getFileName();
		response.header("Content-Disposition", "attachment; filename=\"" + dfileName + "\"");
		return response.build();
	} 
	
	@GET
	@Path("/downloadftpmodle")
	public Response DownloadFtpModle() throws Exception{
		File file = new File("../upload/ftpTemplate.xlsx");
		InputStream is = new FileInputStream(file);
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		int c = is.read();
		while (c != -1) {
			bo.write(c);
			c = is.read();
		}
		is.close();
		ResponseBuilder response = Response.ok(bo.toByteArray());
		String dfileName = "FtpDownLoadTemplet.xlsx";
		response.header("Content-Disposition", "attachment; filename=\"" + dfileName + "\"");
		return response.build();
	}
	
	@GET
	@Path("/downloadftprecord")
	public Response DownloadFtpRecord() throws Exception{
		File file = new File("../record/FTPconfigRecord.xlsx");
		InputStream is = new FileInputStream(file);
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		int c = is.read();
		while (c != -1) {
			bo.write(c);
			c = is.read();
		}
		is.close();
		ResponseBuilder response = Response.ok(bo.toByteArray());
		String dfileName = "FTPconfigRecord.xlsx";
		response.header("Content-Disposition", "attachment; filename=\"" + dfileName + "\"");
		return response.build();
	}
	
	
}
