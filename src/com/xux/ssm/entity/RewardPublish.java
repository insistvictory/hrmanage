package com.xux.ssm.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/21.
 */
public class RewardPublish {
    private Integer id;
    private Integer eid;//员工id
    private String cause;//奖惩原因
    private Double money;
    private Date rpTime;//奖惩时间

    public RewardPublish() {
    }

    public RewardPublish(Integer eid, String cause, Double money, Date rpTime) {
        this.eid = eid;
        this.cause = cause;
        this.money = money;
        this.rpTime = rpTime;
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

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getRpTime() {
        return rpTime;
    }

    public void setRpTime(Date rpTime) {
        this.rpTime = rpTime;
    }

    @Override
    public String toString() {
        return "RewardPublish{" +
                "id=" + id +
                ", eid=" + eid +
                ", cause='" + cause + '\'' +
                ", money=" + money +
                ", rpTime=" + rpTime +
                '}';
    }
}
