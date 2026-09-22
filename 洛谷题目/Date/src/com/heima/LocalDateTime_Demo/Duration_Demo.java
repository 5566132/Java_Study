package com.heima.LocalDateTime_Demo;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Duration_Demo {
    public static void main(String[] args){
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss");
        LocalDateTime ldt1 = LocalDateTime.of(2026,9,1,0,0);
        LocalDateTime ldt11 = LocalDateTime.of(2026,9,3,23,59);
        Duration d1 = Duration.between(ldt1, ldt11);
        //System.out.println("Month = " + d1.toMonths());
        System.out.println("Day = " + d1.toDays());
        System.out.println("Hour = " + d1.toHours());


        LocalDateTime ldt111 = LocalDateTime.of(2020,9,1,0,0);

        System.out.println(ChronoUnit.YEARS.between(ldt111, ldt1));
        System.out.println(ChronoUnit.MONTHS.between(ldt111, ldt1));
        System.out.println(ChronoUnit.DAYS.between(ldt111, ldt1));
        System.out.println(ChronoUnit.HOURS.between(ldt111, ldt1));


    }


}
