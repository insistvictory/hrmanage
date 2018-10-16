package com.xux.ssm.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/16.
 */
public class RecruitmentInfo {
    private Integer rid;
    private String company;
    private Job job;
    private String address;
    private String salary;
    private String duty;
    private String requirements;
    private Date pubdate;

    public RecruitmentInfo() {
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    @Override
    public String toString() {
        return "RecruitmentInfo{" +
                "rid=" + rid +
                ", company='" + company + '\'' +
                ", job=" + job +
                ", address='" + address + '\'' +
                ", salary='" + salary + '\'' +
                ", duty='" + duty + '\'' +
                ", requirements='" + requirements + '\'' +
                ", pubdate=" + pubdate +
                '}';
    }
}
