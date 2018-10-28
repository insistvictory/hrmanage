package com.xux.ssm.dao;

import com.xux.ssm.entity.ArgSalary;
import org.apache.ibatis.annotations.Param;


/**
 * Created by Administrator on 2018/10/24.
 */
public interface ArgSalaryDao {


    ArgSalary queryArgSalaryByEidAndTimeAndAgreeStatus(@Param("eid") Integer eid, @Param("year") int year, @Param("i") int i, @Param("str") String str);

    void addArgSalary(ArgSalary argSalary);


}
