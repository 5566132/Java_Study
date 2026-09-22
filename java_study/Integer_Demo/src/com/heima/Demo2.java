package com.heima;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Demo2 {
    public static void main(String[] args){
        //LocalDateTime ldt1 = LocalDateTime.of(2000,8,20);
        LocalDate ld1 = LocalDate.of(2000, 8,20);
        LocalDate ld2 = LocalDate.now();
        System.out.println(ChronoUnit.DAYS.between(ld1, ld2));









    }
}
