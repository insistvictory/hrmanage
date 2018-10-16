package com.xux.ssm.dao;

import com.xux.ssm.entity.Dept;

import java.util.List;

/**
 * Created by Administrator on 2018/10/13.
 */
public interface DeptDao {
    List<Dept> queryAllDepts();
    void addDept(Dept dept);
    void deleteDeptById(Integer id);
    void updateDept(Dept dept);

    Dept queryDeptByName(String dName);
}
