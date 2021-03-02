package org.joda.time.chrono;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.achartengine.chart.TimeChart;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableDateTime;
import org.joda.time.chrono.AssembledChronology;

public final class IslamicChronology extends BasicChronology {

    /* renamed from: AH */
    public static final int f1780AH = 1;
    private static final int CYCLE = 30;
    private static final DateTimeField ERA_FIELD = new BasicSingleEraDateTimeField("AH");
    private static final IslamicChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);
    public static final LeapYearPatternType LEAP_YEAR_15_BASED = new LeapYearPatternType(0, 623158436);
    public static final LeapYearPatternType LEAP_YEAR_16_BASED = new LeapYearPatternType(1, 623191204);
    public static final LeapYearPatternType LEAP_YEAR_HABASH_AL_HASIB = new LeapYearPatternType(3, 153692453);
    public static final LeapYearPatternType LEAP_YEAR_INDIAN = new LeapYearPatternType(2, 690562340);
    private static final int LONG_MONTH_LENGTH = 30;
    private static final int MAX_YEAR = 292271022;
    private static final long MILLIS_PER_CYCLE = 918518400000L;
    private static final long MILLIS_PER_LONG_MONTH = 2592000000L;
    private static final long MILLIS_PER_LONG_YEAR = 30672000000L;
    private static final long MILLIS_PER_MONTH = 2551440384L;
    private static final long MILLIS_PER_MONTH_PAIR = 5097600000L;
    private static final long MILLIS_PER_SHORT_YEAR = 30585600000L;
    private static final long MILLIS_PER_YEAR = 30617280288L;
    private static final long MILLIS_YEAR_1 = -42521587200000L;
    private static final int MIN_YEAR = -292269337;
    private static final int MONTH_PAIR_LENGTH = 59;
    private static final int SHORT_MONTH_LENGTH = 29;
    private static final Map<DateTimeZone, IslamicChronology[]> cCache = new HashMap();
    private static final long serialVersionUID = -3663823829888L;
    private final LeapYearPatternType iLeapYears;

    public static IslamicChronology getInstanceUTC() {
        return INSTANCE_UTC;
    }

    public static IslamicChronology getInstance() {
        return getInstance(DateTimeZone.getDefault(), LEAP_YEAR_16_BASED);
    }

    public static IslamicChronology getInstance(DateTimeZone dateTimeZone) {
        return getInstance(dateTimeZone, LEAP_YEAR_16_BASED);
    }

    public static IslamicChronology getInstance(DateTimeZone dateTimeZone, LeapYearPatternType leapYearPatternType) {
        IslamicChronology islamicChronology;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        synchronized (cCache) {
            IslamicChronology[] islamicChronologyArr = cCache.get(dateTimeZone);
            if (islamicChronologyArr == null) {
                islamicChronologyArr = new IslamicChronology[4];
                cCache.put(dateTimeZone, islamicChronologyArr);
            }
            IslamicChronology[] islamicChronologyArr2 = islamicChronologyArr;
            islamicChronology = islamicChronologyArr2[leapYearPatternType.index];
            if (islamicChronology == null) {
                if (dateTimeZone == DateTimeZone.UTC) {
                    IslamicChronology islamicChronology2 = new IslamicChronology((Chronology) null, (Object) null, leapYearPatternType);
                    islamicChronology = new IslamicChronology(LimitChronology.getInstance(islamicChronology2, new DateTime(1, 1, 1, 0, 0, 0, 0, (Chronology) islamicChronology2), (ReadableDateTime) null), (Object) null, leapYearPatternType);
                } else {
                    islamicChronology = new IslamicChronology(ZonedChronology.getInstance(getInstance(DateTimeZone.UTC, leapYearPatternType), dateTimeZone), (Object) null, leapYearPatternType);
                }
                islamicChronologyArr2[leapYearPatternType.index] = islamicChronology;
            }
        }
        return islamicChronology;
    }

    IslamicChronology(Chronology chronology, Object obj, LeapYearPatternType leapYearPatternType) {
        super(chronology, obj, 4);
        this.iLeapYears = leapYearPatternType;
    }

    private Object readResolve() {
        Chronology base = getBase();
        return base == null ? getInstanceUTC() : getInstance(base.getZone());
    }

    public LeapYearPatternType getLeapYearPatternType() {
        return this.iLeapYears;
    }

    public Chronology withUTC() {
        return INSTANCE_UTC;
    }

    public Chronology withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return dateTimeZone == getZone() ? this : getInstance(dateTimeZone);
    }

    public int hashCode() {
        return (super.hashCode() * 13) + getLeapYearPatternType().hashCode();
    }

    /* access modifiers changed from: package-private */
    public int getYear(long j) {
        long j2;
        long j3;
        long j4 = j - MILLIS_YEAR_1;
        long j5 = j4 / MILLIS_PER_CYCLE;
        long j6 = j4 % MILLIS_PER_CYCLE;
        int i = (int) ((30 * j5) + 1);
        if (isLeapYear(i)) {
            j2 = 30672000000L;
        } else {
            j2 = 30585600000L;
        }
        while (j6 >= j2) {
            j6 -= j2;
            i++;
            if (isLeapYear(i)) {
                j3 = 30672000000L;
            } else {
                j3 = 30585600000L;
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public long setYear(long j, int i) {
        int dayOfYear = getDayOfYear(j, getYear(j));
        int millisOfDay = getMillisOfDay(j);
        if (dayOfYear > 354 && !isLeapYear(i)) {
            dayOfYear--;
        }
        return ((long) millisOfDay) + getYearMonthDayMillis(i, 1, dayOfYear);
    }

    /* access modifiers changed from: package-private */
    public long getYearDifference(long j, long j2) {
        int year = getYear(j);
        int year2 = getYear(j2);
        int i = year - year2;
        if (j - getYearMillis(year) < j2 - getYearMillis(year2)) {
            i--;
        }
        return (long) i;
    }

    /* access modifiers changed from: package-private */
    public long getTotalMillisByYearMonth(int i, int i2) {
        int i3 = i2 - 1;
        if (i3 % 2 == 1) {
            return (((long) (i3 / 2)) * MILLIS_PER_MONTH_PAIR) + MILLIS_PER_LONG_MONTH;
        }
        return ((long) (i3 / 2)) * MILLIS_PER_MONTH_PAIR;
    }

    /* access modifiers changed from: package-private */
    public int getDayOfMonth(long j) {
        int dayOfYear = getDayOfYear(j) - 1;
        if (dayOfYear == 354) {
            return 30;
        }
        return ((dayOfYear % 59) % 30) + 1;
    }

    /* access modifiers changed from: package-private */
    public boolean isLeapYear(int i) {
        return this.iLeapYears.isLeapYear(i);
    }

    /* access modifiers changed from: package-private */
    public int getDaysInYearMax() {
        return 355;
    }

    /* access modifiers changed from: package-private */
    public int getDaysInYear(int i) {
        return isLeapYear(i) ? 355 : 354;
    }

    /* access modifiers changed from: package-private */
    public int getDaysInYearMonth(int i, int i2) {
        if ((i2 != 12 || !isLeapYear(i)) && (i2 - 1) % 2 != 0) {
            return 29;
        }
        return 30;
    }

    /* access modifiers changed from: package-private */
    public int getDaysInMonthMax() {
        return 30;
    }

    /* access modifiers changed from: package-private */
    public int getDaysInMonthMax(int i) {
        if (i == 12 || (i - 1) % 2 == 0) {
            return 30;
        }
        return 29;
    }

    /* access modifiers changed from: package-private */
    public int getMonthOfYear(long j, int i) {
        int yearMillis = (int) ((j - getYearMillis(i)) / TimeChart.DAY);
        if (yearMillis == 354) {
            return 12;
        }
        return ((yearMillis * 2) / 59) + 1;
    }

    /* access modifiers changed from: package-private */
    public long getAverageMillisPerYear() {
        return MILLIS_PER_YEAR;
    }

    /* access modifiers changed from: package-private */
    public long getAverageMillisPerYearDividedByTwo() {
        return 15308640144L;
    }

    /* access modifiers changed from: package-private */
    public long getAverageMillisPerMonth() {
        return MILLIS_PER_MONTH;
    }

    /* access modifiers changed from: package-private */
    public long calculateFirstDayOfYearMillis(int i) {
        if (i > MAX_YEAR) {
            throw new ArithmeticException("Year is too large: " + i + " > " + MAX_YEAR);
        } else if (i < MIN_YEAR) {
            throw new ArithmeticException("Year is too small: " + i + " < " + MIN_YEAR);
        } else {
            int i2 = i - 1;
            int i3 = (i2 % 30) + 1;
            long j = (((long) (i2 / 30)) * MILLIS_PER_CYCLE) + MILLIS_YEAR_1;
            for (int i4 = 1; i4 < i3; i4++) {
                j += isLeapYear(i4) ? MILLIS_PER_LONG_YEAR : MILLIS_PER_SHORT_YEAR;
            }
            return j;
        }
    }

    /* access modifiers changed from: package-private */
    public int getMinYear() {
        return 1;
    }

    /* access modifiers changed from: package-private */
    public int getMaxYear() {
        return MAX_YEAR;
    }

    /* access modifiers changed from: package-private */
    public long getApproxMillisAtEpochDividedByTwo() {
        return 21260793600000L;
    }

    /* access modifiers changed from: protected */
    public void assemble(AssembledChronology.Fields fields) {
        if (getBase() == null) {
            super.assemble(fields);
            fields.era = ERA_FIELD;
            fields.monthOfYear = new BasicMonthOfYearDateTimeField(this, 12);
            fields.months = fields.monthOfYear.getDurationField();
        }
    }

    public static class LeapYearPatternType implements Serializable {
        private static final long serialVersionUID = 26581275372698L;
        final byte index;
        final int pattern;

        LeapYearPatternType(int i, int i2) {
            this.index = (byte) i;
            this.pattern = i2;
        }

        /* access modifiers changed from: package-private */
        public boolean isLeapYear(int i) {
            if (((1 << (i % 30)) & this.pattern) > 0) {
                return true;
            }
            return false;
        }

        private Object readResolve() {
            switch (this.index) {
                case 0:
                    return IslamicChronology.LEAP_YEAR_15_BASED;
                case 1:
                    return IslamicChronology.LEAP_YEAR_16_BASED;
                case 2:
                    return IslamicChronology.LEAP_YEAR_INDIAN;
                case 3:
                    return IslamicChronology.LEAP_YEAR_HABASH_AL_HASIB;
                default:
                    return this;
            }
        }
    }
}
