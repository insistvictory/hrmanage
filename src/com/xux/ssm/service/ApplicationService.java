package com.xux.ssm.service;



import com.xux.ssm.entity.Application;

import java.util.List;

/**
 * Created by Administrator on 2018/10/16.
 */
public interface ApplicationService {
    List<Application> findAllApplications();

    void addApplication(Application application);

    Application findApplicationById(Integer apid);

    void updateApplication(Application application);

    void deleteApplicationById(Integer id);
}
