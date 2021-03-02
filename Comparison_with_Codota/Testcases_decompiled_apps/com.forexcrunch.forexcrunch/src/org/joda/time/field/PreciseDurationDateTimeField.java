package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public abstract class PreciseDurationDateTimeField extends BaseDateTimeField {
    private static final long serialVersionUID = 5004523158306266035L;
    private final DurationField iUnitField;
    final long iUnitMillis;

    public PreciseDurationDateTimeField(DateTimeFieldType dateTimeFieldType, DurationField durationField) {
        super(dateTimeFieldType);
        if (!durationField.isPrecise()) {
            throw new IllegalArgumentException("Unit duration field must be precise");
        }
        this.iUnitMillis = durationField.getUnitMillis();
        if (this.iUnitMillis < 1) {
            throw new IllegalArgumentException("The unit milliseconds must be at least 1");
        }
        this.iUnitField = durationField;
    }

    public boolean isLenient() {
        return false;
    }

    public long set(long j, int i) {
        FieldUtils.verifyValueBounds((DateTimeField) this, i, getMinimumValue(), getMaximumValueForSet(j, i));
        return (((long) (i - get(j))) * this.iUnitMillis) + j;
    }

    public long roundFloor(long j) {
        if (j >= 0) {
            return j - (j % this.iUnitMillis);
        }
        long j2 = 1 + j;
        return (j2 - (j2 % this.iUnitMillis)) - this.iUnitMillis;
    }

    public long roundCeiling(long j) {
        if (j <= 0) {
            return j - (j % this.iUnitMillis);
        }
        long j2 = j - 1;
        return (j2 - (j2 % this.iUnitMillis)) + this.iUnitMillis;
    }

    public long remainder(long j) {
        if (j >= 0) {
            return j % this.iUnitMillis;
        }
        return (((j + 1) % this.iUnitMillis) + this.iUnitMillis) - 1;
    }

    public DurationField getDurationField() {
        return this.iUnitField;
    }

    public int getMinimumValue() {
        return 0;
    }

    public final long getUnitMillis() {
        return this.iUnitMillis;
    }

    /* access modifiers changed from: protected */
    public int getMaximumValueForSet(long j, int i) {
        return getMaximumValue(j);
    }
}
