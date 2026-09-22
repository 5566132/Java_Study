package com.heima.TreeSet;

import java.util.Iterator;
import java.util.TreeSet;

public class Test1 {
    public static void main(String[] args){
        TreeSet<Student> ts = new TreeSet<>();
        Student s1 = new Student("ac 1号", 10, 90, 90, 90);
        Student s2 = new Student("2号", 20, 80, 90, 90);
        Student s3 = new Student("3号", 20, 90, 90, 90);
        Student s4 = new Student("4号", 10, 80, 80, 90);
        Student s5 = new Student("5号", 10, 80, 80, 80);
        Student s6 = new Student("abcd 0号", 10, 90, 90, 90);
        Student s11 = new Student("1号", 10, 90, 90, 90);

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);
        ts.add(s11);

        Iterator<Student> it = ts.iterator();
        while(it.hasNext()){
            Student temp = it.next();
            temp.show();
        }





    }
}
