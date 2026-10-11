package com.atguigu.rest.crud.Service.impl;

import com.atguigu.rest.crud.Dao.EmplayeeDao;
import com.atguigu.rest.crud.Service.EmplayeeService;
import com.atguigu.rest.crud.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmplayeeService {

    @Autowired
    private EmplayeeDao emplayeeDao;

    @Override
    public Employee getEmployee(Long id) {
        return emplayeeDao.getEmployee(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return emplayeeDao.getAllEmployees();
    }

    @Override
    public void addEmployee(Employee employee) {
        System.out.println("到新增员工的Service层了");
        emplayeeDao.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        emplayeeDao.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        emplayeeDao.deleteEmployee(id);
    }
}
