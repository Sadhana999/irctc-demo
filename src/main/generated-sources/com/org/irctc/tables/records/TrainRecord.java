/*
 * This file is generated by jOOQ.
 */
package com.org.irctc.tables.records;


import com.org.irctc.tables.Train;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TrainRecord extends UpdatableRecordImpl<TrainRecord> implements Record10<String, String, String, String, String, String, LocalDateTime, String, LocalDateTime, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>irctc.train.train_id</code>.
     */
    public void setTrainId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>irctc.train.train_id</code>.
     */
    public String getTrainId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>irctc.train.train_number</code>.
     */
    public void setTrainNumber(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>irctc.train.train_number</code>.
     */
    public String getTrainNumber() {
        return (String) get(1);
    }

    /**
     * Setter for <code>irctc.train.train_name</code>.
     */
    public void setTrainName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>irctc.train.train_name</code>.
     */
    public String getTrainName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>irctc.train.source</code>.
     */
    public void setSource(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>irctc.train.source</code>.
     */
    public String getSource() {
        return (String) get(3);
    }

    /**
     * Setter for <code>irctc.train.destination</code>.
     */
    public void setDestination(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>irctc.train.destination</code>.
     */
    public String getDestination() {
        return (String) get(4);
    }

    /**
     * Setter for <code>irctc.train.created_by</code>.
     */
    public void setCreatedBy(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>irctc.train.created_by</code>.
     */
    public String getCreatedBy() {
        return (String) get(5);
    }

    /**
     * Setter for <code>irctc.train.created_date</code>.
     */
    public void setCreatedDate(LocalDateTime value) {
        set(6, value);
    }

    /**
     * Getter for <code>irctc.train.created_date</code>.
     */
    public LocalDateTime getCreatedDate() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>irctc.train.modified_by</code>.
     */
    public void setModifiedBy(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>irctc.train.modified_by</code>.
     */
    public String getModifiedBy() {
        return (String) get(7);
    }

    /**
     * Setter for <code>irctc.train.modified_date</code>.
     */
    public void setModifiedDate(LocalDateTime value) {
        set(8, value);
    }

    /**
     * Getter for <code>irctc.train.modified_date</code>.
     */
    public LocalDateTime getModifiedDate() {
        return (LocalDateTime) get(8);
    }

    /**
     * Setter for <code>irctc.train.status</code>.
     */
    public void setStatus(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>irctc.train.status</code>.
     */
    public String getStatus() {
        return (String) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row10<String, String, String, String, String, String, LocalDateTime, String, LocalDateTime, String> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    @Override
    public Row10<String, String, String, String, String, String, LocalDateTime, String, LocalDateTime, String> valuesRow() {
        return (Row10) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Train.TRAIN.TRAIN_ID;
    }

    @Override
    public Field<String> field2() {
        return Train.TRAIN.TRAIN_NUMBER;
    }

    @Override
    public Field<String> field3() {
        return Train.TRAIN.TRAIN_NAME;
    }

    @Override
    public Field<String> field4() {
        return Train.TRAIN.SOURCE;
    }

    @Override
    public Field<String> field5() {
        return Train.TRAIN.DESTINATION;
    }

    @Override
    public Field<String> field6() {
        return Train.TRAIN.CREATED_BY;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return Train.TRAIN.CREATED_DATE;
    }

    @Override
    public Field<String> field8() {
        return Train.TRAIN.MODIFIED_BY;
    }

    @Override
    public Field<LocalDateTime> field9() {
        return Train.TRAIN.MODIFIED_DATE;
    }

    @Override
    public Field<String> field10() {
        return Train.TRAIN.STATUS;
    }

    @Override
    public String component1() {
        return getTrainId();
    }

    @Override
    public String component2() {
        return getTrainNumber();
    }

    @Override
    public String component3() {
        return getTrainName();
    }

    @Override
    public String component4() {
        return getSource();
    }

    @Override
    public String component5() {
        return getDestination();
    }

    @Override
    public String component6() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime component7() {
        return getCreatedDate();
    }

    @Override
    public String component8() {
        return getModifiedBy();
    }

    @Override
    public LocalDateTime component9() {
        return getModifiedDate();
    }

    @Override
    public String component10() {
        return getStatus();
    }

    @Override
    public String value1() {
        return getTrainId();
    }

    @Override
    public String value2() {
        return getTrainNumber();
    }

    @Override
    public String value3() {
        return getTrainName();
    }

    @Override
    public String value4() {
        return getSource();
    }

    @Override
    public String value5() {
        return getDestination();
    }

    @Override
    public String value6() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime value7() {
        return getCreatedDate();
    }

    @Override
    public String value8() {
        return getModifiedBy();
    }

    @Override
    public LocalDateTime value9() {
        return getModifiedDate();
    }

    @Override
    public String value10() {
        return getStatus();
    }

    @Override
    public TrainRecord value1(String value) {
        setTrainId(value);
        return this;
    }

    @Override
    public TrainRecord value2(String value) {
        setTrainNumber(value);
        return this;
    }

    @Override
    public TrainRecord value3(String value) {
        setTrainName(value);
        return this;
    }

    @Override
    public TrainRecord value4(String value) {
        setSource(value);
        return this;
    }

    @Override
    public TrainRecord value5(String value) {
        setDestination(value);
        return this;
    }

    @Override
    public TrainRecord value6(String value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public TrainRecord value7(LocalDateTime value) {
        setCreatedDate(value);
        return this;
    }

    @Override
    public TrainRecord value8(String value) {
        setModifiedBy(value);
        return this;
    }

    @Override
    public TrainRecord value9(LocalDateTime value) {
        setModifiedDate(value);
        return this;
    }

    @Override
    public TrainRecord value10(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public TrainRecord values(String value1, String value2, String value3, String value4, String value5, String value6, LocalDateTime value7, String value8, LocalDateTime value9, String value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TrainRecord
     */
    public TrainRecord() {
        super(Train.TRAIN);
    }

    /**
     * Create a detached, initialised TrainRecord
     */
    public TrainRecord(String trainId, String trainNumber, String trainName, String source, String destination, String createdBy, LocalDateTime createdDate, String modifiedBy, LocalDateTime modifiedDate, String status) {
        super(Train.TRAIN);

        setTrainId(trainId);
        setTrainNumber(trainNumber);
        setTrainName(trainName);
        setSource(source);
        setDestination(destination);
        setCreatedBy(createdBy);
        setCreatedDate(createdDate);
        setModifiedBy(modifiedBy);
        setModifiedDate(modifiedDate);
        setStatus(status);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised TrainRecord
     */
    public TrainRecord(com.org.irctc.tables.pojos.Train value) {
        super(Train.TRAIN);

        if (value != null) {
            setTrainId(value.getTrainId());
            setTrainNumber(value.getTrainNumber());
            setTrainName(value.getTrainName());
            setSource(value.getSource());
            setDestination(value.getDestination());
            setCreatedBy(value.getCreatedBy());
            setCreatedDate(value.getCreatedDate());
            setModifiedBy(value.getModifiedBy());
            setModifiedDate(value.getModifiedDate());
            setStatus(value.getStatus());
            resetChangedOnNotNull();
        }
    }
}