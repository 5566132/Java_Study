package com.atguigu.service;
import com.atguigu.dao.Dao;
import com.atguigu.date.Book;
import com.atguigu.date.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service("s1")
public class UserService implements Service{
    @Autowired
    @Qualifier("d1")
    private Dao dao;

    @Override
    public void show_allbook(){
        List<Book> list = dao.show_allbook();
        for(Book temp: list){
            System.out.println("书 id = " + temp.getId() + "  name = " + temp.getName() + "  price = " + temp.getPrice() + "   stock = " + temp.getStock());
        }
    }

    @Override
    public void show_alluser(){
        List<User> list = dao.show_alluser();
        for(User temp : list){
            System.out.println("用户 id = " + temp.getId() + "   name = " + temp.getName() + "   money = " + temp.getMoney());
        }
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    //只买一本书
    public void buybook(Integer userid, Integer bookid){
        //先查询用户的信息和书的信息
        User t1 = dao.finduser(userid);
        Book t2 = dao.findbook(bookid);
        //计算买书要花多少钱
        int need = t2.getPrice();

        //书减去count
        dao.reduce_book(bookid, 1);

        //用户减钱
        dao.reduce_money(userid, need);

    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void buy_many_book(Integer userid, Integer bookid , Integer count){
        int i;
        for(i=0;i<count;i++){
            buybook(userid, bookid);
            System.out.println("成功买了第 " + (i+ 1)  + " 本书");
        }
    }


}
