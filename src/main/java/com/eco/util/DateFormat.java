package com.eco.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormat {
	
	public static Date getWeekStartDate(String queryDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(stringToDate(queryDate));
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date date = calendar.getTime();
		return date;
	}
		
	public static Date stringToDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date reDate = null;
		try {
			reDate = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return reDate;
	}
	
}
