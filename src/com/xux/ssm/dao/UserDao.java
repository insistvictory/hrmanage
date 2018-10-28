package com.xux.ssm.dao;

import com.xux.ssm.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/10/12.
 */
public interface UserDao {
    /**
     * 通过用户名密码查询用户
     * @param name
     * @param password
     * @return
     */
    public User queryUserByNameAndPassword(@Param("name")String name, @Param("password")String password);

    /**
     * 添加用户
     * @param user
     */
    public void insertUser(User user);

    /**
     * 通过用户名查询用户
     * @param name
     * @return
     */
    User queryByName(String name);

    /**
     * 通过id查询用户
     * @param uid
     * @return
     */
    User queryUserByUid(Integer uid);

    /**
     * 通过密码查询用户
     * @param password
     * @return
     */
    User queryUserByPassword(@Param("password") String password,@Param("id") Integer id);

    /**
     * 修改密码
     * @param id
     * @param newPassword
     */
    void updatePassword(@Param("id")Integer id, @Param("newPassword")String newPassword);


    void updateType(@Param("i") int i, @Param("uid") Integer uid);
}
