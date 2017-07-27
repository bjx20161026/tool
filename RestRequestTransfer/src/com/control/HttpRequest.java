package com.control;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;

import com.util.FileTools;
import com.util.StringTool;

@Path("/httptool") // 服务路径
public class HttpRequest {
	Logger logger = Logger.getLogger(HttpRequest.class);

	@GET
	@Path("/sendGet/{many:.*}")
	public Response sendGet(@PathParam("many") String many, @Context HttpServletRequest request) throws Exception {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		String urlNameString = UrlTransfer(request, many);
		URL realUrl = new URL(urlNameString);
		HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("User-Agent", request.getHeader("User-Agent"));
		connection.setDoInput(true);
		connection.setConnectTimeout(5000);
		connection.connect();
		Map<String, List<String>> map = connection.getHeaderFields();
		ResponseBuilder response = null;
		InputStream is = connection.getInputStream();// ByteArrayOutputStream
		if (map.get("Content-Type").get(0).toLowerCase().indexOf("stream") > -1) {
			int c = is.read();
			while (c != -1) {
				bo.write(c);
				c = is.read();
			}
			is.close();
			response = Response.ok(bo.toByteArray());
			String disposition = map.get("Content-Disposition").get(0);
			String dfileName = disposition.substring(disposition.indexOf("filename=\"") + "filename=\"".length(),
					disposition.lastIndexOf("\""));
			response.header("Content-Disposition", "attachment; filename=\"" + dfileName + "\"");
		} else {
			String result = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			response = Response.ok(result);
		}
		response.header("Content-Type", map.get("Content-Type").get(0));
		return response.build();
	}

	@POST
	@Path("/sendPost/{many:.*}")
	public Response sendPost(@PathParam("many") String many, @Context HttpServletRequest request, String data)
			throws Exception {
		logger.info("PostBody---->>>"+data);
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		PrintWriter out = null;
		String urlNameString = UrlTransfer(request, many);
		URL realUrl = new URL(urlNameString);
		URLConnection connection = realUrl.openConnection();
		connection.setRequestProperty("User-Agent", request.getHeader("User-Agent"));
		connection.setRequestProperty("Content-Type", request.getHeader("Content-Type"));
		connection.setRequestProperty("connection", "Keep-Alive");
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.connect();
		out = new PrintWriter(connection.getOutputStream());
		out.print(data);
		out.flush();
		Map<String, List<String>> map = connection.getHeaderFields();
		ResponseBuilder response = null;
		InputStream is = connection.getInputStream();// ByteArrayOutputStream
		if (map.get("Content-Type").get(0).toLowerCase().indexOf("stream") > -1) {
			int c = is.read();
			while (c != -1) {
				bo.write(c);
				c = is.read();
			}
			is.close();
			response = Response.ok(bo.toByteArray());
			String disposition = map.get("Content-Disposition").get(0);
			String dfileName = disposition.substring(disposition.indexOf("filename=\"") + "filename=\"".length(),
					disposition.lastIndexOf("\""));
			response.header("Content-Disposition", "attachment; filename=\"" + dfileName + "\"");
		} else {
			String result = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			response = Response.ok(result);
		}
		response.header("Content-Type", map.get("Content-Type").get(0));
		return response.build();
	}

	public String UrlTransfer(HttpServletRequest request, String many) {
		Properties pro = FileTools.getProperties("TargetURL.properties");
		String target = pro.getProperty(StringTool.SubIndexString(many, "/", 0, 1));
		String url = target + many;
		if ((request.getQueryString()) != null)
			url += "?" + (request.getQueryString());
		logger.info("HttpUrl:" + url);
		return url;
	}
}
