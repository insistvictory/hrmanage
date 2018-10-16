package com.xux.ssm.service;

import com.xux.ssm.entity.User;

/**
 * Created by Administrator on 2018/10/12.
 */
public interface UserService {
    public User findUserByNameAndPassword(String name, String password);

    void addUser(User user);

    User validate(String name);

    User findUserByUid(Integer uid);

    User validatePassword(String password);

    void updatePassword(Integer id,String newPassword);
}

