package com.builder.yiban;

import java.util.GregorianCalendar;

public class MyCalendar extends GregorianCalendar {
    public String getNowTimesByString(){
        int year = get(YEAR);
        int month = get(MONTH);
        int day = get(DATE);
        StringBuffer sb = new StringBuffer();
        sb.append(year);
        sb.append("-");
        sb.append(month+1);
        sb.append("-");
        sb.append(day);
        return sb.toString();
    }

}
