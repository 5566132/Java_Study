package com.heima.IO1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Read1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\A_java\\java_study\\IO_\\src\\MY_IO.txt");
        int b;
        while((b = fis.read()) != -1){
            System.out.print((char)b);
        }

        fis.close();


    }
}
