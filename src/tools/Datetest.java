package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.nutz.castor.castor.Datetime2Calendar;
//dateTime = dateTime.plusDays(1) // 增加天    
//.plusYears(1)// 增加年    
//.plusMonths(1)// 增加月    
//.plusWeeks(1)// 增加星期    
//.minusMillis(1)// 减分钟    
//.minusHours(1)// 减小时    
//.minusSeconds(1);// 减秒数  
public class Datetest {

	public static void main(String[] args) {
		
//		Calendar c = Calendar.getInstance(); 
//		c.setTime(stringToDate("20160808", "yyyyMMdd"));
//		//c.add(Calendar.MONTH, 1); // 目前時間加1個月    
//		//System.out.println(dateFormat(c.getTime(), "yyyyMMdd"));    
//		c.add(Calendar.HOUR, 3); // 目前時間加3小時    
//		System.out.println(df.format(c.getTime()));    
//		c.add(Calendar.YEAR, -2); // 目前時間減2年    
//		System.out.println(dateFormat(c.getTime(), "yyyyMMdd")); 
		//c.add(Calendar.DAY_OF_WEEK, 7); // 目前的時間加7天    
		//System.out.println(dateFormat(c.getTime(), "yyyyMMdd"));
//		DateTime dateTime = new DateTime();
//		System.out.println(dateTime.toString("yyyyMMdd"));
//		dateTime = dateTime.minusYears(1);
//		System.out.println(dateTime.toString("yyyyMMdd"));
		DateTimeFormatter format = DateTimeFormat .forPattern("yyyy-MM-dd HH:mm:ss");  
		 DateTime dateTime2 = DateTime.parse("2012-12-21 23:22:45", format); 
		 System.out.println("dateTime2"+dateTime2);
//		// 根据指定格式,将时间字符串转换成DateTime对象,这里的格式和上面的输出格式是一样的
		 
         DateTime dt2 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime("2012-12-26 03:27:39");  
         System.out.println("dt2"+dt2);
		 System.out.println("date:"+new Date());
		 System.out.println("datetime:"+new DateTime().plusMonths(2).toDate());
		 
		Date day = DateUtil.stringToDate("2016-11-01", "yyyyMMdd");
		System.out.println(DateUtil.dayNumBeforeNow(day));
		
		Date startDay = stringToDate("20161112", "yyyyMMdd");
		Date today = stringToDate("20161111", "yyyyMMdd");
		float temp = (startDay.getTime()-today.getTime()) / (1000*3600*24);
		System.out.println("min"+(int)temp);
		 
		 
		 
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
			return null;
		}
	}
}

//Android+%7C+%E7%AD%96%E7%95%A5%E7%82%92%E8%82%A1%E9%80%9A2.1.0+%7C+a000004ff4fb44+%7C+PE-CL00+%7C+Official
