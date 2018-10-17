package com.xux.ssm.service;

import com.xux.ssm.entity.*;

import java.util.List;

/**
 * Created by Administrator on 2018/10/14.
 */
public interface AdminService {
    Resume searchDelivererDetailByDid(Integer did);

    Admin findAdminByNameAndPassword(String name, String password);

    List<Dept> lookDepts();

    List<Job> findAllJobs();

    void addInterview(Interview interview);
}
