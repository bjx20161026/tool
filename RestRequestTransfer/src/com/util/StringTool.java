package com.util;

public class StringTool {
	public static String SubIndexString(String str, String target, int first, int last) {
		for (int i = 0; i < first; i++) {
			if (str.indexOf(target) > -1)
				str = str.substring(str.indexOf(target) + target.length(), str.length());
		}
		String temp = "";
		for (int i = 0; i < last - first; i++) {
			if (str.indexOf(target) > -1) {
				if (i > 0)	temp += target;
				temp += str.substring(0, str.indexOf(target));
				str = str.substring(str.indexOf(target) + target.length(), str.length());
			}
		}
		return temp;
	}
	public static String SubIndexString(String str, String target, int first) {
		for (int i = 0; i < first; i++) {
			if (str.indexOf(target) > -1)
				str = str.substring(str.indexOf(target) + target.length(), str.length());
		}
		return str;
	}

	public static void main(String[] args) {
		System.out.println(StringTool.SubIndexString("/httptool/sendGet/workOrder/", "/", 2, 4));
	}

}
