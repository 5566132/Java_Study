package com.atguigu.mybatis.mapper.dynamicSql;

import com.atguigu.mybatis.bean.emp.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

//这些东西都是Dao层的, 或者说Mapper层
@Mapper
public interface EmpDynamicSqlMapper {
    public List<Emp> getEmpByNameAndSalary(@Param("name") String name, @Param("salary") BigDecimal salary);
    public void updateEmpById(@Param("id") Long id, @Param("emp") Emp it);


    public List<Emp> getEmpByList(@Param("list")List<Long> what_can_i_say);

    public void insertEmpByList(@Param("list") List<Emp> jjj);
    public void updateEmpByList(@Param("list") List<Emp> jjj);
    public void deleteEmpByList(@Param("list") List<Emp> jjj);


}
