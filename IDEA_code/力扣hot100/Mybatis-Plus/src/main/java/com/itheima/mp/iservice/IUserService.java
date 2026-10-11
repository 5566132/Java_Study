package com.itheima.mp.iservice;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.mp.domain.po.User;

import java.math.BigDecimal;

public interface IUserService extends IService<User> {
    //根据id更改余额
    public void DeductMoneyById(Long id, BigDecimal money);

    //根据List集合批量查询

}
