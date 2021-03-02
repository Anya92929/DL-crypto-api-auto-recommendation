package org.apache.commons.lang3.time;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;
import p006nl.volkerinfradesign.checkandroid.database.LogTable;

public class DurationFormatUtils {
    public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'";

    /* renamed from: a */
    static final Object f7220a = "y";

    /* renamed from: b */
    static final Object f7221b = "M";

    /* renamed from: c */
    static final Object f7222c = "d";

    /* renamed from: d */
    static final Object f7223d = "H";

    /* renamed from: e */
    static final Object f7224e = "m";

    /* renamed from: f */
    static final Object f7225f = "s";

    /* renamed from: g */
    static final Object f7226g = "S";

    public static String formatDurationHMS(long j) {
        return formatDuration(j, "H:mm:ss.SSS");
    }

    public static String formatDurationISO(long j) {
        return formatDuration(j, ISO_EXTENDED_FORMAT_PATTERN, false);
    }

    public static String formatDuration(long j, String str) {
        return formatDuration(j, str, true);
    }

    public static String formatDuration(long j, String str, boolean z) {
        C1975a[] a = m7469a(str);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        if (C1975a.m7470a(a, f7222c)) {
            i = (int) (j / DateUtils.MILLIS_PER_DAY);
            j -= ((long) i) * DateUtils.MILLIS_PER_DAY;
        }
        if (C1975a.m7470a(a, f7223d)) {
            i2 = (int) (j / DateUtils.MILLIS_PER_HOUR);
            j -= ((long) i2) * DateUtils.MILLIS_PER_HOUR;
        }
        if (C1975a.m7470a(a, f7224e)) {
            i3 = (int) (j / DateUtils.MILLIS_PER_MINUTE);
            j -= ((long) i3) * DateUtils.MILLIS_PER_MINUTE;
        }
        if (C1975a.m7470a(a, f7225f)) {
            i4 = (int) (j / 1000);
            j -= ((long) i4) * 1000;
        }
        if (C1975a.m7470a(a, f7226g)) {
            i5 = (int) j;
        }
        return m7468a(a, 0, 0, i, i2, i3, i4, i5, z);
    }

