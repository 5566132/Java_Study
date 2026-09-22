package com.heima.Collection;

import java.math.BigInteger;
import java.util.Scanner;
public class Test3 {
    public static void main(String[] atgs){
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        BigInteger sum = new BigInteger("0");
        BigInteger mu = new BigInteger("1");
        BigInteger i = new BigInteger("1");
        BigInteger ADD = new BigInteger("1");
        n = n.add(i);
        while(!(i.equals(n))){
            //System.out.println(" i = " + i);
            mu = mu.multiply(i);
            sum = sum.add(mu);
            i = i.add(ADD);
        }
        System.out.println(sum);



    }
}
