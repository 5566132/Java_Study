package com.heima.Generic_;

public class HSk extends Dog{
    HSk(){
        super();
    }
    HSk(String name, int age){
        super(name, age);
    }
    @Override
    public void eat(){
        System.out.println(this.age + " 岁的哈士奇 " + this.name + " 吃dog shit");
    }
}
