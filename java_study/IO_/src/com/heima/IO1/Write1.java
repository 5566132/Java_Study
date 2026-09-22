package com.heima.IO1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Write1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\A_java\\java_study\\IO_\\src\\MY_IO.txt");
        Random r = new Random();
        int n = r.nextInt(10, 100);
        while(n-- > 0){
            int se = r.nextInt('a', ('z' + 1));
            fos.write(se);
        }
        fos.close();




    }
}
