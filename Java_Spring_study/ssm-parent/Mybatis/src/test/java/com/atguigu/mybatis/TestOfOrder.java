package com.atguigu.mybatis;

import com.atguigu.mybatis.bean.cus_order.Customer;
import com.atguigu.mybatis.bean.cus_order.Order;
import com.atguigu.mybatis.mapper.cus_order.CustomerMapper;
import com.atguigu.mybatis.mapper.cus_order.OrderMapper;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestOfOrder {

    @Autowired
    OrderMapper om;

    @Autowired
    CustomerMapper cm;

    @Test
    public void t8(){
        List<Order> list = cm.getAllOrder();
        for(Order temp : list){
            System.out.println(temp);
        }

    }




    @Test
    public void t1(){
        Order o1 = om.getOrderById(1L);
        System.out.println(o1);
    }

    @Test
    public void t2(){
        Customer c1 = cm.getCustomerById(1L);
        System.out.println(c1);
    }

    //分步按照id查询Customer
    @Test
    public void t3(){
        Customer c1 = cm.getCustomerById_orderSteps(1L);
        System.out.println(c1);
    }

    //分步按照id查询Order
    @Test
    public void t4(){
        Order o1 = om.getOrderById_Step(1L);
        System.out.println(o1);

    }


    //解决循环调用导致的无线递归问题
    @Test
    public void t5(){
        Order o1 = om.getOrderByIdAndCustomerAndOrder(1L);
        System.out.println(o1);
    }


    //分步查询, 使用延迟查询
    @Test
    public void t6() throws InterruptedException {
        Order o1 = om.getOrderById_Step(1L);
        System.out.println(o1.getId());
        Thread.sleep(3000);
        System.out.println(o1.getCus());

    }

    //查询所有customer
    @Test
    public void t7(){
        List<Customer> list = cm.getAllCustomer();
        for(Customer temp : list){
            System.out.println(temp);
        }
    }



}
