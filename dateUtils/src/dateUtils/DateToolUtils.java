package dateUtils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
//import java.util.logging.Logger;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;



public class DateToolUtils {
	/**
	 * log4j日志 
	 */
	//static private Logger log = LoggerFactory.getLog("DateUtil.class");
	/**   
	  
	 * 把这种形式yyyy-MM-dd HH:mm:ss的字符串转换成时间类型。   
	  
	 * @param   dateStr   这种形式yyyy-MM-dd HH:mm:ss的字符串
	  
	 * @return 时间类型   Date  
	  
	 * @Exception 异常对象   
	  
	 * @since  CodingExample　Ver(编码范例查看) 1.1   
	  
	*/
	
	 /**
     * Date Style
     */
    public static final String DATESTYLE = "yyyyMMddHHmmss";

    /**
     * Date Style for Extention
     */
    public static final String DATESTYLE_EX = "yyyy-MM-dd_HH-mm-ss";
    
    /**
     * Date Style for Extention
     */
    public static final String DATESTYLE_ = "yyyy-MM-dd";

    /**
     * Date Style for Year & Month
     */
    public static final String DATESTYLE_YEAR_MONTH = "yyyyMM";

    /**
     * Date Style for Short
     */
    public static final String DATESTYLE_SHORT = "yyyyMMdd";

    /**
     * Date Style for Extention
     */
    public static final String DATESTYLE_SHORT_EX = "yyyy/MM/dd";

    /**
     * Date Style for Year & Month Extention
     */
    public static final String DATESTYLE_YEAR_MONTH_EX = "yyyy/MM";

