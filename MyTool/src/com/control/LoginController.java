package com.control;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.sys.LoginInformation;

@Controller
@RequestMapping("/login")
public class LoginController {
	Logger logger = Logger.getLogger(getClass());
	@Autowired
	LoginInformation login;
	
	@RequestMapping(value="/getPassword",method=RequestMethod.GET)
	public @ResponseBody String GetPassword(HttpServletRequest request){
		return login.GetPassword(request.getParameter("name"));
	}
	
	public @ResponseBody String SetAccount(HttpServletRequest request){
		try {
			login.SetAccount(request.getParameter("name"), request.getParameter("password"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Operate failed :"+e.getMessage();
		}
		return "Operate Succeed!";
	}
}
