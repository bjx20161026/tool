package com.creatorFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Tewet {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception{
		File file = new File("F:/test.txt");
		FileInputStream is = new FileInputStream(file);
		BufferedReader br=new BufferedReader(new InputStreamReader(is,"gbk"));
		System.out.println(br.readLine());
	}
}
