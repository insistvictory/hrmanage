package com.xux.ssm.service;

import com.xux.ssm.entity.Dept;

import java.util.List;

/**
 * Created by Administrator on 2018/10/13.
 */
public interface DeptService {
    List<Dept> findAllDepts();

    Dept findDeptByName(String dName);
}
