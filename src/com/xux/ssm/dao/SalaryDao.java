package com.xux.ssm.dao;

import com.xux.ssm.entity.Salary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/10/24.
 */
public interface SalaryDao {
    void saveSalary(Salary salary);

    Salary querySalaryByEid(Integer eid);

    Salary querySalaryByEidAndTime(@Param("year") int year, @Param("month") int month, @Param("eid") Integer eid);

    List<Salary> querySalariesByTime(@Param("i") int i, @Param("k") int k);//i年份k月份

    Salary querySalaryById(Integer id);
}
