package com.creatorFile;

import java.util.Date;

public class TEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Date().toString());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("2");
	}

}
