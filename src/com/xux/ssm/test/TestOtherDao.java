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
}
