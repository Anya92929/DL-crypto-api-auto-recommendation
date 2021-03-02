package org.joda.time.format;

import com.google.ads.AdSize;
import com.parse.ParseException;
import com.parse.codec.binary.BaseNCodec;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadablePartial;

public class DateTimeFormat {
    static final int DATE = 0;
    static final int DATETIME = 2;
    static final int FULL = 0;
    static final int LONG = 1;
    static final int MEDIUM = 2;
    static final int NONE = 4;
    static final int SHORT = 3;
    static final int TIME = 1;
    private static final Map<String, DateTimeFormatter> cPatternedCache = new HashMap(7);
    private static final DateTimeFormatter[] cStyleCache = new DateTimeFormatter[25];

    public static DateTimeFormatter forPattern(String str) {
        return createFormatterForPattern(str);
    }

    public static DateTimeFormatter forStyle(String str) {
        return createFormatterForStyle(str);
    }

    public static String patternForStyle(String str, Locale locale) {
        DateTimeFormatter createFormatterForStyle = createFormatterForStyle(str);
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return ((StyleFormatter) createFormatterForStyle.getPrinter()).getPattern(locale);
    }

    public static DateTimeFormatter shortDate() {
        return createFormatterForStyleIndex(3, 4);
    }

    public static DateTimeFormatter shortTime() {
        return createFormatterForStyleIndex(4, 3);
    }

    public static DateTimeFormatter shortDateTime() {
        return createFormatterForStyleIndex(3, 3);
    }

    public static DateTimeFormatter mediumDate() {
        return createFormatterForStyleIndex(2, 4);
    }

    public static DateTimeFormatter mediumTime() {
        return createFormatterForStyleIndex(4, 2);
    }

    public static DateTimeFormatter mediumDateTime() {
        return createFormatterForStyleIndex(2, 2);
    }

    public static DateTimeFormatter longDate() {
        return createFormatterForStyleIndex(1, 4);
    }

    public static DateTimeFormatter longTime() {
        return createFormatterForStyleIndex(4, 1);
    }

    public static DateTimeFormatter longDateTime() {
        return createFormatterForStyleIndex(1, 1);
    }

    public static DateTimeFormatter fullDate() {
        return createFormatterForStyleIndex(0, 4);
    }

    public static DateTimeFormatter fullTime() {
        return createFormatterForStyleIndex(4, 0);
    }

    public static DateTimeFormatter fullDateTime() {
        return createFormatterForStyleIndex(0, 0);
    }

    static void appendPatternTo(DateTimeFormatterBuilder dateTimeFormatterBuilder, String str) {
        parsePatternTo(dateTimeFormatterBuilder, str);
    }

    protected DateTimeFormat() {
    }

