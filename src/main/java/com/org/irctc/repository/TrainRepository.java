package com.org.irctc.repository;

import com.java.generated.jooq.tables.pojos.Train;

import java.util.List;

public interface TrainRepository {
    List<Train> getAllTrains();
    void addTrain(Train train);
    Train getTrainByTrainNo(String trainNumber);
    Train getTrainByTrainId(String trainId);
    void updateTrain(Train train);
    public List<Train> getTrainsBetweenStations(String fromStation, String toStation);
}
