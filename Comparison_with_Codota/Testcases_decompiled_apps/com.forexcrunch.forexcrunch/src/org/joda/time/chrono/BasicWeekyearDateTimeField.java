package org.joda.time.chrono;

import com.google.android.gcm.GCMRegistrar;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.ImpreciseDateTimeField;

final class BasicWeekyearDateTimeField extends ImpreciseDateTimeField {
    private static final long WEEK_53 = 31449600000L;
    private static final long serialVersionUID = 6215066916806820644L;
    private final BasicChronology iChronology;

    BasicWeekyearDateTimeField(BasicChronology basicChronology) {
        super(DateTimeFieldType.weekyear(), basicChronology.getAverageMillisPerYear());
        this.iChronology = basicChronology;
    }

    public boolean isLenient() {
        return false;
    }

    public int get(long j) {
        return this.iChronology.getWeekyear(j);
    }

    public long add(long j, int i) {
        return i == 0 ? j : set(j, get(j) + i);
    }

    public long add(long j, long j2) {
        return add(j, FieldUtils.safeToInt(j2));
    }

    public long addWrapField(long j, int i) {
        return add(j, i);
    }

    public long getDifferenceAsLong(long j, long j2) {
        long j3;
        if (j < j2) {
            return (long) (-getDifference(j2, j));
        }
        int i = get(j);
        int i2 = get(j2);
        long remainder = remainder(j);
        long remainder2 = remainder(j2);
        if (remainder2 < WEEK_53 || this.iChronology.getWeeksInYear(i) > 52) {
            j3 = remainder2;
        } else {
            j3 = remainder2 - GCMRegistrar.DEFAULT_ON_SERVER_LIFESPAN_MS;
        }
        int i3 = i - i2;
        if (remainder < j3) {
            i3--;
        }
        return (long) i3;
    }

    public long set(long j, int i) {
        FieldUtils.verifyValueBounds((DateTimeField) this, Math.abs(i), this.iChronology.getMinYear(), this.iChronology.getMaxYear());
        int i2 = get(j);
        if (i2 == i) {
            return j;
        }
        int dayOfWeek = this.iChronology.getDayOfWeek(j);
        int weeksInYear = this.iChronology.getWeeksInYear(i2);
        int weeksInYear2 = this.iChronology.getWeeksInYear(i);
        if (weeksInYear2 >= weeksInYear) {
            weeksInYear2 = weeksInYear;
        }
        int weekOfWeekyear = this.iChronology.getWeekOfWeekyear(j);
        if (weekOfWeekyear <= weeksInYear2) {
            weeksInYear2 = weekOfWeekyear;
        }
        long year = this.iChronology.setYear(j, i);
        int i3 = get(year);
        if (i3 < i) {
            year += GCMRegistrar.DEFAULT_ON_SERVER_LIFESPAN_MS;
        } else if (i3 > i) {
            year -= GCMRegistrar.DEFAULT_ON_SERVER_LIFESPAN_MS;
        }
        return this.iChronology.dayOfWeek().set(year + (((long) (weeksInYear2 - this.iChronology.getWeekOfWeekyear(year))) * GCMRegistrar.DEFAULT_ON_SERVER_LIFESPAN_MS), dayOfWeek);
    }

    public DurationField getRangeDurationField() {
        return null;
    }

    public boolean isLeap(long j) {
        return this.iChronology.getWeeksInYear(this.iChronology.getWeekyear(j)) > 52;
    }

    public int getLeapAmount(long j) {
        return this.iChronology.getWeeksInYear(this.iChronology.getWeekyear(j)) - 52;
    }

    public DurationField getLeapDurationField() {
        return this.iChronology.weeks();
    }

    public int getMinimumValue() {
        return this.iChronology.getMinYear();
    }

    public int getMaximumValue() {
        return this.iChronology.getMaxYear();
    }

    public long roundFloor(long j) {
        long roundFloor = this.iChronology.weekOfWeekyear().roundFloor(j);
        int weekOfWeekyear = this.iChronology.getWeekOfWeekyear(roundFloor);
        if (weekOfWeekyear > 1) {
            return roundFloor - (GCMRegistrar.DEFAULT_ON_SERVER_LIFESPAN_MS * ((long) (weekOfWeekyear - 1)));
        }
        return roundFloor;
    }

    public long remainder(long j) {
        return j - roundFloor(j);
    }

    private Object readResolve() {
        return this.iChronology.weekyear();
    }
}
