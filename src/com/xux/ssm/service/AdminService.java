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

    List<Train> findAllTrains();

    Train findTrainDetailById(Integer id);

    void addTrain(Train train);

    void updateTrain(Train train);


    List<Interview> findAllInterviewsByReadStatus(String string);

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteTrainById(Integer id);

    List<RewardPublish> findAllRewardAndPublish();


    List<Check> findPersonChecksByTime(int year, int month, Integer eid);

    List<RewardPublish> findAllRewardAndPublishByEid(Integer eid);


    void addSalary(Salary salary);

    ArgSalary findArgSalaryByEidAndTimeAndAgreeStatus(Integer eid, int year, int i, String str);

    Salary findPersonSalaryByEid(Integer eid);

    Salary findPersonSalaryByEidAndTime(int year, int month, Integer eid);

    List<Salary> findSalariesByTime(int i, int k);

    List<Argument> findAllArguments();


    Salary findSalaryById(Integer id);

    void addArgSalary(ArgSalary argSalary);


    void updateDeptByNameAndId(String name, Integer id);

    void deleteJobByName(String name);
}
