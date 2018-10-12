package com.xux.ssm.entity;

/**
 * Created by Administrator on 2018/10/12.
 */
public class Salary {
    private Integer id;
    private String money;

    public Salary() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", money='" + money + '\'' +
                '}';
    }
}
