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

//����ʱ����SpringIOC����
@RunWith(SpringJUnit4ClassRunner.class)
//����Spring�������ļ�
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
		dept.setName("������");
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
		dept.setName("����");
		Date date=new Date();
		dept.setCreateTime(date);
		deptDao.updateDept(dept);
	}
	@Test
	public void testJobAdd(){
		Job job=new Job();
		job.setCreateTime(new Date());
		job.setDeptId(2);
		job.setName("���²�����");
		jobDao.addJob(job);
	}
	@Test
	public void testQueryJobByName(){
		System.out.println(jobDao.queryJobByName("���²�����"));
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
		job.setName("���²�����");
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
		Dept dept=deptDao.queryDeptByName("���²�");
		System.out.println(dept);
	}

	@Test
	public void testQueryJobsByDeptId(){
		List<Job> list=jobDao.queryJobsByDeptId(1);
		System.out.println(list);
	}
	@Test
	public void testAddResume(){
		Resume resume=new Resume(3,"bbb","��",33,"����","32423432","231@123","���²�","���²�����","��Ա","С��","wodsfe","4000-6000","game");
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
		Resume resume=new Resume(1,"ccc","Ů",19,"����","32423432","231@123","���²�","���²�����","��Ա","����","������","4000-6000","game");
		resumeDao.updateResume(resume);
	}
	@Test
	public void testUpdateInterviewReadStatus(){
		interviewDao.modifyInterviewReadStatus("δ�鿴",1);
	}
	@Test
	public void testUpdateUserPassword(){
		userDao.updatePassword(1,"abc");
	}

	/**
	 * ��ѯ������Ƹ��Ϣ
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
