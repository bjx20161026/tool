package com.control;

import java.io.IOException;

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
	public @ResponseBody String Test() {
		logger.info("test");
		return "这是一个测试的首页，会不断地进行丰富";
	}
	
	@RequestMapping(value = "/CreatUploadConfig", method = RequestMethod.GET)
	public @ResponseBody String CreatUploadConfig(HttpServletRequest Request) throws IOException {
		String path = Request.getParameter("path");
		return esbUpload.CreatUploadConfig(path);	
	}
}
