package com.xux.ssm.dao;

import com.xux.ssm.entity.RecruitmentInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/10/16.
 */
public interface RecruitmentInfoDao {
    List<RecruitmentInfo> queryAllRecruitInfos();

    RecruitmentInfo queryRecruitInfoById(Integer id);
}
