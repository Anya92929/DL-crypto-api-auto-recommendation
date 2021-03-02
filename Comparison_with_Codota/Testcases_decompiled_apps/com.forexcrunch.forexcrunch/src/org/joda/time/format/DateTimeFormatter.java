package org.joda.time.format;

import com.google.android.gms.appstate.AppStateClient;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadWritableInstant;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;

public class DateTimeFormatter {
    private final Chronology iChrono;
    private final int iDefaultYear;
    private final Locale iLocale;
    private final boolean iOffsetParsed;
    private final DateTimeParser iParser;
    private final Integer iPivotYear;
    private final DateTimePrinter iPrinter;
    private final DateTimeZone iZone;

    public DateTimeFormatter(DateTimePrinter dateTimePrinter, DateTimeParser dateTimeParser) {
        this.iPrinter = dateTimePrinter;
        this.iParser = dateTimeParser;
        this.iLocale = null;
        this.iOffsetParsed = false;
        this.iChrono = null;
        this.iZone = null;
        this.iPivotYear = null;
        this.iDefaultYear = AppStateClient.STATUS_WRITE_OUT_OF_DATE_VERSION;
    }

    private DateTimeFormatter(DateTimePrinter dateTimePrinter, DateTimeParser dateTimeParser, Locale locale, boolean z, Chronology chronology, DateTimeZone dateTimeZone, Integer num, int i) {
        this.iPrinter = dateTimePrinter;
        this.iParser = dateTimeParser;
        this.iLocale = locale;
        this.iOffsetParsed = z;
        this.iChrono = chronology;
        this.iZone = dateTimeZone;
        this.iPivotYear = num;
        this.iDefaultYear = i;
    }

    public boolean isPrinter() {
        return this.iPrinter != null;
    }

    public DateTimePrinter getPrinter() {
        return this.iPrinter;
    }

    public boolean isParser() {
        return this.iParser != null;
    }

    public DateTimeParser getParser() {
        return this.iParser;
    }

    public DateTimeFormatter withLocale(Locale locale) {
        if (locale == getLocale() || (locale != null && locale.equals(getLocale()))) {
            return this;
        }
        return new DateTimeFormatter(this.iPrinter, this.iParser, locale, this.iOffsetParsed, this.iChrono, this.iZone, this.iPivotYear, this.iDefaultYear);
    }

    public Locale getLocale() {
        return this.iLocale;
    }

    public DateTimeFormatter withOffsetParsed() {
        return this.iOffsetParsed ? this : new DateTimeFormatter(this.iPrinter, this.iParser, this.iLocale, true, this.iChrono, (DateTimeZone) null, this.iPivotYear, this.iDefaultYear);
    }

    public boolean isOffsetParsed() {
        return this.iOffsetParsed;
    }

    public DateTimeFormatter withChronology(Chronology chronology) {
        if (this.iChrono == chronology) {
            return this;
        }
        return new DateTimeFormatter(this.iPrinter, this.iParser, this.iLocale, this.iOffsetParsed, chronology, this.iZone, this.iPivotYear, this.iDefaultYear);
    }

    public Chronology getChronology() {
        return this.iChrono;
    }

    @Deprecated
    public Chronology getChronolgy() {
        return this.iChrono;
    }

    public DateTimeFormatter withZoneUTC() {
        return withZone(DateTimeZone.UTC);
    }

    public DateTimeFormatter withZone(DateTimeZone dateTimeZone) {
        if (this.iZone == dateTimeZone) {
            return this;
        }
        return new DateTimeFormatter(this.iPrinter, this.iParser, this.iLocale, false, this.iChrono, dateTimeZone, this.iPivotYear, this.iDefaultYear);
    }

    public DateTimeZone getZone() {
        return this.iZone;
    }

    public DateTimeFormatter withPivotYear(Integer num) {
        if (this.iPivotYear == num || (this.iPivotYear != null && this.iPivotYear.equals(num))) {
            return this;
        }
        return new DateTimeFormatter(this.iPrinter, this.iParser, this.iLocale, this.iOffsetParsed, this.iChrono, this.iZone, num, this.iDefaultYear);
    }

    public DateTimeFormatter withPivotYear(int i) {
        return withPivotYear(Integer.valueOf(i));
    }

    public Integer getPivotYear() {
        return this.iPivotYear;
    }

    public DateTimeFormatter withDefaultYear(int i) {
        return new DateTimeFormatter(this.iPrinter, this.iParser, this.iLocale, this.iOffsetParsed, this.iChrono, this.iZone, this.iPivotYear, i);
    }

    public int getDefaultYear() {
        return this.iDefaultYear;
    }

    public void printTo(StringBuffer stringBuffer, ReadableInstant readableInstant) {
        printTo(stringBuffer, DateTimeUtils.getInstantMillis(readableInstant), DateTimeUtils.getInstantChronology(readableInstant));
    }

    public void printTo(Writer writer, ReadableInstant readableInstant) throws IOException {
        printTo(writer, DateTimeUtils.getInstantMillis(readableInstant), DateTimeUtils.getInstantChronology(readableInstant));
    }

