package com.control;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import com.dao.MetaDtMsgSendRecord;
import com.service.esbSendMsg.SendMsgRecord;
@Path("/EsbSend")
public class EsbSendController {
	@GET
	@Path("/getMsg")
	@Produces("application/json") 
	public List<Map<String,Object>> GetEsbSendMsg(@Context HttpServletRequest request) throws Exception{
		SendMsgRecord sendMsgRecord = new SendMsgRecord();
		String protocol = request.getParameter("protocol").trim();
		String day = request.getParameter("day").trim();
		return sendMsgRecord.getMsgRecord(protocol, day);
	}
}
