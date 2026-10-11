package com.atguige;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {
    public static void main(String[] args) {


    }

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User u1 = (User)context.getBean("user1");
        System.out.println(u1);
        User u2 = context.getBean("user2", User.class);
        System.out.println(u2);
        User u3 = context.getBean("user1", User.class);
        System.out.println(u3);
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserDao u1 = context.getBean("userDao1", UserDao.class);
        u1.run();
    }



    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User u1 = (User)context.getBean("user");
        System.out.println(u1.getAge() + "    " + u1.getName());

    }





}
