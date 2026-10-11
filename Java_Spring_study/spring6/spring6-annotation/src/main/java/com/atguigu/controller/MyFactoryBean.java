package com.atguigu.controller;

import com.atguigu.service.Service;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyFactoryBean implements FactoryBean<Controller> {
    @Override
    public Controller getObject(){

       // ApplicationContext co = new ClassPathXmlApplicationContext("bean.xml");
       // Service se = (Service)co.getBean("s1");
        Controller ret = new Controller();
      //  ret.setSe(se);
        return ret;
    }
    @Override
    public Class<?> getObjectType(){
        return Controller.class;
    }

}
