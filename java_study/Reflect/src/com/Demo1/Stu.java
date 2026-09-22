package com.Demo1;

public class Stu {
    public String name;
    private int age;


    public Stu(){
        name = null;
        age = 0;
    }
    public Stu(String name){
        this.name = name;
    }
    private Stu(int age){
        this.age = age;
    }
    public Stu(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void sum(int... a){
        int i;
        int sum = 0;
        for(i=0;i<a.length;i++){
            sum += a[i];
        }

    }

}
