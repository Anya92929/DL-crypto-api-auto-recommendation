package org.joda.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.chrono.BaseChronology;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.FormatUtils;
import org.joda.time.p007tz.FixedDateTimeZone;
import org.joda.time.p007tz.NameProvider;
import org.joda.time.p007tz.Provider;

public abstract class DateTimeZone implements Serializable {
    public static final DateTimeZone UTC = new FixedDateTimeZone("UTC", "UTC", 0, 0);
    private static Set<String> cAvailableIDs = null;
    private static volatile DateTimeZone cDefault = null;
    private static NameProvider cNameProvider = null;
    private static DateTimeFormatter cOffsetFormatter = null;
    private static Provider cProvider = null;
    private static Map<String, String> cZoneIdConversion = null;
    private static Map<String, SoftReference<DateTimeZone>> iFixedOffsetCache = null;
    private static final long serialVersionUID = 5546345482340108586L;
    private final String iID;

    public abstract boolean equals(Object obj);

    public abstract String getNameKey(long j);

    public abstract int getOffset(long j);

    public abstract int getStandardOffset(long j);

    public abstract boolean isFixed();

    public abstract long nextTransition(long j);

    public abstract long previousTransition(long j);

    static {
        setProvider0((Provider) null);
        setNameProvider0((NameProvider) null);
    }

    public static DateTimeZone getDefault() {
        DateTimeZone dateTimeZone = cDefault;
        if (dateTimeZone == null) {
            synchronized (DateTimeZone.class) {
                dateTimeZone = cDefault;
                if (dateTimeZone == null) {
                    dateTimeZone = null;
                    try {
                        String property = System.getProperty("user.timezone");
                        if (property != null) {
                            dateTimeZone = forID(property);
                        }
                    } catch (RuntimeException e) {
                    }
                    if (dateTimeZone == null) {
                        try {
                            dateTimeZone = forTimeZone(TimeZone.getDefault());
                        } catch (IllegalArgumentException e2) {
                        }
                    }
                    if (dateTimeZone == null) {
                        dateTimeZone = UTC;
                    }
                    cDefault = dateTimeZone;
                }
            }
        }
        return dateTimeZone;
    }

