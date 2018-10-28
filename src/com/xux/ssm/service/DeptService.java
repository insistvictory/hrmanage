package com.xux.ssm.service;

import com.xux.ssm.entity.Dept;
import com.xux.ssm.entity.Employee;

import java.util.List;

/**
 * Created by Administrator on 2018/10/13.
 */
public interface DeptService {
    List<Dept> findAllDepts();

    Dept findDeptByName(String dName);


    List<Employee> searchEmployeeByDeptName(String name);

    List<Employee> searchEmployeeByJobName(String name);

    void addDept(Dept dept);

    void editDept(Dept dept);

    void deleteDeptByName(String name);
}
