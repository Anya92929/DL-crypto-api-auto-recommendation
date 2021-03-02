package org.joda.time;

import java.io.Serializable;
import org.joda.convert.FromString;
import org.joda.time.base.AbstractInstant;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.convert.ConverterManager;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public final class Instant extends AbstractInstant implements ReadableInstant, Serializable {
    private static final long serialVersionUID = 3299096530934209741L;
    private final long iMillis;

    public static Instant now() {
        return new Instant();
    }

    @FromString
    public static Instant parse(String str) {
        return parse(str, ISODateTimeFormat.dateTimeParser());
    }

    public static Instant parse(String str, DateTimeFormatter dateTimeFormatter) {
        return dateTimeFormatter.parseDateTime(str).toInstant();
    }

    public Instant() {
        this.iMillis = DateTimeUtils.currentTimeMillis();
    }

    public Instant(long j) {
        this.iMillis = j;
    }

    public Instant(Object obj) {
        this.iMillis = ConverterManager.getInstance().getInstantConverter(obj).getInstantMillis(obj, ISOChronology.getInstanceUTC());
    }

    public Instant toInstant() {
        return this;
    }

    public Instant withMillis(long j) {
        return j == this.iMillis ? this : new Instant(j);
    }

    public Instant withDurationAdded(long j, int i) {
        return (j == 0 || i == 0) ? this : withMillis(getChronology().add(getMillis(), j, i));
    }

    public Instant withDurationAdded(ReadableDuration readableDuration, int i) {
        return (readableDuration == null || i == 0) ? this : withDurationAdded(readableDuration.getMillis(), i);
    }

    public Instant plus(long j) {
        return withDurationAdded(j, 1);
    }

    public Instant plus(ReadableDuration readableDuration) {
        return withDurationAdded(readableDuration, 1);
    }

    public Instant minus(long j) {
        return withDurationAdded(j, -1);
    }

    public Instant minus(ReadableDuration readableDuration) {
        return withDurationAdded(readableDuration, -1);
    }

    public long getMillis() {
        return this.iMillis;
    }

    public Chronology getChronology() {
        return ISOChronology.getInstanceUTC();
    }

    public DateTime toDateTime() {
        return new DateTime(getMillis(), (Chronology) ISOChronology.getInstance());
    }

    @Deprecated
    public DateTime toDateTimeISO() {
        return toDateTime();
    }

    public MutableDateTime toMutableDateTime() {
        return new MutableDateTime(getMillis(), (Chronology) ISOChronology.getInstance());
    }

    @Deprecated
    public MutableDateTime toMutableDateTimeISO() {
        return toMutableDateTime();
    }
}
