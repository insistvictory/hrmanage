package com.xux.ssm.dao;

import com.xux.ssm.entity.RewardPublish;

import java.util.List;

/**
 * Created by Administrator on 2018/10/21.
 */
public interface RewardPublishDao {
    void addRewardPublish(RewardPublish rewardPublish);
    List<RewardPublish> queryRewardPublishByEid(Integer id);

    List<RewardPublish> queryRewardPublishes();
}
