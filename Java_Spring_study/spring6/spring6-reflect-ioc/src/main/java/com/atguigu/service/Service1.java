package com.atguigu.service;

import com.atguigu.dao.Dao;

public class Service1 implements Service{
    private Dao dao;
    @Override
    public void run(){
        System.out.println("Service111111.......");
    }
}
