package com.xux.ssm.service.impl;

import com.xux.ssm.dao.ApplicationDao;
import com.xux.ssm.dao.InterviewDao;
import com.xux.ssm.dao.ResumeDao;
import com.xux.ssm.entity.Application;
import com.xux.ssm.entity.Interview;
import com.xux.ssm.entity.Resume;
import com.xux.ssm.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/10/17.
 */
@Service
public class InterviewServiceImpl implements InterviewService{
    @Autowired
    private ApplicationDao applicationDao;
    @Autowired
    private InterviewDao interviewDao;
    @Autowired
    private ResumeDao resumeDao;
    @Override
    public Interview findInterviewByApplyId(Integer id) {
        return interviewDao.queryInterviewByApplyId(id);
    }

    @Override
    public void modifyInterviewReadStatus(String readStatus, Integer id) {
        interviewDao.modifyInterviewReadStatus(readStatus,id);
    }

    @Override
    public Interview findInterviewById(Integer iid) {
        return interviewDao.queryInterviewById(iid);
    }

    @Override
    public void modifyInterview(Interview interview) {
        interviewDao.updateInterview(interview);
    }

}
