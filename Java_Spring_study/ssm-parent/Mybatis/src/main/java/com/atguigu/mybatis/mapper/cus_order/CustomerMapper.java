package com.atguigu.mybatis.mapper.cus_order;

import com.atguigu.mybatis.bean.cus_order.Customer;
import com.atguigu.mybatis.bean.cus_order.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerMapper {

    public Customer getCustomerById(@Param("id") Long id);
    public Customer getCustomerById_orderSteps(@Param("id") Long id);


    //按照id查单一Customer
    public Customer get(@Param("id") Long id);

    //查询所有Customer
    public List<Customer> getAllCustomer();



    //查询所有Order
    public List<Order> getAllOrder();

}
