package com.heima.IO1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Read2 {
    public static void main(String[] args) throws IOException {
        //视频拷贝起始地点
        FileInputStream fis = new FileInputStream("D:\\A_java\\java_study\\IO_\\src\\here.mp4");
        //视频拷贝目的地
        FileOutputStream fos = new FileOutputStream("D:\\A_java\\java_study\\IO_\\src\\com\\heima\\IO1\\copy.mp4");
        int b;

        //视频拷贝成 文件 的目的地
        FileOutputStream fos2 = new FileOutputStream("D:\\A_java\\java_study\\IO_\\src\\MY_IO.txt");
        int cnt = 0;



        //进行第一次对视频的拷贝
        LocalDateTime ldt = LocalDateTime.now();
        while((b = fis.read()) != -1){
            cnt++;
            fos2.write(b);
        }
        System.out.println(" cnt = " + cnt);
        LocalDateTime ldt2 = LocalDateTime.now();
        Duration dur = Duration.between(ldt, ldt2);
        System.out.println(dur);

        System.out.println("------------------------");





        cnt = 0;
        //进行第二次对视频的拷贝, 用byte[]
        byte[] by = new byte[1024*1024];
        ldt = LocalDateTime.now();
        while((b = fis.read(by)) != -1){
            cnt++;
            fos2.write(by, 0, b);
        }
        System.out.println(" cnt = " + cnt);
        ldt2 = LocalDateTime.now();
        dur = Duration.between(ldt, ldt2);
        System.out.println(dur);






        fos2.close();
        fos.close();
        fis.close();



    }
}
