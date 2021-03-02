package org.joda.time;

import java.io.Serializable;
import org.joda.convert.FromString;
import org.joda.time.base.BasePeriod;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;

public class MutablePeriod extends BasePeriod implements ReadWritablePeriod, Cloneable, Serializable {
    private static final long serialVersionUID = 3436451121567212165L;

    @FromString
    public static MutablePeriod parse(String str) {
        return parse(str, ISOPeriodFormat.standard());
    }

    public static MutablePeriod parse(String str, PeriodFormatter periodFormatter) {
        return periodFormatter.parsePeriod(str).toMutablePeriod();
    }

    public MutablePeriod() {
        super(0, (PeriodType) null, (Chronology) null);
    }

    public MutablePeriod(PeriodType periodType) {
        super(0, periodType, (Chronology) null);
    }

    public MutablePeriod(int i, int i2, int i3, int i4) {
        super(0, 0, 0, 0, i, i2, i3, i4, PeriodType.standard());
    }

    public MutablePeriod(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        super(i, i2, i3, i4, i5, i6, i7, i8, PeriodType.standard());
    }

    public MutablePeriod(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, PeriodType periodType) {
        super(i, i2, i3, i4, i5, i6, i7, i8, periodType);
    }

    public MutablePeriod(long j) {
        super(j);
    }

    public MutablePeriod(long j, PeriodType periodType) {
        super(j, periodType, (Chronology) null);
    }

    public MutablePeriod(long j, Chronology chronology) {
        super(j, (PeriodType) null, chronology);
    }

    public MutablePeriod(long j, PeriodType periodType, Chronology chronology) {
        super(j, periodType, chronology);
    }

    public MutablePeriod(long j, long j2) {
        super(j, j2, (PeriodType) null, (Chronology) null);
    }

    public MutablePeriod(long j, long j2, PeriodType periodType) {
        super(j, j2, periodType, (Chronology) null);
    }

    public MutablePeriod(long j, long j2, Chronology chronology) {
        super(j, j2, (PeriodType) null, chronology);
    }

    public MutablePeriod(long j, long j2, PeriodType periodType, Chronology chronology) {
        super(j, j2, periodType, chronology);
    }

    public MutablePeriod(ReadableInstant readableInstant, ReadableInstant readableInstant2) {
        super(readableInstant, readableInstant2, (PeriodType) null);
    }

    public MutablePeriod(ReadableInstant readableInstant, ReadableInstant readableInstant2, PeriodType periodType) {
        super(readableInstant, readableInstant2, periodType);
    }

    public MutablePeriod(ReadableInstant readableInstant, ReadableDuration readableDuration) {
        super(readableInstant, readableDuration, (PeriodType) null);
    }

    public MutablePeriod(ReadableInstant readableInstant, ReadableDuration readableDuration, PeriodType periodType) {
        super(readableInstant, readableDuration, periodType);
    }

    public MutablePeriod(ReadableDuration readableDuration, ReadableInstant readableInstant) {
        super(readableDuration, readableInstant, (PeriodType) null);
    }

    public MutablePeriod(ReadableDuration readableDuration, ReadableInstant readableInstant, PeriodType periodType) {
        super(readableDuration, readableInstant, periodType);
    }

    public MutablePeriod(Object obj) {
        super(obj, (PeriodType) null, (Chronology) null);
    }

    public MutablePeriod(Object obj, PeriodType periodType) {
        super(obj, periodType, (Chronology) null);
    }

    public MutablePeriod(Object obj, Chronology chronology) {
        super(obj, (PeriodType) null, chronology);
    }

    public MutablePeriod(Object obj, PeriodType periodType, Chronology chronology) {
        super(obj, periodType, chronology);
    }

    public void clear() {
        super.setValues(new int[size()]);
    }

    public void setValue(int i, int i2) {
        super.setValue(i, i2);
    }

    public void set(DurationFieldType durationFieldType, int i) {
        super.setField(durationFieldType, i);
    }

    public void setPeriod(ReadablePeriod readablePeriod) {
        super.setPeriod(readablePeriod);
    }

