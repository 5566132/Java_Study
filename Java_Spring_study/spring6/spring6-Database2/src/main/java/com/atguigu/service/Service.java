package com.atguigu.service;

public interface Service {
    public void show_allbook();
    public void show_alluser();
    public void buybook(Integer userid, Integer bookid);
    public void buy_many_book(Integer userid, Integer bookid , Integer count);
}
