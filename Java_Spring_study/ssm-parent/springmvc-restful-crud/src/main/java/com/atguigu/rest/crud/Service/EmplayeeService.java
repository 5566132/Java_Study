package com.atguigu.rest.crud.Service;

import com.atguigu.rest.crud.bean.Employee;

import java.util.List;

public interface EmplayeeService {
    public Employee getEmployee(Long id);

    public List<Employee> getAllEmployees();

    public void addEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public void deleteEmployee(Long id);
}
