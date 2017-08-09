package util.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTools {
	public SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public int CountSecond(String start, String end) throws ParseException {
		long starttime = simpleFormat.parse(start).getTime();
		long endtime = simpleFormat.parse(end).getTime();
		int second = (int) ((endtime - starttime) / 1000);
		return second;
	}

	public int CountAbsolutelySecond(String end, String format) throws ParseException {
		SimpleDateFormat localFormat = new SimpleDateFormat(format);
		long starttime = simpleFormat.parse("1970-01-01 00:00:00").getTime();
		long endtime = localFormat.parse(end).getTime();
		int second = (int) ((endtime - starttime) / 1000);
		return second;
	}

	public boolean IsDate(String str, String format) {
		try {
			SimpleDateFormat localFormat = new SimpleDateFormat(format);
			localFormat.parse(str);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean IsDate(String str) {
		try {
			simpleFormat.parse(str);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public SimpleDateFormat getSimpleFormat() {
		return simpleFormat;
	}

	public void setSimpleFormat(SimpleDateFormat simpleFormat) {
		this.simpleFormat = simpleFormat;
	}
}
