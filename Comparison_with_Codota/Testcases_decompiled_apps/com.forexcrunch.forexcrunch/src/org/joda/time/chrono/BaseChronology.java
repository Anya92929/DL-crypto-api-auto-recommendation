package org.joda.time.chrono;

import java.io.Serializable;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.ReadablePartial;
import org.joda.time.ReadablePeriod;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.UnsupportedDateTimeField;
import org.joda.time.field.UnsupportedDurationField;

public abstract class BaseChronology extends Chronology implements Serializable {
    private static final long serialVersionUID = -7310865996721419676L;

    public abstract DateTimeZone getZone();

    public abstract String toString();

    public abstract Chronology withUTC();

    public abstract Chronology withZone(DateTimeZone dateTimeZone);

    protected BaseChronology() {
    }

    public long getDateTimeMillis(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        return millisOfDay().set(dayOfMonth().set(monthOfYear().set(year().set(0, i), i2), i3), i4);
    }

    public long getDateTimeMillis(int i, int i2, int i3, int i4, int i5, int i6, int i7) throws IllegalArgumentException {
        return millisOfSecond().set(secondOfMinute().set(minuteOfHour().set(hourOfDay().set(dayOfMonth().set(monthOfYear().set(year().set(0, i), i2), i3), i4), i5), i6), i7);
    }

    public long getDateTimeMillis(long j, int i, int i2, int i3, int i4) throws IllegalArgumentException {
        return millisOfSecond().set(secondOfMinute().set(minuteOfHour().set(hourOfDay().set(j, i), i2), i3), i4);
    }

