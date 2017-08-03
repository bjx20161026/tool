package com.control;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.test.Test;



@Controller
@RequestMapping("/TestTool")
public class TestToolController {
	Logger logger = Logger.getLogger(EsbUploadController.class);
	
	@Autowired
	Test test;

	@RequestMapping("/CallMethod/{many:.*}")
	public @ResponseBody String CallMethod(@PathVariable(value="many") String many,HttpServletRequest Request) throws Exception{  
//	        Constructor constructor = Class.forName(many).getConstructor();  
//	        Method method = Class.forName(many).getDeclaredMethod("GetMsg",String.class);
//	        method.invoke(Class.forName(many).newInstance(),"DATA.PM.NHM_CPU_MEM_KPI.GCP_APP"); 
		test.GetMsg("123");
		return many;
		
	}
	
//	public static void main(String[] args){
//		  Constructor constructor = Class.forName("").getConstructor(String.class);  
//	        Method method = ((Class) constructor.newInstance("lily")).getDeclaredMethod("test",String.class);
//	}
	
	
	
	
}
