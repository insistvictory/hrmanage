package com.xux.ssm.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/17.
 */
public class Interview {
    private Integer id;
    private Integer applyId;
    private String readStatus;
    private Date interviewTime;
    private String hire;

    public Interview() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(String readStatus) {
        this.readStatus = readStatus;
    }

    public Date getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(Date interviewTime) {
        this.interviewTime = interviewTime;
    }


    public String getHire() {
        return hire;
    }

    public void setHire(String hire) {
        this.hire = hire;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", applyId=" + applyId +
                ", readStatus='" + readStatus + '\'' +
                ", interviewTime=" + interviewTime +
                ", hire='" + hire + '\'' +
                '}';
    }
}
