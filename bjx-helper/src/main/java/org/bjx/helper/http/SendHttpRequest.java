package org.bjx.helper.http;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * @author b j x
 * @Description Sending a HTTP request, there are two ways of get and post; In
 *              the returned Map, the fileName is not empty, which indicates
 *              that the return is a file flow, otherwise it is the other data
 *              type
 */

public class SendHttpRequest {

	Logger logger = Logger.getLogger(SendHttpRequest.class);

	private String url;

	private String content_Type = "application/json;charset=UTF-8";

	private String body;

	public Map<String,Object> sendGet() throws Exception {
		logger.info(String.format("Send [%s] httpRequest for url [%s]", "Get",url));
		Map<String,Object> resultMap = new HashMap<String, Object>();
		URL realUrl = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
		connection.setRequestMethod("GET");
		connection.setDoInput(true);
		connection.setConnectTimeout(5000);
		connection.connect();
		Map<String, List<String>> map = connection.getHeaderFields();
		InputStream is = connection.getInputStream();
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		if (map.get("Content-Type").get(0).toLowerCase().indexOf("stream") > -1) {
			int c = is.read();
			while (c != -1) {
				bo.write(c);
				c = is.read();
			}
			is.close();
			String disposition = map.get("Content-Disposition").get(0);
			String fileName = disposition.substring(disposition.indexOf("filename=\"") + "filename=\"".length(),disposition.lastIndexOf("\""));
			resultMap.put("fileBytes", bo.toByteArray());
			resultMap.put("fileName", fileName);
		} else {
			String result = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			resultMap.put("resultString", result);
		}
		return resultMap;
	}

	public Map<String, Object> sendPost() throws Exception {
		logger.info(String.format("Send [%s] httpRequest for url [%s]", "Post",url));
		Map<String,Object> resultMap = new HashMap<String, Object>();
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		PrintWriter out = null;
		URL realUrl = new URL(url);
		URLConnection connection = realUrl.openConnection();
		connection.setRequestProperty("Content-Type", content_Type);
		connection.setRequestProperty("connection", "Keep-Alive");
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.connect();
		out = new PrintWriter(connection.getOutputStream());
		out.print(body);
		out.flush();
		Map<String, List<String>> map = connection.getHeaderFields();
		InputStream is = connection.getInputStream();// ByteArrayOutputStream
		if (map.get("Content-Type").get(0).toLowerCase().indexOf("stream") > -1) {
			int c = is.read();
			while (c != -1) {
				bo.write(c);
				c = is.read();
			}
			is.close();
			String disposition = map.get("Content-Disposition").get(0);
			String fileName = disposition.substring(disposition.indexOf("filename=\"") + "filename=\"".length(),disposition.lastIndexOf("\""));
			resultMap.put("fileBytes", bo.toByteArray());
			resultMap.put("fileName", fileName);
		} else {
			String result = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			resultMap.put("resultString", result);
		}
		return resultMap;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent_Type() {
		return content_Type;
	}

	public void setContent_Type(String content_Type) {
		this.content_Type = content_Type;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
