package com.itheima.mp.Iservice;

import com.itheima.mp.domain.po.User;
import com.itheima.mp.iservice.Impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserServiceImpl userserviceimpl;

    @Test
    void t1(){
        User u1 = new User();
        u1.setName("小上帝为你");
        u1.setAddress("666大街666号");
        u1.setAge(9999);
        u1.setT_order(89);
        userserviceimpl.save(u1);




    }

}
