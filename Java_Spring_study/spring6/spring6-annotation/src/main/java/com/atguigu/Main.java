package com.atguigu;

import com.atguigu.controller.Controller;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    @Test
    public void run(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Controller co = (Controller)context.getBean("controller1");
        //Controller co = (Controller)context.getBean("factorybean");
        co.run();



    }




}
