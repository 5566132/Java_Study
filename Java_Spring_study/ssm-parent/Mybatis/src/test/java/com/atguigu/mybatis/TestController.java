package com.atguigu.mybatis;


import com.atguigu.mybatis.controller.EmpController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestController {

    @Autowired
    EmpController ec;

    @Test
    public void t1(){
        ec.getAllEmp();
    }
}
