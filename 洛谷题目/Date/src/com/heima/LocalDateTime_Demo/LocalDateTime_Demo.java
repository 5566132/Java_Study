package com.heima.LocalDateTime_Demo;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;

public class LocalDateTime_Demo {
    public static void main(String[] args){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        Month m = ldt.getMonth();
        System.out.println(m);

        int mm = ldt.getMonthValue();
        System.out.println(mm);

        int dm = ldt.getDayOfMonth();
        System.out.println(dm);

        int dy = ldt.getDayOfYear();
        System.out.println(dy);

        MonthDay md = MonthDay.from(ldt);
        System.out.println(md);

        MonthDay md2 = MonthDay.of(ldt.getMonthValue(), ldt.getDayOfMonth());
        System.out.println(md2);

        MonthDay md3 = MonthDay.of(1, ldt.getDayOfMonth());
        System.out.println(md3);





    }
}
