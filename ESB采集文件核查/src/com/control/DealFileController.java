package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.service.bigFile.BigFile;
import com.service.bigFile.RemoteBigFile;

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
		remoteBigFile.setStartLine(startLine);
		remoteBigFile.setEndLine(endLine);
		ResponseBuilder response = Response.ok(remoteBigFile.Read(protocol));
		return response.build();
	}
}
