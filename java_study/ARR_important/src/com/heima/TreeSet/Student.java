package com.heima.TreeSet;

public class Student implements Comparable<Student>{
    public String name;
    int age;
    int chinese;
    int math;
    int english;
    Student(){
        this(null, 0, 0, 0, 0);
    }
    Student(String name, int age, int chinese, int math, int english){
        this.name = name;
        this.age = age;
        this.chinese = chinese;
        this.math = math;
        this.english  = english;
    }

    public void show(){
        System.out.println(" 姓名是: " + this.name + "     age = " + age + "     chinese = " + chinese + "      math = " + math + "         english = " + english);
    }




    @Override
    public int compareTo(Student s1){
        //规律是0不添加
        int ret = 0;
        ret = ret == 0 ? this.chinese - s1.chinese : ret;
        ret = ret == 0 ? this.math - s1.math : ret;
        ret = ret == 0 ? this.english - s1.english : ret;
        ret = ret == 0 ? this.age - s1.age : ret;

        //字典小的在前, 字典大的在后, 会导致, 返回 -1  compareTo的规则是, 返回 -1 的会放在前面
        ret = ret == 0 ? this.name.compareTo(s1.name) : ret;
        System.out.println(" this.name =  " + this.name + "        s1.name = " + s1.name + "             ret = " + ret);

        return ret;
    }
}
