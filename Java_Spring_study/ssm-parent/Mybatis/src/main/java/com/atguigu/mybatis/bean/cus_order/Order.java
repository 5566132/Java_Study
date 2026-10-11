package com.atguigu.mybatis.bean.cus_order;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private Long id;
    private String address;
    private BigDecimal amount;
    private Long customerId;


    private Customer cus;
}
