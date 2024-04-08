package com.org.irctc.repository;

import com.org.irctc.tables.pojos.Booking;
import com.org.irctc.tables.pojos.Seat;

import java.util.List;

public interface BookingRepository {
    public List<Seat> getAvailableSeats(String trainId);

    public boolean isSeatAvailableInTrain(String trainId, String seatId);

    public void addBooking(Booking booking);

    public Booking getBookingById(String bookingId);

    public List<Booking> getAllBookingsByUserId(String userId);
}
