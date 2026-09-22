package Buffered_IO.Buffered_byte;

import java.io.*;

public class Test1 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("D:\\");

        FileReader fr = new FileReader(f1);

        BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream(f1) ));

        FileInputStream fis = new FileInputStream(f1);
        InputStreamReader isr = new InputStreamReader(fis);
        //FileReader fr2 = new FileReader(new InputStreamReader(fis));

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\A_java\\java_study\\IO_\\src\\Buffered_IO\\Buffered_byte\\byte_IO.txt"));
        BufferedReader br2 = new BufferedReader(fr);
       // BufferedReader br3 = new BufferedReader(System.in);
        BufferedReader br4 = new BufferedReader(new FileReader(f1));
        int i;
        for(i=0;i<8190;i++){
            bos.write('a');
        }
        byte[] by = "中".getBytes();
        for(byte b : by){
            bos.write(b);
        }
        bos.close();


        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\A_java\\java_study\\IO_\\src\\Buffered_IO\\Buffered_byte\\byte_IO.txt"));
        int len;
        bos = new BufferedOutputStream(System.out);
        while((len = bis.read()) != -1){
            bos.write((len));
        }
        bos.close();
        bis.close();




    }
}
