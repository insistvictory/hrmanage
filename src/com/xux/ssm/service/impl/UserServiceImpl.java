package com.xux.ssm.service.impl;

import com.xux.ssm.dao.UserDao;
import com.xux.ssm.entity.User;
import com.xux.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/10/12.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public User findUserByNameAndPassword(String name, String password) {
        return userDao.queryUserByNameAndPassword(name,password);
    }

    @Override
    public void addUser(User user) {
        userDao.insertUser(user);
    }
}
