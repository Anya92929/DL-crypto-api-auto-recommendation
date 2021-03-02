package org.joda.time.field;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.ReadablePartial;

public final class UnsupportedDateTimeField extends DateTimeField implements Serializable {
    private static HashMap<DateTimeFieldType, UnsupportedDateTimeField> cCache = null;
    private static final long serialVersionUID = -1934618396111902255L;
    private final DurationField iDurationField;
    private final DateTimeFieldType iType;

    public static synchronized UnsupportedDateTimeField getInstance(DateTimeFieldType dateTimeFieldType, DurationField durationField) {
        UnsupportedDateTimeField unsupportedDateTimeField;
        synchronized (UnsupportedDateTimeField.class) {
            if (cCache == null) {
                cCache = new HashMap<>(7);
                unsupportedDateTimeField = null;
            } else {
                unsupportedDateTimeField = cCache.get(dateTimeFieldType);
                if (!(unsupportedDateTimeField == null || unsupportedDateTimeField.getDurationField() == durationField)) {
                    unsupportedDateTimeField = null;
                }
            }
            if (unsupportedDateTimeField == null) {
                unsupportedDateTimeField = new UnsupportedDateTimeField(dateTimeFieldType, durationField);
                cCache.put(dateTimeFieldType, unsupportedDateTimeField);
            }
        }
        return unsupportedDateTimeField;
    }

    private UnsupportedDateTimeField(DateTimeFieldType dateTimeFieldType, DurationField durationField) {
        if (dateTimeFieldType == null || durationField == null) {
            throw new IllegalArgumentException();
        }
        this.iType = dateTimeFieldType;
        this.iDurationField = durationField;
    }

    public DateTimeFieldType getType() {
        return this.iType;
    }

    public String getName() {
        return this.iType.getName();
    }

    public boolean isSupported() {
        return false;
    }

    public boolean isLenient() {
        return false;
    }

    public int get(long j) {
        throw unsupported();
    }

    public String getAsText(long j, Locale locale) {
        throw unsupported();
    }

    public String getAsText(long j) {
        throw unsupported();
    }

    public String getAsText(ReadablePartial readablePartial, int i, Locale locale) {
        throw unsupported();
    }

    public String getAsText(ReadablePartial readablePartial, Locale locale) {
        throw unsupported();
    }

    public String getAsText(int i, Locale locale) {
        throw unsupported();
    }

    public String getAsShortText(long j, Locale locale) {
        throw unsupported();
    }

    public String getAsShortText(long j) {
        throw unsupported();
    }

    public String getAsShortText(ReadablePartial readablePartial, int i, Locale locale) {
        throw unsupported();
    }

    public String getAsShortText(ReadablePartial readablePartial, Locale locale) {
        throw unsupported();
    }

    public String getAsShortText(int i, Locale locale) {
        throw unsupported();
    }

    public long add(long j, int i) {
        return getDurationField().add(j, i);
    }

    public long add(long j, long j2) {
        return getDurationField().add(j, j2);
    }

    public int[] add(ReadablePartial readablePartial, int i, int[] iArr, int i2) {
        throw unsupported();
    }

    public int[] addWrapPartial(ReadablePartial readablePartial, int i, int[] iArr, int i2) {
        throw unsupported();
    }

    public long addWrapField(long j, int i) {
        throw unsupported();
    }

    public int[] addWrapField(ReadablePartial readablePartial, int i, int[] iArr, int i2) {
        throw unsupported();
    }

    public int getDifference(long j, long j2) {
        return getDurationField().getDifference(j, j2);
    }

    public long getDifferenceAsLong(long j, long j2) {
        return getDurationField().getDifferenceAsLong(j, j2);
    }

    public long set(long j, int i) {
        throw unsupported();
    }

    public int[] set(ReadablePartial readablePartial, int i, int[] iArr, int i2) {
        throw unsupported();
    }

    public long set(long j, String str, Locale locale) {
        throw unsupported();
    }

    public long set(long j, String str) {
        throw unsupported();
    }

    public int[] set(ReadablePartial readablePartial, int i, int[] iArr, String str, Locale locale) {
        throw unsupported();
    }

    public DurationField getDurationField() {
        return this.iDurationField;
    }

    public DurationField getRangeDurationField() {
        return null;
    }

    public boolean isLeap(long j) {
        throw unsupported();
    }

    public int getLeapAmount(long j) {
        throw unsupported();
    }

    public DurationField getLeapDurationField() {
        return null;
    }

    public int getMinimumValue() {
        throw unsupported();
    }

    public int getMinimumValue(long j) {
        throw unsupported();
    }

    public int getMinimumValue(ReadablePartial readablePartial) {
        throw unsupported();
    }

    public int getMinimumValue(ReadablePartial readablePartial, int[] iArr) {
        throw unsupported();
    }

    public int getMaximumValue() {
        throw unsupported();
    }

    public int getMaximumValue(long j) {
        throw unsupported();
    }

    public int getMaximumValue(ReadablePartial readablePartial) {
        throw unsupported();
    }

    public int getMaximumValue(ReadablePartial readablePartial, int[] iArr) {
        throw unsupported();
    }

    public int getMaximumTextLength(Locale locale) {
        throw unsupported();
    }

    public int getMaximumShortTextLength(Locale locale) {
        throw unsupported();
    }

    public long roundFloor(long j) {
        throw unsupported();
    }

    public long roundCeiling(long j) {
        throw unsupported();
    }

    public long roundHalfFloor(long j) {
        throw unsupported();
    }

    public long roundHalfCeiling(long j) {
        throw unsupported();
    }

    public long roundHalfEven(long j) {
        throw unsupported();
    }

    public long remainder(long j) {
        throw unsupported();
    }

    public String toString() {
        return "UnsupportedDateTimeField";
    }

    private Object readResolve() {
        return getInstance(this.iType, this.iDurationField);
    }

    private UnsupportedOperationException unsupported() {
        return new UnsupportedOperationException(this.iType + " field is unsupported");
    }
}
