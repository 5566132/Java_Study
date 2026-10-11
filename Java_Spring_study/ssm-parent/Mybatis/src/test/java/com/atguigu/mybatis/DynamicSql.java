package com.atguigu.mybatis;

import com.atguigu.mybatis.bean.emp.Emp;
import com.atguigu.mybatis.mapper.dynamicSql.EmpDynamicSqlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DynamicSql {
    @Autowired
    EmpDynamicSqlMapper eds;

    @Test
    public void t1(){
        List<Emp> list = eds.getEmpByNameAndSalary(null, null);
        System.out.println(list);
    }


    //测试id为空, 和id不为空
    @Test
    public void t2(){
        Emp e = new Emp();
        e.setEmpName("tom");
        //e.setAge(1213339980);
        //e.setEmpSalary(new BigDecimal(666.66666));
        eds.updateEmpById(1L, e);
    }

    @Test
    public void t3(){
        List<Long> list = new ArrayList<>();
        //list.add(1L);
        //list.add(3L);
        //list.add(5L);
        List<Emp> out = eds.getEmpByList(list);
        for(Emp temp : out){
            System.out.println(temp);
        }
    }

    @Test
    //批量插入
    public void t4(){
        List<Emp> list = new ArrayList<>();
        int i;
        for(i=0;i<10;i++){
            Emp e = new Emp();
            e.setId(i+10);
            e.setEmpName("张" + (i+1));
            e.setAge(i*10+2);
            e.setEmpSalary(new BigDecimal(i*100 + 1*10 + i+0.1));
            list.add(e);
        }

        eds.insertEmpByList(list);
    }
    @Test
    //批量修改
    public void t5(){
        List<Emp> list = new ArrayList<>();
        int i;
        for(i=0;i<10;i++){
            Emp e = new Emp();
            e.setId(i+10);
            e.setEmpName("张牛牛牛" + (i+2));
            //e.setAge(i*10+2);
            //e.setEmpSalary(new BigDecimal(i*100 + 1*10 + i+0.1));
            list.add(e);
        }
        eds.updateEmpByList(list);
    }
    @Test
    //批量删除
    public void t6(){
        List<Emp> list = new ArrayList<>();
        int i;
        for(i=0;i<10;i++){
            Emp e = new Emp();
            e.setId(i+10);
            list.add(e);
        }
        eds.deleteEmpByList(list);
    }



}
