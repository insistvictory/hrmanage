package com.xux.ssm.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/12.
 */
public class Job {
    private Integer id;
    private Integer deptId;
    private String name;
    private Date createTime;

    public Job() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", deptId=" + deptId +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
