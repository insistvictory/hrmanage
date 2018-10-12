package com.xux.ssm.dao;

import com.xux.ssm.entity.User;
import com.xux.ssm.entity.User2;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/10/12.
 */
public interface UserDao {

    public Boolean queryUserByNameAndPassword(@Param("name")String name, @Param("password")String password);
    //public User2 queryUserByNameAndPassword(@Param("name")String name, @Param("password")String password);
    public void insertUser(User user);
}
