package com.heima.no_name_class;

public class Person {

    private int age;
    Person(){
        age = 0;
    }
    Person(int age){
        this.age = age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void showage(){
        System.out.println("年龄为: " + age);
    }
    public  void eat(){
        System.out.println("就知道吃");
    }
}
