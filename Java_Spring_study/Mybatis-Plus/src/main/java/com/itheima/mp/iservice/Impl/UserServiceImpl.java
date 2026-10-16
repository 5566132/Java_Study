package com.itheima.mp.iservice.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.query.UserQuery;
import com.itheima.mp.domain.vo.VoUser;
import com.itheima.mp.iservice.IUserService;
import com.itheima.mp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService  {


    @Autowired
    UserMapper userMapper;



    //根据id扣减员工money
    @Override
    public void DeductMoneyById(Long id, BigDecimal money){
        User user = this.getById(id);
        if(user == null){
            throw new RuntimeException("用户不存在");
        }
        if(user.getSalary().compareTo(money) < 0){
            throw new RuntimeException("用户余额不足");
        }
        lambdaUpdate()
                .set(User::getSalary,user.getSalary().subtract(money))
                .set(user.getSalary().subtract(money).compareTo(BigDecimal.ZERO) == 0, User::getAge, 618)
                .eq(user.getId() != null, User::getId, id)
                .update();


        //userMapper.DeductMoneyById(id , money);
    }


    //利用集合传递id去查询指定id的User
    @Override
    public List<User> selectByList(List<Long> list){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>()
                .in(User::getId, list);
        List<User> ret  = userMapper.selectUserByWrapper(lqw);
        return ret;
    }

    //传递UserQuery对象, 然后利用lambdaQuery()构造条件去查询
    public List<VoUser> selectByUQ(UserQuery uq){
        List<User> list = lambdaQuery()
                .select(User::getName)
                .like(uq.getName()!=null, User::getName, uq.getName())
                .ge(uq.getMinBalance() != null , User::getSalary, uq.getMinBalance())
                .le(uq.getMaxBalance() != null, User::getSalary, uq.getMaxBalance())
                .list();
        List<VoUser> ret = BeanUtil.copyToList(list, VoUser.class);
        return ret;
    }



}
