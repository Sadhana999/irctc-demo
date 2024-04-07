package com.org.irctc.service;

import com.java.generated.jooq.tables.pojos.Booking;
import com.org.irctc.dto.BookingRequestDto;

import java.util.List;

public interface BookingService {
    public String addBooking(BookingRequestDto bookingRequestDto);
    public Booking getBookingById(String bookingId);
    public List<Booking> getBookingsByUserId(String userId);
}
