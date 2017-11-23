package com.util;

import com.dawn.bean.MyDate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */

public class DateUtils {
    public static int   getNowMonth(){
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.MONTH)-1;
    }
    public static List<MyDate> getDateList(int year, int moth){
        List<MyDate>list=new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year) ;
        cal.set(Calendar.MONTH, moth-1);
        cal.getTime();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int  firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);//当前月第一天
        int day = cal.get(Calendar.DAY_OF_WEEK);//这个月第一天是星期几（1, 2,   3,  4,  5, 6,   7，// 日,一，二，三，四，五，六// ）
        cal.set(Calendar.MONTH, moth);
        cal.add(Calendar.DAY_OF_MONTH, -1);;//当前月最后一天
        int lastDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int noDay=day-1;
        for (int i=0;i<noDay;i++){
            MyDate date=new MyDate();
            date.day="";
            list.add(date);
        }
        for (int i=firstDay;i<=lastDay;i++){
            MyDate date=new MyDate();
            date.day=""+i;
            list.add(date);
        }
        return list;
    }
}
