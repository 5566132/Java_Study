package com.heima.regexDemo;
import java.util.Scanner;
import java.util.regex.Pattern;

public class regexDemo2 {
    public static void main(String[] args){
        String regex = "((.)\\2*).+\\1";
        Scanner sc = new Scanner(System.in);
        while(true){
            String s = sc.next();
            Pattern p = Pattern.compile(regex);
            System.out.println(s.matches(regex));



        }
    }
}
