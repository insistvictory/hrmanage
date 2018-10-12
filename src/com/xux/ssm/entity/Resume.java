package com.xux.ssm.entity;

/**
 * Created by Administrator on 2018/10/12.
 */
public class Resume {
    private Integer id;
    private Integer uid;
    private String name;
    private String gender;
    private int age;
    private Education education;
    private String tel;
    private String email;
    private Job job;
    private String politicalStatus;
    private String lastJob;
    private String experience;
    private Salary salaryHope;
    private String hobby;

    public Resume() {
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

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
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

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getLastJob() {
        return lastJob;
    }

    public void setLastJob(String lastJob) {
        this.lastJob = lastJob;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Salary getSalaryHope() {
        return salaryHope;
    }

    public void setSalaryHope(Salary salaryHope) {
        this.salaryHope = salaryHope;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", education=" + education +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", job=" + job +
                ", politicalStatus='" + politicalStatus + '\'' +
                ", lastJob='" + lastJob + '\'' +
                ", experience='" + experience + '\'' +
                ", salaryHope=" + salaryHope +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
