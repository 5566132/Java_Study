package com.heima.Generic_;

public class Dog extends Animal{
    Dog(){
        super();
    }
    Dog(String name, int age){
        super(name, age);
    }
    @Override
    public void eat(){
        System.out.println(this.age + " 岁的小狗 " + this.name + " 吃东西");
    }
}
