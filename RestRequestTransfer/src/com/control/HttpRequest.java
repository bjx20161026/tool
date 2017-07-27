package com.control;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
	public Response sendGet(@PathParam("many") String  many,@Context HttpServletRequest request) throws Exception {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		String urlNameString = UrlTransfer(request,many);
		URL realUrl = new URL(urlNameString);
		HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("user-agent", request.getHeader("User-Agent"));
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
	public Response sendPost(@PathParam("many") String  many,@Context HttpServletRequest request,String data){
		System.out.println(data);
		 PrintWriter out = null;
	        BufferedReader in = null;
	        String result = "";
	        try {
	            URL realUrl = new URL("http://localhost:8080/WlanOrderAutomatic/rest/workOrder/handleOrders");
	            // 打开和URL之间的连接
	            URLConnection conn = realUrl.openConnection();
	            // 设置通用的请求属性
	            conn.setRequestProperty("accept", "*/*");
	            conn.setRequestProperty("connection", "Keep-Alive");
	            conn.setRequestProperty("user-agent",
	                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	            // 发送POST请求必须设置如下两行
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            // 获取URLConnection对象对应的输出流
	            out = new PrintWriter(conn.getOutputStream());
	            // 发送请求参数
	            
	            out.print(data);
	            // flush输出流的缓冲
	            out.flush();
	            // 定义BufferedReader输入流来读取URL的响应
	            in = new BufferedReader(
	                    new InputStreamReader(conn.getInputStream()));
	            String line;
	            while ((line = in.readLine()) != null) {
	                result += line;
	            }
	        } catch (Exception e) {
	            System.out.println("发送 POST 请求出现异常！"+e);
	            e.printStackTrace();
	        }
	        //使用finally块来关闭输出流、输入流
	        finally{
	            try{
	                if(out!=null){
	                    out.close();
	                }
	                if(in!=null){
	                    in.close();
	                }
	            }
	            catch(IOException ex){
	                ex.printStackTrace();
	            }
	        }
	        return null;
	}

	public String UrlTransfer(HttpServletRequest request,String many) {
		Properties pro = FileTools.getProperties("TargetURL.properties");
		String target = pro.getProperty(StringTool.SubIndexString(many, "/", 0, 1));
		String url= target + many;
		if((request.getQueryString())!=null)
				url+="?" + (request.getQueryString());
		logger.info("HttpUrl:"+url);
		return url;
	}
}
