package com.xux.ssm.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/18.
 */
public class Check {
    private Integer id;
    private Integer eid;
    private int year;
    private int month;
    private int day;
    private String beginTime;//上班打卡时间
    private String  endTime;//下班打卡时间
    private String workStatus;//考勤结果

    public Check() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", eid=" + eid +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", workStatus='" + workStatus + '\'' +
                '}';
    }
}
