package org.bjx.helper.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	private SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public int CountSecond(String start, String end) throws ParseException {
		long starttime = simpleFormat.parse(start).getTime();
		long endtime = simpleFormat.parse(end).getTime();
		int second = (int) ((endtime - starttime) / 1000);
		return second;
	}

	public int CountAbsolutelySecond(String end) throws ParseException {
		long starttime = simpleFormat.parse("1970-01-01 00:00:00").getTime();
		long endtime = simpleFormat.parse(end).getTime();
		int second = (int) ((endtime - starttime) / 1000);
		return second;
	}

	public boolean IsDate(String str) {
		try {
			simpleFormat.parse(str);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Date getDay(int i) throws ParseException {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DAY_OF_MONTH, i);
		return simpleFormat.parse(simpleFormat.format(now.getTime()));
	}

	public String getDayString(int i) {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DAY_OF_MONTH, i);
		return simpleFormat.format(now.getTime());
	}
	
	public SimpleDateFormat getSimpleFormat() {
		return simpleFormat;
	}

	public void setSimpleFormat(SimpleDateFormat simpleFormat) {
		this.simpleFormat = simpleFormat;
	}
	
}
