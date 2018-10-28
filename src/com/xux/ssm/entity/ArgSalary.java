package com.xux.ssm.entity;

/**
 * Created by Administrator on 2018/10/24.
 */
public class ArgSalary {
    private Integer id;
    private Integer eid;
    private int year;
    private int month;
    private Double asalry;//ÒìÒé½ð¶î
    private String agreeStatus;//ÔÊ×¼×´Ì¬

    public ArgSalary() {
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

    public Double getAsalry() {
        return asalry;
    }

    public void setAsalry(Double asalry) {
        this.asalry = asalry;
    }

    public String getAgreeStatus() {
        return agreeStatus;
    }

    public void setAgreeStatus(String agreeStatus) {
        this.agreeStatus = agreeStatus;
    }

    @Override
    public String toString() {
        return "ArgSalary{" +
                "id=" + id +
                ", eid=" + eid +
                ", year=" + year +
                ", month=" + month +
                ", asalry=" + asalry +
                ", agreeStatus='" + agreeStatus + '\'' +
                '}';
    }
}
