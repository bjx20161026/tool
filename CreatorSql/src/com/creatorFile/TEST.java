package com.creatorFile;

import java.util.Date;

public class TEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(new Date().toString());
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("2");
		String str = "DATA.RM.DW_FT_RE_ST_PTN_NNI_PORT_15M.PAS_APP";
		System.out.println(str.substring(8, str.indexOf(".",10)));
		System.out.println(str.indexOf(".",5));
	}

}
