package org.joda.time.format;

import java.util.Collection;
import java.util.HashSet;
import org.joda.time.DateTimeFieldType;

public class ISODateTimeFormat {

    /* renamed from: bd */
    private static DateTimeFormatter f1781bd;
    private static DateTimeFormatter bdt;
    private static DateTimeFormatter bdtx;
    private static DateTimeFormatter bod;
    private static DateTimeFormatter bodt;
    private static DateTimeFormatter bodtx;

    /* renamed from: bt */
    private static DateTimeFormatter f1782bt;
    private static DateTimeFormatter btt;
    private static DateTimeFormatter bttx;
    private static DateTimeFormatter btx;
    private static DateTimeFormatter bwd;
    private static DateTimeFormatter bwdt;
    private static DateTimeFormatter bwdtx;

    /* renamed from: dh */
    private static DateTimeFormatter f1783dh;
    private static DateTimeFormatter dhm;
    private static DateTimeFormatter dhms;
    private static DateTimeFormatter dhmsf;
    private static DateTimeFormatter dhmsl;
    private static DateTimeFormatter dme;
    private static DateTimeFormatter dotp;

    /* renamed from: dp */
    private static DateTimeFormatter f1784dp;
    private static DateTimeFormatter dpe;

    /* renamed from: dt */
    private static DateTimeFormatter f1785dt;
    private static DateTimeFormatter dtp;
    private static DateTimeFormatter dtx;
    private static DateTimeFormatter dwe;
    private static DateTimeFormatter dye;
    private static DateTimeFormatter fse;
    private static DateTimeFormatter hde;

    /* renamed from: hm */
    private static DateTimeFormatter f1786hm;
    private static DateTimeFormatter hms;
    private static DateTimeFormatter hmsf;
    private static DateTimeFormatter hmsl;
    private static DateTimeFormatter ldotp;
    private static DateTimeFormatter ldp;
    private static DateTimeFormatter lte;
    private static DateTimeFormatter ltp;
    private static DateTimeFormatter mhe;
    private static DateTimeFormatter mye;

    /* renamed from: od */
    private static DateTimeFormatter f1787od;
    private static DateTimeFormatter odt;
    private static DateTimeFormatter odtx;
    private static DateTimeFormatter sme;

    /* renamed from: t */
    private static DateTimeFormatter f1788t;

    /* renamed from: tp */
    private static DateTimeFormatter f1789tp;
    private static DateTimeFormatter tpe;

    /* renamed from: tt */
    private static DateTimeFormatter f1790tt;
    private static DateTimeFormatter ttx;

    /* renamed from: tx */
    private static DateTimeFormatter f1791tx;
    private static DateTimeFormatter wdt;
    private static DateTimeFormatter wdtx;

    /* renamed from: we */
    private static DateTimeFormatter f1792we;

    /* renamed from: ww */
    private static DateTimeFormatter f1793ww;
    private static DateTimeFormatter wwd;
    private static DateTimeFormatter wwe;

    /* renamed from: ye */
    private static DateTimeFormatter f1794ye;

    /* renamed from: ym */
    private static DateTimeFormatter f1795ym;
    private static DateTimeFormatter ymd;

    /* renamed from: ze */
    private static DateTimeFormatter f1796ze;

    protected ISODateTimeFormat() {
    }

