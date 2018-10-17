package com.xux.ssm.dao;

import com.xux.ssm.entity.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/10/14.
 */
public interface AdminDao {

    Admin findAdminByNameAndPassword(@Param("name")String name, @Param("password")String password);
}
