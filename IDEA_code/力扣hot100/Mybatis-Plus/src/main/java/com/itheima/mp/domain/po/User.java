package com.itheima.mp.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName(value = "tb_user", autoResultMap = true)
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "t_name")
    private String name;

    @TableField("age")
    private Integer age;

    @TableField("salary")
    private BigDecimal salary;

    @TableField("t_order")
    private Integer t_order;

    @TableField("address")
    private String address;

    @TableField(exist = false)
    private String bbbb;

}
