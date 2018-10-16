package com.xux.ssm.dao;

import com.xux.ssm.entity.Employee;

import java.util.List;

/**
 * Created by Administrator on 2018/10/14.
 */
public interface EmployeeDao {
    public List<Employee> queryAllEmployee();

    public Employee queryEmployeeById(Integer id);

    public void insertEmployee(Employee employee);

    public void deleteEmployeeById(Integer id);

    public Employee findById(Integer id);

    public void edit(Employee employee);
}
