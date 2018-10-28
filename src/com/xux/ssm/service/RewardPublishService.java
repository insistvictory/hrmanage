package com.xux.ssm.service;

import com.xux.ssm.entity.RewardPublish;

import java.util.List;

/**
 * Created by Administrator on 2018/10/21.
 */
public interface RewardPublishService {
    void addRewardPublish(RewardPublish rewardPublish);

    List<RewardPublish> findRewardPublishByEid(Integer id);
}
