package com.xux.ssm.service;

import com.xux.ssm.entity.Resume;

/**
 * Created by Administrator on 2018/10/14.
 */
public interface AdminService {
    Resume searchDelivererDetailByDid(Integer did);
}
