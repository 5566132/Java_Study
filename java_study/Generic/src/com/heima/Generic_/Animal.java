package com.heima.Generic_;

public abstract class Animal {
    String name;
    int age;
    Animal(){
        this(null, 0);
    }
    Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    public abstract void eat();
}
