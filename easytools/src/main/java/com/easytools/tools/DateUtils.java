package com.easytools.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * package: com.easytools.tools.DateUtils
 * author: gyc
 * description:与日期操作相关的工具类
 * time: create at 2017/1/15 15:41
 */

public class DateUtils {

    /**
     * 英文简写如：2010
     */
    public static String FORMAT_Y = "yyyy";

    /**
     * 英文简写如：12:01
     */
    public static String FORMAT_HM = "HH:mm";

    /**
     * 英文简写如：1-12 12:01
     */
    public static String FORMAT_MDHM = "MM-dd HH:mm";

    /**
     * 英文简写（默认）如：2010-12-01
     */
    public static String FORMAT_YMD = "yyyy-MM-dd";

    /**
     * 英文全称  如：2010-12-01 23:15
     */
    public static String FORMAT_YMDHM = "yyyy-MM-dd HH:mm";

    /**
     * 英文全称  如：2010-12-01 23:15:06
     */
    public static String FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 精确到毫秒的完整时间    如：yyyy-MM-dd HH:mm:ss.S
     */
    public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";

    /**
     * 精确到毫秒的完整时间    如：yyyy-MM-dd HH:mm:ss.S
     */
    public static String FORMAT_FULL_SN = "yyyyMMddHHmmssS";

    /**
     * 中文简写  如：2010年12月01日
     */
    public static String FORMAT_YMD_CN = "yyyy年MM月dd日";

    /**
     * 中文简写  如：2010年12月01日 12时
     */
    public static String FORMAT_YMDH_CN = "yyyy年MM月dd日 HH时";

    /**
     * 中文简写  如：2010年12月01日 12时12分
     */
    public static String FORMAT_YMDHM_CN = "yyyy年MM月dd日 HH时mm分";

    /**
     * 中文全称  如：2010年12月01日 23时15分06秒
     */
    public static String FORMAT_YMDHMS_CN = "yyyy年MM月dd日  HH时mm分ss秒";

    /**
     * 精确到毫秒的完整中文时间
     */
    public static String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";

    public static Calendar calendar = null;

    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 将字符串按照给定格式做解析，使用默认格式："yyyy-MM-dd HH:mm:ss"
     *
     * @param str 待解析的字符串
     * @return Date对象
     */
    public static Date str2Date(String str) {
        return str2Date(str, null);
    }

    /**
     * 将字符串按照给定格式做解析，如format为空则使用默认格式："yyyy-MM-dd HH:mm:ss"
     *
     * @param str    待解析的字符串
     * @param format 给定的解析格式，若为null则使用"yyyy-MM-dd HH:mm:ss"解析
     * @return Date对象
     */
    public static Date str2Date(String str, String format) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (format == null || format.length() == 0) {
            format = FORMAT;
        }
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将字符串按照给定格式做解析，使用默认格式："yyyy-MM-dd HH:mm:ss"
     *
     * @param str 待解析的字符串
     * @return Calendar对象
     */
    public static Calendar str2Calendar(String str) {
        return str2Calendar(str, null);
    }

    /**
     * 将字符串按照给定格式做解析，如format为空则使用默认格式："yyyy-MM-dd HH:mm:ss"
     *
     * @param str    待解析的字符串
     * @param format 给定的解析格式，若为null则使用"yyyy-MM-dd HH:mm:ss"解析
     * @return Calendar对象
     */
    public static Calendar str2Calendar(String str, String format) {
        Date date = str2Date(str, format);
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }

    /**
     * Calendar转为字符串，使用默认格式：yyyy-MM-dd HH:mm:ss
     *
     * @param c
     * @return
     */
    public static String calendar2Str(Calendar c) {// yyyy-MM-dd HH:mm:ss
        return calendar2Str(c, null);
    }

    /**
     * Calendar转为字符串，
     *
     * @param c
     * @param format 使用的格式，为null则使用默认格式：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String calendar2Str(Calendar c, String format) {
        if (c == null) {
            return null;
        }
        return date2Str(c.getTime(), format);
    }

    /**
     * Date转为字符串，使用默认格式：yyyy-MM-dd HH:mm:ss
     *
     * @param d
     * @return
     */
    public static String date2Str(Date d) {// yyyy-MM-dd HH:mm:ss
        return date2Str(d, null);
    }

