package com.org.irctc.repository;

import com.org.irctc.tables.pojos.Seat;

import java.util.List;

public interface SeatRepository {
    public List<Seat> getAllSeats();
}
