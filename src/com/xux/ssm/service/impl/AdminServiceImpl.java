package com.xux.ssm.service.impl;

import com.xux.ssm.dao.ResumeDao;
import com.xux.ssm.entity.Resume;
import com.xux.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/10/14.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private ResumeDao resumeDao;
    @Override
    public Resume searchDelivererDetailByDid(Integer did) {
        return resumeDao.queryResumeById(did);
    }
}
