package com.xux.ssm.dao;

import com.xux.ssm.entity.Interview;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/10/17.
 */
public interface InterviewDao {
    void addInterview(Interview interview);

    Interview queryInterviewByApplyId(Integer id);

    void modifyInterviewReadStatus(@Param("readStatus") String readStatus, @Param("id") Integer id);

    List<Interview> queryAllInterviewsByReadStatus(String string);

    Interview queryInterviewById(Integer iid);

    void updateInterview(Interview interview);
}
