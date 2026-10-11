package com.Practice;

import com.Demo1.Stu;

import java.io.*;
import java.lang.reflect.Field;

public class Test1 {
    static void main() throws IOException, IllegalAccessException {
        Stu s1 = new Stu("小八", 999);
        Get_in(s1);



    }

    static void Get_in(Object obj) throws IOException, IllegalAccessException {
        Class c1 = obj.getClass();
        Field[] f1 = c1.getDeclaredFields();
        File goal = new File("D:\\A_java\\java_study\\Reflect\\src\\com\\Practice\\Destination");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(goal)));
        StringBuilder sb = new StringBuilder();
        for(Field temp : f1){
            temp.setAccessible(true);
            sb.replace(0, sb.length(), "");
            sb.append(temp.getName() + " = " + temp.get(obj));
            bw.write(sb.toString());
            //bw.newLine();
            bw.write(System.lineSeparator());
        }
        bw.close();
    }



}