    public static DateTimeFormatter forFields(Collection<DateTimeFieldType> collection, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException("The fields must not be null or empty");
        }
        HashSet hashSet = new HashSet(collection);
        int size = hashSet.size();
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        if (hashSet.contains(DateTimeFieldType.monthOfYear())) {
            z3 = dateByMonth(dateTimeFormatterBuilder, hashSet, z, z2);
        } else if (hashSet.contains(DateTimeFieldType.dayOfYear())) {
            z3 = dateByOrdinal(dateTimeFormatterBuilder, hashSet, z, z2);
        } else if (hashSet.contains(DateTimeFieldType.weekOfWeekyear())) {
            z3 = dateByWeek(dateTimeFormatterBuilder, hashSet, z, z2);
        } else if (hashSet.contains(DateTimeFieldType.dayOfMonth())) {
            z3 = dateByMonth(dateTimeFormatterBuilder, hashSet, z, z2);
        } else if (hashSet.contains(DateTimeFieldType.dayOfWeek())) {
            z3 = dateByWeek(dateTimeFormatterBuilder, hashSet, z, z2);
        } else if (hashSet.remove(DateTimeFieldType.year())) {
            dateTimeFormatterBuilder.append(yearElement());
            z3 = true;
        } else if (hashSet.remove(DateTimeFieldType.weekyear())) {
            dateTimeFormatterBuilder.append(weekyearElement());
            z3 = true;
        } else {
            z3 = false;
        }
        if (hashSet.size() < size) {
            z4 = true;
        } else {
            z4 = false;
        }
        time(dateTimeFormatterBuilder, hashSet, z, z2, z3, z4);
        if (!dateTimeFormatterBuilder.canBuildFormatter()) {
            throw new IllegalArgumentException("No valid format for fields: " + collection);
        }
        try {
            collection.retainAll(hashSet);
        } catch (UnsupportedOperationException e) {
        }
        return dateTimeFormatterBuilder.toFormatter();
    }

    private static boolean dateByMonth(DateTimeFormatterBuilder dateTimeFormatterBuilder, Collection<DateTimeFieldType> collection, boolean z, boolean z2) {
        if (collection.remove(DateTimeFieldType.year())) {
            dateTimeFormatterBuilder.append(yearElement());
            if (collection.remove(DateTimeFieldType.monthOfYear())) {
                if (collection.remove(DateTimeFieldType.dayOfMonth())) {
                    appendSeparator(dateTimeFormatterBuilder, z);
                    dateTimeFormatterBuilder.appendMonthOfYear(2);
                    appendSeparator(dateTimeFormatterBuilder, z);
                    dateTimeFormatterBuilder.appendDayOfMonth(2);
                    return false;
                }
                dateTimeFormatterBuilder.appendLiteral('-');
                dateTimeFormatterBuilder.appendMonthOfYear(2);
                return true;
            } else if (!collection.remove(DateTimeFieldType.dayOfMonth())) {
                return true;
            } else {
                checkNotStrictISO(collection, z2);
                dateTimeFormatterBuilder.appendLiteral('-');
                dateTimeFormatterBuilder.appendLiteral('-');
                dateTimeFormatterBuilder.appendDayOfMonth(2);
                return false;
            }
        } else if (collection.remove(DateTimeFieldType.monthOfYear())) {
            dateTimeFormatterBuilder.appendLiteral('-');
            dateTimeFormatterBuilder.appendLiteral('-');
            dateTimeFormatterBuilder.appendMonthOfYear(2);
            if (!collection.remove(DateTimeFieldType.dayOfMonth())) {
                return true;
            }
            appendSeparator(dateTimeFormatterBuilder, z);
            dateTimeFormatterBuilder.appendDayOfMonth(2);
            return false;
        } else if (!collection.remove(DateTimeFieldType.dayOfMonth())) {
            return false;
        } else {
            dateTimeFormatterBuilder.appendLiteral('-');
            dateTimeFormatterBuilder.appendLiteral('-');
            dateTimeFormatterBuilder.appendLiteral('-');
            dateTimeFormatterBuilder.appendDayOfMonth(2);
            return false;
        }
    }

    private static boolean dateByOrdinal(DateTimeFormatterBuilder dateTimeFormatterBuilder, Collection<DateTimeFieldType> collection, boolean z, boolean z2) {
        if (collection.remove(DateTimeFieldType.year())) {
            dateTimeFormatterBuilder.append(yearElement());
            if (!collection.remove(DateTimeFieldType.dayOfYear())) {
                return true;
            }
            appendSeparator(dateTimeFormatterBuilder, z);
            dateTimeFormatterBuilder.appendDayOfYear(3);
            return false;
        } else if (!collection.remove(DateTimeFieldType.dayOfYear())) {
            return false;
        } else {
            dateTimeFormatterBuilder.appendLiteral('-');
            dateTimeFormatterBuilder.appendDayOfYear(3);
            return false;
        }
    }

    private static boolean dateByWeek(DateTimeFormatterBuilder dateTimeFormatterBuilder, Collection<DateTimeFieldType> collection, boolean z, boolean z2) {
        if (collection.remove(DateTimeFieldType.weekyear())) {
            dateTimeFormatterBuilder.append(weekyearElement());
            if (collection.remove(DateTimeFieldType.weekOfWeekyear())) {
                appendSeparator(dateTimeFormatterBuilder, z);
                dateTimeFormatterBuilder.appendLiteral('W');
                dateTimeFormatterBuilder.appendWeekOfWeekyear(2);
                if (!collection.remove(DateTimeFieldType.dayOfWeek())) {
                    return true;
                }
                appendSeparator(dateTimeFormatterBuilder, z);
                dateTimeFormatterBuilder.appendDayOfWeek(1);
                return false;
            } else if (!collection.remove(DateTimeFieldType.dayOfWeek())) {
                return true;
            } else {
                checkNotStrictISO(collection, z2);
                appendSeparator(dateTimeFormatterBuilder, z);
                dateTimeFormatterBuilder.appendLiteral('W');
                dateTimeFormatterBuilder.appendLiteral('-');
                dateTimeFormatterBuilder.appendDayOfWeek(1);
                return false;
            }
        } else if (collection.remove(DateTimeFieldType.weekOfWeekyear())) {
            dateTimeFormatterBuilder.appendLiteral('-');
            dateTimeFormatterBuilder.appendLiteral('W');
            dateTimeFormatterBuilder.appendWeekOfWeekyear(2);
            if (!collection.remove(DateTimeFieldType.dayOfWeek())) {
                return true;
            }
            appendSeparator(dateTimeFormatterBuilder, z);
            dateTimeFormatterBuilder.appendDayOfWeek(1);
            return false;
        } else if (!collection.remove(DateTimeFieldType.dayOfWeek())) {
            return false;
        } else {
            dateTimeFormatterBuilder.appendLiteral('-');
            dateTimeFormatterBuilder.appendLiteral('W');
            dateTimeFormatterBuilder.appendLiteral('-');
            dateTimeFormatterBuilder.appendDayOfWeek(1);
            return false;
        }
    }

    private static void time(DateTimeFormatterBuilder dateTimeFormatterBuilder, Collection<DateTimeFieldType> collection, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean remove = collection.remove(DateTimeFieldType.hourOfDay());
        boolean remove2 = collection.remove(DateTimeFieldType.minuteOfHour());
        boolean remove3 = collection.remove(DateTimeFieldType.secondOfMinute());
        boolean remove4 = collection.remove(DateTimeFieldType.millisOfSecond());
        if (remove || remove2 || remove3 || remove4) {
            if (remove || remove2 || remove3 || remove4) {
                if (z2 && z3) {
                    throw new IllegalArgumentException("No valid ISO8601 format for fields because Date was reduced precision: " + collection);
                } else if (z4) {
                    dateTimeFormatterBuilder.appendLiteral('T');
                }
            }
            if ((!remove || !remove2 || !remove3) && (!remove || remove3 || remove4)) {
                if (z2 && z4) {
                    throw new IllegalArgumentException("No valid ISO8601 format for fields because Time was truncated: " + collection);
                } else if ((remove || ((!remove2 || !remove3) && ((!remove2 || remove4) && !remove3))) && z2) {
                    throw new IllegalArgumentException("No valid ISO8601 format for fields: " + collection);
                }
            }
            if (remove) {
                dateTimeFormatterBuilder.appendHourOfDay(2);
            } else if (remove2 || remove3 || remove4) {
                dateTimeFormatterBuilder.appendLiteral('-');
            }
            if (z && remove && remove2) {
                dateTimeFormatterBuilder.appendLiteral(':');
            }
            if (remove2) {
                dateTimeFormatterBuilder.appendMinuteOfHour(2);
            } else if (remove3 || remove4) {
                dateTimeFormatterBuilder.appendLiteral('-');
            }
            if (z && remove2 && remove3) {
                dateTimeFormatterBuilder.appendLiteral(':');
            }
            if (remove3) {
                dateTimeFormatterBuilder.appendSecondOfMinute(2);
            } else if (remove4) {
                dateTimeFormatterBuilder.appendLiteral('-');
            }
            if (remove4) {
                dateTimeFormatterBuilder.appendLiteral('.');
                dateTimeFormatterBuilder.appendMillisOfSecond(3);
            }
        }
    }

    private static void checkNotStrictISO(Collection<DateTimeFieldType> collection, boolean z) {
        if (z) {
            throw new IllegalArgumentException("No valid ISO8601 format for fields: " + collection);
        }
    }

    private static void appendSeparator(DateTimeFormatterBuilder dateTimeFormatterBuilder, boolean z) {
        if (z) {
            dateTimeFormatterBuilder.appendLiteral('-');
        }
    }

    public static DateTimeFormatter dateParser() {
        if (f1784dp == null) {
            f1784dp = new DateTimeFormatterBuilder().append(dateElementParser()).appendOptional(new DateTimeFormatterBuilder().appendLiteral('T').append(offsetElement()).toParser()).toFormatter();
        }
        return f1784dp;
    }

    public static DateTimeFormatter localDateParser() {
        if (ldp == null) {
            ldp = dateElementParser().withZoneUTC();
        }
        return ldp;
    }

    public static DateTimeFormatter dateElementParser() {
        if (dpe == null) {
            dpe = new DateTimeFormatterBuilder().append((DateTimePrinter) null, new DateTimeParser[]{new DateTimeFormatterBuilder().append(yearElement()).appendOptional(new DateTimeFormatterBuilder().append(monthElement()).appendOptional(dayOfMonthElement().getParser()).toParser()).toParser(), new DateTimeFormatterBuilder().append(weekyearElement()).append(weekElement()).appendOptional(dayOfWeekElement().getParser()).toParser(), new DateTimeFormatterBuilder().append(yearElement()).append(dayOfYearElement()).toParser()}).toFormatter();
        }
        return dpe;
    }

    public static DateTimeFormatter timeParser() {
        if (f1789tp == null) {
            f1789tp = new DateTimeFormatterBuilder().appendOptional(literalTElement().getParser()).append(timeElementParser()).appendOptional(offsetElement().getParser()).toFormatter();
        }
        return f1789tp;
    }

    public static DateTimeFormatter localTimeParser() {
        if (ltp == null) {
            ltp = new DateTimeFormatterBuilder().appendOptional(literalTElement().getParser()).append(timeElementParser()).toFormatter().withZoneUTC();
        }
        return ltp;
    }

    public static DateTimeFormatter timeElementParser() {
        if (tpe == null) {
            DateTimeParser parser = new DateTimeFormatterBuilder().append((DateTimePrinter) null, new DateTimeParser[]{new DateTimeFormatterBuilder().appendLiteral('.').toParser(), new DateTimeFormatterBuilder().appendLiteral(',').toParser()}).toParser();
            tpe = new DateTimeFormatterBuilder().append(hourElement()).append((DateTimePrinter) null, new DateTimeParser[]{new DateTimeFormatterBuilder().append(minuteElement()).append((DateTimePrinter) null, new DateTimeParser[]{new DateTimeFormatterBuilder().append(secondElement()).appendOptional(new DateTimeFormatterBuilder().append(parser).appendFractionOfSecond(1, 9).toParser()).toParser(), new DateTimeFormatterBuilder().append(parser).appendFractionOfMinute(1, 9).toParser(), null}).toParser(), new DateTimeFormatterBuilder().append(parser).appendFractionOfHour(1, 9).toParser(), null}).toFormatter();
        }
        return tpe;
    }

    public static DateTimeFormatter dateTimeParser() {
        if (dtp == null) {
            DateTimeParser parser = new DateTimeFormatterBuilder().appendLiteral('T').append(timeElementParser()).appendOptional(offsetElement().getParser()).toParser();
            dtp = new DateTimeFormatterBuilder().append((DateTimePrinter) null, new DateTimeParser[]{parser, dateOptionalTimeParser().getParser()}).toFormatter();
        }
        return dtp;
    }

    public static DateTimeFormatter dateOptionalTimeParser() {
        if (dotp == null) {
            dotp = new DateTimeFormatterBuilder().append(dateElementParser()).appendOptional(new DateTimeFormatterBuilder().appendLiteral('T').appendOptional(timeElementParser().getParser()).appendOptional(offsetElement().getParser()).toParser()).toFormatter();
        }
        return dotp;
    }

    public static DateTimeFormatter localDateOptionalTimeParser() {
        if (ldotp == null) {
            ldotp = new DateTimeFormatterBuilder().append(dateElementParser()).appendOptional(new DateTimeFormatterBuilder().appendLiteral('T').append(timeElementParser()).toParser()).toFormatter().withZoneUTC();
        }
        return ldotp;
    }

    public static DateTimeFormatter date() {
        return yearMonthDay();
    }

    public static DateTimeFormatter time() {
        if (f1788t == null) {
            f1788t = new DateTimeFormatterBuilder().append(hourMinuteSecondFraction()).append(offsetElement()).toFormatter();
        }
        return f1788t;
    }

    public static DateTimeFormatter timeNoMillis() {
        if (f1791tx == null) {
            f1791tx = new DateTimeFormatterBuilder().append(hourMinuteSecond()).append(offsetElement()).toFormatter();
        }
        return f1791tx;
    }

    public static DateTimeFormatter tTime() {
        if (f1790tt == null) {
            f1790tt = new DateTimeFormatterBuilder().append(literalTElement()).append(time()).toFormatter();
        }
        return f1790tt;
    }

    public static DateTimeFormatter tTimeNoMillis() {
        if (ttx == null) {
            ttx = new DateTimeFormatterBuilder().append(literalTElement()).append(timeNoMillis()).toFormatter();
        }
        return ttx;
    }

    public static DateTimeFormatter dateTime() {
        if (f1785dt == null) {
            f1785dt = new DateTimeFormatterBuilder().append(date()).append(tTime()).toFormatter();
        }
        return f1785dt;
    }

    public static DateTimeFormatter dateTimeNoMillis() {
        if (dtx == null) {
            dtx = new DateTimeFormatterBuilder().append(date()).append(tTimeNoMillis()).toFormatter();
        }
        return dtx;
    }

    public static DateTimeFormatter ordinalDate() {
        if (f1787od == null) {
            f1787od = new DateTimeFormatterBuilder().append(yearElement()).append(dayOfYearElement()).toFormatter();
        }
        return f1787od;
    }

    public static DateTimeFormatter ordinalDateTime() {
        if (odt == null) {
            odt = new DateTimeFormatterBuilder().append(ordinalDate()).append(tTime()).toFormatter();
        }
        return odt;
    }

    public static DateTimeFormatter ordinalDateTimeNoMillis() {
        if (odtx == null) {
            odtx = new DateTimeFormatterBuilder().append(ordinalDate()).append(tTimeNoMillis()).toFormatter();
        }
        return odtx;
    }

    public static DateTimeFormatter weekDate() {
        return weekyearWeekDay();
    }

    public static DateTimeFormatter weekDateTime() {
        if (wdt == null) {
            wdt = new DateTimeFormatterBuilder().append(weekDate()).append(tTime()).toFormatter();
        }
        return wdt;
    }

    public static DateTimeFormatter weekDateTimeNoMillis() {
        if (wdtx == null) {
            wdtx = new DateTimeFormatterBuilder().append(weekDate()).append(tTimeNoMillis()).toFormatter();
        }
        return wdtx;
    }

    public static DateTimeFormatter basicDate() {
        if (f1781bd == null) {
            f1781bd = new DateTimeFormatterBuilder().appendYear(4, 4).appendFixedDecimal(DateTimeFieldType.monthOfYear(), 2).appendFixedDecimal(DateTimeFieldType.dayOfMonth(), 2).toFormatter();
        }
        return f1781bd;
    }

    public static DateTimeFormatter basicTime() {
        if (f1782bt == null) {
            f1782bt = new DateTimeFormatterBuilder().appendFixedDecimal(DateTimeFieldType.hourOfDay(), 2).appendFixedDecimal(DateTimeFieldType.minuteOfHour(), 2).appendFixedDecimal(DateTimeFieldType.secondOfMinute(), 2).appendLiteral('.').appendFractionOfSecond(3, 9).appendTimeZoneOffset("Z", false, 2, 2).toFormatter();
        }
        return f1782bt;
    }

    public static DateTimeFormatter basicTimeNoMillis() {
        if (btx == null) {
            btx = new DateTimeFormatterBuilder().appendFixedDecimal(DateTimeFieldType.hourOfDay(), 2).appendFixedDecimal(DateTimeFieldType.minuteOfHour(), 2).appendFixedDecimal(DateTimeFieldType.secondOfMinute(), 2).appendTimeZoneOffset("Z", false, 2, 2).toFormatter();
        }
        return btx;
    }

    public static DateTimeFormatter basicTTime() {
        if (btt == null) {
            btt = new DateTimeFormatterBuilder().append(literalTElement()).append(basicTime()).toFormatter();
        }
        return btt;
    }

    public static DateTimeFormatter basicTTimeNoMillis() {
        if (bttx == null) {
            bttx = new DateTimeFormatterBuilder().append(literalTElement()).append(basicTimeNoMillis()).toFormatter();
        }
        return bttx;
    }

    public static DateTimeFormatter basicDateTime() {
        if (bdt == null) {
            bdt = new DateTimeFormatterBuilder().append(basicDate()).append(basicTTime()).toFormatter();
        }
        return bdt;
    }

    public static DateTimeFormatter basicDateTimeNoMillis() {
        if (bdtx == null) {
            bdtx = new DateTimeFormatterBuilder().append(basicDate()).append(basicTTimeNoMillis()).toFormatter();
        }
        return bdtx;
    }

    public static DateTimeFormatter basicOrdinalDate() {
        if (bod == null) {
            bod = new DateTimeFormatterBuilder().appendYear(4, 4).appendFixedDecimal(DateTimeFieldType.dayOfYear(), 3).toFormatter();
        }
        return bod;
    }

    public static DateTimeFormatter basicOrdinalDateTime() {
        if (bodt == null) {
            bodt = new DateTimeFormatterBuilder().append(basicOrdinalDate()).append(basicTTime()).toFormatter();
        }
        return bodt;
    }

    public static DateTimeFormatter basicOrdinalDateTimeNoMillis() {
        if (bodtx == null) {
            bodtx = new DateTimeFormatterBuilder().append(basicOrdinalDate()).append(basicTTimeNoMillis()).toFormatter();
        }
        return bodtx;
    }

    public static DateTimeFormatter basicWeekDate() {
        if (bwd == null) {
            bwd = new DateTimeFormatterBuilder().appendWeekyear(4, 4).appendLiteral('W').appendFixedDecimal(DateTimeFieldType.weekOfWeekyear(), 2).appendFixedDecimal(DateTimeFieldType.dayOfWeek(), 1).toFormatter();
        }
        return bwd;
    }

    public static DateTimeFormatter basicWeekDateTime() {
        if (bwdt == null) {
            bwdt = new DateTimeFormatterBuilder().append(basicWeekDate()).append(basicTTime()).toFormatter();
        }
        return bwdt;
    }

    public static DateTimeFormatter basicWeekDateTimeNoMillis() {
        if (bwdtx == null) {
            bwdtx = new DateTimeFormatterBuilder().append(basicWeekDate()).append(basicTTimeNoMillis()).toFormatter();
        }
        return bwdtx;
    }

    public static DateTimeFormatter year() {
        return yearElement();
    }

    public static DateTimeFormatter yearMonth() {
        if (f1795ym == null) {
            f1795ym = new DateTimeFormatterBuilder().append(yearElement()).append(monthElement()).toFormatter();
        }
        return f1795ym;
    }

    public static DateTimeFormatter yearMonthDay() {
        if (ymd == null) {
            ymd = new DateTimeFormatterBuilder().append(yearElement()).append(monthElement()).append(dayOfMonthElement()).toFormatter();
        }
        return ymd;
    }

    public static DateTimeFormatter weekyear() {
        return weekyearElement();
    }

    public static DateTimeFormatter weekyearWeek() {
        if (f1793ww == null) {
            f1793ww = new DateTimeFormatterBuilder().append(weekyearElement()).append(weekElement()).toFormatter();
        }
        return f1793ww;
    }

    public static DateTimeFormatter weekyearWeekDay() {
        if (wwd == null) {
            wwd = new DateTimeFormatterBuilder().append(weekyearElement()).append(weekElement()).append(dayOfWeekElement()).toFormatter();
        }
        return wwd;
    }

    public static DateTimeFormatter hour() {
        return hourElement();
    }

    public static DateTimeFormatter hourMinute() {
        if (f1786hm == null) {
            f1786hm = new DateTimeFormatterBuilder().append(hourElement()).append(minuteElement()).toFormatter();
        }
        return f1786hm;
    }

    public static DateTimeFormatter hourMinuteSecond() {
        if (hms == null) {
            hms = new DateTimeFormatterBuilder().append(hourElement()).append(minuteElement()).append(secondElement()).toFormatter();
        }
        return hms;
    }

    public static DateTimeFormatter hourMinuteSecondMillis() {
        if (hmsl == null) {
            hmsl = new DateTimeFormatterBuilder().append(hourElement()).append(minuteElement()).append(secondElement()).appendLiteral('.').appendFractionOfSecond(3, 3).toFormatter();
        }
        return hmsl;
    }

    public static DateTimeFormatter hourMinuteSecondFraction() {
        if (hmsf == null) {
            hmsf = new DateTimeFormatterBuilder().append(hourElement()).append(minuteElement()).append(secondElement()).append(fractionElement()).toFormatter();
        }
        return hmsf;
    }

    public static DateTimeFormatter dateHour() {
        if (f1783dh == null) {
            f1783dh = new DateTimeFormatterBuilder().append(date()).append(literalTElement()).append(hour()).toFormatter();
        }
        return f1783dh;
    }

    public static DateTimeFormatter dateHourMinute() {
        if (dhm == null) {
            dhm = new DateTimeFormatterBuilder().append(date()).append(literalTElement()).append(hourMinute()).toFormatter();
        }
        return dhm;
    }

    public static DateTimeFormatter dateHourMinuteSecond() {
        if (dhms == null) {
            dhms = new DateTimeFormatterBuilder().append(date()).append(literalTElement()).append(hourMinuteSecond()).toFormatter();
        }
        return dhms;
    }

    public static DateTimeFormatter dateHourMinuteSecondMillis() {
        if (dhmsl == null) {
            dhmsl = new DateTimeFormatterBuilder().append(date()).append(literalTElement()).append(hourMinuteSecondMillis()).toFormatter();
        }
        return dhmsl;
    }

    public static DateTimeFormatter dateHourMinuteSecondFraction() {
        if (dhmsf == null) {
            dhmsf = new DateTimeFormatterBuilder().append(date()).append(literalTElement()).append(hourMinuteSecondFraction()).toFormatter();
        }
        return dhmsf;
    }

    private static DateTimeFormatter yearElement() {
        if (f1794ye == null) {
            f1794ye = new DateTimeFormatterBuilder().appendYear(4, 9).toFormatter();
        }
        return f1794ye;
    }

    private static DateTimeFormatter monthElement() {
        if (mye == null) {
            mye = new DateTimeFormatterBuilder().appendLiteral('-').appendMonthOfYear(2).toFormatter();
        }
        return mye;
    }

    private static DateTimeFormatter dayOfMonthElement() {
        if (dme == null) {
            dme = new DateTimeFormatterBuilder().appendLiteral('-').appendDayOfMonth(2).toFormatter();
        }
        return dme;
    }

    private static DateTimeFormatter weekyearElement() {
        if (f1792we == null) {
            f1792we = new DateTimeFormatterBuilder().appendWeekyear(4, 9).toFormatter();
        }
        return f1792we;
    }

    private static DateTimeFormatter weekElement() {
        if (wwe == null) {
            wwe = new DateTimeFormatterBuilder().appendLiteral("-W").appendWeekOfWeekyear(2).toFormatter();
        }
        return wwe;
    }

    private static DateTimeFormatter dayOfWeekElement() {
        if (dwe == null) {
            dwe = new DateTimeFormatterBuilder().appendLiteral('-').appendDayOfWeek(1).toFormatter();
        }
        return dwe;
    }

    private static DateTimeFormatter dayOfYearElement() {
        if (dye == null) {
            dye = new DateTimeFormatterBuilder().appendLiteral('-').appendDayOfYear(3).toFormatter();
        }
        return dye;
    }

    private static DateTimeFormatter literalTElement() {
        if (lte == null) {
            lte = new DateTimeFormatterBuilder().appendLiteral('T').toFormatter();
        }
        return lte;
    }

    private static DateTimeFormatter hourElement() {
        if (hde == null) {
            hde = new DateTimeFormatterBuilder().appendHourOfDay(2).toFormatter();
        }
        return hde;
    }

    private static DateTimeFormatter minuteElement() {
        if (mhe == null) {
            mhe = new DateTimeFormatterBuilder().appendLiteral(':').appendMinuteOfHour(2).toFormatter();
        }
        return mhe;
    }

    private static DateTimeFormatter secondElement() {
        if (sme == null) {
            sme = new DateTimeFormatterBuilder().appendLiteral(':').appendSecondOfMinute(2).toFormatter();
        }
        return sme;
    }

    private static DateTimeFormatter fractionElement() {
        if (fse == null) {
            fse = new DateTimeFormatterBuilder().appendLiteral('.').appendFractionOfSecond(3, 9).toFormatter();
        }
        return fse;
    }

    private static DateTimeFormatter offsetElement() {
        if (f1796ze == null) {
            f1796ze = new DateTimeFormatterBuilder().appendTimeZoneOffset("Z", true, 2, 4).toFormatter();
        }
        return f1796ze;
    }
}
