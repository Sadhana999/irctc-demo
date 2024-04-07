package com.org.irctc.repository;

import com.java.generated.jooq.tables.pojos.Booking;
import com.java.generated.jooq.tables.pojos.Seat;

import java.util.List;

public interface BookingRepository {
    public List<Seat> getAvailableSeats(String trainId);

    public void addBooking(Booking booking);

    public Booking getBookingById(String bookingId);

    public List<Booking> getAllBookingsByUserId(String userId);
}
