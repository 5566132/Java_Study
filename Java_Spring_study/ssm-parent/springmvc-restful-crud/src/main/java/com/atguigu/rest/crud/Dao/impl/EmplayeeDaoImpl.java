package com.atguigu.rest.crud.Dao.impl;

import com.atguigu.rest.crud.Dao.EmplayeeDao;
import com.atguigu.rest.crud.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("e1")
public class EmplayeeDaoImpl implements EmplayeeDao {

    @Autowired
    private JdbcTemplate jt;


    //单id查询
    @Override
    public Employee getEmployee(Long id) {
        String sql = "select * from emp where id = ?";
        Employee ret = jt.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), id);
        return ret;
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "select * from emp";
        List<Employee> ret = jt.query(sql, new BeanPropertyRowMapper<>(Employee.class));
        return ret;
    }

    @Override
    public void addEmployee(Employee employee) {
        System.out.println("走到了新增员工的Dao");
        jt.update("insert into emp(name, age, email, gender, address, salary, dept) values(?,?,?,?,?,?,?)",
                employee.getName(), employee.getAge(), employee.getEmail(),
                employee.getGender(), employee.getAddress(),
                employee.getSalary(), employee.getDept());
    }

    @Override
    public void updateEmployee(Employee employee) {
        jt.update("update emp set name = ?, age = ?, email = ?, gender = ?, address = ?, salary = ?, dept = ? where id = ?",
                employee.getName(), employee.getAge(), employee.getEmail(),
                employee.getGender(), employee.getAddress(),
                employee.getSalary(), employee.getDept(), employee.getId());
    }

    @Override
    public void deleteEmployee(Long id) {
        jt.update("delete from emp where id = ?", id);
    }
}
