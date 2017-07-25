package com.service.esbCollect.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.service.esbCollect.EsbCollect;
import com.service.util.common.FileTools;
import com.service.util.common.MyDate;
import com.service.util.excle.CreatorFile;
import com.service.util.word.GetWordText;

public class EsbCollectImpl implements EsbCollect {
	String str;

	@Override
	public File DownLoadFtpFile(String url) {
		// TODO Auto-generated method stub
//		FileOperate fo = new FileOperate(url);
		return null;
	}

	@Override
	public String WordTextToExcel(String path) {
		// TODO Auto-generated method stub
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map;
		List<String> listFiles = FileTools.listFiles(path);
		GetWordText getWordText = new GetWordText();
		for(String filepath:listFiles){
			try {
				map=new HashMap<String,String>();
				str = getWordText.getWordText(filepath);
				str=  str.substring(str.lastIndexOf("服务编码服务编码")+"服务编码服务编码".length(), str.lastIndexOf("服务编码命名规则")).trim();
				map.put("filepath", filepath.substring(filepath.lastIndexOf("\\")+1,filepath.length()));
				map.put("protocol", str);
				list.add(map);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		CreatorFile creatorFile = new CreatorFile();
		String[] heads = {"filepath","protocol"};
		String[] head={"文件路径","规约"};
		try {
			byte[] bytes = creatorFile.createExcelFile(heads, head, list, "xlsx");
			MyDate myDate = new MyDate();
			String dateString = myDate.getDayString(0);
			File wordtext = FileTools.CtreatFile("F:/EsbCollect/"+dateString+"/WordTextToExcel.xlsx");
			FileOutputStream cfo = new FileOutputStream(wordtext);
			cfo.write(bytes);
			cfo.flush();
			cfo.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args){
		EsbCollect  esbCollect  = new EsbCollectImpl();
		esbCollect.WordTextToExcel("D:/INAS/DocumentLib/SH/2015RD30_Managed_IPMS_SH/4Requirement/4-4需求接口/东信-共享平台/处理共享接口/ESB服务规约");
	
	}
	
}
