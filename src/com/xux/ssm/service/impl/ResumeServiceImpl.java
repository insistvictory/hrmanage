package com.xux.ssm.service.impl;

import com.xux.ssm.dao.ResumeDao;
import com.xux.ssm.entity.Resume;
import com.xux.ssm.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/10/13.
 */
@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeDao resumeDao;
    @Override
    public Resume findResumeByUid() {
        return resumeDao.queryResumeByUid();
    }
}
