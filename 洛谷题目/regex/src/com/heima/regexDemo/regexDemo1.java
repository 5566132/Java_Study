package com.heima.regexDemo;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexDemo1 {
    public static void main(String[] args){
        String regex3 = "(\\d){3}";




        String s = "来黑马程序员学习Java，" +
                "电话：18512516758，18512508907" +
                "或者联系邮箱：boniu@itcast.cn，" +
                "座机电话：01036517895，010-98951256" +
                "邮箱：bozai@itcast.cn，" +
                "热线电话：400-618-9090 ，400-618-4000，4006184000，4006189090";
        String hotline = "(400-?[1-9]\\d{2}-?[1-9]\\d{3})";
        String idcard = "(1\\d{5}(1[89]|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])\\d{3}(?i)[\\dx])";
        String regex = hotline + "|" + (idcard);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        String line;
        while(m.find()){
            line = m.group();
            System.out.println(line);
        }







    }
}
