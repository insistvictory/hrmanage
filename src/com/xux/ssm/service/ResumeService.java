package com.xux.ssm.service;

import com.xux.ssm.entity.Resume;

/**
 * Created by Administrator on 2018/10/13.
 */
public interface ResumeService {

    Resume findResumeByUid(Integer id);

    void saveResume(Resume resume);

    void updateResume(Resume resume);

    Resume queryResumeByUid(Integer id);
}
