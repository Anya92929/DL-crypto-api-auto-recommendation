package org.joda.time.chrono;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.ImpreciseDateTimeField;

class BasicYearDateTimeField extends ImpreciseDateTimeField {
    private static final long serialVersionUID = -98628754872287L;
    protected final BasicChronology iChronology;

    BasicYearDateTimeField(BasicChronology basicChronology) {
        super(DateTimeFieldType.year(), basicChronology.getAverageMillisPerYear());
        this.iChronology = basicChronology;
    }

    public boolean isLenient() {
        return false;
    }

    public int get(long j) {
        return this.iChronology.getYear(j);
    }

    public long add(long j, int i) {
        return i == 0 ? j : set(j, FieldUtils.safeAdd(get(j), i));
    }

    public long add(long j, long j2) {
        return add(j, FieldUtils.safeToInt(j2));
    }

    public long addWrapField(long j, int i) {
        return i == 0 ? j : set(j, FieldUtils.getWrappedValue(this.iChronology.getYear(j), i, this.iChronology.getMinYear(), this.iChronology.getMaxYear()));
    }

    public long set(long j, int i) {
        FieldUtils.verifyValueBounds((DateTimeField) this, i, this.iChronology.getMinYear(), this.iChronology.getMaxYear());
        return this.iChronology.setYear(j, i);
    }

    public long getDifferenceAsLong(long j, long j2) {
        if (j < j2) {
            return -this.iChronology.getYearDifference(j2, j);
        }
        return this.iChronology.getYearDifference(j, j2);
    }

    public DurationField getRangeDurationField() {
        return null;
    }

    public boolean isLeap(long j) {
        return this.iChronology.isLeapYear(get(j));
    }

    public int getLeapAmount(long j) {
        if (this.iChronology.isLeapYear(get(j))) {
            return 1;
        }
        return 0;
    }

    public DurationField getLeapDurationField() {
        return this.iChronology.days();
    }

    public int getMinimumValue() {
        return this.iChronology.getMinYear();
    }

    public int getMaximumValue() {
        return this.iChronology.getMaxYear();
    }

    public long roundFloor(long j) {
        return this.iChronology.getYearMillis(get(j));
    }

    public long roundCeiling(long j) {
        int i = get(j);
        if (j != this.iChronology.getYearMillis(i)) {
            return this.iChronology.getYearMillis(i + 1);
        }
        return j;
    }

    public long remainder(long j) {
        return j - roundFloor(j);
    }

    private Object readResolve() {
        return this.iChronology.year();
    }
}
