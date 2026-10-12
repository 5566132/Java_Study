package com.itheima.mp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.itheima.mp.domain.po.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    public List<User> selectAllUser();



    //利用Wrapper传递条件去查询多个id的数据
    public List<User> selectUserByWrapper(@Param("ew") LambdaQueryWrapper<User> lqw);

    //根据id扣减余额
    public void DeductMoneyById(@Param("id") Long id, @Param("money") BigDecimal money);






}
