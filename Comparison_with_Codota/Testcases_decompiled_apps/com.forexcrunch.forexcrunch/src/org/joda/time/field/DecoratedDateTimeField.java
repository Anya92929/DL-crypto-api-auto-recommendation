package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public abstract class DecoratedDateTimeField extends BaseDateTimeField {
    private static final long serialVersionUID = 203115783733757597L;
    private final DateTimeField iField;

    protected DecoratedDateTimeField(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType) {
        super(dateTimeFieldType);
        if (dateTimeField == null) {
            throw new IllegalArgumentException("The field must not be null");
        } else if (!dateTimeField.isSupported()) {
            throw new IllegalArgumentException("The field must be supported");
        } else {
            this.iField = dateTimeField;
        }
    }

    public final DateTimeField getWrappedField() {
        return this.iField;
    }

    public boolean isLenient() {
        return this.iField.isLenient();
    }

    public int get(long j) {
        return this.iField.get(j);
    }

    public long set(long j, int i) {
        return this.iField.set(j, i);
    }

    public DurationField getDurationField() {
        return this.iField.getDurationField();
    }

    public DurationField getRangeDurationField() {
        return this.iField.getRangeDurationField();
    }

    public int getMinimumValue() {
        return this.iField.getMinimumValue();
    }

    public int getMaximumValue() {
        return this.iField.getMaximumValue();
    }

    public long roundFloor(long j) {
        return this.iField.roundFloor(j);
    }
}
