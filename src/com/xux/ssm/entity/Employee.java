package com.xux.ssm.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/14.
 */
public class Employee {
    private Integer id;
    private Integer uid;
    private String name;
    private String gender;
    private int age;
    private String  education;
    private String tel;
    private String email;
    private String dept;
    private String job;
    private String politicalStatus;
    private Date entryTime;
    private String hobby;
    private String nowStatus;
    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getNowStatus() {
        return nowStatus;
    }

    public void setNowStatus(String nowStatus) {
        this.nowStatus = nowStatus;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", education='" + education + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", dept='" + dept + '\'' +
                ", job='" + job + '\'' +
                ", politicalStatus='" + politicalStatus + '\'' +
                ", entryTime=" + entryTime +
                ", hobby='" + hobby + '\'' +
                ", nowStatus='" + nowStatus + '\'' +
                '}';
    }
}
