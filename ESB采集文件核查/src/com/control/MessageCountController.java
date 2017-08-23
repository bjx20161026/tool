package com.control;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.service.messageCount.CountDay;
import com.service.messageCount.CountShare;

@Path("/MessageCount")
public class MessageCountController {
	Logger logger = Logger.getLogger(MessageCountController.class);
	
	@GET
	@Path("/daySeries")
	@Produces("application/json") 
    public List<Map<String,Object>> CountDaySeries(){
		CountDay countDay = new CountDay();
		return countDay.Series();
    }
	
	@GET
	@Path("/dayXAxis")
	@Produces("application/json") 
	public Map<String, Object> CountDayXAxis(){
		CountDay countDay = new CountDay();
		return countDay.Categories();
	}
	
	@GET
	@Path("/shareSeries")
	@Produces("application/json") 
    public List<Map<String,Object>> CountShareSeries(){
		CountShare countShare = new CountShare();
		return countShare.Series();
    }
	
	@GET
	@Path("/shareXAxis")
	@Produces("application/json") 
	public Map<String, Object> CountShareXAxis(){
		CountShare countShare = new CountShare();
		return countShare.Categories();
	}
	
}
