package org.joda.time.field;

import java.io.Serializable;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public final class MillisDurationField extends DurationField implements Serializable {
    public static final DurationField INSTANCE = new MillisDurationField();
    private static final long serialVersionUID = 2656707858124633367L;

    private MillisDurationField() {
    }

    public DurationFieldType getType() {
        return DurationFieldType.millis();
    }

    public String getName() {
        return "millis";
    }

    public boolean isSupported() {
        return true;
    }

    public final boolean isPrecise() {
        return true;
    }

    public final long getUnitMillis() {
        return 1;
    }

    public int getValue(long j) {
        return FieldUtils.safeToInt(j);
    }

    public long getValueAsLong(long j) {
        return j;
    }

    public int getValue(long j, long j2) {
        return FieldUtils.safeToInt(j);
    }

    public long getValueAsLong(long j, long j2) {
        return j;
    }

    public long getMillis(int i) {
        return (long) i;
    }

    public long getMillis(long j) {
        return j;
    }

    public long getMillis(int i, long j) {
        return (long) i;
    }

    public long getMillis(long j, long j2) {
        return j;
    }

    public long add(long j, int i) {
        return FieldUtils.safeAdd(j, (long) i);
    }

    public long add(long j, long j2) {
        return FieldUtils.safeAdd(j, j2);
    }

    public int getDifference(long j, long j2) {
        return FieldUtils.safeToInt(FieldUtils.safeSubtract(j, j2));
    }

    public long getDifferenceAsLong(long j, long j2) {
        return FieldUtils.safeSubtract(j, j2);
    }

    public int compareTo(DurationField durationField) {
        long unitMillis = durationField.getUnitMillis();
        long unitMillis2 = getUnitMillis();
        if (unitMillis2 == unitMillis) {
            return 0;
        }
        if (unitMillis2 < unitMillis) {
            return -1;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MillisDurationField) || getUnitMillis() != ((MillisDurationField) obj).getUnitMillis()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (int) getUnitMillis();
    }

    public String toString() {
        return "DurationField[millis]";
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
