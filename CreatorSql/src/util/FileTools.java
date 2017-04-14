package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class FileTools {
	public static List<String> listFiles(String dir){
		List<String> result=new ArrayList<String>();
		File file=new File(dir);
		File[] fts=file.listFiles();
		for(File ft:fts){
			if(ft.isDirectory()){
				result.addAll(listFiles(ft.getAbsolutePath()));
			}else{
				result.add(ft.getAbsolutePath());
			}
		}
		return result;
	}
	public static void main(String[] args){
//		FileTools ls=new FileTools();
		List<String> strs=FileTools.listFiles("C:/Users/BJX/Desktop/亚信");
		for(String str:strs)
			System.out.println(str);
	}
}
