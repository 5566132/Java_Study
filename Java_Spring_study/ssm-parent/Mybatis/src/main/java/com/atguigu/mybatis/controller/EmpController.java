package com.atguigu.mybatis.controller;


import com.atguigu.mybatis.bean.emp.Emp;
import com.atguigu.mybatis.service.EmpService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class EmpController {

    @Autowired
    EmpService es;

    @GetMapping(value = "/employees")
    public List<Emp> getAllEmp(){
        return es.getAllEmp();
    }

    @GetMapping(value = "/employees/page")
    public PageInfo getPageEmp(@RequestParam(value = "page", defaultValue = "1") int pa){
        List<Emp> list = es.getPageEmp(pa);
        PageInfo<Emp> ret = new PageInfo<>(list);
        return ret;
    }


}
