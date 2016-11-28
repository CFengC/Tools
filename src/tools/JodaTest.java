package tools;


import java.util.Scanner;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class JodaTest {
	
	private final static String birthday = "1991-10-04 12:20:55";
	private final static String tbirthday = "1991-07-15 12:20:55";
	
	public static void main(String[] args) {
		System.out.println("#########出生日期:"+birthday+"########");
		DateTimeFormatter format1 = DateTimeFormat .forPattern("yyyy-MM-dd HH:mm:ss");
		DateTime startDateTime = DateTime.parse(birthday, format1);
		System.out.println("文文来到这个世界已经");
		int wendays = calDateToDay(startDateTime,new DateTime());
		System.out.println("#########出生日期:"+tbirthday+"########");
		startDateTime = DateTime.parse(tbirthday, format1);
		System.out.println("程枫来到这个世界已经");
		int fengdays = calDateToDay(startDateTime,new DateTime());
		System.out.println("*********早出生:"+(fengdays-wendays)+"天**********");
//		while(true){
//			Scanner s = new Scanner(System.in);
//			System.out.println("################################");
//			DateTimeFormatter format1 = DateTimeFormat .forPattern("yyyy-MM-dd HH:mm:ss");
//			DateTimeFormatter format2 = DateTimeFormat .forPattern("yyyy-MM-dd");
//			DateTime startDateTime = DateTime.parse(birthday, format1);
//			System.out.println("文文来到这个世界已经");
//			calDateToDay(startDateTime,new DateTime());
			//System.out.println("如选择其它日期请输入(格式例如:2012-11-08 14:24:54或着2012-11-08)");
			//System.out.println("########################################");
//			String endDate = s.nextLine();
//			System.out.println("##############endDate############"+endDate);
//			DateTime endDateTime = null;
//			try{
//				endDateTime = DateTime.parse(endDate,format1);
//			}catch(Exception e){
//				try{
//					endDateTime = DateTime.parse(endDate,format2);
//				}catch(Exception e1){
//					System.out.println("输入格式错误!请重新输入.");
//					continue;
//				}
//			}
//			System.out.println("宝宝从出生到" + endDateTime.toString("yyyy-MM-dd HH:mm:ss") + "已经");
//			calDateToDay(startDateTime,endDateTime);
//		}
	}
	
	
	
	public static int calDateToDay(DateTime startDateTime,DateTime endDateTime){
		LocalDate start=new LocalDate(startDateTime);  
		LocalDate end=new LocalDate(endDateTime);
		Days days = Days.daysBetween(start, end);
		int intervalDays = days.getDays();
		int intervalHours = endDateTime.getHourOfDay() - startDateTime.getHourOfDay();
		int intervalMinutes = endDateTime.getMinuteOfHour() - startDateTime.getMinuteOfHour();
		int intervalSeconds = endDateTime.getSecondOfMinute() - startDateTime.getSecondOfMinute();
		
		
		if(intervalSeconds < 0){
			intervalMinutes = intervalMinutes -1;
			intervalSeconds = 60 + intervalSeconds;
		}
		
		if(intervalMinutes < 0){
			intervalHours = intervalHours -1;
			intervalMinutes = 60 + intervalMinutes;
		}
		
		if(intervalHours < 0){
			intervalDays = intervalDays -1;
			intervalHours = 24 + intervalHours;
		}
				
		System.out.println(intervalDays + "天" + intervalHours + 
				"小时" + intervalMinutes + "分钟" + intervalSeconds + "秒");
		System.out.println("#########现在时间:"+endDateTime.toString("yyyy-MM-dd HH:mm:ss")+"#########");
		return intervalDays;
	}

}
