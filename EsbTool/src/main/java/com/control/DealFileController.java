package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.service.bigFile.BigFile;
import com.service.bigFile.RemoteBigFile;
import com.service.download.FileDownLoad;

@Path("/dealFile")
public class DealFileController {
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
	public Response RemoteFile(@Context HttpServletRequest request) throws Exception{
		RemoteBigFile remoteBigFile = new RemoteBigFile();
		String protocol = request.getParameter("protocol").trim();
		int startLine = Integer.parseInt(request.getParameter("startLine"));
		int endLine = Integer.parseInt(request.getParameter("endLine"));
		String day = request.getParameter("day");
		remoteBigFile.setStartLine(startLine);
		remoteBigFile.setEndLine(endLine);
		ResponseBuilder response = Response.ok(remoteBigFile.Read(protocol,day));
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
}