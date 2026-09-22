package com.heima.Generic_;

public class BScat extends Cat{
    BScat(){
        super();
    }
    BScat(String name, int age){
        super(name, age);
    }
    @Override
    public void eat(){
        System.out.println(this.age + " 岁的波斯猫 " + this.name + " 吃小鱼干 ");
    }
}
