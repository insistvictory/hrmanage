package com.xux.ssm.dao;

import com.xux.ssm.entity.Check;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/10/22.
 */
public interface CheckDao {
    void addCheck(Check check);

    Check queryCheckByTimeAndUid(@Param("year") int year,@Param("month") int month,@Param("date") int date,@Param("eid") Integer eid);

    void updateCheck(Check check);

    List<Check> queryChecksByYearAndMonthAndEid(@Param("i") int i,@Param("k") int k, @Param("eid") Integer eid);
}