    /**
     * Date转为字符串
     *
     * @param d
     * @param format 格式，为null则使用默认格式：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2Str(Date d, String format) {// yyyy-MM-dd HH:mm:ss
        if (d == null) {
            return null;
        }
        if (format == null || format.length() == 0) {
            format = FORMAT;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String s = sdf.format(d);
        return s;
    }

    /**
     * 返回当前的日期和时间
     *
     * @return 如：2017-1-15 16:37:15
     */
    public static String getCurDateStr() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" +
                c.get(Calendar.DAY_OF_MONTH) + " " + c.get(Calendar.HOUR_OF_DAY) +
                ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
    }

    /**
     * 获得当前日期的字符串格式
     * @param format    格式化的类型
     * @return  返回格式化之后的事件
     */
    public static String getCurDateStr(String format) {
        Calendar c = Calendar.getInstance();
        return calendar2Str(c, format);
    }

    /**
     * 返回当前时间字符串
     *
     * @param time 当前的时间
     * @return  格式到秒
     */
    public static String getMillon(long time) {
        return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(time);
    }

    /**
     * 返回给定天的字符串
     *
     * @param time  当前的时间
     * @return  当前的天
     */
    public static String getDay(long time) {
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }

    /**
     * 返回给定时间的毫秒字符串
     *
     * @param time 时间
     * @return 返回一个毫秒
     */
    // 格式到毫秒
    public static String getSMillon(long time) {
        return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS").format(time);
    }

    /**
     * 时间转换
     * @param time
     * @param format
     * @return
     */
    public static String getDateByLong(long time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date(time);
        return sdf.format(date);
    }

    /**
     * 在日期上增加数个整月
     * @param date 日期
     * @param n 要增加的月数
     * @return   增加数个整月
     */
    public static Date addMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();

    }

    /**
     * 在日期上增加天数
     * @param date 日期
     * @param n 要增加的天数
     * @return   增加之后的天数
     */
    public static Date addDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return cal.getTime();

    }

    /**
     * 获取距现在某一小时的时刻
     *
     * @param format 格式化时间的格式
     * @param h 距现在的小时 例如：h=-1为上一个小时，h=1为下一个小时
     * @return  获取距现在某一小时的时刻
     */
    public static String getNextHour(String format, int h) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date();
        date.setTime(date.getTime() + h * 60 * 60 * 1000);
        return sdf.format(date);
    }

    /**
     * 获取时间戳
     * @return 获取时间戳
     */
    public static String getTimeStamp() {
        SimpleDateFormat df = new SimpleDateFormat(FORMAT_FULL);
        Calendar calendar = Calendar.getInstance();
        return df.format(calendar.getTime());

    }

    /**
     * 功能描述：返回月
     *
     * @param date Date 日期
     * @return 返回月份
     */
    public static int getMonth(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 功能描述：返回日
     *
     * @param date Date 日期
     * @return 返回日份
     */
    public static int getDay(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 功能描述：返回小时
     *
     * @param date 日期
     * @return 返回小时
     */
    public static int getHour(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 功能描述：返回分
     *
     * @param date 日期
     * @return 返回分钟
     */
    public static int getMinute(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 返回秒
     *
     * @param date Date 日期
     * @return 秒数
     */
    public static int getSecond(Date date) {
        calendar = Calendar.getInstance();

        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 功能描述：返回毫秒
     *
     * @param date 日期
     * @return 返回毫
     */
    public static long getMillis(Date date) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    /**
     * 获得默认的日期格式：yyyy-MM-dd HH:mm:ss
     * @return  默认的格式
     */
    public static String getDatePattern() {
        return FORMAT_YMDHMS;
    }

    /**
     * 按默认格式的字符串距离今天的天数
     *
     * @param date 日期字符串
     * @return 按默认格式的字符串距离今天的天数
     */
    public static int countDays(String date) {
        long t = Calendar.getInstance().getTime().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(parse(date));
        long t1 = c.getTime().getTime();
        return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
    }


    /**
     * 按用户格式字符串距离今天的天数
     *
     * @param date 日期字符串
     * @param format 日期格式
     * @return  按用户格式字符串距离今天的天数
     */
    public static int countDays(String date, String format) {
        long t = Calendar.getInstance().getTime().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(parse(date, format));
        long t1 = c.getTime().getTime();
        return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
    }

    public static Date parse(String strDate) {
        return parse(strDate, getDatePattern());
    }

    /**
     * 使用用户格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @param pattern 日期格式
     * @return  提取字符串日期
     */
    public static Date parse(String strDate, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }
}
