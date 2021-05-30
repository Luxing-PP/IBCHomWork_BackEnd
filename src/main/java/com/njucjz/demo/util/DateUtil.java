package com.njucjz.demo.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private static long ONE_DAY_MS = 86400000;

    /*只保留日期*/
    public static Date clearDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static boolean isNewDay(Date before){
        if( before==null ){
            //首次登陆
            return true;
        }

        Date today = clearDate(new Date());
        before = clearDate(before);

        return (today.compareTo(before)) > 0;
    }
}
