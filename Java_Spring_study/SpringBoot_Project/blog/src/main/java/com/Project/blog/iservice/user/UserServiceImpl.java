package com.Project.blog.iservice.user;

import com.Project.blog.Bean.Po.User;
import com.Project.blog.mapper.UserMapper;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
    @Autowired
    UserMapper userMapper;



}
