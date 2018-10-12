package com.xux.ssm.test;




import com.xux.ssm.dao.UserDao;
import com.xux.ssm.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//����ʱ����SpringIOC����
@RunWith(SpringJUnit4ClassRunner.class)
//����Spring�������ļ�
@ContextConfiguration({"classpath:spring.xml"})
public class TestDao {
  	@Autowired
  	private UserDao userDao;
	@Test
	public void testUserDao(){
		System.out.println(userDao.queryUserByNameAndPassword("aaa","aaa"));
	}
	@Test
	public void testInsertUser(){
		User user=new User();
		user.setName("bbb");
		user.setPassword("bbb");
		userDao.insertUser(user);

	}

}
