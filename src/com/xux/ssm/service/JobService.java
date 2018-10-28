package com.xux.ssm.service;

import com.xux.ssm.entity.Job;

import java.util.List;

/**
 * Created by Administrator on 2018/10/13.
 */
public interface JobService {
    List<Job> findAllJobs();

    List<Job> findJobsByDeptId(Integer id);

    Job findJobByName(String name);

    void addJob(Job job);

    void updateJob(Job job);

    Job findJobById(Integer id);

    void updateJobByIdAndName(Integer id, String name);
}
