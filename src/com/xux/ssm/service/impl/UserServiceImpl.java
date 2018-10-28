package com.xux.ssm.service.impl;

import com.xux.ssm.dao.ApplicationDao;
import com.xux.ssm.dao.UserDao;
import com.xux.ssm.entity.Application;
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
    @Autowired
    private ApplicationDao applicationDao;
    @Override
    public User findUserByNameAndPassword(String name, String password) {
        return userDao.queryUserByNameAndPassword(name,password);
    }

    @Override
    public void addUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public User validate(String name) {
        return userDao.queryByName(name);
    }

    @Override
    public User findUserByUid(Integer uid) {
        return userDao.queryUserByUid(uid);
    }

    @Override
    public User validatePassword(String password,Integer id) {
        return userDao.queryUserByPassword(password,id);
    }

    @Override
    public void updatePassword(Integer id, String newPassword) {
        userDao.updatePassword(id,newPassword);
    }

    @Override
    public Application findApplyByResumeId(Integer resumeId) {
        return applicationDao.queryApplicationByResumeId(resumeId);
    }

    @Override
    public void updateType(int i, Integer uid) {
        userDao.updateType(i,uid);
    }


}
