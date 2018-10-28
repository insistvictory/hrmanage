package com.xux.ssm.service;

import com.xux.ssm.entity.Interview;



/**
 * Created by Administrator on 2018/10/17.
 */
public interface InterviewService {

  Interview findInterviewByApplyId(Integer id);

  void modifyInterviewReadStatus(String readStatus, Integer id);


    Interview findInterviewById(Integer iid);

  void modifyInterview(Interview interview);
}
