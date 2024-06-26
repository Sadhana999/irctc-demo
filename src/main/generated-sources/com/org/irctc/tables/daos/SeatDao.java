/*
 * This file is generated by jOOQ.
 */
package com.org.irctc.tables.daos;


import com.org.irctc.tables.Seat;
import com.org.irctc.tables.records.SeatRecord;

import java.util.List;
import java.util.Optional;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class SeatDao extends DAOImpl<SeatRecord, com.org.irctc.tables.pojos.Seat, String> {

    /**
     * Create a new SeatDao without any configuration
     */
    public SeatDao() {
        super(Seat.SEAT, com.org.irctc.tables.pojos.Seat.class);
    }

    /**
     * Create a new SeatDao with an attached configuration
     */
    @Autowired
    public SeatDao(Configuration configuration) {
        super(Seat.SEAT, com.org.irctc.tables.pojos.Seat.class, configuration);
    }

    @Override
    public String getId(com.org.irctc.tables.pojos.Seat object) {
        return object.getSeatId();
    }

    /**
     * Fetch records that have <code>seat_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.org.irctc.tables.pojos.Seat> fetchRangeOfSeatId(String lowerInclusive, String upperInclusive) {
        return fetchRange(Seat.SEAT.SEAT_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>seat_id IN (values)</code>
     */
    public List<com.org.irctc.tables.pojos.Seat> fetchBySeatId(String... values) {
        return fetch(Seat.SEAT.SEAT_ID, values);
    }

    /**
     * Fetch a unique record that has <code>seat_id = value</code>
     */
    public com.org.irctc.tables.pojos.Seat fetchOneBySeatId(String value) {
        return fetchOne(Seat.SEAT.SEAT_ID, value);
    }

    /**
     * Fetch a unique record that has <code>seat_id = value</code>
     */
    public Optional<com.org.irctc.tables.pojos.Seat> fetchOptionalBySeatId(String value) {
        return fetchOptional(Seat.SEAT.SEAT_ID, value);
    }

    /**
     * Fetch records that have <code>seat_number BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.org.irctc.tables.pojos.Seat> fetchRangeOfSeatNumber(String lowerInclusive, String upperInclusive) {
        return fetchRange(Seat.SEAT.SEAT_NUMBER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>seat_number IN (values)</code>
     */
    public List<com.org.irctc.tables.pojos.Seat> fetchBySeatNumber(String... values) {
        return fetch(Seat.SEAT.SEAT_NUMBER, values);
    }

    /**
     * Fetch a unique record that has <code>seat_number = value</code>
     */
    public com.org.irctc.tables.pojos.Seat fetchOneBySeatNumber(String value) {
        return fetchOne(Seat.SEAT.SEAT_NUMBER, value);
    }

    /**
     * Fetch a unique record that has <code>seat_number = value</code>
     */
    public Optional<com.org.irctc.tables.pojos.Seat> fetchOptionalBySeatNumber(String value) {
        return fetchOptional(Seat.SEAT.SEAT_NUMBER, value);
    }

    /**
     * Fetch records that have <code>status BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.org.irctc.tables.pojos.Seat> fetchRangeOfStatus(String lowerInclusive, String upperInclusive) {
        return fetchRange(Seat.SEAT.STATUS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>status IN (values)</code>
     */
    public List<com.org.irctc.tables.pojos.Seat> fetchByStatus(String... values) {
        return fetch(Seat.SEAT.STATUS, values);
    }
}
