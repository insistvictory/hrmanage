package com.xux.ssm.entity;

/**
 * Created by Administrator on 2018/10/12.
 */
public class Resume {
    private Integer id;
    private Integer uid;
    private String name;
    private String gender;//性别
    private int age;
    private String  education;//学历
    private String tel;
    private String email;
    private String dept;
    private String job;
    private String politicalStatus;//政治面貌
    private String lastJob;
    private String experience;
    private String salaryHope;//期望薪资
    private String hobby;

    public Resume() {
    }

    public Resume(Integer uid, String name, String gender, int age, String education, String tel, String email, String dept, String job, String politicalStatus, String lastJob, String experience, String salaryHope, String hobby) {
        this.uid = uid;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.education = education;
        this.tel = tel;
        this.email = email;
        this.dept = dept;
        this.job = job;
        this.politicalStatus = politicalStatus;
        this.lastJob = lastJob;
        this.experience = experience;
        this.salaryHope = salaryHope;
        this.hobby = hobby;
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

    public String getSalaryHope() {
        return salaryHope;
    }

    public void setSalaryHope(String salaryHope) {
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
                ", education='" + education + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", dept='" + dept + '\'' +
                ", job='" + job + '\'' +
                ", politicalStatus='" + politicalStatus + '\'' +
                ", lastJob='" + lastJob + '\'' +
                ", experience='" + experience + '\'' +
                ", salaryHope='" + salaryHope + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
