package com.itheima;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Try_BigInteger {
    public static void main(String[] args){
        BigInteger bi = new BigInteger("99999999999999999999");
        BigInteger bi2 = new BigInteger("9999999999999999999999999999999");
        BigInteger b3 = BigInteger.valueOf(8);
        System.out.println(b3.multiply(bi));
        System.out.println(bi.add(bi2));
        double a = (0.1 + 0.2);
        System.out.println(a);
        BigDecimal bd = new BigDecimal("0.1");
        System.out.println(bd.add(bd));

    }
}
