package com.xux.ssm.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/20.
 */
public class Train {
    private Integer id;//培训通知id
    private String trainContext;//培训内容
    private Date trainTime;//培训开始时间
    private String trainDept;//培训部门
    private Integer sumTime;//培训时长

    public Train(String trainContext, Date trainTime, String trainDept, Integer sumTime) {
        this.trainContext = trainContext;
        this.trainTime = trainTime;
        this.trainDept = trainDept;
        this.sumTime = sumTime;
    }

    public Train() {

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrainContext() {
        return trainContext;
    }

    public void setTrainContext(String trainContext) {
        this.trainContext = trainContext;
    }

    public Date getTrainTime() {
        return trainTime;
    }

    public void setTrainTime(Date trainTime) {
        this.trainTime = trainTime;
    }

    public String getTrainDept() {
        return trainDept;
    }

    public void setTrainDept(String trainDept) {
        this.trainDept = trainDept;
    }


    public Integer getSumTime() {
        return sumTime;
    }

    public void setSumTime(Integer sumTime) {
        this.sumTime = sumTime;
    }


    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", trainContext='" + trainContext + '\'' +
                ", trainTime=" + trainTime +
                ", trainDept='" + trainDept + '\'' +
                ", sumTime=" + sumTime +
                '}';
    }
}
