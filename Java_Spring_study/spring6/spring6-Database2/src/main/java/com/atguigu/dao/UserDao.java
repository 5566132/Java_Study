package com.atguigu.dao;

import com.atguigu.controller.Controller;
import com.atguigu.date.Book;
import com.atguigu.date.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.rowset.JdbcRowSet;
import java.util.List;

@Repository("d1")
public class UserDao implements Dao{
    @Autowired
    @Qualifier("jt")
    private JdbcTemplate jt;

    @Override
    public List<Book> show_allbook(){
        String sql = "select * from book";
        List<Book> list = jt.query(sql, new BeanPropertyRowMapper<>(Book.class));
        return list;
    }

    @Override
    public List<User> show_alluser(){
        String sql = "select * from user";
        List<User> list = jt.query(sql, new BeanPropertyRowMapper<>(User.class));
        return list;
    }

    @Override
    public Book findbook(Integer bookid){
        String sql = "select * from book where id = ?";
        Book temp = jt.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), bookid);
        System.out.println(temp.toStirng());
        return temp;
    }

    @Override
    public User finduser(Integer userid){
        String sql = "select * from user where id = ?";
        User temp = jt.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), userid);
        System.out.println(temp.toStirng());
        return temp;
    }

    @Override
    public void reduce_book(Integer bookid, int count){
        String sql = "update book set stock = stock - ? where id = ?";
        jt.update(sql, count, bookid);
    }

    @Override
    public void reduce_money(Integer userid, int money){
        String sql = "update user set money = money - ? where id = ?";
        jt.update(sql, money, userid);
    }





}
