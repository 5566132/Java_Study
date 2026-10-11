package com.atguigu.controller;
import com.atguigu.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class Controller {
    @Autowired
    @Qualifier("s1")
    private Service se;

    public void show_allbook(){
        se.show_allbook();
    }
    public void show_alluser(){
        se.show_alluser();
    }
    public void buybook(Integer userid, Integer bookid, Integer count){
        se.buy_many_book(userid, bookid, count);
    }



}
