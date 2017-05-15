package com.service.esbUpload;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.service.util.excle.ReadExcle;

public class EsbUploadTest {
	public String[] toStrings(String str) {
		String[] strs = str.split(",");
		strs[0] = strs[0].substring(1).trim();
		int length = strs.length;
		for (int i = 1; i < length - 1; i++) {
			strs[i] = strs[i].trim();
		}
		strs[length - 1] = strs[length - 1].substring(0, strs[length - 1].length() - 1).trim();
		return strs;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadExcle readExcle = new ReadExcle();
		try {
			List<Map<String, String>> list = readExcle.readExcel(
					"C:/Users/BJX/Desktop/文件夹/亚信/飞思达/DW_FT_SE_BB_SQM_TV_ALARM_H/DW_FT_SE_BB_SQM_TV_ALARM_H.xlsx");
			String str = list.get(0).get("heads");
			System.out.println("获取一个不存在的map："+list.get(0).get("bcz"));
			System.out.println(str);
			String[] strs = str.split(",");
			strs[0] = strs[0].substring(1).trim();
			int length = strs.length;
			for (int i = 1; i < length - 1; i++) {
				strs[i] = strs[i].trim();
			}
			strs[length - 1] = strs[length - 1].substring(0, strs[length - 1].length() - 1).trim();
			for (String st : strs) {
				System.out.println(st);
			}
			System.out.println(JSON.toJSON(list));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
