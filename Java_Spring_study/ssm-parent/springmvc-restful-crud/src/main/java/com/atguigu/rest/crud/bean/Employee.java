package com.atguigu.rest.crud.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(description = "这个对象6666")
public class Employee {

    @Schema(description = "这个就是正常对象的id")
    private Long id;


    private String name;
    private Integer age;
    private String email;
    private String gender;
    private String address;
    private BigDecimal salary;
    private String dept;


}
