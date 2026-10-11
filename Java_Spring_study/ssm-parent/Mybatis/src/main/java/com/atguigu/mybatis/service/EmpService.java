package com.atguigu.mybatis.service;

import com.atguigu.mybatis.bean.emp.Emp;
import com.atguigu.mybatis.mapper.Emp.EmpMapper;
import com.atguigu.mybatis.mapper.dynamicSql.EmpDynamicSqlMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    EmpDynamicSqlMapper empDynamicSqlMapper;

    @Autowired
    EmpMapper empMapper;


    //获取全部员工信息
    public List<Emp> getAllEmp(){
        List<Emp> list = empDynamicSqlMapper.getEmpByNameAndSalary(null,null);
        return list;
    }
    //获取指定页的员工信息
    public List<Emp> getPageEmp(int page){
        PageHelper.startPage(page, 5);
        List<Emp> list = empMapper.getAllEmps();
        return list;
    }



}
