package com.itheima.mp.domain.query;

import lombok.Data;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.math.BigDecimal;

@Data
public class UserQuery {

    private String name;
    private BigDecimal minBalance;
    private BigDecimal maxBalance;


}
