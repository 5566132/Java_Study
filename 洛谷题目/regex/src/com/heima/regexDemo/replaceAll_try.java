package com.heima.regexDemo;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class replaceAll_try {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String regex1 = "(.)\\1+";

        String regex2 = "(.)\\d";
        String regex3 = "((?i)java)(?=123)";
        while(true){
            String s = sc.next();
            //String end = s.replaceAll(regex1, "$1");
            //System.out.println(end);
            Pattern p = Pattern.compile(regex3);
            Matcher m = p.matcher(s);
            while(m.find()){
                System.out.println(m.group(1));

            }
            System.out.println("=====  " + s.matches(regex3));

        }

    }
}
