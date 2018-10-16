package com.xux.ssm.dao;

import com.xux.ssm.entity.Resume;

/**
 * Created by Administrator on 2018/10/13.
 */
public interface ResumeDao {
    Resume queryResumeByUid(Integer id);

    Resume queryResumeById(Integer did);

    void addResume(Resume resume);

    void updateResume(Resume resume);
}
