package com.xux.ssm.service.impl;

import com.xux.ssm.dao.JobDao;
import com.xux.ssm.entity.Job;
import com.xux.ssm.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/10/13.
 */
@Service
public class JobServiceImpl implements JobService {
@Autowired
private JobDao jobDao;
    @Override
    public List<Job> findAllJobs() {
        return jobDao.queryAllJobs();
    }

    @Override
    public List<Job> findJobsByDeptId(Integer id) {
        return jobDao.queryJobsByDeptId(id);
    }
}