    public static String formatDurationWords(long j, boolean z, boolean z2) {
        String formatDuration = formatDuration(j, "d' days 'H' hours 'm' minutes 's' seconds'");
        if (z) {
            String str = " " + formatDuration;
            formatDuration = StringUtils.replaceOnce(str, " 0 days", "");
            if (formatDuration.length() != str.length()) {
                String replaceOnce = StringUtils.replaceOnce(formatDuration, " 0 hours", "");
                if (replaceOnce.length() != formatDuration.length()) {
                    formatDuration = StringUtils.replaceOnce(replaceOnce, " 0 minutes", "");
                    if (formatDuration.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
                    }
                }
            } else {
                formatDuration = str;
            }
            if (formatDuration.length() != 0) {
                formatDuration = formatDuration.substring(1);
            }
        }
        if (z2) {
            String replaceOnce2 = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
            if (replaceOnce2.length() != formatDuration.length()) {
                formatDuration = StringUtils.replaceOnce(replaceOnce2, " 0 minutes", "");
                if (formatDuration.length() != replaceOnce2.length()) {
                    String replaceOnce3 = StringUtils.replaceOnce(formatDuration, " 0 hours", "");
                    if (replaceOnce3.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(replaceOnce3, " 0 days", "");
                    }
                } else {
                    formatDuration = replaceOnce2;
                }
            }
        }
        return StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(" " + formatDuration, " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
    }

    public static String formatPeriodISO(long j, long j2) {
        return formatPeriod(j, j2, ISO_EXTENDED_FORMAT_PATTERN, false, TimeZone.getDefault());
    }

    public static String formatPeriod(long j, long j2, String str) {
        return formatPeriod(j, j2, str, true, TimeZone.getDefault());
    }

    public static String formatPeriod(long j, long j2, String str, boolean z, TimeZone timeZone) {
        int i;
        int i2;
        C1975a[] a = m7469a(str);
        Calendar instance = Calendar.getInstance(timeZone);
        instance.setTime(new Date(j));
        Calendar instance2 = Calendar.getInstance(timeZone);
        instance2.setTime(new Date(j2));
        int i3 = instance2.get(14) - instance.get(14);
        int i4 = instance2.get(13) - instance.get(13);
        int i5 = instance2.get(12) - instance.get(12);
        int i6 = instance2.get(11) - instance.get(11);
        int i7 = instance2.get(5) - instance.get(5);
        int i8 = instance2.get(2) - instance.get(2);
        int i9 = instance2.get(1) - instance.get(1);
        while (i3 < 0) {
            i3 += LogTable.MAX_SIZE;
            i4--;
        }
        while (i4 < 0) {
            i4 += 60;
            i5--;
        }
        while (i5 < 0) {
            i5 += 60;
            i6--;
        }
        while (i6 < 0) {
            i6 += 24;
            i7--;
        }
        if (C1975a.m7470a(a, f7221b)) {
            int i10 = i8;
            i = i7;
            i2 = i10;
            while (i < 0) {
                i += instance.getActualMaximum(5);
                i2--;
                instance.add(2, 1);
            }
            while (i2 < 0) {
                i2 += 12;
                i9--;
            }
            if (!C1975a.m7470a(a, f7220a) && i9 != 0) {
                while (i9 != 0) {
                    i2 += i9 * 12;
                    i9 = 0;
                }
            }
        } else {
            if (!C1975a.m7470a(a, f7220a)) {
                int i11 = instance2.get(1);
                if (i8 < 0) {
                    i11--;
                }
                while (instance.get(1) != i11) {
                    int actualMaximum = i7 + (instance.getActualMaximum(6) - instance.get(6));
                    if ((instance instanceof GregorianCalendar) && instance.get(2) == 1 && instance.get(5) == 29) {
                        actualMaximum++;
                    }
                    instance.add(1, 1);
                    i7 = actualMaximum + instance.get(6);
                }
                i9 = 0;
            }
            while (instance.get(2) != instance2.get(2)) {
                i7 += instance.getActualMaximum(5);
                instance.add(2, 1);
            }
            int i12 = i7;
            int i13 = 0;
            while (i < 0) {
                i12 = i + instance.getActualMaximum(5);
                i13 = i2 - 1;
                instance.add(2, 1);
            }
        }
        if (!C1975a.m7470a(a, f7222c)) {
            i6 += i * 24;
            i = 0;
        }
        if (!C1975a.m7470a(a, f7223d)) {
            i5 += i6 * 60;
            i6 = 0;
        }
        if (!C1975a.m7470a(a, f7224e)) {
            i4 += i5 * 60;
            i5 = 0;
        }
        if (!C1975a.m7470a(a, f7225f)) {
            i3 += i4 * LogTable.MAX_SIZE;
            i4 = 0;
        }
        return m7468a(a, i9, i2, i, i6, i5, i4, i3, z);
    }

    /* renamed from: a */
    static String m7468a(C1975a[] aVarArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        int i8;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z2 = false;
        int i9 = i7;
        for (C1975a aVar : aVarArr) {
            Object c = aVar.mo13591c();
            int b = aVar.mo13590b();
            if (c instanceof StringBuffer) {
                stringBuffer.append(c.toString());
            } else if (c == f7220a) {
                stringBuffer.append(z ? StringUtils.leftPad(Integer.toString(i), b, '0') : Integer.toString(i));
                z2 = false;
            } else if (c == f7221b) {
                stringBuffer.append(z ? StringUtils.leftPad(Integer.toString(i2), b, '0') : Integer.toString(i2));
                z2 = false;
            } else if (c == f7222c) {
                stringBuffer.append(z ? StringUtils.leftPad(Integer.toString(i3), b, '0') : Integer.toString(i3));
                z2 = false;
            } else if (c == f7223d) {
                stringBuffer.append(z ? StringUtils.leftPad(Integer.toString(i4), b, '0') : Integer.toString(i4));
                z2 = false;
            } else if (c == f7224e) {
                stringBuffer.append(z ? StringUtils.leftPad(Integer.toString(i5), b, '0') : Integer.toString(i5));
                z2 = false;
            } else if (c == f7225f) {
                stringBuffer.append(z ? StringUtils.leftPad(Integer.toString(i6), b, '0') : Integer.toString(i6));
                z2 = true;
            } else if (c == f7226g) {
                if (z2) {
                    int i10 = i9 + LogTable.MAX_SIZE;
                    stringBuffer.append((z ? StringUtils.leftPad(Integer.toString(i10), b, '0') : Integer.toString(i10)).substring(1));
                    i8 = i10;
                } else {
                    stringBuffer.append(z ? StringUtils.leftPad(Integer.toString(i9), b, '0') : Integer.toString(i9));
                    i8 = i9;
                }
                i9 = i8;
                z2 = false;
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    static C1975a[] m7469a(String str) {
        Object obj;
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList(charArray.length);
        C1975a aVar = null;
        StringBuffer stringBuffer = null;
        boolean z = false;
        for (char c : charArray) {
            if (!z || c == '\'') {
                switch (c) {
                    case '\'':
                        if (!z) {
                            stringBuffer = new StringBuffer();
                            arrayList.add(new C1975a(stringBuffer));
                            z = true;
                            obj = null;
                            break;
                        } else {
                            obj = null;
                            stringBuffer = null;
                            z = false;
                            break;
                        }
                    case 'H':
                        obj = f7223d;
                        break;
                    case 'M':
                        obj = f7221b;
                        break;
                    case 'S':
                        obj = f7226g;
                        break;
                    case 'd':
                        obj = f7222c;
                        break;
                    case 'm':
                        obj = f7224e;
                        break;
                    case 's':
                        obj = f7225f;
                        break;
                    case 'y':
                        obj = f7220a;
                        break;
                    default:
                        if (stringBuffer == null) {
                            stringBuffer = new StringBuffer();
                            arrayList.add(new C1975a(stringBuffer));
                        }
                        stringBuffer.append(c);
                        obj = null;
                        break;
                }
                if (obj != null) {
                    if (aVar == null || aVar.mo13591c() != obj) {
                        aVar = new C1975a(obj);
                        arrayList.add(aVar);
                    } else {
                        aVar.mo13589a();
                    }
                    stringBuffer = null;
                }
            } else {
                stringBuffer.append(c);
            }
        }
        return (C1975a[]) arrayList.toArray(new C1975a[arrayList.size()]);
    }

    /* renamed from: org.apache.commons.lang3.time.DurationFormatUtils$a */
    static class C1975a {

        /* renamed from: a */
        private final Object f7227a;

        /* renamed from: b */
        private int f7228b = 1;

        /* renamed from: a */
        static boolean m7470a(C1975a[] aVarArr, Object obj) {
            for (C1975a c : aVarArr) {
                if (c.mo13591c() == obj) {
                    return true;
                }
            }
            return false;
        }

        C1975a(Object obj) {
            this.f7227a = obj;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo13589a() {
            this.f7228b++;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo13590b() {
            return this.f7228b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public Object mo13591c() {
            return this.f7227a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1975a)) {
                return false;
            }
            C1975a aVar = (C1975a) obj;
            if (this.f7227a.getClass() != aVar.f7227a.getClass() || this.f7228b != aVar.f7228b) {
                return false;
            }
            if (this.f7227a instanceof StringBuffer) {
                return this.f7227a.toString().equals(aVar.f7227a.toString());
            }
            if (this.f7227a instanceof Number) {
                return this.f7227a.equals(aVar.f7227a);
            }
            if (this.f7227a == aVar.f7227a) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f7227a.hashCode();
        }

        public String toString() {
            return StringUtils.repeat(this.f7227a.toString(), this.f7228b);
        }
    }
}
