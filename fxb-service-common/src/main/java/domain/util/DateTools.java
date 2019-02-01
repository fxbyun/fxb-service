/**
 * 
 */
package domain.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author mengfei.xiong
 *
 */
public class DateTools {

	
	public static SimpleDateFormat SDF_YYMMDD = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat SDF_YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String StringToDate_YYYY_MM_DD(Date date){
		String dates="";
		try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            dates = sdf.format(date);
        }
        catch (Exception e) {
            date = null;
            System.out.println(e);
        }

        return dates;

	}

    public static String StringToDate_YYYYMMDD(Date date){
        String dates="";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            dates = sdf.format(date);
        }
        catch (Exception e) {
            date = null;
            System.out.println(e);
        }
        return dates;

    }

    public static Date stringToDate(String dateString,String format) {
        Date date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(dateString);
        }
        catch (Exception e) {
            date = null;
        }

        return date;
    }

    public static Date stringToDate(String dateString) {
        Date date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = sdf.parse(dateString);
        }
        catch (Exception e) {
            date = null;
            System.out.println(e);
        }

        return date;
    }

    public static String dateToString(Date date,String format){
    	if(date == null){
    		return "yyyy-MM-dd HH:mm";
    	}
    	SimpleDateFormat sdf = new SimpleDateFormat(format);
    	return sdf.format(date);
    }

    public static Date StringToDate_YYYY_MM_DD_HH_MM(String dateString) {
        Date date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            date = sdf.parse(dateString);
        }
        catch (Exception e) {
            date = null;
            System.out.println(e);
        }

        return date;
    }

    public static Date StringToDate_YYYY_MM_DD_HH_MM_SS(String dateString) {
        Date date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = sdf.parse(dateString);
        }
        catch (Exception e) {
            date = null;
            System.out.println(e);
        }

        return date;
    }


    public static Date stringToDateShort(String dateString) {
        Date date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            date = sdf.parse(dateString);
        }
        catch (Exception e) {
            date = null;
            System.out.println(e);
        }

        return date;
    }
    public static String dateToString(Date date){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	return sdf.format(date);
    }


    public static String getByTimeMillis(long timeMillis){
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(timeMillis);
		return dateToString(c.getTime());

    }

    public static long getTimeMillis(String dateTime){
    	if(dateTime == null || dateTime.equals("")){
    		return 0l;
    	}
		Date date = DateTools.stringToDate(dateTime);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
    }

    public static String getNowDate(String format){
    	Date date = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat(format);
    	return sdf.format(date);
    }

    public static String getNowDateYYYYMMDD(){
    	Date date = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    	return sdf.format(date);
    }

    public static String getNowDateYYYY_MM_DD(){
    	Date date = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	return sdf.format(date);
    }

    public static String getNowDateYYYY_MM_DD_HH_MM(){
    	Date date = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	return sdf.format(date);
    }

    public static String getNowDateYYYY_MM_DD_HH_MM_SS(){
    	Date date = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	return sdf.format(date);
    }
    
    public static String getSomeDayYYYY_MM_DD(Calendar c){
    	Date date = c.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
    	return sdf.format(date);
    }

    public static String getNowDateYYYYMMDDHHMMSS(){
    	Date date = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    	return sdf.format(date);
    }
   /* 将当前日期加减n天数。
    * 如传入整型-3 意为将当前日期减去3天的日期
    * 如传入整型3 意为将当前日期加上3天后的日期
    */
    public static String dateAdd(int days) {
        Calendar canlendar = Calendar.getInstance(); //java.util包
        canlendar.add(Calendar.DATE, days); //日期减 如果不够减会将月变动
        String result =(new SimpleDateFormat("yyyy-MM-dd")).format(canlendar.getTime());
        return result;
    }
    
    //获得一个星期前的日期
    public static String getLastWeekDateYYYY_MM_DD(Date date){
    	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	   Calendar calendar = Calendar.getInstance();
    	   calendar.setTime(date);
    	   calendar.set(Calendar.WEEK_OF_MONTH, calendar.get(Calendar.WEEK_OF_MONTH) -1);//一星期前

   	       return sdf.format(calendar.getTime());//一星期前
    }
    //获得两个星期前的日期
    public static String getLastTwoWeekDateYYYY_MM_DD(Date date){
 	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 	   Calendar calendar = Calendar.getInstance();
 	   calendar.setTime(date);
 	   calendar.set(Calendar.WEEK_OF_MONTH, calendar.get(Calendar.WEEK_OF_MONTH) -1);//一星期前

	   String oneweek = sdf.format(calendar.getTime());//一星期前
	   Date oneWeekDate = null;
	   try{
		   oneWeekDate = sdf.parse(oneweek);
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   if(oneWeekDate == null){
		   calendar.setTime(new Date());
	 	   calendar.set(Calendar.WEEK_OF_MONTH, calendar.get(Calendar.WEEK_OF_MONTH) -2);//一星期前
	   }else{
		   calendar.setTime(oneWeekDate);
	 	   calendar.set(Calendar.WEEK_OF_MONTH, calendar.get(Calendar.WEEK_OF_MONTH) -1);//一星期前
	   }
 	   return sdf.format(calendar.getTime());//两个星期前
    }
    //获得两个星期前的时间
    public static String getLastTwoWeekDateYYYY_MM_DD_HH_MM_SS(){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(Calendar.WEEK_OF_MONTH, calendar.get(Calendar.WEEK_OF_MONTH) -1);//一星期前
    	
    	String oneweek = sdf.format(calendar.getTime());//一星期前
    	Date oneWeekDate = null;
    	try{
    		oneWeekDate = sdf.parse(oneweek);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	if(oneWeekDate == null){
    		calendar.setTime(new Date());
    		calendar.set(Calendar.WEEK_OF_MONTH, calendar.get(Calendar.WEEK_OF_MONTH) -2);//一星期前
    	}else{
    		calendar.setTime(oneWeekDate);
    		calendar.set(Calendar.WEEK_OF_MONTH, calendar.get(Calendar.WEEK_OF_MONTH) -1);//一星期前
    	}
    	calendar.set(Calendar.SECOND, 0);
    	calendar.set(Calendar.MINUTE, 0);
    	calendar.set(Calendar.HOUR_OF_DAY, 0);
    	return sdf.format(calendar.getTime());//两个星期前
    }
    //获得一个月前的日期
    public static String getLastMonthDateYYYY_MM_DD(Date date){
 	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 	   Calendar calendar = Calendar.getInstance();
 	   calendar.setTime(date);
 	   calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) -1);//一星期前

	   return sdf.format(calendar.getTime());//一个月前
    }
    //获得三个月前的日期
    public static String getLastThreeMonthDateYYYY_MM_DD(Date date){
 	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 	   Calendar calendar = Calendar.getInstance();
 	   calendar.setTime(date);
 	   calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) -3);//三个月前

	   return sdf.format(calendar.getTime());//一个月前
    }
    //获得一年前的日期
    public static String getLastYearDateYYYY_MM_DD(Date date){
 	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 	   Calendar calendar = Calendar.getInstance();
 	   calendar.setTime(date);
 	   calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) -1);//一年前

	   return sdf.format(calendar.getTime());
    }

    /**
     * 返回true表示时间比预计时间大，不能查询
     * @param startTime
     * @param differsence
     * @return
     * @create_time 2010-11-18 下午02:27:47
     */
    @SuppressWarnings("static-access")
    public static boolean compareTime(String startTime, int differsence) {
        Calendar startcalendar = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            startcalendar.setTime(sdf.parse(startTime));
            startcalendar.set(startcalendar.MONTH, (startcalendar.get(startcalendar.MONTH) + differsence));
            return calendar.after(startcalendar);
        } catch (Exception e) {
            return true;
        }
    }

    //获取date这天开始时间 0分0秒
    public static Calendar toDayStart(Calendar c) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
        	   Calendar dayStart = Calendar.getInstance();
               dayStart.setTime(sdf.parse(sdf.format(c.getTime())));
           	return dayStart;
        } catch (ParseException e) {
            return null;
        }
    }
    
    //获取date这天结束时间 23分59秒999毫秒
    public static Calendar toDayEnd(Calendar c) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date tmp = null;
        try {
            tmp = sdf.parse(sdf.format(c.getTime()));
        } catch (ParseException e) {
            return null;
        }
        Calendar dayEnd = Calendar.getInstance();
        dayEnd.setTime( new Date(tmp.getTime() + 24 * 60 * 60 * 1000 - 1));
        return dayEnd;
    }
    /***
     * 如果时间小于1971 那么返回为Null 
     * 因为mysql数据库必须设置默认值,所以get方法进行转换 
     * @param whenDate
     * @return
     */
    public static Date valid1970Return(Date whenDate){
    	if(whenDate==null) return null;
    	Date date1971 = DateUtil.getDateByString("1971-01-01 00:00:00");
    	//如果在whenDate在date1971 年以前, 那么就返回为Null
    	if(date1971.after(whenDate)){
    		return null;
    	}
    	return whenDate;
    }
    
    public static void main(String args[]) {
    	//System.out.println(getLastMonthDateYYYY_MM_DD(new Date()));
//    	//System.out.println(getLastThreeMonthDateYYYY_MM_DD(new Date()));
//
//        List<String> list = new ArrayList<String>();
//        for (int i = -5; i < 0; i++)
//        list.add(DateTools.dateAdd(i));
//
//        for(String o:list){
//            System.out.println(o);
//        }
//    	Date d = DateTools.toDayStart(Calendar.getInstance()).getTime();
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    	System.out.println(sdf.format(d));
//    	Date c = DateTools.toDayEnd(Calendar.getInstance()).getTime();
//    	System.out.println(sdf.format(c));
    	
    	Date whenDate = DateUtil.getDateByString("1970-01-01 08:00:00");
    	
    	System.out.println(valid1970Return(whenDate));
     
    	
    }
	
	
	/**
	 * 将String类型转成Calendar
	 * @param dateString
	 * @param format
	 * @return
	 */
	public static Calendar stringToCalendar(String dateString, String format) {
	    Date date = stringToDate(dateString, format);
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    
	    return calendar;
	}
	
    public static String dateAddYYMMDD(int days) {
        Calendar canlendar = Calendar.getInstance(); //java.util包
        canlendar.add(Calendar.DATE, days); //日期减 如果不够减会将月变动
        String result =(new SimpleDateFormat("yyMMdd")).format(canlendar.getTime());
        return result;
    }
	 public static String dateAddTld(Integer days) {
	     return  dateAdd(days) ;
	}
	 
	 public static String dateAddYYMMDDTld(Integer days) {
	     return  dateAddYYMMDD(days) ;
	}
}