    public void setPeriod(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        super.setPeriod(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void setPeriod(ReadableInterval readableInterval) {
        if (readableInterval == null) {
            setPeriod(0);
            return;
        }
        setPeriod(readableInterval.getStartMillis(), readableInterval.getEndMillis(), DateTimeUtils.getChronology(readableInterval.getChronology()));
    }

    public void setPeriod(ReadableInstant readableInstant, ReadableInstant readableInstant2) {
        if (readableInstant == readableInstant2) {
            setPeriod(0);
            return;
        }
        setPeriod(DateTimeUtils.getInstantMillis(readableInstant), DateTimeUtils.getInstantMillis(readableInstant2), DateTimeUtils.getIntervalChronology(readableInstant, readableInstant2));
    }

    public void setPeriod(long j, long j2) {
        setPeriod(j, j2, (Chronology) null);
    }

    public void setPeriod(long j, long j2, Chronology chronology) {
        setValues(DateTimeUtils.getChronology(chronology).get(this, j, j2));
    }

    public void setPeriod(ReadableDuration readableDuration) {
        setPeriod(readableDuration, (Chronology) null);
    }

    public void setPeriod(ReadableDuration readableDuration, Chronology chronology) {
        setPeriod(DateTimeUtils.getDurationMillis(readableDuration), chronology);
    }

    public void setPeriod(long j) {
        setPeriod(j, (Chronology) null);
    }

    public void setPeriod(long j, Chronology chronology) {
        setValues(DateTimeUtils.getChronology(chronology).get((ReadablePeriod) this, j));
    }

    public void add(DurationFieldType durationFieldType, int i) {
        super.addField(durationFieldType, i);
    }

    public void add(ReadablePeriod readablePeriod) {
        super.addPeriod(readablePeriod);
    }

    public void add(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        setPeriod(FieldUtils.safeAdd(getYears(), i), FieldUtils.safeAdd(getMonths(), i2), FieldUtils.safeAdd(getWeeks(), i3), FieldUtils.safeAdd(getDays(), i4), FieldUtils.safeAdd(getHours(), i5), FieldUtils.safeAdd(getMinutes(), i6), FieldUtils.safeAdd(getSeconds(), i7), FieldUtils.safeAdd(getMillis(), i8));
    }

    public void add(ReadableInterval readableInterval) {
        if (readableInterval != null) {
            add((ReadablePeriod) readableInterval.toPeriod(getPeriodType()));
        }
    }

    public void add(ReadableDuration readableDuration) {
        if (readableDuration != null) {
            add((ReadablePeriod) new Period(readableDuration.getMillis(), getPeriodType()));
        }
    }

    public void add(long j) {
        add((ReadablePeriod) new Period(j, getPeriodType()));
    }

    public void add(long j, Chronology chronology) {
        add((ReadablePeriod) new Period(j, getPeriodType(), chronology));
    }

    public void mergePeriod(ReadablePeriod readablePeriod) {
        super.mergePeriod(readablePeriod);
    }

    public int getYears() {
        return getPeriodType().getIndexedField(this, PeriodType.YEAR_INDEX);
    }

    public int getMonths() {
        return getPeriodType().getIndexedField(this, PeriodType.MONTH_INDEX);
    }

    public int getWeeks() {
        return getPeriodType().getIndexedField(this, PeriodType.WEEK_INDEX);
    }

    public int getDays() {
        return getPeriodType().getIndexedField(this, PeriodType.DAY_INDEX);
    }

    public int getHours() {
        return getPeriodType().getIndexedField(this, PeriodType.HOUR_INDEX);
    }

    public int getMinutes() {
        return getPeriodType().getIndexedField(this, PeriodType.MINUTE_INDEX);
    }

    public int getSeconds() {
        return getPeriodType().getIndexedField(this, PeriodType.SECOND_INDEX);
    }

    public int getMillis() {
        return getPeriodType().getIndexedField(this, PeriodType.MILLI_INDEX);
    }

    public void setYears(int i) {
        super.setField(DurationFieldType.years(), i);
    }

    public void addYears(int i) {
        super.addField(DurationFieldType.years(), i);
    }

    public void setMonths(int i) {
        super.setField(DurationFieldType.months(), i);
    }

    public void addMonths(int i) {
        super.addField(DurationFieldType.months(), i);
    }

    public void setWeeks(int i) {
        super.setField(DurationFieldType.weeks(), i);
    }

    public void addWeeks(int i) {
        super.addField(DurationFieldType.weeks(), i);
    }

    public void setDays(int i) {
        super.setField(DurationFieldType.days(), i);
    }

    public void addDays(int i) {
        super.addField(DurationFieldType.days(), i);
    }

    public void setHours(int i) {
        super.setField(DurationFieldType.hours(), i);
    }

    public void addHours(int i) {
        super.addField(DurationFieldType.hours(), i);
    }

    public void setMinutes(int i) {
        super.setField(DurationFieldType.minutes(), i);
    }

    public void addMinutes(int i) {
        super.addField(DurationFieldType.minutes(), i);
    }

    public void setSeconds(int i) {
        super.setField(DurationFieldType.seconds(), i);
    }

    public void addSeconds(int i) {
        super.addField(DurationFieldType.seconds(), i);
    }

    public void setMillis(int i) {
        super.setField(DurationFieldType.millis(), i);
    }

    public void addMillis(int i) {
        super.addField(DurationFieldType.millis(), i);
    }

    public MutablePeriod copy() {
        return (MutablePeriod) clone();
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError("Clone error");
        }
    }
}
