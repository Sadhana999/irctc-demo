package com.org.irctc.service.impl;

import com.org.irctc.constants.StatusConstants;
import com.org.irctc.dto.TrainRequestDto;
import com.org.irctc.repository.TrainRepository;
import com.org.irctc.service.TrainsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.generated.jooq.tables.pojos.Train;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TrainsServiceImpl implements TrainsService {

    @Autowired
    TrainRepository trainRepository;

    @Override
    public String addTrain(TrainRequestDto trainRequestDto){
        Train newTrain = new Train();
        String trainId=UUID.randomUUID().toString();
        newTrain.setTrainId(trainId);
        newTrain.setTrainNumber(trainRequestDto.getTrainNumber());
        newTrain.setTrainName(trainRequestDto.getTrainName());
        newTrain.setSource(trainRequestDto.getSource());
        newTrain.setDestination(trainRequestDto.getDestination());
        newTrain.setCreatedBy("ADMIN");
        newTrain.setCreatedDate(LocalDateTime.now());
        newTrain.setStatus(StatusConstants.ACTIVE);

        trainRepository.addTrain(newTrain);
        return trainId;
    }

    @Override
    public String deleteTrainById(String trainId){
        Train train = trainRepository.getTrainByTrainId(trainId);
        train.setModifiedBy("ADMIN");
        train.setModifiedDate(LocalDateTime.now());
        train.setStatus(StatusConstants.DELETED);
        trainRepository.updateTrain(train);
        return train.getTrainId();
    }

    @Override
    public String updateTrain(TrainRequestDto trainRequestDto){
        Train train = trainRepository.getTrainByTrainId(trainRequestDto.getTrainId());
        train.setTrainNumber(trainRequestDto.getTrainNumber());
        train.setTrainName(trainRequestDto.getTrainName());
        train.setSource(trainRequestDto.getSource());
        train.setDestination(trainRequestDto.getDestination());

        trainRepository.updateTrain(train);
        return train.getTrainId();
    }

    @Override
    public Train getTrainById(String trainNumber){
        return trainRepository.getTrainByTrainNo(trainNumber);
    }

    @Override
    public List<Train> getAllTrains(){
        return trainRepository.getAllTrains();
    }

    @Override
    public List<Train> getTrainsBetweenStations(String fromStation, String toStation){
        return trainRepository.getTrainsBetweenStations(fromStation,toStation);
    }
}
