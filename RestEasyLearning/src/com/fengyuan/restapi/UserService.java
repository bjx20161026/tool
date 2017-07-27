package com.fengyuan.restapi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.hw.sml.tools.Https;

import com.fengyuan.HttpRequest;
import com.fengyuan.domain.User;

@Path("/userservice") // 服务路径
public class UserService {
	/**
	 * 初始化三个用户数据，存入map中，key为用户id，value为用户对象
	 */
	static Map<Integer, User> userMap = new HashMap<>();
	static {
		User user1 = new User("Lee", 24, "138***");
		userMap.put(1, user1);
		User user2 = new User("Cathy", 25, "188***");
		userMap.put(2, user2);
		User user3 = new User("Aaron", 26, "186***");
		userMap.put(3, user3);
	}

	/**
	 * 获取指定id的用户
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/user/{id}") // 具体服务的路径, id是入参
	@Produces("application/json") // 返回的格式
	public User getById(@PathParam("id") Integer id) {
		return (User) userMap.get(id);
	}

	/**
	 * 以json格式返回所有用户
	 * 
	 * @return
	 */
	@GET
	@Path("/users")
	@Produces("application/json;")
	public String getUsers() {
		return HttpRequest.sendGet(
				"http://localhost:8080/WlanOrderAutomatic/rest/workOrder/getOrderByCondition?limit=10&start=9", "");
	}

	@GET
	@Path("/abc")
	public Response getFile(@Context HttpServletRequest request) throws Exception {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();

		String result = Https
				.newGetHttps(
						"http://192.168.1.121:8080/WlanOrderAutomatic/rest/workOrder/export?title=asdfa&exportType=csv")
				.bos(bo).execute();
		// ByteArrayOutputStream bo = ByteArrayOutputStream(os);
		ResponseBuilder response = Response.ok(bo.toByteArray());
		String dfileName = new String(request.getParameter("title").getBytes("iso-8859-1"), "utf-8") + "."
				+ request.getParameter("exportType");
		if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
			dfileName = new String(dfileName.getBytes("utf-8"), "ISO8859-1"); // firefox浏览器
		} else if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0
				|| request.getHeader("User-Agent").toLowerCase().indexOf("rv:11.0") > 0) {
			dfileName = URLEncoder.encode(dfileName, "UTF-8");// IE浏览器
		} else if (request.getHeader("User-Agent").toUpperCase().indexOf("CHROME") > 0) {
			dfileName = new String(dfileName.getBytes("utf-8"), "ISO8859-1");// 谷歌
		}
		response.header("Content-Disposition", "attachment; filename=\"" + dfileName + "\"");
		return response.build();
	}

	@GET
	@Path("/abc2")
	public Response getFile2(@Context HttpServletRequest request) throws Exception {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		String dfileName = "";
		String urlNameString = "http://192.168.1.121:8080/WlanOrderAutomatic/rest/workOrder/export?title=测试&exportType=csv";
		URL realUrl = new URL(urlNameString);
		HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("user-agent", request.getHeader("User-Agent"));
		connection.setDoInput(true);
		connection.setConnectTimeout(5000);
		connection.connect();
		Map<String, List<String>> map = connection.getHeaderFields();
		for (String key : map.keySet()) {
			System.out.println(key + "--->" + map.get(key));
			List<String> Disposition = map.get("Content-Disposition");
			for (String str : Disposition) {
				if (str.indexOf("filename=\"") > -1) {
					dfileName = str.substring(str.indexOf("filename=\"") + "filename=\"".length(),
							str.lastIndexOf("\""));
				}
			}
		}
		InputStream bis = connection.getInputStream();// ByteArrayOutputStream
		int c = bis.read();// 读取bis流中的下一个字节
		while (c != -1) {
			bo.write(c);
			c = bis.read();
		}
		bis.close();
		ResponseBuilder response = Response.ok(bo.toByteArray());
		response.header("Content-Disposition", "attachment; filename=\"" + dfileName + "\"");
		return response.build();
	}
	
	@GET
	@Path("/sendGet")
	public Response sendGet(@Context HttpServletRequest request) throws Exception {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		String urlNameString = "http://localhost:8080/WlanOrderAutomatic/rest/workOrder/getOrderByCondition?limit=10&start=9";
		URL realUrl = new URL(urlNameString);
		HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("user-agent", request.getHeader("User-Agent"));
		connection.setDoInput(true);
		connection.setConnectTimeout(5000);
		connection.connect();
		Map<String, List<String>> map = connection.getHeaderFields();
		InputStream is = connection.getInputStream();// ByteArrayOutputStream
		int c = is.read();// 读取bis流中的下一个字节
		while (c != -1) {
			bo.write(c);
			c = is.read();
		}
		is.close();
		ResponseBuilder response = Response.ok("asdfa");
        response.header("Content-Type",map.get("Content-Type").get(0));
		return response.build();
	}
}
