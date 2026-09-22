package com.Code_DeCode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) throws IOException {
        File temp = new File("D::\\A_java");
        FileInputStream fis = new FileInputStream("D:\\A_java\\java_study\\IO_\\src\\MY_IO.txt");
        StringBuilder sb = new StringBuilder();
        byte[] by = new byte[4];
        int len ;
        ArrayList<Byte> arr = new ArrayList<>();
        int i;
        while((len = fis.read(by)) != -1){
           for(i=0;i<len;i++){
               arr.add(by[i]);
           }
        }
        System.out.println(arr.size());

        fis.close();
        Byte[] by1  = arr.toArray(new Byte[0]);
        byte[] out = new byte[by1.length];
        System.out.println("-------------------------");
        for(i=0;i<by1.length;i++){
            out[i] = by1[i];
        }
        String OUT1 = new String(out, "UTF-8");
        System.out.println(OUT1);





    }
}
