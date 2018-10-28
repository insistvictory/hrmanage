package com.xux.ssm.test;


import com.xux.ssm.dao.*;
import com.xux.ssm.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

//启动时加载SpringIOC容器
@RunWith(SpringJUnit4ClassRunner.class)
//引入Spring的配置文件
@ContextConfiguration({"classpath:spring.xml"})
public class TestOtherDao {
  	@Autowired
	private ApplicationDao applicationDao;
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
	private SalaryDao salaryDao;
  	@Autowired
	private ArgSalaryDao argSalaryDao;
  	@Autowired
	private ArgumentDao argumentDao;
  	@Test
	public void testQueryAllApplications(){
		System.out.println(applicationDao.queryAllApplications());
	}
	@Test
	public void TestQueryApplicationByResumeId(){
		System.out.println(applicationDao.queryApplicationByResumeId(1));
	}
	@Test
	public void TestQueryApplicationById(){
		System.out.println(applicationDao.queryApplicationById(8));
	}
	@Test
	public void testAddApplication(){
		Application application=new Application(2,new Date(),"未查看");
		applicationDao.addApplication(application);
	}
	@Test
	public void testDeleteApplicationById(){
		applicationDao.deleteApplicationById(11);

	}
	@Test
	public void testQueryInterviewByApplyId(){
		System.out.println(interviewDao.queryInterviewByApplyId(1));
	}
	@Test
	public void testQueryEmployeeByDeptName(){
		System.out.println(employeeDao.queryEmployeeByDeptName("人事部"));
	}
	@Test
	public void testQueryAllEmployee(){
		System.out.println(employeeDao.queryAllEmployee());
	}
	@Test
	public void testUpdateEmployeeById(){
		employeeDao.updateEmployeeById(1,"人事部","人事部主管");
	}
	@Test
	public void testAddTrain(){
		trainDao.addTrain(new Train("22",new Date(),"人事部",30));
	}
	@Test
	public void testQueryAllTrains(){
		System.out.println(trainDao.queryAllTrains());
	}
	@Test
	public void testQueryTrainById(){
		System.out.println(trainDao.queryTrainById(1));
	}
	@Test
	public void testUpdateEmployee(){
		Employee employee=employeeDao.queryEmployeeById(2);
		System.out.println(employee);
		employee.setTel("44444");
		employeeDao.updateEmployee(employee);
	}
	@Test
	public void testAddReward(){
		rewardPublishDao.addRewardPublish(new RewardPublish(1,"ewew",32332.2,new Date()));
	}
	@Test
	public void testQueryInterviewsByReadStatus(){
		interviewDao.queryAllInterviewsByReadStatus("已查看");
	}
	@Test
	public void testAddCheck(){
		Check check=new Check();
		check.setWorkStatus("测试迟到");
		check.setBeginTime("2018-1-21 10:21:11");
		check.setDay(21);
		check.setMonth(1);
		check.setYear(2018);
		check.setEid(1);
		checkDao.addCheck(check);
	}
	@Test
	public void testQueryCheckByTimeAndUid(){
		System.out.println(checkDao.queryCheckByTimeAndUid(2018,1,21,1));

	}
	@Test
	public void testUpdateCheck(){
		Check check=new Check();
		check.setWorkStatus("测试迟到");
		check.setBeginTime("2018-1-21 10:21:11");
		check.setDay(21);
		check.setMonth(1);
		check.setYear(2018);
		check.setEid(1);
		check.setEndTime("2018-1-21 17:21:11");
		check.setId(1);
		checkDao.updateCheck(check);
	}
	@Test
	public void queryTrainsByDept(){
		System.out.println(trainDao.queryTrainsByDeptName("人事部"));
	}
	@Test
	public void testSaveSalary(){
		Salary salary=new Salary();
		salary.setSumSalary(323.3);
		salary.setSociety(-200.0);
		salary.setMonth(10);
		salary.setYear(2018);
		salary.setRewardSalary(3232.3);
		salary.setBaseSalary(232.2);
		salary.setArgSalary(33.3);
		salary.setEid(1);
		salaryDao.saveSalary(salary);
	}
	@Test
	public void testArguments(){
		String string="同意";
		ArgSalary a=argSalaryDao.queryArgSalaryByEidAndTimeAndAgreeStatus(1,2018,10,string);
		System.out.println(a);
		System.out.println(a.getAsalry());
	}
	@Test
	public void testQuerySalaryByEid(){
		System.out.println(salaryDao.querySalaryByEid(1));
	}
	@Test
	public void testQuerySalaryByEidAndTime(){
		System.out.println(salaryDao.querySalaryByEidAndTime(2018,10,1));
	}
	@Test
	public void testQuerySalariesByTime(){
		System.out.println(salaryDao.querySalariesByTime(2018,10));
	}
	@Test
	public void testQueryInterviewById(){
		System.out.println(interviewDao.queryInterviewById(15));
	}
	@Test
	public void testUpdateInterview(){
		Interview interview=new Interview();
		interview.setHire("呃呃");
		interview.setReadStatus("已查看");
		interview.setApplyId(32);
		interview.setInterviewTime(new Date());
		interview.setId(15);
		interviewDao.updateInterview(interview);
	}
	@Test
	public void testAddArgument(){
		Argument argument=new Argument();
		argument.setArgSalary(32.3);
		argument.setReason("false");
		argument.setSalaryId(1);
		argumentDao.addArgument(argument);
	}
	@Test
	public void testQueryAllArguments(){
		System.out.println(argumentDao.queryAllArgument());
	}
	@Test
	public void testAddArsalary(){
		ArgSalary argSalary=new ArgSalary();
		argSalary.setYear(2018);
		argSalary.setMonth(10);
		argSalary.setEid(1);
		argSalary.setAgreeStatus("同意");
		argSalary.setAsalry(213.3);
		argSalaryDao.addArgSalary(argSalary);
	}
}
