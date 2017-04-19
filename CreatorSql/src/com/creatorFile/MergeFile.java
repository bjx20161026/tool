package com.creatorFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.FileTools;

public class MergeFile {
	String newfile;
	String fn;
	String filePath;
	public String getNewfile() {
		return newfile;
	}
	public void setNewfile(String newfile) {
		this.newfile = newfile;
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public void CreatCsv() throws Exception{
		File file = new File(newfile);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		List<String> names=FileTools.listFiles(filePath);

		for(String path:names){

			 String path2=path.substring(path.lastIndexOf("\\")+1);
		     System.out.println(path2);
			 Pattern p = Pattern.compile(fn,Pattern.CASE_INSENSITIVE|Pattern.MULTILINE);  
		     Matcher matcher = p.matcher(path2);  
		     if(!matcher.find()){
		    	 continue;
		     }
		     System.out.println(path);
		     InputStream is = new FileInputStream(path);
		     BufferedReader br=new BufferedReader(new InputStreamReader(is,"gbk"));
		     String temp;
		     br.readLine();
		     while((temp=br.readLine())!=null){
		    	 temp+="\r\n";
//		    	 fw.write(temp);
		    	 bw.write(temp);
		     }
		}	
		bw.flush();
		bw.close();
	}
	public static void main(String[] args){
		MergeFile toOneCsv = new MergeFile();
		toOneCsv.setFilePath("F:/3月数据");
//		toOneCsv.setNewfile("F:拆机.csv");
//		toOneCsv.setFn("HB_NRTM_DetachOrder_SH_(.*?).csv");
//		toOneCsv.setNewfile("F:移机.csv");
//		toOneCsv.setFn("HB_NRTM_MoveOrder_SH_(.*?).csv");
		toOneCsv.setNewfile("F:装机.csv");
		toOneCsv.setFn("HB_NRTM_InstallOrder_SH_(.*?).csv");
		try {
			toOneCsv.CreatCsv();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
