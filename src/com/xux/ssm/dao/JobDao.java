package com.xux.ssm.dao;

import com.xux.ssm.entity.Job;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/10/13.
 */
public interface JobDao {
    List<Job> queryAllJobs();
    void addJob(Job job);
    void deleteJobById(Integer id);
    void updateJob(Job job);
    List<Job> queryJobsByDeptId(Integer id);
    Job queryJobByName(String name);
    Job queryJobById(Integer id);
    void updateJobByIdAndName(@Param("id") Integer id, @Param("name") String name);//����id��ְλ�����޸�
    void deleteJobByName(String name);
}
