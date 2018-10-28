package com.xux.ssm.service;

import com.xux.ssm.entity.Application;
import com.xux.ssm.entity.User;

/**
 * Created by Administrator on 2018/10/12.
 */
public interface UserService {
    /**
     * 用户名、密码查询用户
     * @param name
     * @param password
     * @return
     */
    public User findUserByNameAndPassword(String name, String password);

    /**
     * 增添用户
     * @param user
     */
    void addUser(User user);

    /**
     * 通过用户名验证用户
     * @param name
     * @return
     */
    User validate(String name);

    /**
     * 查询用户通过id
     * @param uid
     * @return
     */
    User findUserByUid(Integer uid);

    /**
     * 通过用户密码验证用户
     * @param password
     * @return
     */
    User validatePassword(String password,Integer id);

    /**
     * 修改密码
     * @param id
     * @param newPassword
     */
    void updatePassword(Integer id,String newPassword);


    Application findApplyByResumeId(Integer resumeId);


    void updateType(int i, Integer uid);
}

