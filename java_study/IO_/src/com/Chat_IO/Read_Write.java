package com.Chat_IO;

import java.io.*;

public class Read_Write {
    public static void main(String[] args) throws IOException {
        File fin = new File("D:\\A_java\\java_study\\IO_\\src\\MY_IO.txt");
        File fout = new File("D:\\A_java\\java_study\\IO_\\src\\MY_IO_read");
        FileReader fr = new FileReader(fin);
        FileWriter fw = new FileWriter(fout);
        char[] c1 = new char[4];
        int len;
        while((len = fr.read(c1)) != -1){
            fw.write(c1,0, len);
            //fw.write(c1);
        }

        fw.write('\n');
        fw.write("鸡你太美");
        fw.write(54188);











        fw.close();
        fr.close();







    }
}
