package com.org.irctc.service.impl;

import com.org.irctc.exception.InvalidEntityException;
import com.org.irctc.tables.pojos.Booking;
import com.org.irctc.constants.StatusConstants;
import com.org.irctc.dto.BookingRequestDto;
import com.org.irctc.repository.BookingRepository;
import com.org.irctc.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    @Transactional
    public String addBooking(BookingRequestDto bookingRequestDto){

        if(!bookingRepository.isSeatAvailableInTrain(bookingRequestDto.getTrainId(),
                bookingRequestDto.getSeatId())){
            throw new InvalidEntityException("Seat is already booked");
        }
        Booking newBooking = new Booking();
        String bookingId = UUID.randomUUID().toString();
        newBooking.setBookingId(bookingId);
        newBooking.setTrainId(bookingRequestDto.getTrainId());
        newBooking.setSeatId(bookingRequestDto.getSeatId());
        newBooking.setUserId(bookingRequestDto.getUserId());
        newBooking.setCreatedBy("USER");
        newBooking.setCreatedDate(LocalDateTime.now());
        newBooking.setStatus(StatusConstants.ACTIVE);

        bookingRepository.addBooking(newBooking);
        return bookingId;
    }

    @Override
    public Booking getBookingById(String bookingId){
        return bookingRepository.getBookingById(bookingId);
    }

    @Override
    public List<Booking> getBookingsByUserId(String userId){
        return bookingRepository.getAllBookingsByUserId(userId);
    }
}
