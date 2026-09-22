package Practice_copy;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        File f = new File("D:\\A_java\\java_study\\IO_\\Photo\\屏幕截图 2026-09-10 183557.png");

        File fg = new File("D:\\A_java\\java_study\\IO_\\Destination\\" + f.getName());

        //字节基本流拷贝文件
        FileInputStream fis = new FileInputStream(f);
        FileOutputStream fos = new FileOutputStream(fg);
        int len ;
        LocalDateTime ldt1 = LocalDateTime.now();
        while((len = fis.read()) != -1){
            fos.write(len);
        }
        LocalDateTime ldt2 = LocalDateTime.now();
        Duration ddddd = Duration.between(ldt1, ldt2);
        System.out.println(ddddd);



        //字节基本流读数组
        fis = new FileInputStream(f);
        fos = new FileOutputStream(fg);
        byte[] b1 = new byte[1024];
        ldt1 = LocalDateTime.now();
        while((len = fis.read(b1)) != -1){
            fos.write(b1, 0, len);
        }
        ldt2 = LocalDateTime.now();
        Duration d1 = Duration.between(ldt1, ldt2);
        System.out.println(d1);

        //字节缓冲流读
        fis = new FileInputStream(f);
        fos = new FileOutputStream(fg);
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ldt1 = LocalDateTime.now();
        while((len = bis.read()) != -1){
            bos.write(len);
        }
        ldt2 = LocalDateTime.now();
        d1 = Duration.between(ldt1, ldt2);
        System.out.println(d1);

        //缓冲用数组

        fis = new FileInputStream(f);
        fos = new FileOutputStream(fg);
        bis = new BufferedInputStream(fis);
        bos = new BufferedOutputStream(fos);
        ldt1 = LocalDateTime.now();
        while((len = bis.read(b1)) != -1){
            bos.write(b1, 0, len);
        }
        ldt2 = LocalDateTime.now();
        d1 = Duration.between(ldt1, ldt2);
        System.out.println(d1);

        bis.close();
        bos.close();




    }
}
