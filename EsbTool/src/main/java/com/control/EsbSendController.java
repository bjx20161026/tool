package com.control;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import com.dao.MetaDtMsgSendRecord;
@Path("/EsbSend")
public class EsbSendController {
	@GET
	@Path("/getMsg")
	@Produces("application/json") 
	public List<Map<String,Object>> GetEsbSendMsg(@Context HttpServletRequest request){
		MetaDtMsgSendRecord metaDtMsgSendRecord = new MetaDtMsgSendRecord();
		return metaDtMsgSendRecord.getRecord("DW", "1");
	}
}
