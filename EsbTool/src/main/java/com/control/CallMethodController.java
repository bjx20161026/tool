package com.control;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;

@Path("/callMethod")
public class CallMethodController {
	Logger logger = Logger.getLogger(CallMethodController.class);
	@GET
	@Path("/sendGet/{many:.*}")
	public Response sendGet(@PathParam("many") String many, @Context HttpServletRequest request) throws Exception {
        Method method = Class.forName(many).getDeclaredMethod(request.getParameter("method"),String.class);
        Object object =  method.invoke(Class.forName(many).newInstance(),request.getParameter("protocol"));
        ResponseBuilder response = Response.ok(object);
		return response.build();
	}
}
