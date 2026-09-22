package com.heima.Arrays_Demo1;

public class Stu {
    private int id;
    private int age;
    public Stu(){
        this(0, 0);
    }
    public Stu(int id, int age){
        this.id = id;
        this.age = age;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getId(){
        return id;
    }
    public int getAge(){
        return age;
    }

    public void show(){
        System.out.println("id = " + id +  "    age = " + age);
    }








}
