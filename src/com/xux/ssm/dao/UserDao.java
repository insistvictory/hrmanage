package com.xux.ssm.dao;

import com.xux.ssm.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/10/12.
 */
public interface UserDao {
    /**
     * ͨ���û��������ѯ�û�
     * @param name
     * @param password
     * @return
     */
    public User queryUserByNameAndPassword(@Param("name")String name, @Param("password")String password);

    /**
     * ����û�
     * @param user
     */
    public void insertUser(User user);

    /**
     * ͨ���û�����ѯ�û�
     * @param name
     * @return
     */
    User queryByName(String name);

    /**
     * ͨ��id��ѯ�û�
     * @param uid
     * @return
     */
    User queryUserByUid(Integer uid);

    /**
     * ͨ�������ѯ�û�
     * @param password
     * @return
     */
    User queryUserByPassword(@Param("password") String password,@Param("id") Integer id);

    /**
     * �޸�����
     * @param id
     * @param newPassword
     */
    void updatePassword(@Param("id")Integer id, @Param("newPassword")String newPassword);


    void updateType(@Param("i") int i, @Param("uid") Integer uid);
}
