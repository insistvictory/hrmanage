package com.xux.ssm.dao;

import com.xux.ssm.entity.Argument;

import java.util.List;

/**
 * Created by Administrator on 2018/10/25.
 */
public interface ArgumentDao {

    void addArgument(Argument argument);

    List<Argument> queryAllArgument();
}
