package com.heima.IO1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Read_Write {
    public static void main(String[] args) throws IOException {
        //取数据地点
        FileInputStream fis = new FileInputStream("D:\\A_java\\java_study\\IO_\\src\\MY_IO_read");
        //写入数据地点
        FileOutputStream fos = new FileOutputStream("D:\\A_java\\java_study\\IO_\\src\\MY_IO.txt");

        byte[] by = new byte[4];
        int len;
        while((len = fis.read(by)) != -1){
            System.out.println(" len = " + len);
            //fos.write(by, 0, len);
            fos.write(by);
        }

        fos.close();
        fis.close();







    }
}


/*

2 4 8 16 32 64 128 256











 */