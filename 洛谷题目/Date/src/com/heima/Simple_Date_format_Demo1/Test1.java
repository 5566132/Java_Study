package com.heima.Simple_Date_format_Demo1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) throws ParseException {
        String st = "2000-11-11";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = new Date();
        //System.out.println(d1);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
        d1 = sdf1.parse(st);
        //System.out.println(d1);
        Date d2 = new Date();
        String out = sdf2.format(d1);
        System.out.println(out);

        SimpleDateFormat sdf3 = new SimpleDateFormat();
        d1 = sdf3.parse(st);
        System.out.println(d1);


    }
}
