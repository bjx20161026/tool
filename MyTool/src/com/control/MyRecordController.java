package com.control;

import java.net.URLEncoder;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.mapping.FastCollectRecord;
import com.dao.mapping.dm_co_ba_cfg_task_mng;
import com.service.fastCollect.MyRecord;
import com.service.fastCollect.impl.GetConfig;
import com.service.fastCollect.impl.GetTask;
import com.service.util.common.MyDate;

@Controller
@RequestMapping("/MyRecord")
public class MyRecordController {
	Logger logger = Logger.getLogger(MyRecordController.class);
	@Autowired
	MyRecord myRecord;
	@Autowired
	GetConfig getConfig;
	@Autowired
	GetTask getTask;
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody List<FastCollectRecord> Test() throws ParseException {
		logger.info("test");
		MyDate myDate = new MyDate();
		myRecord.setEnd(myDate.getDay(0));
		myRecord.setBegin(myDate.getDay(-1));
		return myRecord.GetRecord();
	}
	@RequestMapping(value="/CreatLocalFiles",method=RequestMethod.GET)
	public @ResponseBody String CreatLocalFiles() throws Exception{
		myRecord.CteatLocalFile();
		return "处理完成！";
	}
	
	
	@RequestMapping(value="/CountActual",method = RequestMethod.GET)
	public @ResponseBody Map<String,Integer> CountActual() throws Exception{
		logger.info("CountActual");
		MyDate myDate = new MyDate();
		myRecord.setEnd(myDate.getDay(0));
		myRecord.setBegin(myDate.getDay(-1));
		return myRecord.CountActual(myRecord.GetRecord());
	}
	@RequestMapping(value="/CountTheory",method = RequestMethod.GET)
	public @ResponseBody Map<String,String> CountTheory() throws Exception{
		logger.info("CountTheory");
		System.out.println(getConfig.GetConfigs().size());
		return getConfig.CountTheory(getConfig.GetConfigs());
	}
	@RequestMapping(value="/GetTasks",method=RequestMethod.GET)
	public @ResponseBody List<dm_co_ba_cfg_task_mng> GetTask(){
		logger.info("GetTasks");
		return getTask.GetTasks("esb://%");
	}
	@RequestMapping(value = "/export", produces = "application/octet-stream;charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<byte[]> export(HttpServletRequest  request) throws Exception {
		String dfileName ="esbRecord.csv";
		if (request.getHeader("User-Agent").toLowerCase()  
	               .indexOf("firefox") > 0) {  
			dfileName = new String(dfileName.getBytes("utf-8"), "ISO8859-1"); // firefox浏览器  
	        } else if (request.getHeader("User-Agent").toUpperCase()  
	                .indexOf("MSIE") > 0||request.getHeader("User-Agent").toLowerCase()  
	                .indexOf("rv:11.0") > 0) {  
	        	dfileName = URLEncoder.encode(dfileName, "UTF-8");// IE浏览器  
	       }else if (request.getHeader("User-Agent").toUpperCase()  
	                .indexOf("CHROME") > 0) {  
	    	   dfileName = new String(dfileName.getBytes("utf-8"), "ISO8859-1");// 谷歌  
	        } 
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", dfileName);
		return new ResponseEntity<byte[]>(myRecord.ExcelCreator("esb"), headers, HttpStatus.OK);
	}

}
