package com.creatorFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import util.FileTools;

public class ChangeFileName {
	public static void main(String[] args) throws Exception {
		List<String> strs = FileTools.listFiles("F:/jiakuan");
		for (String path : strs) {
			System.out.println("path: " + path);
			InputStream is = new FileInputStream(path);
			String fileName = path.replace(".CSV", "_P01_END.CSV");
			fileName = fileName.replace("jiakuan", "jiakuan2");
			File file = new File(fileName);
			FileOutputStream fos = new FileOutputStream(fileName);
			byte[] b = new byte[1024];
			while ((is.read(b)) != -1) {
				fos.write(b);
			}
			is.close();
			fos.close();
		}
		System.out.println("处理完成");
	}
}
