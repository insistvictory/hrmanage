package com.xux.ssm.entity;

/**
 * Created by Administrator on 2018/10/24.
 */
public class Argument {
    private Integer id;
    private Integer salaryId;
    private String reason;//异议理由
    private Double argSalary;//出入金额

    public Argument() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Double getArgSalary() {
        return argSalary;
    }

    public void setArgSalary(Double argSalary) {
        this.argSalary = argSalary;
    }

    @Override
    public String toString() {
        return "Argument{" +
                "id=" + id +
                ", salaryId=" + salaryId +
                ", reason='" + reason + '\'' +
                ", argSalary=" + argSalary +
                '}';
    }
}
