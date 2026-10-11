package com.atguigu.service;

import com.atguigu.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service("s1")
public class Serviceimpl implements Service{
    private Dao dao;
    public Serviceimpl(){
        System.out.println("调用了Serviceimpl的无参构造");
    }


    @Autowired
    @Qualifier(value = "daoimpl2")
    public void setDao(Dao dao){
        this.dao = dao;
        System.out.println("Service调用了set方法去给Dao赋值");
    }



    @Override
    public void run(){
        System.out.println("Serviceimpl.......");
        dao.run();
    }
}
