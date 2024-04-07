/*
 * This file is generated by jOOQ.
 */
package com.java.generated.jooq.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Seat implements Serializable {

    private static final long serialVersionUID = 1L;

    private String seatId;
    private String seatNumber;
    private String status;
    private BigDecimal price;

    public Seat() {}

    public Seat(Seat value) {
        this.seatId = value.seatId;
        this.seatNumber = value.seatNumber;
        this.status = value.status;
        this.price = value.price;
    }

    public Seat(
        String seatId,
        String seatNumber,
        String status,
        BigDecimal price
    ) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.status = status;
        this.price = price;
    }

    /**
     * Getter for <code>irctc.seat.seat_id</code>.
     */
    public String getSeatId() {
        return this.seatId;
    }

    /**
     * Setter for <code>irctc.seat.seat_id</code>.
     */
    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    /**
     * Getter for <code>irctc.seat.seat_number</code>.
     */
    public String getSeatNumber() {
        return this.seatNumber;
    }

    /**
     * Setter for <code>irctc.seat.seat_number</code>.
     */
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    /**
     * Getter for <code>irctc.seat.status</code>.
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Setter for <code>irctc.seat.status</code>.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter for <code>irctc.seat.price</code>.
     */
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * Setter for <code>irctc.seat.price</code>.
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Seat other = (Seat) obj;
        if (this.seatId == null) {
            if (other.seatId != null)
                return false;
        }
        else if (!this.seatId.equals(other.seatId))
            return false;
        if (this.seatNumber == null) {
            if (other.seatNumber != null)
                return false;
        }
        else if (!this.seatNumber.equals(other.seatNumber))
            return false;
        if (this.status == null) {
            if (other.status != null)
                return false;
        }
        else if (!this.status.equals(other.status))
            return false;
        if (this.price == null) {
            if (other.price != null)
                return false;
        }
        else if (!this.price.equals(other.price))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.seatId == null) ? 0 : this.seatId.hashCode());
        result = prime * result + ((this.seatNumber == null) ? 0 : this.seatNumber.hashCode());
        result = prime * result + ((this.status == null) ? 0 : this.status.hashCode());
        result = prime * result + ((this.price == null) ? 0 : this.price.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Seat (");

        sb.append(seatId);
        sb.append(", ").append(seatNumber);
        sb.append(", ").append(status);
        sb.append(", ").append(price);

        sb.append(")");
        return sb.toString();
    }
}