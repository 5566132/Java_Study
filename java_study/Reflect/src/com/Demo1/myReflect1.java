package com.Demo1;

public class myReflect1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("com.Demo1.Stu");
        Class c2 = Stu.class;
        Stu s1 = new Stu();
        Class c3 = s1.getClass();
        System.out.println(c1 == c2);
        System.out.println(c2 == c3);
        System.out.println(c1);



    }


}
