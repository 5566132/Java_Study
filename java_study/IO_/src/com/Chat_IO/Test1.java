package com.Chat_IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test1 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("D:\\A_java\\java_study\\IO_\\src\\MY_IO.txt");
        FileReader fr = new FileReader(f1);
        char c1;
        int len;
        while((len = fr.read()) != -1){
            if(len == '\r'){
                System.out.print("(\\r)");
                continue;
            }
            if(len == '\n'){
                System.out.print("\\n");
            }
            System.out.print((char)(len));
        }
        fr.close();






    }
}
