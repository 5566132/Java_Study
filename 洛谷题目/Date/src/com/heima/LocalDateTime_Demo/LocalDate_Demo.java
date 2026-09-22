package com.heima.LocalDateTime_Demo;

import java.time.LocalDate;
import java.time.Period;

public class LocalDate_Demo {
    public static void main(String[] args){
        LocalDate ld = LocalDate.now();
        System.out.println(ld);

        LocalDate ld1 = LocalDate.of(2000, 11, 11);
        System.out.println(ld1);

        Period period = Period.between(ld1, LocalDate.now());
        System.out.println(period);

        System.out.println("月份间隔: " + period.getMonths());
        System.out.println("日期间隔: " + period.getDays());

        LocalDate ld2 = LocalDate.of(2000, 12, 10);
        Period period1 = Period.between(ld1, ld2);
        System.out.println("  +++   " + period1.toTotalMonths());



    }
}
