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

        sb.append(String.format("%2d",month+1).replace(" ","0"));
        sb.append("-");
        sb.append(String.format("%2d",day).replace(" ","0"));
        return sb.toString();
    }
    public String getNowTimes(){
        int year = get(YEAR);
        int month = get(MONTH);
        int day = get(DATE);
        StringBuffer sb = new StringBuffer();
        sb.append(year);

        sb.append(String.format("%2d",month+1).replace(" ","0"));

        sb.append(String.format("%2d",day).replace(" ","0"));
        return sb.toString();
    }

}
