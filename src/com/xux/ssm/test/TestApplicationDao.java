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
public class TestApplicationDao {
  	@Autowired
	private ApplicationDao applicationDao;
  	@Test
	public void testQueryAllApplications(){
		System.out.println(applicationDao.queryAllApplications());
	}

}
