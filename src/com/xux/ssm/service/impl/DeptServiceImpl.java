package com.xux.ssm.service.impl;

import com.xux.ssm.dao.DeptDao;
import com.xux.ssm.dao.EmployeeDao;
import com.xux.ssm.entity.Dept;
import com.xux.ssm.entity.Employee;
import com.xux.ssm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/10/13.
 */
@Service
public class DeptServiceImpl implements DeptService{
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public List<Dept> findAllDepts() {
        return deptDao.queryAllDepts();
    }

    @Override
    public Dept findDeptByName(String dName) {
        return deptDao.queryDeptByName(dName);
    }

    @Override
    public List<Employee> searchEmployeeByDeptName(String name) {
        List<Employee> employees=employeeDao.queryEmployeeByDeptName(name);
        return employees;
    }

    @Override
    public List<Employee> searchEmployeeByJobName(String name) {
        List<Employee> employees=employeeDao.queryEmployeeByJobName(name);
        return employees;
    }

    @Override
    public void addDept(Dept dept) {
        deptDao.addDept(dept);
    }

    @Override
    public void editDept(Dept dept) {
        deptDao.updateDept(dept);
    }
}
