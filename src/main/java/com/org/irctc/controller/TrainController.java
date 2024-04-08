package com.org.irctc.controller;

import com.org.irctc.dto.TrainRequestDto;
import com.org.irctc.helper.ResponseObject;
import com.org.irctc.helper.ResponseUtil;
import com.org.irctc.service.TrainsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/train")
public class TrainController {

    @Autowired
    TrainsService trainsService;

    @GetMapping()
    public ResponseEntity<ResponseObject> getTrainsBetweenStations(@RequestParam("source") String source,
                                                                   @RequestParam("destination") String destination){
        ResponseObject responseObject = ResponseUtil.buildResponse(
                trainsService.getTrainsBetweenStations(source, destination));
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ResponseObject> addTrain(@RequestBody TrainRequestDto trainRequestDto){
        ResponseObject responseObject = ResponseUtil.buildResponse(trainsService.addTrain(trainRequestDto));
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    @PutMapping("/{trainId}")
    public ResponseEntity<ResponseObject> updateTrain(@RequestBody TrainRequestDto trainRequestDto){
        ResponseObject responseObject = ResponseUtil.buildResponse(trainsService.updateTrain(trainRequestDto));
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    @DeleteMapping("/{trainId}")
    public ResponseEntity<ResponseObject> deleteTrain(@PathVariable String trainId){
        ResponseObject responseObject = ResponseUtil.buildResponse(trainsService.deleteTrainById(trainId));
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

}
