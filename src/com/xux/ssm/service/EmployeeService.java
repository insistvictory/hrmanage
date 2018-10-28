package com.xux.ssm.service;

import com.xux.ssm.entity.*;

import java.util.List;

/**
 * Created by Administrator on 2018/10/20.
 */
public interface EmployeeService {
    Employee findEmployeeById(Integer id);

    Employee findEmployeeByUid(Integer id);

    void modifyEmployee(Employee employee);

    List<Dept> lookDepts();

    Dept findDeptByName(String deptName);

    List<Job> findJobsByDeptId(Integer id);

    User findUserByUid(Integer id);

    void addRewardPublish(RewardPublish rewardPublish);

    void addCheck(Check check);

    Check findCheckByTimeAndUid(int year, int month, int date, Integer eid);

    void updateCheck(Check check);

    List<Employee> findEmployeeByJobName(String jName);


    List<Train> findTrainsByDeptName(String dept);

    List<Check> findChecksByYearAndMonthAndEid(int i, int k, Integer eid);


    Salary findSalariesByTime(int year, int month, Integer eid);


    void addArgument(Argument argument);
}
