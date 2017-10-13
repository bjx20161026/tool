package com.control;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.service.download.FileDownLoad;
import com.service.esbCollect.EsbCollect;


@Path("/EsbCollect")
public class EsbCollectController {
	@GET
	@Path("/getMsgList")
	@Produces("application/json") 
    public List<Map<String,Object>> getMsgList (@Context HttpServletRequest request) throws Exception{
		String protocol = request.getParameter("PROTOCOL").trim();
		String StartTime = request.getParameter("STARTTIME").trim();
		String EndTime = request.getParameter("ENDTIME").trim();
		EsbCollect esbCollect = new EsbCollect();
		return esbCollect.Deal(protocol, StartTime, EndTime);
	}
	
	@GET
	@Path("/GetEsbCollectFile")
	public Response DownloadFileByID(@Context HttpServletRequest request) throws Exception{
		String id = request.getParameter("ID");
		String fileName = request.getParameter("FILENAME");
		FileDownLoad fileDownLoad = new FileDownLoad();
		ResponseBuilder response = Response.ok(fileDownLoad.DownLoadEsbCollectFile(id).toByteArray());
		response.header("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		return response.build();
	}
}
