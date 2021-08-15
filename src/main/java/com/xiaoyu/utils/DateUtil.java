package com.xiaoyu.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtil {

    /**
     * 计算年龄, 小于1岁 按1岁算
     *
     * @param birthday 生日
     * @param nowDt    计算时间
     * @return 年龄
     */
    public static int parseAge(Date birthday, Date nowDt) {
        // 计算时间
        Calendar now = Calendar.getInstance();
        now.setTime(nowDt);
        long nowTimeInMillis = now.getTimeInMillis();

        // 生日
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthday);
        long birthTimeInMillis = birth.getTimeInMillis();

        // 结算结果
        Calendar res = Calendar.getInstance();
        long millis = nowTimeInMillis - birthTimeInMillis;
        res.setTimeInMillis(millis);
        int year = res.get(Calendar.YEAR); // 年份
        // int month = res.get(Calendar.MONTH); // 月份
        // int day = res.get(Calendar.DAY_OF_MONTH); // 天数
        // int hour = res.get(Calendar.HOUR_OF_DAY); // 小时
        // int ageYear = 1;
        // int ageMonth;
        // int ageDay;
        // if (year > 1970) {
        //     ageYear = year - 1970;
        // } else if (month > Calendar.JANUARY) {
        //     ageMonth = month - Calendar.JANUARY;
        // } else if (day > 1) {
        //     ageDay = day - 1;
        // } else {
        //     ageDay = 1;
        // }
        return (year > 1970) ? (year - 1970) : 1;
    }
}
