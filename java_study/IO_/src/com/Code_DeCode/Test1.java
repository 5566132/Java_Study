package com.Code_DeCode;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "j你太m";

        //默认是用 UTF-8 的编码模式
        byte[] b1 = str.getBytes();
        System.out.println(Arrays.toString(b1));

        byte[] b2 = str.getBytes("GBK");
        System.out.println(Arrays.toString(b2));

        String s2 = new String(b1);
        String s3 = new String(b2, "GBK");

        System.out.println(s2 + "\n" + s3);






    }
}