    private static void parsePatternTo(DateTimeFormatterBuilder dateTimeFormatterBuilder, String str) {
        int length = str.length();
        int[] iArr = new int[1];
        int i = 0;
        while (i < length) {
            iArr[0] = i;
            String parseToken = parseToken(str, iArr);
            int i2 = iArr[0];
            int length2 = parseToken.length();
            if (length2 != 0) {
                char charAt = parseToken.charAt(0);
                switch (charAt) {
                    case '\'':
                        String substring = parseToken.substring(1);
                        if (substring.length() != 1) {
                            dateTimeFormatterBuilder.appendLiteral(new String(substring));
                            break;
                        } else {
                            dateTimeFormatterBuilder.appendLiteral(substring.charAt(0));
                            break;
                        }
                    case 'C':
                        dateTimeFormatterBuilder.appendCenturyOfEra(length2, length2);
                        break;
                    case 'D':
                        dateTimeFormatterBuilder.appendDayOfYear(length2);
                        break;
                    case 'E':
                        if (length2 < 4) {
                            dateTimeFormatterBuilder.appendDayOfWeekShortText();
                            break;
                        } else {
                            dateTimeFormatterBuilder.appendDayOfWeekText();
                            break;
                        }
                    case 'G':
                        dateTimeFormatterBuilder.appendEraText();
                        break;
                    case 'H':
                        dateTimeFormatterBuilder.appendHourOfDay(length2);
                        break;
                    case 'K':
                        dateTimeFormatterBuilder.appendHourOfHalfday(length2);
                        break;
                    case 'M':
                        if (length2 >= 3) {
                            if (length2 < 4) {
                                dateTimeFormatterBuilder.appendMonthOfYearShortText();
                                break;
                            } else {
                                dateTimeFormatterBuilder.appendMonthOfYearText();
                                break;
                            }
                        } else {
                            dateTimeFormatterBuilder.appendMonthOfYear(length2);
                            break;
                        }
                    case 'S':
                        dateTimeFormatterBuilder.appendFractionOfSecond(length2, length2);
                        break;
                    case 'Y':
                    case ParseException.CACHE_MISS:
                    case ParseException.INVALID_NESTED_KEY:
                        if (length2 != 2) {
                            int i3 = 9;
                            if (i2 + 1 < length) {
                                iArr[0] = iArr[0] + 1;
                                if (isNumericToken(parseToken(str, iArr))) {
                                    i3 = length2;
                                }
                                iArr[0] = iArr[0] - 1;
                            }
                            switch (charAt) {
                                case 'Y':
                                    dateTimeFormatterBuilder.appendYearOfEra(length2, i3);
                                    break;
                                case ParseException.CACHE_MISS:
                                    dateTimeFormatterBuilder.appendWeekyear(length2, i3);
                                    break;
                                case ParseException.INVALID_NESTED_KEY:
                                    dateTimeFormatterBuilder.appendYear(length2, i3);
                                    break;
                            }
                        } else {
                            boolean z = true;
                            if (i2 + 1 < length) {
                                iArr[0] = iArr[0] + 1;
                                if (isNumericToken(parseToken(str, iArr))) {
                                    z = false;
                                }
                                iArr[0] = iArr[0] - 1;
                            }
                            switch (charAt) {
                                case ParseException.CACHE_MISS:
                                    dateTimeFormatterBuilder.appendTwoDigitWeekyear(new DateTime().getWeekyear() - 30, z);
                                    break;
                                default:
                                    dateTimeFormatterBuilder.appendTwoDigitYear(new DateTime().getYear() - 30, z);
                                    break;
                            }
                        }
                    case AdSize.LARGE_AD_HEIGHT:
                        if (length2 != 1) {
                            if (length2 != 2) {
                                dateTimeFormatterBuilder.appendTimeZoneId();
                                break;
                            } else {
                                dateTimeFormatterBuilder.appendTimeZoneOffset((String) null, "Z", true, 2, 2);
                                break;
                            }
                        } else {
                            dateTimeFormatterBuilder.appendTimeZoneOffset((String) null, "Z", false, 2, 2);
                            break;
                        }
                    case 'a':
                        dateTimeFormatterBuilder.appendHalfdayOfDayText();
                        break;
                    case 'd':
                        dateTimeFormatterBuilder.appendDayOfMonth(length2);
                        break;
                    case ParseException.OBJECT_NOT_FOUND:
                        dateTimeFormatterBuilder.appendDayOfWeek(length2);
                        break;
                    case 'h':
                        dateTimeFormatterBuilder.appendClockhourOfHalfday(length2);
                        break;
                    case ParseException.INVALID_JSON:
                        dateTimeFormatterBuilder.appendClockhourOfDay(length2);
                        break;
                    case ParseException.NOT_INITIALIZED:
                        dateTimeFormatterBuilder.appendMinuteOfHour(length2);
                        break;
                    case ParseException.PUSH_MISCONFIGURED:
                        dateTimeFormatterBuilder.appendSecondOfMinute(length2);
                        break;
                    case ParseException.OPERATION_FORBIDDEN:
                        dateTimeFormatterBuilder.appendWeekOfWeekyear(length2);
                        break;
                    case ParseException.INVALID_FILE_NAME:
                        if (length2 < 4) {
                            dateTimeFormatterBuilder.appendTimeZoneShortName((Map<String, DateTimeZone>) null);
                            break;
                        } else {
                            dateTimeFormatterBuilder.appendTimeZoneName();
                            break;
                        }
                    default:
                        throw new IllegalArgumentException("Illegal pattern component: " + parseToken);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0069, code lost:
        r2 = r2 - 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String parseToken(java.lang.String r11, int[] r12) {
        /*
            r10 = 97
            r9 = 90
            r8 = 65
            r7 = 39
            r1 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = r12[r1]
            int r4 = r11.length()
            char r0 = r11.charAt(r2)
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
            char r5 = r11.charAt(r5)
            if (r5 != r0) goto L_0x006b
            r3.append(r0)
            int r2 = r2 + 1
            goto L_0x0025
        L_0x0037:
            r3.append(r7)
            r0 = r1
        L_0x003b:
            if (r2 >= r4) goto L_0x006b
            char r5 = r11.charAt(r2)
            if (r5 != r7) goto L_0x005d
            int r6 = r2 + 1
            if (r6 >= r4) goto L_0x0057
            int r6 = r2 + 1
            char r6 = r11.charAt(r6)
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
            r12[r1] = r2
            java.lang.String r0 = r3.toString()
            return r0
        L_0x0072:
            r3.append(r5)
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.DateTimeFormat.parseToken(java.lang.String, int[]):java.lang.String");
    }

    private static boolean isNumericToken(String str) {
        int length = str.length();
        if (length > 0) {
            switch (str.charAt(0)) {
                case 'C':
                case 'D':
                case 'F':
                case 'H':
                case 'K':
                case 'S':
                case 'W':
                case 'Y':
                case 'c':
                case 'd':
                case ParseException.OBJECT_NOT_FOUND:
                case 'h':
                case ParseException.INVALID_JSON:
                case ParseException.NOT_INITIALIZED:
                case ParseException.PUSH_MISCONFIGURED:
                case ParseException.OPERATION_FORBIDDEN:
                case ParseException.CACHE_MISS:
                case ParseException.INVALID_NESTED_KEY:
                    return true;
                case 'M':
                    if (length <= 2) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    private static DateTimeFormatter createFormatterForPattern(String str) {
        DateTimeFormatter dateTimeFormatter;
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Invalid pattern specification");
        }
        synchronized (cPatternedCache) {
            dateTimeFormatter = cPatternedCache.get(str);
            if (dateTimeFormatter == null) {
                DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
                parsePatternTo(dateTimeFormatterBuilder, str);
                dateTimeFormatter = dateTimeFormatterBuilder.toFormatter();
                cPatternedCache.put(str, dateTimeFormatter);
            }
        }
        return dateTimeFormatter;
    }

    private static DateTimeFormatter createFormatterForStyle(String str) {
        if (str == null || str.length() != 2) {
            throw new IllegalArgumentException("Invalid style specification: " + str);
        }
        int selectStyle = selectStyle(str.charAt(0));
        int selectStyle2 = selectStyle(str.charAt(1));
        if (selectStyle != 4 || selectStyle2 != 4) {
            return createFormatterForStyleIndex(selectStyle, selectStyle2);
        }
        throw new IllegalArgumentException("Style '--' is invalid");
    }

    private static DateTimeFormatter createFormatterForStyleIndex(int i, int i2) {
        DateTimeFormatter dateTimeFormatter;
        int i3 = (i << 2) + i + i2;
        synchronized (cStyleCache) {
            dateTimeFormatter = cStyleCache[i3];
            if (dateTimeFormatter == null) {
                int i4 = 2;
                if (i == 4) {
                    i4 = 1;
                } else if (i2 == 4) {
                    i4 = 0;
                }
                StyleFormatter styleFormatter = new StyleFormatter(i, i2, i4);
                dateTimeFormatter = new DateTimeFormatter(styleFormatter, styleFormatter);
                cStyleCache[i3] = dateTimeFormatter;
            }
        }
        return dateTimeFormatter;
    }

    private static int selectStyle(char c) {
        switch (c) {
            case '-':
                return 4;
            case 'F':
                return 0;
            case BaseNCodec.MIME_CHUNK_SIZE:
                return 1;
            case 'M':
                return 2;
            case 'S':
                return 3;
            default:
                throw new IllegalArgumentException("Invalid style character: " + c);
        }
    }

    static class StyleFormatter implements DateTimePrinter, DateTimeParser {
        private static final Map<String, DateTimeFormatter> cCache = new HashMap();
        private final int iDateStyle;
        private final int iTimeStyle;
        private final int iType;

        StyleFormatter(int i, int i2, int i3) {
            this.iDateStyle = i;
            this.iTimeStyle = i2;
            this.iType = i3;
        }

        public int estimatePrintedLength() {
            return 40;
        }

        public void printTo(StringBuffer stringBuffer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) {
            getFormatter(locale).getPrinter().printTo(stringBuffer, j, chronology, i, dateTimeZone, locale);
        }

        public void printTo(Writer writer, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            getFormatter(locale).getPrinter().printTo(writer, j, chronology, i, dateTimeZone, locale);
        }

        public void printTo(StringBuffer stringBuffer, ReadablePartial readablePartial, Locale locale) {
            getFormatter(locale).getPrinter().printTo(stringBuffer, readablePartial, locale);
        }

        public void printTo(Writer writer, ReadablePartial readablePartial, Locale locale) throws IOException {
            getFormatter(locale).getPrinter().printTo(writer, readablePartial, locale);
        }

        public int estimateParsedLength() {
            return 40;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, String str, int i) {
            return getFormatter(dateTimeParserBucket.getLocale()).getParser().parseInto(dateTimeParserBucket, str, i);
        }

        private DateTimeFormatter getFormatter(Locale locale) {
            DateTimeFormatter dateTimeFormatter;
            if (locale == null) {
                locale = Locale.getDefault();
            }
            String str = Integer.toString(this.iType + (this.iDateStyle << 4) + (this.iTimeStyle << 8)) + locale.toString();
            synchronized (cCache) {
                dateTimeFormatter = cCache.get(str);
                if (dateTimeFormatter == null) {
                    dateTimeFormatter = DateTimeFormat.forPattern(getPattern(locale));
                    cCache.put(str, dateTimeFormatter);
                }
            }
            return dateTimeFormatter;
        }

        /* access modifiers changed from: package-private */
        public String getPattern(Locale locale) {
            DateFormat dateFormat = null;
            switch (this.iType) {
                case 0:
                    dateFormat = DateFormat.getDateInstance(this.iDateStyle, locale);
                    break;
                case 1:
                    dateFormat = DateFormat.getTimeInstance(this.iTimeStyle, locale);
                    break;
                case 2:
                    dateFormat = DateFormat.getDateTimeInstance(this.iDateStyle, this.iTimeStyle, locale);
                    break;
            }
            if (dateFormat instanceof SimpleDateFormat) {
                return ((SimpleDateFormat) dateFormat).toPattern();
            }
            throw new IllegalArgumentException("No datetime pattern for locale: " + locale);
        }
    }
}
