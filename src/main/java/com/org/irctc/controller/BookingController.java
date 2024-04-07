package com.org.irctc.controller;

import com.org.irctc.dto.BookingRequestDto;
import com.org.irctc.helper.ResponseObject;
import com.org.irctc.helper.ResponseUtil;
import com.org.irctc.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping()
    public ResponseEntity<ResponseObject> addBooking(@RequestBody BookingRequestDto bookingRequestDto){
        ResponseObject responseObject = ResponseUtil.buildResponse(bookingService.addBooking(bookingRequestDto));
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<ResponseObject> getBookingById(@PathVariable String bookingId){
        ResponseObject responseObject = ResponseUtil.buildResponse(bookingService.getBookingById(bookingId));
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<ResponseObject> getBookingByUserId(@PathVariable String userId){
        ResponseObject responseObject = ResponseUtil.buildResponse(bookingService.getBookingsByUserId(userId));
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
}
