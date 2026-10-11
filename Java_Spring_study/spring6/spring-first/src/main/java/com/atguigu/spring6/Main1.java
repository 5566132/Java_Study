package com.atguigu.spring6;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main1 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User temp = (User)context.getBean("user");
        temp.add();

        //反射
        Class c1 = User.class;

        Constructor constructor = c1.getConstructor(int.class);

        User u2 = (User)constructor.newInstance(222);
        System.out.println("u2.age = " + u2.age);
    }

    @Test
    public void show(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User temp = (User)context.getBean("user");
        temp.add();
    }

    @Test
    public void t1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User temp = (User)context.getBean("user");
        User temp2 = (User)context.getBean("user");
        System.out.println(temp + "  \n" + temp2);
    }




}
