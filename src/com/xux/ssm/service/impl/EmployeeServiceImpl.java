package com.xux.ssm.service.impl;

import com.xux.ssm.dao.*;
import com.xux.ssm.entity.*;
import com.xux.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/10/20.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private JobDao jobDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RewardPublishDao rewardPublishDao;
    @Autowired
    private CheckDao checkDao;
    @Autowired
    private TrainDao trainDao;
    @Autowired
    private SalaryDao salaryDao;
    @Autowired
    private ArgumentDao argumentDao;

    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeDao.queryEmployeeById(id);
    }

    @Override
    public Employee findEmployeeByUid(Integer id) {
        return employeeDao.queryEmployeeByUid(id);
    }

    @Override
    public void modifyEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @Override
    public List<Dept> lookDepts() {
        return deptDao.queryAllDepts();
    }

    @Override
    public Dept findDeptByName(String deptName) {
        return deptDao.queryDeptByName(deptName);
    }

    @Override
    public List<Job> findJobsByDeptId(Integer id) {
        return jobDao.queryJobsByDeptId(id);
    }

    @Override
    public User findUserByUid(Integer id) {
        return userDao.queryUserByUid(id);
    }

    @Override
    public void addRewardPublish(RewardPublish rewardPublish) {
        rewardPublishDao.addRewardPublish(rewardPublish);
    }

    @Override
    public void addCheck(Check check) {
        checkDao.addCheck(check);
    }

    @Override
    public Check findCheckByTimeAndUid(int year, int month, int date, Integer eid) {
        return checkDao.queryCheckByTimeAndUid(year,month,date,eid);
    }

    @Override
    public void updateCheck(Check check) {
        checkDao.updateCheck(check);
    }

    @Override
    public List<Employee> findEmployeeByJobName(String jName) {
        return employeeDao.queryEmployeeByJobName(jName);
    }

    @Override
    public List<Train> findTrainsByDeptName(String dept) {
        return trainDao.queryTrainsByDeptName(dept);
    }

    @Override
    public List<Check> findChecksByYearAndMonthAndEid(int i, int k, Integer eid) {
        return checkDao.queryChecksByYearAndMonthAndEid(i,k,eid);
    }

    @Override
    public Salary findSalariesByTime(int year, int month, Integer eid) {
        return salaryDao.querySalaryByEidAndTime(year,month,eid);
    }

    @Override
    public void addArgument(Argument argument) {
        argumentDao.addArgument(argument);
    }
}
