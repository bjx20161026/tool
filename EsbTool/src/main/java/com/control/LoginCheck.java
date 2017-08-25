package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.service.login.LoginInfo;

@Path("/login")
public class LoginCheck {
	@GET
	@Path("/getPassword")
	public Response getPassword(@Context HttpServletRequest request){
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		LoginInfo loginInfo = new LoginInfo();
		int isTrue = 0;
		String pass = loginInfo.GetPassWord(name);
		System.out.println("pass--->>>"+pass);
		System.out.println("password--->>>"+password);
		if(pass!=null&&password!=null&&pass.equals(password)){
			isTrue = 1;
		}
		ResponseBuilder response = Response.ok(isTrue);
		return response.build();
	}
}
