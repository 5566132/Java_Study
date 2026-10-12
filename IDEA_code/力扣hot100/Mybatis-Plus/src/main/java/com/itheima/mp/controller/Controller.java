package com.itheima.mp.controller;


import cn.hutool.core.bean.BeanUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.itheima.mp.domain.dto.DtoUser;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.query.UserQuery;
import com.itheima.mp.domain.vo.VoUser;
import com.itheima.mp.iservice.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController("User管理")
@RequestMapping("")
@Tag(name = "User管理")
public class Controller {
    @Autowired
    IUserService iUserService;


    //单id查询
    @Operation(summary = "单id查询User")
    @GetMapping("/user/{id}")
    public VoUser handle1(@PathVariable("id") Long id){
        User u = iUserService.getById(id);
        VoUser vo = new VoUser();
        //BeanUtils.copyProperties(u,vo);


        return BeanUtil.copyProperties(u, VoUser.class);
    }


    //批量查询
    @GetMapping("/users")
    public List<VoUser> handle2(@RequestBody Map<String, Object> map){
        List<User> ret = iUserService.selectByList((List<Long>)map.get("list"));
        List<VoUser> list = BeanUtil.copyToList(ret, VoUser.class);
        return list;
    }

    //根据id和money去扣减指定员工的余额
    @Operation(summary = "根据id和money去扣减指定员工的余额")
    @PutMapping("/user/{id}/deduction/{money}")
    public void handle3(@Parameter(description = "用户id") @PathVariable("id") Long id , @Parameter(description = "要扣减的余额") @PathVariable("money")BigDecimal m){
        iUserService.DeductMoneyById(id, m);

    }

    //新增员工
    @PostMapping("/users")
    public void handle4(@RequestBody DtoUser add){
        //DtoUser转换成User
        User it = new User();
        BeanUtils.copyProperties(add, it);
        it.setLdt(LocalDateTime.now());
        iUserService.save(it);
        System.out.println("新增员工成功");
    }

    //删除员工
    @DeleteMapping("/user/{id}")
    public void handle5(@PathVariable("id") Long id){
        iUserService.removeById(id);
        System.out.println("删除员工结束");
    }

    //根据指定条件去查询User
    @GetMapping("/list")
    public List<VoUser> handle6(UserQuery uq){
        return iUserService.selectByUQ(uq);
    }





}
