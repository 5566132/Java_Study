package com.itheima.mp.iservice.Impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.iservice.IUserService;
import com.itheima.mp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService  {
    @Autowired
    UserMapper userMapper;

    @Override
    public void DeductMoneyById(Long id, BigDecimal money){
        userMapper.DeductMoneyById(id , money);
    }

}
