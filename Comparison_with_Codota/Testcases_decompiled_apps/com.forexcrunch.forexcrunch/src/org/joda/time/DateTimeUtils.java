package org.joda.time;

import java.text.DateFormatSymbols;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.joda.time.chrono.ISOChronology;

public class DateTimeUtils {
    private static final SystemMillisProvider SYSTEM_MILLIS_PROVIDER = new SystemMillisProvider();
    private static volatile MillisProvider cMillisProvider = SYSTEM_MILLIS_PROVIDER;
    private static volatile Map<String, DateTimeZone> cZoneNames;

    public interface MillisProvider {
        long getMillis();
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("UT", DateTimeZone.UTC);
        linkedHashMap.put("UTC", DateTimeZone.UTC);
        linkedHashMap.put("GMT", DateTimeZone.UTC);
        put(linkedHashMap, "EST", "America/New_York");
        put(linkedHashMap, "EDT", "America/New_York");
        put(linkedHashMap, "CST", "America/Chicago");
        put(linkedHashMap, "CDT", "America/Chicago");
        put(linkedHashMap, "MST", "America/Denver");
        put(linkedHashMap, "MDT", "America/Denver");
        put(linkedHashMap, "PST", "America/Los_Angeles");
        put(linkedHashMap, "PDT", "America/Los_Angeles");
        cZoneNames = Collections.unmodifiableMap(linkedHashMap);
    }

    private static void put(Map<String, DateTimeZone> map, String str, String str2) {
        try {
            map.put(str, DateTimeZone.forID(str2));
        } catch (RuntimeException e) {
        }
    }

    protected DateTimeUtils() {
    }

    public static final long currentTimeMillis() {
        return cMillisProvider.getMillis();
    }

    public static final void setCurrentMillisSystem() throws SecurityException {
        checkPermission();
        cMillisProvider = SYSTEM_MILLIS_PROVIDER;
    }

    public static final void setCurrentMillisFixed(long j) throws SecurityException {
        checkPermission();
        cMillisProvider = new FixedMillisProvider(j);
    }

    public static final void setCurrentMillisOffset(long j) throws SecurityException {
        checkPermission();
        if (j == 0) {
            cMillisProvider = SYSTEM_MILLIS_PROVIDER;
        } else {
            cMillisProvider = new OffsetMillisProvider(j);
        }
    }

    public static final void setCurrentMillisProvider(MillisProvider millisProvider) throws SecurityException {
        if (millisProvider == null) {
            throw new IllegalArgumentException("The MillisProvider must not be null");
        }
        checkPermission();
        cMillisProvider = millisProvider;
    }

    private static void checkPermission() throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("CurrentTime.setProvider"));
        }
    }

    public static final long getInstantMillis(ReadableInstant readableInstant) {
        if (readableInstant == null) {
            return currentTimeMillis();
        }
        return readableInstant.getMillis();
    }

    public static final Chronology getInstantChronology(ReadableInstant readableInstant) {
        if (readableInstant == null) {
            return ISOChronology.getInstance();
        }
        Chronology chronology = readableInstant.getChronology();
        if (chronology == null) {
            return ISOChronology.getInstance();
        }
        return chronology;
    }

    public static final Chronology getIntervalChronology(ReadableInstant readableInstant, ReadableInstant readableInstant2) {
        Chronology chronology = null;
        if (readableInstant != null) {
            chronology = readableInstant.getChronology();
        } else if (readableInstant2 != null) {
            chronology = readableInstant2.getChronology();
        }
        if (chronology == null) {
            return ISOChronology.getInstance();
        }
        return chronology;
    }

    public static final Chronology getIntervalChronology(ReadableInterval readableInterval) {
        if (readableInterval == null) {
            return ISOChronology.getInstance();
        }
        Chronology chronology = readableInterval.getChronology();
        if (chronology == null) {
            return ISOChronology.getInstance();
        }
        return chronology;
    }

    public static final ReadableInterval getReadableInterval(ReadableInterval readableInterval) {
        if (readableInterval != null) {
            return readableInterval;
        }
        long currentTimeMillis = currentTimeMillis();
        return new Interval(currentTimeMillis, currentTimeMillis);
    }

    public static final Chronology getChronology(Chronology chronology) {
        if (chronology == null) {
            return ISOChronology.getInstance();
        }
        return chronology;
    }

    public static final DateTimeZone getZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            return DateTimeZone.getDefault();
        }
        return dateTimeZone;
    }

    public static final PeriodType getPeriodType(PeriodType periodType) {
        if (periodType == null) {
            return PeriodType.standard();
        }
        return periodType;
    }

    public static final long getDurationMillis(ReadableDuration readableDuration) {
        if (readableDuration == null) {
            return 0;
        }
        return readableDuration.getMillis();
    }

    public static final boolean isContiguous(ReadablePartial readablePartial) {
        if (readablePartial == null) {
            throw new IllegalArgumentException("Partial must not be null");
        }
        DurationFieldType durationFieldType = null;
        for (int i = 0; i < readablePartial.size(); i++) {
            DateTimeField field = readablePartial.getField(i);
            if (i > 0 && field.getRangeDurationField().getType() != durationFieldType) {
                return false;
            }
            durationFieldType = field.getDurationField().getType();
        }
        return true;
    }

    public static final DateFormatSymbols getDateFormatSymbols(Locale locale) {
        try {
            return (DateFormatSymbols) DateFormatSymbols.class.getMethod("getInstance", new Class[]{Locale.class}).invoke((Object) null, new Object[]{locale});
        } catch (Exception e) {
            return new DateFormatSymbols(locale);
        }
    }

    public static final Map<String, DateTimeZone> getDefaultTimeZoneNames() {
        return cZoneNames;
    }

    public static final void setDefaultTimeZoneNames(Map<String, DateTimeZone> map) {
        cZoneNames = Collections.unmodifiableMap(new HashMap(map));
    }

    public static final double toJulianDay(long j) {
        return (((double) j) / 8.64E7d) + 2440587.5d;
    }

    public static final long toJulianDayNumber(long j) {
        return (long) Math.floor(toJulianDay(j) + 0.5d);
    }

    public static final long fromJulianDay(double d) {
        return (long) ((d - 2440587.5d) * 8.64E7d);
    }

    static class SystemMillisProvider implements MillisProvider {
        SystemMillisProvider() {
        }

        public long getMillis() {
            return System.currentTimeMillis();
        }
    }

    static class FixedMillisProvider implements MillisProvider {
        private final long iMillis;

        FixedMillisProvider(long j) {
            this.iMillis = j;
        }

        public long getMillis() {
            return this.iMillis;
        }
    }

    static class OffsetMillisProvider implements MillisProvider {
        private final long iMillis;

        OffsetMillisProvider(long j) {
            this.iMillis = j;
        }

        public long getMillis() {
            return System.currentTimeMillis() + this.iMillis;
        }
    }
}
