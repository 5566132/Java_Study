package com.atguigu.mybatis.mapper.Emp;


import com.atguigu.mybatis.bean.emp.Emp;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmpParamMapper {
    Emp getEmployee1(@Param(value = "id") Long what_is_this);
    Emp getEmployee2(@Param(value = "list")List<Long> dawdwudhuwhdw, @Param(value = "noneed") Long abb);
    void addEmployee1(Emp add);
    void addEmployee2(Map<String, Object> m);

    BigDecimal getSalaryById(@Param(value = "id") Long id);

    List<Emp> getAll();

    @MapKey("id")
    Map<Integer, Emp> getAllMap();

}