    public static void setDefault(DateTimeZone dateTimeZone) throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("DateTimeZone.setDefault"));
        }
        if (dateTimeZone == null) {
            throw new IllegalArgumentException("The datetime zone must not be null");
        }
        synchronized (DateTimeZone.class) {
            cDefault = dateTimeZone;
        }
    }

    @FromString
    public static DateTimeZone forID(String str) {
        if (str == null) {
            return getDefault();
        }
        if (str.equals("UTC")) {
            return UTC;
        }
        DateTimeZone zone = cProvider.getZone(str);
        if (zone != null) {
            return zone;
        }
        if (str.startsWith("+") || str.startsWith("-")) {
            int parseOffset = parseOffset(str);
            if (((long) parseOffset) == 0) {
                return UTC;
            }
            return fixedOffsetZone(printOffset(parseOffset), parseOffset);
        }
        throw new IllegalArgumentException("The datetime zone id '" + str + "' is not recognised");
    }

    public static DateTimeZone forOffsetHours(int i) throws IllegalArgumentException {
        return forOffsetHoursMinutes(i, 0);
    }

    public static DateTimeZone forOffsetHoursMinutes(int i, int i2) throws IllegalArgumentException {
        int safeAdd;
        if (i == 0 && i2 == 0) {
            return UTC;
        }
        if (i2 < 0 || i2 > 59) {
            throw new IllegalArgumentException("Minutes out of range: " + i2);
        }
        try {
            int safeMultiply = FieldUtils.safeMultiply(i, 60);
            if (safeMultiply < 0) {
                safeAdd = FieldUtils.safeAdd(safeMultiply, -i2);
            } else {
                safeAdd = FieldUtils.safeAdd(safeMultiply, i2);
            }
            return forOffsetMillis(FieldUtils.safeMultiply(safeAdd, (int) DateTimeConstants.MILLIS_PER_MINUTE));
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Offset is too large");
        }
    }

    public static DateTimeZone forOffsetMillis(int i) {
        return fixedOffsetZone(printOffset(i), i);
    }

    public static DateTimeZone forTimeZone(TimeZone timeZone) {
        if (timeZone == null) {
            return getDefault();
        }
        String id = timeZone.getID();
        if (id.equals("UTC")) {
            return UTC;
        }
        DateTimeZone dateTimeZone = null;
        String convertedId = getConvertedId(id);
        if (convertedId != null) {
            dateTimeZone = cProvider.getZone(convertedId);
        }
        if (dateTimeZone == null) {
            dateTimeZone = cProvider.getZone(id);
        }
        if (dateTimeZone != null) {
            return dateTimeZone;
        }
        if (convertedId == null) {
            String id2 = timeZone.getID();
            if (id2.startsWith("GMT+") || id2.startsWith("GMT-")) {
                int parseOffset = parseOffset(id2.substring(3));
                if (((long) parseOffset) == 0) {
                    return UTC;
                }
                return fixedOffsetZone(printOffset(parseOffset), parseOffset);
            }
        }
        throw new IllegalArgumentException("The datetime zone id '" + id + "' is not recognised");
    }

    private static synchronized DateTimeZone fixedOffsetZone(String str, int i) {
        DateTimeZone fixedDateTimeZone;
        synchronized (DateTimeZone.class) {
            if (i == 0) {
                fixedDateTimeZone = UTC;
            } else {
                if (iFixedOffsetCache == null) {
                    iFixedOffsetCache = new HashMap();
                }
                Reference reference = iFixedOffsetCache.get(str);
                if (reference == null || (fixedDateTimeZone = (DateTimeZone) reference.get()) == null) {
                    fixedDateTimeZone = new FixedDateTimeZone(str, (String) null, i, i);
                    iFixedOffsetCache.put(str, new SoftReference(fixedDateTimeZone));
                }
            }
        }
        return fixedDateTimeZone;
    }

    public static Set<String> getAvailableIDs() {
        return cAvailableIDs;
    }

    public static Provider getProvider() {
        return cProvider;
    }

    public static void setProvider(Provider provider) throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("DateTimeZone.setProvider"));
        }
        setProvider0(provider);
    }

    private static void setProvider0(Provider provider) {
        if (provider == null) {
            provider = getDefaultProvider();
        }
        Set<String> availableIDs = provider.getAvailableIDs();
        if (availableIDs == null || availableIDs.size() == 0) {
            throw new IllegalArgumentException("The provider doesn't have any available ids");
        } else if (!availableIDs.contains("UTC")) {
            throw new IllegalArgumentException("The provider doesn't support UTC");
        } else if (!UTC.equals(provider.getZone("UTC"))) {
            throw new IllegalArgumentException("Invalid UTC zone provided");
        } else {
            cProvider = provider;
            cAvailableIDs = availableIDs;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016 A[SYNTHETIC, Splitter:B:8:0x0016] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static org.joda.time.p007tz.Provider getDefaultProvider() {
        /*
            r1 = 0
            java.lang.String r0 = "org.joda.time.DateTimeZone.Provider"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x0041 }
            if (r0 == 0) goto L_0x0031
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0025 }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ Exception -> 0x0025 }
            org.joda.time.tz.Provider r0 = (org.joda.time.p007tz.Provider) r0     // Catch:{ Exception -> 0x0025 }
        L_0x0013:
            r1 = r0
        L_0x0014:
            if (r1 != 0) goto L_0x003f
            org.joda.time.tz.ZoneInfoProvider r0 = new org.joda.time.tz.ZoneInfoProvider     // Catch:{ Exception -> 0x0033 }
            java.lang.String r2 = "org/joda/time/tz/data"
            r0.<init>((java.lang.String) r2)     // Catch:{ Exception -> 0x0033 }
        L_0x001d:
            if (r0 != 0) goto L_0x0024
            org.joda.time.tz.UTCProvider r0 = new org.joda.time.tz.UTCProvider
            r0.<init>()
        L_0x0024:
            return r0
        L_0x0025:
            r0 = move-exception
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ SecurityException -> 0x0041 }
            java.lang.ThreadGroup r3 = r2.getThreadGroup()     // Catch:{ SecurityException -> 0x0041 }
            r3.uncaughtException(r2, r0)     // Catch:{ SecurityException -> 0x0041 }
        L_0x0031:
            r0 = r1
            goto L_0x0013
        L_0x0033:
            r0 = move-exception
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            java.lang.ThreadGroup r3 = r2.getThreadGroup()
            r3.uncaughtException(r2, r0)
        L_0x003f:
            r0 = r1
            goto L_0x001d
        L_0x0041:
            r0 = move-exception
            goto L_0x0014
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.DateTimeZone.getDefaultProvider():org.joda.time.tz.Provider");
    }

    public static NameProvider getNameProvider() {
        return cNameProvider;
    }

    public static void setNameProvider(NameProvider nameProvider) throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("DateTimeZone.setNameProvider"));
        }
        setNameProvider0(nameProvider);
    }

    private static void setNameProvider0(NameProvider nameProvider) {
        if (nameProvider == null) {
            nameProvider = getDefaultNameProvider();
        }
        cNameProvider = nameProvider;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0015  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static org.joda.time.p007tz.NameProvider getDefaultNameProvider() {
        /*
            r1 = 0
            java.lang.String r0 = "org.joda.time.DateTimeZone.NameProvider"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x0029 }
            if (r0 == 0) goto L_0x0027
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x001b }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ Exception -> 0x001b }
            org.joda.time.tz.NameProvider r0 = (org.joda.time.p007tz.NameProvider) r0     // Catch:{ Exception -> 0x001b }
        L_0x0013:
            if (r0 != 0) goto L_0x001a
            org.joda.time.tz.DefaultNameProvider r0 = new org.joda.time.tz.DefaultNameProvider
            r0.<init>()
        L_0x001a:
            return r0
        L_0x001b:
            r0 = move-exception
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ SecurityException -> 0x0029 }
            java.lang.ThreadGroup r3 = r2.getThreadGroup()     // Catch:{ SecurityException -> 0x0029 }
            r3.uncaughtException(r2, r0)     // Catch:{ SecurityException -> 0x0029 }
        L_0x0027:
            r0 = r1
            goto L_0x0013
        L_0x0029:
            r0 = move-exception
            r0 = r1
            goto L_0x0013
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.DateTimeZone.getDefaultNameProvider():org.joda.time.tz.NameProvider");
    }

    private static synchronized String getConvertedId(String str) {
        String str2;
        synchronized (DateTimeZone.class) {
            Map map = cZoneIdConversion;
            if (map == null) {
                map = new HashMap();
                map.put("GMT", "UTC");
                map.put("WET", "WET");
                map.put("CET", "CET");
                map.put("MET", "CET");
                map.put("ECT", "CET");
                map.put("EET", "EET");
                map.put("MIT", "Pacific/Apia");
                map.put("HST", "Pacific/Honolulu");
                map.put("AST", "America/Anchorage");
                map.put("PST", "America/Los_Angeles");
                map.put("MST", "America/Denver");
                map.put("PNT", "America/Phoenix");
                map.put("CST", "America/Chicago");
                map.put("EST", "America/New_York");
                map.put("IET", "America/Indiana/Indianapolis");
                map.put("PRT", "America/Puerto_Rico");
                map.put("CNT", "America/St_Johns");
                map.put("AGT", "America/Argentina/Buenos_Aires");
                map.put("BET", "America/Sao_Paulo");
                map.put("ART", "Africa/Cairo");
                map.put("CAT", "Africa/Harare");
                map.put("EAT", "Africa/Addis_Ababa");
                map.put("NET", "Asia/Yerevan");
                map.put("PLT", "Asia/Karachi");
                map.put("IST", "Asia/Kolkata");
                map.put("BST", "Asia/Dhaka");
                map.put("VST", "Asia/Ho_Chi_Minh");
                map.put("CTT", "Asia/Shanghai");
                map.put("JST", "Asia/Tokyo");
                map.put("ACT", "Australia/Darwin");
                map.put("AET", "Australia/Sydney");
                map.put("SST", "Pacific/Guadalcanal");
                map.put("NST", "Pacific/Auckland");
                cZoneIdConversion = map;
            }
            str2 = (String) map.get(str);
        }
        return str2;
    }

    private static int parseOffset(String str) {
        return -((int) offsetFormatter().withChronology(new BaseChronology() {
            public DateTimeZone getZone() {
                return null;
            }

            public Chronology withUTC() {
                return this;
            }

            public Chronology withZone(DateTimeZone dateTimeZone) {
                return this;
            }

            public String toString() {
                return getClass().getName();
            }
        }).parseMillis(str));
    }

    private static String printOffset(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i >= 0) {
            stringBuffer.append('+');
        } else {
            stringBuffer.append('-');
            i = -i;
        }
        int i2 = i / DateTimeConstants.MILLIS_PER_HOUR;
        FormatUtils.appendPaddedInteger(stringBuffer, i2, 2);
        int i3 = i - (i2 * DateTimeConstants.MILLIS_PER_HOUR);
        int i4 = i3 / DateTimeConstants.MILLIS_PER_MINUTE;
        stringBuffer.append(':');
        FormatUtils.appendPaddedInteger(stringBuffer, i4, 2);
        int i5 = i3 - (i4 * DateTimeConstants.MILLIS_PER_MINUTE);
        if (i5 == 0) {
            return stringBuffer.toString();
        }
        int i6 = i5 / 1000;
        stringBuffer.append(':');
        FormatUtils.appendPaddedInteger(stringBuffer, i6, 2);
        int i7 = i5 - (i6 * 1000);
        if (i7 == 0) {
            return stringBuffer.toString();
        }
        stringBuffer.append('.');
        FormatUtils.appendPaddedInteger(stringBuffer, i7, 3);
        return stringBuffer.toString();
    }

    private static synchronized DateTimeFormatter offsetFormatter() {
        DateTimeFormatter dateTimeFormatter;
        synchronized (DateTimeZone.class) {
            if (cOffsetFormatter == null) {
                cOffsetFormatter = new DateTimeFormatterBuilder().appendTimeZoneOffset((String) null, true, 2, 4).toFormatter();
            }
            dateTimeFormatter = cOffsetFormatter;
        }
        return dateTimeFormatter;
    }

    protected DateTimeZone(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Id must not be null");
        }
        this.iID = str;
    }

    @ToString
    public final String getID() {
        return this.iID;
    }

    public final String getShortName(long j) {
        return getShortName(j, (Locale) null);
    }

    public String getShortName(long j, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String nameKey = getNameKey(j);
        if (nameKey == null) {
            return this.iID;
        }
        String shortName = cNameProvider.getShortName(locale, this.iID, nameKey);
        return shortName == null ? printOffset(getOffset(j)) : shortName;
    }

    public final String getName(long j) {
        return getName(j, (Locale) null);
    }

    public String getName(long j, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String nameKey = getNameKey(j);
        if (nameKey == null) {
            return this.iID;
        }
        String name = cNameProvider.getName(locale, this.iID, nameKey);
        return name == null ? printOffset(getOffset(j)) : name;
    }

    public final int getOffset(ReadableInstant readableInstant) {
        if (readableInstant == null) {
            return getOffset(DateTimeUtils.currentTimeMillis());
        }
        return getOffset(readableInstant.getMillis());
    }

    public boolean isStandardOffset(long j) {
        return getOffset(j) == getStandardOffset(j);
    }

    public int getOffsetFromLocal(long j) {
        int offset = getOffset(j);
        long j2 = j - ((long) offset);
        int offset2 = getOffset(j2);
        if (offset != offset2) {
            if (offset - offset2 < 0 && nextTransition(j2) != nextTransition(j - ((long) offset2))) {
                return offset;
            }
        } else if (offset >= 0) {
            long previousTransition = previousTransition(j2);
            if (previousTransition < j2) {
                int offset3 = getOffset(previousTransition);
                if (j2 - previousTransition <= ((long) (offset3 - offset))) {
                    return offset3;
                }
            }
        }
        return offset2;
    }

    public long convertUTCToLocal(long j) {
        int offset = getOffset(j);
        long j2 = ((long) offset) + j;
        if ((j ^ j2) >= 0 || (((long) offset) ^ j) < 0) {
            return j2;
        }
        throw new ArithmeticException("Adding time zone offset caused overflow");
    }

    public long convertLocalToUTC(long j, boolean z, long j2) {
        int offset = getOffset(j2);
        long j3 = j - ((long) offset);
        return getOffset(j3) == offset ? j3 : convertLocalToUTC(j, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long convertLocalToUTC(long r13, boolean r15) {
        /*
            r12 = this;
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r10 = 0
            int r5 = r12.getOffset((long) r13)
            long r0 = (long) r5
            long r0 = r13 - r0
            int r4 = r12.getOffset((long) r0)
            if (r5 == r4) goto L_0x005e
            if (r15 != 0) goto L_0x0018
            if (r5 >= 0) goto L_0x005e
        L_0x0018:
            long r0 = (long) r5
            long r0 = r13 - r0
            long r0 = r12.nextTransition(r0)
            long r6 = (long) r5
            long r6 = r13 - r6
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x0027
            r0 = r2
        L_0x0027:
            long r6 = (long) r4
            long r6 = r13 - r6
            long r6 = r12.nextTransition(r6)
            long r8 = (long) r4
            long r8 = r13 - r8
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 != 0) goto L_0x0060
        L_0x0035:
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x005e
            if (r15 == 0) goto L_0x0045
            org.joda.time.IllegalInstantException r0 = new org.joda.time.IllegalInstantException
            java.lang.String r1 = r12.getID()
            r0.<init>(r13, r1)
            throw r0
        L_0x0045:
            r0 = r5
        L_0x0046:
            long r1 = (long) r0
            long r1 = r13 - r1
            long r3 = r13 ^ r1
            int r3 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r3 >= 0) goto L_0x005d
            long r3 = (long) r0
            long r3 = r3 ^ r13
            int r0 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r0 >= 0) goto L_0x005d
            java.lang.ArithmeticException r0 = new java.lang.ArithmeticException
            java.lang.String r1 = "Subtracting time zone offset caused overflow"
            r0.<init>(r1)
            throw r0
        L_0x005d:
            return r1
        L_0x005e:
            r0 = r4
            goto L_0x0046
        L_0x0060:
            r2 = r6
            goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.DateTimeZone.convertLocalToUTC(long, boolean):long");
    }

    public long getMillisKeepLocal(DateTimeZone dateTimeZone, long j) {
        DateTimeZone dateTimeZone2;
        if (dateTimeZone == null) {
            dateTimeZone2 = getDefault();
        } else {
            dateTimeZone2 = dateTimeZone;
        }
        return dateTimeZone2 == this ? j : dateTimeZone2.convertLocalToUTC(convertUTCToLocal(j), false, j);
    }

    public boolean isLocalDateTimeGap(LocalDateTime localDateTime) {
        if (isFixed()) {
            return false;
        }
        try {
            localDateTime.toDateTime(this);
            return false;
        } catch (IllegalInstantException e) {
            return true;
        }
    }

    public long adjustOffset(long j, boolean z) {
        long j2 = j - 10800000;
        long offset = (long) getOffset(j2);
        long offset2 = (long) getOffset(10800000 + j);
        if (offset <= offset2) {
            return j;
        }
        long j3 = offset - offset2;
        long nextTransition = nextTransition(j2);
        long j4 = nextTransition - j3;
        long j5 = nextTransition + j3;
        if (j < j4 || j >= j5) {
            return j;
        }
        if (j - j4 < j3) {
            return z ? j + j3 : j;
        }
        if (!z) {
            return j - j3;
        }
        return j;
    }

    public TimeZone toTimeZone() {
        return TimeZone.getTimeZone(this.iID);
    }

    public int hashCode() {
        return getID().hashCode() + 57;
    }

    public String toString() {
        return getID();
    }

    /* access modifiers changed from: protected */
    public Object writeReplace() throws ObjectStreamException {
        return new Stub(this.iID);
    }

    private static final class Stub implements Serializable {
        private static final long serialVersionUID = -6471952376487863581L;
        private transient String iID;

        Stub(String str) {
            this.iID = str;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeUTF(this.iID);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            this.iID = objectInputStream.readUTF();
        }

        private Object readResolve() throws ObjectStreamException {
            return DateTimeZone.forID(this.iID);
        }
    }
}
