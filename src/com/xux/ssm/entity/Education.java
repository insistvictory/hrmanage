package com.xux.ssm.entity;

/**
 * Created by Administrator on 2018/10/12.
 */
public class Education {
    private Integer id;
    private String qualification;

    public Education() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", qualification='" + qualification + '\'' +
                '}';
    }
}
