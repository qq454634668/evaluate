package com.evaluate.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {

	public static final String TIME_SHORT="yyyyMMddHHmmss";
	public static final String TIME_NORMAL="yyyy-MM-dd HH:mm:ss";
	
	
	@SuppressWarnings("static-access")
	public static String after(String nowTime, Integer number) {
		String time = "";
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date now = null;
		try {
			now = sdf.parse(nowTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		c.add(Calendar.DAY_OF_MONTH, number);
		time = c.get(c.YEAR)
				+"-"+((c.get(Calendar.MONTH)+1)< 10?"0"+(c.get(Calendar.MONTH)+1):(c.get(Calendar.MONTH)+1))
				+"-"+(c.get(Calendar.DAY_OF_MONTH)<10?"0"+c.get(Calendar.DAY_OF_MONTH):c.get(Calendar.DAY_OF_MONTH))
				+" "+(c.get(Calendar.HOUR_OF_DAY)<10?"0"+c.get(Calendar.HOUR_OF_DAY):c.get(Calendar.HOUR_OF_DAY))
				+":"+(c.get(Calendar.MINUTE)<10?"0"+c.get(Calendar.MINUTE):c.get(Calendar.MINUTE))
				+":"+(c.get(Calendar.SECOND)<10?"0"+c.get(Calendar.SECOND):c.get(Calendar.SECOND));
		return time;
	}
	
	@SuppressWarnings("static-access")
	public static String getChangeTime(String nowTime,String timeType,Integer number){
		String time = "";
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date now = null;
			try {
				now = sdf.parse(nowTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		if(timeType.equals("year")){
			c.add(Calendar.YEAR, number);
		}else if(timeType.equals("month")){
			c.add(Calendar.MONTH, number);
		}else if(timeType.equals("day")){
			c.add(Calendar.DAY_OF_MONTH, number);
		}else if(timeType.equals("hour")){
			c.add(Calendar.HOUR_OF_DAY, number);
		}else if(timeType.equals("minute")){
			c.add(Calendar.MINUTE, number);
		}else if(timeType.equals("second")){
			c.add(Calendar.SECOND, number);
		}
		time = c.get(c.YEAR)
			+"-"+((c.get(Calendar.MONTH)+1)<10?"0"+(c.get(Calendar.MONTH)+1):(c.get(Calendar.MONTH)+1))
			+"-"+(c.get(Calendar.DAY_OF_MONTH)<10?"0"+c.get(Calendar.DAY_OF_MONTH):c.get(Calendar.DAY_OF_MONTH))
			+" "+(c.get(Calendar.HOUR_OF_DAY)<10?"0"+c.get(Calendar.HOUR_OF_DAY):c.get(Calendar.HOUR_OF_DAY))
			+":"+(c.get(Calendar.MINUTE)<10?"0"+c.get(Calendar.MINUTE):c.get(Calendar.MINUTE))
			+":"+(c.get(Calendar.SECOND)<10?"0"+c.get(Calendar.SECOND):c.get(Calendar.SECOND));
		return time;
	}

	public static String timeToString(Date date){
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	public static String getNowTimeString(){
		Date date = new Date();
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	public static String getNowTimeStringByPattern(String pattern){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	public static String timeToString(Date date,String patern){
		SimpleDateFormat sdf = new SimpleDateFormat(patern);
		return sdf.format(date);
	}
	
	public static String timeToPattern(Date date, String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	
	public static Date timeStringToDate(String timeString,String pattern) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(timeString);
	}
	
	public static int getMonth(String dateTime){
		  int y = 0;
		  Date d = new Date();
		  try{
			  SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd");
			  ParsePosition pos = new ParsePosition(0);
			  Date dt1=formatter.parse(dateTime,pos);
			  long l =  d.getTime() - dt1.getTime();
			  long t = l/(3600*24*1000);
			  y = (int) (t/30);
			  if(y==0){y=1;}
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		return y;
	}
	
	public static int getTian(String dateTime){
		  int y = 0;
		  Date d = new Date();
		  try{
			  SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd");
			  ParsePosition pos = new ParsePosition(0);
			  Date dt1=formatter.parse(dateTime,pos);
			  long l =  d.getTime() - dt1.getTime();
			  long t = l/(3600*1000*24);
			  y = (int) t;
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		return y;
	}
	
	public static String getNextMonthDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");     
		 Calendar   calendar = Calendar.getInstance();
		 Date nextDate = new Date(); 
		 try {
			 nextDate = sdf.parse(sdf.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		calendar.setTime(nextDate);    
		calendar.add(Calendar.DAY_OF_MONTH, 30); 
		return sdf.format(calendar.getTime()); 
	}
}
