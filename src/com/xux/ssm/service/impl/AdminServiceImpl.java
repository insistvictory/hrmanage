package com.xux.ssm.service.impl;

import com.xux.ssm.dao.*;
import com.xux.ssm.entity.*;
import com.xux.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/10/14.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private ResumeDao resumeDao;
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private JobDao jobDao;
    @Autowired
    private InterviewDao interviewDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public Resume searchDelivererDetailByDid(Integer did) {
        return resumeDao.queryResumeById(did);
    }


    @Override
    public List<Dept> lookDepts() {
        return deptDao.queryAllDepts() ;
    }

    @Override
    public List<Job> findAllJobs() {
        return jobDao.queryAllJobs();
    }

    @Override
    public void addInterview(Interview interview) {
        interviewDao.addInterview(interview);
    }

    @Override
    public List<Job> findJobsByDeptId(Integer id) {
        return jobDao.queryJobsByDeptId(id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDao.queryAllEmployee();
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeDao.queryEmployeeById(id);
    }

    @Override
    public void updateEmployeeById(Integer id, String dept, String job) {
        employeeDao.updateEmployeeById(id,dept,job);
    }
}
