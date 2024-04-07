package com.org.irctc.repository;

import com.java.generated.jooq.tables.pojos.Seat;

import java.util.List;

public interface SeatRepository {
    public List<Seat> getAllSeats();
}
