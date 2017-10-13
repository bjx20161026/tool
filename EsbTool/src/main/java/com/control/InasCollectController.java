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

import com.dao.inasCollect.DmCoBaTaskRecord;
import com.service.download.FileDownLoad;
import com.service.inasCollect.DealPolicyTable;

@Path("/InasCollectd")
public class InasCollectController {
	@GET
	@Path("/getPolicy")
	@Produces("application/json") 
	public List<Map<String,Object>> GetInasPolicy(@Context HttpServletRequest request) throws Exception{
		String type = request.getParameter("TYPE").trim();
		String id = request.getParameter("ID").trim();
		String config = request.getParameter("CONFIG").trim();	
		DealPolicyTable deal = new DealPolicyTable();
		return deal.parse(type, id, config);
	}
	
	@GET
	@Path("/getRecord")
	@Produces("application/json")
	public List<Map<String,Object>> GetInasRecord(@Context HttpServletRequest request) throws Exception{
		String protocol = request.getParameter("PROTOCOL").trim();
		String StartTime = request.getParameter("STARTTIME").trim();
		String EndTime = request.getParameter("ENDTIME").trim();
		DmCoBaTaskRecord dmRecord = new DmCoBaTaskRecord();
		return dmRecord.GetRecord(protocol, StartTime, EndTime);
	}
	
	@GET
	@Path("/GetCollectFile")
	public Response DownloadFileByID(@Context HttpServletRequest request) throws Exception{
		String protocol = request.getParameter("PROTOCOL");
		String fileName = request.getParameter("FILENAME");
		FileDownLoad fileDownLoad = new FileDownLoad();
		ResponseBuilder response = Response.ok(fileDownLoad.DownLoadCollectFile(protocol,fileName).toByteArray());
		response.header("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		return response.build();
	}
}
