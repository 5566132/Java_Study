package com.heima.no_name_class;

public class Test {
    public static void main(String[] args){
        int age = 9999;
        Person p = new Person(9999){
            final int age = 66666666;
            @Override
            public void eat(){
                System.out.println("错了, 不吃了");
            }
        };
        p.showage();
        p.eat();



    }

}
