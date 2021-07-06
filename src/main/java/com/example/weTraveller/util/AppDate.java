package com.example.weTraveller.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AppDate {

	private static final Logger log = (Logger) LoggerFactory.getLogger(AppDate.class);

	public static final String YYYY_MM_DD_T_HH_MM_SS = "yyyy-MM-dd'T'HH:mm:ss";
	public static final String MMMM_DD_YYYY = "MMMM dd, yyyy";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String DD_MM_YYYY = "dd-MM-yyyy";
	public static final String DD_MM_YYYY_SLASH = "dd/MM/yyyy";

	public static Calendar now() {
		return Calendar.getInstance();
	}

	public static Calendar calender(String dateString, String format){
		try{
			Calendar calender = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			calender.setTime(sdf.parse(dateString));
			return calender;
		}catch(Throwable t){
			log.error(t.getMessage());
		}
		return null;
	}

	public static String current(String format){
		String dateString = "";
		try{
			Date date = now().getTime();
			dateString = new SimpleDateFormat(format).format(date);
		}catch(Throwable t){
			log.error(t.getMessage());
		}
		return dateString;
	}

	public static String dateString(Calendar calendar, String format){
		if(calendar == null) return "";

		String dateString = "";
		try{
			Date date = calendar.getTime();
			dateString = new SimpleDateFormat(format).format(date);
		}catch(Throwable t){
			log.error(t.getMessage());
		}
		return dateString;
	}

	public static long currentTimeStamp(){
		try{
			return now().getTimeInMillis();
		}catch(Throwable t){
			log.error(t.getMessage());
		}
		return 0;
	}

	public static void main(String[] args) {
		//System.out.println(AppDate.calender("2019-04-04T00:00:00", AppDate.YYYY_MM_DD_T_HH_MM_SS));
		System.out.println(AppDate.current(AppDate.MMMM_DD_YYYY));
	}
}