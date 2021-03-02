package org.joda.time.convert;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.ReadWritableInterval;
import org.joda.time.ReadWritablePeriod;
import org.joda.time.ReadablePartial;
import org.joda.time.ReadablePeriod;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;

class StringConverter extends AbstractConverter implements InstantConverter, PartialConverter, DurationConverter, PeriodConverter, IntervalConverter {
    static final StringConverter INSTANCE = new StringConverter();

    protected StringConverter() {
    }

    public long getInstantMillis(Object obj, Chronology chronology) {
        return ISODateTimeFormat.dateTimeParser().withChronology(chronology).parseMillis((String) obj);
    }

    public int[] getPartialValues(ReadablePartial readablePartial, Object obj, Chronology chronology, DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter.getZone() != null) {
            chronology = chronology.withZone(dateTimeFormatter.getZone());
        }
        return chronology.get(readablePartial, dateTimeFormatter.withChronology(chronology).parseMillis((String) obj));
    }

    public long getDurationMillis(Object obj) {
        long parseLong;
        long j;
        int i;
        int i2 = 1;
        String str = (String) obj;
        int length = str.length();
        if (length < 4 || !((str.charAt(0) == 'P' || str.charAt(0) == 'p') && ((str.charAt(1) == 'T' || str.charAt(1) == 't') && (str.charAt(length - 1) == 'S' || str.charAt(length - 1) == 's')))) {
            throw new IllegalArgumentException("Invalid format: \"" + str + '\"');
        }
        String substring = str.substring(2, length - 1);
        boolean z = false;
        int i3 = -1;
        for (int i4 = 0; i4 < substring.length(); i4++) {
            if (substring.charAt(i4) < '0' || substring.charAt(i4) > '9') {
                if (i4 == 0 && substring.charAt(0) == '-') {
                    z = true;
                } else {
                    if (z) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i4 > i && substring.charAt(i4) == '.' && i3 == -1) {
                        i3 = i4;
                    } else {
                        throw new IllegalArgumentException("Invalid format: \"" + str + '\"');
                    }
                }
            }
        }
        if (!z) {
            i2 = 0;
        }
        if (i3 > 0) {
            long parseLong2 = Long.parseLong(substring.substring(i2, i3));
            String substring2 = substring.substring(i3 + 1);
            if (substring2.length() != 3) {
                substring2 = (substring2 + "000").substring(0, 3);
            }
            j = (long) Integer.parseInt(substring2);
            parseLong = parseLong2;
        } else if (z) {
            parseLong = Long.parseLong(substring.substring(i2, substring.length()));
            j = 0;
        } else {
            parseLong = Long.parseLong(substring);
            j = 0;
        }
        if (z) {
            return FieldUtils.safeAdd(FieldUtils.safeMultiply(-parseLong, 1000), -j);
        }
        return FieldUtils.safeAdd(FieldUtils.safeMultiply(parseLong, 1000), j);
    }

    public void setInto(ReadWritablePeriod readWritablePeriod, Object obj, Chronology chronology) {
        String str = (String) obj;
        PeriodFormatter standard = ISOPeriodFormat.standard();
        readWritablePeriod.clear();
        int parseInto = standard.parseInto(readWritablePeriod, str, 0);
        if (parseInto < str.length()) {
            if (parseInto < 0) {
                standard.withParseType(readWritablePeriod.getPeriodType()).parseMutablePeriod(str);
            }
            throw new IllegalArgumentException("Invalid format: \"" + str + '\"');
        }
    }

    public void setInto(ReadWritableInterval readWritableInterval, Object obj, Chronology chronology) {
        Chronology chronology2;
        long j;
        Period period = null;
        String str = (String) obj;
        int indexOf = str.indexOf(47);
        if (indexOf < 0) {
            throw new IllegalArgumentException("Format requires a '/' separator: " + str);
        }
        String substring = str.substring(0, indexOf);
        if (substring.length() <= 0) {
            throw new IllegalArgumentException("Format invalid: " + str);
        }
        String substring2 = str.substring(indexOf + 1);
        if (substring2.length() <= 0) {
            throw new IllegalArgumentException("Format invalid: " + str);
        }
        DateTimeFormatter withChronology = ISODateTimeFormat.dateTimeParser().withChronology(chronology);
        PeriodFormatter standard = ISOPeriodFormat.standard();
        long j2 = 0;
        char charAt = substring.charAt(0);
        if (charAt == 'P' || charAt == 'p') {
            period = standard.withParseType(getPeriodType(substring)).parsePeriod(substring);
            chronology2 = null;
        } else {
            DateTime parseDateTime = withChronology.parseDateTime(substring);
            j2 = parseDateTime.getMillis();
            chronology2 = parseDateTime.getChronology();
        }
        char charAt2 = substring2.charAt(0);
        if (charAt2 != 'P' && charAt2 != 'p') {
            DateTime parseDateTime2 = withChronology.parseDateTime(substring2);
            long millis = parseDateTime2.getMillis();
            if (chronology2 == null) {
                chronology2 = parseDateTime2.getChronology();
            }
            if (chronology == null) {
                chronology = chronology2;
            }
            if (period != null) {
                j2 = chronology.add((ReadablePeriod) period, millis, -1);
                j = millis;
            } else {
                j = millis;
            }
        } else if (period != null) {
            throw new IllegalArgumentException("Interval composed of two durations: " + str);
        } else {
            Period parsePeriod = standard.withParseType(getPeriodType(substring2)).parsePeriod(substring2);
            if (chronology == null) {
                chronology = chronology2;
            }
            j = chronology.add((ReadablePeriod) parsePeriod, j2, 1);
        }
        readWritableInterval.setInterval(j2, j);
        readWritableInterval.setChronology(chronology);
    }

    public Class<?> getSupportedType() {
        return String.class;
    }
}
