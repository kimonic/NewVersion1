package dingw.com.newversion.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by 12348 on 2017/3/28 0028.
 * 时间处理类
 */

public class TimeUtils {
     /**
     * @return  返回系统时间--时 分
     */
    public static String getCurentTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm", Locale.getDefault());
        Date currentTime = new Date();
        return formatter.format(currentTime);
    }

    /**
     * 获取现在时间
     * @return 返回短时间字符串格式 yyyy-MM-dd
     */
    public static String getStringDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日", Locale.getDefault());
        return formatter.format(currentTime);
    }
    /**
     * 获取现在日期
     * @return   返回短时间格式 yyyy-MM-dd
     */
    public static String getNowDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return formatter.format(currentTime);
    }

    /**
     * 将短时间格式字符串转换为时间 yyyy-MM-dd
     * @param strDate 日期
     * @return yyyy-MM-dd
     */
    private static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        ParsePosition pos = new ParsePosition(0);
        return formatter.parse(strDate, pos);
    }

    /**
     * 根据一个日期，返回是星期几的字符串
     * @param sdate 日期
     * @return       星期几
     */
    public static String getWeek(String sdate) {
        Date date = strToDate(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return new SimpleDateFormat("EEEE", Locale.getDefault()).format(c.getTime());
    }

    /**
     * 根据yyyy-MM-dd  获得日期是星期几
     * @param sdate  日期
     * @return  星期几
     */
    public static String getWeekStr(String sdate){
        String str = getWeek(sdate);
        if("1".equals(str)){
            str = "星期日";
        }else if("2".equals(str)){
            str = "星期一";
        }else if("3".equals(str)){
            str = "星期二";
        }else if("4".equals(str)){
            str = "星期三";
        }else if("5".equals(str)){
            str = "星期四";
        }else if("6".equals(str)){
            str = "星期五";
        }else if("7".equals(str)){
            str = "星期六";
        }
        return str;
    }



}
