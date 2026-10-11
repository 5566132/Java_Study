package com.itheima.mp.controller;


import com.itheima.mp.domain.po.User;
import com.itheima.mp.iservice.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class Controller {
    @Autowired
    IUserService iUserService;

    //单id查询
    @GetMapping("/user/{id}")
    public User handle1(@PathVariable("id") Long id){
        User u = iUserService.getById(id);
        return u;
    }

    //批量查询
    @GetMapping("/users")
    public List<User> handle2(@RequestBody List<Long> list){
        List<User> ret = iUserService.listByIds(list);
        return ret;
    }


}
