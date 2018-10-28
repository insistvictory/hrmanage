package com.xux.ssm.service;

import com.xux.ssm.entity.Application;
import com.xux.ssm.entity.User;

/**
 * Created by Administrator on 2018/10/12.
 */
public interface UserService {
    /**
     * �û����������ѯ�û�
     * @param name
     * @param password
     * @return
     */
    public User findUserByNameAndPassword(String name, String password);

    /**
     * �����û�
     * @param user
     */
    void addUser(User user);

    /**
     * ͨ���û�����֤�û�
     * @param name
     * @return
     */
    User validate(String name);

    /**
     * ��ѯ�û�ͨ��id
     * @param uid
     * @return
     */
    User findUserByUid(Integer uid);

    /**
     * ͨ���û�������֤�û�
     * @param password
     * @return
     */
    User validatePassword(String password,Integer id);

    /**
     * �޸�����
     * @param id
     * @param newPassword
     */
    void updatePassword(Integer id,String newPassword);


    Application findApplyByResumeId(Integer resumeId);


    void updateType(int i, Integer uid);
}

