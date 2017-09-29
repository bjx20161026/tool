package com.control;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

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
		return null;
	}
}
