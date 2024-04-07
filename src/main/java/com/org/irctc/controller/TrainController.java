package com.org.irctc.controller;

import com.java.generated.jooq.tables.pojos.Train;
import com.org.irctc.helper.ResponseObject;
import com.org.irctc.helper.ResponseUtil;
import com.org.irctc.service.TrainsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/train")
public class TrainController {

    @Autowired
    TrainsService trainsService;

    @GetMapping()
    public ResponseEntity<ResponseObject> getTrainsBetweenStations(String source, String destination){
        ResponseObject responseObject = ResponseUtil.buildResponse(
                trainsService.getTrainsBetweenStations(source, destination));
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
}
