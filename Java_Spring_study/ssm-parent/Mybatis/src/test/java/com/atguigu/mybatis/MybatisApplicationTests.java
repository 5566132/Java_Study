package com.atguigu.mybatis;

import com.atguigu.mybatis.bean.emp.Emp;
import com.atguigu.mybatis.mapper.Emp.EmpMapper;
import com.atguigu.mybatis.mapper.Emp.EmpParamMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisApplicationTests {
    @Autowired
    EmpMapper em;

    @Autowired
    EmpParamMapper epm;

    @Test
    public void get(){
        Emp temp = em.getEmpById(1);
        System.out.println(temp);
    }


    @Test
    public void add(){
        Emp temp = new Emp();
        temp.setAge(100);
        temp.setEmpName("小八");
        temp.setEmpSalary(new BigDecimal(8888.888));
        em.insertEmp(temp);
    }

    @Test
    public void get2(){
        Emp e1 = epm.getEmployee1(1L);
        System.out.println(e1);
    }

    @Test
    public void getlist2(){
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        Emp e1 = epm.getEmployee2(list, 2L);
        System.out.println(e1);
    }

    @Test
    public void add_emp2(){
        Emp add = new Emp();
        add.setEmpName("我是谁, 我在那里?");
        add.setAge(10086);
        System.out.println(add);
        epm.addEmployee1(add);
        System.out.println(add);
    }

    @Test
    public void add_map2(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "为什么要用map呀");
        map.put("age", 66666);
        epm.addEmployee2(map);
    }

    //测试, 返回salary
    @Test
    public void t1(){
        BigDecimal bd = epm.getSalaryById(1L);
        System.out.println(bd);
    }

    //list 和 返回Map<Inerger, Emp>
    @Test
    public void t2(){
        List<Emp> list = epm.getAll();
        list.forEach(System.out::println);
        Map<Integer, Emp> m = epm.getAllMap();
        System.out.println(m);
        for(Map.Entry<Integer, Emp> temp : m.entrySet()){
            System.out.println(temp.getKey());
            System.out.println(temp.getValue());
        }
        Emp temp = m.get(1);
        System.out.println(temp);

    }






}
