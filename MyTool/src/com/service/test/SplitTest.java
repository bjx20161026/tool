package com.service.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SplitTest {
	
	public static void main(String[] args) throws IOException {
		File file = new File("F:/test.txt");
		InputStream is = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"gbk"));
		String a = br.readLine();
		String[] as = a.split("\t");
		System.out.println(as[1]);
		System.out.println(as[2]);
		System.out.println("\\t");
	}
}
