package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateUtil {
	private static Logger logger = Logger.getLogger(DateUtil.class);
	
	public static boolean isToday(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(new Date()).equals(format.format(date));
	}
	
	public static boolean isSameDay(Date d1, Date d2){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(d1).equals(format.format(d2));
	}
	
	/**
	 * 根据时间模版，获得当前时间字符串
	 * <br> format 为时间模板：yyyy-MM-dd HH:mm:ss
	 * 
	 * @param format
	 * @return
	 */
	public static String getNewDate(String format){
		return dateFormat(new Date(), format);
	}
	
	public static String dateFormat(Date date, String format){
		return new SimpleDateFormat(format).format(date);
	}
	
	public static Date stringToDate(String dateStr, String format){
		if(dateStr == null){
			return null;
		}
		
		try {
			return new SimpleDateFormat(format).parse(dateStr);
		} catch (ParseException e) {
			logger.error("", e);
			return null;
		}
	}
	
	/**
	 * 获得距今N天的日期字符串
	 * <li>当amount为正数则是amount天后
	 * <li>当amount为负数则是amount天前
	 * 
	 * @param before
	 * @return
	 */
	public static String getDate(int amount, String format){
		return new SimpleDateFormat(format).format(getDate(amount));
	}
	
	/**
	 * 获得距今N天的日期字符串
	 * <li>当amount为正数则是amount天后
	 * <li>当amount为负数则是amount天前
	 * 
	 * @param before
	 * @return
	 */
	public static Date getDate(int amount){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, amount);
		return cal.getTime();
	}
	
	/**
	 * 该方法返回参数时间到当前时间的自然日差
	 * 例如：2016年3月8号－2016年3月10号共有三个自然日的差
	 * 
	 * @param day
	 * @return
	 */
	public static int dayNumBeforeNow(Date day){
		Date startDay = stringToDate(dateFormat(day, "yyyyMMdd"), "yyyyMMdd");
		Date today = stringToDate(getNewDate("yyyyMMdd"), "yyyyMMdd");
		float temp = (today.getTime()-startDay.getTime()) / (1000*3600*24) + 1;
		return (int)temp;
	}
	
	/**
	 * 该方法返回参数时间到当前时间的自然日差
	 * 例如：2016年3月8号－2016年3月10号共有三个自然日的差
	 * 
	 * @param day
	 * @return
	 */
	public static int dayNumAfterNow(Date day){
		Date startDay = stringToDate(dateFormat(day, "yyyyMMdd"), "yyyyMMdd");
		Date today = stringToDate(getNewDate("yyyyMMdd"), "yyyyMMdd");
		float temp = (startDay.getTime()-today.getTime()) / (1000*3600*24) + 1;
		return (int)temp;
	}
}
