package com.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.esbUpload.EsbUpload;

@Controller
@RequestMapping("/EsbUpload")
public class EsbUploadController {
	Logger logger = Logger.getLogger(EsbUploadController.class);
	@Autowired
	EsbUpload esbUpload;
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody List<Map<String,Object>> Test() {
		logger.info("test");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", "总量");
		List<Integer> ls = new ArrayList<Integer>();
		ls.add(7989);
		ls.add(7988);
		ls.add(7900);
		ls.add(7989);
		
		ls.add(7900);
		ls.add(7900);
		ls.add(7900);
		ls.add(7989);
		
		ls.add(7900);
		ls.add(7985);
		ls.add(7989);
		ls.add(7988);
		map.put("data", ls);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(map);
		return list;
	}
	
	@RequestMapping(value = "/CreatUploadConfig", method = RequestMethod.GET)
	public @ResponseBody String CreatUploadConfig(HttpServletRequest Request) throws Exception {
		String path = Request.getParameter("path");
		return esbUpload.CreatUploadConfig(path);	
	}
}
