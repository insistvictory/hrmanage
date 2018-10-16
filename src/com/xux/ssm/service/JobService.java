package com.xux.ssm.service;

import com.xux.ssm.entity.Job;

import java.util.List;

/**
 * Created by Administrator on 2018/10/13.
 */
public interface JobService {
    List<Job> findAllJobs();

    List<Job> findJobsByDeptId(Integer id);
}
