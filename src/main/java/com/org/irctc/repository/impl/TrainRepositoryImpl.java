package com.org.irctc.repository.impl;

import com.org.irctc.Tables;
import com.org.irctc.tables.daos.SeatDao;
import com.org.irctc.constants.StatusConstants;
import com.org.irctc.repository.TrainRepository;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.org.irctc.tables.daos.TrainDao;
import com.org.irctc.tables.pojos.Train;

import java.util.List;

@Repository
public class TrainRepositoryImpl implements TrainRepository {

    private final DSLContext dslContext;
    private final TrainDao trainDao;
    public TrainRepositoryImpl(DSLContext dslContext, TrainDao trainDao) {
        this.dslContext = dslContext;
        this.trainDao = trainDao;
    }

    @Override
    public List<Train> getAllTrains(){
        return trainDao.findAll();
    }

    @Override
    public void addTrain(Train train){
        trainDao.insert(train);
    }

    @Override
    public Train getTrainByTrainNo(String trainNumber){
        return trainDao.fetchOneByTrainNumber(trainNumber);
    }

    @Override
    public Train getTrainByTrainId(String trainId){
        return trainDao.fetchOneByTrainId(trainId);
    }

    @Override
    public void updateTrain(Train train){
        trainDao.update(train);
    }

    @Override
    public List<Train> getTrainsBetweenStations(String fromStation, String toStation){
        return dslContext.select().from(Tables.TRAIN)
                .where(Tables.TRAIN.SOURCE.eq(fromStation)
                        .and(Tables.TRAIN.DESTINATION.eq(toStation))
                        .and(Tables.TRAIN.STATUS.eq(StatusConstants.ACTIVE)))
                .fetchInto(Train.class);
    }

}
