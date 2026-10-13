package com.itheima.mp.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;



@Data
public class DtoUser {



    private Long id;

    private String name;

    private Integer age;

    private BigDecimal salary;

    private String password;

    private String address;





}
