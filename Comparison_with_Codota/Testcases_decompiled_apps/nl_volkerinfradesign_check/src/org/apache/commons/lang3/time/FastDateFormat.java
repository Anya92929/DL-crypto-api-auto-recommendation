package org.apache.commons.lang3.time;

import android.support.p001v4.widget.ExploreByTouchHelper;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.Validate;
import p010uk.p011co.senab.photoview.BuildConfig;

public class FastDateFormat extends Format {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;

    /* renamed from: a */
    private static final C1334js<FastDateFormat> f7229a = new C1334js<FastDateFormat>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public FastDateFormat mo8863b(String str, TimeZone timeZone, Locale locale) {
            return new FastDateFormat(str, timeZone, locale);
        }
    };

    /* renamed from: b */
    private static ConcurrentMap<C1983g, String> f7230b = new ConcurrentHashMap(7);
    private static final long serialVersionUID = 1;

    /* renamed from: c */
    private final String f7231c;

    /* renamed from: d */
    private final TimeZone f7232d;

    /* renamed from: e */
    private final Locale f7233e;

    /* renamed from: f */
    private transient C1980d[] f7234f;

    /* renamed from: g */
    private transient int f7235g;

    /* renamed from: org.apache.commons.lang3.time.FastDateFormat$b */
    interface C1978b extends C1980d {
        /* renamed from: a */
        void mo13617a(StringBuffer stringBuffer, int i);
    }

    /* renamed from: org.apache.commons.lang3.time.FastDateFormat$d */
    interface C1980d {
        /* renamed from: a */
        int mo13615a();

        /* renamed from: a */
        void mo13616a(StringBuffer stringBuffer, Calendar calendar);
    }

    public static FastDateFormat getInstance() {
        return f7229a.mo8862a(3, 3, (TimeZone) null, (Locale) null);
    }

    public static FastDateFormat getInstance(String str) {
        return f7229a.mo8864c(str, (TimeZone) null, (Locale) null);
    }

    public static FastDateFormat getInstance(String str, TimeZone timeZone) {
        return f7229a.mo8864c(str, timeZone, (Locale) null);
    }

    public static FastDateFormat getInstance(String str, Locale locale) {
        return f7229a.mo8864c(str, (TimeZone) null, locale);
    }

    public static FastDateFormat getInstance(String str, TimeZone timeZone, Locale locale) {
        return f7229a.mo8864c(str, timeZone, locale);
    }

    public static FastDateFormat getDateInstance(int i) {
        return f7229a.mo8862a(Integer.valueOf(i), (Integer) null, (TimeZone) null, (Locale) null);
    }

    public static FastDateFormat getDateInstance(int i, Locale locale) {
        return f7229a.mo8862a(Integer.valueOf(i), (Integer) null, (TimeZone) null, locale);
    }

    public static FastDateFormat getDateInstance(int i, TimeZone timeZone) {
        return f7229a.mo8862a(Integer.valueOf(i), (Integer) null, timeZone, (Locale) null);
    }

    public static FastDateFormat getDateInstance(int i, TimeZone timeZone, Locale locale) {
        return f7229a.mo8862a(Integer.valueOf(i), (Integer) null, timeZone, locale);
    }

    public static FastDateFormat getTimeInstance(int i) {
        return f7229a.mo8862a((Integer) null, Integer.valueOf(i), (TimeZone) null, (Locale) null);
    }

    public static FastDateFormat getTimeInstance(int i, Locale locale) {
        return f7229a.mo8862a((Integer) null, Integer.valueOf(i), (TimeZone) null, locale);
    }

    public static FastDateFormat getTimeInstance(int i, TimeZone timeZone) {
        return f7229a.mo8862a((Integer) null, Integer.valueOf(i), timeZone, (Locale) null);
    }

    public static FastDateFormat getTimeInstance(int i, TimeZone timeZone, Locale locale) {
        return f7229a.mo8862a((Integer) null, Integer.valueOf(i), timeZone, locale);
    }

    public static FastDateFormat getDateTimeInstance(int i, int i2) {
        return f7229a.mo8862a(Integer.valueOf(i), Integer.valueOf(i2), (TimeZone) null, (Locale) null);
    }

    public static FastDateFormat getDateTimeInstance(int i, int i2, Locale locale) {
        return f7229a.mo8862a(Integer.valueOf(i), Integer.valueOf(i2), (TimeZone) null, locale);
    }

    public static FastDateFormat getDateTimeInstance(int i, int i2, TimeZone timeZone) {
        return getDateTimeInstance(i, i2, timeZone, (Locale) null);
    }

    public static FastDateFormat getDateTimeInstance(int i, int i2, TimeZone timeZone, Locale locale) {
        return f7229a.mo8862a(Integer.valueOf(i), Integer.valueOf(i2), timeZone, locale);
    }

    /* renamed from: a */
    static String m7474a(TimeZone timeZone, boolean z, int i, Locale locale) {
        C1983g gVar = new C1983g(timeZone, z, i, locale);
        String str = (String) f7230b.get(gVar);
        if (str != null) {
            return str;
        }
        String displayName = timeZone.getDisplayName(z, i, locale);
        String putIfAbsent = f7230b.putIfAbsent(gVar, displayName);
        return putIfAbsent != null ? putIfAbsent : displayName;
    }

    protected FastDateFormat(String str, TimeZone timeZone, Locale locale) {
        this.f7231c = str;
        this.f7232d = timeZone;
        this.f7233e = locale;
        m7475a();
    }

    /* renamed from: a */
    private void m7475a() {
        List<C1980d> parsePattern = parsePattern();
        this.f7234f = (C1980d[]) parsePattern.toArray(new C1980d[parsePattern.size()]);
        int i = 0;
        int length = this.f7234f.length;
        while (true) {
            length--;
            if (length >= 0) {
                i += this.f7234f[length].mo13615a();
            } else {
                this.f7235g = i;
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public List<C1980d> parsePattern() {
        Object eVar;
        String[] strArr;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.f7233e);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.f7231c.length();
        int[] iArr = new int[1];
        int i = 0;
        while (i < length) {
            iArr[0] = i;
            String parseToken = parseToken(this.f7231c, iArr);
            int i2 = iArr[0];
            int length2 = parseToken.length();
            if (length2 == 0) {
                return arrayList;
            }
            switch (parseToken.charAt(0)) {
                case '\'':
                    String substring = parseToken.substring(1);
                    if (substring.length() != 1) {
                        eVar = new C1981e(substring);
                        break;
                    } else {
                        eVar = new C1977a(substring.charAt(0));
                        break;
                    }
                case 'D':
                    eVar = selectNumberRule(6, length2);
                    break;
                case 'E':
                    if (length2 < 4) {
                        strArr = shortWeekdays;
                    } else {
                        strArr = weekdays;
                    }
                    eVar = new C1982f(7, strArr);
                    break;
                case 'F':
                    eVar = selectNumberRule(8, length2);
                    break;
                case 'G':
                    eVar = new C1982f(0, eras);
                    break;
                case 'H':
                    eVar = selectNumberRule(11, length2);
                    break;
                case 'K':
                    eVar = selectNumberRule(10, length2);
                    break;
                case 'M':
                    if (length2 < 4) {
                        if (length2 != 3) {
                            if (length2 != 2) {
                                eVar = C1991o.f7256a;
                                break;
                            } else {
                                eVar = C1988l.f7253a;
                                break;
                            }
                        } else {
                            eVar = new C1982f(2, shortMonths);
                            break;
                        }
                    } else {
                        eVar = new C1982f(2, months);
                        break;
                    }
                case 'S':
                    eVar = selectNumberRule(14, length2);
                    break;
                case 'W':
                    eVar = selectNumberRule(4, length2);
                    break;
                case 'Z':
                    if (length2 != 1) {
                        eVar = C1985i.f7248a;
                        break;
                    } else {
                        eVar = C1985i.f7249b;
                        break;
                    }
                case 'a':
                    eVar = new C1982f(9, amPmStrings);
                    break;
                case 'd':
                    eVar = selectNumberRule(5, length2);
                    break;
                case 'h':
                    eVar = new C1986j(selectNumberRule(10, length2));
                    break;
                case 'k':
                    eVar = new C1987k(selectNumberRule(11, length2));
                    break;
                case 'm':
                    eVar = selectNumberRule(12, length2);
                    break;
                case 's':
                    eVar = selectNumberRule(13, length2);
                    break;
                case 'w':
                    eVar = selectNumberRule(3, length2);
                    break;
                case 'y':
                    if (length2 != 2) {
                        if (length2 < 4) {
                            length2 = 4;
                        }
                        eVar = selectNumberRule(1, length2);
                        break;
                    } else {
                        eVar = C1990n.f7255a;
                        break;
                    }
                case BuildConfig.VERSION_CODE /*122*/:
                    if (length2 < 4) {
                        eVar = new C1984h(this.f7232d, this.f7233e, 0);
                        break;
                    } else {
                        eVar = new C1984h(this.f7232d, this.f7233e, 1);
                        break;
                    }
                default:
                    throw new IllegalArgumentException("Illegal pattern component: " + parseToken);
            }
            arrayList.add(eVar);
            i = i2 + 1;
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0069, code lost:
        r2 = r2 - 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String parseToken(java.lang.String r12, int[] r13) {
        /*
            r11 = this;
            r10 = 97
            r9 = 90
            r8 = 65
            r7 = 39
            r1 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = r13[r1]
            int r4 = r12.length()
            char r0 = r12.charAt(r2)
            if (r0 < r8) goto L_0x001c
            if (r0 <= r9) goto L_0x0022
        L_0x001c:
            if (r0 < r10) goto L_0x0037
            r5 = 122(0x7a, float:1.71E-43)
            if (r0 > r5) goto L_0x0037
        L_0x0022:
            r3.append(r0)
        L_0x0025:
            int r5 = r2 + 1
            if (r5 >= r4) goto L_0x006b
            int r5 = r2 + 1
            char r5 = r12.charAt(r5)
            if (r5 != r0) goto L_0x006b
            r3.append(r0)
            int r2 = r2 + 1
            goto L_0x0025
        L_0x0037:
            r3.append(r7)
            r0 = r1
        L_0x003b:
            if (r2 >= r4) goto L_0x006b
            char r5 = r12.charAt(r2)
            if (r5 != r7) goto L_0x005d
            int r6 = r2 + 1
            if (r6 >= r4) goto L_0x0057
            int r6 = r2 + 1
            char r6 = r12.charAt(r6)
            if (r6 != r7) goto L_0x0057
            int r2 = r2 + 1
            r3.append(r5)
        L_0x0054:
            int r2 = r2 + 1
            goto L_0x003b
        L_0x0057:
            if (r0 != 0) goto L_0x005b
            r0 = 1
            goto L_0x0054
        L_0x005b:
            r0 = r1
            goto L_0x0054
        L_0x005d:
            if (r0 != 0) goto L_0x0072
            if (r5 < r8) goto L_0x0063
            if (r5 <= r9) goto L_0x0069
        L_0x0063:
            if (r5 < r10) goto L_0x0072
            r6 = 122(0x7a, float:1.71E-43)
            if (r5 > r6) goto L_0x0072
        L_0x0069:
            int r2 = r2 + -1
        L_0x006b:
            r13[r1] = r2
            java.lang.String r0 = r3.toString()
            return r0
        L_0x0072:
            r3.append(r5)
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.FastDateFormat.parseToken(java.lang.String, int[]):java.lang.String");
    }

    /* access modifiers changed from: protected */
    public C1978b selectNumberRule(int i, int i2) {
        switch (i2) {
            case 1:
                return new C1992p(i);
            case 2:
                return new C1989m(i);
            default:
                return new C1979c(i, i2);
        }
    }

    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer);
        }
        throw new IllegalArgumentException("Unknown class: " + (obj == null ? "<null>" : obj.getClass().getName()));
    }

    public String format(long j) {
        return format(new Date(j));
    }

    public String format(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.f7232d, this.f7233e);
        gregorianCalendar.setTime(date);
        return applyRules(gregorianCalendar, new StringBuffer(this.f7235g)).toString();
    }

    public String format(Calendar calendar) {
        return format(calendar, new StringBuffer(this.f7235g)).toString();
    }

    public StringBuffer format(long j, StringBuffer stringBuffer) {
        return format(new Date(j), stringBuffer);
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.f7232d, this.f7233e);
        gregorianCalendar.setTime(date);
        return applyRules(gregorianCalendar, stringBuffer);
    }

    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return applyRules(calendar, stringBuffer);
    }

    /* access modifiers changed from: protected */
    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        for (C1980d a : this.f7234f) {
            a.mo13616a(stringBuffer, calendar);
        }
        return stringBuffer;
    }

    public Object parseObject(String str, ParsePosition parsePosition) {
        parsePosition.setIndex(0);
        parsePosition.setErrorIndex(0);
        return null;
    }

    public String getPattern() {
        return this.f7231c;
    }

    public TimeZone getTimeZone() {
        return this.f7232d;
    }

    public Locale getLocale() {
        return this.f7233e;
    }

    public int getMaxLengthEstimate() {
        return this.f7235g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDateFormat)) {
            return false;
        }
        FastDateFormat fastDateFormat = (FastDateFormat) obj;
        if (!this.f7231c.equals(fastDateFormat.f7231c) || !this.f7232d.equals(fastDateFormat.f7232d) || !this.f7233e.equals(fastDateFormat.f7233e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f7231c.hashCode() + ((this.f7232d.hashCode() + (this.f7233e.hashCode() * 13)) * 13);
    }

    public String toString() {
        return "FastDateFormat[" + this.f7231c + "]";
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        m7475a();
    }

    /* renamed from: org.apache.commons.lang3.time.FastDateFormat$a */
    static class C1977a implements C1980d {

        /* renamed from: a */
        private final char f7236a;

        C1977a(char c) {
            this.f7236a = c;
        }

        /* renamed from: a */
        public int mo13615a() {
            return 1;
        }

        /* renamed from: a */
        public void mo13616a(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.f7236a);
        }
    }

    /* renamed from: org.apache.commons.lang3.time.FastDateFormat$e */
    static class C1981e implements C1980d {

        /* renamed from: a */
        private final String f7239a;

        C1981e(String str) {
            this.f7239a = str;
        }

        /* renamed from: a */
        public int mo13615a() {
            return this.f7239a.length();
        }

        /* renamed from: a */
        public void mo13616a(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.f7239a);
        }
    }

    /* renamed from: org.apache.commons.lang3.time.FastDateFormat$f */
    static class C1982f implements C1980d {

        /* renamed from: a */
        private final int f7240a;

        /* renamed from: b */
        private final String[] f7241b;

        C1982f(int i, String[] strArr) {
            this.f7240a = i;
            this.f7241b = strArr;
        }

        /* renamed from: a */
        public int mo13615a() {
            int i = 0;
            int length = this.f7241b.length;
            while (true) {
                int i2 = length - 1;
                if (i2 < 0) {
                    return i;
                }
                int length2 = this.f7241b[i2].length();
                if (length2 <= i) {
                    length2 = i;
                }
                i = length2;
                length = i2;
            }
        }

        /* renamed from: a */
        public void mo13616a(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.f7241b[calendar.get(this.f7240a)]);
        }
    }

    /* renamed from: org.apache.commons.lang3.time.FastDateFormat$p */
    static class C1992p implements C1978b {

        /* renamed from: a */
        private final int f7257a;

        C1992p(int i) {
            this.f7257a = i;
        }

        /* renamed from: a */
        public int mo13615a() {
            return 4;
        }

        /* renamed from: a */
        public void mo13616a(StringBuffer stringBuffer, Calendar calendar) {
            mo13617a(stringBuffer, calendar.get(this.f7257a));
        }

        /* renamed from: a */
        public final void mo13617a(StringBuffer stringBuffer, int i) {
            if (i < 10) {
                stringBuffer.append((char) (i + 48));
            } else if (i < 100) {
                stringBuffer.append((char) ((i / 10) + 48));
                stringBuffer.append((char) ((i % 10) + 48));
            } else {
                stringBuffer.append(Integer.toString(i));
            }
        }
    }

    /* renamed from: org.apache.commons.lang3.time.FastDateFormat$o */
    static class C1991o implements C1978b {

        /* renamed from: a */
        static final C1991o f7256a = new C1991o();

        C1991o() {
        }

        /* renamed from: a */
        public int mo13615a() {
            return 2;
        }

        /* renamed from: a */
        public void mo13616a(StringBuffer stringBuffer, Calendar calendar) {
            mo13617a(stringBuffer, calendar.get(2) + 1);
        }

        /* renamed from: a */
        public final void mo13617a(StringBuffer stringBuffer, int i) {
            if (i < 10) {
                stringBuffer.append((char) (i + 48));
                return;
            }
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }
    }

    /* renamed from: org.apache.commons.lang3.time.FastDateFormat$c */
    static class C1979c implements C1978b {

        /* renamed from: a */
        private final int f7237a;

        /* renamed from: b */
        private final int f7238b;

        C1979c(int i, int i2) {
            if (i2 < 3) {
                throw new IllegalArgumentException();
            }
            this.f7237a = i;
            this.f7238b = i2;
        }

        /* renamed from: a */
        public int mo13615a() {
            return 4;
        }

        /* renamed from: a */
        public void mo13616a(StringBuffer stringBuffer, Calendar calendar) {
            mo13617a(stringBuffer, calendar.get(this.f7237a));
        }

        /* renamed from: a */
        public final void mo13617a(StringBuffer stringBuffer, int i) {
            int length;
            if (i < 100) {
                int i2 = this.f7238b;
                while (true) {
                    i2--;
                    if (i2 >= 2) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append((char) ((i / 10) + 48));
                        stringBuffer.append((char) ((i % 10) + 48));
                        return;
                    }
                }
            } else {
                if (i < 1000) {
                    length = 3;
                } else {
                    Validate.isTrue(i > -1, "Negative values should not be possible", (long) i);
                    length = Integer.toString(i).length();
                }
                int i3 = this.f7238b;
                while (true) {
                    i3--;
                    if (i3 >= length) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append(Integer.toString(i));
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: org.apache.commons.lang3.time.FastDateFormat$m */
    static class C1989m implements C1978b {

        /* renamed from: a */
        private final int f7254a;

        C1989m(int i) {
            this.f7254a = i;
        }

        /* renamed from: a */
        public int mo13615a() {
            return 2;
        }

        /* renamed from: a */
        public void mo13616a(StringBuffer stringBuffer, Calendar calendar) {
            mo13617a(stringBuffer, calendar.get(this.f7254a));
        }

        /* renamed from: a */
        public final void mo13617a(StringBuffer stringBuffer, int i) {
            if (i < 100) {
                stringBuffer.append((char) ((i / 10) + 48));
                stringBuffer.append((char) ((i % 10) + 48));
                return;
            }
            stringBuffer.append(Integer.toString(i));
        }
    }

    /* renamed from: org.apache.commons.lang3.time.FastDateFormat$n */
    static class C1990n implements C1978b {

        /* renamed from: a */
        static final C1990n f7255a = new C1990n();

        C1990n() {
        }

        /* renamed from: a */
        public int mo13615a() {
            return 2;
        }

        /* renamed from: a */
        public void mo13616a(StringBuffer stringBuffer, Calendar calendar) {
            mo13617a(stringBuffer, calendar.get(1) % 100);
        }

        /* renamed from: a */
        public final void mo13617a(StringBuffer stringBuffer, int i) {
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }
    }

    /* renamed from: org.apache.commons.lang3.time.FastDateFormat$l */
    static class C1988l implements C1978b {

        /* renamed from: a */
        static final C1988l f7253a = new C1988l();

        C1988l() {
        }

        /* renamed from: a */
        public int mo13615a() {
            return 2;
        }

        /* renamed from: a */
        public void mo13616a(StringBuffer stringBuffer, Calendar calendar) {
            mo13617a(stringBuffer, calendar.get(2) + 1);
        }

        /* renamed from: a */
        public final void mo13617a(StringBuffer stringBuffer, int i) {
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }
    }

    /* renamed from: org.apache.commons.lang3.time.FastDateFormat$j */
    static class C1986j implements C1978b {

        /* renamed from: a */
        private final C1978b f7251a;

        C1986j(C1978b bVar) {
            this.f7251a = bVar;
        }

        /* renamed from: a */
        public int mo13615a() {
            return this.f7251a.mo13615a();
        }

        /* renamed from: a */
        public void mo13616a(StringBuffer stringBuffer, Calendar calendar) {
            int i = calendar.get(10);
            if (i == 0) {
                i = calendar.getLeastMaximum(10) + 1;
            }
            this.f7251a.mo13617a(stringBuffer, i);
        }

        /* renamed from: a */
        public void mo13617a(StringBuffer stringBuffer, int i) {
            this.f7251a.mo13617a(stringBuffer, i);
        }
    }

    /* renamed from: org.apache.commons.lang3.time.FastDateFormat$k */
    static class C1987k implements C1978b {

        /* renamed from: a */
        private final C1978b f7252a;

        C1987k(C1978b bVar) {
            this.f7252a = bVar;
        }

        /* renamed from: a */
        public int mo13615a() {
            return this.f7252a.mo13615a();
        }

        /* renamed from: a */
        public void mo13616a(StringBuffer stringBuffer, Calendar calendar) {
            int i = calendar.get(11);
            if (i == 0) {
                i = calendar.getMaximum(11) + 1;
            }
            this.f7252a.mo13617a(stringBuffer, i);
        }

        /* renamed from: a */
        public void mo13617a(StringBuffer stringBuffer, int i) {
            this.f7252a.mo13617a(stringBuffer, i);
        }
    }

    /* renamed from: org.apache.commons.lang3.time.FastDateFormat$h */
    static class C1984h implements C1980d {

        /* renamed from: a */
        private final TimeZone f7245a;

        /* renamed from: b */
        private final String f7246b;

        /* renamed from: c */
        private final String f7247c;

        C1984h(TimeZone timeZone, Locale locale, int i) {
            this.f7245a = timeZone;
            this.f7246b = FastDateFormat.m7474a(timeZone, false, i, locale);
            this.f7247c = FastDateFormat.m7474a(timeZone, true, i, locale);
        }

        /* renamed from: a */
        public int mo13615a() {
            return Math.max(this.f7246b.length(), this.f7247c.length());
        }

        /* renamed from: a */
        public void mo13616a(StringBuffer stringBuffer, Calendar calendar) {
            if (!this.f7245a.useDaylightTime() || calendar.get(16) == 0) {
                stringBuffer.append(this.f7246b);
            } else {
                stringBuffer.append(this.f7247c);
            }
        }
    }

    /* renamed from: org.apache.commons.lang3.time.FastDateFormat$i */
    static class C1985i implements C1980d {

        /* renamed from: a */
        static final C1985i f7248a = new C1985i(true);

        /* renamed from: b */
        static final C1985i f7249b = new C1985i(false);

        /* renamed from: c */
        final boolean f7250c;

        C1985i(boolean z) {
            this.f7250c = z;
        }

        /* renamed from: a */
        public int mo13615a() {
            return 5;
        }

        /* renamed from: a */
        public void mo13616a(StringBuffer stringBuffer, Calendar calendar) {
            int i = calendar.get(15) + calendar.get(16);
            if (i < 0) {
                stringBuffer.append('-');
                i = -i;
            } else {
                stringBuffer.append('+');
            }
            int i2 = i / 3600000;
            stringBuffer.append((char) ((i2 / 10) + 48));
            stringBuffer.append((char) ((i2 % 10) + 48));
            if (this.f7250c) {
                stringBuffer.append(':');
            }
            int i3 = (i / 60000) - (i2 * 60);
            stringBuffer.append((char) ((i3 / 10) + 48));
            stringBuffer.append((char) ((i3 % 10) + 48));
        }
    }

    /* renamed from: org.apache.commons.lang3.time.FastDateFormat$g */
    static class C1983g {

        /* renamed from: a */
        private final TimeZone f7242a;

        /* renamed from: b */
        private final int f7243b;

        /* renamed from: c */
        private final Locale f7244c;

        C1983g(TimeZone timeZone, boolean z, int i, Locale locale) {
            this.f7242a = timeZone;
            this.f7243b = z ? i | ExploreByTouchHelper.INVALID_ID : i;
            this.f7244c = locale;
        }

        public int hashCode() {
            return (((this.f7243b * 31) + this.f7244c.hashCode()) * 31) + this.f7242a.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C1983g)) {
                return false;
            }
            C1983g gVar = (C1983g) obj;
            if (!this.f7242a.equals(gVar.f7242a) || this.f7243b != gVar.f7243b || !this.f7244c.equals(gVar.f7244c)) {
                return false;
            }
            return true;
        }
    }
}
