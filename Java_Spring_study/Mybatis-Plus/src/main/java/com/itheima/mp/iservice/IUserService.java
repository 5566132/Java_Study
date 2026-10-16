package com.itheima.mp.iservice;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.query.UserQuery;
import com.itheima.mp.domain.vo.VoUser;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;


public interface IUserService extends IService<User> {
    //根据id更改余额
    public void DeductMoneyById(@Param("id")Long id, @Param("money")BigDecimal money);

    //根据List集合批量查询
    public List<User> selectByList(@Param("list") List<Long> list);

    //传递UserQuery对象, 然后利用lambdaQuery()构造条件去查询
    public List<VoUser> selectByUQ(UserQuery uq);

}
