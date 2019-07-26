package com.example.study.utils;


import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 处理时间
 * 
 * @author qingli8
 * @date 2018年2月26日
 */
public class TimeUtil {

    /**
     * 根据指定格式格式化时间
     * 
     * @param date
     * @param format
     * @return
     */
    public static String dateToStr(Date date, String format) {
        return (new SimpleDateFormat(format, Locale.CHINA)).format(date);
    }

    /**
     * 根据指定格式解析时间字符串
     * 
     * @param datestr
     * @param format
     * @return
     */
    public static Date strToDate(String str, String format) {
        if (StringUtils.isNotBlank(str) && StringUtils.isNotBlank(format)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);

            try {
                return sdf.parse(str);
            } catch (Exception e) {
                e.printStackTrace();

                return null;
            }
        }

        return null;
    }

    /**
     * 输出指定格式时间字符串
     * 
     * @param fromStr
     * @param fromFormat
     * @param toFormat
     * @return
     */
    public static String strToStr(String fromStr, String fromFormat, String toFormat) {
        return TimeUtil.dateToStr(TimeUtil.strToDate(fromStr, fromFormat), toFormat);
    }

    /**
     * 日期增加天数(int)
     * 
     * @param date
     * @param days
     * @return
     */
    public static Date addDays(Date date, int days) {
        if (null == date)
            return null;
        if (0 == days)
            return date;

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, days);

        return c.getTime();
    }

    /**
     * 日期增加小时数(int)
     * 
     * @param date
     * @param seconds
     * @return
     */
    public static Date addHours(Date date, int hours) {
        if (null == date)
            return null;
        if (0 == hours)
            return date;

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR_OF_DAY, hours);

        return c.getTime();
    }

    /**
     * 日期增加分钟数(int)
     * 
     * @param date
     * @param seconds
     * @return
     */
    public static Date addMinutes(Date date, int minutes) {
        if (null == date)
            return null;
        if (0 == minutes)
            return date;

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, minutes);

        return c.getTime();
    }

    /**
     * 日期增加秒数(int)
     * 
     * @param date
     * @param seconds
     * @return
     */
    public static Date addSeconds(Date date, int seconds) {
        if (null == date)
            return null;
        if (0 == seconds)
            return date;

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.SECOND, seconds);

        return c.getTime();
    }

    /**
     * 日期增加毫秒数(int)
     * 
     * @param date
     * @param days
     * @return
     */
    public static Date addMills(Date date, int mills) {
        if (null == date)
            return null;
        if (0 == mills)
            return date;

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MILLISECOND, mills);

        return c.getTime();
    }

    /**
     * 获取零点时间“yyyy-MM-dd 00:00:00.000”
     * 
     * @param date
     * @return
     */
    public static Date getZeroDate(Date date) {
        if (null == date)
            return null;

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return c.getTime();
    }

    /**
     * 判断结束时间是否在开始时间之后,如果是则返回“yyyy-MM-ddT23:59:59.999”时间
     * 
     * @param stTime
     * @param edTime
     * @return
     */
    public static String getScanEndTime(String stTime, String edTime) {
        String str = stTime.substring(0, 10) + "T23:59:59.999";

        boolean isAfter = getDateFromEsDateStr(edTime).after(getDateFromEsDateStr(str));
        if (isAfter)
            return str;
        else
            return edTime;
    }

    /**
     * 将ES时间格式 yyyy-MM-ddTHH:mm:ss.SSS转换为Date
     * 
     * @param dateStr yyyy-MM-ddTHH:mm:ss.SSS
     * @return
     */
    public static Date getDateFromEsDateStr(String dateStr) {
        if (StringUtils.isBlank(dateStr))
            return null;

        if (dateStr.contains("T"))
            dateStr = dateStr.replace("T", " ");

        return TimeUtil.strToDate(dateStr, "yyyy-MM-ddTHH:mm:ss.SSS");
    }

    /**
     * 将Date转换为ES时间格式 yyyy-MM-ddTHH:mm:ss.SSS
     * 
     * @param date java.util.Date
     * @return
     */
    public static String getEsDateStr(Date date) {
        String str = dateToStr(date, "yyyy-MM-ddTHH:mm:ss.SSS");

        return str.replace(" ", "T");
    }

    /**
     * 获取范围内所有日期
     * 
     * @param stDate 开始时间
     * @param edDate 结束时间
     * @param regionDateFormatter 开始、结束时间格式化串
     * @param returnDateFormatter 返回时间格式化串
     * @return
     */
    public static List<String> getDates(String stDate, String edDate, String regionDateFormatter, String returnDateFormatter) {
        List<String> dates = new ArrayList<String>();

        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(strToDate(stDate, regionDateFormatter));
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(strToDate(edDate, regionDateFormatter));

        while (!calBegin.getTime().after(calEnd.getTime())) {
            dates.add(dateToStr(calBegin.getTime(), returnDateFormatter));
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
        }

        return dates;
    }

    /**
     * 获取给定时间小时时间
     * 
     * @param size
     * @return
     */
    public static Integer getHour(Date date) {
        if (null == date)
            return null;

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c.get(Calendar.HOUR_OF_DAY);
    }
    
    /**
     * 获取给定时间分钟时间
     * 
     * @param size
     * @return
     */
    public static Integer getMinute(Date date) {
        if (null == date)
            return null;

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c.get(Calendar.MINUTE);
    }

    /**
     * 获取范围内所有月份
     * 
     * @param size
     * @return
     */
    public static List<String> getMonths(int size) {
        List<String> months = new ArrayList<String>();

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -(size + 1));

        for (int i = 0; i < size; i++) {
            c.add(Calendar.MONTH, 1);
            months.add(dateToStr(c.getTime(), "yyyy-MM"));
        }

        return months;
    }



    /**
     * 获取给定格式时间字符串后一天时间
     * 
     * @param date
     * @param formatter
     * @return
     */
    public static String getSufDateStr(String date, String formatter) {
        return dateToStr(addDays(strToDate(date, formatter), 1), formatter);
    }
}