    public void printTo(Appendable appendable, ReadableInstant readableInstant) throws IOException {
        appendable.append(print(readableInstant));
    }

    public void printTo(StringBuffer stringBuffer, long j) {
        printTo(stringBuffer, j, (Chronology) null);
    }

    public void printTo(Writer writer, long j) throws IOException {
        printTo(writer, j, (Chronology) null);
    }

    public void printTo(Appendable appendable, long j) throws IOException {
        appendable.append(print(j));
    }

    public void printTo(StringBuffer stringBuffer, ReadablePartial readablePartial) {
        DateTimePrinter requirePrinter = requirePrinter();
        if (readablePartial == null) {
            throw new IllegalArgumentException("The partial must not be null");
        }
        requirePrinter.printTo(stringBuffer, readablePartial, this.iLocale);
    }

    public void printTo(Writer writer, ReadablePartial readablePartial) throws IOException {
        DateTimePrinter requirePrinter = requirePrinter();
        if (readablePartial == null) {
            throw new IllegalArgumentException("The partial must not be null");
        }
        requirePrinter.printTo(writer, readablePartial, this.iLocale);
    }

    public void printTo(Appendable appendable, ReadablePartial readablePartial) throws IOException {
        appendable.append(print(readablePartial));
    }

    public String print(ReadableInstant readableInstant) {
        StringBuffer stringBuffer = new StringBuffer(requirePrinter().estimatePrintedLength());
        printTo(stringBuffer, readableInstant);
        return stringBuffer.toString();
    }

    public String print(long j) {
        StringBuffer stringBuffer = new StringBuffer(requirePrinter().estimatePrintedLength());
        printTo(stringBuffer, j);
        return stringBuffer.toString();
    }

    public String print(ReadablePartial readablePartial) {
        StringBuffer stringBuffer = new StringBuffer(requirePrinter().estimatePrintedLength());
        printTo(stringBuffer, readablePartial);
        return stringBuffer.toString();
    }

    private void printTo(StringBuffer stringBuffer, long j, Chronology chronology) {
        DateTimePrinter requirePrinter = requirePrinter();
        Chronology selectChronology = selectChronology(chronology);
        DateTimeZone zone = selectChronology.getZone();
        int offset = zone.getOffset(j);
        long j2 = ((long) offset) + j;
        if ((j ^ j2) < 0 && (((long) offset) ^ j) >= 0) {
            zone = DateTimeZone.UTC;
            offset = 0;
            j2 = j;
        }
        requirePrinter.printTo(stringBuffer, j2, selectChronology.withUTC(), offset, zone, this.iLocale);
    }

    private void printTo(Writer writer, long j, Chronology chronology) throws IOException {
        DateTimePrinter requirePrinter = requirePrinter();
        Chronology selectChronology = selectChronology(chronology);
        DateTimeZone zone = selectChronology.getZone();
        int offset = zone.getOffset(j);
        long j2 = ((long) offset) + j;
        if ((j ^ j2) < 0 && (((long) offset) ^ j) >= 0) {
            zone = DateTimeZone.UTC;
            offset = 0;
            j2 = j;
        }
        requirePrinter.printTo(writer, j2, selectChronology.withUTC(), offset, zone, this.iLocale);
    }

    private DateTimePrinter requirePrinter() {
        DateTimePrinter dateTimePrinter = this.iPrinter;
        if (dateTimePrinter != null) {
            return dateTimePrinter;
        }
        throw new UnsupportedOperationException("Printing not supported");
    }

    public int parseInto(ReadWritableInstant readWritableInstant, String str, int i) {
        DateTimeParser requireParser = requireParser();
        if (readWritableInstant == null) {
            throw new IllegalArgumentException("Instant must not be null");
        }
        long millis = readWritableInstant.getMillis();
        Chronology chronology = readWritableInstant.getChronology();
        long offset = millis + ((long) chronology.getZone().getOffset(millis));
        Chronology selectChronology = selectChronology(chronology);
        DateTimeParserBucket dateTimeParserBucket = new DateTimeParserBucket(offset, selectChronology, this.iLocale, this.iPivotYear, selectChronology.year().get(offset));
        int parseInto = requireParser.parseInto(dateTimeParserBucket, str, i);
        readWritableInstant.setMillis(dateTimeParserBucket.computeMillis(false, str));
        if (this.iOffsetParsed && dateTimeParserBucket.getOffsetInteger() != null) {
            selectChronology = selectChronology.withZone(DateTimeZone.forOffsetMillis(dateTimeParserBucket.getOffsetInteger().intValue()));
        } else if (dateTimeParserBucket.getZone() != null) {
            selectChronology = selectChronology.withZone(dateTimeParserBucket.getZone());
        }
        readWritableInstant.setChronology(selectChronology);
        if (this.iZone != null) {
            readWritableInstant.setZone(this.iZone);
        }
        return parseInto;
    }

