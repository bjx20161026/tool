package com.creatorFile;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		String str = "嘉定汇聚环207环,汇聚环,2-6-二平面汇聚长寿主01/SHCS-6T/A-11-A/PTN7900,,100000.0,二平,嘉定骨干汇聚环01,环,6,38,是,485,18735.387,30432.72634769504,557.8889522222222,557.8889522222222,0.5578889522222222,0.5578889522222222,2977.728467643728,2977.728467643728";
//		String str= "崇明东风接入环,接入环,4-772-崇明长征-1/二平面/PTN7900,4-773-崇明新东风-1/二平面/PTN7900,10000.0,崇明,崇明汇聚环203环,环,1,,否,,0.0,0.09656767859359483,0.0017702666666666667,0.0017702666666666667,1.7702666666666666E-5,1.7702666666666666E-5,,";	
//		String[] strs = str.split(",",-1);
//		int i = 0;
//		for(String st:strs){
//			System.out.println(i+" : "+st);
//			i++;
//		}
//		String str = "This is a test!";
//		OutputStream os = new FileOutputStream("F:/test.txt.gz");
//		os=new GZIPOutputStream(os);
//		OutputStreamWriter osw=new OutputStreamWriter(os);
//		osw.write("This is a test!"); 
//		osw.flush();
//		osw.close();
//		os.close();
//		System.out.println("Task is finised!");
        Map<String,String> map = new HashMap<String,String>();
        map.put("1", "A");
        map.put("1", "B");
        System.out.println(map.get("1"));
	}

}
