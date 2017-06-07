package com.control;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.fastCollect.FastCollect;

@Controller
@RequestMapping("/FastCollect")
public class FastCollectController {
	Logger logger = Logger.getLogger(EsbUploadController.class);
	@Autowired
	FastCollect fastCollect;
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody String Test() {
		logger.info("test");
		return "这是一个测试的首页，会不断地进行丰富";
	}
	
	@RequestMapping(value = "/CreatFastCollectConfig", method = RequestMethod.GET)
	public @ResponseBody String CreatUploadConfig(HttpServletRequest Request) throws Exception {
		String path = Request.getParameter("path");
		return fastCollect.CreatFastCollectConfig(path);	
	}
}
