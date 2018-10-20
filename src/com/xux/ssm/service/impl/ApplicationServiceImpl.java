package com.xux.ssm.service.impl;

import com.xux.ssm.dao.ApplicationDao;
import com.xux.ssm.entity.Application;
import com.xux.ssm.service.ApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/10/16.
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationDao applicationDao;
    @Override
    public List<Application> findAllApplications() {
        return applicationDao.queryAllApplications();
    }

    @Override
    public void addApplication(Application application) {
        applicationDao.addApplication(application);
    }

    @Override
    public Application findApplicationById(Integer apid) {
        return applicationDao.queryApplicationById(apid);
    }

    @Override
    public void updateApplication(Application application) {
        applicationDao.updateApplication(application);
    }

    @Override
    public void deleteApplicationById(Integer id) {
        applicationDao.deleteApplicationById(id);
    }

    @Override
    public Application queryApplicationByResumeId(Integer id) {
        return applicationDao.queryApplicationByResumeId(id);
    }
}
