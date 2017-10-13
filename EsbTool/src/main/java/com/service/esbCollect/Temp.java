package com.service.esbCollect;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dao.esbCollect.MetaDtMsgRecord;

public class Temp {
	
	public List<Map<String,Object>> list;
	
	public void getList(){
		MetaDtMsgRecord metaDtMsgRecord = new MetaDtMsgRecord();
		list = metaDtMsgRecord.Temp(null, null);
	}
	
	public void deal() throws Exception{
		File file = new File("F:/BAK/EsbTemp.txt");
		InputStream is = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
		String protocol = null;
		MetaDtMsgRecord metaDtMsgRecord = new MetaDtMsgRecord();
		int i = 0;
		String str = "";
		while((protocol=br.readLine())!=null){
			list = metaDtMsgRecord.GetMsgList(protocol, null, null);
			str += list.size()+",";
			System.out.println(i++);
		}
		System.out.println(str);
	}
	
	public static void main(String[] args) throws Exception{
		Temp temp =  new Temp();
		temp.deal();
	}
}
