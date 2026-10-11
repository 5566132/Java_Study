package com.BeanLife;

public class User {
    private int age;
    public User(){
        age = 0;
        System.out.println("调用了无参构造");
    }
    public void setAge(int age){
        System.out.println("调用了set方法");
        this.age = age;
    }
    public int getAeg(){
        return age;
    }
    public void initMethod(){
        System.out.println("调用了初始化方法");
    }
    public void destoryMethod(){
        System.out.println("调用了销毁方法");
    }


}
