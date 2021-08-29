package com.xiaoyu.utils;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期工具类
 */
public class DateUtil {

    public static final String default_format_seconds = "HH:mm:ss"; // 时:分:秒
    public static final String default_format_min = "HH:mm"; // 时:分
    public static final String default_format_date_day = "yyyy-MM-dd"; // 年-月-日 时:分:秒
    public static final String default_format_date_min = "yyyy-MM-dd HH:mm"; // 年-月-日 时:分:秒
    public static final String default_format_date_seconds = "yyyy-MM-dd HH:mm:ss"; // 年-月-日 时:分:秒

    public static final String default_format_date_day_begin = "yyyy-MM-dd 00:00:00"; // 一天的开始日期
    public static final String default_format_date_day_End = "yyyy-MM-dd 23:59:59"; // 一天的结束日期

    public static final String default_format_date_cst = "EEE MMM dd HH:mm:ss zzz yyyy"; // cst 格式日期

    /**
     * 获取日期天的结束时间
     *
     * @param date Date日期
     * @return 一天的结束
     */
    public static String dateOfEnd(Date date) {
        if (date == null) return null;
        DateFormat simpleDateFormat = new SimpleDateFormat(default_format_date_day_End);
        return simpleDateFormat.format(date);
    }

    /**
     * 获取日期天的起始时间
     *
     * @param date Date日期
     * @return 一天的开始
     */
    public static String dateOfBegin(Date date) {
        if (date == null) return null;
        DateFormat simpleDateFormat = new SimpleDateFormat(default_format_date_day_begin);
        return simpleDateFormat.format(date);
    }

    /**
     * String 转 Date,失败返回null, 默认格式:[yyyy-MM-dd HH:mm:ss]
     *
     * @param strDate String日期
     * @return Date日期
     */
    public static Date stringToDate(String strDate) {
        if (StringUtils.isBlank(strDate)) return null;
        DateFormat simpleDateFormat = new SimpleDateFormat(default_format_date_seconds);
        try {
            return simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            System.out.println("日期转换错误：String转Date出错");
        }
        return null;
    }

    /**
     * cst格式String 转 Date,失败返回null, 默认格式:[yyyy-MM-dd HH:mm:ss]
     *
     * @param strDate String日期
     * @return Date日期
     */
    public static Date cstStringToDate(String strDate) {
        if (StringUtils.isBlank(strDate)) return null;
        DateFormat simpleDateFormat = new SimpleDateFormat(default_format_date_cst, Locale.US);
        try {
            return simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            System.out.println("日期转换错误：cst格式String转Date出错");
        }
        return null;
    }

    /**
     * String 转 Date, 失败返回null
     *
     * @param strDate String日期
     * @param pattern 转换格式
     * @return Date日期, 失败返回null
     */
    public static Date stringToDate(String strDate, String pattern) {
        if (StringUtils.isBlank(strDate) || StringUtils.isBlank(pattern)) return null;
        DateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            return simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            System.out.println("日期转换错误：String转Date出错");
        }
        return null;
    }

    /**
     * Date 转 String,失败返回null, 默认格式:[yyyy-MM-dd HH:mm:ss]
     *
     * @param date Date日期
     * @return String日期
     */
    public static String dateToString(Date date) {
        if (date == null) return null;
        DateFormat simpleDateFormat = new SimpleDateFormat(default_format_date_seconds);
        return simpleDateFormat.format(date);
    }

    /**
     * Date 转 String, 失败返回null
     *
     * @param date    Date日期
     * @param pattern 转换格式
     * @return String日期, 失败返回null
     */
    public static String dateToString(String date, String pattern) {
        if (date == null || StringUtils.isBlank(pattern)) return null;
        DateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     * 计算出生日期到指定日期的年龄, 公共部分抽取
     *
     * @param birthday 生日
     * @param nowDate  计算时间
     * @return Calendar 日历
     */
    private static Calendar figureAge(Date birthday, Date nowDate) {
        // 计算时间
        Calendar now = Calendar.getInstance();
        now.setTime(nowDate);
        long nowTimeInMillis = now.getTimeInMillis();
        // 生日
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthday);
        long birthTimeInMillis = birth.getTimeInMillis();
        // 结算结果
        Calendar res = Calendar.getInstance();
        long millis = nowTimeInMillis - birthTimeInMillis;
        res.setTimeInMillis(millis);
        return res;
    }

    /**
     * 计算出生日期到指定日期的年龄, [精确到年]
     * - 小于1岁 按1岁算
     *
     * @param birthday 生日
     * @param nowDate  计算时间
     * @return 年龄
     */
    public static int figureAgeYear(Date birthday, Date nowDate) {
        Calendar res = figureAge(birthday, nowDate);
        int year = res.get(Calendar.YEAR); // 年份
        return (year > 1970) ? (year - 1970) : 1;
    }

    /**
     * 计算出生日期到指定日期的年龄, [精确到月, 年-月]
     * - 小于1岁 按1岁算
     * - 小于1月 返回00
     *
     * @param birthday 生日
     * @param nowDate  计算时间
     * @return 年龄[年龄-月数 ]
     */
    public static String figureAgeMonth(Date birthday, Date nowDate) {
        Calendar res = figureAge(birthday, nowDate);
        int year = res.get(Calendar.YEAR); // 年份
        int month = res.get(Calendar.MONTH); // 月份
        int ageYear = 1;
        int ageMonth = 0;
        if (year > 1970) ageYear = year - 1970;
        if (month > Calendar.JANUARY) ageMonth = month - Calendar.JANUARY;
        return ageYear + "-" + String.format("%02d", ageMonth);
    }

    /**
     * 计算出生日期到指定日期的年龄,[精确到日, 年-月-日]
     * - 小于1岁 按1岁算
     * - 小于1月 返回00
     * - 小于1天 返回00
     *
     * @param birthday 生日
     * @param nowDate  计算时间
     * @return 年龄[年龄-月数-天数]
     */
    public static String figureAgeDay(Date birthday, Date nowDate) {
        Calendar res = figureAge(birthday, nowDate);
        int year = res.get(Calendar.YEAR); // 年份
        int month = res.get(Calendar.MONTH); // 月份
        int day = res.get(Calendar.DAY_OF_MONTH); // 天数
        int ageYear = 1;
        int ageMonth = 0;
        int ageDay = 0;
        if (year > 1970) ageYear = year - 1970;
        if (month > Calendar.JANUARY) ageMonth = month - Calendar.JANUARY;
        if (day > 1) ageDay = day - 1;
        return ageYear + "-" + String.format("%02d", ageMonth) + "-" + String.format("%02d", ageDay);
    }

    // main测试
    public static void main(String[] args) {
        // System.out.println(dateToString(new Date()));
        // System.out.println(stringToDate("2021-08-21", default_format_date_day));
        // System.out.println(String.format("%02d", 3));
        // System.out.println(figureAgeMonth(stringToDate("1996-09-06", default_format_date_day), new Date()));
        // System.out.println(figureAgeDay(stringToDate("1996-09-06", default_format_date_day), new Date()));
        System.out.println(figureAgeDay(stringToDate("1996-09-06", default_format_date_day), stringToDate("2021-10-07", default_format_date_day)));
    }
}
