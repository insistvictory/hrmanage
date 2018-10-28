package com.xux.ssm.dao;

import com.xux.ssm.entity.Train;

import java.util.List;

/**
 * Created by Administrator on 2018/10/20.
 */
public interface TrainDao {

    List<Train> queryAllTrains();

    Train queryTrainById(Integer id);

    void addTrain(Train train);

    void updateTrain(Train train);

    void deleteTrainById(Integer id);

    List<Train> queryTrainsByDeptName(String dept);
}
