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
public class TestDao {
  	@Autowired
  	private UserDao userDao;
  	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private DeptDao deptDao;
	@Autowired
	private JobDao jobDao;
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private RecruitmentInfoDao recruitmentInfoDao;
	@Autowired
	private InterviewDao interviewDao;
	@Test
	public void testUserDao(){
		System.out.println(userDao.queryUserByNameAndPassword("aaa","aaa"));
	}
	@Test
	public void testInsertUser(){
		User user=new User();
		user.setName("add");
		user.setPassword("add");
		user.setType(4);
		userDao.insertUser(user);

	}
	@Test
	public void testQueryResumeByUid(){
		Integer id=1;
		Resume resume=resumeDao.queryResumeByUid(id);
		System.out.println(resume);
	}
	@Test
	public void testQueryResumeById(){
		Integer id=1;
		Resume resume=resumeDao.queryResumeById(1);
		System.out.println(resume);
	}
	@Test
	public void testQueryAllDepts(){
		System.out.println(deptDao.queryAllDepts());
	}
	@Test
	public void testQueryAllJobs(){
		System.out.println(jobDao.queryAllJobs());
	}
	@Test
	public void testAddDept(){
		Dept dept=new Dept();
		dept.setName("技术部");
		Date date=new Date();
		dept.setCreateTime(date);
		deptDao.addDept(dept);
	}
	@Test
	public void testDeleteDept(){
		deptDao.deleteDeptById(1);
	}
	@Test
	public void testUpdateDept(){
		Dept dept=new Dept();
		dept.setId(4);
		dept.setName("财务部");
		Date date=new Date();
		dept.setCreateTime(date);
		deptDao.updateDept(dept);
	}
	@Test
	public void testJobAdd(){
		Job job=new Job();
		job.setCreateTime(new Date());
		job.setDeptId(2);
		job.setName("人事部经理");
		jobDao.addJob(job);
	}
	@Test
	public void testQueryJobByName(){
		System.out.println(jobDao.queryJobByName("人事部主管"));
	}
	@Test
	public void testJobDel(){
		jobDao.deleteJobById(1);
	}
	@Test
	public void testJobUpdate(){
		Job job=new Job();
		job.setCreateTime(new Date());
		job.setDeptId(2);
		job.setId(4);
		job.setName("人事部主管");
		jobDao.updateJob(job);
	}
	@Test
	public void testQueryEmployeeById(){
		Integer id=1;
		Employee employee=employeeDao.queryEmployeeById(1);
		System.out.println(employee);
	}
	@Test
	public void testQueryDeptByName(){
		Dept dept=deptDao.queryDeptByName("人事部");
		System.out.println(dept);
	}

	@Test
	public void testQueryJobsByDeptId(){
		List<Job> list=jobDao.queryJobsByDeptId(1);
		System.out.println(list);
	}
	@Test
	public void testAddResume(){
		Resume resume=new Resume(3,"bbb","男",33,"本科","32423432","231@123","人事部","人事部主管","党员","小炮","wodsfe","4000-6000","game");
		resumeDao.addResume(resume);
	}
	@Test
	public void testQueryUserByUid(){
		System.out.println(userDao.queryUserByUid(8));
	}
	@Test
	public void testQueryUserByPassword(){
		System.out.println(userDao.queryUserByPassword("aaa",1));
	}
	@Test
	public void testUpdateResume(){
		Resume resume=new Resume(1,"ccc","女",19,"本科","32423432","231@123","人事部","人事部主管","团员","大炮","明萌派","4000-6000","game");
		resumeDao.updateResume(resume);
	}
	@Test
	public void testUpdateInterviewReadStatus(){
		interviewDao.modifyInterviewReadStatus("未查看",1);
	}
	@Test
	public void testUpdateUserPassword(){
		userDao.updatePassword(1,"abc");
	}

	/**
	 * 查询所有招聘信息
	 */
	@Test
	public void testQueryRecruits(){
		System.out.println(recruitmentInfoDao.queryAllRecruitInfos());
	}
	@Test
	public void testQueryRecruitById(){
		System.out.println(recruitmentInfoDao.queryRecruitInfoById(2));
	}
}
