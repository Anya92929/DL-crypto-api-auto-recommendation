package org.joda.time.format;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.joda.time.Chronology;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadablePartial;
import org.joda.time.field.MillisDurationField;
import org.joda.time.field.PreciseDateTimeField;

public class DateTimeFormatterBuilder {
    private ArrayList<Object> iElementPairs = new ArrayList<>();
    private Object iFormatter;

    public DateTimeFormatter toFormatter() {
        DateTimePrinter dateTimePrinter;
        DateTimeParser dateTimeParser;
        Object formatter = getFormatter();
        if (isPrinter(formatter)) {
            dateTimePrinter = (DateTimePrinter) formatter;
        } else {
            dateTimePrinter = null;
        }
        if (isParser(formatter)) {
            dateTimeParser = (DateTimeParser) formatter;
        } else {
            dateTimeParser = null;
        }
        if (dateTimePrinter != null || dateTimeParser != null) {
            return new DateTimeFormatter(dateTimePrinter, dateTimeParser);
        }
        throw new UnsupportedOperationException("Both printing and parsing not supported");
    }

    public DateTimePrinter toPrinter() {
        Object formatter = getFormatter();
        if (isPrinter(formatter)) {
            return (DateTimePrinter) formatter;
        }
        throw new UnsupportedOperationException("Printing is not supported");
    }

    public DateTimeParser toParser() {
        Object formatter = getFormatter();
        if (isParser(formatter)) {
            return (DateTimeParser) formatter;
        }
        throw new UnsupportedOperationException("Parsing is not supported");
    }

    public boolean canBuildFormatter() {
        return isFormatter(getFormatter());
    }

    public boolean canBuildPrinter() {
        return isPrinter(getFormatter());
    }

    public boolean canBuildParser() {
        return isParser(getFormatter());
    }

    public void clear() {
        this.iFormatter = null;
        this.iElementPairs.clear();
    }