    public void validate(ReadablePartial readablePartial, int[] iArr) {
        int i = 0;
        int size = readablePartial.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = iArr[i2];
            DateTimeField field = readablePartial.getField(i2);
            if (i3 < field.getMinimumValue()) {
                throw new IllegalFieldValueException(field.getType(), (Number) Integer.valueOf(i3), (Number) Integer.valueOf(field.getMinimumValue()), (Number) null);
            } else if (i3 > field.getMaximumValue()) {
                throw new IllegalFieldValueException(field.getType(), (Number) Integer.valueOf(i3), (Number) null, (Number) Integer.valueOf(field.getMaximumValue()));
            } else {
                i2++;
            }
        }
        while (i < size) {
            int i4 = iArr[i];
            DateTimeField field2 = readablePartial.getField(i);
            if (i4 < field2.getMinimumValue(readablePartial, iArr)) {
                throw new IllegalFieldValueException(field2.getType(), (Number) Integer.valueOf(i4), (Number) Integer.valueOf(field2.getMinimumValue(readablePartial, iArr)), (Number) null);
            } else if (i4 > field2.getMaximumValue(readablePartial, iArr)) {
                throw new IllegalFieldValueException(field2.getType(), (Number) Integer.valueOf(i4), (Number) null, (Number) Integer.valueOf(field2.getMaximumValue(readablePartial, iArr)));
            } else {
                i++;
            }
        }
    }

    public int[] get(ReadablePartial readablePartial, long j) {
        int size = readablePartial.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = readablePartial.getFieldType(i).getField(this).get(j);
        }
        return iArr;
    }

    public long set(ReadablePartial readablePartial, long j) {
        int size = readablePartial.size();
        for (int i = 0; i < size; i++) {
            j = readablePartial.getFieldType(i).getField(this).set(j, readablePartial.getValue(i));
        }
        return j;
    }

    public int[] get(ReadablePeriod readablePeriod, long j, long j2) {
        int size = readablePeriod.size();
        int[] iArr = new int[size];
        if (j != j2) {
            for (int i = 0; i < size; i++) {
                DurationField field = readablePeriod.getFieldType(i).getField(this);
                int difference = field.getDifference(j2, j);
                j = field.add(j, difference);
                iArr[i] = difference;
            }
        }
        return iArr;
    }

    public int[] get(ReadablePeriod readablePeriod, long j) {
        int size = readablePeriod.size();
        int[] iArr = new int[size];
        if (j != 0) {
            long j2 = 0;
            for (int i = 0; i < size; i++) {
                DurationField field = readablePeriod.getFieldType(i).getField(this);
                if (field.isPrecise()) {
                    int difference = field.getDifference(j, j2);
                    j2 = field.add(j2, difference);
                    iArr[i] = difference;
                }
            }
        }
        return iArr;
    }

    public long add(ReadablePeriod readablePeriod, long j, int i) {
        if (i == 0 || readablePeriod == null) {
            return j;
        }
        int size = readablePeriod.size();
        long j2 = j;
        for (int i2 = 0; i2 < size; i2++) {
            long value = (long) readablePeriod.getValue(i2);
            if (value != 0) {
                j2 = readablePeriod.getFieldType(i2).getField(this).add(j2, value * ((long) i));
            }
        }
        return j2;
    }

    public long add(long j, long j2, int i) {
        return (j2 == 0 || i == 0) ? j : FieldUtils.safeAdd(j, FieldUtils.safeMultiply(j2, i));
    }

    public DurationField millis() {
        return UnsupportedDurationField.getInstance(DurationFieldType.millis());
    }

    public DateTimeField millisOfSecond() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.millisOfSecond(), millis());
    }

    public DateTimeField millisOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.millisOfDay(), millis());
    }

    public DurationField seconds() {
        return UnsupportedDurationField.getInstance(DurationFieldType.seconds());
    }

    public DateTimeField secondOfMinute() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.secondOfMinute(), seconds());
    }

    public DateTimeField secondOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.secondOfDay(), seconds());
    }

    public DurationField minutes() {
        return UnsupportedDurationField.getInstance(DurationFieldType.minutes());
    }

    public DateTimeField minuteOfHour() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.minuteOfHour(), minutes());
    }

    public DateTimeField minuteOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.minuteOfDay(), minutes());
    }

    public DurationField hours() {
        return UnsupportedDurationField.getInstance(DurationFieldType.hours());
    }

    public DateTimeField hourOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.hourOfDay(), hours());
    }

    public DateTimeField clockhourOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.clockhourOfDay(), hours());
    }

    public DurationField halfdays() {
        return UnsupportedDurationField.getInstance(DurationFieldType.halfdays());
    }

    public DateTimeField hourOfHalfday() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.hourOfHalfday(), hours());
    }

    public DateTimeField clockhourOfHalfday() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.clockhourOfHalfday(), hours());
    }

    public DateTimeField halfdayOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.halfdayOfDay(), halfdays());
    }

    public DurationField days() {
        return UnsupportedDurationField.getInstance(DurationFieldType.days());
    }

    public DateTimeField dayOfWeek() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.dayOfWeek(), days());
    }

    public DateTimeField dayOfMonth() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.dayOfMonth(), days());
    }

    public DateTimeField dayOfYear() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.dayOfYear(), days());
    }

    public DurationField weeks() {
        return UnsupportedDurationField.getInstance(DurationFieldType.weeks());
    }

    public DateTimeField weekOfWeekyear() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.weekOfWeekyear(), weeks());
    }

    public DurationField weekyears() {
        return UnsupportedDurationField.getInstance(DurationFieldType.weekyears());
    }

    public DateTimeField weekyear() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.weekyear(), weekyears());
    }

    public DateTimeField weekyearOfCentury() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.weekyearOfCentury(), weekyears());
    }

    public DurationField months() {
        return UnsupportedDurationField.getInstance(DurationFieldType.months());
    }

    public DateTimeField monthOfYear() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.monthOfYear(), months());
    }

    public DurationField years() {
        return UnsupportedDurationField.getInstance(DurationFieldType.years());
    }

    public DateTimeField year() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.year(), years());
    }

    public DateTimeField yearOfEra() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.yearOfEra(), years());
    }

    public DateTimeField yearOfCentury() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.yearOfCentury(), years());
    }

    public DurationField centuries() {
        return UnsupportedDurationField.getInstance(DurationFieldType.centuries());
    }

    public DateTimeField centuryOfEra() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.centuryOfEra(), centuries());
    }

    public DurationField eras() {
        return UnsupportedDurationField.getInstance(DurationFieldType.eras());
    }

    public DateTimeField era() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.era(), eras());
    }
}
