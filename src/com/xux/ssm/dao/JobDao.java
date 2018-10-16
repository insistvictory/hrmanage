package com.xux.ssm.dao;

import com.xux.ssm.entity.Job;

import java.util.List;

/**
 * Created by Administrator on 2018/10/13.
 */
public interface JobDao {
    List<Job> queryAllJobs();
    void addJob(Job job);
    void deleteJobById(Integer id);
    void updateJob(Job job);
    List<Job> queryJobsByDeptId(Integer id);
}
