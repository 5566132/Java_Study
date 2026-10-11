package com.atguigu.dao;


import org.springframework.stereotype.Repository;

@Repository
public class Daoimpl implements Dao{
    public Daoimpl(){
        System.out.println("调用了Daoimpl的无参构造");
    }

    @Override
    public void run(){
        System.out.println("Danimpl......");
    }
}
