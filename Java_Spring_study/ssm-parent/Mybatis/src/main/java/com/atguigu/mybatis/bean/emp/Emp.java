package com.atguigu.mybatis.bean.emp;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 对应数据库表 t_emp 的实体类
 */
@Data
public class Emp {
    private Integer id;
    private String empName;
    private Integer age;
    private BigDecimal empSalary;

}
