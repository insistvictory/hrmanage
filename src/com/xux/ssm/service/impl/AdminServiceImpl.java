package com.xux.ssm.service.impl;

import com.xux.ssm.dao.*;
import com.xux.ssm.entity.*;
import com.xux.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/10/14.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private ResumeDao resumeDao;
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private JobDao jobDao;
    @Autowired
    private InterviewDao interviewDao;
    @Override
    public Resume searchDelivererDetailByDid(Integer did) {
        return resumeDao.queryResumeById(did);
    }

    @Override
    public Admin findAdminByNameAndPassword(String name, String password) {
        return adminDao.findAdminByNameAndPassword(name,password);
    }

    @Override
    public List<Dept> lookDepts() {
        return deptDao.queryAllDepts() ;
    }

    @Override
    public List<Job> findAllJobs() {
        return jobDao.queryAllJobs();
    }

    @Override
    public void addInterview(Interview interview) {
        interviewDao.addInterview(interview);
    }
}
