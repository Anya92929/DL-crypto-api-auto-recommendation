package org.joda.time.chrono;

import org.achartengine.chart.TimeChart;
import org.joda.time.Chronology;

abstract class BasicGJChronology extends BasicChronology {
    private static final long FEB_29 = 5097600000L;
    private static final int[] MAX_DAYS_PER_MONTH_ARRAY = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final long[] MAX_TOTAL_MILLIS_BY_MONTH_ARRAY = new long[12];
    private static final int[] MIN_DAYS_PER_MONTH_ARRAY = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final long[] MIN_TOTAL_MILLIS_BY_MONTH_ARRAY = new long[12];
    private static final long serialVersionUID = 538276888268L;

    static {
        long j = 0;
        long j2 = 0;
        for (int i = 0; i < 11; i++) {
            j2 += ((long) MIN_DAYS_PER_MONTH_ARRAY[i]) * TimeChart.DAY;
            MIN_TOTAL_MILLIS_BY_MONTH_ARRAY[i + 1] = j2;
            j += ((long) MAX_DAYS_PER_MONTH_ARRAY[i]) * TimeChart.DAY;
            MAX_TOTAL_MILLIS_BY_MONTH_ARRAY[i + 1] = j;
        }
    }

    BasicGJChronology(Chronology chronology, Object obj, int i) {
        super(chronology, obj, i);
    }

    /* access modifiers changed from: package-private */
    public int getMonthOfYear(long j, int i) {
        int yearMillis = (int) ((j - getYearMillis(i)) >> 10);
        if (isLeapYear(i)) {
            if (yearMillis < 15356250) {
                if (yearMillis < 7678125) {
                    if (yearMillis < 2615625) {
                        return 1;
                    }
                    return yearMillis < 5062500 ? 2 : 3;
                } else if (yearMillis < 10209375) {
                    return 4;
                } else {
                    return yearMillis < 12825000 ? 5 : 6;
                }
            } else if (yearMillis < 23118750) {
                if (yearMillis < 17971875) {
                    return 7;
                }
                return yearMillis < 20587500 ? 8 : 9;
            } else if (yearMillis < 25734375) {
                return 10;
            } else {
                return yearMillis < 28265625 ? 11 : 12;
            }
        } else if (yearMillis < 15271875) {
            if (yearMillis < 7593750) {
                if (yearMillis >= 2615625) {
                    return yearMillis < 4978125 ? 2 : 3;
                }
                return 1;
            } else if (yearMillis < 10125000) {
                return 4;
            } else {
                return yearMillis < 12740625 ? 5 : 6;
            }
        } else if (yearMillis < 23034375) {
            if (yearMillis < 17887500) {
                return 7;
            }
            return yearMillis < 20503125 ? 8 : 9;
        } else if (yearMillis < 25650000) {
            return 10;
        } else {
            return yearMillis < 28181250 ? 11 : 12;
        }
    }

    /* access modifiers changed from: package-private */
    public int getDaysInYearMonth(int i, int i2) {
        if (isLeapYear(i)) {
            return MAX_DAYS_PER_MONTH_ARRAY[i2 - 1];
        }
        return MIN_DAYS_PER_MONTH_ARRAY[i2 - 1];
    }

    /* access modifiers changed from: package-private */
    public int getDaysInMonthMax(int i) {
        return MAX_DAYS_PER_MONTH_ARRAY[i - 1];
    }

    /* access modifiers changed from: package-private */
    public int getDaysInMonthMaxForSet(long j, int i) {
        if (i > 28 || i < 1) {
            return getDaysInMonthMax(j);
        }
        return 28;
    }

    /* access modifiers changed from: package-private */
    public long getTotalMillisByYearMonth(int i, int i2) {
        if (isLeapYear(i)) {
            return MAX_TOTAL_MILLIS_BY_MONTH_ARRAY[i2 - 1];
        }
        return MIN_TOTAL_MILLIS_BY_MONTH_ARRAY[i2 - 1];
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getYearDifference(long r16, long r18) {
        /*
            r15 = this;
            int r7 = r15.getYear(r16)
            r0 = r18
            int r8 = r15.getYear(r0)
            long r2 = r15.getYearMillis(r7)
            long r4 = r16 - r2
            long r2 = r15.getYearMillis(r8)
            long r2 = r18 - r2
            r9 = 5097600000(0x12fd73400, double:2.518549036E-314)
            int r6 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r6 < 0) goto L_0x0055
            boolean r6 = r15.isLeapYear(r8)
            if (r6 == 0) goto L_0x003d
            boolean r6 = r15.isLeapYear(r7)
            if (r6 != 0) goto L_0x0055
            r9 = 86400000(0x5265c00, double:4.2687272E-316)
            long r2 = r2 - r9
            r11 = r2
            r13 = r4
            r5 = r13
            r3 = r11
        L_0x0033:
            int r2 = r7 - r8
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x003b
            int r2 = r2 + -1
        L_0x003b:
            long r2 = (long) r2
            return r2
        L_0x003d:
            r9 = 5097600000(0x12fd73400, double:2.518549036E-314)
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r6 < 0) goto L_0x0055
            boolean r6 = r15.isLeapYear(r7)
            if (r6 == 0) goto L_0x0055
            r9 = 86400000(0x5265c00, double:4.2687272E-316)
            long r4 = r4 - r9
            r11 = r2
            r13 = r4
            r5 = r13
            r3 = r11
            goto L_0x0033
        L_0x0055:
            r11 = r2
            r13 = r4
            r5 = r13
            r3 = r11
            goto L_0x0033
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.chrono.BasicGJChronology.getYearDifference(long, long):long");
    }

    /* access modifiers changed from: package-private */
    public long setYear(long j, int i) {
        int year = getYear(j);
        int dayOfYear = getDayOfYear(j, year);
        int millisOfDay = getMillisOfDay(j);
        if (dayOfYear > 59) {
            if (isLeapYear(year)) {
                if (!isLeapYear(i)) {
                    dayOfYear--;
                }
            } else if (isLeapYear(i)) {
                dayOfYear++;
            }
        }
        return getYearMonthDayMillis(i, 1, dayOfYear) + ((long) millisOfDay);
    }
}
