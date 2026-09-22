package com.heima.Generic_;

public class Cat extends Animal{
    Cat(){
        super();
    }
    Cat(String name, int age){
        super(name, age);
    }
    @Override
    public void eat(){
        System.out.println(this.age + " 岁的小猫 " + this.name + " 吃东西");
    }
}
