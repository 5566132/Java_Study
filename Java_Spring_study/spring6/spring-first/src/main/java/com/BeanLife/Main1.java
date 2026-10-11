package com.BeanLife;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {
    @Test
    public void run1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Bean-Life.xml");
        User u1 = (User)context.getBean("user");
        System.out.println(u1);
        context.close();

    }
}
