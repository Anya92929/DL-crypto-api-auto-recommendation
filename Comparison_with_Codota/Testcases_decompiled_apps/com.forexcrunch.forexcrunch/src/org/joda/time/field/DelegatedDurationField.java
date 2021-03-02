package org.joda.time.field;

import java.io.Serializable;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public class DelegatedDurationField extends DurationField implements Serializable {
    private static final long serialVersionUID = -5576443481242007829L;
    private final DurationField iField;
    private final DurationFieldType iType;

    protected DelegatedDurationField(DurationField durationField) {
        this(durationField, (DurationFieldType) null);
    }

    protected DelegatedDurationField(DurationField durationField, DurationFieldType durationFieldType) {
        if (durationField == null) {
            throw new IllegalArgumentException("The field must not be null");
        }
        this.iField = durationField;
        this.iType = durationFieldType == null ? durationField.getType() : durationFieldType;
    }

    public final DurationField getWrappedField() {
        return this.iField;
    }

    public DurationFieldType getType() {
        return this.iType;
    }

    public String getName() {
        return this.iType.getName();
    }

    public boolean isSupported() {
        return this.iField.isSupported();
    }

    public boolean isPrecise() {
        return this.iField.isPrecise();
    }

    public int getValue(long j) {
        return this.iField.getValue(j);
    }

    public long getValueAsLong(long j) {
        return this.iField.getValueAsLong(j);
    }

    public int getValue(long j, long j2) {
        return this.iField.getValue(j, j2);
    }

    public long getValueAsLong(long j, long j2) {
        return this.iField.getValueAsLong(j, j2);
    }

    public long getMillis(int i) {
        return this.iField.getMillis(i);
    }

    public long getMillis(long j) {
        return this.iField.getMillis(j);
    }

    public long getMillis(int i, long j) {
        return this.iField.getMillis(i, j);
    }

    public long getMillis(long j, long j2) {
        return this.iField.getMillis(j, j2);
    }

    public long add(long j, int i) {
        return this.iField.add(j, i);
    }

    public long add(long j, long j2) {
        return this.iField.add(j, j2);
    }

    public int getDifference(long j, long j2) {
        return this.iField.getDifference(j, j2);
    }

    public long getDifferenceAsLong(long j, long j2) {
        return this.iField.getDifferenceAsLong(j, j2);
    }

    public long getUnitMillis() {
        return this.iField.getUnitMillis();
    }

    public int compareTo(DurationField durationField) {
        return this.iField.compareTo(durationField);
    }

    public boolean equals(Object obj) {
        if (obj instanceof DelegatedDurationField) {
            return this.iField.equals(((DelegatedDurationField) obj).iField);
        }
        return false;
    }

    public int hashCode() {
        return this.iField.hashCode() ^ this.iType.hashCode();
    }

    public String toString() {
        return this.iType == null ? this.iField.toString() : "DurationField[" + this.iType + ']';
    }
}