    public long parseMillis(String str) {
        int i;
        DateTimeParser requireParser = requireParser();
        DateTimeParserBucket dateTimeParserBucket = new DateTimeParserBucket(0, selectChronology(this.iChrono), this.iLocale, this.iPivotYear, this.iDefaultYear);
        int parseInto = requireParser.parseInto(dateTimeParserBucket, str, 0);
        if (parseInto < 0) {
            i = parseInto ^ -1;
        } else if (parseInto >= str.length()) {
            return dateTimeParserBucket.computeMillis(true, str);
        } else {
            i = parseInto;
        }
        throw new IllegalArgumentException(FormatUtils.createErrorMessage(str, i));
    }

    public LocalDate parseLocalDate(String str) {
        return parseLocalDateTime(str).toLocalDate();
    }

    public LocalTime parseLocalTime(String str) {
        return parseLocalDateTime(str).toLocalTime();
    }

    public LocalDateTime parseLocalDateTime(String str) {
        int i;
        DateTimeParser requireParser = requireParser();
        Chronology withUTC = selectChronology((Chronology) null).withUTC();
        DateTimeParserBucket dateTimeParserBucket = new DateTimeParserBucket(0, withUTC, this.iLocale, this.iPivotYear, this.iDefaultYear);
        int parseInto = requireParser.parseInto(dateTimeParserBucket, str, 0);
        if (parseInto < 0) {
            i = parseInto ^ -1;
        } else if (parseInto >= str.length()) {
            long computeMillis = dateTimeParserBucket.computeMillis(true, str);
            if (dateTimeParserBucket.getOffsetInteger() != null) {
                withUTC = withUTC.withZone(DateTimeZone.forOffsetMillis(dateTimeParserBucket.getOffsetInteger().intValue()));
            } else if (dateTimeParserBucket.getZone() != null) {
                withUTC = withUTC.withZone(dateTimeParserBucket.getZone());
            }
            return new LocalDateTime(computeMillis, withUTC);
        } else {
            i = parseInto;
        }
        throw new IllegalArgumentException(FormatUtils.createErrorMessage(str, i));
    }

    public DateTime parseDateTime(String str) {
        int i;
        DateTimeParser requireParser = requireParser();
        Chronology selectChronology = selectChronology((Chronology) null);
        DateTimeParserBucket dateTimeParserBucket = new DateTimeParserBucket(0, selectChronology, this.iLocale, this.iPivotYear, this.iDefaultYear);
        int parseInto = requireParser.parseInto(dateTimeParserBucket, str, 0);
        if (parseInto < 0) {
            i = parseInto ^ -1;
        } else if (parseInto >= str.length()) {
            long computeMillis = dateTimeParserBucket.computeMillis(true, str);
            if (this.iOffsetParsed && dateTimeParserBucket.getOffsetInteger() != null) {
                selectChronology = selectChronology.withZone(DateTimeZone.forOffsetMillis(dateTimeParserBucket.getOffsetInteger().intValue()));
            } else if (dateTimeParserBucket.getZone() != null) {
                selectChronology = selectChronology.withZone(dateTimeParserBucket.getZone());
            }
            DateTime dateTime = new DateTime(computeMillis, selectChronology);
            if (this.iZone != null) {
                return dateTime.withZone(this.iZone);
            }
            return dateTime;
        } else {
            i = parseInto;
        }
        throw new IllegalArgumentException(FormatUtils.createErrorMessage(str, i));
    }

    public MutableDateTime parseMutableDateTime(String str) {
        int i;
        DateTimeParser requireParser = requireParser();
        Chronology selectChronology = selectChronology((Chronology) null);
        DateTimeParserBucket dateTimeParserBucket = new DateTimeParserBucket(0, selectChronology, this.iLocale, this.iPivotYear, this.iDefaultYear);
        int parseInto = requireParser.parseInto(dateTimeParserBucket, str, 0);
        if (parseInto < 0) {
            i = parseInto ^ -1;
        } else if (parseInto >= str.length()) {
            long computeMillis = dateTimeParserBucket.computeMillis(true, str);
            if (this.iOffsetParsed && dateTimeParserBucket.getOffsetInteger() != null) {
                selectChronology = selectChronology.withZone(DateTimeZone.forOffsetMillis(dateTimeParserBucket.getOffsetInteger().intValue()));
            } else if (dateTimeParserBucket.getZone() != null) {
                selectChronology = selectChronology.withZone(dateTimeParserBucket.getZone());
            }
            MutableDateTime mutableDateTime = new MutableDateTime(computeMillis, selectChronology);
            if (this.iZone != null) {
                mutableDateTime.setZone(this.iZone);
            }
            return mutableDateTime;
        } else {
            i = parseInto;
        }
        throw new IllegalArgumentException(FormatUtils.createErrorMessage(str, i));
    }

    private DateTimeParser requireParser() {
        DateTimeParser dateTimeParser = this.iParser;
        if (dateTimeParser != null) {
            return dateTimeParser;
        }
        throw new UnsupportedOperationException("Parsing not supported");
    }

    private Chronology selectChronology(Chronology chronology) {
        Chronology chronology2 = DateTimeUtils.getChronology(chronology);
        if (this.iChrono != null) {
            chronology2 = this.iChrono;
        }
        if (this.iZone != null) {
            return chronology2.withZone(this.iZone);
        }
        return chronology2;
    }
}