    /**
     * Date Style for detail
     */
    public static final String DATESTYLE_DETAIL = "yyyyMMddHHmmssSSS";

	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd",
			"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" };
	static public  Date string2Date(String dateStr){
		if(dateStr == null){
			//Logger.info("字符串转换成时间类型不能为空。");syso
		}
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date newCreateTime = null;
		if(!"".equals(dateStr) ){
			try {
				 newCreateTime = sdf.parse(dateStr);
			} catch (ParseException e) {
				//Logger.warn("时间转换出错!!create_time:"+dateStr);syso
				e.printStackTrace();
			}
		}
		return newCreateTime;
	}
	
	static public String getDateStr(Date date) {    
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
        return format.format(date);    
    }  
	
	  /**
	    * 获取当前日期的前一天
	    * @param date
	    * @return
	    */
	static public Date getBeforeDay(Date date) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_MONTH,-1);
			date = calendar.getTime();
			return date;
		}
	
	/**
	 * 日期字符串转date
	 * @param strDate
	 * @return
	 */
	static public Date changeStringToDate(String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date uDate = null;
		try {
			uDate = sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return uDate;
	}
    
	/**
	 * 获取第二天的日期
	 * 
	 * @param date
	 */
	public static Date getNextDate(Date date) {
		Calendar calendar = Calendar.getInstance();
	      calendar.setTime(date);
	      calendar.add(Calendar.DAY_OF_MONTH,1);//把日期往前减少一天，若想把日期向后推一天则将负数改为正数
	      date=calendar.getTime(); 
	   return date;
	}
	

    /**
     * 日期转化为字符串
     * @param date 时间
     * @return yyyy-MM-dd HH:mm:ss 格式化的时间字符串
     */
    public static String dateToString(Date date) {
        if(date==null) return "";
        return FormatDate(date, "yyyy-MM-dd HH:mm:ss");
    }
	

    /**
     * 日期转化为字符串
     * @param date 时间
     * @return yyyy-MM-dd 格式化的时间字符串
     */
    public static String dateToStringShort(Date date) {
        if(date==null) return "";
        return FormatDate(date, "yyyy-MM-dd");
    }

    /**
     * 计算两个日期差（毫秒）
     * @param date1 时间1
     * @param date2 时间2
     * @return 相差毫秒数
     */
    public static long diffTwoDate(Date date1, Date date2) {
        long l1 = date1.getTime();
        long l2 = date2.getTime();
        return (l1 - l2);
    }
    
    
    
    /**
     * 计算两个日期差（天）
     * @param date1 时间1
     * @param date2 时间2
     * @return 相差天数
     */
    public static int diffTwoDateDay(Date date1, Date date2) {
        long l1 = date1.getTime();
        long l2 = date2.getTime();
        int diff = Integer.parseInt(""+(l1 - l2)/3600/24/1000);
        return diff;
    }

    /**
     * 对日期进行格式化
     * @param date 日期
     * @param sf 日期格式
     * @return 字符串
     */
    public static String FormatDate(Date date, String sf) {
        if(date==null) return "";
        SimpleDateFormat dateformat = new SimpleDateFormat(sf);
        return dateformat.format(date);
    }

    /**
     * 取得当前系统日期
     * @return yyyy-MM-dd
     */
    public static String getCurrDate() {
        Date date_time = new Date();
        return FormatDate(date_time, "yyyy-MM-dd");
    }

    //取系统时间时一定要用这个方法，否则日期可能不动
    public static Date getCurrDateTime(){
        return new Date(System.currentTimeMillis());
    }

    /**
     * 取得当前系统时间
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrTime() {
        Date date_time = new Date();
        return FormatDate(date_time, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 10位时间转为8时间
     * @param str
     * @return
     */
    public static String getDate10to8(String str){
    	String y = str.substring(0,4);
    	String m = str.substring(5,7);
        String d = str.substring(8,10);
    	return y+m+d;
    }

    /**
     * 8位时间转为10时间
     * @param str
     * @return
     */
    public static String getDate8to10(String str){
    	String y = str.substring(0,4);
    	String m = str.substring(4,6);
        String d = str.substring(6,8);
    	return y+"-"+m+"-"+d;
    }

	/**
     * 取得日期的天份
     * @param date 日期
     * @return dd 天字符串
     */
    public static String getDay(Date date) {
        return FormatDate(date, "dd");
    }
	
	
	/**
     * 取得日期的小时
     * @param date 日期
     * @return hh 小时字符串
     */
    public static String getHour(Date date) {
        return FormatDate(date, "HH");
    }

        /**
		 * 取得日期的分钟
		 * @param date 时间
		 * @return mm 分钟字符串
		 */
		public static String getMinute(Date date) {
		    return FormatDate(date, "mm");
		}



    /**
     * 取得日期的月份
     * @param date 日期
     * @return mm 月份字符串
     */
    public static String getMonth(Date date) {
        return FormatDate(date, "MM");
    }

    public static int getMonth(Date start, Date end) {
        if (start.after(end)) {
            Date t = start;
            start = end;
            end = t;
        }
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(start);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);
        Calendar temp = Calendar.getInstance();
        temp.setTime(end);
        temp.add(Calendar.DATE, 1);

        int year = endCalendar.get(Calendar.YEAR)
                - startCalendar.get(Calendar.YEAR);
        int month = endCalendar.get(Calendar.MONTH)
                - startCalendar.get(Calendar.MONTH);

        if ((startCalendar.get(Calendar.DATE) == 1)
                && (temp.get(Calendar.DATE) == 1)) {
            return year * 12 + month + 1;
        } else if ((startCalendar.get(Calendar.DATE) != 1)
                && (temp.get(Calendar.DATE) == 1)) {
            return year * 12 + month;
        } else if ((startCalendar.get(Calendar.DATE) == 1)
                && (temp.get(Calendar.DATE) != 1)) {
            return year * 12 + month;
        } else {
            return (year * 12 + month - 1) < 0 ? 0 : (year * 12 + month);
        }
    }

    /**
     * 取得时间的秒
     * @param date 时间
     * @return ss 秒字符串
     */
    public static String getSecond(Date date) {
        return FormatDate(date, "ss");
    }

    /**
     *根据年、月取得月末的日期
     * @param year 年
     * @parm month 月
     * @return time  返回日期格式"yyyy-mm-dd"
     */
    public static String getTime(String year,String month){
        String time="";
        int len=31;
        int iYear=Integer.parseInt(year);
        int iMonth=Integer.parseInt(month);
        if(iMonth==4 || iMonth==6 || iMonth==9 || iMonth==11)
            len=30;
        if(iMonth==2){
            len=28;
            if((iYear%4==0 && iYear%100==0 && iYear%400==0) || (iYear%4==0 && iYear%100!=0)){
                len=29;
            }
        }
        time=year+"-"+month+"-"+String.valueOf(len);
        return time;
    }

    /**
     * 取得日期的年份
     * @param date 日期
     * @return yyyy 年份字符串
     */
    public static String getYear(Date date) {
        return FormatDate(date, "yyyy");
    }

    /**
     * 主函数
     * @param args 测试参数
     */
    public static void main(String[] args) {
        DateToolUtils d = new DateToolUtils();
        String strDate = "2007-02-11";
        Date aa = d.stringToDateShort(strDate);

        DateToolUtils ddd=new DateToolUtils();
        
    }
    /**
     * 字符串转换为日期
     * @param dateString yyyy-MM-dd HH:mm:ss
     * @return 日期
     */
    public static Date stringToDate(String dateString) {
        if(dateString==null || dateString.trim().length()==0) return null;
        String datestr = dateString.trim();
        
    	String sf = "yyyy-MM-dd HH:mm:ss";
        Date dt = stringToDate(datestr, sf);
        if(dt==null) dt = stringToDate(datestr, "yyyy-MM-dd");
        if(dt==null) dt = stringToDate(datestr, "yyyyMMdd");
        return dt;
    }
    /** 字符串转换为日期
     *  @param dateString 日期格式字符串
     *  @param  sf 日期格式化定义
     *  @return 转换后的日期
     */
    public static Date stringToDate(String dateString, String sf) {
        ParsePosition pos = new ParsePosition(0);
        SimpleDateFormat sdf = new SimpleDateFormat(sf);
        Date dt = sdf.parse(dateString, pos);
        return dt;
    }
    /**
     * 字符串转换为日期
     * @param dateString yyyy-MM-dd
     * @return 日期
     */
    public static Date stringToDateShort(String dateString) {
        String sf = "yyyy-MM-dd";
        Date dt = stringToDate(dateString, sf);
        return dt;
    }
    public DateToolUtils() {
    }
    /**
	 * 取得日以上粒度起始时间
	 * @param granularity 粒度
	 * @param statisticDate 结束时间
	 * @return 起始时间
	 */
	public String getBeginDate(String granularity,String statisticDate){
		String beginDate = "";
		Date date = this.stringToDateShort(statisticDate);
		Date beginDateTemp  = null;
		if(granularity.equals("1")){//日
			beginDateTemp = date;
		}
		if(granularity.equals("2")){//周
			beginDateTemp = this.getWeekBegin(date);
		}
		if(granularity.equals("3")){//旬
			beginDateTemp = this.getPeriodBegin(date);
		}
		else if(granularity.equals("4")){//月
			beginDateTemp = this.getMonthBegin(date);
		}
		else if(granularity.equals("5")){//季
			beginDateTemp = this.getSeasonBegin(date);
		}
		else if(granularity.equals("6")){//半年
			beginDateTemp = this.getHalfYearBegin(date);
		}
		else if(granularity.equals("7")){//年
			beginDateTemp = this.getYearBegin(date);
		}
		beginDate = this.dateToStringShort(beginDateTemp);
		return beginDate;
	}

    /**
     *
     * @param currentTime 计算日期
     * @param type 偏移的类别
     * @param iQuantity 偏移数量
     * @return 偏移后的时间串
     */
    public String getDateChangeALL(String currentTime, String type,
                                   int iQuantity) {
      Date curr = null;
      String newtype = "";
      if(currentTime.length()==10){
        curr = this.stringToDateShort(currentTime);
      }
      if(currentTime.length()>10){
        curr = this.stringToDate(currentTime);
      }
      
      //    日
      if(type.equals("1")){
          iQuantity = iQuantity;
          newtype = "d";
      }
      //    周，按照7天计算
      else if(type.equals("2")){
          iQuantity = iQuantity*7;
          newtype = "d";
      }
//    旬，按照10天计算
      else if(type.equals("3")){
          iQuantity = iQuantity*10;
          newtype = "d";
      }
      //月
      else if(type.equals("4")){
          iQuantity = iQuantity;
          newtype = "m";
      }      
//    旬，按照3个月计算
      else if(type.equals("5")){
        iQuantity = iQuantity*3;
        newtype = "m";
      }
      //半年，按照六个月计算
      else if(type.equals("6")){
          iQuantity = iQuantity*6;
          newtype = "m";
      }
      //年
      else if(type.equals("7")){         
          newtype = "y";
      }
      else{
    	  iQuantity = iQuantity;
          newtype = "d";
      }
      
      Date change = this.getDateChangeTime(curr, newtype, iQuantity);
      
//      if(!type.equals("d")){
//      change = this.getMonthEnd(change);
//      }
      
      return this.dateToStringShort(change);
    }

    /**
     *
     * @param currentTime 计算的日期
     * @param type 偏移的类别
     * @param iQuantity 偏移数量
     * @return 偏移后的时间
     */
    public Date getDateChangeTime(Date currentTime, String type,
                                  int iQuantity) {
        int year = Integer.parseInt(this.FormatDate(currentTime, "yyyy"));
        int month = Integer.parseInt(this.FormatDate(currentTime, "MM"));
        //月份修正
        month=month-1;
        int day = Integer.parseInt(this.FormatDate(currentTime, "dd"));
        int hour = Integer.parseInt(this.FormatDate(currentTime, "HH"));
        int mi = Integer.parseInt(this.FormatDate(currentTime, "mm"));
        int ss = Integer.parseInt(this.FormatDate(currentTime, "ss"));
        GregorianCalendar gc = new GregorianCalendar(year, month, day,
                hour, mi, ss);
        //月份修正
        //gc.add(GregorianCalendar.MONTH, -1);
        if (type.equalsIgnoreCase("y")) {
            gc.add(GregorianCalendar.YEAR, iQuantity);
        }
        else if (type.equalsIgnoreCase("m")) {
            gc.add(GregorianCalendar.MONTH, iQuantity);
        }
        else if (type.equalsIgnoreCase("d")) {
            gc.add(GregorianCalendar.DATE, iQuantity);
        }
        else if (type.equalsIgnoreCase("h")) {
            gc.add(GregorianCalendar.HOUR, iQuantity);
        }
        else if (type.equalsIgnoreCase("mi")) {
            gc.add(GregorianCalendar.MINUTE, iQuantity);
        }
        else if (type.equalsIgnoreCase("s")) {
            gc.add(GregorianCalendar.SECOND, iQuantity);
        }
        return gc.getTime();
    }


    /**
     *
     * @param currentTime 计算的日期
     * @param type 偏移的类别
     * @param iQuantity 偏移数量
     * @return 偏移后的时间串
     */
    public String getDateChangeTime(String currentTime, String type,
                                    int iQuantity) {
        Date curr = this.stringToDate(currentTime);
        curr = this.getDateChangeTime(curr, type, iQuantity);
        return this.dateToString(curr);
    }
    /**
	 * 取得日以上粒度起始时间
	 * @param granularity 粒度
	 * @param statisticDate 结束时间
	 * @return 起始时间
	 */
	public String getEndDate(String granularity,String statisticDate){
		String beginDate = "";
		Date date = this.stringToDateShort(statisticDate);
		Date beginDateTemp  = null;
		
		
		if(granularity.equals("1")){//日
			beginDateTemp = date;
		}
		if(granularity.equals("2")){//周
			beginDateTemp = this.getWeekEnd(date);
		}
		if(granularity.equals("3")){//旬
			beginDateTemp = this.getPeriodEnd(date);
		}
		else if(granularity.equals("4")){//月
			beginDateTemp = this.getMonthEnd(date);
		}
		else if(granularity.equals("5")){//季
			beginDateTemp = this.getSeasonEnd(date);
		}
		else if(granularity.equals("6")){//半年
			beginDateTemp = this.getHalfYearEnd(date);
		}
		else if(granularity.equals("7")){//年
			beginDateTemp = this.getYearEnd(date);
		}
		
		beginDate = this.dateToStringShort(beginDateTemp);
		return beginDate;
	}

	/**
	 * 取半年初
	 * @param date
	 * @return
	 */
	public Date getHalfYearBegin(Date date){
		int year = Integer.parseInt( this.FormatDate(date, "yyyy"));
		int month = Integer.parseInt(this.FormatDate(date, "MM"));
		String newDateStr = this.FormatDate(date,"yyyy")+"-";
		if( month<=6 ){
			newDateStr+="01-01";
		}
		else{
			newDateStr+="07-01";
		}
		return this.stringToDateShort(newDateStr);
	}

    /**
	 * 取半年末
	 * @param date
	 * @return
	 */
	public Date getHalfYearEnd(Date date){
		int year = Integer.parseInt( this.FormatDate(date, "yyyy"));
		int month = Integer.parseInt(this.FormatDate(date, "MM"));
		String newDateStr = this.FormatDate(date,"yyyy")+"-";
		if( month<=6 ){
			newDateStr+="06-30";
		}
		else{
			newDateStr+="12-31";
		}
		return this.stringToDateShort(newDateStr);
	}

	/**
	 * 取月初
	 * @param date
	 * @return
	 */
	public Date getMonthBegin(Date date){
		String newDateStr = this.FormatDate(date, "yyyy-MM")+"-01";
		//FormatDate(date, "yyyy-MM-dd");
		return this.stringToDateShort(newDateStr);
	}
	
	
	/**
     * 取月末时间
     * @param date 日期
     * @return date
     */
    public Date getMonthEnd(Date date){
        int year = Integer.parseInt( this.FormatDate(date, "yyyy"));
        int month = Integer.parseInt(this.FormatDate(date, "MM"));
        int day = Integer.parseInt(this.FormatDate(date, "dd"));

        GregorianCalendar calendar = new GregorianCalendar(year,month-1,day,0,0,0);
        int monthLength = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
        String newDateStr = this.FormatDate(date,"yyyy")+"-"+this.FormatDate(date,"MM")+"-";
        if(monthLength<10)
            newDateStr+="0"+monthLength;
        else
            newDateStr+=""+monthLength;
        return this.stringToDateShort(newDateStr);
    }
	
	/**
	 * 取旬初
	 * @param date
	 * @return
	 */
	public Date getPeriodBegin(Date date){
		int days = Integer.parseInt(this.FormatDate(date, "dd"));
		String newDateStr = this.FormatDate(date,"yyyy-MM")+"-";
		if( days<=10 ){
			newDateStr+="01";
		}
		else if( days<=20 ){
			newDateStr+="11";
		}else{
			newDateStr+="21";
		}
		return this.stringToDateShort(newDateStr);
	}
	
	
	/**
	 * 取旬末
	 * @param date
	 * @return
	 */
	public Date getPeriodEnd(Date date){
		int days = Integer.parseInt(this.FormatDate(date, "dd"));
		String newDateStr = this.FormatDate(date,"yyyy-MM")+"-";
		if( days<=10 ){
			newDateStr+="10";
		}
		else if( days<=20 ){
			newDateStr+="20";
		}else{
			newDateStr=this.FormatDate(this.getMonthEnd(date),"yyyy-MM-dd");
		}
		return this.stringToDateShort(newDateStr);
	}
	
	
	/**
	 * 取季初
	 * @param date
	 * @return
	 */
	public Date getSeasonBegin(Date date){
		int year = Integer.parseInt( this.FormatDate(date, "yyyy"));
		int month = Integer.parseInt(this.FormatDate(date, "MM"));
		String newDateStr = this.FormatDate(date,"yyyy")+"-";
		if( month>=1 && month<=3 ){
			newDateStr+="01-01";
		}
		else if( month>=4 && month<=6 ){
			newDateStr+="04-01";
		}
		else if( month>=7 && month<=9 ){
			newDateStr+="07-01";
		}
		else if( month>=10 && month<=12 ){
			newDateStr+="10-01";
		}
		return this.stringToDateShort(newDateStr);
	}
	
	/**
     * 取季度末时间
     * @param date 日期
     * @return date
     */
    public Date getSeasonEnd(Date date){
        int year = Integer.parseInt( this.FormatDate(date, "yyyy"));
        int month = Integer.parseInt(this.FormatDate(date, "MM"));
        String newDateStr = this.FormatDate(date,"yyyy")+"-";
        if( month>=1 && month<=3 ){
            newDateStr+="03-31";
        }
        else if( month>=4 && month<=6 ){
            newDateStr+="06-30";
        }
        else if( month>=7 && month<=9 ){
            newDateStr+="09-30";
        }
        else if( month>=10 && month<=12 ){
            newDateStr+="12-31";
        }
        return this.stringToDateShort(newDateStr);
    }
	
	
	/**
	 * 取得时间描述
	 * 日 yyyy－mm－dd
	 * 月 yyyy年mm月
	 * 季 yyyy年第×季度
	 * 年 yyyy年
	 * @param granularity 粒度
	 * @param statisticDate 时间
	 * @return 时间对应粒度的描述
	 */
	public String getTimedes(String granularity,String statisticDate){
	  String timedes = "";
	  Date date = this.stringToDateShort(statisticDate);
	  String year="",month="01",day="01";
	  year = DateToolUtils.getYear(date);
	  month = DateToolUtils.getMonth(date);
	  day = DateToolUtils.getDay(date);
	  if(granularity.equals("1")){//日
	    timedes = statisticDate;
	  }else if(granularity.equals("4")){//月
	    timedes = year+"年"+month+"月";

	  }else if(granularity.equals("8")){//季
	    String quarter = month+"-"+day;
	    if(quarter.equals("03-31")){
	      timedes = year+"年 第1季度";
	    }else if(quarter.equals("06-30")){
	      timedes = year+"年 第2季度";
	    }else if(quarter.equals("09-30")){
	      timedes = year+"年 第3季度";
	    }else if(quarter.equals("12-31")){
	      timedes = year+"年 第4季度";
	    }
	  }else if(granularity.equals("32")){//年
	    timedes = year+"年";
	  }
	  return timedes;
	}

    /**
	 * 取周初
	 * @param date
	 * @return
	 */
	public Date getWeekBegin(Date date){
		
		 int year = Integer.parseInt(this.FormatDate(date, "yyyy"));
	        int month = Integer.parseInt(this.FormatDate(date, "MM"));
	        //月份修正
	        month=month-1;
	        int day = Integer.parseInt(this.FormatDate(date, "dd"));
	       
	        GregorianCalendar gc = new GregorianCalendar(year, month, day
	                );
	        
		int week =GregorianCalendar.DAY_OF_WEEK-1;
		
		if(week==0){
			week=7;
		}
		
		gc.add(GregorianCalendar.DATE, 0-week+1);
		
		return gc.getTime();
	}

	/**
	 * 取周末
	 * @param date
	 * @return
	 */
	public Date getWeekEnd(Date date){
		
		 int year = Integer.parseInt(this.FormatDate(date, "yyyy"));
	        int month = Integer.parseInt(this.FormatDate(date, "MM"));
	        //月份修正
	        month=month-1;
	        int day = Integer.parseInt(this.FormatDate(date, "dd"));
	       
	        GregorianCalendar gc = new GregorianCalendar(year, month, day
	                );
	        
		int week =GregorianCalendar.DAY_OF_WEEK-1;
		
		if(week==0){
			week=7;
		}		
		gc.add(GregorianCalendar.DATE, 7-week);
		
		return gc.getTime();
	}

    /**
	 * 取得年初
	 * @param date
	 * @return
	 */
	public Date getYearBegin(Date date){
		String newDateStr = this.FormatDate(date,"yyyy")+"-01-01";
		return this.stringToDateShort(newDateStr);
	}
    
    /**
     * 是否为年末
     * @param date 时间
     * @return
     */
    public Date getYearEnd(Date date){
        String newDateStr = this.FormatDate(date,"yyyy")+"-12-31";
        return this.stringToDateShort(newDateStr);
    }
    
    /**
     * 是否为旬末
     * @param date 时间
     * @return 是或否
     */
    public boolean IsXperiodEnd(Date date){ 
    	
    	boolean flag = false;
        
    	String day = this.getDay(date);
        String month = this.getMonth(date);
        
        if( day.equalsIgnoreCase("10") ){
            flag = true;
        }
        else if( day.equalsIgnoreCase("20") ){
        	flag = true;
        }
        //月末不算旬末
//        else if( this.getMonthEnd(date).compareTo(date)==0 ){
//        	flag = true;
//        }
        
        return flag;
    }
    
    /**
     * 日期加N天
     * @param Sring 时间
     * @return 加后的日期
     */
	public static String addDay(String s, int n) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Calendar cd = Calendar.getInstance();
			cd.setTime(sdf.parse(s));
			cd.add(Calendar.DATE, n);// 增加一天
			// cd.add(Calendar.MONTH, n);//增加一个月

			return sdf.format(cd.getTime());

		} catch (Exception e) {
			return null;
		}
	}
	
	  /**
     * 日期加N天
     * @param Sring 时间
     * @return 加后的日期
     */
	public static String delDay(String s, int n) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Calendar cd = Calendar.getInstance();
			cd.setTime(sdf.parse(s));
			cd.add(Calendar.DATE, -n);// 增加一天
			// cd.add(Calendar.MONTH, n);//增加一个月

			return sdf.format(cd.getTime());

		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 给两个日期 封装成周的数据 [2017/02/15~2017/02/19, 2017/02/20~2017/02/26,
	 * 2017/02/27~2017/03/05, 2017/03/06~2017/03/08]
	 * 
	 * @param startTime
	 *            2017-02-15 13:43:54
	 * @param endTime
	 *            2017-03-08 13:43:54
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getBuildWeeksBetween(String startTime, String endTime) throws ParseException {
		List<String> listWeeks = getWeeksBetween(startTime, endTime);
		/**
		 * 默认七周会有重复 所以简单处理
		 */
		Set<String> set = new TreeSet<String>();
		List<String> resultWeeks = new ArrayList<String>();
		for (int i = 0; i < listWeeks.size(); i++) {
			String str = listWeeks.get(i);
			/*
			 * if(listWeeks.size()>0&&i==0){
			 * set.add(DateFormatString(changeStringToDate(startTime,
			 * "yyyy-MM-dd HH:mm:ss"
			 * ))+"~"+DateFormatString(changeStringToDate(str, "yyyy-MM-dd")));
			 * if(listWeeks.size()==1&&!listWeeks.get(i).equals(DateFormatString
			 * (changeStringToDate(endTime, "yyyy-MM-dd HH:mm:ss"
			 * ),"yyyy-MM-dd"))){//不是相同的一直
			 * set.add(DateFormatString(getCurrentWeekMonday(changeStringToDate(
			 * endTime, "yyyy-MM-dd HH:mm:ss"
			 * )))+"~"+DateFormatString(changeStringToDate(endTime,
			 * "yyyy-MM-dd HH:mm:ss"))); } continue; }
			 */
			set.add(DateFormatString(getCurrentWeekMonday(changeStringToDate(str, "yyyy-MM-dd"))) + "~"
					+ DateFormatString(changeStringToDate(str, "yyyy-MM-dd")));
			/*
			 * if(listWeeks.size()>0&&i==listWeeks.size()-1){
			 * set.add(DateFormatString(getCurrentWeekMonday(changeStringToDate(
			 * endTime, "yyyy-MM-dd HH:mm:ss"
			 * )))+"~"+DateFormatString(changeStringToDate(endTime,
			 * "yyyy-MM-dd HH:mm:ss"))); continue; }
			 */
		}
		// 不处理不是当前周了
		/*
		 * if(listWeeks.size()<1){ String str =
		 * DateFormatString(changeStringToDate(startTime, "yyyy-MM-dd HH:mm:ss"
		 * ))+"~"+DateFormatString(changeStringToDate(endTime,
		 * "yyyy-MM-dd HH:mm:ss")); set.add(str); }
		 */
		resultWeeks.addAll(set);
		return resultWeeks;
	}
	/**
	 * 获取两个时间段的周的时间 得出的周末
	 * 
	 * @param t1
	 * @param t2
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getWeeksBetween(String t1, String t2) throws ParseException {
		ArrayList<String> result = new ArrayList<String>();
		// 初始化第一个日期
		Calendar cal1 = Calendar.getInstance();
		// 初始化第二个日期，这里的天数可以随便的设置
		Calendar cal2 = Calendar.getInstance();

		// 设置传入的时间格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// 指定一个日期
		Date date1 = dateFormat.parse(t1);
		Date date2 = dateFormat.parse(t2);
		// 对 calendar 设置为 date 所定的日期
		cal1.setTime(date1);
		cal2.setTime(date2);
		while (cal1.compareTo(cal2) <= 0) {
			if (cal1.get(Calendar.DAY_OF_WEEK) == 1) {
				result.add(new SimpleDateFormat("yyyy-MM-dd").format(cal1.getTime()));
			}
			cal1.add(Calendar.DAY_OF_YEAR, 1);
		}
		return result;
	}
	/**
	 * 获取本周周一
	 * 
	 * @param date
	 * @return
	 */
	public static Date getCurrentWeekMonday(Date date) {

		Date a = DateUtils.addDays(date, -1);
		Calendar cal = Calendar.getInstance();
		cal.setTime(a);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTime();
	}
	public static String DateFormatString(Date date, String parse) {

		String formatDate = DateFormatUtils.format(date, parse);

		return formatDate;
	}
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String DateFormatString(Date date) {

		String formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");

		return formatDate;
	}

	public static Date changeStringToDate(String strDate, String parse) {
		if (StringUtils.isBlank(strDate)) {
			return null;
		}
		try {
			SimpleDateFormat format = new SimpleDateFormat(parse);
			return format.parse(strDate);
		} catch (ParseException e) {
			return null;
		}
	}
	/**
	 * 获取本周周日
	 * 
	 * @param date
	 * @return
	 */
	public static Date getCurrentWeekSunday(Date date) {

		Date a = DateUtils.addDays(date, -1);
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(a);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return cal.getTime();
	}
	
	public static String getStrDateEnd(Date date) {
		if (date == null) {
			return null;
		}
		String str = formatDate(date, "yyyy-MM-dd") + " 23:59:59";
		return str;
	}
	/**
	 * 获取dateEnd开始（包含当天到dateBegin结尾的 日期集合：：： 日期是按日或月递减
	 * 
	 * @param dateEnd
	 *            开始
	 * @param dateBegin
	 *            结尾
	 * @param size
	 *            默认生成的日期集合数 默认为7
	 * @param back
	 *            每次递减间隔的大小 获取日日期为1；获取周日期为7
	 * @return
	 */
	public static List<String> newlySevenDays(String dateBegin, String dateEnd, int size, int back) {
		List<String> listDates = new ArrayList<String>();
		if (dateEnd == null || "".equals(dateEnd))
			return null;
		if (dateBegin != null && !"".equals(dateBegin)) { // 如果有开始和结束时间，默认获取10000个日期记录
			size = 10000;
		}
		if (size == 0)
			size = 7;
		for (int i = 0; i < size; i++) {
			java.util.Calendar rightNow = java.util.Calendar.getInstance();
			rightNow.setTime(DataSpliUtil.changeStringToDateOnlyYMD(dateBegin));
			java.text.SimpleDateFormat sim = new java.text.SimpleDateFormat("yyyy-MM-dd");
			rightNow.add(java.util.Calendar.DAY_OF_MONTH, i * back);// 如果是后退几天，就写
																		// -天数
																		// 例如：
			String date = sim.format(rightNow.getTime()); // 进行时间转换
			if (dateEnd != null && !"".equals(dateEnd)) {
				if (DataSpliUtil.changeStringToDateOnlyYMD(date).getTime() > DataSpliUtil.changeStringToDateOnlyYMD(dateEnd)
						.getTime()) {
					break;
				}
			}

			listDates.add(date);
		}

		return listDates;
	}
	/**
	 * 两个日期之间的所有月份
	 * 
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException {
		ArrayList<String> result = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");// 格式化为年月
		SimpleDateFormat sdfResult = new SimpleDateFormat("yyyy-MM");
		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();

		min.setTime(sdf.parse(minDate));
		min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

		max.setTime(sdf.parse(maxDate));
		max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

		Calendar curr = min;
		while (curr.before(max)) {
			result.add(sdfResult.format(curr.getTime()));
			curr.add(Calendar.MONTH, 1);
		}
		return result;
	}
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	public static String getHm(Date date){
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm"); 
		if(date!=null){
			return sdf2.format(date);
		}else{
			return null;
		}
		
	}
}
