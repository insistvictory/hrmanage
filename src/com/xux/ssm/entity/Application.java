package com.xux.ssm.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/16.
 */
public class Application {
    private Integer id;
    private Integer resumeId;
    private Date applyTime;
    private String resumeStatus;
    private String InterviewStatus;


    public Application() {
    }

    public Application(Integer resumeId, Date applyTime, String resumeStatus) {
        this.resumeId = resumeId;
        this.applyTime = applyTime;
        this.resumeStatus = resumeStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getResumeStatus() {
        return resumeStatus;
    }

    public void setResumeStatus(String resumeStatus) {
        this.resumeStatus = resumeStatus;
    }

    public String getInterviewStatus() {
        return InterviewStatus;
    }

    public void setInterviewStatus(String interviewStatus) {
        InterviewStatus = interviewStatus;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", resumeId=" + resumeId +
                ", applyTime=" + applyTime +
                ", resumeStatus='" + resumeStatus + '\'' +
                ", InterviewStatus='" + InterviewStatus + '\'' +
                '}';
    }
}
