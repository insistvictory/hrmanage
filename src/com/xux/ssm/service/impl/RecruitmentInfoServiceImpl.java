package com.xux.ssm.service.impl;

import com.xux.ssm.dao.RecruitmentInfoDao;
import com.xux.ssm.entity.RecruitmentInfo;
import com.xux.ssm.service.RecruitmentInfoService;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/10/16.
 */
@Service
public class RecruitmentInfoServiceImpl implements RecruitmentInfoService{
    @Autowired
    private RecruitmentInfoDao recruitmentInfoDao;
    @Override
    public List<RecruitmentInfo> findAllRecruitInfos() {
        return recruitmentInfoDao.queryAllRecruitInfos();
    }

    @Override
    public RecruitmentInfo findRecruitInfoById(Integer id) {
        return recruitmentInfoDao.queryRecruitInfoById(id);
    }
}
