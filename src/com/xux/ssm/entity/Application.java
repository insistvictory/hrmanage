package com.xux.ssm.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/16.
 */
public class Application {
    private Integer id;
    private Integer recruitId;
    private Integer resumeId;
    private Date applyTime;
    private String resumeStatus;


    public Application() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecruitId() {
        return recruitId;
    }

    public void setRecruitId(Integer recruitId) {
        this.recruitId = recruitId;
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

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", recruitId=" + recruitId +
                ", resumeId=" + resumeId +
                ", applyTime=" + applyTime +
                ", resumeStatus='" + resumeStatus + '\'' +
                '}';
    }
}
