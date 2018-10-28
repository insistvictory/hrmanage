package com.xux.ssm.service.impl;

import com.xux.ssm.dao.RewardPublishDao;
import com.xux.ssm.entity.RewardPublish;
import com.xux.ssm.service.RewardPublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/10/21.
 */
@Service
public class RewardPublishServiceImpl implements RewardPublishService {
    @Autowired
    private RewardPublishDao rewardPublishDao;

    @Override
    public void addRewardPublish(RewardPublish rewardPublish) {
        rewardPublishDao.addRewardPublish(rewardPublish);
    }

    @Override
    public List<RewardPublish> findRewardPublishByEid(Integer id) {
        return rewardPublishDao.queryRewardPublishByEid(id);
    }
}
