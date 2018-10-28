package com.xux.ssm.entity;

/**
 * Created by Administrator on 2018/10/13.
 */
public class Salary {
    private Integer id;
    private Integer eid;
    private Integer year;
    private Integer month;
    private Double baseSalary;//基本工资就是打卡数*100
    private Double rewardSalary;//奖惩金额(迟到、加班、早退、绩效都算在里面)
    private Double society;//社保固定-200,（这里没有设定固定的薪水标准）
    private Double sumSalary;//实发工资
    private Double argSalary;//异议工资

    public Salary() {
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Double getRewardSalary() {
        return rewardSalary;
    }

    public void setRewardSalary(Double rewardSalary) {
        this.rewardSalary = rewardSalary;
    }

    public Double getSociety() {
        return society;
    }

    public void setSociety(Double society) {
        this.society = society;
    }

    public Double getSumSalary() {
        return sumSalary;
    }

    public void setSumSalary(Double sumSalary) {
        this.sumSalary = sumSalary;
    }

    public Double getArgSalary() {
        return argSalary;
    }

    public void setArgSalary(Double argSalary) {
        this.argSalary = argSalary;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", eid=" + eid +
                ", year=" + year +
                ", month=" + month +
                ", baseSalary=" + baseSalary +
                ", rewardSalary=" + rewardSalary +
                ", society=" + society +
                ", sumSalary=" + sumSalary +
                ", argSalary=" + argSalary +
                '}';
    }
}
