package com.org.irctc.service;

import com.org.irctc.dto.TrainRequestDto;
import com.org.irctc.tables.pojos.Train;

import java.util.List;

public interface TrainsService {
    public String addTrain(TrainRequestDto train);

    public String deleteTrainById(String trainNumber);

    public String updateTrain(TrainRequestDto train);

    public Train getTrainById(String trainNumber);

    public List<Train> getAllTrains();

    public List<Train> getTrainsBetweenStations(String fromStation, String toStation);
}
