/*
 * This file is generated by jOOQ.
 */
package com.org.irctc.tables;


import com.org.irctc.Irctc;
import com.org.irctc.Keys;
import com.org.irctc.tables.records.SeatRecord;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function3;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row3;
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
public class Seat extends TableImpl<SeatRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>irctc.seat</code>
     */
    public static final Seat SEAT = new Seat();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SeatRecord> getRecordType() {
        return SeatRecord.class;
    }

    /**
     * The column <code>irctc.seat.seat_id</code>.
     */
    public final TableField<SeatRecord, String> SEAT_ID = createField(DSL.name("seat_id"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>irctc.seat.seat_number</code>.
     */
    public final TableField<SeatRecord, String> SEAT_NUMBER = createField(DSL.name("seat_number"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>irctc.seat.status</code>.
     */
    public final TableField<SeatRecord, String> STATUS = createField(DSL.name("status"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    private Seat(Name alias, Table<SeatRecord> aliased) {
        this(alias, aliased, null);
    }

    private Seat(Name alias, Table<SeatRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>irctc.seat</code> table reference
     */
    public Seat(String alias) {
        this(DSL.name(alias), SEAT);
    }

    /**
     * Create an aliased <code>irctc.seat</code> table reference
     */
    public Seat(Name alias) {
        this(alias, SEAT);
    }

    /**
     * Create a <code>irctc.seat</code> table reference
     */
    public Seat() {
        this(DSL.name("seat"), null);
    }

    public <O extends Record> Seat(Table<O> child, ForeignKey<O, SeatRecord> key) {
        super(child, key, SEAT);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Irctc.IRCTC;
    }

    @Override
    public UniqueKey<SeatRecord> getPrimaryKey() {
        return Keys.KEY_SEAT_PRIMARY;
    }

    @Override
    public List<UniqueKey<SeatRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.KEY_SEAT_SEAT_NUMBER_UNIQUE);
    }

    @Override
    public Seat as(String alias) {
        return new Seat(DSL.name(alias), this);
    }

    @Override
    public Seat as(Name alias) {
        return new Seat(alias, this);
    }

    @Override
    public Seat as(Table<?> alias) {
        return new Seat(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Seat rename(String name) {
        return new Seat(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Seat rename(Name name) {
        return new Seat(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Seat rename(Table<?> name) {
        return new Seat(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super String, ? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super String, ? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}