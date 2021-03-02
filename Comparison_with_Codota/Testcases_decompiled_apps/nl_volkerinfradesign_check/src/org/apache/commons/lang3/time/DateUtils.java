package org.apache.commons.lang3.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DateUtils {
    public static final long MILLIS_PER_DAY = 86400000;
    public static final long MILLIS_PER_HOUR = 3600000;
    public static final long MILLIS_PER_MINUTE = 60000;
    public static final long MILLIS_PER_SECOND = 1000;
    public static final int RANGE_MONTH_MONDAY = 6;
    public static final int RANGE_MONTH_SUNDAY = 5;
    public static final int RANGE_WEEK_CENTER = 4;
    public static final int RANGE_WEEK_MONDAY = 2;
    public static final int RANGE_WEEK_RELATIVE = 3;
    public static final int RANGE_WEEK_SUNDAY = 1;
    public static final int SEMI_MONTH = 1001;

    /* renamed from: a */
    private static final int[][] f7217a = {new int[]{14}, new int[]{13}, new int[]{12}, new int[]{11, 10}, new int[]{5, 5, 9}, new int[]{2, SEMI_MONTH}, new int[]{1}, new int[]{0}};

    public static boolean isSameDay(Date date, Date date2) {
        if (date == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        return isSameDay(instance, instance2);
    }

    public static boolean isSameDay(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isSameInstant(Date date, Date date2) {
        if (date != null && date2 != null) {
            return date.getTime() == date2.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean isSameInstant(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.getTime().getTime() == calendar2.getTime().getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean isSameLocalTime(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (calendar.get(14) == calendar2.get(14) && calendar.get(13) == calendar2.get(13) && calendar.get(12) == calendar2.get(12) && calendar.get(11) == calendar2.get(11) && calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1) && calendar.get(0) == calendar2.get(0) && calendar.getClass() == calendar2.getClass()) {
            return true;
        } else {
            return false;
        }
    }

    public static Date parseDate(String str, String... strArr) throws ParseException {
        return m7461a(str, strArr, true);
    }

    public static Date parseDateStrictly(String str, String... strArr) throws ParseException {
        return m7461a(str, strArr, false);
    }

    /* renamed from: a */
    private static Date m7461a(String str, String[] strArr, boolean z) throws ParseException {
        String str2;
        String str3;
        if (str == null || strArr == null) {
            throw new IllegalArgumentException("Date and Patterns must not be null");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.setLenient(z);
        ParsePosition parsePosition = new ParsePosition(0);
        for (String str4 : strArr) {
            if (str4.endsWith("ZZ")) {
                str2 = str4.substring(0, str4.length() - 1);
            } else {
                str2 = str4;
            }
            simpleDateFormat.applyPattern(str2);
            parsePosition.setIndex(0);
            if (str4.endsWith("ZZ")) {
                str3 = str.replaceAll("([-+][0-9][0-9]):([0-9][0-9])$", "$1$2");
            } else {
                str3 = str;
            }
            Date parse = simpleDateFormat.parse(str3, parsePosition);
            if (parse != null && parsePosition.getIndex() == str3.length()) {
                return parse;
            }
        }
        throw new ParseException("Unable to parse the date: " + str, -1);
    }

    public static Date addYears(Date date, int i) {
        return m7462a(date, 1, i);
    }

    public static Date addMonths(Date date, int i) {
        return m7462a(date, 2, i);
    }

    public static Date addWeeks(Date date, int i) {
        return m7462a(date, 3, i);
    }

    public static Date addDays(Date date, int i) {
        return m7462a(date, 5, i);
    }

    public static Date addHours(Date date, int i) {
        return m7462a(date, 11, i);
    }

    public static Date addMinutes(Date date, int i) {
        return m7462a(date, 12, i);
    }

    public static Date addSeconds(Date date, int i) {
        return m7462a(date, 13, i);
    }

    public static Date addMilliseconds(Date date, int i) {
        return m7462a(date, 14, i);
    }

    /* renamed from: a */
    private static Date m7462a(Date date, int i, int i2) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(i, i2);
        return instance.getTime();
    }

    public static Date setYears(Date date, int i) {
        return m7465b(date, 1, i);
    }

    public static Date setMonths(Date date, int i) {
        return m7465b(date, 2, i);
    }

    public static Date setDays(Date date, int i) {
        return m7465b(date, 5, i);
    }

    public static Date setHours(Date date, int i) {
        return m7465b(date, 11, i);
    }

    public static Date setMinutes(Date date, int i) {
        return m7465b(date, 12, i);
    }

    public static Date setSeconds(Date date, int i) {
        return m7465b(date, 13, i);
    }

    public static Date setMilliseconds(Date date, int i) {
        return m7465b(date, 14, i);
    }

    /* renamed from: b */
    private static Date m7465b(Date date, int i, int i2) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar instance = Calendar.getInstance();
        instance.setLenient(false);
        instance.setTime(date);
        instance.set(i, i2);
        return instance.getTime();
    }

    public static Calendar toCalendar(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance;
    }

    public static Date round(Date date, int i) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        m7463a(instance, i, 1);
        return instance.getTime();
    }

    public static Calendar round(Calendar calendar, int i) {
        if (calendar == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar calendar2 = (Calendar) calendar.clone();
        m7463a(calendar2, i, 1);
        return calendar2;
    }

    public static Date round(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return round((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return round((Calendar) obj, i).getTime();
            }
            throw new ClassCastException("Could not round " + obj);
        }
    }

    public static Date truncate(Date date, int i) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        m7463a(instance, i, 0);
        return instance.getTime();
    }

    public static Calendar truncate(Calendar calendar, int i) {
        if (calendar == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar calendar2 = (Calendar) calendar.clone();
        m7463a(calendar2, i, 0);
        return calendar2;
    }

    public static Date truncate(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return truncate((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return truncate((Calendar) obj, i).getTime();
            }
            throw new ClassCastException("Could not truncate " + obj);
        }
    }

    public static Date ceiling(Date date, int i) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        m7463a(instance, i, 2);
        return instance.getTime();
    }

    public static Calendar ceiling(Calendar calendar, int i) {
        if (calendar == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar calendar2 = (Calendar) calendar.clone();
        m7463a(calendar2, i, 2);
        return calendar2;
    }

    public static Date ceiling(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return ceiling((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return ceiling((Calendar) obj, i).getTime();
            }
            throw new ClassCastException("Could not find ceiling of for type: " + obj.getClass());
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m7463a(java.util.Calendar r11, int r12, int r13) {
        /*
            r0 = 1
            int r0 = r11.get(r0)
            r1 = 280000000(0x10b07600, float:6.960157E-29)
            if (r0 <= r1) goto L_0x0012
            java.lang.ArithmeticException r0 = new java.lang.ArithmeticException
            java.lang.String r1 = "Calendar value too large for accurate calculations"
            r0.<init>(r1)
            throw r0
        L_0x0012:
            r0 = 14
            if (r12 != r0) goto L_0x0017
        L_0x0016:
            return
        L_0x0017:
            java.util.Date r4 = r11.getTime()
            long r2 = r4.getTime()
            r0 = 0
            r1 = 14
            int r1 = r11.get(r1)
            if (r13 == 0) goto L_0x002c
            r5 = 500(0x1f4, float:7.0E-43)
            if (r1 >= r5) goto L_0x002e
        L_0x002c:
            long r6 = (long) r1
            long r2 = r2 - r6
        L_0x002e:
            r1 = 13
            if (r12 != r1) goto L_0x0033
            r0 = 1
        L_0x0033:
            r1 = 13
            int r1 = r11.get(r1)
            if (r0 != 0) goto L_0x0046
            if (r13 == 0) goto L_0x0041
            r5 = 30
            if (r1 >= r5) goto L_0x0046
        L_0x0041:
            long r6 = (long) r1
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 * r8
            long r2 = r2 - r6
        L_0x0046:
            r1 = 12
            if (r12 != r1) goto L_0x004b
            r0 = 1
        L_0x004b:
            r1 = 12
            int r1 = r11.get(r1)
            if (r0 != 0) goto L_0x0179
            if (r13 == 0) goto L_0x0059
            r0 = 30
            if (r1 >= r0) goto L_0x0179
        L_0x0059:
            long r0 = (long) r1
            r6 = 60000(0xea60, double:2.9644E-319)
            long r0 = r0 * r6
            long r0 = r2 - r0
        L_0x0060:
            long r2 = r4.getTime()
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x006e
            r4.setTime(r0)
            r11.setTime(r4)
        L_0x006e:
            r2 = 0
            int[][] r4 = f7217a
            int r5 = r4.length
            r0 = 0
            r3 = r0
        L_0x0074:
            if (r3 >= r5) goto L_0x015a
            r6 = r4[r3]
            int r1 = r6.length
            r0 = 0
        L_0x007a:
            if (r0 >= r1) goto L_0x00d8
            r7 = r6[r0]
            if (r7 != r12) goto L_0x00d5
            r0 = 2
            if (r13 == r0) goto L_0x0088
            r0 = 1
            if (r13 != r0) goto L_0x0016
            if (r2 == 0) goto L_0x0016
        L_0x0088:
            r0 = 1001(0x3e9, float:1.403E-42)
            if (r12 != r0) goto L_0x00a9
            r0 = 5
            int r0 = r11.get(r0)
            r1 = 1
            if (r0 != r1) goto L_0x009c
            r0 = 5
            r1 = 15
            r11.add(r0, r1)
            goto L_0x0016
        L_0x009c:
            r0 = 5
            r1 = -15
            r11.add(r0, r1)
            r0 = 2
            r1 = 1
            r11.add(r0, r1)
            goto L_0x0016
        L_0x00a9:
            r0 = 9
            if (r12 != r0) goto L_0x00cc
            r0 = 11
            int r0 = r11.get(r0)
            if (r0 != 0) goto L_0x00be
            r0 = 11
            r1 = 12
            r11.add(r0, r1)
            goto L_0x0016
        L_0x00be:
            r0 = 11
            r1 = -12
            r11.add(r0, r1)
            r0 = 5
            r1 = 1
            r11.add(r0, r1)
            goto L_0x0016
        L_0x00cc:
            r0 = 0
            r0 = r6[r0]
            r1 = 1
            r11.add(r0, r1)
            goto L_0x0016
        L_0x00d5:
            int r0 = r0 + 1
            goto L_0x007a
        L_0x00d8:
            r1 = 0
            r0 = 0
            switch(r12) {
                case 9: goto L_0x0139;
                case 1001: goto L_0x011a;
                default: goto L_0x00dd;
            }
        L_0x00dd:
            r10 = r0
            r0 = r1
            r1 = r2
            r2 = r10
        L_0x00e1:
            if (r2 != 0) goto L_0x0103
            r0 = 0
            r0 = r6[r0]
            int r0 = r11.getActualMinimum(r0)
            r1 = 0
            r1 = r6[r1]
            int r2 = r11.getActualMaximum(r1)
            r1 = 0
            r1 = r6[r1]
            int r1 = r11.get(r1)
            int r1 = r1 - r0
            int r0 = r2 - r0
            int r0 = r0 / 2
            if (r1 <= r0) goto L_0x0158
            r0 = 1
        L_0x0100:
            r10 = r1
            r1 = r0
            r0 = r10
        L_0x0103:
            if (r0 == 0) goto L_0x0114
            r2 = 0
            r2 = r6[r2]
            r7 = 0
            r6 = r6[r7]
            int r6 = r11.get(r6)
            int r0 = r6 - r0
            r11.set(r2, r0)
        L_0x0114:
            int r0 = r3 + 1
            r3 = r0
            r2 = r1
            goto L_0x0074
        L_0x011a:
            r7 = 0
            r7 = r6[r7]
            r8 = 5
            if (r7 != r8) goto L_0x00dd
            r0 = 5
            int r0 = r11.get(r0)
            int r2 = r0 + -1
            r0 = 15
            if (r2 < r0) goto L_0x012d
            int r2 = r2 + -15
        L_0x012d:
            r0 = 7
            if (r2 <= r0) goto L_0x0137
            r0 = 1
        L_0x0131:
            r1 = 1
            r10 = r1
            r1 = r0
            r0 = r2
            r2 = r10
            goto L_0x00e1
        L_0x0137:
            r0 = 0
            goto L_0x0131
        L_0x0139:
            r7 = 0
            r7 = r6[r7]
            r8 = 11
            if (r7 != r8) goto L_0x00dd
            r0 = 11
            int r2 = r11.get(r0)
            r0 = 12
            if (r2 < r0) goto L_0x014c
            int r2 = r2 + -12
        L_0x014c:
            r0 = 6
            if (r2 < r0) goto L_0x0156
            r0 = 1
        L_0x0150:
            r1 = 1
            r10 = r1
            r1 = r0
            r0 = r2
            r2 = r10
            goto L_0x00e1
        L_0x0156:
            r0 = 0
            goto L_0x0150
        L_0x0158:
            r0 = 0
            goto L_0x0100
        L_0x015a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "The field "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r12)
            java.lang.String r2 = " is not supported"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0179:
            r0 = r2
            goto L_0x0060
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DateUtils.m7463a(java.util.Calendar, int, int):void");
    }

    public static Iterator<Calendar> iterator(Date date, int i) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return iterator(instance, i);
    }

    public static Iterator<Calendar> iterator(Calendar calendar, int i) {
        Calendar truncate;
        Calendar truncate2;
        int i2;
        int i3 = 2;
        if (calendar == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                truncate = truncate(calendar, 5);
                truncate2 = truncate(calendar, 5);
                switch (i) {
                    case 1:
                        i2 = 7;
                        i3 = 1;
                        break;
                    case 2:
                        i2 = 1;
                        break;
                    case 3:
                        i3 = calendar.get(7);
                        i2 = i3 - 1;
                        break;
                    case 4:
                        i3 = calendar.get(7) - 3;
                        i2 = calendar.get(7) + 3;
                        break;
                    default:
                        i2 = 7;
                        i3 = 1;
                        break;
                }
            case 5:
            case 6:
                Calendar truncate3 = truncate(calendar, 2);
                Calendar calendar2 = (Calendar) truncate3.clone();
                calendar2.add(2, 1);
                calendar2.add(5, -1);
                if (i != 6) {
                    i3 = 1;
                    truncate = truncate3;
                    truncate2 = calendar2;
                    i2 = 7;
                    break;
                } else {
                    truncate = truncate3;
                    truncate2 = calendar2;
                    i2 = 1;
                    break;
                }
            default:
                throw new IllegalArgumentException("The range style " + i + " is not valid.");
        }
        if (i3 < 1) {
            i3 += 7;
        }
        if (i3 > 7) {
            i3 -= 7;
        }
        if (i2 < 1) {
            i2 += 7;
        }
        if (i2 > 7) {
            i2 -= 7;
        }
        while (truncate.get(7) != i3) {
            truncate.add(5, -1);
        }
        while (truncate2.get(7) != i2) {
            truncate2.add(5, 1);
        }
        return new C1974a(truncate, truncate2);
    }

    public static Iterator<?> iterator(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return iterator((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return iterator((Calendar) obj, i);
            }
            throw new ClassCastException("Could not iterate based on " + obj);
        }
    }

    public static long getFragmentInMilliseconds(Date date, int i) {
        return m7466c(date, i, 14);
    }

    public static long getFragmentInSeconds(Date date, int i) {
        return m7466c(date, i, 13);
    }

    public static long getFragmentInMinutes(Date date, int i) {
        return m7466c(date, i, 12);
    }

    public static long getFragmentInHours(Date date, int i) {
        return m7466c(date, i, 11);
    }

    public static long getFragmentInDays(Date date, int i) {
        return m7466c(date, i, 6);
    }

    public static long getFragmentInMilliseconds(Calendar calendar, int i) {
        return m7464b(calendar, i, 14);
    }

    public static long getFragmentInSeconds(Calendar calendar, int i) {
        return m7464b(calendar, i, 13);
    }

    public static long getFragmentInMinutes(Calendar calendar, int i) {
        return m7464b(calendar, i, 12);
    }

    public static long getFragmentInHours(Calendar calendar, int i) {
        return m7464b(calendar, i, 11);
    }

    public static long getFragmentInDays(Calendar calendar, int i) {
        return m7464b(calendar, i, 6);
    }

    /* renamed from: c */
    private static long m7466c(Date date, int i, int i2) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return m7464b(instance, i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0059, code lost:
        r0 = r0 + ((((long) r8.get(12)) * MILLIS_PER_MINUTE) / r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0066, code lost:
        r0 = r0 + ((((long) r8.get(13)) * 1000) / r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return r0 + (((long) (r8.get(14) * 1)) / r2);
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long m7464b(java.util.Calendar r8, int r9, int r10) {
        /*
            r6 = 86400000(0x5265c00, double:4.2687272E-316)
            if (r8 != 0) goto L_0x000d
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The date must not be null"
            r0.<init>(r1)
            throw r0
        L_0x000d:
            long r2 = m7460a(r10)
            r0 = 0
            switch(r9) {
                case 1: goto L_0x0038;
                case 2: goto L_0x0042;
                default: goto L_0x0016;
            }
        L_0x0016:
            switch(r9) {
                case 1: goto L_0x004c;
                case 2: goto L_0x004c;
                case 3: goto L_0x0019;
                case 4: goto L_0x0019;
                case 5: goto L_0x004c;
                case 6: goto L_0x004c;
                case 7: goto L_0x0019;
                case 8: goto L_0x0019;
                case 9: goto L_0x0019;
                case 10: goto L_0x0019;
                case 11: goto L_0x0059;
                case 12: goto L_0x0066;
                case 13: goto L_0x0072;
                case 14: goto L_0x007e;
                default: goto L_0x0019;
            }
        L_0x0019:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "The fragment "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r2 = " is not supported"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0038:
            r4 = 6
            int r4 = r8.get(r4)
            long r4 = (long) r4
            long r4 = r4 * r6
            long r4 = r4 / r2
            long r0 = r0 + r4
            goto L_0x0016
        L_0x0042:
            r4 = 5
            int r4 = r8.get(r4)
            long r4 = (long) r4
            long r4 = r4 * r6
            long r4 = r4 / r2
            long r0 = r0 + r4
            goto L_0x0016
        L_0x004c:
            r4 = 11
            int r4 = r8.get(r4)
            long r4 = (long) r4
            r6 = 3600000(0x36ee80, double:1.7786363E-317)
            long r4 = r4 * r6
            long r4 = r4 / r2
            long r0 = r0 + r4
        L_0x0059:
            r4 = 12
            int r4 = r8.get(r4)
            long r4 = (long) r4
            r6 = 60000(0xea60, double:2.9644E-319)
            long r4 = r4 * r6
            long r4 = r4 / r2
            long r0 = r0 + r4
        L_0x0066:
            r4 = 13
            int r4 = r8.get(r4)
            long r4 = (long) r4
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r6
            long r4 = r4 / r2
            long r0 = r0 + r4
        L_0x0072:
            r4 = 14
            int r4 = r8.get(r4)
            int r4 = r4 * 1
            long r4 = (long) r4
            long r2 = r4 / r2
            long r0 = r0 + r2
        L_0x007e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DateUtils.m7464b(java.util.Calendar, int, int):long");
    }

    public static boolean truncatedEquals(Calendar calendar, Calendar calendar2, int i) {
        return truncatedCompareTo(calendar, calendar2, i) == 0;
    }

    public static boolean truncatedEquals(Date date, Date date2, int i) {
        return truncatedCompareTo(date, date2, i) == 0;
    }

    public static int truncatedCompareTo(Calendar calendar, Calendar calendar2, int i) {
        return truncate(calendar, i).compareTo(truncate(calendar2, i));
    }

    public static int truncatedCompareTo(Date date, Date date2, int i) {
        return truncate(date, i).compareTo(truncate(date2, i));
    }

    /* renamed from: a */
    private static long m7460a(int i) {
        switch (i) {
            case 5:
            case 6:
                return MILLIS_PER_DAY;
            case 11:
                return MILLIS_PER_HOUR;
            case 12:
                return MILLIS_PER_MINUTE;
            case 13:
                return 1000;
            case 14:
                return 1;
            default:
                throw new IllegalArgumentException("The unit " + i + " cannot be represented is milleseconds");
        }
    }

    /* renamed from: org.apache.commons.lang3.time.DateUtils$a */
    static class C1974a implements Iterator<Calendar> {

        /* renamed from: a */
        private final Calendar f7218a;

        /* renamed from: b */
        private final Calendar f7219b;

        C1974a(Calendar calendar, Calendar calendar2) {
            this.f7218a = calendar2;
            this.f7219b = calendar;
            this.f7219b.add(5, -1);
        }

        public boolean hasNext() {
            return this.f7219b.before(this.f7218a);
        }

        /* renamed from: a */
        public Calendar next() {
            if (this.f7219b.equals(this.f7218a)) {
                throw new NoSuchElementException();
            }
            this.f7219b.add(5, 1);
            return (Calendar) this.f7219b.clone();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
