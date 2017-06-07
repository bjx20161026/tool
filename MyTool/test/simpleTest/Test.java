package simpleTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("F:/test2.csv");
		InputStreamReader isr = new InputStreamReader(is, "GBK");
		BufferedReader br = new BufferedReader(isr);
		String temp;
		while ((temp = br.readLine()) != null) {
			String[] tempss = temp.split(",");
			for (String temps : tempss) {
				if (temps.contains("\"")) {
					temps = temps.replace("\"", "\"\"");
					temps = "\"" + temps + "\"";
				}
				System.out.println(temps);
			}
		}
	}

	/*
	 * 生成csv时的转义处理
	 */
	public String toStandardCsv(String temp, String separator) {
		int flag = 0;
		if (temp.contains("\"")) {
			temp = temp.replace("\"", "\"\"");
			temp = "\"" + temp + "\"";
			flag = 1;
		}
		if (flag == 0 && temp.contains(separator)) {
			temp = "\"" + temp + "\"";
		}
		return temp;
	}
}
