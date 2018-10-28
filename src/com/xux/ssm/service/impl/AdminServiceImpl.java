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
    @Autowired
    private TrainDao trainDao;
    @Autowired
    private RewardPublishDao rewardPublishDao;
    @Autowired
    private CheckDao checkDao;
    @Autowired
    private ArgSalaryDao argSalaryDao;
    @Autowired
    private SalaryDao salaryDao;
    @Autowired
    private ArgumentDao argumentDao;
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

    @Override
    public List<Train> findAllTrains() {
        return trainDao.queryAllTrains();
    }

    @Override
    public Train findTrainDetailById(Integer id) {
        return trainDao.queryTrainById(id);
    }

    @Override
    public void addTrain(Train train) {
        trainDao.addTrain(train);
    }

    @Override
    public void updateTrain(Train train) {
        trainDao.updateTrain(train);
    }

    @Override
    public List<Interview> findAllInterviewsByReadStatus(String string) {
        return interviewDao.queryAllInterviewsByReadStatus(string);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @Override
    public void deleteTrainById(Integer id) {
        trainDao.deleteTrainById(id);
    }

    @Override
    public List<RewardPublish> findAllRewardAndPublish() {
        return rewardPublishDao.queryRewardPublishes();
    }

    @Override
    public List<Check> findPersonChecksByTime(int year, int month, Integer eid) {
        return checkDao.queryChecksByYearAndMonthAndEid(year,month,eid);
    }

    @Override
    public List<RewardPublish> findAllRewardAndPublishByEid(Integer eid) {
        return rewardPublishDao.queryRewardPublishByEid(eid);
    }



    @Override
    public void addSalary(Salary salary) {
        salaryDao.saveSalary(salary);
    }

    @Override
    public ArgSalary findArgSalaryByEidAndTimeAndAgreeStatus(Integer eid, int year, int i, String str) {
        return argSalaryDao.queryArgSalaryByEidAndTimeAndAgreeStatus(eid,year,i,str);
    }

    @Override
    public Salary findPersonSalaryByEid(Integer eid) {
        return salaryDao.querySalaryByEid(eid);
    }

    @Override
    public Salary findPersonSalaryByEidAndTime(int year, int month, Integer eid) {
        return salaryDao.querySalaryByEidAndTime(year,month,eid);
    }

    @Override
    public List<Salary> findSalariesByTime(int i, int k) {
        return salaryDao.querySalariesByTime(i,k);
    }

    @Override
    public List<Argument> findAllArguments() {
        return  argumentDao.queryAllArgument();
    }

    @Override
    public Salary findSalaryById(Integer id) {
        return salaryDao.querySalaryById(id);
    }

    @Override
    public void addArgSalary(ArgSalary argSalary) {
        argSalaryDao.addArgSalary(argSalary);
    }

    @Override
    public void updateDeptByNameAndId(String name, Integer id) {
        deptDao.updateDeptByNameAndId(name,id);
    }

    @Override
    public void deleteJobByName(String name) {
        jobDao.deleteJobByName(name);
    }

}
