package com.xux.ssm.service;

import com.xux.ssm.entity.*;

import java.util.List;

/**
 * Created by Administrator on 2018/10/14.
 */
public interface AdminService {
    Resume searchDelivererDetailByDid(Integer did);

    List<Dept> lookDepts();

    List<Job> findAllJobs();

    void addInterview(Interview interview);


    List<Job> findJobsByDeptId(Integer id);

    List<Employee> findAllEmployees();

    Employee findEmployeeById(Integer id);

    void updateEmployeeById(Integer id, String dept, String job);
}
