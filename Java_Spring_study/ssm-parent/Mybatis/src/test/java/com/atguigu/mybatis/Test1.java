package com.atguigu.mybatis;

import com.atguigu.mybatis.bean.TProduct;
import com.atguigu.mybatis.bean.emp.Emp;
import com.atguigu.mybatis.mapper.TProductMapper;
import com.atguigu.mybatis.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Test1 {

    @Autowired
    EmpService empService;

    @Autowired
    TProductMapper tProductMapper;
    //测试分页
    @Test
    public void t1(){
        //PageHelper.startPage(1,5);
        List<Emp> list = empService.getPageEmp(2);
        for(Emp temp : list){
            System.out.println(temp);
        }
    }

    //测试逆向生成的Mapper
    @Test
    public void t2(){
        TProduct ttt = new TProduct();
        ttt.setId(1L);
        ttt.setProductName("超级管理员");
        tProductMapper.updateByPrimaryKey(ttt);



        TProduct tp = tProductMapper.selectByPrimaryKey(1L);
        System.out.println(tp);


    }

}
