package com.xux.ssm.service.impl;

import com.xux.ssm.dao.ApplicationDao;
import com.xux.ssm.service.ApplicationService;
import javafx.application.Application;
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
}
