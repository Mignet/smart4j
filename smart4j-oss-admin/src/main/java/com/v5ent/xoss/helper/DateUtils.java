package com.v5ent.xoss.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @描述：日期工具类 默认使用 "yyyy-MM-dd HH:mm:ss" 格式化日期
 *
 * @author Mignet
 * @时间  2015年8月20日下午1:57:08
 *
 */
public final class DateUtils {
	private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);
	public static String FORMAT_SHORT = "yyyy-MM-dd";
	public static String FORMAT_MM = "yyyy-MM-dd HH:mm";
	public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";
	public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";
	public static String FORMAT_SHORT_CN = "yyyy年MM月dd";
	public static String FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒";
	public static String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";
	public static String FORMAT_DATE_CN = "yyMMdd";

	/**
	 * 获得默认的 date pattern 　　
	 */
	public static String getDatePattern() {
		return FORMAT_LONG;
	}

	/**
	 * 根据预设格式返回当前日期 　　
	 * 
	 * @return 　　
	 */
	public static String getNow() {
		return format(new Date());
	}

	/**
	 * 根据用户格式返回当前日期 　
	 * 
	 * @param format
	 *            　　
	 * @return 　　
	 */
	public static String getNow(String format) {
		return format(new Date(), format);
	}

	/**
	 * 使用预设格式格式化日期 　　
	 * 
	 * @param date
	 *            　　
	 * @return 　　
	 */
	public static String format(Date date) {
		if(date==null){
			return "";
		}
		return format(date, getDatePattern());
	}

	/**
	 * 使用用户格式格式化日期 　
	 * 
	 * @param date
	 *            日期 　　
	 * @param pattern
	 *            日期格式 　　
	 * @return 　　
	 */
	public static String format(Date date, String pattern) {
		String returnValue = "";
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			returnValue = df.format(date);
		}
		return (returnValue);
	}
	
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @param pattern yyyy-MM-dd or yyyy-MM or yyyy
	 * @return
	 */
	public static List<String> getBetweeenTime(Date startDate,Date endDate,String pattern) {
		int type = 0;
		if(pattern.contains("HH")){
			 type = Calendar.HOUR;
		}else if(pattern.contains("dd")){
			 type = Calendar.DATE;
		}else if(pattern.contains("MM")){
			 type = Calendar.MONTH;
		}else if(pattern.contains("yyyy")){
			 type = Calendar.YEAR;
		}
		String strStartDate = format(startDate,pattern);
		String strEndDate = format(endDate,pattern);
		Date theEndDate = parse(strEndDate,pattern);
		
		Date currDate = parse(strStartDate,pattern);
		Calendar cal = Calendar.getInstance();
		cal.setTime(currDate);
		List<String> ret = new ArrayList<String>();
		while(!cal.getTime().after(theEndDate)){
			ret.add(format(cal.getTime(),pattern));
			cal.add(type,1);
		}
		return ret;
	}
	

	/**
	 * 使用预设格式提取字符串日期 　　
	 * 
	 * @param strDate
	 *            日期字符串 　　
	 * @return 　　
	 */
	public static Date parse(String strDate) {
		return parse(strDate, getDatePattern());
	}

	/**
	 * 使用用户格式提取字符串日期 　　
	 *
	 * @param strDate
	 *            日期字符串 　　
	 * @param pattern
	 *            日期格式 　　
	 * @return 　　
	 */
	public static Date parse(String strDate, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			return df.parse(strDate);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 使用用户格式提取字符串日期 　　
	 *
	 * @param date
	 *            日期 　　
	 * @param pattern
	 *            日期格式 　　
	 * @return 　　
	 * 
	 * @throws ParseException
	 */
	public static Date parse(Date date, String pattern) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.parse(df.format(date));
	}

	/**
	 * 在日期上增加数个整月 　　
	 * 
	 * @param date
	 *            日期 　　
	 * @param n
	 *            要增加的月数 　　
	 * @return 　　
	 */
	public static Date addMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

	/**
	 * 在日期上减去天数 　　
	 * 
	 * @param date
	 *            日期 　　
	 * @param n
	 *            要减去的天数 　　
	 * @return 　　
	 */
	public static Date subDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - n);
		return cal.getTime();
	}

	/**
	 * 在日期上增加天数 　　
	 *
	 * @param date
	 *            日期 　　
	 * @param n
	 *            要增加的天数 　　
	 * @return 　　
	 */
	public static Date addDay(Date date, int n) {
		if(date == null || n == 0){
			return date;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, n);
		return cal.getTime();
	}
	
	/**
	 * 在日期上增加天数 　　
	 *
	 * @param date
	 *            日期 　　
	 * @param n
	 *            要增加的天数 　　
	 * @return 　　
	 */
	public static Date addHour(Date date, int n) {
		if(date == null || n == 0){
			return date;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, n);
		return cal.getTime();
	}

	/**
	 * 获取时间戳 　　
	 */
	public static String getTimeString() {
		SimpleDateFormat df = new SimpleDateFormat(FORMAT_FULL);
		Calendar calendar = Calendar.getInstance();
		return df.format(calendar.getTime());
	}

	/**
	 * 获取日期年份 　　
	 *
	 * @param date
	 *            日期 　　
	 * @return 　　
	 */
	public static String getYear(Date date) {
		return format(date).substring(0, 4);
	}
	/**
	 * 获取季度(中文)
	 * @param date
	 * @return
	 */
	public static String getSeasonCn(Date date) {
		 String season = null;  
	        Calendar c = Calendar.getInstance();  
	        c.setTime(date);  
	        int month = c.get(Calendar.MONTH);  
	        switch (month) {  
	        case Calendar.JANUARY:  
	        case Calendar.FEBRUARY:  
	        case Calendar.MARCH:  
	            season = "一";  
	            break;  
	        case Calendar.APRIL:  
	        case Calendar.MAY:  
	        case Calendar.JUNE:  
	            season = "二";  
	            break;  
	        case Calendar.JULY:  
	        case Calendar.AUGUST:  
	        case Calendar.SEPTEMBER:  
	            season = "三";  
	            break;  
	        case Calendar.OCTOBER:  
	        case Calendar.NOVEMBER:  
	        case Calendar.DECEMBER:  
	            season = "四";  
	            break;  
	        default:  
	            break;  
	        }  
	        return season; 
	}
	/**
	 * 获取季度
	 * @param date
	 * @return
	 */
	public static int getSeason(Date date) {  
        int season = 0;  
        Calendar c = Calendar.getInstance();  
        c.setTime(date);  
        int month = c.get(Calendar.MONTH);  
        switch (month) {  
        case Calendar.JANUARY:  
        case Calendar.FEBRUARY:  
        case Calendar.MARCH:  
            season = 1;  
            break;  
        case Calendar.APRIL:  
        case Calendar.MAY:  
        case Calendar.JUNE:  
            season = 2;  
            break;  
        case Calendar.JULY:  
        case Calendar.AUGUST:  
        case Calendar.SEPTEMBER:  
            season = 3;  
            break;  
        case Calendar.OCTOBER:  
        case Calendar.NOVEMBER:  
        case Calendar.DECEMBER:  
            season = 4;  
            break;  
        default:  
            break;  
        }  
        return season;  
    }  

	/**
	 * 按默认格式的字符串距离今天的天数 　　
	 * 
	 * @param date
	 *            日期字符串 　　
	 * @return 　　
	 */
	public static int countDays(String date) {
		long t = Calendar.getInstance().getTime().getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(parse(date));
		long t1 = c.getTime().getTime();
		return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
	}

	/**
	 * 　　 按用户格式字符串距离今天的天数 　　
	 * 
	 * @param date
	 *            日期字符串 　　
	 * @param format
	 *            日期格式 　 　
	 * @return 　　
	 */
	public static int countDays(String date, String format) {
		long t = Calendar.getInstance().getTime().getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(parse(date, format));
		long t1 = c.getTime().getTime();
		return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
	}

	/**
	 * 
	 * countDays(计算连个时间点相隔多少天)
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 * 
	 *         author：zhou'sheng
	 */
	public static int countDays(Date date1, Date date2) {

		Date dateA, dateB, temp;

		try {
			dateA = parse(date1, "yyyy-MM-dd");
			dateB = parse(date2, "yyyy-MM-dd");
		} catch (ParseException e) {
			return 0;
		}

		if (dateA.getTime() == dateB.getTime()) {
			return 0;
		}

		if (dateA.getTime() < dateB.getTime()) {
			temp = dateA;
			dateA = dateB;
			dateB = temp;
		}

		Calendar cA = Calendar.getInstance();
		Calendar cB = Calendar.getInstance();
		cA.setTime(dateA);
		cB.setTime(dateB);

		long t1 = dateA.getTime();
		long t2 = dateB.getTime();

		return (int) (t1 / 1000 - t2 / 1000) / 3600 / 24;
	}

	/**
	 * @param date1
	 *            需要比较的时间 不能为空(null),需要正确的日期格式
	 * @param date2
	 *            被比较的时间 为
	 * @param stype
	 *            返回值类型 0为多少天，1为多少个月，2为多少年
	 * @return
	 */
	public static int compareDate(Date date1, Date date2, int stype) {
		int n = 0;
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(date1);
		c2.setTime(date2);
		while (!c1.after(c2)) { // 循环对比，直到相等，n 就是所要的结果
			n++;
			if (stype == 1) {
				c1.add(Calendar.MONTH, 1); // 比较月份，月份+1
			} else {
				c1.add(Calendar.DATE, 1); // 比较天数，日期+1
			}
		}
		n = n - 1;
		if (stype == 2) {
			n = (int) n / 365;
		}
		return n;
	}
	/**
	 * @param date1
	 *            需要比较的时间 不能为空(null),需要正确的日期格式
	 * @param date2
	 *            被比较的时间 为
	 * @param stype
	 *            返回值类型 0为多少天，1为多少个月，2为多少年
	 * @return
	 */
	public static int compareDate(String date1, String date2, int stype) {
		int n = 0;
		String formatStyle = stype == 1 ? "yyyy-MM" : "yyyy-MM-dd";

		DateFormat df = new SimpleDateFormat(formatStyle);
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		try {
			c1.setTime(df.parse(date1));
			c2.setTime(df.parse(date2));
		} catch (Exception e3) {
			logger.error("时间比较错误：",e3);
		}

		while (!c1.after(c2)) { // 循环对比，直到相等，n 就是所要的结果
			n++;
			if (stype == 1) {
				c1.add(Calendar.MONTH, 1); // 比较月份，月份+1
			} else {
				c1.add(Calendar.DATE, 1); // 比较天数，日期+1
			}
		}

		n = n - 1;

		if (stype == 2) {
			n = (int) n / 365;
		}

		return n;
	}

	/**
	 * 
	 * compareDate(比较时间大小)
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 * 
	 * @author：zhou'sheng
	 */
	public static int compareDate(Date date1, Date date2) {
		if(date1 == null || null == date2){
			return 0;
		}
		try {
			if (date1.getTime() > date2.getTime()) {
				return 1;
			} else if (date1.getTime() < date2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 得到当前日期
	 * 
	 * @return
	 */
	public static String getCurrentDate() {
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		return simple.format(date);
	}
	

	

	public static int getMonths(String date1, String date2) {
		int year, month;
		Date dateA, dateB, temp;

		dateA = parse(date1, "yyyy-MM-dd");
		dateB = parse(date2, "yyyy-MM-dd");

		if (dateA.getTime() == dateB.getTime()) {
			return 0;
		}

		if (dateA.getTime() < dateB.getTime()) {
			temp = dateA;
			dateA = dateB;
			dateB = temp;
		}

		Calendar cA = Calendar.getInstance();
		Calendar cB = Calendar.getInstance();
		cA.setTime(dateA);
		cB.setTime(dateB);

		year = cA.get(Calendar.YEAR) - cB.get(Calendar.YEAR);// 年
		month = cA.get(Calendar.MONTH) - cB.get(Calendar.MONTH);// 月

		if (year > 0) {
			if (month > 0) {
				if (cB.get(Calendar.DATE) > cA.get(Calendar.DATE)) {
					month--;
				} else if (cB.get(Calendar.DATE) == cA.get(Calendar.DATE)) {

				} else {

				}
			} else if (month == 0) {
				if (cB.get(Calendar.DATE) > cA.get(Calendar.DATE)) {
					month = -1;
				} else if (cB.get(Calendar.DATE) == cA.get(Calendar.DATE)) {

				} else {

				}
			} else {
				if (cA.get(Calendar.DATE) > cB.get(Calendar.DATE)) {

				} else if (cA.get(Calendar.DATE) == cB.get(Calendar.DATE)) {

				} else {
					month--;
				}
			}
		} else {
			if (month > 0) {
				if (cB.get(Calendar.DATE) > cA.get(Calendar.DATE)) {
					month--;
				} else if (cB.get(Calendar.DATE) == cA.get(Calendar.DATE)) {

				} else {

				}
			}
		}

		return year * 12 + month;
	}

	
	
	/**
     * 得到某年某周的第一天
     *
     * @param year
     * @param week
     * @return
     */
    public static Date getFirstDayOfWeek(int year, int week) {
        week = week - 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);

        Calendar cal = (Calendar) calendar.clone();
        cal.add(Calendar.DATE, week * 7);

        return getFirstDayOfWeek(cal.getTime());
    }

    /**
     * 得到某年某周的最后一天
     *
     * @param year
     * @param week
     * @return
     */
    public static Date getLastDayOfWeek(int year, int week) {
        week = week - 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);
        Calendar cal = (Calendar) calendar.clone();
        cal.add(Calendar.DATE, week * 7);

        return getLastDayOfWeek(cal.getTime());
    }

    /**
     * 取得当前日期所在周的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,
                      calendar.getFirstDayOfWeek()); // Sunday
        return calendar.getTime();
    }

    /**
     * 取得当前日期所在周的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,
                     calendar.getFirstDayOfWeek() + 6); // Saturday
        return calendar.getTime();
    }

    /**
     * 取得当前日期所在周的前一周最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfLastWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfWeek(calendar.get(Calendar.YEAR),
                                calendar.get(Calendar.WEEK_OF_YEAR) - 1);
    }

    /**
     * 返回指定日期的月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH), 1);
        return calendar.getTime();
    }

    /**
     * 返回指定年月的月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        return calendar.getTime();
    }

    /**
     * 返回指定日期的月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH), 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 返回指定年月的月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 返回指定日期的上个月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfLastMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH) - 1, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 返回指定日期的季的第一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getFirstDayOfQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getFirstDayOfQuarter(calendar.get(Calendar.YEAR),
                                    getQuarterOfYear(date));
    }

    /**
     * 返回指定年季的季的第一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getFirstDayOfQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 1 - 1;
        } else if (quarter == 2) {
            month = 4 - 1;
        } else if (quarter == 3) {
            month = 7 - 1;
        } else if (quarter == 4) {
            month = 10 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getFirstDayOfMonth(year, month);
    }

    /**
     * 返回指定日期的季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfQuarter(calendar.get(Calendar.YEAR),
                                   getQuarterOfYear(date));
    }
    
    /**
     * 获取下季度第一天
     * @param date
     * @return
     */
    public static Date getFirstDayOfNextQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setTime(getLastDayOfQuarter(calendar.get(Calendar.YEAR),
                                   getQuarterOfYear(date)));
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTime();
    }
    
    /**
     * 获取下季度最后一天
     * @param date
     * @return
     */
    public static Date getLastDayOfNextQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 3);
        calendar.setTime(getLastDayOfQuarter(calendar.get(Calendar.YEAR),
                                   getQuarterOfYear(calendar.getTime())));
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTime();
    }


    /**
     * 返回指定年季的季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 3 - 1;
        } else if (quarter == 2) {
            month = 6 - 1;
        } else if (quarter == 3) {
            month = 9 - 1;
        } else if (quarter == 4) {
            month = 12 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getLastDayOfMonth(year, month);
    }
    
    /**
     * 返回指定日期的上一季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfLastQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfLastQuarter(calendar.get(Calendar.YEAR),
                                       getQuarterOfYear(date));
    }

    /**
     * 返回指定年季的上一季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfLastQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 12 - 1;
        } else if (quarter == 2) {
            month = 3 - 1;
        } else if (quarter == 3) {
            month = 6 - 1;
        } else if (quarter == 4) {
            month = 9 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getLastDayOfMonth(year, month);
    }

    /**
     * 返回指定日期的季度
     *
     * @param date
     * @return
     */
    public static int getQuarterOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) / 3 + 1;
    }
    
	public static  String getMonth() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		month = month + 1;
		StringBuilder sb = new StringBuilder();
		sb.append(year).append("-");
		if (month < 10) {
			sb.append("0");
		}
		sb.append(month);
		return sb.toString();
	}
	/**
	 * 佣金发放月份
	 * @return
	 */
	public static  String getCommissionMonth() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		if (month == 0) {
			//1月份处理去年12月份
			year = year - 1;
			month = 12;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(year).append("年");
		if (month < 10) {
			sb.append("0");
		}
		sb.append(month).append("月");
		return sb.toString();
	}
	

}