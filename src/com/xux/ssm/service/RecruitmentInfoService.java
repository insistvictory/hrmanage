package com.xux.ssm.service;

import com.xux.ssm.entity.RecruitmentInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/10/16.
 */
public interface RecruitmentInfoService {
    List<RecruitmentInfo> findAllRecruitInfos();

    RecruitmentInfo findRecruitInfoById(Integer id);
}

