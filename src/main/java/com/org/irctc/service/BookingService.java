package com.org.irctc.service;

import com.org.irctc.tables.pojos.Booking;
import com.org.irctc.dto.BookingRequestDto;

import java.util.List;

public interface BookingService {
    public String addBooking(BookingRequestDto bookingRequestDto);
    public Booking getBookingById(String bookingId);
    public List<Booking> getBookingsByUserId(String userId);
}
