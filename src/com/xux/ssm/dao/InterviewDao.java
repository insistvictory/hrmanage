package com.xux.ssm.dao;

import com.xux.ssm.entity.Interview;

/**
 * Created by Administrator on 2018/10/17.
 */
public interface InterviewDao {
    void addInterview(Interview interview);

    Interview queryInterviewByApplyId(Integer id);
}
