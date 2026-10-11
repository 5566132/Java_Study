package com.atguigu.spring6;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class User {
    public int age;
    public User(){
        this(0);
        System.out.println("调用了无参构造");
    }
    public User(int age){
        this.age = age;
        System.out.println("调用了一个参数的构造");
    }
    public void setAge(int age){
        this.age = age + 10;
    }
    public void set666(int age){
        this.age = age + 1000;
    }
    public void setabc(int age){
        this.age = age + 100000;
    }
    public int getAge(){
        return this.age;
    }



    public void add(){
        System.out.println("添加----");
    }


    @Test
    public void show(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User temp = (User)context.getBean("user");
        temp.add();
    }

}
