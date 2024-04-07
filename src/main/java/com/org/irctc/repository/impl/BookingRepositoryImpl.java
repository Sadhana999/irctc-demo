package com.org.irctc.repository.impl;

import com.java.generated.jooq.Tables;
import com.java.generated.jooq.tables.daos.BookingDao;
import com.java.generated.jooq.tables.daos.SeatDao;
import com.java.generated.jooq.tables.pojos.Booking;
import com.java.generated.jooq.tables.pojos.Seat;
import com.org.irctc.repository.BookingRepository;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingRepositoryImpl implements BookingRepository {

    private final DSLContext dslContext;
    private final BookingDao bookingDao;

    @Autowired
    public BookingRepositoryImpl(DSLContext dslContext, BookingDao bookingDao) {
        this.dslContext=dslContext;
        this.bookingDao = bookingDao;
    }

    @Override
    public List<Seat> getAvailableSeats(String trainId){
        return dslContext.select()
                .from(Tables.SEAT)
                .leftJoin(Tables.BOOKING)
                .on(Tables.BOOKING.SEAT_ID.eq(Tables.SEAT.SEAT_ID).and(Tables.BOOKING.TRAIN_ID.eq(trainId)))
                .where(Tables.BOOKING.BOOKING_ID.isNull()) // Filter to find seats not booked
                .fetchInto(Seat.class);
    }

    @Override
    public void addBooking(Booking booking){
        bookingDao.insert(booking);
    }

    @Override
    public Booking getBookingById(String bookingId){
        return bookingDao.fetchOneByBookingId(bookingId);
    }

    @Override
    public List<Booking> getAllBookingsByUserId(String userId){
        return bookingDao.fetchByUserId(userId);
    }
}
