package com.atguigu.mybatis.mapper.cus_order;

import com.atguigu.mybatis.bean.cus_order.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    Order getOrderById(@Param("id") Long id);
    Order getOrderByCustomerId(@Param("id") Long customerId);


    //分布查询订单
    Order getOrderById_Step(@Param("id") Long id);


    //根据id查订单 并且查到下单的用户 并且 查到用户的所有订单
    Order getOrderByIdAndCustomerAndOrder(@Param("id") Long id);


}