    public DateTimeFormatterBuilder append(DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter != null) {
            return append0(dateTimeFormatter.getPrinter(), dateTimeFormatter.getParser());
        }
        throw new IllegalArgumentException("No formatter supplied");
    }

    public DateTimeFormatterBuilder append(DateTimePrinter dateTimePrinter) {
        checkPrinter(dateTimePrinter);
        return append0(dateTimePrinter, (DateTimeParser) null);
    }

    public DateTimeFormatterBuilder append(DateTimeParser dateTimeParser) {
        checkParser(dateTimeParser);
        return append0((DateTimePrinter) null, dateTimeParser);
    }

    public DateTimeFormatterBuilder append(DateTimePrinter dateTimePrinter, DateTimeParser dateTimeParser) {
        checkPrinter(dateTimePrinter);
        checkParser(dateTimeParser);
        return append0(dateTimePrinter, dateTimeParser);
    }

    public DateTimeFormatterBuilder append(DateTimePrinter dateTimePrinter, DateTimeParser[] dateTimeParserArr) {
        int i = 0;
        if (dateTimePrinter != null) {
            checkPrinter(dateTimePrinter);
        }
        if (dateTimeParserArr == null) {
            throw new IllegalArgumentException("No parsers supplied");
        }
        int length = dateTimeParserArr.length;
        if (length != 1) {
            DateTimeParser[] dateTimeParserArr2 = new DateTimeParser[length];
            while (i < length - 1) {
                DateTimeParser dateTimeParser = dateTimeParserArr[i];
                dateTimeParserArr2[i] = dateTimeParser;
                if (dateTimeParser == null) {
                    throw new IllegalArgumentException("Incomplete parser array");
                }
                i++;
            }
            dateTimeParserArr2[i] = dateTimeParserArr[i];
            return append0(dateTimePrinter, new MatchingParser(dateTimeParserArr2));
        } else if (dateTimeParserArr[0] != null) {
            return append0(dateTimePrinter, dateTimeParserArr[0]);
        } else {
            throw new IllegalArgumentException("No parser supplied");
        }
    }

    public DateTimeFormatterBuilder appendOptional(DateTimeParser dateTimeParser) {
        checkParser(dateTimeParser);
        return append0((DateTimePrinter) null, new MatchingParser(new DateTimeParser[]{dateTimeParser, null}));
    }

    private void checkParser(DateTimeParser dateTimeParser) {
        if (dateTimeParser == null) {
            throw new IllegalArgumentException("No parser supplied");
        }
    }

    private void checkPrinter(DateTimePrinter dateTimePrinter) {
        if (dateTimePrinter == null) {
            throw new IllegalArgumentException("No printer supplied");
        }
    }

    private DateTimeFormatterBuilder append0(Object obj) {
        this.iFormatter = null;
        this.iElementPairs.add(obj);
        this.iElementPairs.add(obj);
        return this;
    }

    private DateTimeFormatterBuilder append0(DateTimePrinter dateTimePrinter, DateTimeParser dateTimeParser) {
        this.iFormatter = null;
        this.iElementPairs.add(dateTimePrinter);
        this.iElementPairs.add(dateTimeParser);
        return this;
    }

    public DateTimeFormatterBuilder appendLiteral(char c) {
        return append0(new CharacterLiteral(c));
    }

    public DateTimeFormatterBuilder appendLiteral(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Literal must not be null");
        }
        switch (str.length()) {
            case 0:
                return this;
            case 1:
                return append0(new CharacterLiteral(str.charAt(0)));
            default:
                return append0(new StringLiteral(str));
        }
    }

    public DateTimeFormatterBuilder appendDecimal(DateTimeFieldType dateTimeFieldType, int i, int i2) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i2 < i) {
            i2 = i;
        }
        if (i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        } else if (i <= 1) {
            return append0(new UnpaddedNumber(dateTimeFieldType, i2, false));
        } else {
            return append0(new PaddedNumber(dateTimeFieldType, i2, false, i));
        }
    }

    public DateTimeFormatterBuilder appendFixedDecimal(DateTimeFieldType dateTimeFieldType, int i) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        } else if (i > 0) {
            return append0(new FixedNumber(dateTimeFieldType, i, false));
        } else {
            throw new IllegalArgumentException("Illegal number of digits: " + i);
        }
    }

    public DateTimeFormatterBuilder appendSignedDecimal(DateTimeFieldType dateTimeFieldType, int i, int i2) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i2 < i) {
            i2 = i;
        }
        if (i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        } else if (i <= 1) {
            return append0(new UnpaddedNumber(dateTimeFieldType, i2, true));
        } else {
            return append0(new PaddedNumber(dateTimeFieldType, i2, true, i));
        }
    }

    public DateTimeFormatterBuilder appendFixedSignedDecimal(DateTimeFieldType dateTimeFieldType, int i) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        } else if (i > 0) {
            return append0(new FixedNumber(dateTimeFieldType, i, true));
        } else {
            throw new IllegalArgumentException("Illegal number of digits: " + i);
        }
    }

    public DateTimeFormatterBuilder appendText(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            return append0(new TextField(dateTimeFieldType, false));
        }
        throw new IllegalArgumentException("Field type must not be null");
    }

    public DateTimeFormatterBuilder appendShortText(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            return append0(new TextField(dateTimeFieldType, true));
        }
        throw new IllegalArgumentException("Field type must not be null");
    }

    public DateTimeFormatterBuilder appendFraction(DateTimeFieldType dateTimeFieldType, int i, int i2) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i2 < i) {
            i2 = i;
        }
        if (i >= 0 && i2 > 0) {
            return append0(new Fraction(dateTimeFieldType, i, i2));
        }
        throw new IllegalArgumentException();
    }

    public DateTimeFormatterBuilder appendFractionOfSecond(int i, int i2) {
        return appendFraction(DateTimeFieldType.secondOfDay(), i, i2);
    }

    public DateTimeFormatterBuilder appendFractionOfMinute(int i, int i2) {
        return appendFraction(DateTimeFieldType.minuteOfDay(), i, i2);
    }

    public DateTimeFormatterBuilder appendFractionOfHour(int i, int i2) {
        return appendFraction(DateTimeFieldType.hourOfDay(), i, i2);
    }

    public DateTimeFormatterBuilder appendFractionOfDay(int i, int i2) {
        return appendFraction(DateTimeFieldType.dayOfYear(), i, i2);
    }

    public DateTimeFormatterBuilder appendMillisOfSecond(int i) {
        return appendDecimal(DateTimeFieldType.millisOfSecond(), i, 3);
    }

    public DateTimeFormatterBuilder appendMillisOfDay(int i) {
        return appendDecimal(DateTimeFieldType.millisOfDay(), i, 8);
    }

    public DateTimeFormatterBuilder appendSecondOfMinute(int i) {
        return appendDecimal(DateTimeFieldType.secondOfMinute(), i, 2);
    }

    public DateTimeFormatterBuilder appendSecondOfDay(int i) {
        return appendDecimal(DateTimeFieldType.secondOfDay(), i, 5);
    }

    public DateTimeFormatterBuilder appendMinuteOfHour(int i) {
        return appendDecimal(DateTimeFieldType.minuteOfHour(), i, 2);
    }

    public DateTimeFormatterBuilder appendMinuteOfDay(int i) {
        return appendDecimal(DateTimeFieldType.minuteOfDay(), i, 4);
    }

    public DateTimeFormatterBuilder appendHourOfDay(int i) {
        return appendDecimal(DateTimeFieldType.hourOfDay(), i, 2);
    }

    public DateTimeFormatterBuilder appendClockhourOfDay(int i) {
        return appendDecimal(DateTimeFieldType.clockhourOfDay(), i, 2);
    }

    public DateTimeFormatterBuilder appendHourOfHalfday(int i) {
        return appendDecimal(DateTimeFieldType.hourOfHalfday(), i, 2);
    }

    public DateTimeFormatterBuilder appendClockhourOfHalfday(int i) {
        return appendDecimal(DateTimeFieldType.clockhourOfHalfday(), i, 2);
    }

    public DateTimeFormatterBuilder appendDayOfWeek(int i) {
        return appendDecimal(DateTimeFieldType.dayOfWeek(), i, 1);
    }

    public DateTimeFormatterBuilder appendDayOfMonth(int i) {
        return appendDecimal(DateTimeFieldType.dayOfMonth(), i, 2);
    }

    public DateTimeFormatterBuilder appendDayOfYear(int i) {
        return appendDecimal(DateTimeFieldType.dayOfYear(), i, 3);
    }

    public DateTimeFormatterBuilder appendWeekOfWeekyear(int i) {
        return appendDecimal(DateTimeFieldType.weekOfWeekyear(), i, 2);
    }

    public DateTimeFormatterBuilder appendWeekyear(int i, int i2) {
        return appendSignedDecimal(DateTimeFieldType.weekyear(), i, i2);
    }

    public DateTimeFormatterBuilder appendMonthOfYear(int i) {
        return appendDecimal(DateTimeFieldType.monthOfYear(), i, 2);
    }

    public DateTimeFormatterBuilder appendYear(int i, int i2) {
        return appendSignedDecimal(DateTimeFieldType.year(), i, i2);
    }

    public DateTimeFormatterBuilder appendTwoDigitYear(int i) {
        return appendTwoDigitYear(i, false);
    }

    public DateTimeFormatterBuilder appendTwoDigitYear(int i, boolean z) {
        return append0(new TwoDigitYear(DateTimeFieldType.year(), i, z));
    }

    public DateTimeFormatterBuilder appendTwoDigitWeekyear(int i) {
        return appendTwoDigitWeekyear(i, false);
    }

    public DateTimeFormatterBuilder appendTwoDigitWeekyear(int i, boolean z) {
        return append0(new TwoDigitYear(DateTimeFieldType.weekyear(), i, z));
    }

    public DateTimeFormatterBuilder appendYearOfEra(int i, int i2) {
        return appendDecimal(DateTimeFieldType.yearOfEra(), i, i2);
    }

    public DateTimeFormatterBuilder appendYearOfCentury(int i, int i2) {
        return appendDecimal(DateTimeFieldType.yearOfCentury(), i, i2);
    }

    public DateTimeFormatterBuilder appendCenturyOfEra(int i, int i2) {
        return appendSignedDecimal(DateTimeFieldType.centuryOfEra(), i, i2);
    }

    public DateTimeFormatterBuilder appendHalfdayOfDayText() {
        return appendText(DateTimeFieldType.halfdayOfDay());
    }

    public DateTimeFormatterBuilder appendDayOfWeekText() {
        return appendText(DateTimeFieldType.dayOfWeek());
    }

    public DateTimeFormatterBuilder appendDayOfWeekShortText() {
        return appendShortText(DateTimeFieldType.dayOfWeek());
    }

    public DateTimeFormatterBuilder appendMonthOfYearText() {
        return appendText(DateTimeFieldType.monthOfYear());
    }

    public DateTimeFormatterBuilder appendMonthOfYearShortText() {
        return appendShortText(DateTimeFieldType.monthOfYear());
    }

    public DateTimeFormatterBuilder appendEraText() {
        return appendText(DateTimeFieldType.era());
    }

    public DateTimeFormatterBuilder appendTimeZoneName() {
        return append0(new TimeZoneName(0, (Map<String, DateTimeZone>) null), (DateTimeParser) null);
    }

    public DateTimeFormatterBuilder appendTimeZoneName(Map<String, DateTimeZone> map) {
        TimeZoneName timeZoneName = new TimeZoneName(0, map);
        return append0(timeZoneName, timeZoneName);
    }

    public DateTimeFormatterBuilder appendTimeZoneShortName() {
        return append0(new TimeZoneName(1, (Map<String, DateTimeZone>) null), (DateTimeParser) null);
    }

    public DateTimeFormatterBuilder appendTimeZoneShortName(Map<String, DateTimeZone> map) {
        TimeZoneName timeZoneName = new TimeZoneName(1, map);
        return append0(timeZoneName, timeZoneName);
    }

    public DateTimeFormatterBuilder appendTimeZoneId() {
        return append0(TimeZoneId.INSTANCE, TimeZoneId.INSTANCE);
    }

    public DateTimeFormatterBuilder appendTimeZoneOffset(String str, boolean z, int i, int i2) {
        return append0(new TimeZoneOffset(str, str, z, i, i2));
    }

    public DateTimeFormatterBuilder appendTimeZoneOffset(String str, String str2, boolean z, int i, int i2) {
        return append0(new TimeZoneOffset(str, str2, z, i, i2));
    }

    public DateTimeFormatterBuilder appendPattern(String str) {
        DateTimeFormat.appendPatternTo(this, str);
        return this;
    }

    private Object getFormatter() {
        Object obj = this.iFormatter;
        if (obj == null) {
            if (this.iElementPairs.size() == 2) {
                Object obj2 = this.iElementPairs.get(0);
                Object obj3 = this.iElementPairs.get(1);
                if (obj2 == null) {
                    obj = obj3;
                } else if (obj2 == obj3 || obj3 == null) {
                    obj = obj2;
                }
            }
            if (obj == null) {
                obj = new Composite(this.iElementPairs);
            }
            this.iFormatter = obj;
        }
        return obj;
    }

    private boolean isPrinter(Object obj) {
        if (!(obj instanceof DateTimePrinter)) {
            return false;
        }
        if (obj instanceof Composite) {
            return ((Composite) obj).isPrinter();
        }
        return true;
    }

    private boolean isParser(Object obj) {
        if (!(obj instanceof DateTimeParser)) {
            return false;
        }
        if (obj instanceof Composite) {
            return ((Composite) obj).isParser();
        }
        return true;
    }

    private boolean isFormatter(Object obj) {
        return isPrinter(obj) || isParser(obj);
    }

    static void appendUnknownString(StringBuffer stringBuffer, int i) {
        while (true) {
            i--;
            if (i >= 0) {
                stringBuffer.append(65533);
            } else {
                return;
            }
        }
    }

    static void printUnknownString(Writer writer, int i) throws IOException {
        while (true) {
            i--;
            if (i >= 0) {
                writer.write(65533);
            } else {
                return;
            }
        }
    }

    static class CharacterLiteral implements DateTimePrinter, DateTimeParser {
        private final char iValue;

        CharacterLiteral(char c) {
            this.iValue = c;
        }

        public int estimatePrintedLength() {
            return 1;
        }

        public void printTo(StringBuffer stringBuffer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) {
            stringBuffer.append(this.iValue);
        }

        public void printTo(Writer writer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            writer.write(this.iValue);
        }

        public void printTo(StringBuffer stringBuffer, ReadablePartial readablePartial, Locale locale) {
            stringBuffer.append(this.iValue);
        }

        public void printTo(Writer writer, ReadablePartial readablePartial, Locale locale) throws IOException {
            writer.write(this.iValue);
        }

        public int estimateParsedLength() {
            return 1;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, String str, int i) {
            char upperCase;
            char upperCase2;
            if (i >= str.length()) {
                return i ^ -1;
            }
            char charAt = str.charAt(i);
            char c = this.iValue;
            if (charAt == c || (upperCase = Character.toUpperCase(charAt)) == (upperCase2 = Character.toUpperCase(c)) || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) {
                return i + 1;
            }
            return i ^ -1;
        }
    }

    static class StringLiteral implements DateTimePrinter, DateTimeParser {
        private final String iValue;

        StringLiteral(String str) {
            this.iValue = str;
        }

        public int estimatePrintedLength() {
            return this.iValue.length();
        }

        public void printTo(StringBuffer stringBuffer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) {
            stringBuffer.append(this.iValue);
        }

        public void printTo(Writer writer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            writer.write(this.iValue);
        }

        public void printTo(StringBuffer stringBuffer, ReadablePartial readablePartial, Locale locale) {
            stringBuffer.append(this.iValue);
        }

        public void printTo(Writer writer, ReadablePartial readablePartial, Locale locale) throws IOException {
            writer.write(this.iValue);
        }

        public int estimateParsedLength() {
            return this.iValue.length();
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, String str, int i) {
            if (str.regionMatches(true, i, this.iValue, 0, this.iValue.length())) {
                return this.iValue.length() + i;
            }
            return i ^ -1;
        }
    }

    static abstract class NumberFormatter implements DateTimePrinter, DateTimeParser {
        protected final DateTimeFieldType iFieldType;
        protected final int iMaxParsedDigits;
        protected final boolean iSigned;

        NumberFormatter(DateTimeFieldType dateTimeFieldType, int i, boolean z) {
            this.iFieldType = dateTimeFieldType;
            this.iMaxParsedDigits = i;
            this.iSigned = z;
        }

        public int estimateParsedLength() {
            return this.iMaxParsedDigits;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a3, code lost:
            r4 = r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int parseInto(org.joda.time.format.DateTimeParserBucket r12, java.lang.String r13, int r14) {
            /*
                r11 = this;
                r9 = 57
                r8 = 48
                r7 = 45
                r3 = 0
                int r0 = r11.iMaxParsedDigits
                int r1 = r13.length()
                int r1 = r1 - r14
                int r0 = java.lang.Math.min(r0, r1)
                r2 = r3
                r4 = r0
                r1 = r14
                r0 = r3
            L_0x0016:
                if (r0 >= r4) goto L_0x00a3
                int r5 = r1 + r0
                char r5 = r13.charAt(r5)
                if (r0 != 0) goto L_0x0058
                if (r5 == r7) goto L_0x0026
                r6 = 43
                if (r5 != r6) goto L_0x0058
            L_0x0026:
                boolean r6 = r11.iSigned
                if (r6 == 0) goto L_0x0058
                if (r5 != r7) goto L_0x0043
                r2 = 1
            L_0x002d:
                int r5 = r0 + 1
                if (r5 >= r4) goto L_0x00a3
                int r5 = r1 + r0
                int r5 = r5 + 1
                char r5 = r13.charAt(r5)
                if (r5 < r8) goto L_0x00a3
                if (r5 <= r9) goto L_0x0045
                r4 = r2
            L_0x003e:
                if (r0 != 0) goto L_0x0061
                r1 = r1 ^ -1
            L_0x0042:
                return r1
            L_0x0043:
                r2 = r3
                goto L_0x002d
            L_0x0045:
                if (r2 == 0) goto L_0x0055
                int r0 = r0 + 1
            L_0x0049:
                int r4 = r4 + 1
                int r5 = r13.length()
                int r5 = r5 - r1
                int r4 = java.lang.Math.min(r4, r5)
                goto L_0x0016
            L_0x0055:
                int r1 = r1 + 1
                goto L_0x0049
            L_0x0058:
                if (r5 < r8) goto L_0x00a3
                if (r5 <= r9) goto L_0x005e
                r4 = r2
                goto L_0x003e
            L_0x005e:
                int r0 = r0 + 1
                goto L_0x0016
            L_0x0061:
                r2 = 9
                if (r0 < r2) goto L_0x0076
                int r2 = r1 + r0
                java.lang.String r0 = r13.substring(r1, r2)
                int r0 = java.lang.Integer.parseInt(r0)
                r1 = r2
            L_0x0070:
                org.joda.time.DateTimeFieldType r2 = r11.iFieldType
                r12.saveField((org.joda.time.DateTimeFieldType) r2, (int) r0)
                goto L_0x0042
            L_0x0076:
                if (r4 == 0) goto L_0x00a1
                int r2 = r1 + 1
                r3 = r2
            L_0x007b:
                int r2 = r3 + 1
                char r3 = r13.charAt(r3)     // Catch:{ StringIndexOutOfBoundsException -> 0x0099 }
                int r3 = r3 + -48
                int r1 = r1 + r0
                r0 = r3
            L_0x0085:
                if (r2 >= r1) goto L_0x009d
                int r3 = r0 << 3
                int r0 = r0 << 1
                int r3 = r3 + r0
                int r0 = r2 + 1
                char r2 = r13.charAt(r2)
                int r2 = r2 + r3
                int r2 = r2 + -48
                r10 = r0
                r0 = r2
                r2 = r10
                goto L_0x0085
            L_0x0099:
                r0 = move-exception
                r1 = r1 ^ -1
                goto L_0x0042
            L_0x009d:
                if (r4 == 0) goto L_0x0070
                int r0 = -r0
                goto L_0x0070
            L_0x00a1:
                r3 = r1
                goto L_0x007b
            L_0x00a3:
                r4 = r2
                goto L_0x003e
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.DateTimeFormatterBuilder.NumberFormatter.parseInto(org.joda.time.format.DateTimeParserBucket, java.lang.String, int):int");
        }
    }

    static class UnpaddedNumber extends NumberFormatter {
        protected UnpaddedNumber(DateTimeFieldType dateTimeFieldType, int i, boolean z) {
            super(dateTimeFieldType, i, z);
        }

        public int estimatePrintedLength() {
            return this.iMaxParsedDigits;
        }

        public void printTo(StringBuffer stringBuffer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) {
            try {
                FormatUtils.appendUnpaddedInteger(stringBuffer, this.iFieldType.getField(chronology).get(j));
            } catch (RuntimeException e) {
                stringBuffer.append(65533);
            }
        }

        public void printTo(Writer writer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            try {
                FormatUtils.writeUnpaddedInteger(writer, this.iFieldType.getField(chronology).get(j));
            } catch (RuntimeException e) {
                writer.write(65533);
            }
        }

        public void printTo(StringBuffer stringBuffer, ReadablePartial readablePartial, Locale locale) {
            if (readablePartial.isSupported(this.iFieldType)) {
                try {
                    FormatUtils.appendUnpaddedInteger(stringBuffer, readablePartial.get(this.iFieldType));
                } catch (RuntimeException e) {
                    stringBuffer.append(65533);
                }
            } else {
                stringBuffer.append(65533);
            }
        }

        public void printTo(Writer writer, ReadablePartial readablePartial, Locale locale) throws IOException {
            if (readablePartial.isSupported(this.iFieldType)) {
                try {
                    FormatUtils.writeUnpaddedInteger(writer, readablePartial.get(this.iFieldType));
                } catch (RuntimeException e) {
                    writer.write(65533);
                }
            } else {
                writer.write(65533);
            }
        }
    }

    static class PaddedNumber extends NumberFormatter {
        protected final int iMinPrintedDigits;

        protected PaddedNumber(DateTimeFieldType dateTimeFieldType, int i, boolean z, int i2) {
            super(dateTimeFieldType, i, z);
            this.iMinPrintedDigits = i2;
        }

        public int estimatePrintedLength() {
            return this.iMaxParsedDigits;
        }

        public void printTo(StringBuffer stringBuffer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) {
            try {
                FormatUtils.appendPaddedInteger(stringBuffer, this.iFieldType.getField(chronology).get(j), this.iMinPrintedDigits);
            } catch (RuntimeException e) {
                DateTimeFormatterBuilder.appendUnknownString(stringBuffer, this.iMinPrintedDigits);
            }
        }

        public void printTo(Writer writer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            try {
                FormatUtils.writePaddedInteger(writer, this.iFieldType.getField(chronology).get(j), this.iMinPrintedDigits);
            } catch (RuntimeException e) {
                DateTimeFormatterBuilder.printUnknownString(writer, this.iMinPrintedDigits);
            }
        }

        public void printTo(StringBuffer stringBuffer, ReadablePartial readablePartial, Locale locale) {
            if (readablePartial.isSupported(this.iFieldType)) {
                try {
                    FormatUtils.appendPaddedInteger(stringBuffer, readablePartial.get(this.iFieldType), this.iMinPrintedDigits);
                } catch (RuntimeException e) {
                    DateTimeFormatterBuilder.appendUnknownString(stringBuffer, this.iMinPrintedDigits);
                }
            } else {
                DateTimeFormatterBuilder.appendUnknownString(stringBuffer, this.iMinPrintedDigits);
            }
        }

        public void printTo(Writer writer, ReadablePartial readablePartial, Locale locale) throws IOException {
            if (readablePartial.isSupported(this.iFieldType)) {
                try {
                    FormatUtils.writePaddedInteger(writer, readablePartial.get(this.iFieldType), this.iMinPrintedDigits);
                } catch (RuntimeException e) {
                    DateTimeFormatterBuilder.printUnknownString(writer, this.iMinPrintedDigits);
                }
            } else {
                DateTimeFormatterBuilder.printUnknownString(writer, this.iMinPrintedDigits);
            }
        }
    }

    static class FixedNumber extends PaddedNumber {
        protected FixedNumber(DateTimeFieldType dateTimeFieldType, int i, boolean z) {
            super(dateTimeFieldType, i, z, i);
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, String str, int i) {
            int i2;
            char charAt;
            int parseInto = super.parseInto(dateTimeParserBucket, str, i);
            if (parseInto < 0 || parseInto == (i2 = this.iMaxParsedDigits + i)) {
                return parseInto;
            }
            if (this.iSigned && ((charAt = str.charAt(i)) == '-' || charAt == '+')) {
                i2++;
            }
            if (parseInto > i2) {
                return (i2 + 1) ^ -1;
            }
            if (parseInto < i2) {
                return parseInto ^ -1;
            }
            return parseInto;
        }
    }

    static class TwoDigitYear implements DateTimePrinter, DateTimeParser {
        private final boolean iLenientParse;
        private final int iPivot;
        private final DateTimeFieldType iType;

        TwoDigitYear(DateTimeFieldType dateTimeFieldType, int i, boolean z) {
            this.iType = dateTimeFieldType;
            this.iPivot = i;
            this.iLenientParse = z;
        }

        public int estimateParsedLength() {
            return this.iLenientParse ? 4 : 2;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, String str, int i) {
            int i2;
            int i3;
            int i4;
            int i5;
            boolean z;
            int i6 = 0;
            int length = str.length() - i;
            if (this.iLenientParse) {
                int i7 = 0;
                boolean z2 = false;
                boolean z3 = false;
                int i8 = length;
                while (i7 < i8) {
                    char charAt = str.charAt(i + i7);
                    if (i7 != 0 || (charAt != '-' && charAt != '+')) {
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i7++;
                    } else {
                        if (charAt == '-') {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            i7++;
                            z2 = z;
                            z3 = true;
                        } else {
                            i++;
                            z3 = true;
                            i8--;
                            z2 = z;
                        }
                    }
                }
                if (i7 == 0) {
                    return i ^ -1;
                }
                if (z3 || i7 != 2) {
                    if (i7 >= 9) {
                        i4 = i + i7;
                        i5 = Integer.parseInt(str.substring(i, i4));
                    } else {
                        if (z2) {
                            i3 = i + 1;
                        } else {
                            i3 = i;
                        }
                        int i9 = i3 + 1;
                        try {
                            int charAt2 = str.charAt(i3) - '0';
                            i4 = i + i7;
                            int i10 = i9;
                            i5 = charAt2;
                            for (int i11 = i10; i11 < i4; i11++) {
                                i5 = (str.charAt(i11) + ((i5 << 3) + (i5 << 1))) - 48;
                            }
                            if (z2) {
                                i5 = -i5;
                            }
                        } catch (StringIndexOutOfBoundsException e) {
                            return i ^ -1;
                        }
                    }
                    dateTimeParserBucket.saveField(this.iType, i5);
                    return i4;
                }
            } else if (Math.min(2, length) < 2) {
                return i ^ -1;
            }
            char charAt3 = str.charAt(i);
            if (charAt3 < '0' || charAt3 > '9') {
                return i ^ -1;
            }
            int i12 = charAt3 - '0';
            char charAt4 = str.charAt(i + 1);
            if (charAt4 < '0' || charAt4 > '9') {
                return i ^ -1;
            }
            int i13 = (((i12 << 1) + (i12 << 3)) + charAt4) - 48;
            int i14 = this.iPivot;
            if (dateTimeParserBucket.getPivotYear() != null) {
                i14 = dateTimeParserBucket.getPivotYear().intValue();
            }
            int i15 = i14 - 50;
            if (i15 >= 0) {
                i2 = i15 % 100;
            } else {
                i2 = ((i15 + 1) % 100) + 99;
            }
            if (i13 < i2) {
                i6 = 100;
            }
            dateTimeParserBucket.saveField(this.iType, ((i6 + i15) - i2) + i13);
            return i + 2;
        }

        public int estimatePrintedLength() {
            return 2;
        }

        public void printTo(StringBuffer stringBuffer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) {
            int twoDigitYear = getTwoDigitYear(j, chronology);
            if (twoDigitYear < 0) {
                stringBuffer.append(65533);
                stringBuffer.append(65533);
                return;
            }
            FormatUtils.appendPaddedInteger(stringBuffer, twoDigitYear, 2);
        }

        public void printTo(Writer writer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            int twoDigitYear = getTwoDigitYear(j, chronology);
            if (twoDigitYear < 0) {
                writer.write(65533);
                writer.write(65533);
                return;
            }
            FormatUtils.writePaddedInteger(writer, twoDigitYear, 2);
        }

        private int getTwoDigitYear(long j, Chronology chronology) {
            try {
                int i = this.iType.getField(chronology).get(j);
                if (i < 0) {
                    i = -i;
                }
                return i % 100;
            } catch (RuntimeException e) {
                return -1;
            }
        }

        public void printTo(StringBuffer stringBuffer, ReadablePartial readablePartial, Locale locale) {
            int twoDigitYear = getTwoDigitYear(readablePartial);
            if (twoDigitYear < 0) {
                stringBuffer.append(65533);
                stringBuffer.append(65533);
                return;
            }
            FormatUtils.appendPaddedInteger(stringBuffer, twoDigitYear, 2);
        }

        public void printTo(Writer writer, ReadablePartial readablePartial, Locale locale) throws IOException {
            int twoDigitYear = getTwoDigitYear(readablePartial);
            if (twoDigitYear < 0) {
                writer.write(65533);
                writer.write(65533);
                return;
            }
            FormatUtils.writePaddedInteger(writer, twoDigitYear, 2);
        }

        private int getTwoDigitYear(ReadablePartial readablePartial) {
            if (readablePartial.isSupported(this.iType)) {
                try {
                    int i = readablePartial.get(this.iType);
                    if (i < 0) {
                        i = -i;
                    }
                    return i % 100;
                } catch (RuntimeException e) {
                }
            }
            return -1;
        }
    }

    static class TextField implements DateTimePrinter, DateTimeParser {
        private static Map<Locale, Map<DateTimeFieldType, Object[]>> cParseCache = new HashMap();
        private final DateTimeFieldType iFieldType;
        private final boolean iShort;

        TextField(DateTimeFieldType dateTimeFieldType, boolean z) {
            this.iFieldType = dateTimeFieldType;
            this.iShort = z;
        }

        public int estimatePrintedLength() {
            return this.iShort ? 6 : 20;
        }

        public void printTo(StringBuffer stringBuffer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) {
            try {
                stringBuffer.append(print(j, chronology, locale));
            } catch (RuntimeException e) {
                stringBuffer.append(65533);
            }
        }

        public void printTo(Writer writer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            try {
                writer.write(print(j, chronology, locale));
            } catch (RuntimeException e) {
                writer.write(65533);
            }
        }

        public void printTo(StringBuffer stringBuffer, ReadablePartial readablePartial, Locale locale) {
            try {
                stringBuffer.append(print(readablePartial, locale));
            } catch (RuntimeException e) {
                stringBuffer.append(65533);
            }
        }

        public void printTo(Writer writer, ReadablePartial readablePartial, Locale locale) throws IOException {
            try {
                writer.write(print(readablePartial, locale));
            } catch (RuntimeException e) {
                writer.write(65533);
            }
        }

        private String print(long j, Chronology chronology, Locale locale) {
            DateTimeField field = this.iFieldType.getField(chronology);
            if (this.iShort) {
                return field.getAsShortText(j, locale);
            }
            return field.getAsText(j, locale);
        }

        private String print(ReadablePartial readablePartial, Locale locale) {
            if (!readablePartial.isSupported(this.iFieldType)) {
                return "�";
            }
            DateTimeField field = this.iFieldType.getField(readablePartial.getChronology());
            if (this.iShort) {
                return field.getAsShortText(readablePartial, locale);
            }
            return field.getAsText(readablePartial, locale);
        }

        public int estimateParsedLength() {
            return estimatePrintedLength();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00d0, code lost:
            r0 = java.lang.Math.min(r11.length(), r0 + r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d9, code lost:
            if (r0 <= r12) goto L_0x0101;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00db, code lost:
            r2 = r11.substring(r12, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e3, code lost:
            if (r1.contains(r2) == false) goto L_0x00fe;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00e5, code lost:
            r10.saveField(r9.iFieldType, r2, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00fe, code lost:
            r0 = r0 - 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            return r12 ^ -1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int parseInto(org.joda.time.format.DateTimeParserBucket r10, java.lang.String r11, int r12) {
            /*
                r9 = this;
                r8 = 32
                java.util.Locale r4 = r10.getLocale()
                java.util.Map<java.util.Locale, java.util.Map<org.joda.time.DateTimeFieldType, java.lang.Object[]>> r5 = cParseCache
                monitor-enter(r5)
                java.util.Map<java.util.Locale, java.util.Map<org.joda.time.DateTimeFieldType, java.lang.Object[]>> r0 = cParseCache     // Catch:{ all -> 0x00fb }
                java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x00fb }
                java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x00fb }
                if (r0 != 0) goto L_0x0105
                java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x00fb }
                r0.<init>()     // Catch:{ all -> 0x00fb }
                java.util.Map<java.util.Locale, java.util.Map<org.joda.time.DateTimeFieldType, java.lang.Object[]>> r1 = cParseCache     // Catch:{ all -> 0x00fb }
                r1.put(r4, r0)     // Catch:{ all -> 0x00fb }
                r3 = r0
            L_0x001e:
                org.joda.time.DateTimeFieldType r0 = r9.iFieldType     // Catch:{ all -> 0x00fb }
                java.lang.Object r0 = r3.get(r0)     // Catch:{ all -> 0x00fb }
                java.lang.Object[] r0 = (java.lang.Object[]) r0     // Catch:{ all -> 0x00fb }
                if (r0 != 0) goto L_0x00ec
                java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x00fb }
                r0 = 32
                r1.<init>(r0)     // Catch:{ all -> 0x00fb }
                org.joda.time.MutableDateTime r0 = new org.joda.time.MutableDateTime     // Catch:{ all -> 0x00fb }
                r6 = 0
                org.joda.time.DateTimeZone r2 = org.joda.time.DateTimeZone.UTC     // Catch:{ all -> 0x00fb }
                r0.<init>((long) r6, (org.joda.time.DateTimeZone) r2)     // Catch:{ all -> 0x00fb }
                org.joda.time.DateTimeFieldType r2 = r9.iFieldType     // Catch:{ all -> 0x00fb }
                org.joda.time.MutableDateTime$Property r6 = r0.property(r2)     // Catch:{ all -> 0x00fb }
                int r2 = r6.getMinimumValueOverall()     // Catch:{ all -> 0x00fb }
                int r7 = r6.getMaximumValueOverall()     // Catch:{ all -> 0x00fb }
                int r0 = r7 - r2
                if (r0 <= r8) goto L_0x004e
                r0 = r12 ^ -1
                monitor-exit(r5)     // Catch:{ all -> 0x00fb }
            L_0x004d:
                return r0
            L_0x004e:
                int r0 = r6.getMaximumTextLength(r4)     // Catch:{ all -> 0x00fb }
            L_0x0052:
                if (r2 > r7) goto L_0x0094
                r6.set((int) r2)     // Catch:{ all -> 0x00fb }
                java.lang.String r8 = r6.getAsShortText(r4)     // Catch:{ all -> 0x00fb }
                r1.add(r8)     // Catch:{ all -> 0x00fb }
                java.lang.String r8 = r6.getAsShortText(r4)     // Catch:{ all -> 0x00fb }
                java.lang.String r8 = r8.toLowerCase(r4)     // Catch:{ all -> 0x00fb }
                r1.add(r8)     // Catch:{ all -> 0x00fb }
                java.lang.String r8 = r6.getAsShortText(r4)     // Catch:{ all -> 0x00fb }
                java.lang.String r8 = r8.toUpperCase(r4)     // Catch:{ all -> 0x00fb }
                r1.add(r8)     // Catch:{ all -> 0x00fb }
                java.lang.String r8 = r6.getAsText(r4)     // Catch:{ all -> 0x00fb }
                r1.add(r8)     // Catch:{ all -> 0x00fb }
                java.lang.String r8 = r6.getAsText(r4)     // Catch:{ all -> 0x00fb }
                java.lang.String r8 = r8.toLowerCase(r4)     // Catch:{ all -> 0x00fb }
                r1.add(r8)     // Catch:{ all -> 0x00fb }
                java.lang.String r8 = r6.getAsText(r4)     // Catch:{ all -> 0x00fb }
                java.lang.String r8 = r8.toUpperCase(r4)     // Catch:{ all -> 0x00fb }
                r1.add(r8)     // Catch:{ all -> 0x00fb }
                int r2 = r2 + 1
                goto L_0x0052
            L_0x0094:
                java.lang.String r2 = "en"
                java.lang.String r6 = r4.getLanguage()     // Catch:{ all -> 0x00fb }
                boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x00fb }
                if (r2 == 0) goto L_0x00bd
                org.joda.time.DateTimeFieldType r2 = r9.iFieldType     // Catch:{ all -> 0x00fb }
                org.joda.time.DateTimeFieldType r6 = org.joda.time.DateTimeFieldType.era()     // Catch:{ all -> 0x00fb }
                if (r2 != r6) goto L_0x00bd
                java.lang.String r0 = "BCE"
                r1.add(r0)     // Catch:{ all -> 0x00fb }
                java.lang.String r0 = "bce"
                r1.add(r0)     // Catch:{ all -> 0x00fb }
                java.lang.String r0 = "CE"
                r1.add(r0)     // Catch:{ all -> 0x00fb }
                java.lang.String r0 = "ce"
                r1.add(r0)     // Catch:{ all -> 0x00fb }
                r0 = 3
            L_0x00bd:
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00fb }
                r6 = 0
                r2[r6] = r1     // Catch:{ all -> 0x00fb }
                r6 = 1
                java.lang.Integer r7 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00fb }
                r2[r6] = r7     // Catch:{ all -> 0x00fb }
                org.joda.time.DateTimeFieldType r6 = r9.iFieldType     // Catch:{ all -> 0x00fb }
                r3.put(r6, r2)     // Catch:{ all -> 0x00fb }
            L_0x00cf:
                monitor-exit(r5)     // Catch:{ all -> 0x00fb }
                int r2 = r11.length()
                int r0 = r0 + r12
                int r0 = java.lang.Math.min(r2, r0)
            L_0x00d9:
                if (r0 <= r12) goto L_0x0101
                java.lang.String r2 = r11.substring(r12, r0)
                boolean r3 = r1.contains(r2)
                if (r3 == 0) goto L_0x00fe
                org.joda.time.DateTimeFieldType r1 = r9.iFieldType
                r10.saveField(r1, r2, r4)
                goto L_0x004d
            L_0x00ec:
                r1 = 0
                r1 = r0[r1]     // Catch:{ all -> 0x00fb }
                java.util.Set r1 = (java.util.Set) r1     // Catch:{ all -> 0x00fb }
                r2 = 1
                r0 = r0[r2]     // Catch:{ all -> 0x00fb }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x00fb }
                int r0 = r0.intValue()     // Catch:{ all -> 0x00fb }
                goto L_0x00cf
            L_0x00fb:
                r0 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x00fb }
                throw r0
            L_0x00fe:
                int r0 = r0 + -1
                goto L_0x00d9
            L_0x0101:
                r0 = r12 ^ -1
                goto L_0x004d
            L_0x0105:
                r3 = r0
                goto L_0x001e
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.DateTimeFormatterBuilder.TextField.parseInto(org.joda.time.format.DateTimeParserBucket, java.lang.String, int):int");
        }
    }

    static class Fraction implements DateTimePrinter, DateTimeParser {
        private final DateTimeFieldType iFieldType;
        protected int iMaxDigits;
        protected int iMinDigits;

        protected Fraction(DateTimeFieldType dateTimeFieldType, int i, int i2) {
            this.iFieldType = dateTimeFieldType;
            i2 = i2 > 18 ? 18 : i2;
            this.iMinDigits = i;
            this.iMaxDigits = i2;
        }

        public int estimatePrintedLength() {
            return this.iMaxDigits;
        }

        public void printTo(StringBuffer stringBuffer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) {
            try {
                printTo(stringBuffer, (Writer) null, j, chronology);
            } catch (IOException e) {
            }
        }

        public void printTo(Writer writer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            printTo((StringBuffer) null, writer, j, chronology);
        }

        public void printTo(StringBuffer stringBuffer, ReadablePartial readablePartial, Locale locale) {
            try {
                printTo(stringBuffer, (Writer) null, readablePartial.getChronology().set(readablePartial, 0), readablePartial.getChronology());
            } catch (IOException e) {
            }
        }

        public void printTo(Writer writer, ReadablePartial readablePartial, Locale locale) throws IOException {
            printTo((StringBuffer) null, writer, readablePartial.getChronology().set(readablePartial, 0), readablePartial.getChronology());
        }

        /* access modifiers changed from: protected */
        public void printTo(StringBuffer stringBuffer, Writer writer, long j, Chronology chronology) throws IOException {
            String l;
            DateTimeField field = this.iFieldType.getField(chronology);
            int i = this.iMinDigits;
            try {
                long remainder = field.remainder(j);
                if (remainder != 0) {
                    long[] fractionData = getFractionData(remainder, field);
                    long j2 = fractionData[0];
                    int i2 = (int) fractionData[1];
                    if ((2147483647L & j2) == j2) {
                        l = Integer.toString((int) j2);
                    } else {
                        l = Long.toString(j2);
                    }
                    int length = l.length();
                    while (length < i2) {
                        if (stringBuffer != null) {
                            stringBuffer.append('0');
                        } else {
                            writer.write(48);
                        }
                        i--;
                        i2--;
                    }
                    if (i < i2) {
                        while (i < i2 && length > 1 && l.charAt(length - 1) == '0') {
                            i2--;
                            length--;
                        }
                        if (length < l.length()) {
                            if (stringBuffer != null) {
                                for (int i3 = 0; i3 < length; i3++) {
                                    stringBuffer.append(l.charAt(i3));
                                }
                                return;
                            }
                            for (int i4 = 0; i4 < length; i4++) {
                                writer.write(l.charAt(i4));
                            }
                            return;
                        }
                    }
                    if (stringBuffer != null) {
                        stringBuffer.append(l);
                    } else {
                        writer.write(l);
                    }
                } else if (stringBuffer != null) {
                    while (true) {
                        i--;
                        if (i >= 0) {
                            stringBuffer.append('0');
                        } else {
                            return;
                        }
                    }
                } else {
                    while (true) {
                        i--;
                        if (i >= 0) {
                            writer.write(48);
                        } else {
                            return;
                        }
                    }
                }
            } catch (RuntimeException e) {
                if (stringBuffer != null) {
                    DateTimeFormatterBuilder.appendUnknownString(stringBuffer, i);
                } else {
                    DateTimeFormatterBuilder.printUnknownString(writer, i);
                }
            }
        }

        private long[] getFractionData(long j, DateTimeField dateTimeField) {
            int i;
            long j2;
            long unitMillis = dateTimeField.getDurationField().getUnitMillis();
            int i2 = this.iMaxDigits;
            while (true) {
                switch (i) {
                    case 1:
                        j2 = 10;
                        break;
                    case 2:
                        j2 = 100;
                        break;
                    case 3:
                        j2 = 1000;
                        break;
                    case 4:
                        j2 = 10000;
                        break;
                    case 5:
                        j2 = 100000;
                        break;
                    case 6:
                        j2 = 1000000;
                        break;
                    case 7:
                        j2 = 10000000;
                        break;
                    case 8:
                        j2 = 100000000;
                        break;
                    case 9:
                        j2 = 1000000000;
                        break;
                    case 10:
                        j2 = 10000000000L;
                        break;
                    case 11:
                        j2 = 100000000000L;
                        break;
                    case 12:
                        j2 = 1000000000000L;
                        break;
                    case 13:
                        j2 = 10000000000000L;
                        break;
                    case 14:
                        j2 = 100000000000000L;
                        break;
                    case 15:
                        j2 = 1000000000000000L;
                        break;
                    case 16:
                        j2 = 10000000000000000L;
                        break;
                    case 17:
                        j2 = 100000000000000000L;
                        break;
                    case 18:
                        j2 = 1000000000000000000L;
                        break;
                    default:
                        j2 = 1;
                        break;
                }
                if ((unitMillis * j2) / j2 == unitMillis) {
                    return new long[]{(j2 * j) / unitMillis, (long) i};
                }
                i2 = i - 1;
            }
        }

        public int estimateParsedLength() {
            return this.iMaxDigits;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, String str, int i) {
            DateTimeField field = this.iFieldType.getField(dateTimeParserBucket.getChronology());
            int min = Math.min(this.iMaxDigits, str.length() - i);
            long j = 0;
            long unitMillis = field.getDurationField().getUnitMillis() * 10;
            int i2 = 0;
            while (i2 < min) {
                char charAt = str.charAt(i + i2);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i2++;
                unitMillis /= 10;
                j += ((long) (charAt - '0')) * unitMillis;
            }
            long j2 = j / 10;
            if (i2 == 0) {
                return i ^ -1;
            }
            if (j2 > 2147483647L) {
                return i ^ -1;
            }
            dateTimeParserBucket.saveField((DateTimeField) new PreciseDateTimeField(DateTimeFieldType.millisOfSecond(), MillisDurationField.INSTANCE, field.getDurationField()), (int) j2);
            return i2 + i;
        }
    }

    static class TimeZoneOffset implements DateTimePrinter, DateTimeParser {
        private final int iMaxFields;
        private final int iMinFields;
        private final boolean iShowSeparators;
        private final String iZeroOffsetParseText;
        private final String iZeroOffsetPrintText;

        TimeZoneOffset(String str, String str2, boolean z, int i, int i2) {
            int i3 = 4;
            this.iZeroOffsetPrintText = str;
            this.iZeroOffsetParseText = str2;
            this.iShowSeparators = z;
            if (i <= 0 || i2 < i) {
                throw new IllegalArgumentException();
            }
            if (i > 4) {
                i2 = 4;
            } else {
                i3 = i;
            }
            this.iMinFields = i3;
            this.iMaxFields = i2;
        }

        public int estimatePrintedLength() {
            int i = (this.iMinFields + 1) << 1;
            if (this.iShowSeparators) {
                i += this.iMinFields - 1;
            }
            if (this.iZeroOffsetPrintText == null || this.iZeroOffsetPrintText.length() <= i) {
                return i;
            }
            return this.iZeroOffsetPrintText.length();
        }

        public void printTo(StringBuffer stringBuffer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) {
            if (dateTimeZone != null) {
                if (i != 0 || this.iZeroOffsetPrintText == null) {
                    if (i >= 0) {
                        stringBuffer.append('+');
                    } else {
                        stringBuffer.append('-');
                        i = -i;
                    }
                    int i2 = i / DateTimeConstants.MILLIS_PER_HOUR;
                    FormatUtils.appendPaddedInteger(stringBuffer, i2, 2);
                    if (this.iMaxFields != 1) {
                        int i3 = i - (i2 * DateTimeConstants.MILLIS_PER_HOUR);
                        if (i3 != 0 || this.iMinFields > 1) {
                            int i4 = i3 / DateTimeConstants.MILLIS_PER_MINUTE;
                            if (this.iShowSeparators) {
                                stringBuffer.append(':');
                            }
                            FormatUtils.appendPaddedInteger(stringBuffer, i4, 2);
                            if (this.iMaxFields != 2) {
                                int i5 = i3 - (i4 * DateTimeConstants.MILLIS_PER_MINUTE);
                                if (i5 != 0 || this.iMinFields > 2) {
                                    int i6 = i5 / 1000;
                                    if (this.iShowSeparators) {
                                        stringBuffer.append(':');
                                    }
                                    FormatUtils.appendPaddedInteger(stringBuffer, i6, 2);
                                    if (this.iMaxFields != 3) {
                                        int i7 = i5 - (i6 * 1000);
                                        if (i7 != 0 || this.iMinFields > 3) {
                                            if (this.iShowSeparators) {
                                                stringBuffer.append('.');
                                            }
                                            FormatUtils.appendPaddedInteger(stringBuffer, i7, 3);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                stringBuffer.append(this.iZeroOffsetPrintText);
            }
        }

        public void printTo(Writer writer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            if (dateTimeZone != null) {
                if (i != 0 || this.iZeroOffsetPrintText == null) {
                    if (i >= 0) {
                        writer.write(43);
                    } else {
                        writer.write(45);
                        i = -i;
                    }
                    int i2 = i / DateTimeConstants.MILLIS_PER_HOUR;
                    FormatUtils.writePaddedInteger(writer, i2, 2);
                    if (this.iMaxFields != 1) {
                        int i3 = i - (i2 * DateTimeConstants.MILLIS_PER_HOUR);
                        if (i3 != 0 || this.iMinFields != 1) {
                            int i4 = i3 / DateTimeConstants.MILLIS_PER_MINUTE;
                            if (this.iShowSeparators) {
                                writer.write(58);
                            }
                            FormatUtils.writePaddedInteger(writer, i4, 2);
                            if (this.iMaxFields != 2) {
                                int i5 = i3 - (i4 * DateTimeConstants.MILLIS_PER_MINUTE);
                                if (i5 != 0 || this.iMinFields != 2) {
                                    int i6 = i5 / 1000;
                                    if (this.iShowSeparators) {
                                        writer.write(58);
                                    }
                                    FormatUtils.writePaddedInteger(writer, i6, 2);
                                    if (this.iMaxFields != 3) {
                                        int i7 = i5 - (i6 * 1000);
                                        if (i7 != 0 || this.iMinFields != 3) {
                                            if (this.iShowSeparators) {
                                                writer.write(46);
                                            }
                                            FormatUtils.writePaddedInteger(writer, i7, 3);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                writer.write(this.iZeroOffsetPrintText);
            }
        }

        public void printTo(StringBuffer stringBuffer, ReadablePartial readablePartial, Locale locale) {
        }

        public void printTo(Writer writer, ReadablePartial readablePartial, Locale locale) throws IOException {
        }

        public int estimateParsedLength() {
            return estimatePrintedLength();
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, String str, int i) {
            boolean z;
            int i2;
            int i3;
            int i4;
            char charAt;
            boolean z2 = false;
            int length = str.length() - i;
            if (this.iZeroOffsetParseText != null) {
                if (this.iZeroOffsetParseText.length() != 0) {
                    if (str.regionMatches(true, i, this.iZeroOffsetParseText, 0, this.iZeroOffsetParseText.length())) {
                        dateTimeParserBucket.setOffset((Integer) 0);
                        return i + this.iZeroOffsetParseText.length();
                    }
                } else if (length <= 0 || !((charAt = str.charAt(i)) == '-' || charAt == '+')) {
                    dateTimeParserBucket.setOffset((Integer) 0);
                    return i;
                }
            }
            if (length <= 1) {
                return i ^ -1;
            }
            char charAt2 = str.charAt(i);
            if (charAt2 == '-') {
                z = true;
            } else if (charAt2 != '+') {
                return i ^ -1;
            } else {
                z = false;
            }
            int i5 = length - 1;
            int i6 = i + 1;
            if (digitCount(str, i6, 2) < 2) {
                return i6 ^ -1;
            }
            int parseTwoDigits = FormatUtils.parseTwoDigits(str, i6);
            if (parseTwoDigits > 23) {
                return i6 ^ -1;
            }
            int i7 = parseTwoDigits * DateTimeConstants.MILLIS_PER_HOUR;
            int i8 = i5 - 2;
            int i9 = i6 + 2;
            if (i8 <= 0) {
                i2 = i7;
                i3 = i9;
            } else {
                char charAt3 = str.charAt(i9);
                if (charAt3 == ':') {
                    i8--;
                    i9++;
                    z2 = true;
                } else if (charAt3 < '0' || charAt3 > '9') {
                    i2 = i7;
                    i3 = i9;
                }
                int digitCount = digitCount(str, i9, 2);
                if (digitCount == 0 && !z2) {
                    i2 = i7;
                    i3 = i9;
                } else if (digitCount < 2) {
                    return i9 ^ -1;
                } else {
                    int parseTwoDigits2 = FormatUtils.parseTwoDigits(str, i9);
                    if (parseTwoDigits2 > 59) {
                        return i9 ^ -1;
                    }
                    int i10 = i7 + (parseTwoDigits2 * DateTimeConstants.MILLIS_PER_MINUTE);
                    int i11 = i8 - 2;
                    int i12 = i9 + 2;
                    if (i11 <= 0) {
                        i2 = i10;
                        i3 = i12;
                    } else {
                        if (z2) {
                            if (str.charAt(i12) != ':') {
                                i2 = i10;
                                i3 = i12;
                            } else {
                                i11--;
                                i12++;
                            }
                        }
                        int digitCount2 = digitCount(str, i12, 2);
                        if (digitCount2 == 0 && !z2) {
                            i2 = i10;
                            i3 = i12;
                        } else if (digitCount2 < 2) {
                            return i12 ^ -1;
                        } else {
                            int parseTwoDigits3 = FormatUtils.parseTwoDigits(str, i12);
                            if (parseTwoDigits3 > 59) {
                                return i12 ^ -1;
                            }
                            int i13 = i10 + (parseTwoDigits3 * 1000);
                            int i14 = i11 - 2;
                            int i15 = i12 + 2;
                            if (i14 <= 0) {
                                i2 = i13;
                                i3 = i15;
                            } else {
                                if (z2) {
                                    if (str.charAt(i15) == '.' || str.charAt(i15) == ',') {
                                        int i16 = i14 - 1;
                                        i15++;
                                    } else {
                                        i2 = i13;
                                        i3 = i15;
                                    }
                                }
                                int digitCount3 = digitCount(str, i15, 3);
                                if (digitCount3 == 0 && !z2) {
                                    i2 = i13;
                                    i3 = i15;
                                } else if (digitCount3 < 1) {
                                    return i15 ^ -1;
                                } else {
                                    int i17 = i15 + 1;
                                    int charAt4 = ((str.charAt(i15) - '0') * 100) + i13;
                                    if (digitCount3 > 1) {
                                        i3 = i17 + 1;
                                        i2 = ((str.charAt(i17) - '0') * 10) + charAt4;
                                        if (digitCount3 > 2) {
                                            i2 += str.charAt(i3) - '0';
                                            i3++;
                                        }
                                    } else {
                                        i2 = charAt4;
                                        i3 = i17;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (z) {
                i4 = -i2;
            } else {
                i4 = i2;
            }
            dateTimeParserBucket.setOffset(Integer.valueOf(i4));
            return i3;
        }

        private int digitCount(String str, int i, int i2) {
            int i3 = 0;
            for (int min = Math.min(str.length() - i, i2); min > 0; min--) {
                char charAt = str.charAt(i + i3);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i3++;
            }
            return i3;
        }
    }

    static class TimeZoneName implements DateTimePrinter, DateTimeParser {
        static final int LONG_NAME = 0;
        static final int SHORT_NAME = 1;
        private final Map<String, DateTimeZone> iParseLookup;
        private final int iType;

        TimeZoneName(int i, Map<String, DateTimeZone> map) {
            this.iType = i;
            this.iParseLookup = map;
        }

        public int estimatePrintedLength() {
            return this.iType == 1 ? 4 : 20;
        }

        public void printTo(StringBuffer stringBuffer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) {
            stringBuffer.append(print(j - ((long) i), dateTimeZone, locale));
        }

        public void printTo(Writer writer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            writer.write(print(j - ((long) i), dateTimeZone, locale));
        }

        private String print(long j, DateTimeZone dateTimeZone, Locale locale) {
            if (dateTimeZone == null) {
                return "";
            }
            switch (this.iType) {
                case 0:
                    return dateTimeZone.getName(j, locale);
                case 1:
                    return dateTimeZone.getShortName(j, locale);
                default:
                    return "";
            }
        }

        public void printTo(StringBuffer stringBuffer, ReadablePartial readablePartial, Locale locale) {
        }

        public void printTo(Writer writer, ReadablePartial readablePartial, Locale locale) throws IOException {
        }

        public int estimateParsedLength() {
            return this.iType == 1 ? 4 : 20;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, String str, int i) {
            Map<String, DateTimeZone> map = this.iParseLookup;
            Map<String, DateTimeZone> defaultTimeZoneNames = map != null ? map : DateTimeUtils.getDefaultTimeZoneNames();
            String substring = str.substring(i);
            for (String next : defaultTimeZoneNames.keySet()) {
                if (substring.startsWith(next)) {
                    dateTimeParserBucket.setZone(defaultTimeZoneNames.get(next));
                    return next.length() + i;
                }
            }
            return i ^ -1;
        }
    }

    enum TimeZoneId implements DateTimePrinter, DateTimeParser {
        INSTANCE;
        
        static final Set<String> ALL_IDS = null;
        static final int MAX_LENGTH = 0;

        static {
            int i;
            ALL_IDS = DateTimeZone.getAvailableIDs();
            Iterator<String> it = ALL_IDS.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    i = Math.max(i2, it.next().length());
                } else {
                    MAX_LENGTH = i2;
                    return;
                }
            }
        }

        public int estimatePrintedLength() {
            return MAX_LENGTH;
        }

        public void printTo(StringBuffer stringBuffer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) {
            stringBuffer.append(dateTimeZone != null ? dateTimeZone.getID() : "");
        }

        public void printTo(Writer writer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            writer.write(dateTimeZone != null ? dateTimeZone.getID() : "");
        }

        public void printTo(StringBuffer stringBuffer, ReadablePartial readablePartial, Locale locale) {
        }

        public void printTo(Writer writer, ReadablePartial readablePartial, Locale locale) throws IOException {
        }

        public int estimateParsedLength() {
            return MAX_LENGTH;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, String str, int i) {
            String substring = str.substring(i);
            String str2 = null;
            for (String next : ALL_IDS) {
                if (!substring.startsWith(next) || (str2 != null && next.length() <= str2.length())) {
                    next = str2;
                }
                str2 = next;
            }
            if (str2 == null) {
                return i ^ -1;
            }
            dateTimeParserBucket.setZone(DateTimeZone.forID(str2));
            return str2.length() + i;
        }
    }

    static class Composite implements DateTimePrinter, DateTimeParser {
        private final int iParsedLengthEstimate;
        private final DateTimeParser[] iParsers;
        private final int iPrintedLengthEstimate;
        private final DateTimePrinter[] iPrinters;

        Composite(List<Object> list) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            decompose(list, arrayList, arrayList2);
            if (arrayList.contains((Object) null) || arrayList.isEmpty()) {
                this.iPrinters = null;
                this.iPrintedLengthEstimate = 0;
            } else {
                int size = arrayList.size();
                this.iPrinters = new DateTimePrinter[size];
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    DateTimePrinter dateTimePrinter = (DateTimePrinter) arrayList.get(i2);
                    i += dateTimePrinter.estimatePrintedLength();
                    this.iPrinters[i2] = dateTimePrinter;
                }
                this.iPrintedLengthEstimate = i;
            }
            if (arrayList2.contains((Object) null) || arrayList2.isEmpty()) {
                this.iParsers = null;
                this.iParsedLengthEstimate = 0;
                return;
            }
            int size2 = arrayList2.size();
            this.iParsers = new DateTimeParser[size2];
            int i3 = 0;
            for (int i4 = 0; i4 < size2; i4++) {
                DateTimeParser dateTimeParser = (DateTimeParser) arrayList2.get(i4);
                i3 += dateTimeParser.estimateParsedLength();
                this.iParsers[i4] = dateTimeParser;
            }
            this.iParsedLengthEstimate = i3;
        }

        public int estimatePrintedLength() {
            return this.iPrintedLengthEstimate;
        }

        public void printTo(StringBuffer stringBuffer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) {
            Locale locale2;
            DateTimePrinter[] dateTimePrinterArr = this.iPrinters;
            if (dateTimePrinterArr == null) {
                throw new UnsupportedOperationException();
            }
            if (locale == null) {
                locale2 = Locale.getDefault();
            } else {
                locale2 = locale;
            }
            for (DateTimePrinter printTo : dateTimePrinterArr) {
                printTo.printTo(stringBuffer, j, chronology, i, dateTimeZone, locale2);
            }
        }

        public void printTo(Writer writer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            Locale locale2;
            DateTimePrinter[] dateTimePrinterArr = this.iPrinters;
            if (dateTimePrinterArr == null) {
                throw new UnsupportedOperationException();
            }
            if (locale == null) {
                locale2 = Locale.getDefault();
            } else {
                locale2 = locale;
            }
            for (DateTimePrinter printTo : dateTimePrinterArr) {
                printTo.printTo(writer, j, chronology, i, dateTimeZone, locale2);
            }
        }

        public void printTo(StringBuffer stringBuffer, ReadablePartial readablePartial, Locale locale) {
            DateTimePrinter[] dateTimePrinterArr = this.iPrinters;
            if (dateTimePrinterArr == null) {
                throw new UnsupportedOperationException();
            }
            if (locale == null) {
                locale = Locale.getDefault();
            }
            for (DateTimePrinter printTo : dateTimePrinterArr) {
                printTo.printTo(stringBuffer, readablePartial, locale);
            }
        }

        public void printTo(Writer writer, ReadablePartial readablePartial, Locale locale) throws IOException {
            DateTimePrinter[] dateTimePrinterArr = this.iPrinters;
            if (dateTimePrinterArr == null) {
                throw new UnsupportedOperationException();
            }
            if (locale == null) {
                locale = Locale.getDefault();
            }
            for (DateTimePrinter printTo : dateTimePrinterArr) {
                printTo.printTo(writer, readablePartial, locale);
            }
        }

        public int estimateParsedLength() {
            return this.iParsedLengthEstimate;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, String str, int i) {
            DateTimeParser[] dateTimeParserArr = this.iParsers;
            if (dateTimeParserArr == null) {
                throw new UnsupportedOperationException();
            }
            int length = dateTimeParserArr.length;
            for (int i2 = 0; i2 < length && i >= 0; i2++) {
                i = dateTimeParserArr[i2].parseInto(dateTimeParserBucket, str, i);
            }
            return i;
        }

        /* access modifiers changed from: package-private */
        public boolean isPrinter() {
            return this.iPrinters != null;
        }

        /* access modifiers changed from: package-private */
        public boolean isParser() {
            return this.iParsers != null;
        }

        private void decompose(List<Object> list, List<Object> list2, List<Object> list3) {
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                Object obj = list.get(i);
                if (obj instanceof Composite) {
                    addArrayToList(list2, ((Composite) obj).iPrinters);
                } else {
                    list2.add(obj);
                }
                Object obj2 = list.get(i + 1);
                if (obj2 instanceof Composite) {
                    addArrayToList(list3, ((Composite) obj2).iParsers);
                } else {
                    list3.add(obj2);
                }
            }
        }

        private void addArrayToList(List<Object> list, Object[] objArr) {
            if (objArr != null) {
                for (Object add : objArr) {
                    list.add(add);
                }
            }
        }
    }

    static class MatchingParser implements DateTimeParser {
        private final int iParsedLengthEstimate;
        private final DateTimeParser[] iParsers;

        MatchingParser(DateTimeParser[] dateTimeParserArr) {
            int i;
            this.iParsers = dateTimeParserArr;
            int i2 = 0;
            int length = dateTimeParserArr.length;
            while (true) {
                int i3 = length - 1;
                if (i3 >= 0) {
                    DateTimeParser dateTimeParser = dateTimeParserArr[i3];
                    if (dateTimeParser == null || (i = dateTimeParser.estimateParsedLength()) <= i2) {
                        i = i2;
                    }
                    i2 = i;
                    length = i3;
                } else {
                    this.iParsedLengthEstimate = i2;
                    return;
                }
            }
        }

        public int estimateParsedLength() {
            return this.iParsedLengthEstimate;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
            r11.restoreState(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            return r0 ^ -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
            if (r4 > r13) goto L_0x001c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
            if (r4 != r13) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
            if (r1 == false) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
            if (r2 == null) goto L_0x0021;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int parseInto(org.joda.time.format.DateTimeParserBucket r11, java.lang.String r12, int r13) {
            /*
                r10 = this;
                r5 = 0
                org.joda.time.format.DateTimeParser[] r7 = r10.iParsers
                int r8 = r7.length
                java.lang.Object r9 = r11.saveState()
                r2 = 0
                r6 = r5
                r0 = r13
                r4 = r13
            L_0x000c:
                if (r6 >= r8) goto L_0x005b
                r1 = r7[r6]
                if (r1 != 0) goto L_0x0023
                if (r4 > r13) goto L_0x0015
            L_0x0014:
                return r13
            L_0x0015:
                r1 = 1
            L_0x0016:
                if (r4 > r13) goto L_0x001c
                if (r4 != r13) goto L_0x0055
                if (r1 == 0) goto L_0x0055
            L_0x001c:
                if (r2 == 0) goto L_0x0021
                r11.restoreState(r2)
            L_0x0021:
                r13 = r4
                goto L_0x0014
            L_0x0023:
                int r3 = r1.parseInto(r11, r12, r13)
                if (r3 < r13) goto L_0x004b
                if (r3 <= r4) goto L_0x0058
                int r1 = r12.length()
                if (r3 >= r1) goto L_0x003b
                int r1 = r6 + 1
                if (r1 >= r8) goto L_0x003b
                int r1 = r6 + 1
                r1 = r7[r1]
                if (r1 != 0) goto L_0x003d
            L_0x003b:
                r13 = r3
                goto L_0x0014
            L_0x003d:
                java.lang.Object r1 = r11.saveState()
                r2 = r3
            L_0x0042:
                r11.restoreState(r9)
                int r3 = r6 + 1
                r6 = r3
                r4 = r2
                r2 = r1
                goto L_0x000c
            L_0x004b:
                if (r3 >= 0) goto L_0x0058
                r1 = r3 ^ -1
                if (r1 <= r0) goto L_0x0058
                r0 = r1
                r1 = r2
                r2 = r4
                goto L_0x0042
            L_0x0055:
                r13 = r0 ^ -1
                goto L_0x0014
            L_0x0058:
                r1 = r2
                r2 = r4
                goto L_0x0042
            L_0x005b:
                r1 = r5
                goto L_0x0016
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.DateTimeFormatterBuilder.MatchingParser.parseInto(org.joda.time.format.DateTimeParserBucket, java.lang.String, int):int");
        }
    }
}
