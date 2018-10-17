package com.xux.ssm.dao;



import com.xux.ssm.entity.Application;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/10/16.
 */
public interface ApplicationDao {
    List<Application> queryAllApplications();

    void addApplication(Application application);

    Application queryApplicationByResumeId(Integer id);

    Application queryApplicationById(Integer apid);

    void updateApplication(Application application);

    void deleteApplicationById(Integer id);
}

