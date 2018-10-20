package com.xux.ssm.dao;

import com.xux.ssm.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/10/14.
 */
public interface EmployeeDao {
     List<Employee> queryAllEmployee();

     Employee queryEmployeeById(Integer id);

     void insertEmployee(Employee employee);

     void deleteEmployeeById(Integer id);

     void edit(Employee employee);

    List<Employee> queryEmployeeByDeptName(String name);

    List<Employee> queryEmployeeByJobName(String name);

    void updateEmployeeById( @Param("id")Integer id, @Param("dept")String dept,@Param("job")String job);
}
