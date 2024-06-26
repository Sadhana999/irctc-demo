/*
 * This file is generated by jOOQ.
 */
package com.org.irctc.tables;


import com.org.irctc.Irctc;
import com.org.irctc.Keys;
import com.org.irctc.tables.records.BookingRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function9;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row9;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Booking extends TableImpl<BookingRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>irctc.booking</code>
     */
    public static final Booking BOOKING = new Booking();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BookingRecord> getRecordType() {
        return BookingRecord.class;
    }

    /**
     * The column <code>irctc.booking.booking_id</code>.
     */
    public final TableField<BookingRecord, String> BOOKING_ID = createField(DSL.name("booking_id"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>irctc.booking.train_id</code>.
     */
    public final TableField<BookingRecord, String> TRAIN_ID = createField(DSL.name("train_id"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>irctc.booking.seat_id</code>.
     */
    public final TableField<BookingRecord, String> SEAT_ID = createField(DSL.name("seat_id"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>irctc.booking.user_id</code>.
     */
    public final TableField<BookingRecord, String> USER_ID = createField(DSL.name("user_id"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>irctc.booking.status</code>.
     */
    public final TableField<BookingRecord, String> STATUS = createField(DSL.name("status"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>irctc.booking.created_by</code>.
     */
    public final TableField<BookingRecord, String> CREATED_BY = createField(DSL.name("created_by"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>irctc.booking.created_date</code>.
     */
    public final TableField<BookingRecord, LocalDateTime> CREATED_DATE = createField(DSL.name("created_date"), SQLDataType.LOCALDATETIME(0), this, "");

    /**
     * The column <code>irctc.booking.modified_by</code>.
     */
    public final TableField<BookingRecord, String> MODIFIED_BY = createField(DSL.name("modified_by"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>irctc.booking.modified_date</code>.
     */
    public final TableField<BookingRecord, LocalDateTime> MODIFIED_DATE = createField(DSL.name("modified_date"), SQLDataType.LOCALDATETIME(0), this, "");

    private Booking(Name alias, Table<BookingRecord> aliased) {
        this(alias, aliased, null);
    }

    private Booking(Name alias, Table<BookingRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>irctc.booking</code> table reference
     */
    public Booking(String alias) {
        this(DSL.name(alias), BOOKING);
    }

    /**
     * Create an aliased <code>irctc.booking</code> table reference
     */
    public Booking(Name alias) {
        this(alias, BOOKING);
    }

    /**
     * Create a <code>irctc.booking</code> table reference
     */
    public Booking() {
        this(DSL.name("booking"), null);
    }

    public <O extends Record> Booking(Table<O> child, ForeignKey<O, BookingRecord> key) {
        super(child, key, BOOKING);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Irctc.IRCTC;
    }

    @Override
    public UniqueKey<BookingRecord> getPrimaryKey() {
        return Keys.KEY_BOOKING_PRIMARY;
    }

    @Override
    public List<ForeignKey<BookingRecord, ?>> getReferences() {
        return Arrays.asList(Keys.BOOKING_TRAIN_ID, Keys.BOOKING_SEAT_ID);
    }

    private transient Train _train;
    private transient Seat _seat;

    /**
     * Get the implicit join path to the <code>irctc.train</code> table.
     */
    public Train train() {
        if (_train == null)
            _train = new Train(this, Keys.BOOKING_TRAIN_ID);

        return _train;
    }

    /**
     * Get the implicit join path to the <code>irctc.seat</code> table.
     */
    public Seat seat() {
        if (_seat == null)
            _seat = new Seat(this, Keys.BOOKING_SEAT_ID);

        return _seat;
    }

    @Override
    public Booking as(String alias) {
        return new Booking(DSL.name(alias), this);
    }

    @Override
    public Booking as(Name alias) {
        return new Booking(alias, this);
    }

    @Override
    public Booking as(Table<?> alias) {
        return new Booking(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Booking rename(String name) {
        return new Booking(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Booking rename(Name name) {
        return new Booking(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Booking rename(Table<?> name) {
        return new Booking(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<String, String, String, String, String, String, LocalDateTime, String, LocalDateTime> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function9<? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super LocalDateTime, ? super String, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function9<? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super LocalDateTime, ? super String, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
