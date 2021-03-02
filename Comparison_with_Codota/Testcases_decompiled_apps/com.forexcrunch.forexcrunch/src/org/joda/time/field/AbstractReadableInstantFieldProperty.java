package org.joda.time.field;

import java.io.Serializable;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DurationField;
import org.joda.time.Interval;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;

public abstract class AbstractReadableInstantFieldProperty implements Serializable {
    private static final long serialVersionUID = 1971226328211649661L;

    public abstract DateTimeField getField();

    /* access modifiers changed from: protected */
    public abstract long getMillis();

    public DateTimeFieldType getFieldType() {
        return getField().getType();
    }

    public String getName() {
        return getField().getName();
    }

    /* access modifiers changed from: protected */
    public Chronology getChronology() {
        throw new UnsupportedOperationException("The method getChronology() was added in v1.4 and needs to be implemented by subclasses of AbstractReadableInstantFieldProperty");
    }

    public int get() {
        return getField().get(getMillis());
    }

    public String getAsString() {
        return Integer.toString(get());
    }

    public String getAsText() {
        return getAsText((Locale) null);
    }

    public String getAsText(Locale locale) {
        return getField().getAsText(getMillis(), locale);
    }

    public String getAsShortText() {
        return getAsShortText((Locale) null);
    }

    public String getAsShortText(Locale locale) {
        return getField().getAsShortText(getMillis(), locale);
    }

    public int getDifference(ReadableInstant readableInstant) {
        if (readableInstant == null) {
            return getField().getDifference(getMillis(), DateTimeUtils.currentTimeMillis());
        }
        return getField().getDifference(getMillis(), readableInstant.getMillis());
    }

    public long getDifferenceAsLong(ReadableInstant readableInstant) {
        if (readableInstant == null) {
            return getField().getDifferenceAsLong(getMillis(), DateTimeUtils.currentTimeMillis());
        }
        return getField().getDifferenceAsLong(getMillis(), readableInstant.getMillis());
    }

    public DurationField getDurationField() {
        return getField().getDurationField();
    }

    public DurationField getRangeDurationField() {
        return getField().getRangeDurationField();
    }

    public boolean isLeap() {
        return getField().isLeap(getMillis());
    }

    public int getLeapAmount() {
        return getField().getLeapAmount(getMillis());
    }

    public DurationField getLeapDurationField() {
        return getField().getLeapDurationField();
    }

    public int getMinimumValueOverall() {
        return getField().getMinimumValue();
    }

    public int getMinimumValue() {
        return getField().getMinimumValue(getMillis());
    }

    public int getMaximumValueOverall() {
        return getField().getMaximumValue();
    }

    public int getMaximumValue() {
        return getField().getMaximumValue(getMillis());
    }

    public int getMaximumTextLength(Locale locale) {
        return getField().getMaximumTextLength(locale);
    }

    public int getMaximumShortTextLength(Locale locale) {
        return getField().getMaximumShortTextLength(locale);
    }

    public long remainder() {
        return getField().remainder(getMillis());
    }

    public Interval toInterval() {
        DateTimeField field = getField();
        long roundFloor = field.roundFloor(getMillis());
        return new Interval(roundFloor, field.add(roundFloor, 1));
    }

    public int compareTo(ReadableInstant readableInstant) {
        if (readableInstant == null) {
            throw new IllegalArgumentException("The instant must not be null");
        }
        int i = get();
        int i2 = readableInstant.get(getFieldType());
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        return 0;
    }

    public int compareTo(ReadablePartial readablePartial) {
        if (readablePartial == null) {
            throw new IllegalArgumentException("The partial must not be null");
        }
        int i = get();
        int i2 = readablePartial.get(getFieldType());
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractReadableInstantFieldProperty)) {
            return false;
        }
        AbstractReadableInstantFieldProperty abstractReadableInstantFieldProperty = (AbstractReadableInstantFieldProperty) obj;
        if (get() != abstractReadableInstantFieldProperty.get() || !getFieldType().equals(abstractReadableInstantFieldProperty.getFieldType()) || !FieldUtils.equals(getChronology(), abstractReadableInstantFieldProperty.getChronology())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (get() * 17) + getFieldType().hashCode() + getChronology().hashCode();
    }

    public String toString() {
        return "Property[" + getName() + "]";
    }
}
