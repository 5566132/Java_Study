package com.atguigu.mybatis.mapper.Emp;

import com.atguigu.mybatis.bean.emp.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmpMapper {

    /** 按 id 查单个员工 */
    Emp getEmpById(@Param("id") Integer id);

    /** 查所有员工 */
    List<Emp> getAllEmps();

    /** 新增员工 */
    void insertEmp(Emp emp);

    /** 修改员工 */
    void updateEmp(Emp emp);

    /** 按 id 删除员工 */
    void deleteEmp(@Param("id") Integer id);
}
