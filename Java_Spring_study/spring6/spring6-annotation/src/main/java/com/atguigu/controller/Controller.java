package com.atguigu.controller;

import com.atguigu.service.Service;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Controller("controller1")
public class Controller {

    @Resource
    private Service se;
    public Controller(){
        System.out.println("调用了Controller的无参构造");
    }

    public Controller(Service se){
        this.se = se;
    }
    //@Autowired
    //@Qualifier("s1")
    public void setSe(Service se){
        this.se = se;
        System.out.println("Controller调用了set方法去给Service赋值");
    }

    public void run(){
        System.out.println("Controller......");
        se.run();
    }

}
