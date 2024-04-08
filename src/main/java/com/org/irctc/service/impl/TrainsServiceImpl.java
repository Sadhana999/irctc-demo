package com.org.irctc.service.impl;

import com.org.irctc.constants.RoleConstants;
import com.org.irctc.constants.StatusConstants;
import com.org.irctc.dto.TrainRequestDto;
import com.org.irctc.exception.UnauthorizedException;
import com.org.irctc.repository.TrainRepository;
import com.org.irctc.repository.UserRepository;
import com.org.irctc.service.TrainsService;
import com.org.irctc.tables.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import com.org.irctc.tables.pojos.Train;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TrainsServiceImpl implements TrainsService {

    @Autowired
    TrainRepository trainRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public String addTrain(TrainRequestDto trainRequestDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
        String userName = jwtAuthenticationToken.getToken().getSubject();
        Optional<User> user = userRepository.getUserByUserName(userName);
        if(user.get().getRole().equals(RoleConstants.USER)){
            throw new UnauthorizedException("Unauthorized User. You don't have access for this.");
        }
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
        String userName = jwtAuthenticationToken.getToken().getSubject();
        Optional<User> user = userRepository.getUserByUserName(userName);
        if(user.get().getRole().equals(RoleConstants.USER)){
            throw new UnauthorizedException("Unauthorized User. You don't have access for this.");
        }
        Train train = trainRepository.getTrainByTrainId(trainId);
        train.setModifiedBy("ADMIN");
        train.setModifiedDate(LocalDateTime.now());
        train.setStatus(StatusConstants.DELETED);
        trainRepository.updateTrain(train);
        return train.getTrainId();
    }

    @Override
    public String updateTrain(TrainRequestDto trainRequestDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
        String userName = jwtAuthenticationToken.getToken().getSubject();
        Optional<User> user = userRepository.getUserByUserName(userName);
        if(user.get().getRole().equals(RoleConstants.USER)){
            throw new UnauthorizedException("Unauthorized User. You don't have access for this.");
        }
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
