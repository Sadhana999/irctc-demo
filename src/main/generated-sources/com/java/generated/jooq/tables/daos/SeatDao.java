/*
 * This file is generated by jOOQ.
 */
package com.java.generated.jooq.tables.daos;


import com.java.generated.jooq.tables.Seat;
import com.java.generated.jooq.tables.records.SeatRecord;

import java.math.BigDecimal;
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
public class SeatDao extends DAOImpl<SeatRecord, com.java.generated.jooq.tables.pojos.Seat, String> {

    /**
     * Create a new SeatDao without any configuration
     */
    public SeatDao() {
        super(Seat.SEAT, com.java.generated.jooq.tables.pojos.Seat.class);
    }

    /**
     * Create a new SeatDao with an attached configuration
     */
    @Autowired
    public SeatDao(Configuration configuration) {
        super(Seat.SEAT, com.java.generated.jooq.tables.pojos.Seat.class, configuration);
    }

    @Override
    public String getId(com.java.generated.jooq.tables.pojos.Seat object) {
        return object.getSeatId();
    }

    /**
     * Fetch records that have <code>seat_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.java.generated.jooq.tables.pojos.Seat> fetchRangeOfSeatId(String lowerInclusive, String upperInclusive) {
        return fetchRange(Seat.SEAT.SEAT_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>seat_id IN (values)</code>
     */
    public List<com.java.generated.jooq.tables.pojos.Seat> fetchBySeatId(String... values) {
        return fetch(Seat.SEAT.SEAT_ID, values);
    }

    /**
     * Fetch a unique record that has <code>seat_id = value</code>
     */
    public com.java.generated.jooq.tables.pojos.Seat fetchOneBySeatId(String value) {
        return fetchOne(Seat.SEAT.SEAT_ID, value);
    }

    /**
     * Fetch a unique record that has <code>seat_id = value</code>
     */
    public Optional<com.java.generated.jooq.tables.pojos.Seat> fetchOptionalBySeatId(String value) {
        return fetchOptional(Seat.SEAT.SEAT_ID, value);
    }

    /**
     * Fetch records that have <code>seat_number BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.java.generated.jooq.tables.pojos.Seat> fetchRangeOfSeatNumber(String lowerInclusive, String upperInclusive) {
        return fetchRange(Seat.SEAT.SEAT_NUMBER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>seat_number IN (values)</code>
     */
    public List<com.java.generated.jooq.tables.pojos.Seat> fetchBySeatNumber(String... values) {
        return fetch(Seat.SEAT.SEAT_NUMBER, values);
    }

    /**
     * Fetch a unique record that has <code>seat_number = value</code>
     */
    public com.java.generated.jooq.tables.pojos.Seat fetchOneBySeatNumber(String value) {
        return fetchOne(Seat.SEAT.SEAT_NUMBER, value);
    }

    /**
     * Fetch a unique record that has <code>seat_number = value</code>
     */
    public Optional<com.java.generated.jooq.tables.pojos.Seat> fetchOptionalBySeatNumber(String value) {
        return fetchOptional(Seat.SEAT.SEAT_NUMBER, value);
    }

    /**
     * Fetch records that have <code>status BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.java.generated.jooq.tables.pojos.Seat> fetchRangeOfStatus(String lowerInclusive, String upperInclusive) {
        return fetchRange(Seat.SEAT.STATUS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>status IN (values)</code>
     */
    public List<com.java.generated.jooq.tables.pojos.Seat> fetchByStatus(String... values) {
        return fetch(Seat.SEAT.STATUS, values);
    }

    /**
     * Fetch records that have <code>price BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.java.generated.jooq.tables.pojos.Seat> fetchRangeOfPrice(BigDecimal lowerInclusive, BigDecimal upperInclusive) {
        return fetchRange(Seat.SEAT.PRICE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>price IN (values)</code>
     */
    public List<com.java.generated.jooq.tables.pojos.Seat> fetchByPrice(BigDecimal... values) {
        return fetch(Seat.SEAT.PRICE, values);
    }
}
