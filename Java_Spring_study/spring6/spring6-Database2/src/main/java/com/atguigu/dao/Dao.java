package com.atguigu.dao;

import com.atguigu.date.Book;
import com.atguigu.date.User;

import java.util.List;

public interface Dao {

    //查询全部图书, 返回给service层
    public List<Book> show_allbook();
    //查询全部用户, 返回给service层
    public List<User> show_alluser();

    //id查书
    public Book findbook(Integer bookid);
    //id查用户
    public User finduser(Integer userid);

    //按id给书库存减去指定数量
    public void reduce_book(Integer bookid, int count);
    //按id给用户减去指定余额
    public void reduce_money(Integer userid, int money);
}
