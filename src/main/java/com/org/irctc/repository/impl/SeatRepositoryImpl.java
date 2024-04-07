package com.org.irctc.repository.impl;

import com.java.generated.jooq.tables.daos.SeatDao;
import com.java.generated.jooq.tables.pojos.Seat;
import com.org.irctc.repository.SeatRepository;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatRepositoryImpl implements SeatRepository {
    private final DSLContext dslContext;
    private final SeatDao seatDao;

    public SeatRepositoryImpl(DSLContext dslContext, SeatDao seatDao) {
        this.dslContext=dslContext;
        this.seatDao = seatDao;
    }

    @Override
    public List<Seat> getAllSeats(){
        return seatDao.findAll();
    }
}
