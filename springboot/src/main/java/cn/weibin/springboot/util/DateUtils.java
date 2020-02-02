package cn.weibin.springboot.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期时间工具类
 * 
 * @author weibin
 */
public abstract class DateUtils {

    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static final String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    public static final String FORMAT_DATE = "yyyy-MM-dd";

    public static final String FORMAT_YEAR_MONTH = "yyyyMM";

    public static String toNormlString(Date date) {
        return toStringFormat(date, FORMAT_DATE_TIME);
    }

    public static String toDateString(Date date) {
        return toStringFormat(date, FORMAT_DATE);
    }

    public static String toStringFormat(Date date, String format) {
        String dateString = null;
        if (date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            dateString = formatter.format(date);
        }
        return dateString;
    }

    public static Date parseDate(String strDate) {
        return parseDateTime(strDate, FORMAT_DATE);
    }

    public static Date parseDateTime(String strDate) {
        return parseDateTime(strDate, FORMAT_DATE_TIME);
    }

    public static Date parseDateTime(String strDate, String format) {
        Date date = null;
        if (strDate != null && !"".equals(strDate)) {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            try {
                date = formatter.parse(strDate);
            } catch (ParseException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return date;
    }

    /**
     * 添加日期小时数
     * 
     * @param date
     * @param hours
     * @return
     */
    public static Date addHours(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    /**
     * 添加日期分钟数
     * 
     * @param date
     * @param minutes
     * @return
     */
    public static Date addMinute(Date date, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }

    /**
     * 添加日期天数
     * 
     * @param date
     * @param days
     * @return
     */
    public static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    /**
     * 添加日期月数
     * 
     * @param date
     * @param days
     * @return
     */
    public static Date addMonths(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, days);
        return calendar.getTime();
    }

    /**
     * 添加日期月数
     * 
     * @param date
     * @param days
     * @return
     */
    public static Date addYears(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, days);
        return calendar.getTime();
    }

    /**
     * 比较2个时间是否是相同的日期
     * 
     * @param d1
     * @param d2
     * @return
     */
    public static boolean isSameOfDate(Date d1, Date d2) {
        String date1 = DateUtils.toStringFormat(d1, FORMAT_DATE);
        String date2 = DateUtils.toStringFormat(d2, FORMAT_DATE);
        return date1.equals(date2);
    }

    /**
     * 时间清零, 只留日期
     * 
     * @param date
     * @return
     */
    public static Date timeClear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date1, Date date2) {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
        return days;
    }

}
