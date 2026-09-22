package com.heima.LocalDateTime_Demo;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Date;

public class DateTimeFormat {
    public static void main(String[] args){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime ldt = LocalDateTime.of(2026, 9, 1, 12,12);
System.out.println(ldt);
        String s = "2026-11-11";
        System.out.println(dtf.format(ldt));


        LocalDate ld1 = LocalDate.parse(s,dtf);
        System.out.println(ld1);

        LocalDate ld2 = LocalDate.of(2026,1,1);
        LocalDateTime ldt1 = LocalDateTime.of(2026, 12, 31, 23,59);
        System.out.println(ldt1);


        LocalDate id3 = LocalDate.parse(s, dtf);
        System.out.println(id3);

        LocalDate ld4 = LocalDate.of(2026,10,10);
        String s1 = dtf.format(ld4);
        System.out.println(ld4);
        System.out.println(s1);


        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String s4 = "2026-01-01 23:59";
        LocalDateTime ldt4 = LocalDateTime.parse(s4, dtf4);
        System.out.println(ldt4);
        String s4_out = dtf4.format(ldt4);
        System.out.println("s4_out = " + s4_out);
        System.out.println(ldt4.toLocalTime());


        ldt4.plusDays(10);
        s4_out = dtf4.format(ldt4.plusDays(10));
        System.out.println("s4_out = " + s4_out);


            s4_out = dtf4.format(ldt4.plusMonths(20));
            System.out.println("s4_out = " + s4_out);







    }
}
