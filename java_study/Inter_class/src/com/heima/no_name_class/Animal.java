package com.heima.no_name_class;

public abstract class Animal {
    private int age;
    Animal(){
        age = 0;
    }
    Animal(int age){
        this.age = age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public abstract void eat();
}


