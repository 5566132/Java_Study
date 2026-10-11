package com.atguigu.dao;


import org.springframework.stereotype.Repository;

@Repository
public class Daoimpl2 implements Dao{
    public Daoimpl2(){
        System.out.println("调用了Daoimpl222的无参构造");
    }

    public void run(){
        System.out.println("Daoimpl2222......");
    }

}
