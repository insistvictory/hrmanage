package com.xux.ssm.service;

import com.xux.ssm.entity.User;

/**
 * Created by Administrator on 2018/10/12.
 */
public interface UserService {
    Boolean findUserByNameAndPassword(String name, String password);

    void addUser(User user);
}
