package com.atguigu.mybatis.bean.cus_order;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
@Data
public class Customer {
    private Long id;
    private String name;
    private String phone;

    private List<Order> orders;
}
