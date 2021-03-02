package org.joda.time.field;

import java.util.Locale;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;

public abstract class AbstractPartialFieldProperty {
    public abstract int get();

    public abstract DateTimeField getField();

    /* access modifiers changed from: protected */
    public abstract ReadablePartial getReadablePartial();

    protected AbstractPartialFieldProperty() {
    }

    public DateTimeFieldType getFieldType() {
        return getField().getType();
    }

    public String getName() {
        return getField().getName();
    }

    public String getAsString() {
        return Integer.toString(get());
    }

    public String getAsText() {
        return getAsText((Locale) null);
    }

    public String getAsText(Locale locale) {
        return getField().getAsText(getReadablePartial(), get(), locale);
    }

    public String getAsShortText() {
        return getAsShortText((Locale) null);
    }

    public String getAsShortText(Locale locale) {
        return getField().getAsShortText(getReadablePartial(), get(), locale);
    }

    public DurationField getDurationField() {
        return getField().getDurationField();
    }

    public DurationField getRangeDurationField() {
        return getField().getRangeDurationField();
    }

    public int getMinimumValueOverall() {
        return getField().getMinimumValue();
    }

    public int getMinimumValue() {
        return getField().getMinimumValue(getReadablePartial());
    }

    public int getMaximumValueOverall() {
        return getField().getMaximumValue();
    }

    public int getMaximumValue() {
        return getField().getMaximumValue(getReadablePartial());
    }

    public int getMaximumTextLength(Locale locale) {
        return getField().getMaximumTextLength(locale);
    }

    public int getMaximumShortTextLength(Locale locale) {
        return getField().getMaximumShortTextLength(locale);
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
            throw new IllegalArgumentException("The instant must not be null");
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
        if (!(obj instanceof AbstractPartialFieldProperty)) {
            return false;
        }
        AbstractPartialFieldProperty abstractPartialFieldProperty = (AbstractPartialFieldProperty) obj;
        if (get() == abstractPartialFieldProperty.get() && getFieldType() == abstractPartialFieldProperty.getFieldType() && FieldUtils.equals(getReadablePartial().getChronology(), abstractPartialFieldProperty.getReadablePartial().getChronology())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((get() + 247) * 13) + getFieldType().hashCode()) * 13) + getReadablePartial().getChronology().hashCode();
    }

    public String toString() {
        return "Property[" + getName() + "]";
    }
}
